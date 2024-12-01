package com.br.pessoas.app.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@Cacheable
public class RedisConfig {
	@Bean
	public <T> RedisTemplate<String, T> redisTemplate(@Autowired LettuceConnectionFactory lettuceConnectionFactory) {
		RedisTemplate<String, T> template = new RedisTemplate<>();
		template.setConnectionFactory(lettuceConnectionFactory);

		StringRedisSerializer keySerializer = new StringRedisSerializer();
		RedisSerializer<Object> valueSerializer = RedisSerializer.json();

		template.setKeySerializer(keySerializer);
		template.setValueSerializer(valueSerializer);

		template.setHashKeySerializer(keySerializer);
		template.setHashValueSerializer(valueSerializer);

		template.afterPropertiesSet();
		return template;
	}

	@Bean
	public RedisCacheManager redisCacheManager(RedisConnectionFactory factory) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

		RedisSerializer<Object> serializer = new GenericJackson2JsonRedisSerializer(objectMapper);

		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
				.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer))
				.entryTtl(Duration.ofMinutes(1));

		return RedisCacheManager.builder(factory)
				.cacheDefaults(config)
				.build();
	}
}

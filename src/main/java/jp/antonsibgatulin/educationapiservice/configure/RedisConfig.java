package jp.antonsibgatulin.educationapiservice.configure;

import jp.antonsibgatulin.educationapiservice.service.redis.MessagePublisher;
import jp.antonsibgatulin.educationapiservice.service.redis.MessagerPublisherImpl;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@EnableCaching
@Configuration
public class RedisConfig {

    // Bean definition for JedisConnectionFactory
    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("localhost");
        config.setPort(6379);
        return new JedisConnectionFactory(config);
    }

    // Bean definition for RedisTemplate
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        var redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    // Bean definition for MessagePublisher
    @Bean
    public MessagePublisher messagePublisher() {
        return new MessagerPublisherImpl(redisTemplate(jedisConnectionFactory()));
    }

}
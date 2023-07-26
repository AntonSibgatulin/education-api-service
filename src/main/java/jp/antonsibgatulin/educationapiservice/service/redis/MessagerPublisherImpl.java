package jp.antonsibgatulin.educationapiservice.service.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service
public
class MessagerPublisherImpl implements MessagePublisher {

    private final RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String, String> valueOperations;

    // Constructor injection of RedisTemplate
    public MessagerPublisherImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        valueOperations = redisTemplate.opsForValue();
    }

    // Implementation of the save() method from the MessagePublisher interface
    @Override
    public void save(String key, String value) {
        valueOperations.set(key, value);
    }

    // Implementation of the delete() method from the MessagePublisher interface
    @Override
    public void delete(String key) {
        valueOperations.getAndDelete(key);
    }

    // Implementation of the get() method from the MessagePublisher interface
    @Override
    public String get(String key) {
        return valueOperations.get(key);
    }
}
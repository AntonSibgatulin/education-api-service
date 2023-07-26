package jp.antonsibgatulin.educationapiservice.service.redis;

public interface MessagePublisher {
    public void save(String key,String value);
    public void delete(String key);
    public String get(String key);
}

package me.eae.urls.common.conf;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

/**
 * @author 郝家雨
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/4/216:53
 */
public class LongRedisSerializer implements RedisSerializer<Long> {

    private StringRedisSerializer stringSerializer = new StringRedisSerializer();

    @Override
    public byte[] serialize(@Nullable Long aLong) throws SerializationException {
        return stringSerializer.serialize(aLong.toString());

    }

    @Override
    public Long deserialize(@Nullable byte[] bytes) throws SerializationException {
        return Long.parseLong(stringSerializer.deserialize(bytes));
    }
}

package me.eae.urls.idGenerator;

import me.eae.urls.common.conf.LongRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisSetCommands;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * Created by haojy on 2018/3/30.
 */
@Service
@PropertySource("classpath:application.properties")
public class RedisIdGenerator implements IdGenerator{


    private RedisTemplate <String,String> redisTemplate;

    private BoundHashOperations <String,String,Long> hashOperations;
    /**
     * 默认步长，为100
     */
    private  final Integer  STEP_SIZE = 1024;
    private String idKey = "shortUrl";

    /**
     * 储存自增主键的key值
     */
    private static final String LOCAL_KEY= "me.eae.urls.idGenerator_key";

    /**
     * 系统初始化时起始值
     */
    private Long startNum ;

    @Override
    public Long next() {
        hashOperations = redisTemplate.boundHashOps(LOCAL_KEY);
        return hashOperations.increment(idKey,STEP_SIZE);
    }

    @Override
    public void init(){
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        LongRedisSerializer longRedisSerializer = new LongRedisSerializer();
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(longRedisSerializer);
        hashOperations = redisTemplate.boundHashOps(LOCAL_KEY);
        if(!hashOperations.hasKey(idKey)){
            hashOperations.put(idKey,startNum);
        }
        redisTemplate.setHashKeySerializer(stringSerializer);
        System.out.println(hashOperations.get(idKey));
    }


    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Value("${me.eae.urls.idGenerator.RedisIdGenerator.startNum}")
    public void setStartNum(Long startNum) {
        if(startNum<0||startNum>STEP_SIZE){
            throw new RuntimeException("me.eae.urls.idGenerator.RedisIdGenerator.startNum 参数设置非法，取值应在1-1024之间");
        }
        this.startNum = startNum;
    }
}

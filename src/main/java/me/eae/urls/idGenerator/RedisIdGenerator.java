package me.eae.urls.idGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by haojy on 2018/3/30.
 */
@Service
public class RedisIdGenerator implements IdGenerator{


    private RedisTemplate redisTemplate;

    private BoundHashOperations hashOperations;
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
    private Integer defaultNum = 1;

    @Override
    public Long next() {
        hashOperations = redisTemplate.boundHashOps(LOCAL_KEY);
        return hashOperations.increment(idKey,STEP_SIZE);
    }
    public RedisIdGenerator(){
        //init();
    }




    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}

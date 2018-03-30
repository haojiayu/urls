package me.eae.urls.dao.url;

import me.eae.urls.modle.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/3014:25
 */
@Repository
public class UrlDaoImpl implements UrlDao{

    private StringRedisTemplate stringRedisTemplate;
    private HashOperations hashOperations;
    private String key = "me.eae.urls.dao.url";
    @Override
    public void saveUrl(Url url) {
        hashOperations.put(key,url.getId(),url.getUrl());
    }

    @Override
    public Url getUrl(String id) {
        String url ;
        Object object = hashOperations.get(key,id);
        if (object==null){
            return null;
        }
        url = (String) object;
        Url u = new Url();
        u.setId(id);
        u.setUrl(url);
        return u;
    }

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        hashOperations = this.stringRedisTemplate.opsForHash();
    }
}

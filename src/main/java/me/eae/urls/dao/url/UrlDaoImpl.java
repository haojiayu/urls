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
    private String key_md5 = "me.eae.urls.dao.url_dm5";
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

    @Override
    public String getSurl(String md5) {
        Object object = hashOperations.get(key_md5,md5);
        if (object==null){
            return null;
        }
        return (String )object;
    }

    @Override
    public void saveSurl(String md5,String id) {
        hashOperations.put(key_md5,md5,id);
    }

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        hashOperations = this.stringRedisTemplate.opsForHash();
    }
}

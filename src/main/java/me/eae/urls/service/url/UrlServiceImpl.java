package me.eae.urls.service.url;

import me.eae.urls.common.utils.NumUtils;
import me.eae.urls.dao.url.UrlDao;
import me.eae.urls.idGenerator.RedisIdGenerator;
import me.eae.urls.modle.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/3014:51
 */
@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    RedisIdGenerator redisIdGenerator;

    @Autowired
    UrlDao urlDao;

    @Override
    public Url getUrl(String id) {
        return urlDao.getUrl(id);
    }

    @Override
    public String saveUrl(Url url) {
        Long l = redisIdGenerator.next();
        String id = NumUtils.long2String(l);
        url.setId(id);
        urlDao.saveUrl(url);
        return id;
    }
}

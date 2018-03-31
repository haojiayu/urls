package me.eae.urls.service.url;

import me.eae.urls.common.utils.NumUtils;
import me.eae.urls.common.utils.StringUtils;
import me.eae.urls.dao.url.UrlDao;
import me.eae.urls.idGenerator.RedisIdGenerator;
import me.eae.urls.modle.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
        String lUrl = url.getUrl();
        if(!lUrl.startsWith("http://")&&!lUrl.startsWith("https://")){
            url.setUrl("http://"+lUrl);
        }
        /**
         * 计算url的md5
         */
        String md5 = StringUtils.EncoderByMd5(url.getUrl());
        //判断该md5是否已经存在
        String sUrl = urlDao.getSurl(md5);

        if(sUrl!=null){
            Url lurl = urlDao.getUrl(sUrl);
            if(lurl!=null&&lurl.getUrl().equals(url.getUrl())){
                return sUrl;
            }
        }
        Long l = redisIdGenerator.next();
        String id = NumUtils.long2String(l);
        url.setId(id);
        urlDao.saveUrl(url);
        urlDao.saveSurl(md5,id);
        return id;
    }
}

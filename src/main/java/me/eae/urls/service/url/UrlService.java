package me.eae.urls.service.url;

import me.eae.urls.modle.Url;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/3014:50
 */
public interface UrlService {

    Url getUrl(String id);
    String saveUrl(Url url);

}

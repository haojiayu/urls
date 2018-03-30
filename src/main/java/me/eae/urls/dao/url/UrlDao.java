package me.eae.urls.dao.url;

import me.eae.urls.modle.Url;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/3014:23
 */
public interface UrlDao {

    void saveUrl(Url url);

    Url getUrl(String id);

}

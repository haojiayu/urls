package me.eae.urls.modle;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/3014:52
 */
public class Url {

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id:"+ id)
                .append("url:"+ url)
                .toString();
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

}

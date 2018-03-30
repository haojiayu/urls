package me.eae.urls.service.url;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/3015:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlServiceImplTest {
    @Autowired
    UrlService urlService;
    @Test
    public void getUrl() throws Exception {
        System.out.println(urlService.getUrl("123"));
    }

    @Test
    public void saveUrl() throws Exception {
    }

}
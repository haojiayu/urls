package me.eae.urls.idGenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/3010:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisIdGeneratorTest {
    @Autowired
    private RedisIdGenerator idGenerator;
    @Test
    public void next() throws Exception {
        System.out.println(idGenerator.next());
    }

}
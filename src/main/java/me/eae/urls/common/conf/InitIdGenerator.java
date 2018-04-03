package me.eae.urls.common.conf;

import me.eae.urls.idGenerator.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/4/215:54
 */
@Component
public class InitIdGenerator implements ApplicationRunner {
    @Autowired
    IdGenerator idGenerator;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("init");
        idGenerator.init();
    }
}

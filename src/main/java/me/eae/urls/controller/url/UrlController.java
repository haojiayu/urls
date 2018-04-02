package me.eae.urls.controller.url;

import me.eae.urls.modle.Result;
import me.eae.urls.modle.Url;
import me.eae.urls.service.url.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/3015:22
 */
@Controller
@RequestMapping("/")
public class UrlController {
    @Autowired
    UrlService urlService;
    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/{id}")
    public String redirect(@PathVariable("id") String id) {
        Url u = urlService.getUrl(id);
        if(u==null){
            return "/404";
        }
        return "redirect:"+u.getUrl();
    }

    @PostMapping("/getShortUrl")
    @ResponseBody
    public Result getShortUrl(Url url){

        String urls = urlService.saveUrl(url);
        return Result.OK(urls);
    }

}

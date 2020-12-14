package club.tacbin.patch.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tacbin
 * @date 2020/11/26 17:10
 * @description
 */
@RestController
@RequestMapping("/patch")
public class PatchAjaxUrl {

    Map<String, Object> urlMap = new ConcurrentHashMap<>();
    AtomicInteger count = new AtomicInteger();

    @PostMapping("/fromWeb")
    public void getFromWeb(String url) {
        System.out.println("请求时间: " + System.nanoTime() + " url: " + url);
        url = url.split("\\?")[0];
        urlMap.put(url, new Object());
        count.addAndGet(1);
    }

    @GetMapping("/toWeb")
    public List<String> output() {
        List<String> urls = new ArrayList<>();
        for (String url : urlMap.keySet()) {
            urls.add(url);
        }
        return urls;
    }

    @GetMapping("/reset")
    public List<String> reset() {
        urlMap = new ConcurrentHashMap<>();
        List<String> urls = new ArrayList<>();
        for (String url : urlMap.keySet()) {
            urls.add(url);
        }
        return urls;
    }
}

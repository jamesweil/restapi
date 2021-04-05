package com.jameswei.springboot.restapi.web;

import com.jameswei.springboot.restapi.entity.Weblogs;
import com.jameswei.springboot.restapi.service.WeblogsService;
import com.jameswei.springboot.restapi.util.WebLogsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/weblog")
public class WeblogsController {

    private WeblogsService weblogsService;

    @Autowired
    private void setWeblogsService(WeblogsService weblogsService) {
        this.weblogsService = weblogsService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list() {
        Map<String, Object> data = new HashMap<>();
        data.put("data", weblogsService.findAll());
        return data;
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Map<String, Object> findById(
            @RequestParam(value = "id") String id) {
        Map<String, Object> data = new HashMap<>();
        Weblogs weblogs = weblogsService.findById(id);
        if(StringUtils.isEmpty(weblogs)) {
            data.put("data", "数据查找失败！");
        } else {
            data.put("data", weblogs);
        }

        return data;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(
            @RequestParam(value = "content") String content,
            HttpServletRequest request) {
        Weblogs weblogs = new Weblogs();
        weblogs.setContent(content);
        weblogs.setIpaddr(WebLogsUtil.getIpAddr(request));
        weblogs.setCreatetime(new Timestamp(System.currentTimeMillis()));

        boolean result = weblogsService.add(weblogs);
        Map<String, Object> data = new HashMap<>();
        if(result) {
            data.put("data", weblogs);
        } else {
            data.put("data", "数据插入失败！");
        }

        return data;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Map<String, Object> update(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "content") String content) {
        Map<String, Object> data = new HashMap<>();
        Weblogs weblogs = weblogsService.findById(id);

        if(StringUtils.isEmpty(weblogs)) {
            data.put("data", "数据查找失败！");
            return data;
        }

        weblogs.setContent(content);
        weblogs.setUpdatetime(new Timestamp(System.currentTimeMillis()));

        boolean result = weblogsService.update(weblogs);
        if(result) {
            data.put("data", weblogs);
        } else {
            data.put("data", "数据更新失败！");
        }

        return data;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestParam(value = "id") String id) {

        boolean result = weblogsService.delete(id);
        Map<String, Object> data = new HashMap<>();
        if(result) {
            data.put("data", "数据删除成功！");
        } else {
            data.put("data", "数据删除失败！");
        }

        return data;
    }
}

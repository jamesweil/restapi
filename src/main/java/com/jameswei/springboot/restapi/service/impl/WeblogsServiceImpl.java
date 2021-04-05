package com.jameswei.springboot.restapi.service.impl;

import com.jameswei.springboot.restapi.dao.WeblogsDao;
import com.jameswei.springboot.restapi.entity.Weblogs;
import com.jameswei.springboot.restapi.service.WeblogsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WeblogsServiceImpl implements WeblogsService {

    private final WeblogsDao weblogsDao;

    @Autowired
    public WeblogsServiceImpl(WeblogsDao weblogsDao) {
        this.weblogsDao = weblogsDao;
    }

    @Override
    public List<Weblogs> findAll() {
        return weblogsDao.selectList(null);
    }

    @Override
    public Weblogs findById(String id) {
        return weblogsDao.selectById(id);
    }

    @Override
    public boolean add(Weblogs weblogs) {
        boolean result = false;
        try {
            weblogsDao.insert(weblogs);
            result = true;
        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return result;
    }

    @Override
    public boolean update(Weblogs weblogs) {
        boolean result = false;
        try {
            weblogsDao.updateById(weblogs);
            result = true;
        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try {
            weblogsDao.deleteById(id);
            result = true;
        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return result;
    }
}

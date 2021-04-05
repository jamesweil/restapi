package com.jameswei.springboot.restapi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jameswei.springboot.restapi.entity.Weblogs;
import org.springframework.stereotype.Repository;

@Repository
public interface WeblogsDao extends BaseMapper<Weblogs> {
}

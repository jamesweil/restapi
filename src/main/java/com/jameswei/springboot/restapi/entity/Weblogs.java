package com.jameswei.springboot.restapi.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Weblogs implements Serializable {
  private long id;
  private String content;
  private String ipaddr;
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp updatetime;
}

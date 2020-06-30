package com.jiladahe1997.embeddedproxy.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

public class Announcement {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8600739+08:00", comments="Source field: test_embeddedproxy..announcement.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8630725+08:00", comments="Source field: test_embeddedproxy..announcement.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8630725+08:00", comments="Source field: test_embeddedproxy..announcement.content")
    private String content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8630725+08:00", comments="Source field: test_embeddedproxy..announcement.type")
    private String type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8640874+08:00", comments="Source field: test_embeddedproxy..announcement.time")
    private Date time;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8640874+08:00", comments="Source field: test_embeddedproxy..announcement.views")
    private Integer views;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8620729+08:00", comments="Source field: test_embeddedproxy..announcement.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8630725+08:00", comments="Source field: test_embeddedproxy..announcement.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8630725+08:00", comments="Source field: test_embeddedproxy..announcement.title")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8630725+08:00", comments="Source field: test_embeddedproxy..announcement.title")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8630725+08:00", comments="Source field: test_embeddedproxy..announcement.content")
    public String getContent() {
        return content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8630725+08:00", comments="Source field: test_embeddedproxy..announcement.content")
    public void setContent(String content) {
        this.content = content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8630725+08:00", comments="Source field: test_embeddedproxy..announcement.type")
    public String getType() {
        return type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8640874+08:00", comments="Source field: test_embeddedproxy..announcement.type")
    public void setType(String type) {
        this.type = type;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8640874+08:00", comments="Source field: test_embeddedproxy..announcement.time")
    public Date getTime() {
        return time;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8640874+08:00", comments="Source field: test_embeddedproxy..announcement.time")
    public void setTime(Date time) {
        this.time = time;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8640874+08:00", comments="Source field: test_embeddedproxy..announcement.views")
    public Integer getViews() {
        return views;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8640874+08:00", comments="Source field: test_embeddedproxy..announcement.views")
    public void setViews(Integer views) {
        this.views = views;
    }
}
package com.jiladahe1997.embeddedproxy.example.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AnnouncementDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8680847+08:00", comments="Source Table: test_embeddedproxy..announcement")
    public static final Announcement announcement = new Announcement();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8680847+08:00", comments="Source field: test_embeddedproxy..announcement.id")
    public static final SqlColumn<Integer> id = announcement.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8690842+08:00", comments="Source field: test_embeddedproxy..announcement.title")
    public static final SqlColumn<String> title = announcement.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8690842+08:00", comments="Source field: test_embeddedproxy..announcement.content")
    public static final SqlColumn<String> content = announcement.content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8690842+08:00", comments="Source field: test_embeddedproxy..announcement.type")
    public static final SqlColumn<String> type = announcement.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8690842+08:00", comments="Source field: test_embeddedproxy..announcement.time")
    public static final SqlColumn<Date> time = announcement.time;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8690842+08:00", comments="Source field: test_embeddedproxy..announcement.views")
    public static final SqlColumn<Integer> views = announcement.views;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8680847+08:00", comments="Source Table: test_embeddedproxy..announcement")
    public static final class Announcement extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> content = column("content", JDBCType.VARCHAR);

        public final SqlColumn<String> type = column("type", JDBCType.VARCHAR);

        public final SqlColumn<Date> time = column("time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> views = column("views", JDBCType.INTEGER);

        public Announcement() {
            super("test_embeddedproxy.announcement");
        }
    }
}
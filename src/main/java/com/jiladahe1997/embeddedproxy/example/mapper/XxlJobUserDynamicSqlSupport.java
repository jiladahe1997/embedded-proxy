package com.jiladahe1997.embeddedproxy.example.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class XxlJobUserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7576253+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    public static final XxlJobUser xxlJobUser = new XxlJobUser();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7586248+08:00", comments="Source field: test_embeddedproxy..xxl_job_user.id")
    public static final SqlColumn<Integer> id = xxlJobUser.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7586248+08:00", comments="Source field: test_embeddedproxy..xxl_job_user.username")
    public static final SqlColumn<String> username = xxlJobUser.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7586248+08:00", comments="Source field: test_embeddedproxy..xxl_job_user.password")
    public static final SqlColumn<String> password = xxlJobUser.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7586248+08:00", comments="Source field: test_embeddedproxy..xxl_job_user.role")
    public static final SqlColumn<Byte> role = xxlJobUser.role;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7596247+08:00", comments="Source field: test_embeddedproxy..xxl_job_user.permission")
    public static final SqlColumn<String> permission = xxlJobUser.permission;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7586248+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    public static final class XxlJobUser extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<Byte> role = column("role", JDBCType.TINYINT);

        public final SqlColumn<String> permission = column("permission", JDBCType.VARCHAR);

        public XxlJobUser() {
            super("test_embeddedproxy..xxl_job_user");
        }
    }
}
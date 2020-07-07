package com.jiladahe1997.embeddedproxy.example.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class XxlJobLogDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7816095+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    public static final XxlJobLog xxlJobLog = new XxlJobLog();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7816095+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.id")
    public static final SqlColumn<Long> id = xxlJobLog.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7816095+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.job_group")
    public static final SqlColumn<Integer> jobGroup = xxlJobLog.jobGroup;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7826099+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.job_id")
    public static final SqlColumn<Integer> jobId = xxlJobLog.jobId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7826099+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.executor_address")
    public static final SqlColumn<String> executorAddress = xxlJobLog.executorAddress;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7826099+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.executor_handler")
    public static final SqlColumn<String> executorHandler = xxlJobLog.executorHandler;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7826099+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.executor_param")
    public static final SqlColumn<String> executorParam = xxlJobLog.executorParam;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7826099+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.executor_sharding_param")
    public static final SqlColumn<String> executorShardingParam = xxlJobLog.executorShardingParam;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7826099+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.executor_fail_retry_count")
    public static final SqlColumn<Integer> executorFailRetryCount = xxlJobLog.executorFailRetryCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7826099+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.trigger_time")
    public static final SqlColumn<Date> triggerTime = xxlJobLog.triggerTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7826099+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.trigger_code")
    public static final SqlColumn<Integer> triggerCode = xxlJobLog.triggerCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7836086+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.handle_time")
    public static final SqlColumn<Date> handleTime = xxlJobLog.handleTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7836086+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.handle_code")
    public static final SqlColumn<Integer> handleCode = xxlJobLog.handleCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7836086+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.alarm_status")
    public static final SqlColumn<Byte> alarmStatus = xxlJobLog.alarmStatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7836086+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.trigger_msg")
    public static final SqlColumn<String> triggerMsg = xxlJobLog.triggerMsg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7836086+08:00", comments="Source field: test_embeddedproxy..xxl_job_log.handle_msg")
    public static final SqlColumn<String> handleMsg = xxlJobLog.handleMsg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7816095+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    public static final class XxlJobLog extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Integer> jobGroup = column("job_group", JDBCType.INTEGER);

        public final SqlColumn<Integer> jobId = column("job_id", JDBCType.INTEGER);

        public final SqlColumn<String> executorAddress = column("executor_address", JDBCType.VARCHAR);

        public final SqlColumn<String> executorHandler = column("executor_handler", JDBCType.VARCHAR);

        public final SqlColumn<String> executorParam = column("executor_param", JDBCType.VARCHAR);

        public final SqlColumn<String> executorShardingParam = column("executor_sharding_param", JDBCType.VARCHAR);

        public final SqlColumn<Integer> executorFailRetryCount = column("executor_fail_retry_count", JDBCType.INTEGER);

        public final SqlColumn<Date> triggerTime = column("trigger_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> triggerCode = column("trigger_code", JDBCType.INTEGER);

        public final SqlColumn<Date> handleTime = column("handle_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> handleCode = column("handle_code", JDBCType.INTEGER);

        public final SqlColumn<Byte> alarmStatus = column("alarm_status", JDBCType.TINYINT);

        public final SqlColumn<String> triggerMsg = column("trigger_msg", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> handleMsg = column("handle_msg", JDBCType.LONGVARCHAR);

        public XxlJobLog() {
            super("test_embeddedproxy.xxl_job_log");
        }
    }

}
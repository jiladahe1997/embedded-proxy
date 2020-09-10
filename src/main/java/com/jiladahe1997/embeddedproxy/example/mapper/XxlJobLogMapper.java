package com.jiladahe1997.embeddedproxy.example.mapper;

import static com.jiladahe1997.embeddedproxy.example.mapper.XxlJobLogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jiladahe1997.embeddedproxy.example.model.XxlJobLog;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface XxlJobLogMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7856072+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    BasicColumn[] selectList = BasicColumn.columnList(id, jobGroup, jobId, executorAddress, executorHandler, executorParam, executorShardingParam, executorFailRetryCount, triggerTime, triggerCode, handleTime, handleCode, alarmStatus, triggerMsg, handleMsg);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7836086+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7836086+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7836086+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<XxlJobLog> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7836086+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<XxlJobLog> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7846077+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("XxlJobLogResult")
    Optional<XxlJobLog> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7846077+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="XxlJobLogResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="job_group", property="jobGroup", jdbcType=JdbcType.INTEGER),
        @Result(column="job_id", property="jobId", jdbcType=JdbcType.INTEGER),
        @Result(column="executor_address", property="executorAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="executor_handler", property="executorHandler", jdbcType=JdbcType.VARCHAR),
        @Result(column="executor_param", property="executorParam", jdbcType=JdbcType.VARCHAR),
        @Result(column="executor_sharding_param", property="executorShardingParam", jdbcType=JdbcType.VARCHAR),
        @Result(column="executor_fail_retry_count", property="executorFailRetryCount", jdbcType=JdbcType.INTEGER),
        @Result(column="trigger_time", property="triggerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="trigger_code", property="triggerCode", jdbcType=JdbcType.INTEGER),
        @Result(column="handle_time", property="handleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="handle_code", property="handleCode", jdbcType=JdbcType.INTEGER),
        @Result(column="alarm_status", property="alarmStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="trigger_msg", property="triggerMsg", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="handle_msg", property="handleMsg", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<XxlJobLog> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7846077+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7846077+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, xxlJobLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7846077+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, xxlJobLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7846077+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7846077+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default int insert(XxlJobLog record) {
        return MyBatis3Utils.insert(this::insert, record, xxlJobLog, c ->
            c.map(id).toProperty("id")
            .map(jobGroup).toProperty("jobGroup")
            .map(jobId).toProperty("jobId")
            .map(executorAddress).toProperty("executorAddress")
            .map(executorHandler).toProperty("executorHandler")
            .map(executorParam).toProperty("executorParam")
            .map(executorShardingParam).toProperty("executorShardingParam")
            .map(executorFailRetryCount).toProperty("executorFailRetryCount")
            .map(triggerTime).toProperty("triggerTime")
            .map(triggerCode).toProperty("triggerCode")
            .map(handleTime).toProperty("handleTime")
            .map(handleCode).toProperty("handleCode")
            .map(alarmStatus).toProperty("alarmStatus")
            .map(triggerMsg).toProperty("triggerMsg")
            .map(handleMsg).toProperty("handleMsg")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7856072+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default int insertMultiple(Collection<XxlJobLog> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, xxlJobLog, c ->
            c.map(id).toProperty("id")
            .map(jobGroup).toProperty("jobGroup")
            .map(jobId).toProperty("jobId")
            .map(executorAddress).toProperty("executorAddress")
            .map(executorHandler).toProperty("executorHandler")
            .map(executorParam).toProperty("executorParam")
            .map(executorShardingParam).toProperty("executorShardingParam")
            .map(executorFailRetryCount).toProperty("executorFailRetryCount")
            .map(triggerTime).toProperty("triggerTime")
            .map(triggerCode).toProperty("triggerCode")
            .map(handleTime).toProperty("handleTime")
            .map(handleCode).toProperty("handleCode")
            .map(alarmStatus).toProperty("alarmStatus")
            .map(triggerMsg).toProperty("triggerMsg")
            .map(handleMsg).toProperty("handleMsg")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7856072+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default int insertSelective(XxlJobLog record) {
        return MyBatis3Utils.insert(this::insert, record, xxlJobLog, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(jobGroup).toPropertyWhenPresent("jobGroup", record::getJobGroup)
            .map(jobId).toPropertyWhenPresent("jobId", record::getJobId)
            .map(executorAddress).toPropertyWhenPresent("executorAddress", record::getExecutorAddress)
            .map(executorHandler).toPropertyWhenPresent("executorHandler", record::getExecutorHandler)
            .map(executorParam).toPropertyWhenPresent("executorParam", record::getExecutorParam)
            .map(executorShardingParam).toPropertyWhenPresent("executorShardingParam", record::getExecutorShardingParam)
            .map(executorFailRetryCount).toPropertyWhenPresent("executorFailRetryCount", record::getExecutorFailRetryCount)
            .map(triggerTime).toPropertyWhenPresent("triggerTime", record::getTriggerTime)
            .map(triggerCode).toPropertyWhenPresent("triggerCode", record::getTriggerCode)
            .map(handleTime).toPropertyWhenPresent("handleTime", record::getHandleTime)
            .map(handleCode).toPropertyWhenPresent("handleCode", record::getHandleCode)
            .map(alarmStatus).toPropertyWhenPresent("alarmStatus", record::getAlarmStatus)
            .map(triggerMsg).toPropertyWhenPresent("triggerMsg", record::getTriggerMsg)
            .map(handleMsg).toPropertyWhenPresent("handleMsg", record::getHandleMsg)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7856072+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default Optional<XxlJobLog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, xxlJobLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7856072+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default List<XxlJobLog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, xxlJobLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7856072+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default List<XxlJobLog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, xxlJobLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7856072+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default Optional<XxlJobLog> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7856072+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, xxlJobLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7856072+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    static UpdateDSL<UpdateModel> updateAllColumns(XxlJobLog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(jobGroup).equalTo(record::getJobGroup)
                .set(jobId).equalTo(record::getJobId)
                .set(executorAddress).equalTo(record::getExecutorAddress)
                .set(executorHandler).equalTo(record::getExecutorHandler)
                .set(executorParam).equalTo(record::getExecutorParam)
                .set(executorShardingParam).equalTo(record::getExecutorShardingParam)
                .set(executorFailRetryCount).equalTo(record::getExecutorFailRetryCount)
                .set(triggerTime).equalTo(record::getTriggerTime)
                .set(triggerCode).equalTo(record::getTriggerCode)
                .set(handleTime).equalTo(record::getHandleTime)
                .set(handleCode).equalTo(record::getHandleCode)
                .set(alarmStatus).equalTo(record::getAlarmStatus)
                .set(triggerMsg).equalTo(record::getTriggerMsg)
                .set(handleMsg).equalTo(record::getHandleMsg);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7866064+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(XxlJobLog record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(jobGroup).equalToWhenPresent(record::getJobGroup)
                .set(jobId).equalToWhenPresent(record::getJobId)
                .set(executorAddress).equalToWhenPresent(record::getExecutorAddress)
                .set(executorHandler).equalToWhenPresent(record::getExecutorHandler)
                .set(executorParam).equalToWhenPresent(record::getExecutorParam)
                .set(executorShardingParam).equalToWhenPresent(record::getExecutorShardingParam)
                .set(executorFailRetryCount).equalToWhenPresent(record::getExecutorFailRetryCount)
                .set(triggerTime).equalToWhenPresent(record::getTriggerTime)
                .set(triggerCode).equalToWhenPresent(record::getTriggerCode)
                .set(handleTime).equalToWhenPresent(record::getHandleTime)
                .set(handleCode).equalToWhenPresent(record::getHandleCode)
                .set(alarmStatus).equalToWhenPresent(record::getAlarmStatus)
                .set(triggerMsg).equalToWhenPresent(record::getTriggerMsg)
                .set(handleMsg).equalToWhenPresent(record::getHandleMsg);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7866064+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default int updateByPrimaryKey(XxlJobLog record) {
        return update(c ->
            c.set(jobGroup).equalTo(record::getJobGroup)
            .set(jobId).equalTo(record::getJobId)
            .set(executorAddress).equalTo(record::getExecutorAddress)
            .set(executorHandler).equalTo(record::getExecutorHandler)
            .set(executorParam).equalTo(record::getExecutorParam)
            .set(executorShardingParam).equalTo(record::getExecutorShardingParam)
            .set(executorFailRetryCount).equalTo(record::getExecutorFailRetryCount)
            .set(triggerTime).equalTo(record::getTriggerTime)
            .set(triggerCode).equalTo(record::getTriggerCode)
            .set(handleTime).equalTo(record::getHandleTime)
            .set(handleCode).equalTo(record::getHandleCode)
            .set(alarmStatus).equalTo(record::getAlarmStatus)
            .set(triggerMsg).equalTo(record::getTriggerMsg)
            .set(handleMsg).equalTo(record::getHandleMsg)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7866064+08:00", comments="Source Table: test_embeddedproxy..xxl_job_log")
    default int updateByPrimaryKeySelective(XxlJobLog record) {
        return update(c ->
            c.set(jobGroup).equalToWhenPresent(record::getJobGroup)
            .set(jobId).equalToWhenPresent(record::getJobId)
            .set(executorAddress).equalToWhenPresent(record::getExecutorAddress)
            .set(executorHandler).equalToWhenPresent(record::getExecutorHandler)
            .set(executorParam).equalToWhenPresent(record::getExecutorParam)
            .set(executorShardingParam).equalToWhenPresent(record::getExecutorShardingParam)
            .set(executorFailRetryCount).equalToWhenPresent(record::getExecutorFailRetryCount)
            .set(triggerTime).equalToWhenPresent(record::getTriggerTime)
            .set(triggerCode).equalToWhenPresent(record::getTriggerCode)
            .set(handleTime).equalToWhenPresent(record::getHandleTime)
            .set(handleCode).equalToWhenPresent(record::getHandleCode)
            .set(alarmStatus).equalToWhenPresent(record::getAlarmStatus)
            .set(triggerMsg).equalToWhenPresent(record::getTriggerMsg)
            .set(handleMsg).equalToWhenPresent(record::getHandleMsg)
            .where(id, isEqualTo(record::getId))
        );
    }
}
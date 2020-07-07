package com.jiladahe1997.embeddedproxy.example.mapper;

import static com.jiladahe1997.embeddedproxy.example.mapper.XxlJobUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jiladahe1997.embeddedproxy.example.model.XxlJobUser;
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
public interface XxlJobUserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7696188+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    BasicColumn[] selectList = BasicColumn.columnList(id, username, password, role, permission);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7596247+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7606239+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7616246+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<XxlJobUser> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7626229+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<XxlJobUser> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7626229+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("XxlJobUserResult")
    Optional<XxlJobUser> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7636221+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="XxlJobUserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.TINYINT),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR)
    })
    List<XxlJobUser> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7646216+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7656215+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, xxlJobUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7656215+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, xxlJobUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7666206+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7666206+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default int insert(XxlJobUser record) {
        return MyBatis3Utils.insert(this::insert, record, xxlJobUser, c ->
            c.map(id).toProperty("id")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(role).toProperty("role")
            .map(permission).toProperty("permission")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7676202+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default int insertMultiple(Collection<XxlJobUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, xxlJobUser, c ->
            c.map(id).toProperty("id")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(role).toProperty("role")
            .map(permission).toProperty("permission")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7686193+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default int insertSelective(XxlJobUser record) {
        return MyBatis3Utils.insert(this::insert, record, xxlJobUser, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(role).toPropertyWhenPresent("role", record::getRole)
            .map(permission).toPropertyWhenPresent("permission", record::getPermission)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7706179+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default Optional<XxlJobUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, xxlJobUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7716175+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default List<XxlJobUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, xxlJobUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7716175+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default List<XxlJobUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, xxlJobUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.772617+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default Optional<XxlJobUser> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.772617+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, xxlJobUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7736161+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    static UpdateDSL<UpdateModel> updateAllColumns(XxlJobUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(role).equalTo(record::getRole)
                .set(permission).equalTo(record::getPermission);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7736161+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(XxlJobUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(role).equalToWhenPresent(record::getRole)
                .set(permission).equalToWhenPresent(record::getPermission);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7746156+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default int updateByPrimaryKey(XxlJobUser record) {
        return update(c ->
            c.set(username).equalTo(record::getUsername)
            .set(password).equalTo(record::getPassword)
            .set(role).equalTo(record::getRole)
            .set(permission).equalTo(record::getPermission)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-01T15:01:47.7756156+08:00", comments="Source Table: test_embeddedproxy..xxl_job_user")
    default int updateByPrimaryKeySelective(XxlJobUser record) {
        return update(c ->
            c.set(username).equalToWhenPresent(record::getUsername)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(role).equalToWhenPresent(record::getRole)
            .set(permission).equalToWhenPresent(record::getPermission)
            .where(id, isEqualTo(record::getId))
        );
    }
}
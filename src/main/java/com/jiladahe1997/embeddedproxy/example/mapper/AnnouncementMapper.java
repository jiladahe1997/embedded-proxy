package com.jiladahe1997.embeddedproxy.example.mapper;

import static com.jiladahe1997.embeddedproxy.example.mapper.AnnouncementDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jiladahe1997.embeddedproxy.example.model.Announcement;
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
public interface AnnouncementMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8800734+08:00", comments="Source Table: test_embeddedproxy..announcement")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, content, type, time, views);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8700841+08:00", comments="Source Table: test_embeddedproxy..announcement")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8710833+08:00", comments="Source Table: test_embeddedproxy..announcement")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8710833+08:00", comments="Source Table: test_embeddedproxy..announcement")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Announcement> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8720824+08:00", comments="Source Table: test_embeddedproxy..announcement")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Announcement> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8720824+08:00", comments="Source Table: test_embeddedproxy..announcement")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AnnouncementResult")
    Optional<Announcement> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8730819+08:00", comments="Source Table: test_embeddedproxy..announcement")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AnnouncementResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="views", property="views", jdbcType=JdbcType.INTEGER)
    })
    List<Announcement> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8750806+08:00", comments="Source Table: test_embeddedproxy..announcement")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8750806+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, announcement, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8760805+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, announcement, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8760805+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8770749+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default int insert(Announcement record) {
        return MyBatis3Utils.insert(this::insert, record, announcement, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(content).toProperty("content")
            .map(type).toProperty("type")
            .map(time).toProperty("time")
            .map(views).toProperty("views")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8780744+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default int insertMultiple(Collection<Announcement> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, announcement, c ->
            c.map(id).toProperty("id")
            .map(title).toProperty("title")
            .map(content).toProperty("content")
            .map(type).toProperty("type")
            .map(time).toProperty("time")
            .map(views).toProperty("views")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8790735+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default int insertSelective(Announcement record) {
        return MyBatis3Utils.insert(this::insert, record, announcement, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(content).toPropertyWhenPresent("content", record::getContent)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(time).toPropertyWhenPresent("time", record::getTime)
            .map(views).toPropertyWhenPresent("views", record::getViews)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8810734+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default Optional<Announcement> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, announcement, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8810734+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default List<Announcement> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, announcement, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8820721+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default List<Announcement> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, announcement, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8820721+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default Optional<Announcement> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8830614+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, announcement, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8830614+08:00", comments="Source Table: test_embeddedproxy..announcement")
    static UpdateDSL<UpdateModel> updateAllColumns(Announcement record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(title).equalTo(record::getTitle)
                .set(content).equalTo(record::getContent)
                .set(type).equalTo(record::getType)
                .set(time).equalTo(record::getTime)
                .set(views).equalTo(record::getViews);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8840609+08:00", comments="Source Table: test_embeddedproxy..announcement")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Announcement record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(content).equalToWhenPresent(record::getContent)
                .set(type).equalToWhenPresent(record::getType)
                .set(time).equalToWhenPresent(record::getTime)
                .set(views).equalToWhenPresent(record::getViews);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8850596+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default int updateByPrimaryKey(Announcement record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(content).equalTo(record::getContent)
            .set(type).equalTo(record::getType)
            .set(time).equalTo(record::getTime)
            .set(views).equalTo(record::getViews)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-06-23T20:39:57.8850596+08:00", comments="Source Table: test_embeddedproxy..announcement")
    default int updateByPrimaryKeySelective(Announcement record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(content).equalToWhenPresent(record::getContent)
            .set(type).equalToWhenPresent(record::getType)
            .set(time).equalToWhenPresent(record::getTime)
            .set(views).equalToWhenPresent(record::getViews)
            .where(id, isEqualTo(record::getId))
        );
    }
}
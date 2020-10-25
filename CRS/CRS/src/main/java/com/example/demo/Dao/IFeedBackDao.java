package com.example.demo.Dao;

import com.example.demo.domain.FeedBack;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface IFeedBackDao {

    @Select("select * from FeedBacks")
    List<FeedBack> findAll();


    @Select("<script>"+
            "select * from FeedBacks " +
            "<where> " +
            "<if test='saying!=null'>" +
            " and saying like CONCAT('%',#{saying},'%') " +
            "</if> " +
            "<if test='state!=null'>" +
            " and  state=#{state} " +
            "</if> " +
            "<if test='userID!=null'>" +
            " and userID=#{userID} " +
            "</if>" +
            "<if test='backsaying!=null'>" +
            " and backsaying like CONCAT('%',#{backsaying},'%') " +
            "</if>" +
            "</where>"+
            "</script>")
    List<FeedBack> findByArgs(
            @Param("saying") String saying ,
            @Param("state") Integer state,
            @Param("userID") String userID,
            @Param("backsaying") String backsaying
    );

    @Options(useGeneratedKeys = true,keyProperty = "ID",keyColumn = "ID")
    @Insert("insert into FeedBacks(saying ,sendTime,state,processTime,userID,backsaying) " +
            "values(#{saying} ,#{sendTime},#{state},#{processTime},#{userID},#{backsaying})")
    void addFeedBack(FeedBack feedBack);

    @Delete("delete from FeedBacks where ID=#{ID}")
    void deleteFeedBack(FeedBack feedBack);

    @Update("update FeedBacks set " +
            "saying=#{saying}," +
            "sendTime=#{sendTime}," +
            "state=#{state}" +
            "processTime=#{processTime}" +
            "userID=#{userID}" +
            "backsaying=#{backsaying}" +
            "where ID=#{ID}")
    void updateFeedBack(FeedBack feedBack);

    @Select("select * from FeedBacks where state=0")
    List<FeedBack> findUndoFeedBack();

    @Select("select * from FeedBacks " +
            "where unix_timestamp(#{end})<=unix_timestamp(sendTime)" +
            "and unix_timestamp(#{start})>=unix_timestamp(sendTime)")
    List<FeedBack> findBySendTime(@Param("start") Timestamp start,@Param("end") Timestamp end);

    @Select("select * from FeedBacks " +
            "where unix_timestamp(#{end})<=unix_timestamp(processTime)" +
            "and unix_timestamp(#{start})>=unix_timestamp(processTime)")
    List<FeedBack> findByProcessTime(@Param("start") Timestamp start,@Param("end") Timestamp end);
}

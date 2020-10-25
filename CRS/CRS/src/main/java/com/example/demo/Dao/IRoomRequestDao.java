package com.example.demo.Dao;

import com.example.demo.domain.FeedBack;
import com.example.demo.domain.RoomRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface IRoomRequestDao {
    @Select("select * from RoomRequests")
    List<RoomRequest> findAll();


    @Select("select * from RoomRequests " +
            "<where>" +
            "<if test='RequstID!=null'>" +
            " and RequstID=#{RequstID} " +
            "</if>" +
            "<if test='userID!=null'>" +
            " and userID=#{userID} " +
            "</if>" +
            "<if test='classroomID!=null'>" +
            " and classroomID=#{classroomID} " +
            "</if>" +
            "<if test=' requestTime!=null'>" +
            " and  requestTime=#{ requestTime} " +
            "</if>" +
            "<if test='startTime!=null'>" +
            " and startTime=#{startTime} " +
            "</if>" +
            "<if test='endTime!=null'>" +
            " and endTime=#{endTime} " +
            "</if>" +
            "<if test='state!=null'>" +
            " and state=#{state} " +
            "</if>" +
            "</where>")
    List<RoomRequest> findByArgs(
           @Param("RequstID") BigInteger RequstID,
           @Param("userID") String userID,
           @Param("classroomID") BigInteger classroomID ,
           @Param("requestTime") Timestamp requestTime ,
           @Param("startTime") Timestamp startTime,
           @Param("endTime") Timestamp endTime,
           @Param("state") Integer state
    );

    @Insert("insert into FeedBacks(saying ,sendTime,state,processTime,userID,backsaying) " +
            "values(#{saying} ,#{sendTime},#{state},#{processTime},#{userID},#{backsaying})")
    void addFeedBack(FeedBack feedBack);

    @Delete("delete from FeedBacks where ID=#{ID}")
    void deleteFeedBack(FeedBack feedBack);

    @Update("update Users set " +
            "saying=#{saying}," +
            "sendTime=#{sendTime}," +
            "state=#{state}" +
            "processTime=#{processTime}" +
            "userID=#{userID}" +
            "backsaying=#{backsaying}" +
            "sendTime=#{sendTime}" +
            "processTime=#{processTime}" +
            "where ID=#{ID}")
    void updateFeedBack(FeedBack feedBack);

    @Select("select * FROM FeedBacks " +
            "where unix_timestamp(startTime)>=unix_timestamp(#{timestamp})")
    List<RoomRequest> findByStartTime(@Param("timestamp") Timestamp timestamp);

    @Select("select * FROM FeedBacks " +
            "where unix_timestamp(endTime)<=unix_timestamp(#{timestamp})")
    List<RoomRequest> findByEndTime(@Param("timestamp") Timestamp timestamp);

}


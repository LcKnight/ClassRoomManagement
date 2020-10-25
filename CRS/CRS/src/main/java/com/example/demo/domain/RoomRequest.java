package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class RoomRequest {
    BigInteger RequstID;
    String userID;
    BigInteger classroomID ;
    Timestamp requestTime ;
    Timestamp startTime;
    Timestamp endTime;
    Timestamp state    ;
}

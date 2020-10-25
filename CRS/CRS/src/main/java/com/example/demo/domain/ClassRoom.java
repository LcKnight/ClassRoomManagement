package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ClassRoom {
    BigInteger classroomID;
    String region;
    String building;
    Integer m_number;
    Integer m_type;
    Integer capacity;
}

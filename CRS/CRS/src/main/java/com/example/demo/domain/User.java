package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.jws.HandlerChain;
import java.sql.Timestamp;

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    String userID;
    String userName;
    String m_password;
    Integer priority;
}

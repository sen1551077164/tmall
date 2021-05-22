package com.senmiao.domain;

import lombok.Data;

@Data
public class User {
    Integer id;
    String username;
    String password;
    String nickname;
}
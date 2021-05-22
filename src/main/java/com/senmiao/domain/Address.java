package com.senmiao.domain;

import lombok.Data;

@Data
public class Address {
    Integer id;
    String address;
    Integer postCode;
    String name;
    String phone;
    Integer userId;
}

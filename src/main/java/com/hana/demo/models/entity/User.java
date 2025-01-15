package com.hana.demo.models.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    Long id;
    String name;
    String password;
    String ctime;
    String mtime;
}

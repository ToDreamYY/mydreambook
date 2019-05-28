package com.dreambook.doMain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {

    private Integer uid;

    private String username;

    private String password;

    private String usercode;

    private Set<Role> roles = new HashSet<>();
}

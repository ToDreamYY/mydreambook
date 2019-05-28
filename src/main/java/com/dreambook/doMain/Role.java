package com.dreambook.doMain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Role {

    private Integer rid;

    private String rname;

    private Set<User> users = new HashSet<>();

    private Set<Module> modules = new HashSet<>();
}

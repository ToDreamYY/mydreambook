package com.dreambook.doMain;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Module {

    private Integer mid;

    private String mname;

    private Integer parentid;

    private Set<Role> roles;

}

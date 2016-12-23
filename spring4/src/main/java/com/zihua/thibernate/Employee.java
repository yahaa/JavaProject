package com.zihua.thibernate;

import javax.persistence.Column;

/**
 * Created by zihua on 16-12-23.
 */

public class Employee {
    private String name;
    private String id;

    public Employee() {

    }

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

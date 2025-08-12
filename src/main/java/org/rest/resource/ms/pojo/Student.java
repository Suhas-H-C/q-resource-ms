package org.rest.resource.ms.pojo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

public class Student extends PanacheEntityBase {

    public Long id;
    private String name;
    private Integer standard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Student(String name, Integer standard) {
        this.name = name;
        this.standard = standard;
    }

    public Student() {
    }
}

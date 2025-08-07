package org.rest.resource.ms.pojo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Student extends PanacheEntity {

    private String name;
    private Integer standard;

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

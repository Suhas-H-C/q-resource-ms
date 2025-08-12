package org.rest.resource.ms.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

public class Artist extends PanacheEntityBase {

    public Long id;
    public String name;
    public String bio;
    public int age;

    public Artist() {
    }

    public Artist(String name, String bio, int age) {
        this.name = name;
        this.bio = bio;
        this.age = age;
    }

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

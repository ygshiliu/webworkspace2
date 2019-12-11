package com.wnn.bean;

public class User {
    private Integer id;
    private String username;
    private String email;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public User(final Integer id, final String username, final String email, final int age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public User() {
    }
}

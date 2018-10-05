package com.brzyang.java8.stream;

public class Person {

    private String email;
    private String name;
    private int age;

    public Person(String email, String name, int age) {
        this.email = email;
        this.name = name;
        this.age = age;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [email=" + email + ", name=" + name + ", age=" + age + "]";
    }

}
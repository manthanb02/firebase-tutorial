package com.example.firebaseapp1;

public class users {

    public String name;
    public String age;

    public users(){

    }

    public users(String name,String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

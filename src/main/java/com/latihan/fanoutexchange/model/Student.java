package com.latihan.fanoutexchange.model;

public class Student
{
    private Long nim;
    private String name;
    private String course;

    public Student() {
    }

    public Student(Long nim, String name, String course) {
        this.nim = nim;
        this.name = name;
        this.course = course;
    }

    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

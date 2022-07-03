package com.example.driverapp.data.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String fist_name;
    private final String last_name;
    private final String surname;
    private final int age;
    private boolean absence;

    public Student(String f,String l,String s,int age,boolean absence){
        this.fist_name = f;
        this.last_name = l;
        this.surname = s;
        this.age = age;
        this.absence = absence;
    }

    public String getFist_name() {
        return fist_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }

    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Abdo","ahmed","alimi",22,false);
        Student student2 = new Student("monzer","mohmed","hamed",23,false);
        Student student3 = new Student("taqi","eshaq","maiof",23,false);
        Student student4 = new Student("mohmed","qasem","saleh",21,false);
        Student student5 = new Student("mosa","mohmed","mohmed",20,true);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }

}

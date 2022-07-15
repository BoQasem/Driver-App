package com.example.driverapp.model;

public class Student {
    int id;
    int parent_id;
    String name;
    int level;
    String fist_name = "null";
    String last_name = "null";
    String surname = "null";
    String age;
//    boolean absence;

    public Student(String f,String l,String s,String age){
        this.fist_name = f;
        this.last_name = l;
        this.surname = s;
        this.age = age;
//        this.absence = absence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getFist_name() {
        return fist_name;
    }

    public void setFist_name(String fist_name) {
        this.fist_name = fist_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //    public String getFist_name() {
//        return fist_name;
//    }
//    public String getLast_name() {
//        return last_name;
//    }
//    public String getSurname() {
//        return surname;
//    }
//    public int getAge() {
//        return age;
//    }
//
//    public static void main(String[] args){
//        List<Student> students = new ArrayList<>();
//        Student student1 = new Student("Abdo","ahmed","alimi",22,false);
//        Student student2 = new Student("monzer","mohmed","hamed",23,false);
//        Student student3 = new Student("taqi","eshaq","maiof",23,false);
//        Student student4 = new Student("mohmed","qasem","saleh",21,false);
//        Student student5 = new Student("mosa","mohmed","mohmed",20,true);
//
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//        students.add(student4);
//        students.add(student5);
//    }

}

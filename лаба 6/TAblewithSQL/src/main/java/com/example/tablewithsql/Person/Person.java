package com.example.tablewithsql.Person;

public class Person {

    public int id;
    public String Name;
    public String Surname;
    public String email;

    public Person(int id, String name, String surname,  String email) {
        this.id = id;
        this.Name = name;
        this.Surname=surname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }
    public String getSurname(){return Surname;}

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return id + " "
                + Name + " "
                +Surname+" "
                + email + " ";
    }
}
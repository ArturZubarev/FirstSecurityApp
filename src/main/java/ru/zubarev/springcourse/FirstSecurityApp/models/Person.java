package ru.zubarev.springcourse.FirstSecurityApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Id;
@Column(name = "username")
@NotEmpty(message = "Это поле не может быть пустым")
@Size(min = 2,max = 100,message =
"Имя пользователя должно составлять от 2 до 100 знаков")
private String username;
@Column(name = "year_of_birth")
private int yearOfBirth;
@Column(name = "password")
private String password;
public Person() {}

    public Person(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                '}';
    }
}

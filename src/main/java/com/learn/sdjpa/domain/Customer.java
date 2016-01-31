package com.learn.sdjpa.domain;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.learn.sdjpa.util.MyClass;
import com.learn.sdjpa.util.StringJsonUserType;
import com.learn.sdjpa.util.Utils;

import javax.persistence.*;
import java.io.IOException;

@TypeDefs({ @TypeDef(name = "StringJsonObject", typeClass = StringJsonUserType.class) })
@Entity
@Table(name = "customer") //, schema = "datajpa")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstName;
    private String lastName;
    @Transient
    //private HashMap<String, Integer> test;
    private MyClass test;

    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        test = new MyClass("a","b");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Type(type = "StringJsonObject")
    @Access(AccessType.PROPERTY)
    @Column(name = "test")
    public String getTestAsString() throws IOException {
        return Utils.getJsonRepresenatation(test);
    }

    public Customer setTestAsString(String jsonData) throws IOException {
        if (jsonData != null)
            test = Utils.getObjectFromJson(jsonData);
        return this;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", test=" + test +
                '}';
    }
}


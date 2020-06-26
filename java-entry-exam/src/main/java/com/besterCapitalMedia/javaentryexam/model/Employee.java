package com.besterCapitalMedia.javaentryexam.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class, property = "id", scope = Employee.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    @Column(name = "EmployeeID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "DOB")
    private Date dob;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "SSN")
    private String SSN;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public Date getDOB() {
//        return DOB;
//    }
//
//    public void setDOB(Date DOB) {
//        this.DOB = DOB;
//    }
//
//    public Date getHireDate() {
//        return hireDate;
//    }
//
//    public void setHireDate(Date hireDate) {
//        this.hireDate = hireDate;
//    }
//
//    public String getSSN() {
//        return SSN;
//    }
//
//    public void setSSN(String SSN) {
//        this.SSN = SSN;
//    }
}

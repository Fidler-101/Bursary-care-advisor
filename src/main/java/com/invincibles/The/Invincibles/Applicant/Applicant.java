package com.invincibles.The.Invincibles.Applicant;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.*;
import java.util.Date;

@Entity

public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String firstname;
    private String lastname;

    private String gender;
    private String birthday;
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'Submitted'")
    private String status;

    @CreationTimestamp // Automatically set when entity is created
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Lob // For large objects
    @Column(name = "picture", columnDefinition = "LONGBLOB") // Specify as long blob
    private byte[] picture;

    @Lob // For large objects
    @Column(name = "pdf_file", columnDefinition = "LONGBLOB") // Specify as long blob
    private byte[] pdfFile;

    // Constructor, getters, and setters...


    public Applicant() {

    }

    public Applicant(String username, String firstname, String gender, String lastname, String birthday, String phoneNumber, String email, String password, Date createdAt, String status, byte[] picture, byte[] pdfFile) {
        this.username = username;
        this.firstname = firstname;
        this.gender = gender;
        this.lastname = lastname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.status = status;
        this.picture = picture;
        this.pdfFile = pdfFile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public byte[] getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(byte[] pdfFile) {
        this.pdfFile = pdfFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

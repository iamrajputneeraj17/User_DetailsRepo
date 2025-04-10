package com.example.Users_Details.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_entity", schema = "v_user")
public class User_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String country;
    private String gender;
    private Long mobileNo;
    private String remark;
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_employement", referencedColumnName = "id")
    private List<EmployementDetails> employementDetailsList;

    public List<EmployementDetails> getEmployementDetailsList() {
        return employementDetailsList;
    }

    public void setEmployementDetailsList(List<EmployementDetails> employementDetailsList) {
        this.employementDetailsList = employementDetailsList;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

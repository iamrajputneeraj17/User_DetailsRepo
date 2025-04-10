package com.example.Users_Details.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EmployementDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employment_id;

    private String e_name;

    private String e_status;

    private String e_address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_employement")
    private User_Entity userEntity;

    public Long getEmployment_id() {
        return employment_id;
    }

    public void setEmployment_id(Long employment_id) {
        this.employment_id = employment_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_status() {
        return e_status;
    }

    public void setE_status(String e_status) {
        this.e_status = e_status;
    }

    public String getE_address() {
        return e_address;
    }

    public void setE_address(String e_address) {
        this.e_address = e_address;
    }

    public User_Entity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(User_Entity userEntity) {
        this.userEntity = userEntity;
    }
}




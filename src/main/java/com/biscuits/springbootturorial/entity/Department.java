package com.biscuits.springbootturorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity//to enable this class to interact with the jpa database...//and to make this class an entity...
@Data//to let this entity use lombok...inbuilt @Getters and @Setters...
@NoArgsConstructor//to create a default constructor with no arguments...
@AllArgsConstructor//to create a constructor with all the arguments...
@Builder
public class Department {

    @Id//to make departmentId a primary key...
    @GeneratedValue(strategy = GenerationType.AUTO)//for generating the primary key...
    private Long departmentId;
    @NotBlank(message = "Please add department name")//adding a not blank validation. This ensures that departmentName is never blank...
   /*@Size(max=10, min=0)//size validation
    @Email//email validation...*/
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

   /* public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department() {
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }*/
}

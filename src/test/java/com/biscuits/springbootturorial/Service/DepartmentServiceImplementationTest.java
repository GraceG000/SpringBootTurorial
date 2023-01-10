package com.biscuits.springbootturorial.Service;

import com.biscuits.springbootturorial.Repository.DepartmentRepository;
import com.biscuits.springbootturorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest//to make this a test class...
class DepartmentServiceImplementationTest {

   @Autowired
    private DepartmentServiceImplementation departmentServiceImplementation;

   //mocking departmentRepository...
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
     Department department =  Department.builder()
             .departmentName("IT")
             .departmentAddress("Ahmedabad").departmentCode("IT-06")
             .departmentId(1l)
             .build();

     Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    //write test cases for both the positive scenarios and the negative ones...

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    //@Disabled// This disables a particular test case...
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
          String departmentName = "IT";
          Department found = departmentServiceImplementation.fetchDepartmentByName(departmentName);
          //validating against the department name...
          assertEquals(departmentName, found.getDepartmentName());
    }
}
package com.biscuits.springbootturorial.Controller;

import com.biscuits.springbootturorial.Service.DepartmentService;
import com.biscuits.springbootturorial.entity.Department;
import com.biscuits.springbootturorial.error.DepartmentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static java.lang.reflect.Array.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean//mocking the bean...
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Bangalore")
                .departmentCode("IT-06").departmentName("IT")
                .departmentId(1L)
                .build();
    }
/*
    @Test
    void saveDepartment() throws Exception {
        List<Department> inputDepartment = (List<Department>) Department.builder().departmentAddress("Bangalore").departmentCode("IT-06").departmentName("IT").departmentId(1L).build();

        //mocking...
        Mockito.when(departmentService.saveDepartment((List<Department>) inputDepartment)).thenReturn((List<Department>) department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                "    \"departmentName\":\"IT\",\n" +
                "    \"departmentAddress\": \"Bangalore\",\n" +
                "    \"departmentCode\":\"IT-06\"\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }*/

    @Test
     void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }


}
package com.biscuits.springbootturorial.Controller;

import com.biscuits.springbootturorial.Service.DepartmentService;
import com.biscuits.springbootturorial.entity.Department;
import com.biscuits.springbootturorial.error.DepartmentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController//for creating our rest api...this makes this class an api...
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;//performing dependency injection to allow the springboot framework to have control over the development of the student objects...

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    //method to save a department...
    @PostMapping("/departments")//to make this a rest api//and to save this to the database
    public List<Department> saveDepartment(@Valid @RequestBody List<Department> department){//RequestBody is used to bind the user's input in the http request to the method parameter...
           return departmentService.saveDepartment(department);
    }

    //method to display all the departments available in the database...
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");//performing logs...
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")// to get a particular record based on id...@PathVariable ensures that it maps the departmentId to the {id} portion of the endpoint...
    public Department fetchDepartmentById(@PathVariable("id")Long departmentId ) throws DepartmentNotFoundException {
       return departmentService.fetchDepartmentById(departmentId);
    }

    //implementing error handling...


    //to add a delete functionality to the application...
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
        }

    //to add an update functionality to the application...//Put mapping is used for updates...
    @PutMapping("/departments/{id}")//here, we need to add the path variable and add the request body as well...
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    //to get a department by name...
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}

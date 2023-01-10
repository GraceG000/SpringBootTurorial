package com.biscuits.springbootturorial.Service;

import com.biscuits.springbootturorial.Repository.DepartmentRepository;
import com.biscuits.springbootturorial.entity.Department;
import com.biscuits.springbootturorial.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service//to make this a service class...
public class DepartmentServiceImplementation implements DepartmentService{


    //making reference to the department repository...
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> saveDepartment(List<Department> department) {
        return departmentRepository.saveAll(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("This department is not available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);//we are not returning this because in the controller class we are returning a statement...
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        //the condition statements below are performing null-checks and blank-checks...
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}

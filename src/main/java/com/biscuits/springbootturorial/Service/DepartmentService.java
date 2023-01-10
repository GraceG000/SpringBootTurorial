package com.biscuits.springbootturorial.Service;

import com.biscuits.springbootturorial.entity.Department;
import com.biscuits.springbootturorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public List<Department> saveDepartment(List<Department> department);

   List<Department> fetchDepartmentList();

   Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   void deleteDepartmentById(Long departmentId);

   Department updateDepartment(Long departmentId, Department department);

   Department fetchDepartmentByName(String departmentName);
}

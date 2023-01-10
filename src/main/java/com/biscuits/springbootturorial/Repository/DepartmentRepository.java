package com.biscuits.springbootturorial.Repository;

import com.biscuits.springbootturorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//to make this our repository layer...
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}

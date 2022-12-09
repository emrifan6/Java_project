package com.amiya.springbootstarterweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amiya.springbootstarterweb.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

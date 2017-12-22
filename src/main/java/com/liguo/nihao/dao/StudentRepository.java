package com.liguo.nihao.dao;

import com.liguo.nihao.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 *  JpaRepository完成简单的增删改查功能
 *  JpaSpecificationExecutor完成有条件的复杂查询
 */
public interface StudentRepository extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student> {
     List<Student> getStudentByAge(int age);
     List<Student> findByAge(int age);
}

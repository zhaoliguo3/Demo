package com.liguo.nihao.dao;

import com.liguo.nihao.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *  JpaRepository完成简单的增删改查功能
 *  JpaSpecificationExecutor完成有条件的复杂查询
 */
public interface StudentRepository extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student> {

}

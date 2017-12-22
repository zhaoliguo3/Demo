package com.liguo.nihao.service;

import com.liguo.nihao.dao.StudentRepository;
import com.liguo.nihao.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // 增加一个学生
    public Student insertStudent(Student student){
        return studentRepository.save(student);
    }
    //根据主键删除一个学生
    public void deleteStudentById(Integer id){
        studentRepository.delete(id);
    }
    //更改一个学生的信息
    public Student updataStudent(Student student){
        return studentRepository.save(student);
    }
    //根据主键查找学生
    public Student selectStudentById(Integer id) {
        return studentRepository.findOne(id);
    }
    //查找全部学生
    public List<Student> selectAllStudents(){
        return studentRepository.findAll();
    }
    //分页查询
    public Page<Student> seleteByPage(int page, int size){
        Pageable pageable=new PageRequest(page,size, Sort.Direction.ASC, "id");
        return studentRepository.findAll(pageable);
    }
    //根据年龄查找
    public List<Student> seleteByAge(int age){
        return studentRepository.findByAge(age);
    }
}

package com.liguo.nihao.controller;

import com.liguo.nihao.dao.ResultResponse;
import com.liguo.nihao.domain.Page;
import com.liguo.nihao.domain.Student;
import com.liguo.nihao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NihaoController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResultResponse<Student> addStudent(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("sal") double sal) {
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        student.setSal(sal);
       // return studentService.insertStudent(student);
        return new ResultResponse<Student>(200,"插入成功", studentService.insertStudent(student));
    }

    @GetMapping("/deleteStudent/{id}")
    public ResultResponse<Student> deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudentById(id);
        return new ResultResponse<Student>(200,"删除成功");
    }

    @PutMapping("/updataStudent/{id}")
    public ResultResponse<Student> updataStudent(@PathVariable("id") Integer id,
                                 @RequestParam("name") String name,
                                 @RequestParam("age") int age,
                                 @RequestParam("sal") double sal){
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setSal(sal);
        //return studentService.updataStudent(student);
        return new ResultResponse<Student>(200,"修改成功", studentService.updataStudent(student));
    }

    @GetMapping("/seleteStudent/{id}")
    public ResultResponse<Student> seleteStudent(@PathVariable("id") Integer id){
        //return studentService.selectStudentById(2);
        return new ResultResponse<Student>(200,"查询一个学生",studentService.selectStudentById(2));

    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public ResultResponse<List<Student>> seleteAllStudent(){
        //return studentService.selectAllStudents();
        return new ResultResponse<List<Student>>(200,"查询所有学生",studentService.selectAllStudents());
    }

    @PostMapping("/page")
    public ResultResponse<Page> seleteStudentByPage(@RequestParam("page")int page,
                                    @RequestParam("size")int size){
       // return studentService.seleteByPage(page,size);
       // return new ResultResponse<List<Student>>(200,"分页查询",studentService.seleteByPage(page,size).getContent());
        Page page1=new Page(page,size,studentService.seleteByPage(page,size).getContent());
        return new ResultResponse<Page>(200,"分页查询",page1);
    }

    @PutMapping("/age/{age}")
    public ResultResponse<List<Student>> seleteStudentByAge(@PathVariable int age){
        return new ResultResponse<List<Student>>(200,"根据年龄查询学生",studentService.seleteByAge(age));
    }


}

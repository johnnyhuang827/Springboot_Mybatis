package com.example.service;

import com.example.entity.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface StudentService {
    Student selectStudentById(Long id);


    int insertStudent(Student student);


    int deleteStudentById(int id);


    int updateStudent(Student student);

    List<Student> queryAll();

    PageInfo<Student> queryByPage(int pageNum, int pageSize);

    List<Student> queryByDescOrder();

    List<Student> queryByOrder();

}

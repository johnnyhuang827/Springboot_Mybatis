package com.example.controller;

import com.example.ajax.AjaxResult;
import com.example.entity.Department;
import com.example.entity.Student;
import com.example.service.DepartmentService;
import com.example.service.StudentService;
import com.example.service.StudentVoService;
import com.example.vo.StudentVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
@RequestMapping("/studentVo")
public class StudentVoController {

    @Autowired
    private StudentVoService studentVoService;


    @RequestMapping("/queryAll")
    public List<StudentVo> queryAll(){
        return studentVoService.queryAll();
    }

    @GetMapping("/{id}")
    public StudentVo getInfo(@PathVariable Long id){
        return studentVoService.getInfo(id);

    }

    @RequestMapping("queryByPage/{page}")
    public PageInfo<StudentVo> queryByPage(@PathVariable int page){
        return studentVoService.queryByPage(page, 5);
    }


    // todo
    //vo age,sex


    // todo
    //search
    //score
    //log out
    //register
}

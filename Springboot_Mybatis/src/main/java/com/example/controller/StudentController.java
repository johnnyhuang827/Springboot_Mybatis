package com.example.controller;

import com.example.ajax.AjaxResult;
import com.example.entity.Student;
import com.example.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
@RequestMapping("/student")
public class StudentController {

        @Autowired
        private StudentService studentService;

        protected AjaxResult toAjax(int rows)
        {
            return rows > 0 ? AjaxResult.success() : AjaxResult.error();
        }

        /**
         * 查所有
         * @return
         */
        @RequestMapping("/queryAll")
        public List<Student> queryAll(){
                return studentService.queryAll();
        }

        @RequestMapping("queryByPage/{page}")
        public PageInfo<Student> queryByPage(@PathVariable int page){
                return studentService.queryByPage(page, 4);
        }

        @RequestMapping("/queryByDescOrder")
        public List<Student> queryByDescOrder(){
                return studentService.queryByDescOrder();
        }

        @RequestMapping("/queryByOrder")
        public List<Student> queryByOrder(){
                return studentService.queryByOrder();
        }

        /**
         * 查
         * @param id
         * @return
         */
        @GetMapping("/{id}")
        public Student getInfo(@PathVariable Long id)
        {
            return studentService.selectStudentById(id);
        }


        /**
         * 增
         * @param student
         * @return
         */
        @PostMapping
        public AjaxResult add(@Validated @RequestBody Student student)
        {
            return toAjax(studentService.insertStudent(student));
        }


        /**
         * 改
         * @param student
         * @return
         */
        @PutMapping
        public AjaxResult edit(@Validated @RequestBody Student student)
        {
            return toAjax(studentService.updateStudent(student));
        }


        /**
         * 删
         * @param id
         * @return
         */
        @DeleteMapping("/{id}")
        public AjaxResult remove( @PathVariable int id)
        {
            return toAjax(studentService.deleteStudentById(id));
        }

}



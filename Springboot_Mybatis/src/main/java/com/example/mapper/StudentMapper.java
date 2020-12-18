package com.example.mapper;

import com.example.entity.Student;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;


@Repository
public interface StudentMapper extends Mapper<Student>{

//        使用通用Mapper


//        @Select("select * from student_table where student_id = #{id} ")
//        Student selectStudentById(Long id);
//
//        @Insert("insert into student_table( student_id, student_name, student_birthday, student_gender, student_department_id) " +
//                "values ( #{studentId}, #{studentName}, #{studentBirthday}, #{studentGender} , #{studentDepartmentId})")
//        int insertStudent(Student student);
//
//        @Delete("delete from student_table student_id = #{id}")
//        int deleteStudentById(int id);
//
//        @Update("update student_table\n" +
//                " set\n" +
//                "       student_name = #{studentName},\n" +
//                "       student_birthday = #{studentBirthday},\n" +
//                "       student_gender = #{studentGender}\n" +
//                "       student_department_id = #{studentDepartmentId}\n" +
//                " where student_id = #{id}")
//        int updateStudent(Student student);
//
//        @Select("select * from student_table")
//        List<Student> queryAll();

        @Select("select TIMESTAMPDIFF(YEAR,student_table.student_birthday,CURDATE()) as age from student_table where student_id = #{id}")
        Long queryAge(Long id);

}

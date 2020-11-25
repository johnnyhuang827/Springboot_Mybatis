package com.example.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Table(name = "student_table")
public class Student {


    //使用lombok 简化实体类
    @NotNull(message = "id不能为空")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long studentId;

    private String studentName;

    private Date studentBirthday;

    private Integer studentGender;

    private Long studentDepartmentId;



}

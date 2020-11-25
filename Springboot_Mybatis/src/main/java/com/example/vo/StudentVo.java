package com.example.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class StudentVo {

    @Id
    @KeySql(useGeneratedKeys = true)

    private Long studentId;

    private String studentName;

    private String studentBirthday;

    private String studentDepartment;


}

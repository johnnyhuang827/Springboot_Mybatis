package com.example.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "department_table")
public class Department {

    @NotNull(message = "id不能为空")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long DepartmentId;

    private String DepartmentName;

    private String DeanName;

}

package com.example.mapper;

import com.example.entity.Department;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface DepartmentMapper extends Mapper<Department> {
}

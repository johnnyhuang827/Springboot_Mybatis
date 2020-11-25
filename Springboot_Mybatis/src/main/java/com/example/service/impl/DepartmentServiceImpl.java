package com.example.service.impl;

import com.example.entity.Department;
import com.example.mapper.DepartmentMapper;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department queryById(Long did) {
        return departmentMapper.selectByPrimaryKey(did);
    }
}

package com.example.service.impl;

import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import com.example.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.ValueOperations;
import tk.mybatis.mapper.entity.Example;

import java.util.concurrent.TimeUnit;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    //加入redis缓存
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Student selectStudentById(Long id) {

        String key = "student_" + id;

        ValueOperations<String, Student> operations = redisTemplate.opsForValue();

        //判断redis中是否有键为key的缓存
        boolean hasKey = redisTemplate.hasKey(key);


        if (hasKey) {
            Student student = operations.get(key);
            System.out.println("从缓存中获得数据: "+student.getStudentName()+", key为: " + key);
            System.out.println("------------------------------------");
            return student;
        } else {
            Student student = studentMapper.selectByPrimaryKey(id);
            System.out.println("查询数据库获得数据: "+student.getStudentName()+", key为: " + key);
            System.out.println("------------------------------------");

            // 写入缓存
            operations.set(key, student, 5, TimeUnit.HOURS);
            return student;
        }
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int deleteStudentById(int id) {

        int result = studentMapper.deleteByPrimaryKey(id);
        String key = "student_" + id;
        if (result != 0) {
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                System.out.println("删除了缓存中的key: " + key);
            }
        }
        return result;
    }

    @Override
    public int updateStudent(Student student) {

        ValueOperations<String, Student> operations = redisTemplate.opsForValue();
        int result = studentMapper.updateByPrimaryKey(student);
        if (result != 0) {
            String key = "student_" + student.getStudentId();
            boolean haskey = redisTemplate.hasKey(key);
            if (haskey) {
                redisTemplate.delete(key);
                System.out.println("删除缓存中的key: " + key);
                // 再将更新后的数据加入缓存
                System.out.println("更新缓存中的key: " + key);
                Student studentNew = studentMapper.selectByPrimaryKey(student.getStudentId());
                if (studentNew != null) {
                    operations.set(key, studentNew, 3, TimeUnit.HOURS);
                }
            }


        }
        return result;
    }

    @Override
    public List<Student> queryAll() {
        return studentMapper.selectAll();
    }

    @Override
    public PageInfo<Student> queryByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<Student>(studentMapper.selectAll());
    }

    @Override
    public List<Student> queryByDescOrder() {
        Example example = new Example(Student.class);
        example.orderBy("studentId").desc();
        return studentMapper.selectByExample(example);
    }


    @Override
    public List<Student> queryByOrder() {
        Example example = new Example(Student.class);
        example.orderBy("studentId");
        return studentMapper.selectByExample(example);
    }




}

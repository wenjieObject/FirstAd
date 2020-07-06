package com.wenjie.adc.mapper;

import com.wenjie.adc.pojo.Student;

import java.util.List;

public interface Mapper {

    public List<Student> getAllStudent(String gender,String className);
}

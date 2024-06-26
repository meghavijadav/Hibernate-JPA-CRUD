package com.meghavi.cruddemo.dao;

import com.meghavi.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();
    List<Student> findByLastName(String theLastName);

}

package com.meghavi.cruddemo.dao;

import com.meghavi.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

}

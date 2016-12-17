package com.zihua.dao;

import com.zihua.model.Student;

import java.util.List;

/**
 * Created by zihua on 16-12-17.
 */
public interface StudentDao {

    public int addStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(int id);

    public List<Student> findStudents();
}

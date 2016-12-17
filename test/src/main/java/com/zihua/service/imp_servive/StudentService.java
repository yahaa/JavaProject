package com.zihua.service.imp_servive;

import com.zihua.dao.StudentDao;
import com.zihua.service.Service;
import com.zihua.model.Student;


/**
 * Created by zihua on 16-12-17.
 */
public class StudentService implements Service{
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int add(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int delete(int id) {
        return studentDao.deleteStudent(id);
    }


}

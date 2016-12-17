package com.zihua.service;

import com.zihua.model.Student;

/**
 * Created by zihua on 16-12-17.
 */
public interface Service {
    int add(Student student);

    int delete(int id);

    int update(Student student);
}

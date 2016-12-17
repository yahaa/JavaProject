package com.zihua;

import com.zihua.model.People;
import com.zihua.model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zihua on 16-12-17.
 */
public class MyTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");

    @org.junit.Test
    public void test1() {
        People zihua = (People) ac.getBean("zihua");
        System.out.println(zihua);
    }

    @org.junit.Test
    public void test2() {
        System.out.println("fuck you ");
    }

    @Test
    public void test3() {
        People xiaoqiang = (People) ac.getBean("xiaoqiang");
        System.out.println(xiaoqiang);
    }

    @Test
    public void test4() {
        People huang = (People) ac.getBean("huang");
        System.out.println(huang);
    }

    @Test
    public void test5() {
        People ming = (People) ac.getBean("ming");
        System.out.println(ming);
    }

    @Test
    public void test6() {
        People gao = (People) ac.getBean("gao");
        System.out.println(gao);
    }

    @Test
    public void test7() {
        People yahaa = (People) ac.getBean("yahaa");
        System.out.println(yahaa);
    }

    @Test
    public void test8() {
        Student t = (Student) ac.getBean("zihua");
        t.sayName();

    }


}

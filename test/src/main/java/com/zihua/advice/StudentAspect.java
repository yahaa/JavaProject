package com.zihua.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by zihua on 16-12-17.
 */
public class StudentAspect {
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("执行前");
    }

    public void doAfter(JoinPoint joinPoint) {
        System.out.println("执行完成后");
    }

    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("执行前");
        joinPoint.proceed();
        System.out.println("执行后");
    }

    public void doAfterReturn(JoinPoint joinPoint) {
        System.out.println("返回后执行");
    }

    public void doExcpetion(JoinPoint joinPoint, Exception ex) {
        System.out.println(ex.getMessage());
    }
}

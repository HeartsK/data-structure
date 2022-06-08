package com.heartstone.structure.agency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author code generator
 * @date 2022-05-25 15:51
 */
public class DynamicAgency implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        System.out.println("test");
        return result;
    }

    public Object getProxyTarget(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}

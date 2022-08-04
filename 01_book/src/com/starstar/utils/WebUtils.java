package com.starstar.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils  {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            //把所有请求的参数都注入到user对象中
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}

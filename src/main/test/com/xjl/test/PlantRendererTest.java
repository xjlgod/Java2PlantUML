package com.xjl.test;

import com.github.juanmf.java2plant.render.PlantRenderer;
import com.github.juanmf.java2plant.util.TypesHelper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;

/**
 * @author jingliu_xiong@foxmail.com
 */
public class PlantRendererTest {

    private PlantRenderer plantRenderer;

    @Test
    public void TestFieldPrinter() {
//        Field[] declaredFields = Tree.class.getDeclaredFields();
//        for (Field f : declaredFields) {
//            System.out.println(f.getGenericType().toString());
//        }
//        for (Field f : declaredFields) {
//            System.out.println(TypesHelper.getSimpleName(f.getGenericType().toString()));
//        }

        Method[] declaredMethods = Tree.class.getDeclaredMethods();
        for (Method m : declaredMethods) {
            StringBuilder params = new StringBuilder();
            Parameter[] parameters = m.getParameters();
            Iterator<? extends Parameter> it = Arrays.asList(parameters).iterator();
            while (it.hasNext()) {
                Parameter c = it.next();
                params.append(c.getName() + " ");
                String primitiveType = getPrimitveTypeString(c);
                if (StringUtils.isEmpty(primitiveType)) {
                    params.append(TypesHelper.getSimpleName(c.getParameterizedType().getTypeName()));
                } else {
                    params.append(primitiveType);
                }
                if (it.hasNext()) {
                    params.append(", ");
                }
            }
            System.out.println(params.toString());
        }

        Constructor<?>[] constructors = Tree.class.getConstructors();
        for (Constructor<?> m : constructors) {
            StringBuilder params = new StringBuilder();
            Parameter[] parameters = m.getParameters();
            Iterator<? extends Parameter> it = Arrays.asList(parameters).iterator();
            while (it.hasNext()) {
                Parameter c = it.next();
                params.append(c.getName() + " ");
                String primitiveType = getPrimitveTypeString(c);
                if (StringUtils.isEmpty(primitiveType)) {
                    params.append(TypesHelper.getSimpleName(c.getParameterizedType().getTypeName()));
                } else {
                    params.append(primitiveType);
                }
                if (it.hasNext()) {
                    params.append(", ");
                }
            }
            System.out.println(params.toString());
        }
    }

    private String getPrimitveTypeString(Parameter c) {
        String result = null;
        if (c.getType() == byte[].class) {
            result = "byte []";
        } else if (c.getType()  == boolean[].class) {
            result = "boolean []";
        } else if (c.getType()  == short[].class) {
            result = "short []";
        } else if (c.getType()  == int[].class) {
            result = "int []";
        } else if (c.getType()  == long[].class) {
            result = "long []";
        } else if (c.getType()  == float[].class) {
            result = "float []";
        } else if (c.getType()  == double[].class) {
            result = "double []";
        } else if (c.getType()  == char[].class) {
            result = "char []";
        }
        return result;
    }
}

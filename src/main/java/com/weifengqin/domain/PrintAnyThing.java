package com.weifengqin.domain;

import java.util.List;

/**
 * 泛型类，类型编译时确定
 * @author qin start
 * @create 2023-10-25-10:49
 */
public class PrintAnyThing<T> {


    T printThing;


    public void print(T thing){
        this.printThing = thing;
        System.out.println(printThing);
    }

    // 以下方法两者存一
//    public void methodOverloading(List<String> list){
//
//    }
//
//    public void methodOverloading(List<Integer> list){
//
//    }

    public static <T> T returnSameType(T thing){
        return thing;

    }


    public static <T extends Vehicle> void restrictedTypeSimple(T thing){

    }

    public static  void restrictedTypeWildcard(List<? extends String> thing){

    }

}

package com.weifengqin;

import com.weifengqin.domain.Airplane;
import com.weifengqin.domain.Car;
import com.weifengqin.domain.PrintAnyThing;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qin start
 * @create 2023-10-25-10:48
 */
public class Main {


    /**
     * 泛型两大作用
     * ①编译时做类型擦除，做类型检查。对类型进行了编译限制。避免了强转，把类型检查提前到了编译时
     * ②
     */


    /**
     * 测试泛型类，编译时擦除
     */
    @Test
    public void testBasicGenerics(){
        PrintAnyThing<String> printAnyThing = new PrintAnyThing<>();

//        printAnyThing.print(1);   报错，因为String类型已经确定
        printAnyThing.print("1");
    }

    @Test
    public void testMethodOverloading(){

    }

    /**
     * 泛型方法优势，避免强转。编译时做出了判断
     */
    @Test
    public void testGenericsMethod(){
        Airplane airplane = PrintAnyThing.returnSameType(new Airplane());
        Car car = PrintAnyThing.returnSameType(new Car());
    }


    /**
     * 测试泛型限制。
     * ①单一泛型限制
     * ②引用泛型限制
     */
    @Test
    public void testRestrictedType(){
//        PrintAnyThing.restrictedTypeSimple(new Object());  失败
        PrintAnyThing.restrictedTypeSimple(new Airplane());





        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        //TODO 怎么理解 这里的泛型是什么
        List list = new ArrayList();

//        PrintAnyThing.restrictedTypeWildcard(integerList);失败

        PrintAnyThing.restrictedTypeWildcard(stringList);
        PrintAnyThing.restrictedTypeWildcard(list);

//        PrintAnyThing.restrictedTypeWildcard(new ArrayList<Integer>()); 失败
//        PrintAnyThing.restrictedTypeWildcard(new ArrayList<Object>()); 失败
        //TODO 怎么理解 这里的泛型是什么
        PrintAnyThing.restrictedTypeWildcard(new ArrayList<>());

    }


}

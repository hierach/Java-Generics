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


    //泛型优势
//    类型安全性：泛型允许在编译时捕获类型错误，而不是在运行时。这有助于减少由于类型不匹配而引发的异常。
//    代码复用：泛型代码可以适用于多种数据类型，减少了重复编写相似代码的工作。
//    可读性和可维护性：泛型使代码更加清晰，因为它们表明了代码的意图，而且代码更易于维护。
//    集合框架的增强：Java的集合框架（如ArrayList和HashMap）使用泛型来提高类型安全性和可读性。


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
        //这里的泛型不带"菱形操作符" (<>，使用的时候具体推断
        List list = new ArrayList();

//        PrintAnyThing.restrictedTypeWildcard(integerList);失败

        PrintAnyThing.restrictedTypeWildcard(stringList);
        PrintAnyThing.restrictedTypeWildcard(list);

//        PrintAnyThing.restrictedTypeWildcard(new ArrayList<Integer>()); 失败
//        PrintAnyThing.restrictedTypeWildcard(new ArrayList<Object>()); 失败
        //TODO 怎么理解 这里的泛型是什么
        /**
         * 在Java 8及更高版本中可以成功编译，因为编译器可以推断出new ArrayList<>()应该是一个ArrayList<? extends String>，
         * 而且ArrayList<? extends String>可以匹配方法的参数类型List<? extends String>。
         */
        PrintAnyThing.restrictedTypeWildcard(new ArrayList<>());

    }


}

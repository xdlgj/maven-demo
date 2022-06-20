package com.xdl.maven;

import org.junit.Test;
import com.xdl.maven.Calculator;
//静态导入的效果是将Assert类中的静态资源导入当前类
//这样以来，在当前类中就可以直接使用Asswert类中的静态资源，不需要写类名
import static org.junit.Assert.*;
// 测试compile依赖范围对main目录有效
import com.xdl.maven.Calculator;

/**
 * 测试方式：
 * 通过import语句将要测试的类引入到当前类，引入后：
 * 编译通过：可以使用，这个范围的依赖对当前类有效
 * 编译失败：不能使用，这个范围的依赖对当前类无效
 * main 目录下的java类：CalculatorTest
 * compile 范围引入的依赖：pro01-maven-java
 * pro01-maven-java中的类： Calculator
 */
public class CalculatorTest {
    @Test
    public void testSum() {
        //1.创建Calculator对象
        Calculator calculator = new Calculator();
        //2.调用对象的方法，获取到程序运行的结果
        int actualResult = calculator.sum(5, 3);
        //3.声明一个变量，表示程序运行期待的结果
        int expectedResult = 8;
        //4.使用断言来判断实际结果和期待结果是否一致
        //如果一致：测试通过，不会抛出异常
        //如果不一致，抛出异常，测试失败
        assertEquals(expectedResult, actualResult);
    }
}
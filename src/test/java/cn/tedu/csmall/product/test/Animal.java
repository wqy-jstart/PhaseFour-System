package cn.tedu.csmall.product.test;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * 定义一个动物的接口
 */
@SpringBootTest
public interface Animal {
    //该方法利用反射机制输出本类的完全限定名
    default void show(){
        System.out.println(Animal.class.getName());
    }
    default void yell(){
        System.out.println("我会狗叫!");
    }
}

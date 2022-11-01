package cn.tedu.csmall.product.test;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * Cat类实现Animal接口,选择性重写接口中的方法,重写后可以输出自身类的完全限定名
 */
@SpringBootTest
public class Cat implements Animal{
    @Override
    public void show() {
        System.out.println(Cat.class.getName());
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.show();
        //cn.tedu.csmall.product.test.Cat
    }
}

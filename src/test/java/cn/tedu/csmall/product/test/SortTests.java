package cn.tedu.csmall.product.test;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


@SpringBootTest
public class SortTests {
    public static void main(String[] args) {
        List<Integer> o = new ArrayList<>();
        List<Integer> j = new ArrayList<>();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
            if (array[i] % 2 == 0) {
                o.add(array[i]);
            } else {
                j.add(array[i]);
            }
        }
        Collections.sort(o, (o1, o2) -> o1 - o2);
        Collections.sort(j, (o1, o2) -> o1 - o2);
        System.out.println(o.toString());
        System.out.println(j.toString());
    }
}

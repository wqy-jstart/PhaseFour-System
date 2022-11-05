package cn.tedu.csmall.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@SpringBootTest
public class Md5Tests {

    // 解密工具类
    @Test
    public void encode(){
        String rawPassword = "12345678";
        String encodedPassword = DigestUtils.md5DigestAsHex(rawPassword.getBytes());
        System.out.println("原文：" + rawPassword);
        System.out.println("密文：" + encodedPassword);
    }

    // 加密时添加随机盐
    @Test
    public void encode1(){
        String rawPassword="123456";
        System.out.println("原文:"+rawPassword);
        for (int i = 0; i < 20; i++) {
            String salt = UUID.randomUUID().toString();// 随机生成不同的字符串
            String encodePassword = DigestUtils.md5DigestAsHex((rawPassword+salt).getBytes());
            System.out.println("密文:"+salt+encodePassword);
        }
    }

    // BcryptEncode加密手段
//    @Test
//    public void bcryptEncode() {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String rawPassword = "123456";
//        System.out.println("原文：" + rawPassword);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 15; i++) {
//            String encodedPassword = passwordEncoder.encode(rawPassword);
//            System.out.println("密文：" + encodedPassword);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//    }
}

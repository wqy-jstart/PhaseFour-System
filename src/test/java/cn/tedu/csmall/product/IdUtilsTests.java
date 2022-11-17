package cn.tedu.csmall.product;

import cn.tedu.csmall.product.util.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@Slf4j
@SpringBootTest
public class IdUtilsTests {

    @Test
    void getId(){
        long[] ids = new long[10];
        for (int i = 0; i < ids.length; i++) {
            long id = IdUtils.getId();
            ids[i] = id;
        }
        System.out.println(Arrays.toString(ids));
    }
}

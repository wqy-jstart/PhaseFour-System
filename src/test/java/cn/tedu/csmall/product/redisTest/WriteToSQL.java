package cn.tedu.csmall.product.redisTest;

import cn.tedu.csmall.product.mapper.TestToSQLMapper;
import cn.tedu.csmall.product.pojo.entity.TestToSQL;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

// 测试向数据库中写入100万条记录
@Slf4j
@SpringBootTest
public class WriteToSQL {

    @Autowired
    private TestToSQLMapper testToSQLMapper;

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        List<TestToSQL> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            TestToSQL testToSQL = new TestToSQL();
            testToSQL.setName("武清源" + i);
            if (i % 2 == 0) {
                testToSQL.setAge(10);
            } else {
                testToSQL.setAge(20);
            }
            list.add(testToSQL);
        }
        long end = System.currentTimeMillis();
        int rows = testToSQLMapper.insert(list);
        log.debug("插入成功！影响的行数为：{},一共消耗的时间为：{}ms", rows,(end-start));
    }

    @Test
    public void selectList(){
        long start = System.currentTimeMillis();

        testToSQLMapper.selectList().forEach(System.out::println);

        long end = System.currentTimeMillis();

        log.debug("查询成功！查询时间为：{}ms",(end-start)); // 23s
    }
}

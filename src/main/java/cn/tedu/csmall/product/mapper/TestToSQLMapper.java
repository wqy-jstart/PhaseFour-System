package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.TestToSQL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestToSQLMapper {

    int insert(List<TestToSQL> lists);

    List<TestToSQL> selectList();
}

package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.ex.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AttributeMapperTests {

    @Autowired
    AttributeMapper attributeMapper;

    @Test
    void selectByTemplateId(){
        Long id = 2L;
        try {
            int count = attributeMapper.countByTemplateId(id);
            log.debug("查询成功,数据数量为{}",count);
        }catch (ServiceException e){
            log.debug(e.getMessage());
        }
    }
}

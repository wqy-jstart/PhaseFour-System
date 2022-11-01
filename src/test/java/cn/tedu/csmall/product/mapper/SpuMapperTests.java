package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.ex.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SpuMapperTests {

    @Autowired
    SpuMapper mapper;

    @Test
    void countByAlbumId(){
        Long id = 1L;
        try {
            int count = mapper.countByAlbumId(id);
            log.debug("查询成功!数量为:{}",count);
        }catch (ServiceException e){
            log.debug(e.getMessage());
        }
    }

    @Test
    void countByAttributeTemplateId(){
        Long id = 1L;
        try {
            int count = mapper.countByAttributeTemplateId(id);
            log.debug("查询成功,数据的数量为{}",count);
        }catch (ServiceException e){
            log.debug(e.getMessage());
        }
    }
}

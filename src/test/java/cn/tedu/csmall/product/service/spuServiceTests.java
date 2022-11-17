package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.SpuAddNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class spuServiceTests {
    @Autowired
    private ISpuService iSpuService;

    @Test
    public void insert(){
        SpuAddNewDTO spuAddNewDTO = new SpuAddNewDTO();
        spuAddNewDTO.setName("小米");
        spuAddNewDTO.setTypeNumber("24569888");
        spuAddNewDTO.setTitle("今日新品");
        spuAddNewDTO.setDescription("好得很");
        spuAddNewDTO.setAlbumId(6L);
        spuAddNewDTO.setBrandId(7L);
        spuAddNewDTO.setCategoryId(22L);
        spuAddNewDTO.setDetail("66666666");
        iSpuService.addNew(spuAddNewDTO);
    }

}

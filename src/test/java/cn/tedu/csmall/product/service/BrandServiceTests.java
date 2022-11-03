package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BrandServiceTests {

    @Autowired
    IBrandService service;

    @Test
    void addNew(){
        BrandAddNewDTO brandAddNewDTO = new BrandAddNewDTO();
        brandAddNewDTO.setName("美的01");
        brandAddNewDTO.setPinyin("新-MeiDi");//商品拼音
        brandAddNewDTO.setLogo("新-Mei");//商品标志
        brandAddNewDTO.setDescription("新-该商品非常好!");//商品描述
        brandAddNewDTO.setKeywords("新-格");
        brandAddNewDTO.setSort(1);
        brandAddNewDTO.setSales(2888);
        brandAddNewDTO.setProductCount(30);
        brandAddNewDTO.setCommentCount(300);
        brandAddNewDTO.setPositiveCommentCount(200);
        brandAddNewDTO.setEnable(1);
        try{
            service.addNew(brandAddNewDTO);
            log.debug("测试添加数据成功!");
        }catch (RuntimeException e){
            log.debug(e.getMessage());//捕获异常时输出
        }
    }
}

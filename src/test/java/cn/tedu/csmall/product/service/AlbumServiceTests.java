package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.sevice.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AlbumServiceTests {

    @Autowired//注入Service接口
    IAlbumService service;

    //测试添加相册数据的操作
    @Test
    void addNew() {
        AlbumAddNewDTO albumAddNewDTO = new AlbumAddNewDTO();
        albumAddNewDTO.setName("测试数据10");
        albumAddNewDTO.setDescription("测试数据简介10");
        albumAddNewDTO.setSort(100);
        try{
            service.addNew(albumAddNewDTO);
            log.debug("测试添加数据成功!");
        }catch (ServiceException e){
            log.debug(e.getMessage());
        }
    }
    @Test
    void delete(){
        Long id = 20L;
        try{
            service.delete(id);
            log.debug("测试删除数据成功！");
        }catch (ServiceException e){
            log.debug(e.getMessage());
        }
    }
}

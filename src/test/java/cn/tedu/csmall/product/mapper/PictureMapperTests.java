package cn.tedu.csmall.product.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PictureMapperTests {

    @Autowired
    PictureMapper mapper;

    @Test
    void selectByAlbumId(){
        Long albumId = 1L;
        int count = mapper.countByAlbumId(albumId);
        log.debug("根据相册[{}]统计图片的数量,结果:{}",albumId,count);
    }
}

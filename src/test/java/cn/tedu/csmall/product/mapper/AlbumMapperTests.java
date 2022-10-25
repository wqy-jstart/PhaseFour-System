package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j//输出日志
@SpringBootTest
public class AlbumMapperTests {

    @Autowired
    AlbumMapper mapper;

    @Test
    void insert(){
        Album album = new Album();
        album.setName("测试相册001");
        album.setDescription("测试相册简介001");
        album.setSort(255);
        int rows = mapper.insert(album);
        log.info("受影响的行数为:"+rows);//输出日志
    }
}

package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        System.out.println("受影响的行数为:"+rows);
    }
}

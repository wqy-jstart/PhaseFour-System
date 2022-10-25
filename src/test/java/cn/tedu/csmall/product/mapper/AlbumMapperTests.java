package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j//输出日志
@SpringBootTest
public class AlbumMapperTests {

    @Autowired
    AlbumMapper mapper;

    //插入
    @Test
    void insert(){
        Album album = new Album();
        album.setName("测试相册002");
        album.setDescription("测试相册简介002");
        album.setSort(255);
        log.info("{}",album);//输出日志
        int rows = mapper.insert(album);
        log.info("受影响的行数为:{}",rows);//输出日志
        log.info("{}",album);//输出日志
    }

    //批量插入
    @Test
    void insertBatch(){
        List<Album> albums = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Album album = new Album();
            album.setName("批量插入测试相册"+i);
            album.setDescription("批量插入相册简介"+i);
            album.setSort(200);
            albums.add(album);
        }
        int rows = mapper.insertBatch(albums);
        log.debug("批量插入完成,受影响的行数,{}",rows);
    }

    //删除
    @Test
    void deleteById(){
        int rows = mapper.deleteById(1L);
        log.debug("删除完成,影响记录的条数为,{}",rows);
    }

    //批量删除
    @Test
    void deleteByIds(){
        Long[] ids = {2L,3L,4L};
        int rows = mapper.deleteByIds(ids);
        log.debug("批量删除完成,影响数据的条数为{}",rows);
    }

    //修改
    @Test
    void update(){
        Album album = new Album();
        album.setId(5L);
        album.setName("新-相册");
        album.setDescription("新-简介");
        album.setSort(166);
        int rows = mapper.update(album);
        log.debug("修改完成,影响的条数为{}",rows);
    }

    //查询数量
    @Test
    void count(){
        int count = mapper.count();
        log.debug("统计完成,表中的数据的数量:{}",count);
    }

    //根据id查询相册数据
    @Test
    void standardById(){
        Long id = 5L;
        AlbumStandardVO standardById = mapper.getStandardById(id);
        log.debug("根据id[{}]查询数据详情完成,查询结果:{}",id,standardById);
    }
}

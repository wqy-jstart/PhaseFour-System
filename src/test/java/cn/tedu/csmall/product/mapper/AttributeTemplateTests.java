package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class AttributeTemplateTests {

    @Autowired
    AttributeTemplateMapper mapper;

    @Test
    void insert(){
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setName("不知道");
        attributeTemplate.setSort(1);
        attributeTemplate.setKeywords("无");
        attributeTemplate.setPinyin("buzd");
        int rows = mapper.insert(attributeTemplate);
        log.debug("插入完成,影响数据的条数为:{}",rows);
    }

    @Test
    void insertBatch(){
        List<AttributeTemplate> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            AttributeTemplate attributeTemplate = new AttributeTemplate();
            attributeTemplate.setName("不知道"+i);
            attributeTemplate.setSort(1);
            attributeTemplate.setKeywords("无"+i);
            attributeTemplate.setPinyin("buzd"+i);
            list.add(attributeTemplate);
        }
        int rows = mapper.insertBatch(list);
        log.debug("批量插入完成,受影响的行数,{}",rows);
    }

    @Test
    void deleteById(){
        int rows = mapper.deleteById(1L);
        log.debug("删除完成,影响记录的条数为,{}",rows);
    }

    @Test
    void deleteByIds(){
        Long[] ids = {1L,2L,3L};
        int rows = mapper.deleteByIds(ids);
        log.debug("删除完成,影响记录的条数为,{}",rows);
    }

    @Test
    void update(){
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setId(1L);
        attributeTemplate.setName("不知道");
        attributeTemplate.setSort(2);
        attributeTemplate.setKeywords("无");
        attributeTemplate.setPinyin("buzd");
        int rows = mapper.update(attributeTemplate);
        log.debug("修改完成,影响记录的条数为,{}",rows);
    }

    @Test
    void count(){
        int rows = mapper.count();
        log.debug("统计完成,统计的数量为,{}",rows);
    }

    @Test
    void standardById(){
        Long id = 5L;
        AttributeTemplateStandardVO standardById = mapper.getStandardById(id);
        log.debug("根据id[{}]查询数据详情完成,查询结果:{}",id,standardById);
    }

    @Test
    void list(){
        List<AttributeTemplateListItemVO> list = mapper.list();
        log.debug("查询列表完成,列表中数据的数量:{}",list.size());
        for (AttributeTemplateListItemVO item : list) {
            log.debug("{}",item);
        }
    }
}

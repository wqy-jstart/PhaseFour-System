package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j//输出日志
@SpringBootTest
public class BrandMapperTests {

    @Autowired
    BrandMapper mapper;

    //插入
    @Test
    void insert(){
        Brand brand = new Brand();
        brand.setName("格力");//商品名称
        brand.setPinyin("GeLi");//商品拼音
        brand.setLogo("GL");//商品标志
        brand.setDescription("该商品非常好!");//商品描述
        brand.setKeywords("格");
        brand.setSort(1);
        brand.setSales(3000);
        brand.setProductCount(30);
        brand.setCommentCount(300);
        brand.setPositiveCommentCount(200);
        brand.setEnable(1);
        int rows = mapper.insert(brand);
        System.out.println("影响的条数为:"+rows);
    }

    //批量插入
    @Test
    void isnertBatch(){
        List<Brand> brands = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Brand brand = new Brand();
            brand.setName("商品名称"+i);//商品名称
            brand.setPinyin("GeLi"+i);//商品拼音
            brand.setLogo("GL"+i);//商品标志
            brand.setDescription("该商品非常好!"+i);//商品描述
            brand.setKeywords("格"+i);
            brand.setSort(1);
            brand.setSales(200);
            brand.setProductCount(30);
            brand.setCommentCount(300);
            brand.setPositiveCommentCount(200);
            brand.setEnable(1);
            brands.add(brand);
        }
        int rows = mapper.insertBatch(brands);
        log.debug("批量插入的数据条数,{}",rows);
    }

    //删除
    @Test
    void deleteById(){
        int rows = mapper.deleteById(31L);
        log.debug("删除完成,影响的条数为{}",rows);
    }

    //批量删除
    @Test
    void deleteByIds(){
        Long[] ids= {29L,30L,31L};
        int rows = mapper.deleteByIds(ids);
        log.debug("批量删除完成,影响的条数为{}",rows);
    }

    //修改
    @Test
    void update(){
        Brand brand = new Brand();
        brand.setId(17L);
        brand.setName("新-格力");//商品名称
        brand.setPinyin("新-GeLi");//商品拼音
        brand.setLogo("新-GL");//商品标志
        brand.setDescription("新-该商品非常好!");//商品描述
        brand.setKeywords("新-格");
        brand.setSort(1);
        brand.setSales(2888);
        brand.setProductCount(30);
        brand.setCommentCount(300);
        brand.setPositiveCommentCount(200);
        brand.setEnable(1);
        int rows = mapper.update(brand);
        log.debug("修改完成,影响数据的条数为{}",rows);
    }

    //查询数量
    @Test
    void count(){
        int count = mapper.count();
        log.debug("统计完成,共有品牌数量:{}",count);
    }

    //查询一条品牌数据
    @Test
    void standardById(){
        Long id = 1L;
        BrandStandardVO standardById = mapper.getStandardById(id);
        log.debug("根据id[{}]查询数据详情完成,查询结果:{}",id,standardById);
    }

    //查询所有数据
    @Test
    void list(){
        List<BrandListItemVO> list = mapper.list();
        log.debug("查询列表完成,列表中数据的数量:{}",list.size());
        for (BrandListItemVO item : list) {
            log.debug("{}",item);
        }
    }
}

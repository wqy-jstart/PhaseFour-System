package cn.tedu.csmall.product.preload;

import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.repo.IBrandRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 该组件类用于在项目启动之前从数据库将列表信息加载到Redis中,使得在查询列表时是从Redis中查询的
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Component // 声明是一个组件类,在项目启动时被加载
public class CachePreload implements ApplicationRunner {

    @Autowired
    private BrandMapper brandMapper;

    // 注入品牌的Redis缓存接口
    @Autowired
    private IBrandRedisRepository brandRedisRepository;

    // 构造方法,使得启动项目时自动加载该组件类
    public CachePreload(){
        log.debug("创建开机自动执行的组件对象: CachePreload");
    }

    // ApplicationRunner中的run()方法会在项目启动成功之后自动执行
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("CachePreload.run()");

        log.debug("准备删除Redis缓存中的品牌数据...");
        brandRedisRepository.deleteAll();
        log.debug("删除Redis缓存中的品牌数据,完成!");

        log.debug("准备从数据库中读取品牌列表...");
        List<BrandListItemVO> list = brandMapper.list();
        log.debug("从数据库中读取品牌列表，完成！");

        log.debug("准备将品牌列表写入到Redis缓存...");
        brandRedisRepository.save(list);
        log.debug("将品牌列表写入到Redis缓存，完成！");
    }
}

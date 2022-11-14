package cn.tedu.csmall.product.repo.impl;

import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.repo.IBrandRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Slf4j
@Repository// 声明一个组件,便于装配Spring管理的对象
public class BrandRedisRepositoryImpl implements IBrandRedisRepository {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    public BrandRedisRepositoryImpl(){
        log.debug("创建处理缓存的数据访问对象:BrandRedisRepositoryImpl");
    }

    // 向Redis中写入数据
    @Override
    public void save(BrandStandardVO brandStandardVO) {
        String key = "brand:"+brandStandardVO.getId();// 这样存储便于在Redis中归类呈现
        redisTemplate.opsForValue().set(key,brandStandardVO);
    }
}

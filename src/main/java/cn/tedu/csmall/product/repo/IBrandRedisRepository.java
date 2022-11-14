package cn.tedu.csmall.product.repo;

import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;

/**
 * 用来缓存Redis中品牌数据的接口类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
public interface IBrandRedisRepository {

    void save(BrandStandardVO brandStandardVO);
}

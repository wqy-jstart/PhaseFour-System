package cn.tedu.csmall.product.repo;

import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;

import java.util.List;

/**
 * 用来缓存Redis中品牌数据的接口类
 *
 * @Author java.@Wqy
 * @Version 0.0.1
 */
public interface IBrandRedisRepository {

    String BRAND_ITEM_KEY_PREFIX = "brand:item";// 表示品牌->item数据(多级的效果)

    String BRAND_LIST_KEY = "brand:list";// 用来存放品牌中的list列表的key

    String BRAND_ITEM_KEYS_KEY = "brand:item-keys";// 用来标记品牌的中item中的key成员

    /**
     * 该方法用来存储一条品牌数据,不做返回
     *
     * @param brandStandardVO 需要存储的品牌详情VO类
     */
    void save(BrandStandardVO brandStandardVO);

    /**
     * 该方法用来存储多条品牌数据,空返回
     *
     * @param brands 要存储的品牌List集合
     */
    void save(List<BrandListItemVO> brands);

    /**
     * 删除Redis中的所有数据(item数据,list集合数据,brand:list,brand:item-keys)
     * @return 返回删除的数量
     */
    Long deleteAll();

    /**
     * 向Redis中取出需要的item数据
     * 正常若向Redis中取数据需要对应的key值,
     * 这里的key有前缀拼接,为了封装性,这里只让调用者传入id即可
     *
     * @param id 品牌id
     * @return 返回品牌详情VO类
     */
    BrandStandardVO get(Long id);

    /**
     * 该方法用来取出所有品牌列表,无参
     *
     * @return 返回品牌列表的List集合
     */
    List<BrandListItemVO> list();

    /**
     * 该方法用来按指定下标范围取出品牌列表
     *
     * @param start 起始下标
     * @param end   末尾下标
     * @return 返回列表List集合
     */
    List<BrandListItemVO> list(long start, long end);
}

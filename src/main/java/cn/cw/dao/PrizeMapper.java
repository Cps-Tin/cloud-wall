package cn.cw.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author _Cps
 * @create 2019-02-14 10:25
 */
public interface PrizeMapper {

    Integer anaPrize(JSONObject prize);

    Integer anaPrizeUpdate(JSONObject prize);

    Integer userLoginSyncPrizeList(JSONObject object);

}

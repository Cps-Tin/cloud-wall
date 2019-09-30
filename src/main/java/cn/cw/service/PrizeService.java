package cn.cw.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author _Cps
 * @create 2019-02-14 10:25
 */
public interface PrizeService {

    Integer anaPrize(JSONObject prize);

    Integer anaPrizeUpdate(JSONObject prize);

    Integer userLoginSyncPrizeList(JSONObject object);

}

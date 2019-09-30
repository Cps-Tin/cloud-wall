package cn.cw.service.impl;

import cn.cw.dao.PrizeMapper;
import cn.cw.dao.UserMapper;
import cn.cw.service.PrizeService;
import cn.cw.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author _Cps
 * @create 2019-02-14 10:25
 */
@Service
public class PrizeServiceImpl implements PrizeService {

    @Resource
    public PrizeMapper prizeMapper;

    @Override
    public Integer anaPrize(JSONObject prize) {
        return prizeMapper.anaPrize(prize);
    }

    @Override
    public Integer anaPrizeUpdate(JSONObject prize) {
        return prizeMapper.anaPrizeUpdate(prize);
    }

    @Override
    public Integer userLoginSyncPrizeList(JSONObject object) {
        return prizeMapper.userLoginSyncPrizeList(object);
    }

}

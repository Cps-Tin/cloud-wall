package cn.cw.service.impl;

import cn.cw.dao.AnaMapper;
import cn.cw.service.AnaService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.08.02 13:14
 */
@Service
public class AnaServiceImpl implements AnaService {

    @Resource
    AnaMapper anaMapper;

    @Override
    public Integer anaPublic(JSONObject ana) {
        return anaMapper.anaPublic(ana);
    }

    @Override
    public List<JSONObject> getAnaList(JSONObject object) {
        return anaMapper.getAnaList(object);
    }

    @Override
    public JSONObject getAnaInfo(JSONObject object) {
        return anaMapper.getAnaInfo(object);
    }

    @Override
    public JSONObject getAnaUp(JSONObject object) {
        return anaMapper.getAnaUp(object);
    }

    @Override
    public JSONObject getAnaDown(JSONObject object) {
        return anaMapper.getAnaDown(object);
    }

}

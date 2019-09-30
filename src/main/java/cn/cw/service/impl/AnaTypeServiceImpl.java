package cn.cw.service.impl;

import cn.cw.dao.AnaTypeMapper;
import cn.cw.service.AnaTypeService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.08.02 13:18
 */
@Service
public class AnaTypeServiceImpl implements AnaTypeService {

    @Resource
    AnaTypeMapper anaTypeMapper;

    @Override
    public List<JSONObject> getAnaTypeList() {
        return anaTypeMapper.getAnaTypeList();
    }
}

package cn.cw.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.08.02 13:15
 */
public interface AnaMapper {

    List<JSONObject> getAnaList(JSONObject object);

    JSONObject getAnaInfo(JSONObject object);

    JSONObject getAnaUp(JSONObject object);

    JSONObject getAnaDown(JSONObject object);

    Integer anaPublic(JSONObject ana);
}

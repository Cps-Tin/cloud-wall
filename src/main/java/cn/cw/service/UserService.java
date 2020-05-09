package cn.cw.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author _Cps
 * @create 2019-02-14 10:25
 */
public interface UserService{

    Integer visit(String ip, String address,String device);

    Integer userRegister(JSONObject user);

    JSONObject userLogin(JSONObject user);

    List<JSONObject> getUserList(JSONObject object);

    Integer userNameCheckIsRegister(JSONObject user);

    Integer updateHeadImg(Integer userId, String userHeadImg);

    Integer userModify(JSONObject user);

}

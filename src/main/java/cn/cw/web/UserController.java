package cn.cw.web;

import cn.cw.core.Result;
import cn.cw.core.ResultCode;
import cn.cw.core.ResultGenerator;
import cn.cw.core.ResultPages;
import cn.cw.service.UserService;
import cn.cw.util.*;
import cn.cw.util.encrypt.MD5Util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author _Cps
 * @create 2019-02-14 10:24
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController{

    @Resource
    public UserService userService;

    String upLoadPath = "static"+ File.separator+"upLoadFiles" + File.separator;

    /**
     * 访问记录
     * 参数 device 设备信息
     */
    @RequestMapping("/visit")
    public Result visit(String device, HttpServletRequest request){
        Result result = null;
        String ip = IpUtil.getIpAddr(request);
        String address = IpUtil.getRealAddressByIP(ip);
        System.err.println(device);
        Integer num = userService.visit(ip,address,device);
        if(num == 1){
            result = ResultGenerator.genSuccessResult(address);
        }else{
            result = ResultGenerator.genFailResult("访问失败!");
        }
        return result;
    }

    /**
     * 验证账号是否被注册
     * @param user
     * @return
     */
    @PostMapping("/userNameCheckIsRegister")
    Result userNameCheckIsRegister(@RequestBody JSONObject user){
        Result result = null;
        Integer count = userService.userNameCheckIsRegister(user);
        if(count == 0){
            result = ResultGenerator.genSuccessResult("账号可以使用!");
        }else{
            result = ResultGenerator.genFailResult("账号已被使用!");
        }
        return result;
    }

    /**
     * 添加用户
     * 参数 user
     */
    @PostMapping("/userRegister")
    public Result userRegister(@RequestBody JSONObject user){
        //加密密码
        user.put("userPassword",MD5Util.getMD5String(user.getString("userPassword")));
        Result result = null;
        Integer num = userService.userRegister(user);
        if(num == 1){
            result = ResultGenerator.genSuccessResult("注册成功!");
        }else{
            result = ResultGenerator.genFailResult("注册失败!");
        }
        return result;
    }

    /**
     * 用户登录
     * 参数 user
     */
    @PostMapping("/userLogin")
    public Result userLogin(@RequestBody JSONObject user){
        user.put("userPassword", MD5Util.getMD5String(user.getString("userPassword")));
        Result result = null;
        JSONObject u = userService.userLogin(user);
        if(u != null){
            if(0 == u.getInteger("userDisabled")){
                result = ResultGenerator.genSuccessResult(u);
            }else{
                result = ResultGenerator.genFailResult("您的账号已被限制登陆，请联系管理员!");
            }
        }else{
            result = ResultGenerator.genFailResult("账号或密码错误,请重新输入!");
        }
        return result;
    }

    /**
     * 用户修改
     * 参数 user
     */
    @PostMapping("/userModify")
    public Result userModify(@RequestBody JSONObject user){
        Result result = null;
        Integer num = userService.userModify(user);
        if(num == 1){
            result = ResultGenerator.genSuccessResult("修改成功!");
        }else{
            result = ResultGenerator.genFailResult("修改失败!");
        }
        return result;
    }

    /**
     * 上传头像
     * @param request
     */
    @RequestMapping(value = "/upLoadHeadImg")
    public Result upLoadHeadImg(HttpServletRequest request) {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        String dirPath = request.getSession().getServletContext().getRealPath(upLoadPath);
        Result result = FileUtil.upLoadFile(upLoadPath,dirPath,request);
        if(result.getCode()!=200){
            // 出现了错误
            return result;
        }
        String userHeadImg = result.getMessage();
        Integer num = userService.updateHeadImg(userId,userHeadImg);
        if(num <= 0){
            result.setCode(ResultCode.FAIL);
            result.setMessage("修改头像失败!");
        }
        return result;
    }
    /**
     * 查询用户信息
     * 参数: current pageSize searchName userSex userDisabled
     * @return
     */
    @PostMapping("/getUserList")
    Result getUserList(@RequestBody JSONObject object){
        Result result = null;
        Integer current = object.getInteger("current");
        Integer pageSize = object.getInteger("pageSize");
        if(current == null){
            current = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        PageHelper.startPage(current,pageSize);
        List<JSONObject> list = userService.getUserList(object);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(new ResultPages(pageInfo));
    }

//    @PostMapping("/doLoginTest")
//    public String doLoginTest(User user, HttpSession session) {
//        //在User中添加了个验证码字段
//        if(user.getCheckCode()!=null && !user.getCheckCode().equals("")){
//            String inputImageCode = user.getCheckCode();
//            String sessionImageCode = (String) session.getAttribute(CheckCodeUtil.CHECK_CODE);
//            session.removeAttribute(CheckCodeUtil.CHECK_CODE);//清除Session中的imageCode
//            if(inputImageCode.equalsIgnoreCase(sessionImageCode)){
//                User u = userService.doLogin(user);
//                if (u != null) {
//                    session.setAttribute("userSession",u);
//                    return "redirect:/user/userList";
//                }
//            }else{
//                System.err.println("验证码错误");
//            }
//        }
//        System.err.println("登陆失败");
//        return "login";
//    }

//    /**
//     * 生成前端的图片验证码
//     */
//    @RequestMapping(value = "/checkCode")
//    public void getCheckCode(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            FileUtil.setResponseHeader("验证码",response);
//            CheckCodeUtil randomValidateCode = new CheckCodeUtil();
//            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
//        } catch (Exception e) {
//            System.err.println("将内存中的图片通过流动形式输出到客户端失败>>>>");
//        }
//    }




}

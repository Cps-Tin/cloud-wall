package cn.cw.web;

import cn.cw.core.Result;
import cn.cw.core.ResultCode;
import cn.cw.core.ResultGenerator;
import cn.cw.core.ResultPages;
import cn.cw.service.PrizeService;
import cn.cw.service.UserService;
import cn.cw.util.FileUtil;
import cn.cw.util.IpUtil;
import cn.cw.util.encrypt.MD5Util;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * @author _Cps
 * @create 2019-02-14 10:24
 */
@RestController
@RequestMapping("/prize")
public class PrizeController {

    @Resource
    public PrizeService prizeService;

    /**
     * 用户点赞：登陆状态
     * 参数 {"userId":"","anaId":""}
     */
    @PostMapping("/anaPrizeLogin")
    public Result anaPrizeLogin(@RequestBody JSONObject prize){
        Result result = null;
        Integer num = prizeService.anaPrize(prize);
        Integer num2 = prizeService.anaPrizeUpdate(prize);
        if(num2 == 1){
            result = ResultGenerator.genSuccessResult("点赞成功!");
        }else{
            result = ResultGenerator.genFailResult("点赞失败!");
        }
        return result;
    }

    /**
     * 用户点赞：未登陆状态
     * 参数 {"anaId":""}
     */
    @PostMapping("/anaPrizeUnLogin")
    public Result anaPrizeUnLogin(@RequestBody JSONObject prize){
        Result result = null;
        Integer num = prizeService.anaPrizeUpdate(prize);
        if(num == 1){
            result = ResultGenerator.genSuccessResult("点赞成功!");
        }else{
            result = ResultGenerator.genFailResult("点赞失败!");
        }
        return result;
    }

    /**
     * 用户登陆同步本地点赞记录
     * 参数 {"userId":"","prizeList":[]}
     */
    @PostMapping("/userLoginSyncPrizeList")
    public Result userLoginSyncPrizeList(@RequestBody JSONObject object){
        Result result = null;
        System.out.println(object);
        Integer num = prizeService.userLoginSyncPrizeList(object);
        if(object.getJSONArray("prizeList").size() == num){
            result = ResultGenerator.genSuccessResult("批量点赞成功!");
        }else{
            result = ResultGenerator.genFailResult("批量点赞失败!");
        }
        return result;
    }


}

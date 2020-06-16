package cn.cw.web;

import cn.cw.core.Result;
import cn.cw.core.ResultGenerator;
import cn.cw.core.ResultPages;
import cn.cw.service.AnaService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.08.02 13:12
 */
@RestController
@Api(tags="语录接口")
@RequestMapping("/ana")
public class AnaController {

    @Resource
    AnaService anaService;

    /**
     * 添加语录
     * 参数 ana
     */
    @PostMapping("/anaPublic")
    Result anaPublic(@RequestBody JSONObject ana){
        Result result = null;
        Integer num = anaService.anaPublic(ana);
        if(num == 1){
            result = ResultGenerator.genSuccessResult("发表成功!");
        }else{
            result = ResultGenerator.genFailResult("发表失败!");
        }
        return result;
    }

    /**
     * 根据语录ID 获取语录详情信息
     * 参数:anaId
     */
    @PostMapping("/getAnaInfo")
    Result getAnaInfo(@RequestBody JSONObject object){
        return ResultGenerator.genSuccessResult(anaService.getAnaInfo(object));
    }

    /**
     * 根据语录ID 获取上条语录
     * 参数:anaId
     */
    @PostMapping("/getAnaUp")
    Result getAnaUp(@RequestBody JSONObject object){
        return ResultGenerator.genSuccessResult(anaService.getAnaUp(object));
    }

    /**
     * 根据语录ID 获取下条语录
     * 参数:anaId
     */
    @PostMapping("/getAnaDown")
    Result getAnaDown(@RequestBody JSONObject object){
        return ResultGenerator.genSuccessResult(anaService.getAnaDown(object));
    }

    /**
     * 根据分类ID获取语录
     * 参数:anaTypeId searchName current pageSize
     */
    @PostMapping("/getAnaList")
    @ApiOperation(value = "根据分类ID 获取语录")
    Result getAnaList(@RequestBody JSONObject object){
        Integer current = object.getInteger("current");
        Integer pageSize = object.getInteger("pageSize");
        if(current == null || pageSize == null){
            current = 1;
            pageSize = 10;
        }
        PageHelper.startPage(current,pageSize);
        List<JSONObject> list = anaService.getAnaList(object);
        PageInfo<JSONObject> pageInfo = new PageInfo<JSONObject>(list);
        System.err.println(JSONArray.toJSONStringWithDateFormat(list,"yyyy-MM-dd HH:mm:ss"));
        System.err.println(ResultGenerator.genSuccessResult(new ResultPages<JSONObject>(pageInfo)));
        return ResultGenerator.genSuccessResult(new ResultPages<JSONObject>(pageInfo));
    }

}

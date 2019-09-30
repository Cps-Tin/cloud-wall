package cn.cw.web;

import cn.cw.core.Result;
import cn.cw.core.ResultGenerator;
import cn.cw.service.AnaTypeService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.08.02 13:17
 */
@Controller
@ResponseBody
@RequestMapping("/anaType")
public class AnaTypeController {

    @Resource
    AnaTypeService anaTypeService;

    /**
     * 获取所有分类
     */
    @RequestMapping("/getAnaTypeList")
    Result getAnaTypeList(){
        return ResultGenerator.genSuccessResult(anaTypeService.getAnaTypeList());
    }
}

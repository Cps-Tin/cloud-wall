package cn.cw.web;

import cn.cw.core.Result;
import cn.cw.core.ResultGenerator;
import cn.cw.core.ResultPages;
import cn.cw.service.CommentService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.08.02 14:25
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    CommentService commentService;

    /**
     *  评论语录
     * 	参数:comment
     */
    @PostMapping("/anaComment")
    Result anaComment(@RequestBody JSONObject object){
        Result result = null;
        Integer num = commentService.anaComment(object);
        Integer num2 = commentService.anaCommentUpdate(object);
        if(num2 == 1){
            result = ResultGenerator.genSuccessResult("评论成功!");
        }else{
            result = ResultGenerator.genFailResult("评论失败!");
        }
        return result;
    }

    /**
     *  根据语录ID 获取当前语录的评论、分页 -- 这里需要userId 主要是看是否点过赞、评论过，我们将从前端传过来，不传也可以，就是没登陆的意思，也能查询到数据，只不过点赞和评论都为0
     * 	参数:anaId current pageSize
     */
    @PostMapping("/getCommentList")
    Result getCommentList(@RequestBody JSONObject object){
        Integer current = object.getInteger("current");
        Integer pageSize = object.getInteger("pageSize");
        if(current == null || pageSize == null){
            current = 1;
            pageSize = 10;
        }
        PageHelper.startPage(current,pageSize);
        List<JSONObject> list = commentService.getCommentList(object);
        PageInfo<JSONObject> pageInfo = new PageInfo<JSONObject>(list);
        return ResultGenerator.genSuccessResult(new ResultPages<JSONObject>(pageInfo));
    }

}

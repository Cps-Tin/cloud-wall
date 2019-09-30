package cn.cw.service;

import cn.cw.core.Result;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.08.02 14:26
 */
public interface CommentService {

    List<JSONObject> getCommentList(JSONObject object);

    Integer anaComment(JSONObject object);

    Integer anaCommentUpdate(JSONObject object);
}

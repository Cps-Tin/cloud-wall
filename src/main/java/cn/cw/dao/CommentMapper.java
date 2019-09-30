package cn.cw.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.08.02 14:28
 */
public interface CommentMapper {

    List<JSONObject> getCommentList(JSONObject object);

    Integer anaComment(JSONObject object);

    Integer anaCommentUpdate(JSONObject object);
}

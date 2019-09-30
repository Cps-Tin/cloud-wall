package cn.cw.service.impl;

import cn.cw.dao.CommentMapper;
import cn.cw.service.CommentService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.08.02 14:27
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public List<JSONObject> getCommentList(JSONObject object) {
        return commentMapper.getCommentList(object);
    }

    @Override
    public Integer anaComment(JSONObject object) {
        return commentMapper.anaComment(object);
    }

    @Override
    public Integer anaCommentUpdate(JSONObject object) {
        return commentMapper.anaCommentUpdate(object);
    }
}

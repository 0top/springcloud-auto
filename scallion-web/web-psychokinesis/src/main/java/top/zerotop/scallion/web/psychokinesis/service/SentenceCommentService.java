package top.zerotop.scallion.web.psychokinesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.entity.SentenceComment;
import top.zerotop.scallion.web.psychokinesis.entity.SentenceCommentOperate;
import top.zerotop.scallion.web.psychokinesis.mapper.SentenceCommentMapper;
import top.zerotop.scallion.web.psychokinesis.mapper.SentenceCommentOperateMapper;

import java.util.List;

@Service
public class SentenceCommentService {
    @Autowired
    private SentenceCommentMapper commentMapper;
    @Autowired
    private SentenceCommentOperateMapper commentOperateMapper;

    public List<SentenceComment> querySentenceCommentById(long sentenceId) {
        return commentMapper.querySentenceCommentById(sentenceId);
    }

    public int saveSentenceComment(SentenceComment sentenceComment) {
        return commentMapper.saveSentenceComment(sentenceComment);
    }

    public List<SentenceCommentOperate> queryCommentOperateById(long commentId) {
        return commentOperateMapper.queryCommentOperateById(commentId);
    }

    public int saveSentenceCommentOperate(SentenceCommentOperate sentenceCommentOperate) {
        return commentOperateMapper.saveSentenceCommentOperate(sentenceCommentOperate);
    }
}

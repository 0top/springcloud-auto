package top.zerotop.scallion.web.psychokinesis.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.entity.SentenceCommentOperate;

import java.util.List;

@Mapper
public interface SentenceCommentOperateMapper {
    List<SentenceCommentOperate> queryCommentOperateById(long commentId);

    int saveSentenceCommentOperate(SentenceCommentOperate commentOperate);
}

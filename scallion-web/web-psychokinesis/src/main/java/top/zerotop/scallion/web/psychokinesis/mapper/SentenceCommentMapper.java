package top.zerotop.scallion.web.psychokinesis.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.entity.SentenceComment;

import java.util.List;

@Mapper
public interface SentenceCommentMapper {
    List<SentenceComment> querySentenceCommentById(long sentenceId);

    int saveSentenceComment(SentenceComment sentenceComment);
}

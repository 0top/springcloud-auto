package top.zerotop.scallion.web.psychokinesis.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.entity.SentenceComment;
import top.zerotop.scallion.web.psychokinesis.entity.SentenceOperate;

import java.util.List;

@Mapper
public interface SentenceOperateMapper {
    List<SentenceComment> listAll();

    int saveSentenceOperate(SentenceOperate sentenceOperate);
}

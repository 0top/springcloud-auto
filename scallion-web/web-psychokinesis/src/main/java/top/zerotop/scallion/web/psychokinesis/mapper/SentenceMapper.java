package top.zerotop.scallion.web.psychokinesis.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;

import java.util.List;

@Mapper
public interface SentenceMapper {
    List<Sentence> listAll();

    int saveSentence(Sentence sentence);
}

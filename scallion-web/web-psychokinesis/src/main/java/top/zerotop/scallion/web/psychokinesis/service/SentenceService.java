package top.zerotop.scallion.web.psychokinesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zerotop.scallion.web.psychokinesis.dto.SentenceDto;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.mapper.SentenceMapper;
import top.zerotop.scallion.web.psychokinesis.mapper.SentenceOperateMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class SentenceService {
    @Autowired
    private SentenceMapper sentenceMapper;
    @Autowired
    private SentenceOperateMapper sentenceOperateMapper;

    public List<SentenceDto> listSentence() {
        List<SentenceDto> sentenceDtos = new ArrayList<>();
        List<Sentence> sentences = sentenceMapper.listAll();
        for (Sentence sentence : sentences) {
            sentenceDtos.add(SentenceDto.from(sentence));
        }
        return sentenceDtos;
    }

    public int saveSentence(Sentence sentence) {
        return sentenceMapper.saveSentence(sentence);
    }
}

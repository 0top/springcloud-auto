package top.zerotop.scallion.web.psychokinesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zerotop.scallion.web.psychokinesis.dto.SentenceDto;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.entity.SentenceOperate;
import top.zerotop.scallion.web.psychokinesis.mapper.SentenceMapper;
import top.zerotop.scallion.web.psychokinesis.mapper.SentenceOperateMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class SummaryService {
    @Autowired
    private SentenceMapper sentenceMapper;
    @Autowired
    private SentenceOperateMapper sentenceOperateMapper;

    public void summarySentence() {
        List<Sentence> sentences = sentenceMapper.listAll();

        System.out.printf("total sentence: " + sentences.size());
    }
}

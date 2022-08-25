package top.zerotop.scallion.web.psychokinesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.mapper.SentenceMapper;

import java.util.List;

@Service
public class SentenceService {
    @Autowired
    private SentenceMapper sentenceMapper;

    public List<Sentence> listSentence() {
        return sentenceMapper.listAll();
    }
}

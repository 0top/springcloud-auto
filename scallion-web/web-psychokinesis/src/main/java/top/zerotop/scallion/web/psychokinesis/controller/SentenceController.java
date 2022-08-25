package top.zerotop.scallion.web.psychokinesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.service.SentenceService;

import java.util.List;

@RestController
@RequestMapping(value = "/sentence")
public class SentenceController {
    @Autowired
    private SentenceService sentenceService;

    @GetMapping(value = "/list")
    private List<Sentence> listSentence() {
        return sentenceService.listSentence();
    }
}

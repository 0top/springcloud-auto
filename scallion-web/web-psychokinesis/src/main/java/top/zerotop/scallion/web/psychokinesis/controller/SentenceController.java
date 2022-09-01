package top.zerotop.scallion.web.psychokinesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.service.SentenceService;

import java.util.List;

@RestController
@RequestMapping(value = "/psychokinesis")
public class SentenceController {
    @Autowired
    private SentenceService sentenceService;

    @GetMapping(value = "/sentence")
    private List<Sentence> listSentence() {
        return sentenceService.listSentence();
    }

    @PostMapping(value = "/sentence")
    private int saveSentence(@RequestBody Sentence sentence) {
        return sentenceService.saveSentence(sentence);
    }
}

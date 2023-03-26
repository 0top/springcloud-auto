package top.zerotop.scallion.web.psychokinesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.scallion.web.psychokinesis.dto.SentenceDto;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.service.SentenceService;

import java.util.List;

@RestController
@RequestMapping(value = "/sentence")
public class SentenceController {
    @Autowired
    private SentenceService sentenceService;

    @GetMapping(value = "/list")
    private Response<List<SentenceDto>> listSentence() {
        return ResponseUtil.ok(sentenceService.listSentence());
    }

    @PostMapping(value = "/save")
    private Response saveSentence(@RequestBody Sentence sentence) {
        return ResponseUtil.ok(sentenceService.saveSentence(sentence));
    }
}

package top.zerotop.scallion.web.psychokinesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zerotop.common.rest.Response;
import top.zerotop.common.rest.ResponseUtil;
import top.zerotop.scallion.web.psychokinesis.dto.SentenceDto;
import top.zerotop.scallion.web.psychokinesis.entity.Sentence;
import top.zerotop.scallion.web.psychokinesis.entity.SentenceComment;
import top.zerotop.scallion.web.psychokinesis.service.SentenceCommentService;
import top.zerotop.scallion.web.psychokinesis.service.SentenceService;

import java.util.List;

@RestController
@RequestMapping(value = "/sentence")
public class SentenceController {
    @Autowired
    private SentenceService sentenceService;
    @Autowired
    private SentenceCommentService commentService;

    @GetMapping(value = "/list")
    private Response<List<SentenceDto>> listSentence() {
        return ResponseUtil.ok(sentenceService.listSentence());
    }

    @PostMapping(value = "/save")
    private Response saveSentence(@RequestBody Sentence sentence) {
        return ResponseUtil.ok(sentenceService.saveSentence(sentence));
    }


    @GetMapping(value = "/comment/list")
    private Response<List<SentenceDto>> listSentenceComment(long sentenceId) {
        return ResponseUtil.ok(commentService.querySentenceCommentById(sentenceId));
    }

    @PostMapping(value = "/comment/save")
    private Response saveSentence(@RequestBody SentenceComment comment) {
        return ResponseUtil.ok(commentService.saveSentenceComment(comment));
    }
}

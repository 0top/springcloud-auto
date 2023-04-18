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
import top.zerotop.scallion.web.psychokinesis.service.SummaryService;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class SummaryController {
    @Autowired
    private SummaryService summaryService;

    @GetMapping(value = "/summary")
    private Response<Void> summaryData() {
        summaryService.summarySentence();
        return ResponseUtil.ok();
    }
}

package top.zerotop.scallion.web.psychokinesis.dto;

import top.zerotop.scallion.web.psychokinesis.entity.Sentence;

import java.io.Serializable;

public class SentenceDto implements Serializable {
    private long id;

    private String userId;

    private String sentence;

    private String createTime;

    private String updateTime;

    // 转发
    private long repostsCount;

    // 评论
    public long commentsCount;

    // 点赞
    private long attitudesCount;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public long getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(long repostsCount) {
        this.repostsCount = repostsCount;
    }

    public long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(long commentsCount) {
        this.commentsCount = commentsCount;
    }

    public long getAttitudesCount() {
        return attitudesCount;
    }

    public void setAttitudesCount(long attitudesCount) {
        this.attitudesCount = attitudesCount;
    }

    public static SentenceDto from(Sentence s) {
        SentenceDto dto = new SentenceDto();
        dto.setId(s.getId());
        dto.setUserId(s.getUserId());
        dto.setSentence(s.getSentence());
        dto.setCreateTime(s.getCreateTime());
        dto.setUpdateTime(s.getUpdateTime());
        return dto;
    }
}

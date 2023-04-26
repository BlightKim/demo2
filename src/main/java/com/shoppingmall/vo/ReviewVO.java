package com.shoppingmall.vo;

import java.sql.Date;

public class ReviewVO {

    private int reviewIdx;
    private String subject;
    private String writer;
    private String content;
    private String fileName	;
    private String oriName;
    private String pwd;
    private Date writeDate;
    private int hit;
    private int star;
    private int good;
    private int bad;
    public int getReviewIdx() {
        return reviewIdx;
    }
    public void setReviewIdx(int reviewIdx) {
        this.reviewIdx = reviewIdx;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getOriName() {
        return oriName;
    }
    public void setOriName(String oriName) {
        this.oriName = oriName;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public Date getWriteDate() {
        return writeDate;
    }
    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
    public int getHit() {
        return hit;
    }
    public void setHit(int hit) {
        this.hit = hit;
    }
    public int getStar() {
        return star;
    }
    public void setStar(int star) {
        this.star = star;
    }
    public int getGood() {
        return good;
    }
    public void setGood(int good) {
        this.good = good;
    }
    public int getBad() {
        return bad;
    }
    public void setBad(int bad) {
        this.bad = bad;
    }

    @Override
    public String toString() {
        return "ReviewVO [reviewIdx=" + reviewIdx + ", subject=" + subject + ", writer=" + writer + ", content="
                + content + ", fileName=" + fileName + ", oriName=" + oriName + ", pwd=" + pwd + ", writeDate="
                + writeDate + ", hit=" + hit + ", star=" + star + ", good=" + good + ", bad=" + bad + "]";
    }


}
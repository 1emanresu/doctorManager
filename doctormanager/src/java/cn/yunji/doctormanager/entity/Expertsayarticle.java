package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Expertsayarticle {
    private Integer idexpertsayarticle;

    private String articletitle;

    private Date timeofpublication;

    private String author;

    private Integer typeid;

    private String picture;

    private Integer authorid;

    private String video;

    private String contentintroduction;

    private String earlypregnancytitle;

    private String earlypregnancycontent;

    private String middlepregnancytitle;

    private String middlepregnancycontent;

    private String contenttext;

    public Integer getIdexpertsayarticle() {
        return idexpertsayarticle;
    }

    public void setIdexpertsayarticle(Integer idexpertsayarticle) {
        this.idexpertsayarticle = idexpertsayarticle;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle == null ? null : articletitle.trim();
    }

    public Date getTimeofpublication() {
        return timeofpublication;
    }

    public void setTimeofpublication(Date timeofpublication) {
        this.timeofpublication = timeofpublication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public String getContentintroduction() {
        return contentintroduction;
    }

    public void setContentintroduction(String contentintroduction) {
        this.contentintroduction = contentintroduction == null ? null : contentintroduction.trim();
    }

    public String getEarlypregnancytitle() {
        return earlypregnancytitle;
    }

    public void setEarlypregnancytitle(String earlypregnancytitle) {
        this.earlypregnancytitle = earlypregnancytitle == null ? null : earlypregnancytitle.trim();
    }

    public String getEarlypregnancycontent() {
        return earlypregnancycontent;
    }

    public void setEarlypregnancycontent(String earlypregnancycontent) {
        this.earlypregnancycontent = earlypregnancycontent == null ? null : earlypregnancycontent.trim();
    }

    public String getMiddlepregnancytitle() {
        return middlepregnancytitle;
    }

    public void setMiddlepregnancytitle(String middlepregnancytitle) {
        this.middlepregnancytitle = middlepregnancytitle == null ? null : middlepregnancytitle.trim();
    }

    public String getMiddlepregnancycontent() {
        return middlepregnancycontent;
    }

    public void setMiddlepregnancycontent(String middlepregnancycontent) {
        this.middlepregnancycontent = middlepregnancycontent == null ? null : middlepregnancycontent.trim();
    }

    public String getContenttext() {
        return contenttext;
    }

    public void setContenttext(String contenttext) {
        this.contenttext = contenttext == null ? null : contenttext.trim();
    }
}
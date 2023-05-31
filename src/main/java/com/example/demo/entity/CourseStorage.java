package com.example.demo.entity;

/**
 * @author langshixin
 * @date 2022/8/31
 */
public class CourseStorage {

    public CourseStorage() {
    }

    private String id;
    private String title;
    private String overview;
//    private String content;
//    private String shelve;
    private String createTime;
    private String minGan;
    private String keyWord;
    private String redWord;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMinGan() {
        return minGan;
    }

    public void setMinGan(String minGan) {
        this.minGan = minGan;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getRedWord() {
        return redWord;
    }

    public void setRedWord(String redWord) {
        this.redWord = redWord;
    }
}

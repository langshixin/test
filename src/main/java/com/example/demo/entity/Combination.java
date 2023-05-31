package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author langshixin
 * @date 2022/8/31
 */
@TableName("t_combination")
public class Combination {
    public Combination() {
    }

    public static void main(String[] args) {
        String a = "1234,";
        System.out.println(a.substring(0,a.length()-1));


    }

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    private String title;
    private String description;
    private String showHomePage;
    private String status;
    private String activityStartTime;
    private String activityEndTime;
    private String rule;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShowHomePage() {
        return showHomePage;
    }

    public void setShowHomePage(String showHomePage) {
        this.showHomePage = showHomePage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
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

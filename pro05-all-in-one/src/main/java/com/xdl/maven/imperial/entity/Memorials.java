package com.xdl.maven.imperial.entity;

public class Memorials {
    private Integer memorialsId;
    private String memorialsTitle;
    private String memorialsContent;
    private Integer memorialsEmp;
    private String memorialsCreateTime;
    private String feedbackTime;
    private String feedbackContent;
    private Integer memorialsStatus;
    // 员工姓名、奏折摘要数据库中没有，是为了配合页面显示
    private String memorialsEmpName;
    private String memorialsContentDigest;

    public Memorials() {
    }

    public Memorials(Integer memorialsId, String memorialsTitle, String memorialsContent, Integer memorialsEmp, String memorialsCreateTime, String feedbackTime, String feedbackContent, Integer memorialsStatus, String memorialsEmpName, String memorialsContentDigest) {
        this.memorialsId = memorialsId;
        this.memorialsTitle = memorialsTitle;
        this.memorialsContent = memorialsContent;
        this.memorialsEmp = memorialsEmp;
        this.memorialsCreateTime = memorialsCreateTime;
        this.feedbackTime = feedbackTime;
        this.feedbackContent = feedbackContent;
        this.memorialsStatus = memorialsStatus;
        this.memorialsEmpName = memorialsEmpName;
        this.memorialsContentDigest = memorialsContentDigest;
    }

    public Integer getMemorialsId() {
        return memorialsId;
    }

    public void setMemorialsId(Integer memorialsId) {
        this.memorialsId = memorialsId;
    }

    public String getMemorialsTitle() {
        return memorialsTitle;
    }

    public void setMemorialsTitle(String memorialsTitle) {
        this.memorialsTitle = memorialsTitle;
    }

    public String getMemorialsContent() {
        return memorialsContent;
    }

    public void setMemorialsContent(String memorialsContent) {
        this.memorialsContent = memorialsContent;
    }

    public Integer getMemorialsEmp() {
        return memorialsEmp;
    }

    public void setMemorialsEmp(Integer memorialsEmp) {
        this.memorialsEmp = memorialsEmp;
    }

    public String getMemorialsCreateTime() {
        return memorialsCreateTime;
    }

    public void setMemorialsCreateTime(String memorialsCreateTime) {
        this.memorialsCreateTime = memorialsCreateTime;
    }

    public String getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public Integer getMemorialsStatus() {
        return memorialsStatus;
    }

    public void setMemorialsStatus(Integer memorialsStatus) {
        this.memorialsStatus = memorialsStatus;
    }

    public String getMemorialsEmpName() {
        return memorialsEmpName;
    }

    public void setMemorialsEmpName(String memorialsEmpName) {
        this.memorialsEmpName = memorialsEmpName;
    }

    public String getMemorialsContentDigest() {
        return memorialsContentDigest;
    }

    public void setMemorialsContentDigest(String memorialsContentDigest) {
        this.memorialsContentDigest = memorialsContentDigest;
    }

    @Override
    public String toString() {
        return "Memorials{" +
                "memorialsId=" + memorialsId +
                ", memorialsTitle='" + memorialsTitle + '\'' +
                ", memorialsContent='" + memorialsContent + '\'' +
                ", memorialsEmp=" + memorialsEmp +
                ", memorialsCreateTime='" + memorialsCreateTime + '\'' +
                ", feedbackTime='" + feedbackTime + '\'' +
                ", feedbackContent='" + feedbackContent + '\'' +
                ", memorialsStatus=" + memorialsStatus +
                ", memorialsEmpName='" + memorialsEmpName + '\'' +
                ", memorialsContentDigest='" + memorialsContentDigest + '\'' +
                '}';
    }
}


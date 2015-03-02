package net.liangbo.java.tools.eventbus;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LiangBo mailto:liangbo1180@gmail.com
 * Date: 15/2/12
 * Time: 下午4:43
 */
public class PolicyIssuedEvent {


    private Date issueTime;

    private String name;

    private int status;

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PolicyIssuedEvent{" +
                "issueTime=" + issueTime +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}

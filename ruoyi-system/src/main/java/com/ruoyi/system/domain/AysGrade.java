package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生活动成绩对象 ays_grade
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
public class AysGrade extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号 */
    private String stuId;

    /** 活动id */
    private Long actId;

    /** 记录时长 */
    @Excel(name = "记录时长")
    private Long hour;

    /** 活动分数 */
    @Excel(name = "活动分数")
    private Long grade;

    public void setStuid(String stuId) 
    {
        this.stuId = stuId;
    }

    public String getStuid() 
    {
        return stuId;
    }
    public void setActid(Long actId) 
    {
        this.actId = actId;
    }

    public Long getActid() 
    {
        return actId;
    }
    public void setHour(Long hour) 
    {
        this.hour = hour;
    }

    public Long getHour() 
    {
        return hour;
    }
    public void setGrade(Long grade) 
    {
        this.grade = grade;
    }

    public Long getGrade() 
    {
        return grade;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuId", getStuid())
            .append("actId", getActid())
            .append("hour", getHour())
            .append("grade", getGrade())
            .toString();
    }
}

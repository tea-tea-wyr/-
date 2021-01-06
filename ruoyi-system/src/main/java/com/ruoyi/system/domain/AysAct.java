package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动对象 ays_act
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
public class AysAct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动id */
    private Long aid;

    /** 所属组织方id */
    private Long oid;

    /** 名称 */
    @Excel(name = "名称")
    private String aname;

    /** 主题 */
    @Excel(name = "主题")
    private String asubject;

    /** 标签类型 */
    @Excel(name = "标签类型")
    private String atype;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date astart;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date aend;

    /** 地点 */
    @Excel(name = "地点")
    private String alocation;

    /** 对象 */
    @Excel(name = "对象")
    private String aobject;

    /** 人数 */
    @Excel(name = "人数")
    private Integer anum;

    /** 分数类型 */
    @Excel(name = "分数类型")
    private String agradetype;

    /** 分数 */
    @Excel(name = "分数")
    private Integer agrade;

    public void setAid(Long aid) 
    {
        this.aid = aid;
    }

    public Long getAid() 
    {
        return aid;
    }
    public void setOid(Long oid) 
    {
        this.oid = oid;
    }

    public Long getOid() 
    {
        return oid;
    }
    public void setAname(String aname) 
    {
        this.aname = aname;
    }

    public String getAname() 
    {
        return aname;
    }
    public void setAsubject(String asubject) 
    {
        this.asubject = asubject;
    }

    public String getAsubject() 
    {
        return asubject;
    }
    public void setAtype(String atype) 
    {
        this.atype = atype;
    }

    public String getAtype() 
    {
        return atype;
    }
    public void setAstart(Date astart) 
    {
        this.astart = astart;
    }

    public Date getAstart() 
    {
        return astart;
    }
    public void setAend(Date aend) 
    {
        this.aend = aend;
    }

    public Date getAend() 
    {
        return aend;
    }
    public void setAlocation(String alocation) 
    {
        this.alocation = alocation;
    }

    public String getAlocation() 
    {
        return alocation;
    }
    public void setAobject(String aobject) 
    {
        this.aobject = aobject;
    }

    public String getAobject() 
    {
        return aobject;
    }
    public void setAnum(Integer anum) 
    {
        this.anum = anum;
    }

    public Integer getAnum() 
    {
        return anum;
    }
    public void setAgradetype(String agradetype) 
    {
        this.agradetype = agradetype;
    }

    public String getAgradetype() 
    {
        return agradetype;
    }
    public void setAgrade(Integer agrade) 
    {
        this.agrade = agrade;
    }

    public Integer getAgrade() 
    {
        return agrade;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("aid", getAid())
            .append("oid", getOid())
            .append("aname", getAname())
            .append("asubject", getAsubject())
            .append("atype", getAtype())
            .append("astart", getAstart())
            .append("aend", getAend())
            .append("alocation", getAlocation())
            .append("aobject", getAobject())
            .append("anum", getAnum())
            .append("agradetype", getAgradetype())
            .append("agrade", getAgrade())
            .toString();
    }
}

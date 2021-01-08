package com.ruoyi.common.core.domain.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生对象 ays_stu
 *
 * @author ruoyi
 * @date 2021-01-07
 */
@NoArgsConstructor
@AllArgsConstructor
public class AysStu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private AysStu aysStu;

    /** 学号 */
    @Excel(name = "学号")
    private String stuId;

    /** 密码 */
    @Excel(name = "密码")
    private String spwd;

    /** 姓名 */
    @Excel(name = "姓名")
    private String stuName;



    /** 姓名 */
    @Excel(name = "部门")
    private String deptId;

    /** 学历 */
    @Excel(name = "学历")
    private String sdegree;

    /** 学院 */
    @Excel(name = "学院")
    private String sacademy;

    /** 班级 */
    @Excel(name = "班级")
    private String sclass;

    /** 手机号 */
    @Excel(name = "手机号")
    private String snum;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String semail;

    /** 性别 */
    @Excel(name = "性别")
    private String sgender;

    /** 状态 */
    @Excel(name = "状态")
    private String sstatus;

    /** 职务 */
    @Excel(name = "职务")
    private String sjob;

    /** 用户角色 */
    @Excel(name = "用户角色")
    private String srole;

    /** 备注 */
    @Excel(name = "备注")
    private String sremark;

    /** 最后登录IP */
    @Excel(name = "最后登录IP")
    private String loginip;

    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date logintime;

    public AysStu(String stuId) {
        this.stuId=stuId;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    private SysDept dept;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds() {
        return postIds;
    }

    public void setPostIds(Long[] postIds) {
        this.postIds = postIds;
    }

    /** 角色对象 */
    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    /** 岗位组 */
    private Long[] postIds;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setStuId(String stuId)
    {
        this.stuId = stuId;
    }

    public String getStuId()
    {
        return stuId;
    }
    public void setSpwd(String spwd)
    {
        this.spwd = spwd;
    }

    public String getSpwd()
    {
        return spwd;
    }
    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public String getStuName()
    {
        return stuName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setSdegree(String sdegree)
    {
        this.sdegree = sdegree;
    }

    public String getSdegree()
    {
        return sdegree;
    }
    public void setSacademy(String sacademy)
    {
        this.sacademy = sacademy;
    }

    public String getSacademy()
    {
        return sacademy;
    }
    public void setSclass(String sclass)
    {
        this.sclass = sclass;
    }

    public String getSclass()
    {
        return sclass;
    }
    public void setSnum(String snum)
    {
        this.snum = snum;
    }

    public String getSnum()
    {
        return snum;
    }
    public void setSemail(String semail)
    {
        this.semail = semail;
    }

    public String getSemail()
    {
        return semail;
    }
    public void setSgender(String sgender)
    {
        this.sgender = sgender;
    }

    public String getSgender()
    {
        return sgender;
    }
    public void setSstatus(String sstatus)
    {
        this.sstatus = sstatus;
    }

    public String getSstatus()
    {
        return sstatus;
    }
    public void setSjob(String sjob)
    {
        this.sjob = sjob;
    }

    public String getSjob()
    {
        return sjob;
    }
    public void setSrole(String srole)
    {
        this.srole = srole;
    }

    public String getSrole()
    {
        return srole;
    }
    public void setSremark(String sremark)
    {
        this.sremark = sremark;
    }

    public String getSremark()
    {
        return sremark;
    }
    public void setLoginip(String loginip)
    {
        this.loginip = loginip;
    }

    public String getLoginip()
    {
        return loginip;
    }
    public void setLogintime(Date logintime)
    {
        this.logintime = logintime;
    }

    public Date getLogintime()
    {
        return logintime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("stuId", getStuId())
                .append("spwd", getSpwd())
                .append("stuName", getStuName())
                .append("deptId",getDeptId())
                .append("sdegree", getSdegree())
                .append("sacademy", getSacademy())
                .append("sclass", getSclass())
                .append("snum", getSnum())
                .append("semail", getSemail())
                .append("sgender", getSgender())
                .append("sstatus", getSstatus())
                .append("sjob", getSjob())
                .append("srole", getSrole())
                .append("sremark", getSremark())
                .append("loginip", getLoginip())
                .append("logintime", getLogintime())
                .append("delFlag",getDelFlag())
                .append("dept", getDept())
                .toString();
    }


}

package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统管理员对象 ays_adm
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
public class AysAdm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 账号 */
    private Long mno;

    /** 密码 */
    @Excel(name = "密码")
    private String mpwd;

    /** 昵称 */
    @Excel(name = "昵称")
    private String mnick;

    /** 角色 */
    @Excel(name = "角色")
    private String mrole;

    /** 权限 */
    @Excel(name = "权限")
    private String maccess;

    public void setMno(Long mno) 
    {
        this.mno = mno;
    }

    public Long getMno() 
    {
        return mno;
    }
    public void setMpwd(String mpwd) 
    {
        this.mpwd = mpwd;
    }

    public String getMpwd() 
    {
        return mpwd;
    }
    public void setMnick(String mnick) 
    {
        this.mnick = mnick;
    }

    public String getMnick() 
    {
        return mnick;
    }
    public void setMrole(String mrole) 
    {
        this.mrole = mrole;
    }

    public String getMrole() 
    {
        return mrole;
    }
    public void setMaccess(String maccess) 
    {
        this.maccess = maccess;
    }

    public String getMaccess() 
    {
        return maccess;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mno", getMno())
            .append("mpwd", getMpwd())
            .append("mnick", getMnick())
            .append("mrole", getMrole())
            .append("maccess", getMaccess())
            .toString();
    }
}

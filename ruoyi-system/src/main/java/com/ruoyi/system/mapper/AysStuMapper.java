package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.entity.AysStu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表 数据层
 * 
 * @author ruoyi
 */
@Repository
public interface AysStuMapper
{
    /**
     * 根据条件分页查询用户列表
     * 
     * @param aysStu 用户信息
     * @return 用户信息集合信息
     */
    public List<AysStu> selectStuList(AysStu aysStu);

    /**
     * 通过用户名查询用户
     * 
     * @param stuName 用户名
     * @return 用户对象信息
     */
    public AysStu selectStuByStuName(String stuName);

    /**
     * 通过用户ID查询用户
     * 
     * @param stuId 用户ID
     * @return 用户对象信息
     */
    public AysStu selectStuById(String stuId);

    /**
     * 新增用户信息
     * 
     * @param stu 用户信息
     * @return 结果
     */
    public int insertStu(AysStu stu);

    /**
     * 修改用户信息
     * 
     * @param stu 用户信息
     * @return 结果
     */
    public int updateStu(AysStu stu);

    /**
     * 修改用户头像
     * 
     * @param stuName 用户名
     * @param avatar 头像地址
     * @return 结果
     */
    public int updateStuAvatar(@Param("stuName") String stuName, @Param("avatar") String avatar);

    /**
     * 重置用户密码
     * 
     * @param stuName 用户名
     * @param password 密码
     * @return 结果
     */
    public int resetStuPwd(@Param("stuName") String stuName, @Param("password") String password);

    /**
     * 通过用户ID删除用户
     * 
     * @param stuId 用户ID
     * @return 结果
     */
    public int deleteStuById(String stuId);

    /**
     * 批量删除用户信息
     * 
     * @param stuIds 需要删除的用户ID
     * @return 结果
     */
    public int deleteStuByIds(String[] stuIds);

    /**
     * 校验用户名称是否唯一
     * 
     * @param stuName 用户名称
     * @return 结果
     */
    public int checkStuNameUnique(String stuName);

    /**
     * 校验手机号码是否唯一
     *
     * @param num 手机号码
     * @return 结果
     */
    public AysStu checkPhoneUnique(String num);

    /**
     * 校验email是否唯一
     *
     * @param semail 用户邮箱
     * @return 结果
     */
    public AysStu checkEmailUnique(String semail);


}

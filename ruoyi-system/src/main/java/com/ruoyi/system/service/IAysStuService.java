package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.AysStu;

import java.util.List;

/**
 * 用户 业务层
 * 
 * @author ruoyi
 */
public interface IAysStuService
{
    /**
     * 根据条件分页查询用户列表
     * 
     * @param stu 用户信息
     * @return 用户信息集合信息
     */
    public List<AysStu> selectStuList(AysStu stu);

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
     * 根据用户ID查询用户所属角色组
     * 
     * @param stuName 用户名
     * @return 结果
     */
    public String selectStuRoleGroup(String stuName);

    /**
     * 根据用户ID查询用户所属岗位组
     * 
     * @param stuName 用户名
     * @return 结果
     */
    public String selectStuPostGroup(String stuName);

    /**
     * 校验用户名称是否唯一
     * 
     * @param stuName 用户名称
     * @return 结果
     */
    public String checkStuNameUnique(String stuName);

    /**
     * 校验手机号码是否唯一
     *
     * @param stu 用户信息
     * @return 结果
     */
    public String checkPhoneUnique(AysStu stu);

    /**
     * 校验email是否唯一
     *
     * @param stu 用户信息
     * @return 结果
     */
    public String checkEmailUnique(AysStu stu);

    /**
     * 校验用户是否允许操作
     * 
     * @param stu 用户信息
     */
    public void checkStuAllowed(AysStu stu);

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
     * 修改用户状态
     * 
     * @param stu 用户信息
     * @return 结果
     */
    public int updateStuStatus(AysStu stu);

    /**
     * 修改用户基本信息
     * 
     * @param stu 用户信息
     * @return 结果
     */
    public int updateStuProfile(AysStu stu);

    /**
     * 修改用户头像
     * 
     * @param stuName 用户名
     * @param avatar 头像地址
     * @return 结果
     */
    public boolean updateStuAvatar(String stuName, String avatar);

    /**
     * 重置用户密码
     * 
     * @param stu 用户信息
     * @return 结果
     */
    public int resetPwd(AysStu stu);

    /**
     * 重置用户密码
     * 
     * @param stuName 用户名
     * @param password 密码
     * @return 结果
     */
    public int resetStuPwd(String stuName, String password);

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
     * 导入用户数据
     * 
     * @param stuList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importStu(List<AysStu> stuList, Boolean isUpdateSupport, String operName);


}

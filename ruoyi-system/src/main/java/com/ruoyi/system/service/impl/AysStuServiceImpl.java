package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.AysStu;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysPost;
//import com.ruoyi.system.domain.AysStuPost;
//import com.ruoyi.system.domain.AysStuRole;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.IAysStuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class AysStuServiceImpl implements IAysStuService
{
    private static final Logger log = LoggerFactory.getLogger(AysStuServiceImpl.class);

    @Autowired
    private AysStuMapper stuMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysPostMapper postMapper;

//    @Autowired
//    private AysStuRoleMapper stuRoleMapper;
//
//    @Autowired
//    private AysStuPostMapper stuPostMapper;

    @Autowired
    private ISysConfigService configService;
    private Object StuConstants;

    /**
     * 根据条件分页查询用户列表
     * 
     * @param stu 用户信息
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", stuAlias = "u")
    public List<AysStu> selectStuList(AysStu stu)
    {
        return stuMapper.selectStuList(stu);
    }

    /**
     * 通过用户名查询用户
     * 
     * @param stuName 用户名
     * @return 用户对象信息
     */
    @Override
    public AysStu selectStuByStuName(String stuName)
    {
        return stuMapper.selectStuByStuName(stuName);
    }

    /**
     * 通过用户ID查询用户
     * 
     * @param stuId 用户ID
     * @return 用户对象信息
     */
    @Override
    public AysStu selectStuById(String stuId)
    {
        return stuMapper.selectStuById(stuId);
    }

    @Override
    public String selectStuRoleGroup(String stuName) {
        return null;
    }

    @Override
    public String selectStuPostGroup(String stuName) {
        return null;
    }

    /**
     * 查询用户所属角色组
     * 
     * @param stuName 用户名
     * @return 结果
     */
//    @Override
//    public String selectStuRoleGroup(String stuName)
//    {
//        List<SysRole> list = roleMapper.selectRolesByStuName(stuName);
//        StringBuffer idsStr = new StringBuffer();
//        for (SysRole role : list)
//        {
//            idsStr.append(role.getRoleName()).append(",");
//        }
//        if (StringUtils.isNotEmpty(idsStr.toString()))
//        {
//            return idsStr.substring(0, idsStr.length() - 1);
//        }
//        return idsStr.toString();
//    }

    /**
     * 查询用户所属岗位组
     * 
     * @param stuName 用户名
     * @return 结果
     */
//    @Override
//    public String selectStuPostGroup(String stuName)
//    {
//        List<SysPost> list = postMapper.selectPostsByStuName(stuName);
//        StringBuffer idsStr = new StringBuffer();
//        for (SysPost post : list)
//        {
//            idsStr.append(post.getPostName()).append(",");
//        }
//        if (StringUtils.isNotEmpty(idsStr.toString()))
//        {
//            return idsStr.substring(0, idsStr.length() - 1);
//        }
//        return idsStr.toString();
//    }

    /**
     * 校验用户名称是否唯一
     * 
     * @param stuName 用户名称
     * @return 结果
     */
    @Override
    public String checkStuNameUnique(String stuName)
    {
        int count = stuMapper.checkStuNameUnique(stuName);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param stu 用户信息
     * @return
     */
    @Override
    public String checkPhoneUnique(AysStu stu)
    {
        Long stuId = StringUtils.isNull(stu.getStuId()) ? -1L : Long.valueOf(stu.getStuId());
        AysStu info = stuMapper.checkPhoneUnique(stu.getSnum());
        if (StringUtils.isNotNull(info) && Long.valueOf(info.getStuId()) != stuId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param stu 用户信息
     * @return
     */
    @Override
    public String checkEmailUnique(AysStu stu)
    {
        Long stuId = StringUtils.isNull(stu.getStuId()) ? -1L : Long.valueOf(stu.getStuId());
        AysStu info = stuMapper.checkEmailUnique(stu.getSemail());
        if (StringUtils.isNotNull(info) && Long.valueOf(info.getStuId()) != stuId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public void checkStuAllowed(AysStu stu) {

    }

    /**
     * 校验用户是否允许操作
     * 
     * @param stu 用户信息
     */
//    @Override
//    public void checkStuAllowed(AysStu stu)
//    {
//        if (StringUtils.isNotNull(stu.getStuId()) && stu.isAdmin())
//        {
//            throw new CustomException("不允许操作超级管理员用户");
//        }
//    }

    /**
     * 新增保存用户信息
     * 
     * @param stu 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertStu(AysStu stu)
    {
        // 新增用户信息
        int rows = stuMapper.insertStu(stu);
        // 新增用户岗位关联
//        insertStuPost(stu);
//        // 新增用户与角色管理
//        insertStuRole(stu);
        return rows;
    }

//    @Override
//    public int updateStu(AysStu stu) {
//        return 0;
//    }

    /**
     * 修改保存用户信息
     * 
     * @param stu 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateStu(AysStu stu)
    {
        String stuId = stu.getStuId();
        // 删除用户与角色关联
//        stuRoleMapper.deleteStuRoleByStuId(stuId);
//        // 新增用户与角色管理
//        insertStuRole(stu);
//        // 删除用户与岗位关联
//        stuPostMapper.deleteStuPostByStuId(stuId);
//        // 新增用户与岗位管理
//        insertStuPost(stu);
        return stuMapper.updateStu(stu);
    }

    /**
     * 修改用户状态
     * 
     * @param stu 用户信息
     * @return 结果
     */
    @Override
    public int updateStuStatus(AysStu stu)
    {
        return stuMapper.updateStu(stu);
    }

    /**
     * 修改用户基本信息
     * 
     * @param stu 用户信息
     * @return 结果
     */
    @Override
    public int updateStuProfile(AysStu stu)
    {
        return stuMapper.updateStu(stu);
    }

    /**
     * 修改用户头像
     * 
     * @param stuName 用户名
     * @param avatar 头像地址
     * @return 结果
     */
    @Override
    public boolean updateStuAvatar(String stuName, String avatar)
    {
        return stuMapper.updateStuAvatar(stuName, avatar) > 0;
    }

    /**
     * 重置用户密码
     * 
     * @param stu 用户信息
     * @return 结果
     */
    @Override
    public int resetPwd(AysStu stu)
    {
        return stuMapper.updateStu(stu);
    }

    /**
     * 重置用户密码
     * 
     * @param stuName 用户名
     * @param password 密码
     * @return 结果
     */
    @Override
    public int resetStuPwd(String stuName, String password)
    {
        return stuMapper.resetStuPwd(stuName, password);
    }



    /**
     * 新增用户角色信息
     * 
     * @param stu 用户对象
     */
//    public void insertStuRole(AysStu stu)
//    {
//        Long[] roles = stu.getRoleIds();
//        if (StringUtils.isNotNull(roles))
//        {
//            // 新增用户与角色管理
//            List<AysStuRole> list = new ArrayList<AysStuRole>();
//            for (Long roleId : roles)
//            {
//                AysStuRole ur = new AysStuRole();
//                ur.setStuId(stu.getStuId());
//                ur.setRoleId(roleId);
//                list.add(ur);
//            }
//            if (list.size() > 0)
//            {
//                stuRoleMapper.batchStuRole(list);
//            }
//        }
//    }

    /**
     * 新增用户岗位信息
     * 
     * @param stu 用户对象
     */
//    public void insertStuPost(AysStu stu)
//    {
//        Long[] posts = stu.getPostIds();
//        if (StringUtils.isNotNull(posts))
//        {
//            // 新增用户与岗位管理
//            List<AysStuPost> list = new ArrayList<AysStuPost>();
//            for (Long postId : posts)
//            {
//                AysStuPost up = new AysStuPost();
//                up.setStuId(stu.getStuId());
//                up.setPostId(postId);
//                list.add(up);
//            }
//            if (list.size() > 0)
//            {
//                stuPostMapper.batchStuPost(list);
//            }
//        }
//    }

    /**
     * 通过用户ID删除用户
     * 
     * @param stuId 用户ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteStuById(String stuId)
    {
//        // 删除用户与角色关联
//        stuRoleMapper.deleteStuRoleByStuId(stuId);
//        // 删除用户与岗位表
//        stuPostMapper.deleteStuPostByStuId(stuId);
        return stuMapper.deleteStuById(stuId);
    }

    /**
     * 批量删除用户信息
     * 
     * @param stuIds 需要删除的用户ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteStuByIds(String[] stuIds)
    {
        for (String stuId : stuIds)
        {
            checkStuAllowed(new AysStu(stuId));
        }
//        // 删除用户与角色关联
//        stuRoleMapper.deleteStuRole(stuIds);
//        // 删除用户与岗位关联
//        stuPostMapper.deleteStuPost(stuIds);
        return stuMapper.deleteStuByIds(stuIds);
    }

    @Override
    public String importStu(List<AysStu> stuList, Boolean isUpdateSupport, String operName) {
        return null;
    }

    /**
     * 导入用户数据
     * 
     * @param stuList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
//    @Override
//    public String importStu(List<AysStu> stuList, Boolean isUpdateSupport, String operName)
//    {
//        if (StringUtils.isNull(stuList) || stuList.size() == 0)
//        {
//            throw new CustomException("导入用户数据不能为空！");
//        }
//        int successNum = 0;
//        int failureNum = 0;
//        StringBuilder successMsg = new StringBuilder();
//        StringBuilder failureMsg = new StringBuilder();
//        String password = configService.selectConfigByKey("sys.stu.initPassword");
//        for (AysStu stu : stuList)
//        {
//            try
//            {
//                // 验证是否存在这个用户
//                AysStu u = stuMapper.selectStuByStuName(stu.getStuName());
//                if (StringUtils.isNull(u))
//                {
//                    stu.setPassword(SecurityUtils.encryptPassword(password));
//                    stu.setCreateBy(operName);
//                    this.insertStu(stu);
//                    successNum++;
//                    successMsg.append("<br/>" + successNum + "、账号 " + stu.getStuName() + " 导入成功");
//                }
//                else if (isUpdateSupport)
//                {
//                    stu.setUpdateBy(operName);
//                    this.updateStu(stu);
//                    successNum++;
//                    successMsg.append("<br/>" + successNum + "、账号 " + stu.getStuName() + " 更新成功");
//                }
//                else
//                {
//                    failureNum++;
//                    failureMsg.append("<br/>" + failureNum + "、账号 " + stu.getStuName() + " 已存在");
//                }
//            }
//            catch (Exception e)
//            {
//                failureNum++;
//                String msg = "<br/>" + failureNum + "、账号 " + stu.getStuName() + " 导入失败：";
//                failureMsg.append(msg + e.getMessage());
//                log.error(msg, e);
//            }
//        }
//        if (failureNum > 0)
//        {
//            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
//            throw new CustomException(failureMsg.toString());
//        }
//        else
//        {
//            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
//        }
//        return successMsg.toString();
//    }
}

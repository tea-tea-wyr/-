package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.AysOrg;
//import com.ruoyi.common.core.domain.entity.AysRole;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.mapper.AysOrgMapper;
//import com.ruoyi.system.mapper.AysRoleMapper;
import com.ruoyi.system.service.IAysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门管理 服务实现
 * 
 * @author ruoyi
 */
@Service
public class AysOrgServiceImpl implements IAysOrgService
{
    @Autowired
    private AysOrgMapper orgMapper;

//    @Autowired
//    private AysRoleMapper roleMapper;

    /**
     * 查询部门管理数据
     * 
     * @param org 部门信息
     * @return 部门信息集合
     */
    @Override
    @DataScope(orgAlias = "d")
    public List<AysOrg> selectOrgList(AysOrg org)
    {
        return orgMapper.selectOrgList(org);
    }

    /**
     * 构建前端所需要树结构
     * 
     * @param orgs 部门列表
     * @return 树结构列表
     */
    @Override
    public List<AysOrg> buildOrgTree(List<AysOrg> orgs)
    {
        List<AysOrg> returnList = new ArrayList<AysOrg>();
        List<Long> tempList = new ArrayList<Long>();
        for (AysOrg org : orgs)
        {
            tempList.add(org.getOrgId());
        }
        for (Iterator<AysOrg> iterator = orgs.iterator(); iterator.hasNext();)
        {
            AysOrg org = (AysOrg) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(org.getParentId()))
            {
                recursionFn(orgs, org);
                returnList.add(org);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = orgs;
        }
        return returnList;
    }

    /**
     * 构建前端所需要下拉树结构
     * 
     * @param orgs 部门列表
     * @return 下拉树结构列表
     */
    @Override
    public List<TreeSelect> buildOrgTreeSelect(List<AysOrg> orgs)
    {
        List<AysOrg> orgTrees = buildOrgTree(orgs);
        return orgTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    @Override
    public List<Integer> selectOrgListByRoleId(Long roleId) {
        return null;
    }

    /**
     * 根据角色ID查询部门树信息
     * 
     * @param roleId 角色ID
     * @return 选中部门列表
     */
//    @Override
//    public List<Integer> selectOrgListByRoleId(Long roleId)
//    {
//        AysRole role = roleMapper.selectRoleById(roleId);
//        return orgMapper.selectOrgListByRoleId(roleId, role.isOrgCheckStrictly());
//    }

    /**
     * 根据部门ID查询信息
     * 
     * @param orgId 部门ID
     * @return 部门信息
     */
    @Override
    public AysOrg selectOrgById(Long orgId)
    {
        return orgMapper.selectOrgById(orgId);
    }

    /**
     * 根据ID查询所有子部门（正常状态）
     * 
     * @param orgId 部门ID
     * @return 子部门数
     */
    @Override
    public int selectNormalChildrenOrgById(Long orgId)
    {
        return orgMapper.selectNormalChildrenOrgById(orgId);
    }

    /**
     * 是否存在子节点
     * 
     * @param orgId 部门ID
     * @return 结果
     */
    @Override
    public boolean hasChildByOrgId(Long orgId)
    {
        int result = orgMapper.hasChildByOrgId(orgId);
        return result > 0 ? true : false;
    }

    /**
     * 查询部门是否存在用户
     * 
     * @param orgId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkOrgExistUser(Long orgId)
    {
        int result = orgMapper.checkOrgExistUser(orgId);
        return result > 0 ? true : false;
    }

    /**
     * 校验部门名称是否唯一
     * 
     * @param org 部门信息
     * @return 结果
     */
    @Override
    public String checkOrgNameUnique(AysOrg org)
    {
        Long orgId = StringUtils.isNull(org.getOrgId()) ? -1L : org.getOrgId();
        AysOrg info = orgMapper.checkOrgNameUnique(org.getOrgName(), org.getParentId());
        if (StringUtils.isNotNull(info) && info.getOrgId().longValue() != orgId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 新增保存部门信息
     * 
     * @param org 部门信息
     * @return 结果
     */
    @Override
    public int insertOrg(AysOrg org)
    {
        AysOrg info = orgMapper.selectOrgById(org.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if (!UserConstants.DEPT_NORMAL.equals(info.getStatus()))
        {
            throw new CustomException("部门停用，不允许新增");
        }
        org.setAncestors(info.getAncestors() + "," + org.getParentId());
        return orgMapper.insertOrg(org);
    }

    /**
     * 修改保存部门信息
     * 
     * @param org 部门信息
     * @return 结果
     */
    @Override
    public int updateOrg(AysOrg org)
    {
        AysOrg newParentOrg = orgMapper.selectOrgById(org.getParentId());
        AysOrg oldOrg = orgMapper.selectOrgById(org.getOrgId());
        if (StringUtils.isNotNull(newParentOrg) && StringUtils.isNotNull(oldOrg))
        {
            String newAncestors = newParentOrg.getAncestors() + "," + newParentOrg.getOrgId();
            String oldAncestors = oldOrg.getAncestors();
            org.setAncestors(newAncestors);
            updateOrgChildren(org.getOrgId(), newAncestors, oldAncestors);
        }
        int result = orgMapper.updateOrg(org);
        if (UserConstants.DEPT_NORMAL.equals(org.getStatus()))
        {
            // 如果该部门是启用状态，则启用该部门的所有上级部门
            updateParentOrgStatus(org);
        }
        return result;
    }

    /**
     * 修改该部门的父级部门状态
     * 
     * @param org 当前部门
     */
    private void updateParentOrgStatus(AysOrg org)
    {
        String updateBy = org.getUpdateBy();
        org = orgMapper.selectOrgById(org.getOrgId());
        org.setUpdateBy(updateBy);
        orgMapper.updateOrgStatus(org);
    }

    /**
     * 修改子元素关系
     * 
     * @param orgId 被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateOrgChildren(Long orgId, String newAncestors, String oldAncestors)
    {
        List<AysOrg> children = orgMapper.selectChildrenOrgById(orgId);
        for (AysOrg child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            orgMapper.updateOrgChildren(children);
        }
    }

    /**
     * 删除部门管理信息
     * 
     * @param orgId 部门ID
     * @return 结果
     */
    @Override
    public int deleteOrgById(Long orgId)
    {
        return orgMapper.deleteOrgById(orgId);
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<AysOrg> list, AysOrg t)
    {
        // 得到子节点列表
        List<AysOrg> childList = getChildList(list, t);
        t.setChildren(childList);
        for (AysOrg tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<AysOrg> getChildList(List<AysOrg> list, AysOrg t)
    {
        List<AysOrg> tlist = new ArrayList<AysOrg>();
        Iterator<AysOrg> it = list.iterator();
        while (it.hasNext())
        {
            AysOrg n = (AysOrg) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getOrgId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<AysOrg> list, AysOrg t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}

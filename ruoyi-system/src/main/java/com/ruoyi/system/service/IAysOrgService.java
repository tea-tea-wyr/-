package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.AysOrg;

import java.util.List;

/**
 * 部门管理 服务层
 * 
 * @author ruoyi
 */
public interface IAysOrgService
{
    /**
     * 查询部门管理数据
     * 
     * @param org 部门信息
     * @return 部门信息集合
     */
    public List<AysOrg> selectOrgList(AysOrg org);

    /**
     * 构建前端所需要树结构
     * 
     * @param orgs 部门列表
     * @return 树结构列表
     */
    public List<AysOrg> buildOrgTree(List<AysOrg> orgs);

    /**
     * 构建前端所需要下拉树结构
     * 
     * @param orgs 部门列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildOrgTreeSelect(List<AysOrg> orgs);

    /**
     * 根据角色ID查询部门树信息
     * 
     * @param roleId 角色ID
     * @return 选中部门列表
     */
    public List<Integer> selectOrgListByRoleId(Long roleId);

    /**
     * 根据部门ID查询信息
     * 
     * @param orgId 部门ID
     * @return 部门信息
     */
    public AysOrg selectOrgById(Long orgId);

    /**
     * 根据ID查询所有子部门（正常状态）
     * 
     * @param orgId 部门ID
     * @return 子部门数
     */
    public int selectNormalChildrenOrgById(Long orgId);

    /**
     * 是否存在部门子节点
     * 
     * @param orgId 部门ID
     * @return 结果
     */
    public boolean hasChildByOrgId(Long orgId);

    /**
     * 查询部门是否存在用户
     * 
     * @param orgId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkOrgExistUser(Long orgId);

    /**
     * 校验部门名称是否唯一
     * 
     * @param org 部门信息
     * @return 结果
     */
    public String checkOrgNameUnique(AysOrg org);

    /**
     * 新增保存部门信息
     * 
     * @param org 部门信息
     * @return 结果
     */
    public int insertOrg(AysOrg org);

    /**
     * 修改保存部门信息
     * 
     * @param org 部门信息
     * @return 结果
     */
    public int updateOrg(AysOrg org);

    /**
     * 删除部门管理信息
     * 
     * @param orgId 部门ID
     * @return 结果
     */
    public int deleteOrgById(Long orgId);
}

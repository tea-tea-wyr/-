package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.entity.AysOrg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门管理 数据层
 * 
 * @author ruoyi
 */
public interface AysOrgMapper
{
    /**
     * 查询部门管理数据
     * 
     * @param org 部门信息
     * @return 部门信息集合
     */
    public List<AysOrg> selectOrgList(AysOrg org);

    /**
     * 根据角色ID查询部门树信息
     * 
     * @param roleId 角色ID
     * @param orgCheckStrictly 部门树选择项是否关联显示
     * @return 选中部门列表
     */
    public List<Integer> selectOrgListByRoleId(@Param("roleId") Long roleId, @Param("orgCheckStrictly") boolean orgCheckStrictly);

    /**
     * 根据部门ID查询信息
     * 
     * @param orgId 部门ID
     * @return 部门信息
     */
    public AysOrg selectOrgById(Long orgId);

    /**
     * 根据ID查询所有子部门
     * 
     * @param orgId 部门ID
     * @return 部门列表
     */
    public List<AysOrg> selectChildrenOrgById(Long orgId);

    /**
     * 根据ID查询所有子部门（正常状态）
     * 
     * @param orgId 部门ID
     * @return 子部门数
     */
    public int selectNormalChildrenOrgById(Long orgId);

    /**
     * 是否存在子节点
     * 
     * @param orgId 部门ID
     * @return 结果
     */
    public int hasChildByOrgId(Long orgId);

    /**
     * 查询部门是否存在用户
     * 
     * @param orgId 部门ID
     * @return 结果
     */
    public int checkOrgExistUser(Long orgId);

    /**
     * 校验部门名称是否唯一
     * 
     * @param orgName 部门名称
     * @param parentId 父部门ID
     * @return 结果
     */
    public AysOrg checkOrgNameUnique(@Param("orgName") String orgName, @Param("parentId") Long parentId);

    /**
     * 新增部门信息
     * 
     * @param org 部门信息
     * @return 结果
     */
    public int insertOrg(AysOrg org);

    /**
     * 修改部门信息
     * 
     * @param org 部门信息
     * @return 结果
     */
    public int updateOrg(AysOrg org);

    /**
     * 修改所在部门的父级部门状态
     * 
     * @param org 部门
     */
    public void updateOrgStatus(AysOrg org);

    /**
     * 修改子元素关系
     * 
     * @param orgs 子元素
     * @return 结果
     */
    public int updateOrgChildren(@Param("orgs") List<AysOrg> orgs);

    /**
     * 删除部门管理信息
     * 
     * @param orgId 部门ID
     * @return 结果
     */
    public int deleteOrgById(Long orgId);
}

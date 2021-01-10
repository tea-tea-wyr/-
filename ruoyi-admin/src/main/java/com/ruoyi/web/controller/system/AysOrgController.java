package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.AysOrg;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.IAysOrgService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * 部门信息
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/org")
public class AysOrgController extends BaseController
{
    @Autowired
    private IAysOrgService orgService;

    /**
     * 获取部门列表
     */
    @PreAuthorize("@ss.hasPermi('system:org:list')")
    @GetMapping("/list")
    public AjaxResult list(AysOrg org)
    {
        List<AysOrg> orgs = orgService.selectOrgList(org);
        return AjaxResult.success(orgs);
    }

    /**
     * 查询部门列表（排除节点）
     */
    @PreAuthorize("@ss.hasPermi('system:org:list')")
    @GetMapping("/list/exclude/{orgId}")
    public AjaxResult excludeChild(@PathVariable(value = "orgId", required = false) Long orgId)
    {
        List<AysOrg> orgs = orgService.selectOrgList(new AysOrg());
        Iterator<AysOrg> it = orgs.iterator();
        while (it.hasNext())
        {
            AysOrg d = (AysOrg) it.next();
            if (d.getOrgId().intValue() == orgId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), orgId + ""))
            {
                it.remove();
            }
        }
        return AjaxResult.success(orgs);
    }

    /**
     * 根据部门编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:org:query')")
    @GetMapping(value = "/{orgId}")
    public AjaxResult getInfo(@PathVariable Long orgId)
    {
        return AjaxResult.success(orgService.selectOrgById(orgId));
    }

    /**
     * 获取部门下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(AysOrg org)
    {
        List<AysOrg> orgs = orgService.selectOrgList(org);
        return AjaxResult.success(orgService.buildOrgTreeSelect(orgs));
    }

    /**
     * 加载对应角色部门列表树
     */
    @GetMapping(value = "/roleOrgTreeselect/{roleId}")
    public AjaxResult roleOrgTreeselect(@PathVariable("roleId") Long roleId)
    {
        List<AysOrg> orgs = orgService.selectOrgList(new AysOrg());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", orgService.selectOrgListByRoleId(roleId));
        ajax.put("orgs", orgService.buildOrgTreeSelect(orgs));
        return ajax;
    }

    /**
     * 新增部门
     */
    @PreAuthorize("@ss.hasPermi('system:org:add')")
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody AysOrg org)
    {
        if (UserConstants.NOT_UNIQUE.equals(orgService.checkOrgNameUnique(org)))
        {
            return AjaxResult.error("新增部门'" + org.getOrgName() + "'失败，部门名称已存在");
        }
        org.setCreateBy(SecurityUtils.getUsername());
        return toAjax(orgService.insertOrg(org));
    }

    /**
     * 修改部门
     */
    @PreAuthorize("@ss.hasPermi('system:org:edit')")
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody AysOrg org)
    {
        if (UserConstants.NOT_UNIQUE.equals(orgService.checkOrgNameUnique(org)))
        {
            return AjaxResult.error("修改部门'" + org.getOrgName() + "'失败，部门名称已存在");
        }
        else if (org.getParentId().equals(org.getOrgId()))
        {
            return AjaxResult.error("修改部门'" + org.getOrgName() + "'失败，上级部门不能是自己");
        }
        else if (StringUtils.equals(UserConstants.DEPT_DISABLE, org.getStatus())
                && orgService.selectNormalChildrenOrgById(org.getOrgId()) > 0)
        {
            return AjaxResult.error("该部门包含未停用的子部门！");
        }
        org.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(orgService.updateOrg(org));
    }

    /**
     * 删除部门
     */
    @PreAuthorize("@ss.hasPermi('system:org:remove')")
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{orgId}")
    public AjaxResult remove(@PathVariable Long orgId)
    {
        if (orgService.hasChildByOrgId(orgId))
        {
            return AjaxResult.error("存在下级部门,不允许删除");
        }
        if (orgService.checkOrgExistUser(orgId))
        {
            return AjaxResult.error("部门存在用户,不允许删除");
        }
        return toAjax(orgService.deleteOrgById(orgId));
    }
}

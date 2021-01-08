package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.domain.entity.AysAct;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.IAysActService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动Controller
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/act")
public class AysActController extends BaseController
{
    @Autowired
    private IAysActService aysActService;

    /**
     * 查询活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:act:list')")
    @GetMapping("/list")
    public TableDataInfo list(AysAct aysAct)
    {
        startPage();
        List<AysAct> list = aysActService.selectAysActList(aysAct);
        return getDataTable(list);
    }

    /**
     * 导出活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:act:export')")
    @Log(title = "活动", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AysAct aysAct)
    {
        List<AysAct> list = aysActService.selectAysActList(aysAct);
        ExcelUtil<AysAct> util = new ExcelUtil<AysAct>(AysAct.class);
        return util.exportExcel(list, "act");
    }

    /**
     * 获取活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:act:query')")
    @GetMapping(value = "/{aid}")
    public AjaxResult getInfo(@PathVariable("aid") Long aid)
    {
        return AjaxResult.success(aysActService.selectAysActById(aid));
    }

    /**
     * 新增活动
     */
    @PreAuthorize("@ss.hasPermi('system:act:add')")
    @Log(title = "活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AysAct aysAct)
    {
        return toAjax(aysActService.insertAysAct(aysAct));
    }

    /**
     * 修改活动
     */
    @PreAuthorize("@ss.hasPermi('system:act:edit')")
    @Log(title = "活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AysAct aysAct)
    {
        return toAjax(aysActService.updateAysAct(aysAct));
    }

    /**
     * 删除活动
     */
    @PreAuthorize("@ss.hasPermi('system:act:remove')")
    @Log(title = "活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{aids}")
    public AjaxResult remove(@PathVariable Long[] aids)
    {
        return toAjax(aysActService.deleteAysActByIds(aids));
    }
}

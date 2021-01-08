package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.domain.entity.AysStu;
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
import com.ruoyi.system.service.IAysStuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动Controller
 *
 * @author ruoyi
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/stu")
public class AysStuController extends BaseController
{
    @Autowired
    private IAysStuService stuService;

    /**
     * 查询活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:stu:list')")
    @GetMapping("/list")
    public TableDataInfo list(AysStu aysStu)
    {
        startPage();
        List<AysStu> list = stuService.selectStuList(aysStu);
        return getDataTable(list);
    }

    /**
     * 导出活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:stu:export')")
    @Log(title = "活动", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AysStu aysStu)
    {
        List<AysStu> list = stuService.selectStuList(aysStu);
        ExcelUtil<AysStu> util = new ExcelUtil<AysStu>(AysStu.class);
        return util.exportExcel(list, "stu");
    }

    /**
     * 获取活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:stu:query')")
    @GetMapping(value = "/{stuId}")
    public AjaxResult getInfo(@PathVariable("stuId") String stuId)
    {
        return AjaxResult.success(stuService.selectStuById(stuId));
    }

    /**
     * 新增活动
     */
    @PreAuthorize("@ss.hasPermi('system:stu:add')")
    @Log(title = "活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AysStu aysStu)
    {
        return toAjax(stuService.insertStu(aysStu));
    }

    /**
     * 修改活动
     */
    @PreAuthorize("@ss.hasPermi('system:stu:edit')")
    @Log(title = "活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AysStu aysStu)
    {
        return toAjax(stuService.updateStu(aysStu));
    }

    /**
     * 删除活动
     */
    @PreAuthorize("@ss.hasPermi('system:stu:remove')")
    @Log(title = "活动", businessType = BusinessType.DELETE)
    @DeleteMapping("/{stuIds}")
    public AjaxResult remove(@PathVariable String[] stuIds)
    {
        return toAjax(stuService.deleteStuByIds(stuIds));
    }
}

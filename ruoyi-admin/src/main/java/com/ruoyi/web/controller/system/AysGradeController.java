package com.ruoyi.web.controller.system;

import java.util.List;


import org.apache.ibatis.annotations.Param;
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
import com.ruoyi.system.domain.AysGrade;
import com.ruoyi.system.service.IAysGradeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生活动成绩Controller
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
@RestController
@RequestMapping("/system/grade")
public class AysGradeController extends BaseController
{
    @Autowired
    private IAysGradeService aysGradeService;

    /**
     * 查询学生活动成绩列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:list')")
    @GetMapping("/list")
    public TableDataInfo list(AysGrade aysGrade)
    {
        startPage();
        List<AysGrade> list = aysGradeService.selectAysGradeList(aysGrade);
        return getDataTable(list);
    }

    /**
     * 导出学生活动成绩列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:export')")
    @Log(title = "学生活动成绩", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AysGrade aysGrade)
    {
        List<AysGrade> list = aysGradeService.selectAysGradeList(aysGrade);
        ExcelUtil<AysGrade> util = new ExcelUtil<AysGrade>(AysGrade.class);
        return util.exportExcel(list, "grade");
    }

    /**
     * 获取学生活动成绩详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:query')")
    @GetMapping(value = "/{stuId}")
    public AjaxResult getInfo(@PathVariable("stuId") String stuId)
    {
        return AjaxResult.success(aysGradeService.selectAysGradeById(stuId));
    }

    /**
     * 新增学生活动成绩
     */
    @PreAuthorize("@ss.hasPermi('system:grade:add')")
    @Log(title = "学生活动成绩", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AysGrade aysGrade)
    {
        return toAjax(aysGradeService.insertAysGrade(aysGrade));
    }

    /**
     * 修改学生活动成绩
     */
    @PreAuthorize("@ss.hasPermi('system:grade:edit')")
    @Log(title = "学生活动成绩", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AysGrade aysGrade)
    {
        return toAjax(aysGradeService.updateAysGrade(aysGrade));
    }

    /**
     * 删除学生活动成绩
     */
//    @PreAuthorize("@ss.hasPermi('system:grade:remove')")
//    @Log(title = "学生活动成绩", businessType = BusinessType.DELETE)
//	@DeleteMapping("/{stuIds}")
//    public AjaxResult remove(@PathVariable String[] stuIds,@PathVariable String[] actIds)
//    {
//        return toAjax(aysGradeService.deleteAysGradeByIds(stuIds,actIds));
//    }
//    @PreAuthorize("@ss.hasPermi('system:grade:remove')")
//    @Log(title = "学生活动成绩", businessType = BusinessType.DELETE)
//    @DeleteMapping
//    public AjaxResult remove(@Param("stuId") String stuId, @Param("actId") Long actId)
//    {
//        System.out.println(stuId);
//        System.out.println(actId);
//        return toAjax(aysGradeService.deleteAysGradeById(stuId,actId));
//    }

    @PreAuthorize("@ss.hasPermi('system:grade:remove')")
    @Log(title = "学生活动成绩", businessType = BusinessType.DELETE)
    @DeleteMapping
    public AjaxResult remove(@RequestBody AysGrade aysGrade)
    {

        return toAjax(aysGradeService.deleteAysGradeById(aysGrade));
    }

//    @PreAuthorize("@ss.hasPermi('system:grade:remove')")
//    @Log(title = "学生活动成绩", businessType = BusinessType.DELETE)
//	@DeleteMapping
//    public AjaxResult remove(@RequestBody AysGrade[] aysGrades)
//    {
//        return toAjax(aysGradeService.deleteAysGradeByIds(aysGrades));
//    }
}

package com.ruoyi.system.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AysGradeMapper;
import com.ruoyi.system.domain.AysGrade;
import com.ruoyi.system.service.IAysGradeService;

/**
 * 学生活动成绩Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
@Service
public class AysGradeServiceImpl implements IAysGradeService 
{
    @Autowired
    private AysGradeMapper aysGradeMapper;

    /**
     * 查询学生活动成绩
     * 
     * @param stuId 学生活动成绩ID
     * @return 学生活动成绩
     */
    @Override
    public AysGrade selectAysGradeById(String stuId)
    {
        return aysGradeMapper.selectAysGradeById(stuId);
    }

    /**
     * 查询学生活动成绩列表
     * 
     * @param aysGrade 学生活动成绩
     * @return 学生活动成绩
     */
    @Override
    public List<AysGrade> selectAysGradeList(AysGrade aysGrade)
    {
        return aysGradeMapper.selectAysGradeList(aysGrade);
    }

    /**
     * 新增学生活动成绩
     * 
     * @param aysGrade 学生活动成绩
     * @return 结果
     */
    @Override
    public int insertAysGrade(AysGrade aysGrade)
    {
        return aysGradeMapper.insertAysGrade(aysGrade);
    }

    /**
     * 修改学生活动成绩
     * 
     * @param aysGrade 学生活动成绩
     * @return 结果
     */
    @Override
    public int updateAysGrade(AysGrade aysGrade)
    {
        return aysGradeMapper.updateAysGrade(aysGrade);
    }

//    /**
//     * 批量删除学生活动成绩
//     *
//     * @param stuIds 需要删除的学生活动成绩ID
//     * @return 结果
//     */
//    @Override
//    public int deleteAysGradeByIds(String[] stuIds)
//    {
//        return aysGradeMapper.deleteAysGradeByIds(stuIds);
//    }
    /**
     * 批量删除学生活动成绩
     *
     * @param aysGrades 需要删除的学生活动成绩ID
     * @return 结果
     */
    @Override
    public int deleteAysGradeByIds(AysGrade[] aysGrades)
    {
        return aysGradeMapper.deleteAysGradeByIds(aysGrades);
    }

    /**
     * 删除学生活动成绩信息
     * 
     * @param stuId 学生活动成绩ID
     * @return 结果
     */
//    @Override
//    public int deleteAysGradeById(@Param("stuId") String stuId, @Param("actId") Long actId)
//    {
//        return aysGradeMapper.deleteAysGradeById(stuId,actId);
//    }
    /**
     * 修改学生活动成绩
     *
     * @param aysGrade 学生活动成绩
     * @return 结果
     */
    @Override
    public int deleteAysGradeById(AysGrade aysGrade)
    {
        return aysGradeMapper.deleteAysGradeById(aysGrade);
    }
}

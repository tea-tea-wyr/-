package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AysGrade;
import org.apache.ibatis.annotations.Param;

/**
 * 学生活动成绩Service接口
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
public interface IAysGradeService 
{
    /**
     * 查询学生活动成绩
     * 
     * @param stuId 学生活动成绩ID
     * @return 学生活动成绩
     */
    public AysGrade selectAysGradeById(String stuId);

    /**
     * 查询学生活动成绩列表
     * 
     * @param aysGrade 学生活动成绩
     * @return 学生活动成绩集合
     */
    public List<AysGrade> selectAysGradeList(AysGrade aysGrade);

    /**
     * 新增学生活动成绩
     * 
     * @param aysGrade 学生活动成绩
     * @return 结果
     */
    public int insertAysGrade(AysGrade aysGrade);

    /**
     * 修改学生活动成绩
     * 
     * @param aysGrade 学生活动成绩
     * @return 结果
     */
    public int updateAysGrade(AysGrade aysGrade);

    /**
     * 批量删除学生活动成绩
     * 
     * @param stuIds 需要删除的学生活动成绩ID
     * @return 结果
     */
//    public int deleteAysGradeByIds(String[] stuIds);

//    /**
//     * 删除学生活动成绩信息
//     *
//     * @param stuId 学生活动成绩ID
//     * @param actId
//     * @return 结果
//     */
//    public int deleteAysGradeById(@Param("stuId") String stuId, @Param("actId") Long actId);
//

    /**
     * 修改学生活动成绩
     *
     * @param aysGrade 学生活动成绩
     * @return 结果
     */
    public int deleteAysGradeById(AysGrade aysGrade);
    /**
     * 修改学生活动成绩
     *
     * @param aysGrades 学生活动成绩
     * @return 结果
     */
    public int deleteAysGradeByIds(AysGrade[] aysGrades);


}

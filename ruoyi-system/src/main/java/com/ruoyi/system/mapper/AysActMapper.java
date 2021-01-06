package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AysAct;

/**
 * 活动Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
public interface AysActMapper 
{
    /**
     * 查询活动
     * 
     * @param aid 活动ID
     * @return 活动
     */
    public AysAct selectAysActById(Long aid);

    /**
     * 查询活动列表
     * 
     * @param aysAct 活动
     * @return 活动集合
     */
    public List<AysAct> selectAysActList(AysAct aysAct);

    /**
     * 新增活动
     * 
     * @param aysAct 活动
     * @return 结果
     */
    public int insertAysAct(AysAct aysAct);

    /**
     * 修改活动
     * 
     * @param aysAct 活动
     * @return 结果
     */
    public int updateAysAct(AysAct aysAct);

    /**
     * 删除活动
     * 
     * @param aid 活动ID
     * @return 结果
     */
    public int deleteAysActById(Long aid);

    /**
     * 批量删除活动
     * 
     * @param aids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAysActByIds(Long[] aids);
}

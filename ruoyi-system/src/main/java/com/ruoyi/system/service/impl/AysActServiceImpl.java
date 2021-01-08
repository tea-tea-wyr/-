package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.AysAct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AysActMapper;
import com.ruoyi.system.service.IAysActService;

/**
 * 活动Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
@Service
public class AysActServiceImpl implements IAysActService 
{
    @Autowired
    private AysActMapper aysActMapper;

    /**
     * 查询活动
     * 
     * @param actId 活动ID
     * @return 活动
     */
    @Override
    public AysAct selectAysActById(Long actId)
    {
        return aysActMapper.selectAysActById(actId);
    }

    /**
     * 查询活动列表
     * 
     * @param aysAct 活动
     * @return 活动
     */
    @Override
    public List<AysAct> selectAysActList(AysAct aysAct)
    {
        return aysActMapper.selectAysActList(aysAct);
    }

    /**
     * 新增活动
     * 
     * @param aysAct 活动
     * @return 结果
     */
    @Override
    public int insertAysAct(AysAct aysAct)
    {
        return aysActMapper.insertAysAct(aysAct);
    }

    /**
     * 修改活动
     * 
     * @param aysAct 活动
     * @return 结果
     */
    @Override
    public int updateAysAct(AysAct aysAct)
    {
        return aysActMapper.updateAysAct(aysAct);
    }

    /**
     * 批量删除活动
     * 
     * @param actIds 需要删除的活动ID
     * @return 结果
     */
    @Override
    public int deleteAysActByIds(Long[] actIds)
    {
        return aysActMapper.deleteAysActByIds(actIds);
    }

    /**
     * 删除活动信息
     * 
     * @param actId 活动ID
     * @return 结果
     */
    @Override
    public int deleteAysActById(Long actId)
    {
        return aysActMapper.deleteAysActById(actId);
    }
}

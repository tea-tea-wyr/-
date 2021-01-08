package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AysAdmMapper;
import com.ruoyi.system.domain.AysAdm;
import com.ruoyi.system.service.IAysAdmService;

/**
 * 系统管理员Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
@Service
public class AysAdmServiceImpl implements IAysAdmService 
{
    @Autowired
    private AysAdmMapper aysAdmMapper;

    /**
     * 查询系统管理员
     * 
     * @param mno 系统管理员ID
     * @return 系统管理员
     */
    @Override
    public AysAdm selectAysAdmById(Long mno)
    {
        return aysAdmMapper.selectAysAdmById(mno);
    }

    /**
     * 查询系统管理员列表
     * 
     * @param aysAdm 系统管理员
     * @return 系统管理员
     */
    @Override
    public List<AysAdm> selectAysAdmList(AysAdm aysAdm)
    {
        return aysAdmMapper.selectAysAdmList(aysAdm);
    }

    /**
     * 新增系统管理员
     * 
     * @param aysAdm 系统管理员
     * @return 结果
     */
    @Override
    public int insertAysAdm(AysAdm aysAdm)
    {
        return aysAdmMapper.insertAysAdm(aysAdm);
    }

    /**
     * 修改系统管理员
     * 
     * @param aysAdm 系统管理员
     * @return 结果
     */
    @Override
    public int updateAysAdm(AysAdm aysAdm)
    {
        return aysAdmMapper.updateAysAdm(aysAdm);
    }

    /**
     * 批量删除系统管理员
     * 
     * @param mnos 需要删除的系统管理员ID
     * @return 结果
     */
    @Override
    public int deleteAysAdmByIds(Long[] mnos)
    {
        return aysAdmMapper.deleteAysAdmByIds(mnos);
    }

    /**
     * 删除系统管理员信息
     * 
     * @param mno 系统管理员ID
     * @return 结果
     */
    @Override
    public int deleteAysAdmById(Long mno)
    {
        return aysAdmMapper.deleteAysAdmById(mno);
    }
}

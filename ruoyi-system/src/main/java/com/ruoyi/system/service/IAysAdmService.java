package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AysAdm;

/**
 * 系统管理员Service接口
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
public interface IAysAdmService 
{
    /**
     * 查询系统管理员
     * 
     * @param mno 系统管理员ID
     * @return 系统管理员
     */
    public AysAdm selectAysAdmById(Long mno);

    /**
     * 查询系统管理员列表
     * 
     * @param aysAdm 系统管理员
     * @return 系统管理员集合
     */
    public List<AysAdm> selectAysAdmList(AysAdm aysAdm);

    /**
     * 新增系统管理员
     * 
     * @param aysAdm 系统管理员
     * @return 结果
     */
    public int insertAysAdm(AysAdm aysAdm);

    /**
     * 修改系统管理员
     * 
     * @param aysAdm 系统管理员
     * @return 结果
     */
    public int updateAysAdm(AysAdm aysAdm);

    /**
     * 批量删除系统管理员
     * 
     * @param mnos 需要删除的系统管理员ID
     * @return 结果
     */
    public int deleteAysAdmByIds(Long[] mnos);

    /**
     * 删除系统管理员信息
     * 
     * @param mno 系统管理员ID
     * @return 结果
     */
    public int deleteAysAdmById(Long mno);
}

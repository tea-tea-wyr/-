import request from '@/utils/request'

// 查询系统管理员列表
export function listAdm(query) {
  return request({
    url: '/system/adm/list',
    method: 'get',
    params: query
  })
}

// 查询系统管理员详细
export function getAdm(mno) {
  return request({
    url: '/system/adm/' + mno,
    method: 'get'
  })
}

// 新增系统管理员
export function addAdm(data) {
  return request({
    url: '/system/adm',
    method: 'post',
    data: data
  })
}

// 修改系统管理员
export function updateAdm(data) {
  return request({
    url: '/system/adm',
    method: 'put',
    data: data
  })
}

// 删除系统管理员
export function delAdm(mno) {
  return request({
    url: '/system/adm/' + mno,
    method: 'delete'
  })
}

// 导出系统管理员
export function exportAdm(query) {
  return request({
    url: '/system/adm/export',
    method: 'get',
    params: query
  })
}
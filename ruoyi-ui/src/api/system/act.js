import request from '@/utils/request'

// 查询活动列表
export function listAct(query) {
  return request({
    url: '/system/act/list',
    method: 'get',
    params: query
  })
}

// 查询活动详细
export function getAct(aid) {
  return request({
    url: '/system/act/' + aid,
    method: 'get'
  })
}

// 新增活动
export function addAct(data) {
  return request({
    url: '/system/act',
    method: 'post',
    data: data
  })
}

// 修改活动
export function updateAct(data) {
  return request({
    url: '/system/act',
    method: 'put',
    data: data
  })
}

// 删除活动
export function delAct(aid) {
  return request({
    url: '/system/act/' + aid,
    method: 'delete'
  })
}

// 导出活动
export function exportAct(query) {
  return request({
    url: '/system/act/export',
    method: 'get',
    params: query
  })
}
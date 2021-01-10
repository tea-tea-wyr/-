import request from '@/utils/request'

// 查询学生列表
export function listStu(query) {
  return request({
    url: '/system/stu/list',
    method: 'get',
    params: query
  })
}

// 查询学生详细
export function getStu(sno) {
  return request({
    url: '/system/stu/' + sno,
    method: 'get'
  })
}

// 新增学生
export function addStu(data) {
  return request({
    url: '/system/stu',
    method: 'post',
    data: data
  })
}

// 修改学生
export function updateStu(data) {
  return request({
    url: '/system/stu',
    method: 'put',
    data: data
  })
}

// 删除学生
export function delStu(sno) {
  return request({
    url: '/system/stu/' + sno,
    method: 'delete'
  })
}

// 导出学生
export function exportStu(query) {
  return request({
    url: '/system/stu/export',
    method: 'get',
    params: query
  })
}
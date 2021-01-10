import request from '@/utils/request'

// 查询学生活动成绩列表
export function listGrade(query) {
  return request({
    url: '/system/grade/list',
    method: 'get',
    params: query
  })
}

// 查询学生活动成绩详细
export function getGrade(stuId) {
  return request({
    url: '/system/grade/' + stuId,
    method: 'get'
  })
}

// 新增学生活动成绩
export function addGrade(data) {
  return request({
    url: '/system/grade',
    method: 'post',
    data: data
  })
}

// 修改学生活动成绩
export function updateGrade(data) {
 
  return request({
    url: '/system/grade',
    method: 'put',
    data: data
  })
 
}

// 删除学生活动成绩
export function delGrade(data) {
  // console.log("shuju: "+data.stuId);
  // console.log("shuju: "+data.actId);
  return request({
    url: '/system/grade',
    method: 'delete',
    data:data
  })
}

// 导出学生活动成绩
export function exportGrade(query) {
  return request({
    url: '/system/grade/export',
    method: 'get',
    params: query
  })
}
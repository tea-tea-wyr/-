-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生活动成绩', '3', '1', 'grade', 'system/grade/index', 1, 0, 'C', '0', '0', 'system:grade:list', '#', 'admin', sysdate(), '', null, '学生活动成绩菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生活动成绩查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:grade:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生活动成绩新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:grade:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生活动成绩修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:grade:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生活动成绩删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:grade:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生活动成绩导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:grade:export',       '#', 'admin', sysdate(), '', null, '');
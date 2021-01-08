# # # -- ----------------------------
# # # -- 1、组织表
# # # -- ----------------------------
# # # drop table if exists ays_org;
# # # create table ays_org (
# # #                          org_id           bigint(20)      not null auto_increment    comment '组织id',
# # #                          parent_id         bigint(20)      default 0                  comment '父组织id',
# # #                          ancestors         varchar(50)     default ''                 comment '祖级列表',
# # #                          org_name         varchar(30)     default ''                 comment '组织名称',
# # #                          order_num         int(4)          default 0                  comment '显示顺序',
# # #                          leader            varchar(20)     default null               comment '负责人',
# # #                          phone             varchar(11)     default null               comment '联系电话',
# # #                          email             varchar(50)     default null               comment '邮箱',
# # #                          status            char(1)         default '0'                comment '组织状态（0正常 1停用）',
# # #                          del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
# # #                          create_by         varchar(64)     default ''                 comment '创建者',
# # #                          create_time 	    datetime                                   comment '创建时间',
# # #                          update_by         varchar(64)     default ''                 comment '更新者',
# # #                          update_time       datetime                                   comment '更新时间',
# # #                          primary key (org_id)
# # # ) engine=innodb auto_increment=200 comment = '组织表';
# # insert into ays_org values(100,  0,   '0',          '若依科技',   0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
# # insert into ays_org values(101,  100, '0,100',      '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
# # insert into ays_org values(102,  100, '0,100',      '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
# # insert into ays_org values(103,  101, '0,100,101',  '研发部门',   1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
# # insert into ays_org values(104,  101, '0,100,101',  '市场部门',   2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
#
#
# -- ----------------------------
# -- 5. 活动表
# -- ----------------------------
# drop table if exists ays_act;
# create table ays_act (
#                          act_id          bigint(20)           not null auto_increment    comment '活动id',
#                          org_id          bigint(20)           not null                   comment '所属组织方id',
#                          aname        varchar(50)          not null                   comment '名称',
#                          asubject     varchar(50)          not null                   comment '主题',
#                          atype        char(1)              not null                   comment '标签类型',
#                          astart       datetime                                        comment '开始日期',
#                          aend         datetime                                        comment '结束日期',
#                          astahour     time                                            comment '开始时间',
#                          aendhour     time                                            comment '结束时间',
#                          alocation    varchar(50)          not null                   comment '地点',
#                          aobject      varchar(30)          default ''                 comment '对象',
#                          anum         int(10)              default 0                  comment '人数',
#                          agradetype   char(1)              default '1'                comment '分数类型',
#                          ahour        int(10)              default 0                  comment '总时间',
#                          agrade       int(10)              default 0                  comment '分数',
#                          del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
#
#
#                          primary key (act_id,org_id)
# ) engine=innodb auto_increment=200 comment = '活动表';
# insert into ays_act values(1,'092223333','南口敬老院志愿','志愿活动','1','2020-11-23','2020-11-23','8:00:00','12:00:00','南口敬老院','北化昌平区同学',10,'1',4,8,0);


# 加入活动标签
# insert into sys_dict_type values(11,  '活动标签', 'sys_act_label',        '0', 'admin', sysdate(), '', null, '活动标签列表');
#
#
# insert into sys_dict_data values(29,  1,  '党建类',       '0',       'sys_user_sex',        '',   '',        'Y', '0', 'admin', sysdate(), '', null, '性别男');
# insert into sys_dict_data values(30,  2,  '志愿类',       '1',       'sys_user_sex',        '',   '',        'N', '0', 'admin', sysdate(), '', null, '性别女');


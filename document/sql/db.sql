drop table if exists contacts;

drop table if exists group_man;

drop table if exists groupinfo;

drop table if exists ht_sale_number;

drop table if exists kv;

drop table if exists manager;

drop table if exists manager_code;

drop table if exists manager_heartrate;

drop table if exists manager_motion;

drop table if exists manager_position;

drop table if exists manager_sleep;

drop table if exists news;

drop table if exists remote_care;

drop table if exists sale_detail;

drop table if exists scheduler_task;

drop table if exists versions;

/*==============================================================*/
/* Table: contacts                                              */
/*==============================================================*/
create table contacts
(
   id                   int(11) not null auto_increment comment 'Identifier',
   manid                int(11) not null comment '当前登录人,自己,设置人',
   contactsid           int(11) not null comment '紧急联系人ID',
   kvID                 int(11) comment '关系ID',
   relationship         varchar(32) comment '关系',
   primary key (id)
);

alter table contacts comment '紧急联系人';

/*==============================================================*/
/* Table: group_man                                             */
/*==============================================================*/
create table group_man
(
   id                   int(11) not null comment 'identifier',
   userid               int(11) not null comment '用户,自己,我',
   groupid              int(11) not null comment '好友在我的哪个分组,类似QQ分组,分组ID',
   manid                int(11) comment '好友ID',
   manname              varchar(48) not null comment '好友昵称',
   markname             varchar(48) comment '备注, 默认昵称',
   portriat             varchar(128) comment '头像',
   iscontacts           int(1) default 0 comment '是否是紧急联系人  1:是  null/0:否',
   issee                int(1) default 1 comment '允许查看对方 0不允许 1 允许',
   isCare               int(1) default 0 comment '是否是远程关怀  0:否(默认值)  1:是',
   type                 int(1) default 0 comment '好友请求进度  0 预添加的好友 1 已添加的好友',
   primary key (id)
);

alter table group_man comment '好友列表';

/*==============================================================*/
/* Table: groupinfo                                             */
/*==============================================================*/
create table groupinfo
(
   id                   int(11) not null comment 'ID, identifier',
   name                 varchar(48) not null default '我的好友' comment '分组名称',
   portriat             varchar(128),
   total                int(6) not null default 0 comment '组人数',
   manid                int(11) not null comment '创建人, 所属人',
   enable               int(1) default 1 comment '0:未使用   1:使用',
   primary key (id)
);

alter table groupinfo comment '好友分组';

/*==============================================================*/
/* Table: ht_sale_number                                        */
/*==============================================================*/
create table ht_sale_number
(
   saleID               int(11) not null auto_increment comment 'ID',
   saleDate             char(10) comment '销售日期 yyyy-MM-dd',
   countThem            int(8) comment '销售数目',
   comKey               int(1) not null default 1 comment '1:缔凡思',
   timeline             char(19) comment '时间',
   employee             varchar(96) comment '操作人员, 参与此次销售人员 ',
   recordUID            int(11) comment '录入记录人员',
   status               int(1) comment '单号状态 0:正常状态 4:取消状态',
   remark               mediumtext comment '备注',
   primary key (saleID)
);

alter table ht_sale_number comment '销售单号';

/*==============================================================*/
/* Table: kv                                                    */
/*==============================================================*/
create table kv
(
   kvID                 int(11) not null auto_increment comment 'identifier',
   keyA                 varchar(64) not null comment 'key A',
   keyB                 varchar(64) comment 'key B',
   val                  varchar(128) comment 'Value  字符串值',
   valueInt             int(11) comment 'Value for int  Int型数值',
   sortNum              int(6) not null default 0 comment 'Sort Number, 排序字段, 默认0',
   primary key (kvID)
);

alter table kv comment 'Key-Value 键值表 字典表 长量表';

/*==============================================================*/
/* Table: manager                                               */
/*==============================================================*/
create table manager
(
   id                   int(11) not null comment 'ID,identifier',
   realname             varchar(48) comment '真实姓名',
   nickname             varchar(48) comment '昵称',
   portriat             varchar(128) comment '头像路径,  head/头像名称.png/jpg',
   gender               char(1) default '女' comment '性别',
   email                varchar(64) comment '邮箱地址',
   birthday             char(19) default '1990-01-01' comment '生日,出生年月',
   age                  int(3) comment '年龄,应根据生日自动判断',
   telephone            varchar(24) comment '电话,手机号码',
   address              varchar(196) comment '现住址',
   dept                 varchar(196) comment '所在单位',
   weight               float(3,2) comment '体重',
   height               float(3,2) comment '身高',
   bluetooth            char(17) comment '手环MAC地址',
   device               varchar(16) comment '手环名称, DFS-19F0...',
   deletesign           int(1) comment '删除标识     0:删除 1:正常',
   primary key (id)
);

alter table manager comment '手机用户表';

/*==============================================================*/
/* Table: manager_code                                          */
/*==============================================================*/
create table manager_code
(
   id                   int(11) not null auto_increment comment 'ID, identifier',
   user                 varchar(32) not null comment '登录名,用户名',
   password             varchar(32) not null comment '登录密码',
   code                 char(6) comment '验证码',
   sendtime             char(19) not null comment '发送时间,创建时间',
   timeMillis           bigint(15) comment '时间戳,暂未使用',
   primary key (id)
);

alter table manager_code comment '登录信息表';

/*==============================================================*/
/* Table: manager_heartrate                                     */
/*==============================================================*/
create table manager_heartrate
(
   id                   int(11) not null comment 'ID,identifier',
   manid                int(11) not null comment '用户ID',
   insertdate           char(19) not null comment '时间',
   heartratenum         int(3) default 70 comment '心跳',
   maxNum               int(3) comment '心率最大值 仅在测试心率时有值,同步数据无值或默认心跳值',
   minNum               int(3) comment '心率最小值 仅在测试心率时有值,同步数据无值或默认心跳值',
   primary key (id)
);

alter table manager_heartrate comment '用户心率';

/*==============================================================*/
/* Table: manager_motion                                        */
/*==============================================================*/
create table manager_motion
(
   id                   int(11) not null comment 'ID,identifier',
   manid                int(11) not null comment '用户ID',
   insertdate           char(19) not null comment '时间',
   stepsnum             int(11) default 0 comment '步数',
   activitytime         int(11) default 0 comment '此次运动时长(分钟)',
   mileage              int(11) default 0 comment '运动距离(米)',
   consume              int(11) default 0 comment '卡路里消耗',
   primary key (id)
);

alter table manager_motion comment '用户运动记录表';

/*==============================================================*/
/* Table: manager_position                                      */
/*==============================================================*/
create table manager_position
(
   id                   int(11) not null comment 'ID,identifier',
   manid                int(11) not null comment '用户ID',
   manname              varchar(48) comment '用户昵称',
   uploadtime           char(19) not null comment '时间',
   lng                  double not null default 0 comment '经度',
   lat                  double not null default 0,
   place                varchar(256) comment '具体位置',
   primary key (id)
);

alter table manager_position comment '用户坐标';

/*==============================================================*/
/* Table: manager_sleep                                         */
/*==============================================================*/
create table manager_sleep
(
   id                   int(11) not null comment 'ID,identifier',
   manid                int(11) not null comment '用户ID',
   insertdate           char(19) not null comment '时间',
   allsleep             int(6) default 0 comment '总睡眠时长(分钟)',
   deepsleep            int(6) default 0 comment '深睡时长(分钟)',
   shallowsleep         int(6) default 0 comment '浅睡时长(分钟)',
   sobertime            int(6) default 0 comment '清醒时长(分钟)',
   primary key (id)
);

alter table manager_sleep comment '用户睡眠';

/*==============================================================*/
/* Table: news                                                  */
/*==============================================================*/
create table news
(
   id                   int(11) not null auto_increment comment 'ID,identifier',
   primary key (id)
);

alter table news comment '消息及报警表';

/*==============================================================*/
/* Table: remote_care                                           */
/*==============================================================*/
create table remote_care
(
   rcID                 int(11) not null auto_increment comment 'ID,identifier',
   manid                int(11) comment '用户,自己,我',
   cardID               int(11) comment '我关怀的人',
   markName             varchar(48) comment '备注名称',
   phone                varchar(24) comment '对方手机号',
   portriat             varchar(128) comment '对方头像',
   status               int(1) not null default 0 comment '状态 0:对方未同意 1:互为远程关怀人',
   primary key (rcID)
);

alter table remote_care comment '远程关怀表';

/*==============================================================*/
/* Table: sale_detail                                           */
/*==============================================================*/
create table sale_detail
(
   detailID             bigint not null auto_increment comment 'ID',
   saleNoID             int(11) comment '销售单号ID',
   theName              varchar(16) comment '手环名称',
   macAddr              char(17) comment '手环MAC地址',
   status               int(1) comment '手环状态 0:销售中  1:开始使用/使用中  2:黑名单  4:挂失  ',
   remark               mediumtext comment '备注',
   primary key (detailID)
);

alter table sale_detail comment '销售详情, 手环具体 MAC 地址以及使用状态';

/*==============================================================*/
/* Table: scheduler_task                                        */
/*==============================================================*/
create table scheduler_task
(
   stID                 int(11) not null auto_increment comment 'ID,identifier',
   taskType             int(1) not null default 0 comment '任务类别 0:检测心跳 其他待定',
   sendID               int(11) comment '任务发送者  A 要 B 执行某项任务,当前字段为 A的ID',
   receiverID           int(11) not null comment '任务接收者 A 要 B 执行某项任务,当前字段为 B的ID',
   timeMillis           bigint(15) comment '时间有效期,毫秒数,时间戳,创建时当前时间加配置的是分钟数',
   timeline             char(19) comment '时间',
   status               int(1) not null default 0 comment '0:默认值 初始值 刚刚发布任务  1:B已收到任务  2:处理失败  6:处理成功',
   primary key (stID)
);

alter table scheduler_task comment '待做任务,调度';

/*==============================================================*/
/* Table: versions                                              */
/*==============================================================*/
create table versions
(
   id                   int(11) not null auto_increment comment 'identifier',
   which                int(1) not null comment '手机类别  0:Android   9:iOS',
   version              varchar(20) not null comment '版本号',
   versionInt           int(6) not null comment '版本号数值,版本对应的INT值,程序中以此字段进行判断是否最新版本',
   newVersionTime       char(10) not null comment '更新日期 YYYY-MM-DD',
   forceUpdate          int(1) not null default 0 comment '是否强制更新  0:否   1:是',
   description          mediumtext comment '新版本更新内容',
   href                 varchar(196) not null comment '对应链接',
   primary key (id)
);

alter table versions comment '版本';

alter table contacts add constraint FK___CONTACT_contactid___MANAGER_id foreign key (contactsid)
      references manager (id) on delete restrict on update restrict;

alter table contacts add constraint FK___CONTACT_kvID___KV_kvID foreign key (kvID)
      references kv (kvID) on delete restrict on update restrict;

alter table contacts add constraint FK___CONTACT_manid___MANAGER_id foreign key (manid)
      references manager (id) on delete restrict on update restrict;

alter table group_man add constraint FK___GROUP_MAN_groupid___GROUP_INFO_id foreign key (groupid)
      references groupinfo (id) on delete restrict on update restrict;

alter table group_man add constraint FK___GROUP_MAN_manid___MANAGER_id foreign key (manid)
      references manager (id) on delete restrict on update restrict;

alter table group_man add constraint FK___GROUP_MAN_userid___MANAGER_id foreign key (userid)
      references manager (id) on delete restrict on update restrict;

alter table groupinfo add constraint FK___GROUP_INFO_manid___MANAGER_id foreign key (manid)
      references manager (id) on delete restrict on update restrict;

alter table manager add constraint FK___MANAGER_bluetooth___SALE_DETAIL_macAddr foreign key (bluetooth)
      references sale_detail (macAddr) on delete restrict on update restrict;

alter table manager add constraint FK___MANAGER_telephone___MANAGER_CODE_user foreign key (telephone)
      references manager_code (user);

alter table manager_heartrate add constraint FK___MANAGER_HEART_manid___MANAGER_id foreign key (manid)
      references manager (id) on delete restrict on update restrict;

alter table manager_motion add constraint FK___MANAGER_MOTION_manid___MANAGER_id foreign key (manid)
      references manager (id) on delete restrict on update restrict;

alter table manager_position add constraint FK___MANAGER_POSITION_manid___MANAGER_ID foreign key (manid)
      references manager (id) on delete restrict on update restrict;

alter table manager_sleep add constraint FK___MANAGER_SLEEP_manid___MANAGER_id foreign key (manid)
      references manager (id) on delete restrict on update restrict;

alter table remote_care add constraint FK___CONTACTS_cardID___MANAGER_id foreign key (cardID)
      references manager (id) on delete restrict on update restrict;

alter table remote_care add constraint FK___CONTACTS_manid___MANAGER_id foreign key (manid)
      references manager (id) on delete restrict on update restrict;

alter table sale_detail add constraint FK___SALE_DETAIL_saleNoID___SALE_NUMBER_ID foreign key (saleNoID)
      references ht_sale_number (saleID) on delete restrict on update restrict;

alter table scheduler_task add constraint FK___SCHEDULER_TASK_receiverID___MANAGER_id foreign key (receiverID)
      references manager (id) on delete restrict on update restrict;

alter table scheduler_task add constraint FK___SCHEDULER_TASK_sendID___MANAGER_id foreign key (sendID)
      references manager (id) on delete restrict on update restrict;

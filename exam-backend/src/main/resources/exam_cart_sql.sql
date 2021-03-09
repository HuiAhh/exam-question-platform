/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     10/13/2020 9:32:25 PM                        */
/*==============================================================*/


drop table if exists exam_admin;

drop table if exists exam_cart;

drop table if exists exam_category;

drop table if exists exam_collect;

drop table if exists exam_comment;

drop table if exists exam_errorbook;

drop table if exists exam_feedback;

drop table if exists exam_footprint;

drop table if exists exam_issue;

drop table if exists exam_keyword;

drop table if exists exam_major;

drop table if exists exam_paper;

drop table if exists exam_permission;

drop table if exists exam_question;

drop table if exists exam_role;

drop table if exists exam_school;

drop table if exists exam_search_history;

drop table if exists exam_topic;

drop table if exists exam_user;

/*==============================================================*/
/* Table: exam_admin                                            */
/*==============================================================*/
create table exam_admin
(
   admin_id                   int(11) not null auto_increment,
   username             varchar(63) not null default '' comment '管理员名称',
   password             varchar(63) not null default '' comment '管理员密码',
   last_login_ip        varchar(63) default '' comment '最近一次登录IP地址',
   last_login_time      datetime default NULL comment '最近一次登录时间',
   avatar               varchar(255) default '''' comment '头像图片',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   role_ids             varchar(127) default '[]' comment '角色列表',
   primary key (admin_id)
)
ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='管理员表';

/*==============================================================*/
/* Table: exam_cart                                             */
/*==============================================================*/
create table exam_cart
(
   cart_id                   int(11) not null auto_increment,
   user_id              int(11) default NULL comment '用户表的用户ID',
   question_id          int(11) default NULL comment '题目表的题目ID',
   bag_id               int(11) default NULL comment '试卷袋ID',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (cart_id)
)
ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='购物车题目表';

/*==============================================================*/
/* Table: exam_category
   一级目录，学科
   二级目录，章节
   三级目录，知识点
 */
/*==============================================================*/
create table exam_category
(
   category_id                   int(11) not null auto_increment,
   name                 varchar(63) not null default '' comment '类目名称',
   keywords             varchar(1023) not null default '' comment '类目关键字，以JSON数组格式',
   pid                  int(11) not null default 0 comment '父类目ID',
   icon_url             varchar(255) default '' comment '类目图标',
   pic_url              varchar(255) default '' comment '类目图片',
   level                varchar(255) default 'L1',
   sort_order           tinyint(3) default 50 comment '排序',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (category_id),
   key parent_id (pid)
)
ENGINE=InnoDB AUTO_INCREMENT=1036007 DEFAULT CHARSET=utf8mb4 COMMENT='类目表';

/*==============================================================*/
/* Table: exam_collect                                          */
/*==============================================================*/
create table exam_collect
(
   collect_id                   int(11) not null auto_increment,
   user_id              int(11) not null default 0 comment '用户表的用户ID',
   value_id             int(11) not null default 0 comment '收藏对象的ID',
   type                 tinyint(3) not null default 0 comment '收藏类型，如果type=0，则是题目ID；如果type=1，则是文章ID；如果type=3，则是关键词ID',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (collect_id),
   key user_id (user_id),
   key question_id (value_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收藏表';

/*==============================================================*/
/* Table: exam_comment                                          */
/*==============================================================*/
create table exam_comment
(
   comment_id                   int(11) not null auto_increment,
   value_id             int(11) not null default 0 comment '收藏对象的ID',
   type                 tinyint(3) not null default 0 comment '评论类型，如果type=0，则是题目评论；如果是type=1，则是文章评论；如果type=3，则是组卷题目评论。',
   content              varchar(1023),
   user_id              int(11) not null default 0 comment '用户表的用户ID',
   has_picture          tinyint(1) default 0 comment '是否含有图片',
   pic_urls             varchar(1023) default NULL comment '图片地址列表，采用JSON数组格式',
   star                 smallint(6) default 1 comment '评分， 1-5',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (comment_id),
   key id_value (value_id)
)
ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8 COMMENT='评论表';

/*==============================================================*/
/* Table: exam_errorbook                                        */
/*==============================================================*/
create table exam_errorbook
(
   errorbook_id                   int(10) not null auto_increment,
   user_id              varchar(40) not null comment '用户ID',
   course_id            varchar(40) not null comment '课程ID',
   user_answer          varchar(400) not null,
   question_id          varchar(40) not null,
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (errorbook_id)
)
ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='错题集';

/*==============================================================*/
/* Table: exam_feedback                                         */
/*==============================================================*/
create table exam_feedback
(
   feedback_id                   int(11) not null auto_increment,
   user_id              int(11) not null default 0 comment '用户表的用户ID',
   username             varchar(63),
   mobile               varchar(20),
   feed_type            varchar(63) not null default '' comment '反馈类型',
   content              varchar(1023),
   status               int(3) not null default 0 comment '状态',
   has_picture          tinyint(1) default 0 comment '是否含有图片',
   pic_urls             varchar(1023),
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (feedback_id),
   key id_value (status)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意见反馈表';

/*==============================================================*/
/* Table: exam_footprint                                        */
/*==============================================================*/
create table exam_footprint
(
   footprint_id                   int(11) not null auto_increment,
   user_id              int(11) not null default 0 comment '用户表的用户ID',
   question_id          int(11) not null default 0 comment '浏览题目ID',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (footprint_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户浏览足迹表';

/*==============================================================*/
/* Table: exam_issue                                            */
/*==============================================================*/
create table exam_issue
(
   issue_id                   int(11) not null auto_increment,
   question             varchar(255) default NULL comment '问题标题',
   answer               varchar(255) default NULL comment '问题答案',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (issue_id)
)
ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='常见问题表';

/*==============================================================*/
/* Table: exam_keyword                                          */
/*==============================================================*/
create table exam_keyword
(
   keyword_id           int(11) not null auto_increment,
   keyword              varchar(127) not null default '' comment '关键字',
   url                  varchar(255) not null default '' comment '关键字的跳转链接',
   is_hot               tinyint(1) not null default 0 comment '是否是热门关键字',
   is_default           tinyint(1) not null default 0 comment '是否是默认关键字',
   sort_order           int(11) not null default 100 comment '排序',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (keyword_id)
)
ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='关键字表';

/*==============================================================*/
/* Table: exam_major                                            */
/*==============================================================*/
create table exam_major
(
   major_id                   int(5) not null auto_increment,
   school_id            int(5) comment '学院外键',
   major_name           varchar(20) not null comment '专业名',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (major_id)
)
ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='专业表';

/*==============================================================*/
/* Table: exam_paper                                            */
/*==============================================================*/
create table exam_paper
(
   paper_id                   int(11) not null auto_increment,
   user_id              int(11) not null comment '用户表的用户ID',
   score                int(3) default NULL comment '试卷得分, 借来判断是否做过此卷子',
   begin_time           datetime default NULL,
   end_time             datetime default NULL,
   allow_time           datetime not null,
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (paper_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组卷表';

/*==============================================================*/
/* Table: exam_permission                                       */
/*==============================================================*/
create table exam_permission
(
   permission_id                   int(11) not null auto_increment,
   role_id              int(11) default NULL comment '角色ID',
   permission           varchar(63) default NULL comment '权限',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (permission_id)
)
ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

/*==============================================================*/
/* Table: exam_question                                         */
/*==============================================================*/
create table exam_question
(
   question_id                   int(10) not null auto_increment,
   name                 varchar(500) not null comment '题干',
   keyword_id           int(2) not null comment '关键词id，对应关键词表的主键',
   optiona              varchar(100) default NULL comment '题枝选项',
   optionb              varchar(100) default NULL comment '题枝选项',
   optionc              varchar(100) default NULL comment '题枝选项',
   optiond              varchar(100) default NULL comment '题枝选项',
   answer               varchar(500) not null comment '答案',
   type                 tinyint(2) default 0 comment '题目类型,0表示选择题,1表示填空题,2表示论述题',
   answer_detail        varchar(200) default NULL comment '题解',
   user_answer          varchar(500) default NULL comment '用户答案',
   course_id            varchar(20) not null comment '课程ID',
   difficulty           int(2) not null comment '难度系数',
   primary key (question_id)
)
ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COMMENT='题目表';

/*==============================================================*/
/* Table: exam_role                                             */
/*==============================================================*/
create table exam_role
(
   role_id                   int(11) not null auto_increment,
   name                 varchar(63) not null comment '角色名称',
   description               varchar(1023) default NULL comment '角色描述',
   enabled              tinyint(1) default 1 comment '是否启用',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (role_id),
   unique key name_UNIQUE (name)
)
ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

/*==============================================================*/
/* Table: exam_school                                           */
/*==============================================================*/
create table exam_school
(
   school_id                   int(5) not null auto_increment,
   school_name          varchar(20) not null comment '学院名',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (school_id)
)
ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='学院表';

/*==============================================================*/
/* Table: exam_search_history                                   */
/*==============================================================*/
create table exam_search_history
(
   search_history_id                   int(11) not null auto_increment,
   user_id              int(11) not null comment '用户表的用户ID',
   keyword              varchar(63) not null comment '搜索关键字',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (search_history_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='搜索历史表';

/*==============================================================*/
/* Table: exam_topic                                            */
/*==============================================================*/
create table exam_topic
(
   topic_id             int(11) not null auto_increment,
   title                varchar(255) not null default '''' comment '题解标题',
   subtitle             varchar(255) default '''' comment '题解子标题',
   content              text comment '题解内容',
   price                decimal(10,2) default 0.00 comment '专题相关题目最低价',
   read_count           varchar(255) default '1k' comment '题解阅读量',
   pic_url              varchar(255) default '' comment '题解图片',
   sort_order           int(11) default 100 comment '排序',
   tags                varchar(1023) default '' comment '相关标签，采用JSON数组格式',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (topic_id),
   key topic_id (topic_id)
)
ENGINE=InnoDB AUTO_INCREMENT=319 DEFAULT CHARSET=utf8mb4 COMMENT='文章表';

/*==============================================================*/
/* Table: exam_user                                             */
/*==============================================================*/
create table exam_user
(
   user_id                   int(11) not null auto_increment,
   username             varchar(63) not null comment '用户名称',
   password             varchar(63) not null default '' comment '用户密码',
   gender               tinyint(3) not null default 0 comment '性别：0 未知， 1男， 1 女',
   grade                varchar(10) default NULL,
   major                int(5) not null,
   birthday             date default NULL comment '生日',
   last_login_time      datetime default NULL comment '最近一次登录时间',
   last_login_ip        varchar(63) not null default '' comment '最近一次登录IP地址',
   user_level           tinyint(3) default 0 comment '0 普通用户，1 VIP用户，2 高级VIP用户',
   nickname             varchar(63) not null default '' comment '用户昵称或网络名称',
   mobile               varchar(20) not null default '' comment '用户手机号码',
   avatar               varchar(255) not null default '' comment '用户头像图片',
   weixin_openid        varchar(63) not null default '' comment '微信登录openid',
   email                varchar(40) not null,
   status               tinyint(3) not null default 0 comment '0 可用, 1 禁用, 2 注销',
   add_time             datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   deleted              tinyint(1) default 0 comment '逻辑删除',
   primary key (user_id),
   unique key user_name (username)
)
ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


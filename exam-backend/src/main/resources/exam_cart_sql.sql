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
   username             varchar(63) not null default '' comment '����Ա����',
   password             varchar(63) not null default '' comment '����Ա����',
   last_login_ip        varchar(63) default '' comment '���һ�ε�¼IP��ַ',
   last_login_time      datetime default NULL comment '���һ�ε�¼ʱ��',
   avatar               varchar(255) default '''' comment 'ͷ��ͼƬ',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   role_ids             varchar(127) default '[]' comment '��ɫ�б�',
   primary key (admin_id)
)
ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='����Ա��';

/*==============================================================*/
/* Table: exam_cart                                             */
/*==============================================================*/
create table exam_cart
(
   cart_id                   int(11) not null auto_increment,
   user_id              int(11) default NULL comment '�û�����û�ID',
   question_id          int(11) default NULL comment '��Ŀ�����ĿID',
   bag_id               int(11) default NULL comment '�Ծ��ID',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (cart_id)
)
ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='���ﳵ��Ŀ��';

/*==============================================================*/
/* Table: exam_category
   һ��Ŀ¼��ѧ��
   ����Ŀ¼���½�
   ����Ŀ¼��֪ʶ��
 */
/*==============================================================*/
create table exam_category
(
   category_id                   int(11) not null auto_increment,
   name                 varchar(63) not null default '' comment '��Ŀ����',
   keywords             varchar(1023) not null default '' comment '��Ŀ�ؼ��֣���JSON�����ʽ',
   pid                  int(11) not null default 0 comment '����ĿID',
   icon_url             varchar(255) default '' comment '��Ŀͼ��',
   pic_url              varchar(255) default '' comment '��ĿͼƬ',
   level                varchar(255) default 'L1',
   sort_order           tinyint(3) default 50 comment '����',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (category_id),
   key parent_id (pid)
)
ENGINE=InnoDB AUTO_INCREMENT=1036007 DEFAULT CHARSET=utf8mb4 COMMENT='��Ŀ��';

/*==============================================================*/
/* Table: exam_collect                                          */
/*==============================================================*/
create table exam_collect
(
   collect_id                   int(11) not null auto_increment,
   user_id              int(11) not null default 0 comment '�û�����û�ID',
   value_id             int(11) not null default 0 comment '�ղض����ID',
   type                 tinyint(3) not null default 0 comment '�ղ����ͣ����type=0��������ĿID�����type=1����������ID�����type=3�����ǹؼ���ID',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (collect_id),
   key user_id (user_id),
   key question_id (value_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='�ղر�';

/*==============================================================*/
/* Table: exam_comment                                          */
/*==============================================================*/
create table exam_comment
(
   comment_id                   int(11) not null auto_increment,
   value_id             int(11) not null default 0 comment '�ղض����ID',
   type                 tinyint(3) not null default 0 comment '�������ͣ����type=0��������Ŀ���ۣ������type=1�������������ۣ����type=3�����������Ŀ���ۡ�',
   content              varchar(1023),
   user_id              int(11) not null default 0 comment '�û�����û�ID',
   has_picture          tinyint(1) default 0 comment '�Ƿ���ͼƬ',
   pic_urls             varchar(1023) default NULL comment 'ͼƬ��ַ�б�����JSON�����ʽ',
   star                 smallint(6) default 1 comment '���֣� 1-5',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (comment_id),
   key id_value (value_id)
)
ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8 COMMENT='���۱�';

/*==============================================================*/
/* Table: exam_errorbook                                        */
/*==============================================================*/
create table exam_errorbook
(
   errorbook_id                   int(10) not null auto_increment,
   user_id              varchar(40) not null comment '�û�ID',
   course_id            varchar(40) not null comment '�γ�ID',
   user_answer          varchar(400) not null,
   question_id          varchar(40) not null,
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (errorbook_id)
)
ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='���⼯';

/*==============================================================*/
/* Table: exam_feedback                                         */
/*==============================================================*/
create table exam_feedback
(
   feedback_id                   int(11) not null auto_increment,
   user_id              int(11) not null default 0 comment '�û�����û�ID',
   username             varchar(63),
   mobile               varchar(20),
   feed_type            varchar(63) not null default '' comment '��������',
   content              varchar(1023),
   status               int(3) not null default 0 comment '״̬',
   has_picture          tinyint(1) default 0 comment '�Ƿ���ͼƬ',
   pic_urls             varchar(1023),
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (feedback_id),
   key id_value (status)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���������';

/*==============================================================*/
/* Table: exam_footprint                                        */
/*==============================================================*/
create table exam_footprint
(
   footprint_id                   int(11) not null auto_increment,
   user_id              int(11) not null default 0 comment '�û�����û�ID',
   question_id          int(11) not null default 0 comment '�����ĿID',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (footprint_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='�û�����㼣��';

/*==============================================================*/
/* Table: exam_issue                                            */
/*==============================================================*/
create table exam_issue
(
   issue_id                   int(11) not null auto_increment,
   question             varchar(255) default NULL comment '�������',
   answer               varchar(255) default NULL comment '�����',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (issue_id)
)
ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='���������';

/*==============================================================*/
/* Table: exam_keyword                                          */
/*==============================================================*/
create table exam_keyword
(
   keyword_id           int(11) not null auto_increment,
   keyword              varchar(127) not null default '' comment '�ؼ���',
   url                  varchar(255) not null default '' comment '�ؼ��ֵ���ת����',
   is_hot               tinyint(1) not null default 0 comment '�Ƿ������Źؼ���',
   is_default           tinyint(1) not null default 0 comment '�Ƿ���Ĭ�Ϲؼ���',
   sort_order           int(11) not null default 100 comment '����',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (keyword_id)
)
ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='�ؼ��ֱ�';

/*==============================================================*/
/* Table: exam_major                                            */
/*==============================================================*/
create table exam_major
(
   major_id                   int(5) not null auto_increment,
   school_id            int(5) comment 'ѧԺ���',
   major_name           varchar(20) not null comment 'רҵ��',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (major_id)
)
ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='רҵ��';

/*==============================================================*/
/* Table: exam_paper                                            */
/*==============================================================*/
create table exam_paper
(
   paper_id                   int(11) not null auto_increment,
   user_id              int(11) not null comment '�û�����û�ID',
   score                int(3) default NULL comment '�Ծ�÷�, �����ж��Ƿ������˾���',
   begin_time           datetime default NULL,
   end_time             datetime default NULL,
   allow_time           datetime not null,
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (paper_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='����';

/*==============================================================*/
/* Table: exam_permission                                       */
/*==============================================================*/
create table exam_permission
(
   permission_id                   int(11) not null auto_increment,
   role_id              int(11) default NULL comment '��ɫID',
   permission           varchar(63) default NULL comment 'Ȩ��',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (permission_id)
)
ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COMMENT='Ȩ�ޱ�';

/*==============================================================*/
/* Table: exam_question                                         */
/*==============================================================*/
create table exam_question
(
   question_id                   int(10) not null auto_increment,
   name                 varchar(500) not null comment '���',
   keyword_id           int(2) not null comment '�ؼ���id����Ӧ�ؼ��ʱ������',
   optiona              varchar(100) default NULL comment '��֦ѡ��',
   optionb              varchar(100) default NULL comment '��֦ѡ��',
   optionc              varchar(100) default NULL comment '��֦ѡ��',
   optiond              varchar(100) default NULL comment '��֦ѡ��',
   answer               varchar(500) not null comment '��',
   type                 tinyint(2) default 0 comment '��Ŀ����,0��ʾѡ����,1��ʾ�����,2��ʾ������',
   answer_detail        varchar(200) default NULL comment '���',
   user_answer          varchar(500) default NULL comment '�û���',
   course_id            varchar(20) not null comment '�γ�ID',
   difficulty           int(2) not null comment '�Ѷ�ϵ��',
   primary key (question_id)
)
ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COMMENT='��Ŀ��';

/*==============================================================*/
/* Table: exam_role                                             */
/*==============================================================*/
create table exam_role
(
   role_id                   int(11) not null auto_increment,
   name                 varchar(63) not null comment '��ɫ����',
   description               varchar(1023) default NULL comment '��ɫ����',
   enabled              tinyint(1) default 1 comment '�Ƿ�����',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (role_id),
   unique key name_UNIQUE (name)
)
ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='��ɫ��';

/*==============================================================*/
/* Table: exam_school                                           */
/*==============================================================*/
create table exam_school
(
   school_id                   int(5) not null auto_increment,
   school_name          varchar(20) not null comment 'ѧԺ��',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (school_id)
)
ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='ѧԺ��';

/*==============================================================*/
/* Table: exam_search_history                                   */
/*==============================================================*/
create table exam_search_history
(
   search_history_id                   int(11) not null auto_increment,
   user_id              int(11) not null comment '�û�����û�ID',
   keyword              varchar(63) not null comment '�����ؼ���',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (search_history_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='������ʷ��';

/*==============================================================*/
/* Table: exam_topic                                            */
/*==============================================================*/
create table exam_topic
(
   topic_id             int(11) not null auto_increment,
   title                varchar(255) not null default '''' comment '������',
   subtitle             varchar(255) default '''' comment '����ӱ���',
   content              text comment '�������',
   price                decimal(10,2) default 0.00 comment 'ר�������Ŀ��ͼ�',
   read_count           varchar(255) default '1k' comment '����Ķ���',
   pic_url              varchar(255) default '' comment '���ͼƬ',
   sort_order           int(11) default 100 comment '����',
   tags                varchar(1023) default '' comment '��ر�ǩ������JSON�����ʽ',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (topic_id),
   key topic_id (topic_id)
)
ENGINE=InnoDB AUTO_INCREMENT=319 DEFAULT CHARSET=utf8mb4 COMMENT='���±�';

/*==============================================================*/
/* Table: exam_user                                             */
/*==============================================================*/
create table exam_user
(
   user_id                   int(11) not null auto_increment,
   username             varchar(63) not null comment '�û�����',
   password             varchar(63) not null default '' comment '�û�����',
   gender               tinyint(3) not null default 0 comment '�Ա�0 δ֪�� 1�У� 1 Ů',
   grade                varchar(10) default NULL,
   major                int(5) not null,
   birthday             date default NULL comment '����',
   last_login_time      datetime default NULL comment '���һ�ε�¼ʱ��',
   last_login_ip        varchar(63) not null default '' comment '���һ�ε�¼IP��ַ',
   user_level           tinyint(3) default 0 comment '0 ��ͨ�û���1 VIP�û���2 �߼�VIP�û�',
   nickname             varchar(63) not null default '' comment '�û��ǳƻ���������',
   mobile               varchar(20) not null default '' comment '�û��ֻ�����',
   avatar               varchar(255) not null default '' comment '�û�ͷ��ͼƬ',
   weixin_openid        varchar(63) not null default '' comment '΢�ŵ�¼openid',
   email                varchar(40) not null,
   status               tinyint(3) not null default 0 comment '0 ����, 1 ����, 2 ע��',
   add_time             datetime default NULL comment '����ʱ��',
   update_time          datetime default NULL comment '����ʱ��',
   deleted              tinyint(1) default 0 comment '�߼�ɾ��',
   primary key (user_id),
   unique key user_name (username)
)
ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='�û���';


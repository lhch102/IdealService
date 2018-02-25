create table comment_info
(
  id int auto_increment
    primary key,
  movie_id int not null comment '影片ID',
  comment_type varchar(5) default 'NULL' null comment '评论类型：0:短评；1:长评',
  comment_nick_name varchar(50) default 'NULL' null comment '评论人昵称',
  create_id int default 'NULL' null comment '创建人ID',
  create_time timestamp default 'current_timestamp()' not null comment '创建时间',
  modify_id int default 'NULL' null comment '修改人ID',
  modify_time datetime default 'NULL' null comment '修改时间',
  constraint comment_info_id_uindex
  unique (id)
)
  comment '影片评价表';

-- auto-generated definition
CREATE TABLE sys_dict
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  dict_value  CHAR DEFAULT 'NULL'                     NULL
  COMMENT '数据值',
  label       VARCHAR(32) DEFAULT 'NULL'              NULL
  COMMENT '标签名',
  type        VARCHAR(32) DEFAULT 'NULL'              NULL
  COMMENT '字典类型',
  description VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '描述',
  sort        INT DEFAULT 'NULL'                      NULL
  COMMENT '排序',
  remarks     VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '备注',
  del_flag    CHAR DEFAULT 'NULL'                     NULL
  COMMENT '删除标记；0：已删除；1：未删除',
  create_id   INT DEFAULT 'NULL'                      NULL
  COMMENT '创建人ID',
  create_time TIMESTAMP DEFAULT 'current_timestamp()' NOT NULL
  COMMENT '创建时间',
  modify_id   INT DEFAULT 'NULL'                      NULL
  COMMENT '修改人ID',
  modify_time DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '修改时间',
  CONSTRAINT dict_id_uindex
  UNIQUE (id)
)
  COMMENT '字典表';

-- auto-generated definition
CREATE TABLE movie_info
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  chinese_name  VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '影片中文名',
  english_name  VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '影片英文名',
  ask           VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '别名',
  images        VARCHAR(500) DEFAULT 'NULL'             NULL
  COMMENT '电影竖图海报',
  grade         FLOAT DEFAULT 'NULL'                    NULL
  COMMENT '影片评分',
  country       VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '制片国家',
  film_years    DATE DEFAULT 'NULL'                     NULL
  COMMENT '年代',
  film_types    VARCHAR(5) DEFAULT 'NULL'               NULL
  COMMENT '影片类型；（每个影片对应的类型，至少一个）',
  introduction  MEDIUMTEXT DEFAULT 'NULL'               NULL
  COMMENT '简介',
  film_label    VARCHAR(32) DEFAULT 'NULL'              NULL
  COMMENT '影片标签（可以是多个，比影片类型维度更广）',
  movie_list_id INT DEFAULT 'NULL'                      NULL
  COMMENT '影单ID',
  film_source   VARCHAR(5) DEFAULT 'NULL'               NULL
  COMMENT '影片来源；0:豆瓣；1:IMDB；2:letterboxd；3:烂番茄；4:Netflix；5:Facebook；',
  medium_type   VARCHAR(5) DEFAULT 'NULL'               NULL
  COMMENT '媒体类型；0：电影；1：电视剧；2：动漫；3：纪录片；4：纪录片；5：综艺节目',
  film_time     INT DEFAULT 'NULL'                      NULL
  COMMENT '时长（单位：分钟）',
  heat          INT DEFAULT '0'                         NULL
  COMMENT '影片热度；指数越高，排名越高',
  create_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '创建人ID',
  create_time   TIMESTAMP DEFAULT 'current_timestamp()' NOT NULL
  COMMENT '创建时间',
  modify_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '修改人ID',
  modify_time   DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '修改时间',
  CONSTRAINT movie_info_id_uindex
  UNIQUE (id)
)
  COMMENT '影片信息表';

-- auto-generated definition
CREATE TABLE movie_list
(
  id                INT AUTO_INCREMENT
    PRIMARY KEY,
  movie_list_name   VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '影单名称',
  movie_list_author VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '影单作者',
  movie_list_source VARCHAR(5) DEFAULT 'NULL'               NULL
  COMMENT '影单来源；0:豆瓣；1:IMDB；2:letterboxd；3:烂番茄；4:Netflix；5:Facebook;6:用户；7:PGC(内部)',
  poster            VARCHAR(300) DEFAULT 'NULL'             NULL
  COMMENT '影单海报（默认选影单内第一部电影的海报！！！暂定）',
  shorthand         VARCHAR(32) DEFAULT 'NULL'              NULL
  COMMENT '演员名字简拼',
  create_id         INT DEFAULT 'NULL'                      NULL
  COMMENT '创建人ID',
  create_time       TIMESTAMP DEFAULT 'current_timestamp()' NOT NULL
  COMMENT '创建时间',
  modify_id         INT DEFAULT 'NULL'                      NULL
  COMMENT '修改人ID',
  modify_time       DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '修改时间',
  CONSTRAINT movie_list_id_uindex
  UNIQUE (id)
)
  COMMENT '影单表';


-- auto-generated definition
CREATE TABLE movie_list_details
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  movie_list_id INT DEFAULT 'NULL'                      NULL
  COMMENT '影单ID',
  movie_info_id INT DEFAULT 'NULL'                      NULL
  COMMENT '影片ID',
  create_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '创建人ID',
  create_time   TIMESTAMP DEFAULT 'current_timestamp()' NOT NULL
  COMMENT '创建时间',
  modidy_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '修改人',
  modify_time   DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '修改时间',
  CONSTRAINT movie_list_details_id_uindex
  UNIQUE (id)
)
  COMMENT '影单详情表';

-- auto-generated definition
CREATE TABLE sys_permission
(
  id         INT AUTO_INCREMENT
  COMMENT '主键'
    PRIMARY KEY,
  name       VARCHAR(128)                NOT NULL
  COMMENT '资源名称',
  type       VARCHAR(32)                 NOT NULL
  COMMENT '资源类型：menu,button,',
  url        VARCHAR(128) DEFAULT 'NULL' NULL
  COMMENT '访问url地址',
  percode    VARCHAR(128) DEFAULT 'NULL' NULL
  COMMENT '权限代码字符串',
  parentid   BIGINT DEFAULT 'NULL'       NULL
  COMMENT '父结点id',
  parentids  VARCHAR(128) DEFAULT 'NULL' NULL
  COMMENT '父结点id列表串',
  sortstring VARCHAR(128) DEFAULT 'NULL' NULL
  COMMENT '排序号',
  available  CHAR DEFAULT 'NULL'         NULL
  COMMENT '是否可用,1：可用，0不可用',
  CONSTRAINT permission_id_uindex
  UNIQUE (id)
)
  COMMENT '权限表';

-- auto-generated definition
CREATE TABLE sys_role
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  role_name   VARCHAR(32) DEFAULT 'NULL'              NULL
  COMMENT '角色名称',
  description MEDIUMTEXT DEFAULT 'NULL'               NULL
  COMMENT '描述',
  available   CHAR DEFAULT 'NULL'                     NULL
  COMMENT '是否可用,1：可用，0不可用',
  create_id   INT DEFAULT 'NULL'                      NULL
  COMMENT '创建人ID',
  create_time TIMESTAMP DEFAULT 'current_timestamp()' NOT NULL
  COMMENT '创建时间',
  modify_id   INT DEFAULT 'NULL'                      NULL
  COMMENT '修改人ID',
  modify_time DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '修改时间',
  CONSTRAINT roles_id_uindex
  UNIQUE (id)
)
  COMMENT '角色表';

-- auto-generated definition
CREATE TABLE sys_role_permission
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  role_id       INT NOT NULL
  COMMENT '角色id',
  permission_id INT NOT NULL
  COMMENT '权限id',
  CONSTRAINT role_permission_id_uindex
  UNIQUE (id)
);

-- auto-generated definition
CREATE TABLE security_code
(
  id             INT AUTO_INCREMENT
    PRIMARY KEY,
  phone_num      VARCHAR(20) DEFAULT 'NULL'              NULL
  COMMENT '手机号',
  security_code  VARCHAR(18) DEFAULT 'NULL'              NULL
  COMMENT '验证码',
  return_message VARCHAR(100) DEFAULT 'NULL'             NULL
  COMMENT '接口返回信息',
  business_type  VARCHAR(5) DEFAULT 'NULL'               NULL
  COMMENT '登录类型：0：注册；1：登录',
  is_effective   VARCHAR(5) DEFAULT 'NULL'               NULL
  COMMENT '验证码是否有效；0：无效；1：有效',
  is_success     VARCHAR(5) DEFAULT 'NULL'               NULL
  COMMENT '发送是否成功；0：成功；1：失败',
  create_id      INT DEFAULT 'NULL'                      NULL
  COMMENT '创建人ID',
  create_time    TIMESTAMP DEFAULT 'current_timestamp()' NOT NULL
  COMMENT '创建时间',
  modify_id      INT DEFAULT 'NULL'                      NULL
  COMMENT '修改人ID',
  modify_time    DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '修改时间',
  CONSTRAINT security_code_id_uindex
  UNIQUE (id)
)
  COMMENT '手机号验证码表';

-- auto-generated definition
CREATE TABLE staff
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  movie_info_id INT DEFAULT 'NULL'                      NULL
  COMMENT '影片信息表ID',
  role          VARCHAR(5) DEFAULT 'NULL'               NULL
  COMMENT '角色：0：导演；1：副导演；2：主演；3：演员；4：出品人；5：制片人',
  name          VARCHAR(32) DEFAULT 'NULL'              NULL
  COMMENT '姓名',
  photo         VARCHAR(300) DEFAULT 'NULL'             NULL
  COMMENT '照片，头像',
  create_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '创建人ID',
  create_time   TIMESTAMP DEFAULT 'current_timestamp()' NOT NULL
  COMMENT '创建时间',
  modify_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '修改人ID',
  modify_time   DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '修改时间',
  CONSTRAINT staff_id_uindex
  UNIQUE (id)
)
  COMMENT '职员表';

-- auto-generated definition
CREATE TABLE sys_user
(
  id            INT AUTO_INCREMENT
  COMMENT '主键'
    PRIMARY KEY,
  name          VARCHAR(50)                             NOT NULL
  COMMENT '用户姓名（真实姓名）',
  nick_name     VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '昵称',
  user_name     VARCHAR(50) DEFAULT 'NULL'              NULL
  COMMENT '用户名',
  password      VARCHAR(100) DEFAULT 'NULL'             NULL
  COMMENT '密码',
  token         VARCHAR(50) DEFAULT 'NULL'              NULL,
  sex           VARCHAR(5) DEFAULT 'NULL'               NULL
  COMMENT '性别',
  phone_number  INT DEFAULT 'NULL'                      NULL
  COMMENT '手机号',
  security_code INT DEFAULT 'NULL'                      NULL
  COMMENT '手机号验证码',
  email         VARCHAR(32) DEFAULT 'NULL'              NULL
  COMMENT '邮箱',
  locked        CHAR DEFAULT 'NULL'                     NULL
  COMMENT '账号是否锁定，0锁定，1未锁定',
  create_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '创建人ID',
  login_time    DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '登录时间',
  create_time   TIMESTAMP DEFAULT 'current_timestamp()' NOT NULL
  COMMENT '创建时间',
  modify_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '修改人ID',
  modify_time   DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '修改时间',
  modify_item   VARCHAR(32) DEFAULT 'NULL'              NULL
  COMMENT '修改项',
  CONSTRAINT user_info_id_uindex
  UNIQUE (id)
)
  COMMENT '用户表';

-- auto-generated definition
CREATE TABLE sys_user_role
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  role_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '角色ID',
  user_id     INT DEFAULT 'NULL'                      NULL
  COMMENT '用户ID',
  create_id   INT DEFAULT 'NULL'                      NULL
  COMMENT '创建人ID',
  create_time TIMESTAMP DEFAULT 'current_timestamp()' NOT NULL
  COMMENT '创建时间',
  modify_id   INT DEFAULT 'NULL'                      NULL
  COMMENT '修改人ID',
  modify_time DATETIME DEFAULT 'NULL'                 NULL
  COMMENT '修改时间',
  CONSTRAINT user_role_id_uindex
  UNIQUE (id)
)
  COMMENT '用户角色表';

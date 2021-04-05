create table t_weblogs
(
    id int auto_increment primary key,
    content    varchar(2000) null,
    ipaddr     varchar(20)   null,
    createtime timestamp     null,
    updatetime timestamp     null
) comment 'Web Log data';



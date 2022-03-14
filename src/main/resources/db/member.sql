DROP TABLE IF EXISTS MEMBER;
CREATE TABLE `MEMBER`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `memberName` varchar(128) NULL COMMENT '会员名称',
  `sex` int(2) NULL COMMENT '性别（1：男，女：2）',
  `age` int(2) NULL COMMENT '年龄',
  `mobile` varchar(64) NULL COMMENT '手机号码',
  `email` varchar(64) NULL COMMENT '邮箱',
  `isDeleted` int(2) NULL COMMENT '是否已删除(1:是，0：否)',
  `updateTime` datetime(0) NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `createTime` datetime(0) NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
);

select * from MEMBER;

insert into MEMBER(memberName,sex,age,mobile,email,isDeleted, createTime) values('jack', 1, 28, '12345678', '123@163.com', 1, now());
insert into MEMBER(memberName,sex,age,mobile,email,isDeleted, createTime) values('lucy', 0, 28, '12345678', '123@163.com', 1, now());

select * from MEMBER;


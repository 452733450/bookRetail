DROP TABLE IF EXISTS member;
CREATE TABLE member  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `membername` varchar(128) NULL COMMENT '会员名称',
  `membertype` int(2) NULL COMMENT '会员等级（1：金牌，2：银牌，3：铜牌）',
  `sex` int(2) NULL COMMENT '性别（1：男，2：女）',
  `age` int(2) NULL COMMENT '年龄',
  `mobile` varchar(64) NULL COMMENT '手机号码',
  `email` varchar(64) NULL COMMENT '邮箱',
  `isdeleted` int(2) NULL COMMENT '是否已删除(1:是，0：否)',
  `updatetime` datetime(0) NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `createtime` datetime(0) NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
);



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

DROP TABLE IF EXISTS book;
CREATE TABLE book  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(64) NULL COMMENT '书名',
  `price` decimal(10, 2) NULL COMMENT '单价',
  `store` bigint(20) NULL COMMENT '库存',
  `version` bigint(20) NULL COMMENT '版本号',
  `isdeleted` int(2) NULL COMMENT '是否已删除(1:是，0：否)',
  `updatetime` datetime(0) NULL COMMENT '更新时间',
  `createtime` datetime(0) NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS bizorder;
CREATE TABLE bizorder  (
  `id` bigint(20) NOT NULL,
  `orderno` varchar(64) NULL COMMENT '订单号',
  `memberid` bigint(20) NULL COMMENT '会员id',
  `total` decimal(10, 2) NULL COMMENT '总价',
  `isdeleted` int(2) NULL COMMENT '是否已删除(1:是，0：否)',
  `updatetime` datetime(0) NULL COMMENT '更新时间',
  `createtime` datetime(0) NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS orderdetail;
CREATE TABLE orderdetail  (
  `id` bigint(20) NOT NULL,
  `bizorderid` bigint(20) NULL COMMENT '订单id',
  `orderno` varchar(64) NULL COMMENT '订单编号',
  `memberid` bigint(0) NULL COMMENT '会员id',
  `bookid` bigint(20) NULL COMMENT '书籍id',
  `num` int(0) NULL COMMENT '购买数量',
  `price` decimal(10, 2) NULL COMMENT '购买单价',
  `total` decimal(10, 2) NULL COMMENT '总价',
  `isdeleted` varchar(255) NULL COMMENT '是否已删除(1:是，0：否)',
  `updatetime` datetime(0) NULL COMMENT '更新时间',
  `createtime` datetime(0) NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS point;
CREATE TABLE point (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `memberid` bigint(20) DEFAULT NULL COMMENT '会员id',
  `total` decimal(10,2) DEFAULT NULL COMMENT '总积分',
  `isdeleted` int(2) DEFAULT NULL COMMENT '是否已删除(1:是，0：否)',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
);





CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `couponcode` varchar(45) NOT NULL,
  `registDate` datetime DEFAULT NULL,
  `validDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`email`,`couponcode`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8
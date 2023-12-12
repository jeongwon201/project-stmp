-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.10-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- stmp 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `stmp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `stmp`;

-- 테이블 stmp.player 구조 내보내기
CREATE TABLE IF NOT EXISTS `player` (
  `backNum` int(11) NOT NULL DEFAULT 0,
  `pos` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `birth` varchar(50) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `comment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`backNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 stmp.tactics 구조 내보내기
CREATE TABLE IF NOT EXISTS `tactics` (
  `name` varchar(50) NOT NULL,
  `formation` varchar(50) DEFAULT NULL,
  `p1` varchar(50) DEFAULT NULL,
  `p1_t` varchar(50) DEFAULT NULL,
  `p2` varchar(50) DEFAULT NULL,
  `p2_t` varchar(50) DEFAULT NULL,
  `p3` varchar(50) DEFAULT NULL,
  `p3_t` varchar(50) DEFAULT NULL,
  `p4` varchar(50) DEFAULT NULL,
  `p4_t` varchar(50) DEFAULT NULL,
  `p5` varchar(50) DEFAULT NULL,
  `p5_t` varchar(50) DEFAULT NULL,
  `p6` varchar(50) DEFAULT NULL,
  `p6_t` varchar(50) DEFAULT NULL,
  `p7` varchar(50) DEFAULT NULL,
  `p7_t` varchar(50) DEFAULT NULL,
  `p8` varchar(50) DEFAULT NULL,
  `p8_t` varchar(50) DEFAULT NULL,
  `p9` varchar(50) DEFAULT NULL,
  `p9_t` varchar(50) DEFAULT NULL,
  `p10` varchar(50) DEFAULT NULL,
  `p10_t` varchar(50) DEFAULT NULL,
  `p11` varchar(50) DEFAULT NULL,
  `p11_t` varchar(50) DEFAULT NULL,
  `comment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 stmp.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(50) NOT NULL,
  `pw` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `birth` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

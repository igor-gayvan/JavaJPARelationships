--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 7.1.13.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 24.06.2016 14:01:17
-- Версия сервера: 5.7.13-log
-- Версия клиента: 4.1
--


--
-- Описание для базы данных test
--
DROP DATABASE IF EXISTS test;
CREATE DATABASE IF NOT EXISTS test
CHARACTER SET utf8
COLLATE utf8_general_ci;

-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

-- 
-- Установка базы данных по умолчанию
--
USE test;

--
-- Описание для таблицы categories
--
CREATE TABLE IF NOT EXISTS categories (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 4
AVG_ROW_LENGTH = 5461
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

--
-- Описание для таблицы pages
--
CREATE TABLE IF NOT EXISTS pages (
  id int(11) NOT NULL AUTO_INCREMENT,
  path varchar(255) NOT NULL,
  title varchar(1024) DEFAULT NULL,
  body text DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 3
AVG_ROW_LENGTH = 8192
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

--
-- Описание для таблицы posts
--
CREATE TABLE IF NOT EXISTS posts (
  id int(11) NOT NULL AUTO_INCREMENT,
  timestamp datetime DEFAULT NULL,
  nick varchar(255) DEFAULT NULL,
  text text DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

--
-- Описание для таблицы settings
--
CREATE TABLE IF NOT EXISTS settings (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  value text DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

--
-- Описание для таблицы uploads
--
CREATE TABLE IF NOT EXISTS uploads (
  id int(11) NOT NULL AUTO_INCREMENT,
  filename varchar(255) DEFAULT NULL,
  length bigint(20) DEFAULT NULL,
  timestamp datetime DEFAULT NULL,
  checksum varchar(32) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX checksum_UNIQUE (checksum)
)
ENGINE = INNODB
AUTO_INCREMENT = 6
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

--
-- Описание для таблицы users
--
CREATE TABLE IF NOT EXISTS users (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) DEFAULT NULL,
  password varchar(32) DEFAULT NULL COMMENT 'MD5 hash',
  PRIMARY KEY (id),
  UNIQUE INDEX username_UNIQUE (username)
)
ENGINE = INNODB
AUTO_INCREMENT = 10
AVG_ROW_LENGTH = 3276
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

--
-- Описание для таблицы authors
--
CREATE TABLE IF NOT EXISTS authors (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  user_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX user_id_UNIQUE (user_id),
  CONSTRAINT fk_author_user FOREIGN KEY (user_id)
  REFERENCES users (id) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

--
-- Описание для таблицы articles
--
CREATE TABLE IF NOT EXISTS articles (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(255) DEFAULT NULL,
  content text DEFAULT NULL,
  timestamp datetime DEFAULT NULL,
  author_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX fk_article_author_idx (author_id),
  CONSTRAINT kjjk FOREIGN KEY (author_id)
  REFERENCES authors (id) ON DELETE NO ACTION ON UPDATE NO ACTION
)
ENGINE = INNODB
AUTO_INCREMENT = 14
AVG_ROW_LENGTH = 1489
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

--
-- Описание для таблицы articles_has_categories
--
CREATE TABLE IF NOT EXISTS articles_has_categories (
  id int(11) NOT NULL AUTO_INCREMENT,
  article_id int(11) NOT NULL,
  category_id int(11) NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_articles_idx (article_id),
  INDEX fk_categories_idx (category_id),
  CONSTRAINT fk_articles FOREIGN KEY (article_id)
  REFERENCES articles (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_categories FOREIGN KEY (category_id)
  REFERENCES categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION
)
ENGINE = INNODB
AUTO_INCREMENT = 4
AVG_ROW_LENGTH = 5461
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

-- 
-- Вывод данных для таблицы categories
--
INSERT INTO categories VALUES
(1, 'Western'),
(2, 'Education'),
(3, 'Horror');

-- 
-- Вывод данных для таблицы pages
--
INSERT INTO pages VALUES
(1, 'index', 'Index page', '<h1>Hello, Web JDBC!</h1>'),
(2, 'second', 'Second page', '<div id="lipsum">\n<p>\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Ut id cursus odio, id aliquet diam. Pellentesque lobortis eros sem, aliquam iaculis nulla porttitor et. Fusce neque enim, mattis non quam non, gravida dignissim felis. Donec egestas urna ut suscipit congue. Proin sit amet elit pretium, facilisis nisi id, sodales leo. Donec egestas sed eros eget mattis. Vestibulum magna urna, fringilla nec sapien eu, accumsan feugiat est. Aliquam pretium in erat non molestie. Nam sed arcu euismod, auctor nisi ac, pharetra ex. Mauris elementum, magna sit amet ornare rhoncus, elit tellus ultrices tellus, viverra finibus lectus ipsum a felis.\n</p>\n<p>\nVestibulum sit amet odio lobortis, elementum diam eget, tincidunt leo. Duis elementum dictum elit, non aliquet urna mollis in. Nam iaculis viverra commodo. Nunc accumsan posuere libero eu vehicula. Donec finibus aliquet nisi, vel hendrerit turpis rutrum eu. Nullam mi enim, ullamcorper nec tempus sed, eleifend vitae mauris. Sed aliquam massa id augue blandit, et porttitor sapien euismod. Mauris porttitor risus id lectus porta, at ullamcorper ligula consequat. Duis suscipit, ante non molestie condimentum, quam ipsum imperdiet justo, vel iaculis arcu nisl a mi. Proin risus lectus, porttitor mollis lectus vitae, pretium pulvinar diam. Fusce viverra sagittis eleifend. Proin condimentum velit rutrum elit consectetur, vel commodo lacus tincidunt.\n</p>\n<p>\nNullam et rhoncus lorem. Integer porta massa metus, ut fermentum erat molestie rhoncus. Ut elementum convallis lacus et tempor. Sed at bibendum diam. Curabitur leo nibh, convallis eu lectus sollicitudin, semper consectetur erat. Cras vel faucibus lacus. Sed at leo ullamcorper, consequat turpis eget, congue risus. Praesent dolor sapien, tristique vitae vehicula nec, pretium eu justo. Donec eget justo urna. Maecenas at ligula maximus, maximus eros ut, eleifend massa. Nullam ac congue risus. Donec sit amet quam mi.\n</p>\n<p>\nMorbi et fringilla ex. Quisque mattis magna at leo fringilla, sed ullamcorper elit fermentum. Duis id dignissim lacus, non scelerisque nulla. Donec finibus erat ac magna vestibulum, id hendrerit lacus imperdiet. In ac lobortis dui. Cras pretium dui id ipsum tempor, ut feugiat ex dictum. Maecenas eget rhoncus tellus. Duis neque neque, maximus ac ligula ut, sodales egestas nibh. Aliquam facilisis ornare arcu, at vehicula orci sodales sed. Nullam finibus erat purus, a convallis odio aliquam id. Duis in iaculis nunc, quis rhoncus est. Suspendisse vel leo at mauris ullamcorper aliquet. Proin semper est turpis, eget tempus odio tristique eu. Mauris velit felis, efficitur vitae consequat eu, accumsan ac sapien. Vestibulum vestibulum vestibulum aliquet. Ut ultrices consectetur lorem, at rutrum diam tincidunt nec.\n</p>\n<p>\nIn vehicula nisi non aliquam congue. Donec sagittis diam nec tortor eleifend, sit amet scelerisque augue convallis. Integer nec enim nec odio dapibus molestie sed ut libero. Pellentesque cursus quam vel mollis venenatis. Integer quis congue dolor. Maecenas consectetur erat nisl, nec tristique orci volutpat et. Proin sed faucibus ex. Aliquam eget fringilla ligula. In bibendum sodales magna, vitae rhoncus nunc aliquet vel. Etiam tempor porttitor risus, quis porta nulla blandit eu.\n</p></div>');

-- 
-- Вывод данных для таблицы posts
--

-- Таблица test.posts не содержит данных

-- 
-- Вывод данных для таблицы settings
--
INSERT INTO settings VALUES
(1, 'default.page', 'index'),
(2, 'web.site.name', 'CodeFireUA'),
(3, 'web.site.vendor.name', 'Self Consntruct'),
(4, 'web.site.vendor.site', 'http://self.construct.com/');

-- 
-- Вывод данных для таблицы uploads
--
INSERT INTO uploads VALUES
(1, 'codefire-office-net.txt', 281, '2016-06-04 10:49:24', '39d795d557ad594c356337b5abe34aac'),
(3, 'docker-mysql.txt', 100, '2016-06-04 10:57:06', '21d00e3abb5971ff16c441ecddcda8ba'),
(4, 'lessons-core.txt', 705, '2016-06-04 10:57:06', '50379c493d3f271cfa5cd42212429124'),
(5, 'lessons-standart-edition.txt', 322, '2016-06-04 10:57:06', '0ceba21c87efe4ac2ef45822192c1516');

-- 
-- Вывод данных для таблицы users
--
INSERT INTO users VALUES
(1, 'v.pupkin56', 'e9a10849d8a3a5f9389eb5064022ff12'),
(2, 'user', '4123e5cc43794e5972cee1cf00382445'),
(3, 'admin', '21232f297a57a5a743894a0e4a801fc3'),
(4, 'm.pupkin56', '94230a27fafa3613bf2d10bb18773775'),
(5, 'manager', 'a152e841783914146e4bcd4f39100686');

-- 
-- Вывод данных для таблицы authors
--
INSERT INTO authors VALUES
(1, 'Unknown', 1),
(2, 'Vasya Pupkin', NULL),
(3, 'Petya Vaskin', NULL),
(4, 'New Author', NULL);

-- 
-- Вывод данных для таблицы articles
--
INSERT INTO articles VALUES
(1, 'JPA in action! #1', 'Praesent malesuada auctor ante, sit amet rhoncus nunc luctus et. Donec cursus dui tellus, in cursus arcu tristique in. In dolor libero, elementum non venenatis id, condimentum vitae lectus. Mauris luctus vel odio rutrum vehicula. Donec vel urna vel tortor tempus iaculis pretium eget arcu. Nam ac sapien suscipit diam mattis finibus ut vel tortor. Integer et orci elit.', '2016-05-29 10:51:10', 3),
(2, 'JPA in action! #2', 'Vestibulum efficitur quam lacus, at aliquet nulla finibus scelerisque. Vestibulum venenatis turpis a purus cursus, sit amet congue justo viverra. Ut fermentum vehicula neque, et mattis nisl aliquet vel. Nullam dapibus, dui non faucibus pulvinar, neque felis hendrerit sapien, vitae viverra purus lectus eu nunc. Duis a vestibulum magna. Sed semper vestibulum tellus, vel malesuada velit interdum eu. Phasellus dictum vel nisi non blandit. Donec vitae egestas libero. Curabitur sollicitudin eu lorem ac bibendum. Duis porttitor ornare mi, et tincidunt tellus consectetur eget.', '2016-05-29 10:52:37', 1),
(3, 'JPA in action! #3', 'Mauris mauris augue, dictum sit amet volutpat non, pellentesque a lacus. Integer non dapibus metus. In eu tincidunt arcu, eget consequat diam. Nunc enim ex, euismod ut dolor a, volutpat tempor eros. Nam commodo bibendum dolor sed fringilla. Ut et fringilla libero. Cras consequat, urna at elementum convallis, orci odio ultricies lectus, rhoncus varius elit ex vitae sapien. Suspendisse potenti. Pellentesque tempor nisi sit amet rhoncus lacinia. Quisque venenatis, sem non suscipit malesuada, metus risus viverra quam, sit amet commodo tortor dui in velit. Suspendisse tempor ullamcorper nunc. Proin semper mollis felis, vel placerat odio finibus non. In turpis mauris, cursus vitae sodales et, pretium at sapien. Maecenas non felis ut nisi venenatis pellentesque quis in mauris. Phasellus lacinia ultricies rutrum.', '2016-05-29 10:53:56', 2),
(4, 'JPA in action! #4', 'Nullam id nulla justo. Donec efficitur hendrerit libero id elementum. In tincidunt ligula a nisi auctor placerat. Vivamus ullamcorper convallis lacus et accumsan. Mauris fringilla mattis massa sit amet suscipit. Vestibulum at leo sapien. Donec vitae turpis et sem tincidunt tincidunt mattis vel tellus. Proin aliquet placerat hendrerit. Duis at nunc leo. Vivamus ut mauris erat. Quisque cursus eu odio non tempor. Phasellus et massa eget augue pharetra rutrum a sed lorem. Nullam dictum gravida metus, eget pharetra dolor convallis eu. Morbi magna mi, iaculis nec diam et, fermentum finibus elit.', '2016-05-29 10:54:31', 1),
(6, 'Simple title', '!!!!!!!!!!!', '2016-06-05 14:01:31', 2),
(7, 'Simple title', 'asdasd', '2016-06-05 14:01:31', 1),
(8, 'Simple title', 'asdasd', '2016-06-05 14:01:31', 3),
(9, 'Simple title', 'asdasd', '2016-06-05 14:01:31', 3),
(10, 'Simple title', 'asdasd', '2016-06-05 14:07:59', 1),
(11, 'OK', 'Text for testing...', '2016-06-09 19:26:25', 1),
(13, NULL, NULL, NULL, 4);

-- 
-- Вывод данных для таблицы articles_has_categories
--
INSERT INTO articles_has_categories VALUES
(1, 1, 1),
(2, 2, 3),
(3, 3, 2);

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
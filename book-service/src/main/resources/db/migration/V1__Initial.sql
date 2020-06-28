create table `book` (
  `book_id` bigint(20) not null auto_increment,
  `author` varchar(255) default null,
  `created_on` datetime default null,
  `description` varchar(1000) default null,
  `isbn` varchar(255) default null,
  `language` varchar(255) default null,
  `pages` int(11) not null,
  `price` decimal(10,2) default null,
  `published_date` date default null,
  `publisher` varchar(255) default null,
  `title` varchar(255) default null,
  `updated_on` datetime default null,
  primary key (`book_id`)
)

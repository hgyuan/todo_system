DROP TABLE IF EXISTS todo_item;
CREATE TABLE todo_item (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  text varchar(255) not null,
  mark boolean not null default false
);

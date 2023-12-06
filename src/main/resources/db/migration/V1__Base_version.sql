create table files(
id_file int not null auto_increment primary key,
file_name varchar(256) not null,
file_path varchar(256) not null
);

create table users(
id_user int not null auto_increment primary key,
user_name varchar(256) not null
);

create table events(
id_event int not null auto_increment primary key,
file_id int not null,
user_id int not null
);

alter table events add foreign key (user_id) references users(id_user) on delete cascade;
alter table events add foreign key (file_id) references files(id_file) on delete cascade;

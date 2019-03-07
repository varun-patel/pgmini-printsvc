create table users
(
	studentNumber int not null,
	firstName VARCHAR(32) not null,
	lastName VARCHAR(32) not null,
	password VARCHAR(128) not null,
	quota INT[] not null,
	student BOOLEAN not null,
	admin BOOLEAN not null,
	UUID UUID not null,
	metadata JSON
);

create unique index users_UUID_uindex
	on users (UUID);

create unique index users_studentNumber_uindex
	on users (studentNumber);

alter table users
	add constraint users_pk
		primary key (studentNumber);


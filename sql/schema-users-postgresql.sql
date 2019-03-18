/*
        PGMINI PRINT SERVICE
        Copyright (C) 2019  Varun Patel <varun@varunpatel.ca>

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <https://www.gnu.org/licenses/>.


        ****************************************************************
        ******** IT IS STRONGLY RECOMMENDED THAT YOU CHANGE BOTH********
        ********THE PRINTSVCRUNNER USER PASSWORD AND THE DEFAULT********
        ********     USER PASSWORD BEFORE USING THIS SCRIPT,    ********
        ********       INSTRUCTIONS CAN BE FOUND ON GITHUB      ********
        ****************************************************************
        Prior to running this script create a database called printsvc and connect to it.


 */
drop table if exists users;
create user printsvcrunner;
grant all privileges on database printsvc to printsvcrunner;
alter user printsvcrunner with password 'asdf';

create table users
(
  studentNumber int not null,
  firstName VARCHAR(32) not null,
  lastName VARCHAR(32) not null,
  password VARCHAR(128) not null,
  quota INT[] not null,
  student BOOLEAN not null,
  admin BOOLEAN not null,
  gradYear INT not null,
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

insert into users (studentNumber, firstName, lastName, password, quota, student, admin, gradYear, UUID)
  VALUES (1, 'Print', 'Admin', '77510AE0A208194EA80FF950E6D4244B911F977298EAD53636A4931E2FCAD842', '{999999,999999}', true, true, 999999, 'd6f20d58-8088-48de-877a-d7d64aa687ab');
create table tbl_user
(
    id varchar2(255) primary key not null,
    created_on_timestamp timestamp,
    last_modified_on_timestamp timestamp,
    created_by_id varchar2(255),
    last_modified_by_id varchar2(255),
    username varchar2(255),
    password varchar2(255)
);
alter table tbl_user add foreign key (created_by_id) references tbl_user (id);
alter table tbl_user add foreign key (last_modified_by_id) references tbl_user (id);

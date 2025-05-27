create database quanlysanpham;

use quanlysanpham;

create table Categories(
    id int auto_increment primary key ,
    name varchar(255) not null unique ,
    description text ,
    status bit default 1
);


create table Products(
    id int auto_increment primary key ,
    name varchar(255) not null ,
    description varchar(255) ,
    price double check ( price > 0 )  ,
    image_url varchar(500) ,
    status bit default 1 ,
    create_at datetime default current_timestamp,
    category_id  int not null,
    foreign key (category_id) references Categories(id)
);

-- lay danh sach danh muc
delimiter &&
create procedure get_all_category()
begin
    select * from Categories;
end &&
delimiter &&

-- them danh muc
delimiter &&
create procedure add_category(
    in_name varchar(255),
    in_description text
)
begin
    insert into Categories (name, description)
    values (in_name, in_description);
end &&
delimiter &&

-- tim kiem danh muc theo id
delimiter &&
create procedure get_category_by_id(
    in_id int
)
begin
    select * from Categories where id = in_id;
end &&
delimiter &&


-- tim kiem danh muc theo ten
delimiter &&
create procedure get_category_by_name(
    in_name varchar(255)
)
begin
    select * from Categories where name like concat('%', in_name, '%');
end &&
delimiter &&



delimiter &&
create procedure is_existed(
    in_name varchar(255)
)
begin
    select * from Categories where name = in_name;
end &&
delimiter &&





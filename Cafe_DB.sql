create type user_type as ENUM('customer', 'employee');

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS orders;

create table users(
	user_id serial not null primary key,
	name varchar(255) not null,
	email varchar(255) not null,
	password varchar(255) not null,
	type user_type not null
);

create table orders(
	orderNumber serial not null primary key,
	foodOrdered text[] not null,
	user_id serial not null,
	constraint fk_users
		foreign key(user_id)
			references users(user_id)
);


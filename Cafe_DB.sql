
if not exists (
create type user_type as ENUM('customer', 'employee')
);

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

insert into users (name, email, password, type)
values ('Admin', 'admin@cafe.com', 'AdminPassword1', 'employee');

insert into users (name, email, password, type)
values ('Marc Settin', 'marc.settin@email.com', 'MarcPassword1', 'customer');

create table food_on_order(
    ordernumber int references orders(ordernumber) not null,
    food_id int not null
);

ALTER TABLE food_on_order ADD CONSTRAINT fk_food_on_order
    FOREIGN KEY (ordernumber) REFERENCES orders (ordernumber) ON DELETE CASCADE ON UPDATE CASCADE;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO java_login;
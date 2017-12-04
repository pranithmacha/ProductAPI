
-- create a keyspace
create keyspace if not exists target with replication = {'class':'SimpleStrategy','replication_factor':1};

-- use keyspace
use target;

-- create table
create table product(productid bigint primary key, price double);

-- insert products
insert into product(productid, price) values(22222111, 243.87);
insert into product(productid, price) values(1234567, 243.87);

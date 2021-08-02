create table product(productId bigint primary key, name varchar(256), price decimal(8,2), description text, categoryId bigint, createAt datetime, updateAt datetime);
create table category(categoryId bigint primary key, name varchar(256), parentId bigint, createAt datetime, updateAt datetime);
create table tag(tagId bigint primary key, name varchar(256), createAt datetime, updateAt datetime);
create table product_tag(productId bigint, tagId bigint, createAt datetime, updateAt datetime, primary key(productId, tagId));
create table orders(orderId bigint primary key, totalAmount decimal(8,2), purchaseOrderdate datetime, createAt datetime, updateAt datetime);
create table orderLine(orderId bigint, orderLineId bigint, productId bigint, quantity integer, amount decimal(8,2), createAt datetime, updateAt datetime, primary key(orderId, orderLineId));
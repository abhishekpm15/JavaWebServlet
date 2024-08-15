
create table Registration (CustomerID INTEGER primary key not null,
		CustomerName varchar(20) not null ,
		CustomerEmail varchar(20) not null,
		CustomerPassword varchar(20) not null ,
		CustomerAddress varchar(70) not null,
		ContactNumber varchar(10)not null );
		
	drop table registration
	drop table LoginStatus
	drop table WishList
	drop table product



select * from LoginStatus;
select * from registration;


create table LoginStatus ( id int primary key not null,
lastLogin TIMESTAMP,
lastLogout TIMESTAMP,
isLoggedIn varchar(3));




CREATE TABLE product (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    companyName TEXT NOT NULL,
    price REAL NOT NULL,
    stock INTEGER NOT NULL,
    imageUrl TEXT
);

insert into product (name, description, companyName, price, stock, imageUrl) values("iphone", "Best Iphone ever","Apple", 150000, 100, "https://media-ik.croma.com/prod/https://media.croma.com/image/upload/v1708673189/Croma%20Assets/Communication/Mobiles/Images/300652_0_ncocr2.png?tr=w-360");
insert into product (name, description, companyName, price, stock, imageUrl) values("samsung fold", "Samsung latest Fold model","Samsung", 110000, 80, "https://tse3.mm.bing.net/th/id/OIP.NavQzC8ao-bm5e0FGVwAmAAAAA?rs=1&pid=ImgDetMain");
insert into product (name, description, companyName, price, stock, imageUrl) values("BenQ montior", "Best monitor","BenQ", 15000, 80, "https://image.benq.com/is/image/benqco/01-pd2705q-03-1?$ResponsivePreset$&fmt=png-alpha");
insert into product (name, description, companyName, price, stock, imageUrl) values("TShirt", "Good quality Tshirt","Tshirt", 110000, 80, "https://printzwear.com/wp-content/uploads/2024/02/black-color-born-to-rock-printed-t-shirt-on-a-hanger.png");
insert into product (name, description, companyName, price, stock, imageUrl) values("Sweater", "Best quality Sweater","Sweater", 110000, 80, "https://www.versace.com/dw/image/v2/BGWN_PRD/on/demandware.static/-/Sites-ver-master-catalog/default/dw610523e3/original/90_1013621-1A09601_1E880_10_Cashmere~BlendZipSweater-Clothing-Versace-online-store_2_2.jpg?sw=850&q=85&strip=true");

drop from product;
--create table LoginStatus ( id int primary key not null,
--lastLogin TIMESTAMP,
--lastLogout TIMESTAMP,
--isLoggedIn varchar(3));

--select * from Registration;

select * from Product;
select * from wishlist
drop from wishlist
create table Wishlist (Wishlist_id INTEGER primary key autoincrement, CustomerID INTEGER , ProductID INTEGER , quantity INTEGER, FOREIGN KEY (CustomerID) References Registration(CustomerID), FOREIGN KEY (ProductID) References Product(id));
insert into Wishlist (CustomerID, ProductID, quantity) values (36634,18,10);
insert into Wishlist (CustomerID, ProductID, quantity) values (36634,19,12);
insert into Wishlist (CustomerID, ProductID, quantity) values (36634,20,2);
insert into Wishlist (CustomerID, ProductID, quantity) values (36634,21,1);
insert into Wishlist (CustomerID, ProductID, quantity) values (36634,22,5);


select * from Wishlist;
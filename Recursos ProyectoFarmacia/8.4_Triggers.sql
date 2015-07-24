use Northwind

select * from Categories
select * from Northwind.dbo.  products where CategoryID=2

create trigger delCat on categories
After delete as
begin
	update products set discontinued=1
	from products  inner join deleted as d
	on products.categoryID=d.[categoryID]
end
go

alter table products
nocheck
constraint FK_Products_Categories

delete from Categories where CategoryID=2
go

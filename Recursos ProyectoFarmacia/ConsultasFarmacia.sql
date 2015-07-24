
insert into Tipo_Telefono(Tipo)values("Casa");
insert into Tipo_Telefono(Tipo)values("Movil");
insert into Tipo_Telefono(Tipo)values("Oficina");

insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("LABYMED","QUETZALTENANGO", "77618413",1);
insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("BONIN","QUETZALTENANGO", "77618414",1);
insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("APPLE","QUETZALTENANGO", "77618415",1);
insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("GOOGLE","QUETZALTENANGO", "77618416",1);
insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("PHARA","QUETZALTENANGO", "77618417",1);
insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("LOCOS","QUETZALTENANGO", "77618418",1);
insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("MEDICINA","QUETZALTENANGO", "77618419",1);
insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("ANGNOSTIC","QUETZALTENANGO", "77618423",1);
insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("LOPUS","QUETZALTENANGO", "77618422",1);
insert into Fabricante(Nombre, Direccion, Telefono, Tipo_Telefono_id)values("LABAD","QUETZALTENANGO", "77618445",1);


insert into Producto(Nombre, CodigoP, Fabricante_id)values("Urea", "UREA102", 1);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("Vacutainer", "VACU102", 2);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("Hemoglobina Glucosilada", "GLUCO102",3);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("TUBOS", "TUBO102", 4);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("AGUJA", "AGU102", 5);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("PCR", "PCR102",6);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("FACTOR REMA", "FR102", 7);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("LUGO", "LUGO102", 8);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("WRIT", "WRI102",9);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("ZRII", "ZR102", 10);
insert into Producto(Nombre, CodigoP, Fabricante_id)values("HARMAN", "HAR102", 1);

insert into Tipo_Usuario(Tipo)values("Vendedor");
insert into Tipo_Usuario(Tipo)values("Administrador");


insert into Empleado(Nombre, Apellido, Sexo, Direccion, NIT, DPI, Tipo_Usuario_id)values("Lester Josue", "Meneses Siliezar", 1, "24 Avenida 4-94", "656765", "1234 45673 090", 1);
insert into Empleado(Nombre, Apellido, Sexo, Direccion, NIT, DPI, Tipo_Usuario_id)values("Diego Marvin", "Mendez Santizo", 1, "24 Avenida 4-94", "656765", "1234 45673 090", 2);

INSERT INTO Login(Usuario, Contraseña, Empleado_id)values("LS1234", sha("1234"), 1);

insert into Presentacion(Presentacion)values("Suspension");
insert into Presentacion(Presentacion)values("Comprimido");
insert into Presentacion(Presentacion)values("Capsula");
insert into Presentacion(Presentacion)values("Jarabe");
insert into Presentacion(Presentacion)values("Suspension");
insert into Presentacion(Presentacion)values("Papelillos");
insert into Presentacion(Presentacion)values("Enemas");
insert into Presentacion(Presentacion)values("Pomada");
insert into Presentacion(Presentacion)values("Supositorios");

insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Juan", "Matul", "Ciudad", "8987765");
insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Daniel", "Rivera", "Ciudad", "8987765");
insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Pablo", "Salanic", "Ciudad", "8987765");
insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Marco", "Pez", "Ciudad", "8987765");
insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Jorge", "Soch", "Ciudad", "8987765");
insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Everto", "Tzul", "Ciudad", "8987765");
insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Erick", "Sam", "Ciudad", "8987765");
insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Gerson", "Jucup", "Ciudad", "8987765");
insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Enrique", "Capu", "Ciudad", "8987765");


insert into Proveedor(Nombre, Alias, NIT, Correo)values("Lic. Iliana Patricia Lopez Gutierrez", "Microdiagnostic", "518360k", "");
insert into Proveedor(Nombre, Alias, NIT, Correo)values("Labymed, S.A", "Labymed", "518360k", "ventas.labymed@labymed.com.gt");

insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja, Proveedor_id)values(1,2,13,10,2,1);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja, Proveedor_id)values(2,3,14,101,2,1);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja, Proveedor_id)values(3,4,17,102,2,1);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja, Proveedor_id)values(4,5,16,103,2,2);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja, Proveedor_id)values(5,6,18,104,2,2);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja, Proveedor_id)values(6,7,18,105,2,2);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja, Proveedor_id)values(7,8,19,105,2,2);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja, Proveedor_id)values(8,9,3,106,2,2);

insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values("12345",160102,10,3,3);
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values("123456",160103,11,4,2);
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values("123457",160104,12,5,4);
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values("123458",160105,13,6,5);
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values("123459",160106,14,7,6);
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values("1234510",160107,15,8,7);
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values("1234511",160108,16,9,8);
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values("1234512",160109,17,10,9);
select *from Producto_Presentacion;


insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 60.4, 1,1,"A","364032", 1);
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 70.4, 2,1,"A","364033", 1);
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 80.4, 2,1,"A","36404", 1);
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 90.4, 1,1,"A","36405", 1);
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 110.4, 2,1,"A","36406", 1);
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 1260.4, 1,1,"A","364013", 1);
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 1360.4, 2,1,"A","364063", 1);
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 1460.4, 2,1,"A","364073", 1);
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 1560.4, 2,1,"A","364083", 1);
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 1660.4, 2,1,"A","364093", 1);

insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(20, 2,21,1,1);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(30, 3,23,2,2);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(41, 4,25,3,3);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(42, 7,26,4,4);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(43, 6,28,1,5);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(44, 7,29,2,6);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(45, 8,20,3,7);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(46, 9,22,4,8);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(4, 2,14,5,9);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(480, 4,15,1,1);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(498, 5,10,2,2);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(404, 7,29,3,3);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(403, 8,28,4,4);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(402, 9,26,5,5);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(44, 20, 21,5,6);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(45, 20,2,2,4);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(403, 22,93,4,5);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(404, 1,30,5,8);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(4043, 5,20,6,8);


insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(12.5, '150601',2);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(13.5, '150602',1);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(14.5, '150603',1);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(15.5, '150604',1);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(16.5, '150605',3);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(13.5, '150606',4);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(15.5, '150607',5);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(12.5, '150608',6);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(10.5, '150609',1);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(29.5, '1506010',2);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(22.5, '1506011',3);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(13.5, '150602',5);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(15.5, '150601',2);


INSERT INTO Contacto(Numero, Proveedor_id, Tipo_Telefono_id)values("77630075", 1,1);
INSERT INTO Contacto(Numero, Proveedor_id, Tipo_Telefono_id)values("41518280", 2,2);
INSERT INTO Contacto(Numero, Proveedor_id, Tipo_Telefono_id)values("77630075", 1,1);
INSERT INTO Contacto(Numero, Proveedor_id, Tipo_Telefono_id)values("41518280", 2,2);


Delimiter //
Drop Trigger if exists actualizarOrden//
Create Trigger actualizarOrden
Before Insert on Detalle_Orden
For Each Row
Begin
Declare nuevoTotal DOUBLE default 0;
Declare nuevasExistencias INT default 0;
Select Total into nuevoTotal from Orden where id=New.Orden_id;
Select Existencia_Total into nuevasExistencias from Producto_Presentacion where id=New.Producto_Presentacion_id;
set New.Subtotal=New.Cantidad*New.Precio_Venta;
set nuevoTotal=nuevoTotal+New.Subtotal;
set nuevasExistencias=nuevasExistencias-New.Cantidad;
Update Orden set Total = nuevoTotal where id=New.Orden_id;
Update Producto_Presentacion set Existencia_Total = nuevasExistencias where id=New.Producto_Presentacion_id;
End//

Delimiter //
Drop Trigger if exists actualizarDetalleCompra//
Create Trigger actualizarDetalleCompra
Before Insert on Detalle_Compra
For Each Row
Begin
Declare nuevoTotal DOUBLE default 0;
Declare nuevasExistencias INT default 0;
Select Total into nuevoTotal from Compra where id=New.Compra_id;
Select Existencia_Total into nuevasExistencias from Lote where Producto_Presentacion_id=New.id;
set New.Subtotal=New.Cantidad*New.Precio;
set nuevoTotal=nuevoTotal+New.Subtotal;
set nuevasExistencias=nuevasExistencias+New.Cantidad;
Update Compra set Total = nuevoTotal where id=New.Compra_id;
Update Lote set Existencias_Lote = nuevasExistencias where Producto_Presentacion_id=New.id;
End//


Delimiter //
Drop Trigger if exists actualizarPP//
Create Trigger actualizarPP
after insert on Lote
For Each Row
Begin 
Declare nuevaExistencia INT default 0;
Select Existencia_Lote into nuevaExistencia from Producto_Presentacion where Producto_Presentacion_id=New.id;
set nuevaExistencia = nuevaExistencia+ Existencia_Total;
Update Producto_Presentacion set Existencia_Total = nuevaExistencia where Producto_Presentacion_id=new.id;
End//




insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 444.4, 1,1,"A","dfx12", 1);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(20, 200,21,11,12);

Select * from Producto_Presentacion;

insert into Orden(Fecha, Total, Numero, Serie, Cliente_id, Empleado_id)values(now(), 400, 1906150004, "", 5,1);

select * from Producto;

insert into Detalle_Orden(Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(9,4,1,1);

Select Prod.Nombre, Pre.Presentacion, Prov.Alias, PP.Existencia_Total, PP.Precio_Venta, PP.Unidades_Caja from Producto Prod inner join Producto_Presentacion PP ON Prod.id=PP.Producto_id inner join Proveedor Prov on PP.Proveedor_id=Prov.id inner join Presentacion Pre on PP.Presentacion_id=Pre.id;
Select Prod.Nombre, Pre.Presentacion, Prov.Alias, PP.Existencia_Total, PP.Precio_Venta, PP.Unidades_Caja from Producto Prod inner join Producto_Presentacion PP ON Prod.id=PP.Producto_id inner join Proveedor Prov on PP.Proveedor_id=Prov.id inner join Presentacion Pre on PP.Presentacion_id=Pre.id;

Select Prod.id, Prod.Nombre, Pre.Presentacion, Prov.Alias, PP.Existencia_Total, PP.Precio_Venta, PP.Unidades_Caja, L.Numero as 'Lote', L.Existencias_Lote from Producto Prod inner join Producto_Presentacion PP ON Prod.id=PP.Producto_id inner join Proveedor Prov on PP.Proveedor_id=Prov.id inner join Presentacion Pre on PP.Presentacion_id=Pre.id inner join Lote L on L.Producto_Presentacion_id=L.id;
select * from Producto_Presentacion;

insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values(334234,160109,17,10,3);



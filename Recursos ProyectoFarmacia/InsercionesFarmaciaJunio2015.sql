insert into Tipo_Telefono(Tipo)values("Casa");
insert into Tipo_Telefono(Tipo)values("Movil");
insert into Tipo_Telefono(Tipo)values("Oficina");
select * from Tipo_Telefono;
insert into Fabricante(Nombre, Direccion, Telefono)values("LABYMED","QUETZALTENANGO", "77618413");
insert into Fabricante(Nombre, Direccion, Telefono)values("BONIN","QUETZALTENANGO", "77618414");
insert into Fabricante(Nombre, Direccion, Telefono)values("APPLE","QUETZALTENANGO", "77618415");
insert into Fabricante(Nombre, Direccion, Telefono)values("GOOGLE","QUETZALTENANGO", "77618416");
insert into Fabricante(Nombre, Direccion, Telefono)values("PHARA","QUETZALTENANGO", "77618417");
insert into Fabricante(Nombre, Direccion, Telefono)values("LOCOS","QUETZALTENANGO", "77618418");
insert into Fabricante(Nombre, Direccion, Telefono)values("MEDICINA","QUETZALTENANGO", "77618419");
insert into Fabricante(Nombre, Direccion, Telefono)values("ANGNOSTIC","QUETZALTENANGO", "77618423");
insert into Fabricante(Nombre, Direccion, Telefono)values("LOPUS","QUETZALTENANGO", "77618422");
insert into Fabricante(Nombre, Direccion, Telefono)values("LABAD","QUETZALTENANGO", "77618445");
select * from Fabricante;
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
insert into Producto(Nombre, CodigoP, Fabricante_id)values("HARMAN", "HAR102", 11);

insert into Presentacion(Presentacion)values("Suspension");
insert into Presentacion(Presentacion)values("Comprimido");
insert into Presentacion(Presentacion)values("Capsula");
insert into Presentacion(Presentacion)values("Jarabe");
insert into Presentacion(Presentacion)values("Suspension");
insert into Presentacion(Presentacion)values("Papelillos");
insert into Presentacion(Presentacion)values("Enemas");
insert into Presentacion(Presentacion)values("Pomada");
insert into Presentacion(Presentacion)values("Supositorios");
select * from Presentacion;
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(1, 1, 10, 12.5, 10);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(2, 2, 10, 12.5, 0);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(3, 3, 10, 12.5, 0);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(4, 4, 10, 12.5, 0);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(5, 5, 10, 12.5, 0);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(6, 6, 10, 12.5, 0);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(7, 7, 10, 12.5, 0);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(8, 8, 10, 12.5, 0);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(9, 9, 10, 12.5, 5);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Unidades_Caja)values(10, 1, 10, 12.5, 7);
insert into Historial_PrecioCalle(PrecioCalle, Fecha_Precio, Producto_Presentacion_id)values(12.5, '150601',1);



INSERT INTO ContactoP(Numero, Tipo_Telefono_id, Fabricante_id)values("77630075", 1,1);
INSERT INTO ContactoP(Numero, Tipo_Telefono_id, Fabricante_id)values("41518280", 2,1);
select F.Nombre, F.Direccion, C.Numero, tp.Tipo from Fabricante F inner join ContactoP C on F.id=C.Fabricante_id inner join Tipo_Telefono tp on C.Tipo_Telefono_id=tp.id;
update ContactoP set Tipo_Telefono_id = 2 where idContactoP = 2;
insert into Tipo_Usuario(Tipo)values("Vendedor");
insert into Tipo_Usuario(Tipo)values("Administrador");

insert into Empleado(Nombre, Apellido, Sexo, Direccion, NIT, DPI, Tipo_Usuario_id)values("Diego Marvin", "Mendez Santizo", 1, "24 Avenida 4-94", "656765", "1234 45673 090", 1);
select * from Empleado;
INSERT INTO Login(Usuario, Contraseña, Empleado_id)values("LS1234", sha("1234"), 1);
select Contraseña from Login;
insert into Proveedor(Nombre, Alias, NIT, Correo)values("Labymed, S.A", "Labymed", "30428378", "ventas@labymed.com.gt");
insert into Presentacion(Presentacion)values("Suspension");
insert into Presentacion(Presentacion)values("Tabletas");
insert into Producto(Nombre, CodigoP, Fabricante_id)values("Urea", "2100806000", 1);
insert into Cliente(Nombre, Apellido, Direccion, NIT)values("Juan", "Perez", "Ciudad", "8987765");
select * from Volumenes;
insert into Volumenes(Volumen)values("50 Gr.");
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Volumenes_id, Unidades_Caja)values(1, 1, 0, 12.5, 1, 10);
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values(141315004, 01-01-2016, 15, 10.5, 1);
select * from Lote;
update Lote set Fecha_Vencimiento = 160116 where id=1;
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura)values(now(), 40.4, 1,1,"FACE66XL11","2882");
Select * from Compra;
update Compra set Limite_Credito=now() where id =1;
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(40, 2,20,1,1);
select * from Cliente;
insert into Volumenes(Volumen)value("500 pruebas");
insert into Fabricante(Nombre, Direccion)values("Standar Diagnostic, inc", "156-68 hagal-dong");
insert into Producto(Nombre, CodigoP, Fabricante_id)values("Hemoglobina Glucosilada", "1042184",5);
insert into Presentacion(Presentacion)values("Paquete");
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Volumenes_id, Unidades_Caja)values(4, 6, 60, 35,4,20);
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values(141315005, 160101, 20, 11.5, 2);
insert into Proveedor(Nombre, Alias, NIT, Correo)values("Lic. Iliana Patricia Lopez Gutierrez", "Microdiagnostic", "518360k", "");
insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 60.4, 2,1,"A","36403", 1);
Update Compra set Pagado = 1 where id=2;
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(40, 2,20,1,2);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(60.4, 3,14,2,2);
insert into Orden(Fecha, Total, Numero, Serie, Cliente_id, Empleado_id)values(now(), 250, 1906150001, "", 1,1);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(20,2,10,1,1);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(40,4,5,1,2);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(250,10,25,1,2);
Select DO.id, P.Nombre, P.CodigoP, PRO.Alias, PR.Presentacion, V.Volumen, L.Numero, L.Fecha_Vencimiento, O.Fecha, O.Total, O.Numero, DO.Subtotal, DO.Cantidad, DO.Precio_venta, C.Nombre, C.Apellido, C.Direccion, C. Nit from Orden O inner join Detalle_Orden DO on O.id= DO.Orden_id inner join Cliente C on O.Cliente_id=C.id inner join Producto_Presentacion PP on DO.Producto_Presentacion_id = PP.id inner join Volumenes V on PP.Volumenes_id = PP.id inner join Producto P on PP.Producto_id= P.id inner join Presentacion PR on PP.Presentacion_id = PR.id inner join Lote L on PP.id=L.Producto_Presentacion_id inner join Fabricante F on P.Fabricante_id = F.id inner join Detalle_Compra DC on L.id= DC.Lote_id inner join Compra Cl on DC.Compra_id =Cl.id  inner join Proveedor PRO ON Cl.Proveedor_id=PRO.id group by DO.id;
Select DO.id, P.CodigoP, P.Nombre, PP.Precio_Venta, PRO.Alias, PR.Presentacion, V.Volumen, L.Numero, L.Fecha_Vencimiento, O.Fecha, O.Total, O.Numero, DO.Subtotal, DO.Cantidad, DO.Precio_venta, C.Nombre, C.Apellido, C.Direccion, C. Nit from Orden O inner join Detalle_Orden DO on O.id= DO.Orden_id inner join Cliente C on O.Cliente_id=C.id inner join Producto_Presentacion PP on DO.Producto_Presentacion_id = PP.id inner join Volumenes V on PP.Volumenes_id = PP.id inner join Producto P on PP.Producto_id= P.id inner join Presentacion PR on PP.Presentacion_id = PR.id inner join Lote L on PP.id=L.Producto_Presentacion_id inner join Fabricante F on P.Fabricante_id = F.id inner join Detalle_Compra DC on L.id= DC.Lote_id inner join Compra Cl on DC.Compra_id =Cl.id  inner join Proveedor PRO ON Cl.Proveedor_id=PRO.id group by DO.id;
Select O.Numero as 'Numero de Orden', concat(C.Nombre," ",C.Apellido) as 'Cliente',O.Fecha, O.Total from Orden O inner join Detalle_Orden DO on O.id= DO.Orden_id inner join Cliente C on O.Cliente_id=C.id inner join Producto_Presentacion PP on DO.Producto_Presentacion_id = PP.id inner join Producto P on PP.Producto_id= P.id inner join Presentacion PR on PP.Presentacion_id = PR.id inner join Lote L on PP.id=L.Producto_Presentacion_id inner join Fabricante F on P.Fabricante_id = F.id inner join Detalle_Compra DC on L.id= DC.Lote_id inner join Compra Cl on DC.Compra_id =Cl.id  inner join Proveedor PRO ON Cl.Proveedor_id=PRO.id group by O.id;
Select DO.id, O.id, P.Nombre, P.CodigoP, PRO.Alias, PR.Presentacion, V.Volumen, L.Numero, L.Fecha_Vencimiento, DO.Subtotal, DO.Cantidad, DO.Precio_venta from Orden O inner join Detalle_Orden DO on O.id= DO.Orden_id inner join Cliente C on O.Cliente_id=C.id inner join Producto_Presentacion PP on DO.Producto_Presentacion_id = PP.id inner join Volumenes V on PP.Volumenes_id = PP.id inner join Producto P on PP.Producto_id= P.id inner join Presentacion PR on PP.Presentacion_id = PR.id inner join Lote L on PP.id=L.Producto_Presentacion_id inner join Fabricante F on P.Fabricante_id = F.id inner join Detalle_Compra DC on L.id= DC.Lote_id inner join Compra Cl on DC.Compra_id =Cl.id  inner join Proveedor PRO ON Cl.Proveedor_id=PRO.id group by DO.id;
insert into Orden(Fecha, Total, Numero, Serie, Cliente_id, Empleado_id)values(now(), 400, 1906150004, "", 5,1);
select * from Lote;
select * from Orden;
select * from Volumenes;
select * from Producto_Presentacion;
select * from Producto;
select * from Proveedor;
select * from Compra;
insert into Lote(Numero, Fecha_Vencimiento, Existencias_Lote, Costo, Producto_Presentacion_id)values(141315007, 160405, 60, 456.5, 4);
insert into Producto_Presentacion(Producto_id, Presentacion_id, Existencia_Total, Precio_Venta, Volumenes_id, Unidades_Caja)values(4, 4, 500, 90,2,650);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(10, 2,20,2,3);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(200, 3,30,3,3);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(110, 4,40,4,3);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(25.4, 5,50,1,3);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(41, 2,10,1,4);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(42, 2,15,2,4);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(43, 2,45,3,4);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(44, 2,12,4,5);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(45, 2,3,2,5);
insert into Detalle_Compra(Subtotal, Cantidad, Precio, Lote_id, Compra_id)values(46, 2,4,4,5);

insert into Compra(Fecha, Total, Proveedor_id, Empleado_id, Serie, Nfactura, Pagado)values(now(), 13443.4, 1,1,"A","36403", 1);
select * from Detalle_orden;

insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(30,2,10,2,1);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(60,4,5,2,2);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(250,105,245,2,3);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(300,3,156,3,4);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(32,6,123,3,1);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(20,19,78,3,2);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(13,12,83,4,3);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(29,45,91,4,4);
insert into Detalle_Orden(Subtotal, Cantidad, Precio_Venta, Orden_id, Producto_Presentacion_id)values(187,90,64,4,1);
/*Seleccionar detalle de Orden*/
Select O.id, P.CodigoP, concat(P.Nombre, ", ", Pr.Presentacion, " ", V.Volumen) as 'Descripcion', PP.Precio_Venta, DEO.Cantidad, DEO.Subtotal, O.Total from Orden O inner join Detalle_Orden DEO on O.id=DEO.Orden_id inner join Producto_Presentacion PP on DEO.Producto_Presentacion_id= PP.id inner join Producto P on PP.Producto_id = P.id inner join Presentacion Pr on PP.Presentacion_id =Pr.id inner join Volumenes V on PP.Volumenes_id =V.id order by O.id asc;

select Prove.Alias 'Casa medica', P.Nombre, PP.Unidades_Caja as 'Unidades por caja', PP.Existencia_Total as 'Total en unidades', Precio_Venta as 'Precio Calle' from Compra C inner join Detalle_Compra DC on C.id=DC.Compra_id inner join Lote L on DC.Lote_id=L.id inner join Producto_Presentacion PP on PP.id = L.Producto_Presentacion_id inner join Producto P on PP.Producto_id = P.id inner join Presentacion Pre on PP.Presentacion_id = Pre.id inner join Volumenes	 V on PP.Volumenes_id = V.id inner join Proveedor PROVE on C.Proveedor_id = PROVE.id group by P.id;






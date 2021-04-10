drop database if exists bd_huron_azul;
create database bd_huron_azul;
use bd_huron_azul;
create table usuario (
codusuario bigint primary key auto_increment,
nomusuario varchar(100) not null,
apeusuario varchar(100) not null,
direccion varchar(200),
dni char(8) not null,
sexo int not null,
fecnac date not null,
email varchar(100),
telefono varchar(20),
idlogin varchar(100) not null,
password char(10) not null,
tipousuario int default 2 not null,
estado bit default 1 not null
);
insert into usuario(nomusuario,apeusuario,direccion,dni,sexo,fecnac,email,telefono,idlogin,password,tipousuario) values
('Humberto','Reinoso','UV mirones block 5B Lima Cercado','73580887',1,'19930601','hdrf1993@outlook.com','944809183','hreinoso','1234567890',1),
('Juan','Pacheco','Pasaje Udima 160-B','45984522',1,'19930612','aero356@gmail.com','944809183','aeroman','0123456789',2),
('Diana','Laos','Av Central 210 San Martín de Porres','78894561',2,'19930128','dlaos@gmail.com','945276774','dlaos','dlaosdlaos',2);
select 
*
from
usuario;
create table producto (
codprod bigint primary key auto_increment,
descprod varchar(100) not null,
preprod numeric(19 , 6 ) not null,
stkprod int default 0 not null,
fotoprod varchar(100),
catprod bigint not null
);
insert into producto(descprod,preprod,stkprod,fotoprod,catprod) values
('Miscozoo',17.00,100,'prod1.jpeg',1),
('Miscobones',17.00,100,'prod2.jpeg',1),
('Miscodental' , 17.00,100,'prod3.jpeg',1),
('Miscoduo', 17.00,100,'prod4.jpeg',1),
('Miscosoft Salmon' , 17.00,100,'prod5.jpeg',1),
('Miscostick Chicken',17.00,0,'prod6.jpeg',1),
('Miscotoffy Salmon' ,17.00,0,'prod7.jpeg',1);
select 
*
from
producto;
create table categoriaprod (
codcat bigint primary key auto_increment,
desccat varchar(100) not null
);
insert into categoriaprod(desccat) values ('Alimentos'),('Juguetes'),('Medicamentos'),('Utensilios')
;
select 
*
from
categoriaprod;
create table pedido (
codpedido bigint primary key auto_increment,
cliente bigint not null,
fecpedido datetime not null,
sede bigint not null,
metodoenvio int not null,
metodopago int not null,
monto numeric(19 , 6 ) not null
);
insert into pedido(cliente,fecpedido,sede,metodoenvio,metodopago,monto) values 
(2,'2019-11-04 15:25',1,1,1,85),
(2,'2019-11-05 10:26',2,1,1,34),
(3,'2019-11-26 17:20',1,2,1,17),
(3,'2019-11-28 14:02',2,1,1,17);
select 
*
from
pedido;
create table pedidodetalle (
codpedido bigint not null,
producto bigint not null,
cantidad int not null,
monto numeric(19 , 6 ) not null,
primary key (codpedido , producto)
);
insert into pedidodetalle values 
(1,1,2,34),
(1,3,3,51),
(2,1,1,17),
(2,3,1,17),
(3,2,1,17),
(4,2,1,17);
select 
*
from
pedidodetalle;
create table sede (
codsede bigint primary key auto_increment,
refsede varchar(100) not null,
dirsede varchar(200)
);
insert into sede(refsede,dirsede) values
('San Miguel - F. Gallese','Av. Federico Gallese 301'),
('San Miguel - Insurgentes','Av Insurgentes 842'),
('Pueblo Libre','Av Sucre 340'),
('Callao','Av. Rep de Panamá 121'),
('San Isidro','Av. Augusto P. Aranibar 1991'),
('Bellavista','Av. Faucett 1809'),
('Cercado de Lima','Av. Oscar R. Benavides 2050');
select 
*
from
sede;
create table cita (
codcita bigint primary key auto_increment,
cliente bigint not null,
sede bigint not null,
fecha_hora datetime not null,
estado int default 1 not null,
lugaratencion int not null
);
insert into cita(cliente,sede,fecha_hora,lugaratencion) values
(2,2,'2019-11-05 15:00',1),
(2,1,'2019-11-11 16:00',2),
(3,1,'2019-11-20 10:00',1),
(3,1,'2019-11-21 11:00',2);
select 
*
from
cita;
alter table producto add constraint fk_prod_cat foreign key(catprod) references categoriaprod(codcat);
alter table pedido add constraint fk_pedido_cli foreign key(cliente) references usuario(codusuario);
alter table pedido add constraint fk_pedido_sede foreign key(sede) references sede(codsede);
alter table pedidodetalle add constraint fk_pedidodet_pedido foreign key(codpedido) references pedido(codpedido);
alter table pedidodetalle add constraint fk_pedidodet_prod foreign key(producto) references producto(codprod);
alter table cita add constraint fk_cita_cliente foreign key (cliente) references usuario(codusuario);
alter table cita add constraint fk_cita_sede foreign key(sede) references sede(codsede);
#####################procedimientos almacenados#####################
drop procedure if exists sp_validar_logueo
delimiter $$
create procedure sp_validar_logueo(
p_id varchar(100),
p_pass varchar(100)
)
begin
select * from usuario where (idlogin=p_id or email=p_id) and password=p_pass;
end $$
delimiter ;
call sp_validar_logueo('hreinoso','1234567890');
call sp_validar_logueo('hdrf1993@outlook.com','1234567890');
call sp_validar_logueo('hreinoso','456489');
call sp_validar_logueo('hdrf1993@outlook.com','fdsaiji');
call sp_validar_logueo('jfkdsjaf','1234567890');
drop procedure if exists sp_registrar_usuario;
delimiter $$
create procedure sp_registrar_usuario(
p_nomusuario 	varchar(100),
p_apeusuario 	varchar(100),
p_direccion 	varchar(200),
p_dni 			char(8),
p_sexo 			int,
p_fecnac 		date,
p_email 		varchar(100),
p_telefono 		varchar(20),
p_idlogin 		varchar(100),
p_password 		char(10))
begin
insert into usuario
	   (nomusuario
	   ,apeusuario
	   ,direccion
	   ,dni
	   ,sexo
	   ,fecnac
	   ,email
	   ,telefono
	   ,idlogin
	   ,password)
 values
	   (p_nomusuario
	   ,p_apeusuario
	   ,p_direccion 
	   ,p_dni 		
	   ,p_sexo 		
	   ,p_fecnac 	
	   ,p_email 	
	   ,p_telefono 	
	   ,p_idlogin 	
	   ,p_password);
end $$
delimiter ; 
call sp_registrar_usuario('Rally','Flores','Av Colonial 2050','78948849',1,'19930601','hreinosoflores@gmail.com','3672297','rflores','1234567890');
drop procedure if exists sp_editar_usuario;
delimiter $$
create procedure sp_editar_usuario(
p_codusuario 	bigint,     					
p_direccion 	varchar(200),					
p_email 		varchar(100),
p_telefono 		varchar(20),
p_idlogin 		varchar(100),
p_password 		char(10))
begin
update usuario set 
direccion = 		p_direccion 
,email = 			p_email 	
,telefono = 		p_telefono 	
,idlogin = 			p_idlogin 	
,password = 		p_password 	
where codusuario = p_codusuario;
end $$
delimiter ; 
call sp_editar_usuario(4,'Av Colonial 322','rflores@outlook.com','3672297','rflores','1234567890');
drop procedure if exists sp_registrar_cita;
delimiter $$
create procedure sp_registrar_cita(
p_cliente 		bigint,
p_sede 			bigint,
p_fecha_hora 		datetime,
p_lugaratencion 	int)
begin
insert into cita
	   (cliente
	   ,sede
	   ,fecha_hora
	   ,lugaratencion)
 values(
	   p_cliente 		
	   ,p_sede 			
	   ,p_fecha_hora 	
	   ,p_lugaratencion);
end $$
delimiter ;
call sp_registrar_cita (2,1,'2019-11-05 16:00',1);
drop view if exists vw_cita_tuneado;
create view vw_cita_tuneado
as
select c.codcita as 'nro_cita',u.codusuario,concat(u.nomusuario,' ',u.apeusuario) as 'nom_cliente',u.dni as 'dni',u.direccion as 'domicilio',u.email as 'correo',u.telefono as 'telefono',s.refsede as 'sede',date_format(fecha_hora,'%d/%m/%Y') as 'fecha',substring(date_format(fecha_hora,'%T'),1,5) as 'hora',case when c.estado=1 then 'Solicitado' when c.estado=2 then 'Atendido' when c.estado=3 then 'Cancelado' end as 'estado_actual',case when c.lugaratencion=1 then 'En Sede' when c.lugaratencion=2 then 'A Domicilio' end as 'lugar_atencion' from cita c join usuario u on c.cliente=u.codusuario join sede s on c.sede=s.codsede;
select 
*
from
vw_cita_tuneado;
drop procedure if exists sp_registrar_pedido_cabecera;
delimiter $$
create procedure sp_registrar_pedido_cabecera(
p_cliente 		bigint,
p_fecpedido 	datetime,
p_sede 			bigint,
p_metodoenvio 	int,
p_metodopago 	int,
p_monto 		numeric(19,6))
begin
insert into pedido
	   (cliente
	   ,fecpedido
	   ,sede
	   ,metodoenvio
	   ,metodopago
	   ,monto)
 values
	   (p_cliente 		
	   ,p_fecpedido 	
	   ,p_sede 			
	   ,p_metodoenvio 	
	   ,p_metodopago 	
	   ,p_monto 	);	
end $$
delimiter ;
call sp_registrar_pedido_cabecera (3,'2019-11-05 15:50',1,1,1,34.00);
drop procedure if exists sp_registrar_pedido_detalle;
delimiter $$
create procedure sp_registrar_pedido_detalle(
p_codpedido 	bigint,
p_producto 		bigint,
p_cantidad 		int,
p_monto 		numeric(19,6))
begin
insert into pedidodetalle
	   (codpedido
	   ,producto
	   ,cantidad
	   ,monto)
 values
	   (p_codpedido 
	   ,p_producto 	
	   ,p_cantidad 	
	   ,p_monto 	);
end $$
delimiter ;
call sp_registrar_pedido_detalle (5,1,1,17.00);
call sp_registrar_pedido_detalle (5,2,1,17.00);
drop procedure if exists sp_autogenera_pedido;
delimiter $$
create procedure sp_autogenera_pedido()
begin
select  codpedido from pedido order by codpedido desc limit 1;
end $$
delimiter ;
call sp_autogenera_pedido;
drop procedure if exists sp_listar_producto;
delimiter $$
create procedure sp_listar_producto(
tipo_usuario int,
p_catprod bigint,
p_descprod varchar(100))
begin
if tipo_usuario=1 and p_catprod=0 and p_descprod like '' then select * from producto;
elseif tipo_usuario=1 and p_catprod=0 then select * from producto where descprod like concat(p_descprod, '%');
elseif  tipo_usuario=1 and p_descprod like '' then select * from producto where catprod=p_catprod;
elseif tipo_usuario=1 then select * from producto where descprod like concat(p_descprod, '%') and catprod=p_catprod;
elseif p_catprod=0 and p_descprod like '' then select * from producto where stkprod>0;
elseif p_catprod=0 then select * from producto where stkprod>0 and descprod like concat(p_descprod, '%');
elseif p_descprod like '' then select * from producto where stkprod>0 and catprod=p_catprod;
else select * from producto where stkprod>0 and descprod like concat(p_descprod, '%') and catprod=p_catprod;
end if;
end $$
delimiter ;
call sp_listar_producto(1,0,'');
call sp_listar_producto(1,0,'pel');
call sp_listar_producto(1,1,'');
call sp_listar_producto(1,1,'m');
call sp_listar_producto(2,0,'');
call sp_listar_producto(2,0,'m');
call sp_listar_producto(2,2,'');
call sp_listar_producto(2,2,'p');
drop procedure if exists sp_registrar_producto;
delimiter $$
create procedure sp_registrar_producto(
p_descprod  	varchar(100),
p_preprod 		numeric(19,6),
p_stkprod 		int,
p_fotoprod 		varchar(100),
p_catprod 		bigint)
begin
insert into producto
	   (descprod
	   ,preprod
	   ,stkprod
	   ,fotoprod
	   ,catprod)
 values(
	   p_descprod  
	   ,p_preprod 	
	   ,p_stkprod 	
	   ,p_fotoprod 	
	   ,p_catprod );	
end $$
delimiter ;
call sp_registrar_producto('Peluche de Pescado',25.00,0,'-',2);
drop procedure if exists sp_editar_producto;
delimiter $$
create procedure sp_editar_producto(
p_codprod 		bigint,
p_descprod 		varchar(100),
p_preprod 		numeric(19,6),
p_stkprod 		int,
p_fotoprod 		varchar(100),
p_catprod 		bigint)
begin
update producto
set descprod = p_descprod 	
  ,preprod =  p_preprod 	
  ,stkprod =  p_stkprod 	
  ,fotoprod = p_fotoprod 	
  ,catprod =  p_catprod 	 
where codprod=p_codprod;
end $$
delimiter ;
call sp_editar_producto(8,'Peluche de Pescado',25.00,100,'prod8.jpg',2);
drop procedure if exists sp_autogenera_producto;
delimiter $$
create procedure sp_autogenera_producto()
begin
select  codprod+1 from producto order by codprod desc limit 1;
end $$
delimiter ;
call sp_autogenera_producto();
drop view if exists vw_pedido_tuneado;
create view vw_pedido_tuneado
as
select p.codpedido,u.codusuario,concat(u.nomusuario,' ',u.apeusuario) as 'cliente',u.dni,u.direccion as 'domicilio',u.email as 'correo',u.telefono,date_format(fecpedido,'%d/%m/%Y') as 'fecha',date_format(fecpedido,'%T') as 'hora',s.refsede,case when p.metodoenvio=1 then 'A Domicilio' when p.metodoenvio=2 then 'Recojo en Tienda' end as 'metodoenvio',case when p.metodopago=1 then 'En Efectivo' when p.metodopago=2 then 'Tarjeta de Crédito' when p.metodopago=3 then 'Depósito Bancario' end as 'metodopago',p.monto from pedido as p join usuario as u on p.cliente=u.codusuario join sede as s on p.sede=s.codsede;
select 
*
from
vw_pedido_tuneado
;
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Daniel
 * Created: 25 dic. 2022
 */
INSERT INTO CLIENTE (nomCliente,correo,usuario,password) VALUES ('');
INSERT INTO cliente (nomCliente,correo,password) values ('Daniel',"daniel@gmail.com",123);
SELECT * FROM CLIENTE;
SELECT * FROM CLIENTE WHERE CORREO = 'daniel@gmail.com' AND PASSWORD = '123';
SELECT * FROM CLIENTE WHERE CORREO = 'daniel@gmail.com';
select * from libro;
select * from autor;
select l.idlibro,l.titulo,l.stock,l.anio,e.nomEditorial,a.nomCompleto 
from libro l, editorial e, autor a where e.ideditorial = l.ideditorial and a.idautor = l.idautor order by idlibro;

CREATE procedure insert_prestamo(
	IN p_idcliente int,
    IN p_idlibro int,
    IN p_fechaprestamo date,
    IN p_fechaentrega date,
    IN p_estado varchar(6))
insert into prestamo(idcliente,idlibro,fechaPrestamo,fechaEntrega,estado) values (p_idcliente,p_idlibro,p_fechaprestamo,p_fechaentrega,p_estado);
select * from prestamo;
select max(stock) from libro;

create procedure reducir_stock(
	IN l_cod int)
UPDATE LIBRO SET stock = stock-1 where idlibro = l_cod;

create procedure aumentar_stock(
	IN l_cod int)
UPDATE LIBRO SET stock = stock+1 where idlibro = l_cod; 

create procedure actualizar_estado(
	IN l_cod int)
UPDATE LIBRO SET stock = stock+1 where idlibro = l_cod; 

create procedure actualizar_general(IN idprestamo_p int)
UPDATE libro l , prestamo p set l.stock = l.stock +1 , p.estado = 'R' where l.idlibro = p.idlibro and p.idprestamo = idprestamo_p; 
 
/*TITULO - FECHA PRETAMO- FECHA ENTREGA - ESTADO*/
select l.titulo,p.fechaPrestamo, p.fechaEntrega,estado from libro l , prestamo p , cliente c 
where l.idlibro = p.idlibro and p.idcliente= c.idcliente and c.idcliente = 2;

select * from cliente;



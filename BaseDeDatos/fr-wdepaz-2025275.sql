drop database if exists DBTienda_in5cm;
create database DBTienda_in5cm;
use DBTienda_in5cm;

create table Clientes (
    dpi_cliente int auto_increment not null,
    nombre_cliente varchar(50) not null,
    apellido_cliente varchar(50) not null,
    direccion varchar(100) not null,
    estado int not null,
    primary key pk_dpi_cliente(dpi_cliente)
);

create table Usuarios (
    codigo_usuario int auto_increment not null,
    username varchar(45) not null unique,
    password varchar(45) not null,
    email varchar(60) not null,
    rol varchar(45) not null,
    estado int not null,
    primary key pk_codigo_usuario(codigo_usuario)
);

create table Productos (
    codigo_producto int auto_increment not null,
    nombre_producto varchar(60) not null,
    precio decimal(10,2) not null,
    stock int not null,
    estado int not null,
    primary key pk_codigo_producto(codigo_producto)
);

create table Ventas (
    codigo_venta int auto_increment not null,
    fecha_venta date not null,
    total decimal(10,2) not null,
    estado int,
    clientes_dpi_cliente int not null,
    usuarios_codigo_usuario int not null,
    primary key pk_codigo_venta(codigo_venta),
    constraint fk_ventas_clientes foreign key (clientes_dpi_cliente)
        references Clientes(dpi_cliente) on delete cascade,
    constraint fk_ventas_usuarios foreign key (usuarios_codigo_usuario)
        references Usuarios(codigo_usuario) on delete cascade
);

create table DetalleVenta (
    codigo_detalle_venta int auto_increment not null,
    cantidad int not null,
    precio_unitario decimal(10,2) not null,
    subtotal decimal(10,2) not null,
    productos_codigo_producto int not null,
    ventas_codigo_venta int not null,
    primary key pk_codigo_detalle_venta(codigo_detalle_venta),
    constraint fk_detalle_producto foreign key (productos_codigo_producto)
        references Productos(codigo_producto) on delete cascade,
    constraint fk_detalle_venta foreign key (ventas_codigo_venta)
        references Ventas(codigo_venta) on delete cascade
);

delimiter $$

create procedure sp_usuarios_create(
    u_usuario varchar(45), 
    u_password varchar(45), 
    u_email varchar(60), 
    u_rol varchar(45), 
    u_estado int
)
begin
    insert into Usuarios(username, password, email, rol, estado)
    values (u_usuario, u_password, u_email, u_rol, u_estado);
end $$

create procedure sp_clientes_create(
    c_nombre varchar(50), 
    c_apellido varchar(50), 
    c_direccion varchar(100), 
    c_estado int
)
begin
    insert into Clientes(nombre_cliente, apellido_cliente, direccion, estado)
    values (c_nombre, c_apellido, c_direccion, c_estado);
end $$

create procedure sp_productos_create(
    p_nombre_producto varchar(60), 
    p_precio_unitario decimal(10,2), 
    p_stock int, 
    p_estado int
)
begin
    insert into Productos(nombre_producto, precio, stock, estado)
    values (p_nombre_producto, p_precio_unitario, p_stock, p_estado);
end $$

create procedure sp_ventas_create(
    v_fecha_venta date, 
    v_total_venta decimal(10,2), 
    v_estado int, 
    v_clientes_dpi_cliente int, 
    v_usuarios_codigo_usuario int
)
begin
    insert into Ventas(fecha_venta, total, estado, clientes_dpi_cliente, usuarios_codigo_usuario)
    values (v_fecha_venta, v_total_venta, v_estado, v_clientes_dpi_cliente, v_usuarios_codigo_usuario);
end $$

create procedure sp_detalleventa_create(
    d_cantidad int, 
    d_precio_unitario decimal(10,2), 
    d_subtotal decimal(10,2), 
    d_productos_codigo_producto int, 
    d_ventas_codigo_venta int
)
begin
    insert into DetalleVenta(cantidad, precio_unitario, subtotal, productos_codigo_producto, ventas_codigo_venta)
    values (d_cantidad, d_precio_unitario, d_subtotal, d_productos_codigo_producto, d_ventas_codigo_venta);
end $$

delimiter ;

call sp_clientes_create('mario', 'gomez', 'guatemala', 1);
call sp_clientes_create('lucia', 'fernandez', 'antigua', 1);
call sp_clientes_create('roberto', 'solis', 'mixco', 1);
call sp_clientes_create('elena', 'mendez', 'villa nueva', 1);
call sp_clientes_create('marcos', 'estrada', 'xela', 1);
call sp_clientes_create('sandra', 'perez', 'amatitlan', 1);
call sp_clientes_create('jorge', 'blanco', 'chinautla', 1);
call sp_clientes_create('paola', 'rivas', 'petapa', 1);
call sp_clientes_create('luis', 'garcia', 'escuintla', 1);
call sp_clientes_create('ana', 'martinez', 'jalapa', 1);

call sp_usuarios_create('wilfred', '1234', 'admin@tienda.com', 'administrador', 1);
call sp_usuarios_create('cliente1', 'pass1', 'c1@tienda.com', 'cliente', 1);
call sp_usuarios_create('cliente2', 'pass2', 'c2@tienda.com', 'cliente', 1);
call sp_usuarios_create('cliente3', 'pass3', 'c3@tienda.com', 'cliente', 1);
call sp_usuarios_create('cliente4', 'pass4', 'c4@tienda.com', 'cliente', 1);
call sp_usuarios_create('cliente5', 'pass5', 'c5@tienda.com', 'cliente', 1);
call sp_usuarios_create('cliente6', 'pass6', 'c6@tienda.com', 'cliente', 1);
call sp_usuarios_create('cliente7', 'pass7', 'c7@tienda.com', 'cliente', 1);
call sp_usuarios_create('cliente8', 'pass8', 'c8@tienda.com', 'cliente', 1);
call sp_usuarios_create('cliente9', 'pass9', 'c9@tienda.com', 'cliente', 1);

call sp_productos_create('arroz 1lb', 5.50, 100, 1);
call sp_productos_create('aceite 1l', 15.00, 50, 1);
call sp_productos_create('frijol 1lb', 8.00, 150, 1);
call sp_productos_create('azucar 1lb', 4.50, 200, 1);
call sp_productos_create('leche litro', 12.00, 60, 1);
call sp_productos_create('pan molde', 18.00, 30, 1);
call sp_productos_create('huevos 30u', 35.00, 40, 1);
call sp_productos_create('pasta dental', 22.00, 80, 1);
call sp_productos_create('jabon barra', 7.50, 120, 1);
call sp_productos_create('cafe 400g', 25.00, 45, 1);

call sp_ventas_create('2026-04-15', 50.00, 1, 1, 1);
call sp_ventas_create('2026-04-15', 30.00, 1, 2, 2);
call sp_ventas_create('2026-04-15', 100.00, 1, 3, 3);
call sp_ventas_create('2026-04-15', 15.00, 1, 4, 4);
call sp_ventas_create('2026-04-15', 45.00, 1, 5, 5);
call sp_ventas_create('2026-04-15', 80.00, 1, 6, 6);
call sp_ventas_create('2026-04-15', 20.00, 1, 7, 7);
call sp_ventas_create('2026-04-15', 12.00, 1, 8, 8);
call sp_ventas_create('2026-04-15', 200.00, 1, 9, 9);
call sp_ventas_create('2026-04-15', 90.00, 1, 10, 1);

call sp_detalleventa_create(2, 25.00, 50.00, 1, 1);
call sp_detalleventa_create(2, 15.00, 30.00, 2, 2);
call sp_detalleventa_create(1, 100.00, 100.00, 3, 3);
call sp_detalleventa_create(1, 15.00, 15.00, 4, 4);
call sp_detalleventa_create(3, 15.00, 45.00, 5, 5);
call sp_detalleventa_create(4, 20.00, 80.00, 6, 6);
call sp_detalleventa_create(1, 20.00, 20.00, 7, 7);
call sp_detalleventa_create(1, 12.00, 12.00, 8, 8);
call sp_detalleventa_create(2, 100.00, 200.00, 9, 9);
call sp_detalleventa_create(1, 90.00, 90.00, 10, 10);
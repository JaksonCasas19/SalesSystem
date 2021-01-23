Create table Cliente (
    IDCliente   number(3) not null,
    nombre      varchar(50) not null,
    ruc         number(15) not null,
    contacto    varchar(50),
    direccion   varchar(50),
    telefono    number(15),
    email       varchar(50)
);

alter table Cliente add constraint ruc_uq unique(ruc);
Alter table Cliente add constraint Cliente_pk Primary key(IDCliente);

Create table Producto(
    IDProducto  number(3)   not null,
    descripcion varchar(50) not null,
    precio      number(8,2) not null
)

alter table producto add constraint ck_precio1 check(precio>0 and precio<9999);
Alter table Producto add constraint Producto_pk Primary key(IDProducto);

Create table Pedido(
    IDPedido  number(5)   not null,
    fechaPedido date,
    subTotal    number(15,2) not null,
    Total       number(15,2) not null,
    igv         number(15,2),
    IDCliente   number(3) not null
);

Alter table Pedido add constraint Pedido_pk primary key(IDPedido);
Alter table Pedido add constraint Pedido_Cliente_fk foreign key(IDCliente)
references Cliente(IDCliente);

Create table mesa(
    IDMesa number(2)    not null,
    Numeromesa  number(2)   not null
);

Alter table mesa add constraint mesa_pk Primary key(IDMesa);
alter table mesa add constraint uk_numeromesa unique(numeromesa);

Create table DetallePedido(
    IDDetalle   number(5)   not null,   
    IDPedido    number(5)   not null,
    IDProducto  number(3)   not null,  
    cantidad    number(3)   not null,
    totalDetalle    number(15,2)    not null,
    IDMesa      number(2)   not null 
);

Alter table DetallePedido add constraint DatallePedido_pk Primary key(IDDetalle);
Alter table DetallePedido add constraint DetallePedido_Pedido_fk Foreign Key(IDPedido)
references Pedido(IDPedido);

Alter table DetallePedido add constraint DetallePedido_Producto_fk Foreign Key(IDProducto)
references Producto(IDProducto);

Alter table DetallePedido add constraint DetallePedido_mesa_fk Foreign Key(IDMesa)
references mesa(IDMesa);

alter table detallepedido add constraint ck_cantidad check(cantidad>0);







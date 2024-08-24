--TABLA DE USUARIOS--
CREATE TABLE tbUsuarios(
id_usuario INT PRIMARY KEY,
nombre VARCHAR2(25) NOT NULL,
apellido VARCHAR2(25) NOT NULL,
fecha_nacimiento VARCHAR2(25) NOT NULL,
correo VARCHAR2(40) NOT NULL UNIQUE,
telefono VARCHAR2(20) NOT NULL UNIQUE,
contraseña VARCHAR2(70) NOT NULL CHECK (LENGTH(contraseña) >= 8),
id_tipo_usuario INT,--cambio
CONSTRAINT FKid_tipo_usuario FOREIGN KEY(id_tipo_usuario) REFERENCES tbTiposUsuarios(id_tipo_usuario) ON DELETE CASCADE
);
drop table tbUsuarios cascade constraints purge


ALTER TABLE tbUsuarios
ADD imgFoto VARCHAR2(500);

drop table tbUsuarios cascade constraints purge
drop sequence  identity_Usuarios


CREATE SEQUENCE identity_Usuarios
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE OR REPLACE TRIGGER trg_update_tbUsuarios
AFTER UPDATE OF id_tipo_usuario ON tbTiposUsuarios
FOR EACH ROW
BEGIN
    UPDATE tbUsuarios
    SET id_tipo_usuario = :new.id_tipo_usuario
    WHERE id_tipo_usuario = :old.id_tipo_usuario;
END;

CREATE OR REPLACE TRIGGER trg_before_insert_tbUsuarios
BEFORE INSERT ON tbUsuarios
FOR EACH ROW
BEGIN
    SELECT identity_Usuarios.NEXTVAL INTO :new.id_usuario FROM dual;
END;

INSERT ALL
                                                                                                                                                                                    --perdo12345678--
INTO tbusuarios(nombre, apellido, fecha_nacimiento, correo, telefono, contraseña, id_tipo_usuario, imgFoto) values ('Pedro', 'Guzman', '17/4/1980', 'perdo_guzman@gmail.com', '8764-2321', '8bb7a6fa06b2468f9ca987c9c6ab039746460c876a8214f47f734561f1a5a382', 1, 'nueva_url_de_imagen1')
                                                                                                                                                                                    --paco12345678--
INTO tbusuarios(nombre, apellido, fecha_nacimiento, correo, telefono, contraseña, id_tipo_usuario, imgFoto) values ('Paco', 'Lopez', '28/3/1998', 'paco_lopez@gmail.com', '2364-2901', '998794d2dbedaaf80d0cf80bbfe23a7b7767362f83c7b3207fedb1290dbb44c3 ', 1, 'nueva_url_de_imagen2')
                                                                                                                                                                                    --ismael12345678--
INTO tbusuarios(nombre, apellido, fecha_nacimiento, correo, telefono, contraseña, id_tipo_usuario, imgFoto) values ('Ismael', 'Perez', '09/4/1993', 'ismael_perez@gmail.com', '1324-3201', '8D21CE1F9DD8FB1BB42D24AD4C55688E9DD05D34FA24241C81E31F413214E6B8', 1, 'nueva_url_de_imagen3')
                                                                                                                                                                                    --perdo12345678--
INTO tbusuarios(nombre, apellido, fecha_nacimiento, correo, telefono, contraseña, id_tipo_usuario, imgFoto) values ('Juan', 'Torres', '12/9/1999', 'juan_torres@gmail.com', '2345-2501', '8BB7A6FA06B2468F9CA987C9C6AB039746460C876A8214F47F734561F1A5A382', 1, 'nueva_url_de_imagen4')
                                                                                                                                                                                    --gabi1234567890--
INTO tbusuarios(nombre, apellido, fecha_nacimiento, correo, telefono, contraseña, id_tipo_usuario, imgFoto) values ('Paco', 'Lopez', '28/3/1998', 'gabi@gmail.com', '1554-1234', 'e3d55e763f59cd9b1e3b3b786ae29974eee23b70d4e5aa390f04133371f6a91b', 3, 'nueva_url_de_imagen5')
SELECT * FROM dual;

SELECT * FROM tbUsuarios;

UPDATE tbUsuarios
SET imgFoto = 'nueva_url_de_imagen1'
WHERE id_usuario = 1;

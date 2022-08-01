/* Populate tables */
INSERT INTO urbanizaciones (nombre,distrito,provincia) VALUES ('san juan','Trujillo','Trujillo');
INSERT INTO urbanizaciones (nombre,distrito,provincia) VALUES ('monserrat','Trujillo','Trujillo');
INSERT INTO urbanizaciones (nombre,distrito,provincia) VALUES ('los girasoles','El Porvenir','Trujillo');
INSERT INTO urbanizaciones (nombre,distrito,provincia) VALUES ('arevalo','La Ezperanza','Trujillo');
INSERT INTO urbanizaciones (nombre,distrito,provincia) VALUES ('los pinos','La Ezperanza','Trujillo');

INSERT INTO generos (genero) VALUES ('Acción');
INSERT INTO generos (genero) VALUES ('Comedia');
INSERT INTO generos (genero) VALUES ('Drama');
INSERT INTO generos (genero) VALUES ('Aventuras');
INSERT INTO generos (genero) VALUES ('Ciencia Ficción');
INSERT INTO generos (genero) VALUES ('Fantasía');
INSERT INTO generos (genero) VALUES ('Romantico');
INSERT INTO generos (genero) VALUES ('Musical');
INSERT INTO generos (genero) VALUES ('Suspenso');
INSERT INTO generos (genero) VALUES ('Terror');

INSERT INTO idiomas (idioma, subtitulos) VALUES ('espa�ol','no');
INSERT INTO idiomas (idioma, subtitulos) VALUES ('ingles','espa�ol');
INSERT INTO idiomas (idioma, subtitulos) VALUES ('chino','espa�ol');
INSERT INTO idiomas (idioma, subtitulos) VALUES ('ruso','espa�ol');
INSERT INTO idiomas (idioma, subtitulos) VALUES ('koreano','ingles');
INSERT INTO idiomas (idioma, subtitulos) VALUES ('japones','espa�ol');
INSERT INTO idiomas (idioma, subtitulos) VALUES ('turko','no');

INSERT INTO formatos (formato) VALUES ('MP4');
INSERT INTO formatos (formato) VALUES ('AVI');
INSERT INTO formatos (formato) VALUES ('MOV');
INSERT INTO formatos (formato) VALUES ('MKV');
INSERT INTO formatos (formato) VALUES ('DIVX');
INSERT INTO formatos (formato) VALUES ('3GP');
INSERT INTO formatos (formato) VALUES ('WEBM');

INSERT INTO clientes (nombre, apellido, direccion, telefono, email, urbanizacion_id, foto) VALUES('Andres', 'Guzman','av san juan','987654321', 'profesor@bolsadeideas.com', 1, '');
INSERT INTO clientes (nombre, apellido, direccion, telefono,email,  urbanizacion_id, foto) VALUES('John', 'Doe','av san jose','983654321', 'john.doe@gmail.com', 5, '');
INSERT INTO clientes (nombre, apellido, direccion, telefono,email,  urbanizacion_id, foto) VALUES('Linus', 'Torvalds','av san miguel','923554321', 'linus.torvalds@gmail.com', 3, '');
INSERT INTO clientes (nombre, apellido, direccion, telefono,email,  urbanizacion_id, foto) VALUES('Jane', 'Doe','av laureles','914254321', 'jane.doe@gmail.com', 4, '');
INSERT INTO clientes (nombre, apellido, direccion, telefono,email,  urbanizacion_id, foto) VALUES('Rasmus', 'Lerdorf','av los rosales','909425432', 'rasmus.lerdorf@gmail.com', 4, '');
INSERT INTO clientes (nombre, apellido, direccion, telefono,email,  urbanizacion_id, foto) VALUES('Erich', 'Gamma','av san martin','907682345', 'erich.gamma@gmail.com', 2, '');


/* Creamos algunas fichas */
INSERT INTO fichas (fecha_alquiler, fecha_entrega, costo, mora, comentarios, devuelto, cliente_id) VALUES('2022-07-20','2022-08-01',25,'sin mora','sin comentarios', 'pendiente', 1);
INSERT INTO fichas (fecha_alquiler, fecha_entrega, costo, mora, comentarios, devuelto, cliente_id) VALUES('2022-07-25','2022-08-05',50,'sin mora','sin comentarios', 'pendiente', 2);
INSERT INTO fichas (fecha_alquiler, fecha_entrega, costo, mora, comentarios, devuelto, cliente_id) VALUES('2022-07-25','2022-08-05',50,'sin mora','sin comentarios', 'pendiente', 5);
INSERT INTO fichas (fecha_alquiler, fecha_entrega, costo, mora, comentarios, devuelto, cliente_id) VALUES('2022-07-25','2022-08-05',50,'sin mora','sin comentarios', 'pendiente', 4);
INSERT INTO fichas (fecha_alquiler, fecha_entrega, costo, mora, comentarios, devuelto, cliente_id) VALUES('2022-07-25','2022-08-05',50,'sin mora','sin comentarios', 'pendiente', 3);


INSERT INTO videos (titulo, anio, cantidad, precio ,imagen_portada, trailer,mes,formato_id) VALUES('Jurasic Park', 2022, 10,42.51,'','qehG9dKVDG4',6,1);
INSERT INTO videos (titulo, anio, cantidad, precio,imagen_portada, trailer,mes,formato_id) VALUES('Dr Strange-multiverso', 2022, 10,10.51,'','KREBGtEeW9U',2,2);
INSERT INTO videos (titulo, anio, cantidad, precio ,imagen_portada, trailer,mes,formato_id) VALUES('Spider Man ', 2022, 10,12.00,'','JfVOs4VSpmA',1,1);
INSERT INTO videos (titulo, anio, cantidad, precio,imagen_portada, trailer,mes,formato_id) VALUES('Thor 4', 2022, 10,5.20,'','meNfg26orQI',7,3);
INSERT INTO videos (titulo, anio, cantidad, precio,imagen_portada, trailer,mes,formato_id) VALUES('Morbius', 2022, 10,9.20,'','oZ6iiRrz1SY',5,4);

INSERT INTO generos_items (video_id,genero_id) VALUES(1,1);
INSERT INTO generos_items (video_id,genero_id) VALUES(1,2);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(1,1);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(1,2);
INSERT INTO generos_items (video_id,genero_id) VALUES(2,5);
INSERT INTO generos_items (video_id,genero_id) VALUES(2,2);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(2,3);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(2,4);
INSERT INTO generos_items (video_id,genero_id) VALUES(3,3);
INSERT INTO generos_items (video_id,genero_id) VALUES(3,1);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(3,5);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(3,6);
INSERT INTO generos_items (video_id,genero_id) VALUES(4,1);
INSERT INTO generos_items (video_id,genero_id) VALUES(4,6);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(4,7);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(4,5);
INSERT INTO generos_items (video_id,genero_id) VALUES(5,7);
INSERT INTO generos_items (video_id,genero_id) VALUES(5,5);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(5,6);
INSERT INTO idiomas_items (video_id,idioma_id) VALUES(5,4);



INSERT INTO fichas_items (ficha_id, video_id) VALUES(1, 1);
INSERT INTO fichas_items (ficha_id, video_id) VALUES(1, 2);

INSERT INTO fichas_items (ficha_id, video_id) VALUES(2, 4);
INSERT INTO fichas_items (ficha_id, video_id) VALUES(2, 3);

INSERT INTO fichas_items (ficha_id, video_id) VALUES(3, 2);


INSERT INTO fichas_items (ficha_id, video_id) VALUES(4, 2);
INSERT INTO fichas_items (ficha_id, video_id) VALUES(4, 4);

INSERT INTO fichas_items (ficha_id, video_id) VALUES(3, 2);
INSERT INTO fichas_items (ficha_id, video_id) VALUES(3, 3);
INSERT INTO fichas_items (ficha_id, video_id) VALUES(3, 1);
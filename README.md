# administrador de usuarios by Nisum

MS destinado a la gestion de usuarios

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_maven_

_java 11_

puedes verificar esto corriendo el comando

```
mnv -version
```

### Instalación 🔧


_Descargar el codigo fuente desde el repositorio de gitlab_

```
git clone https://github.com/aguilarjuan/management
```

una vez levantado el proyecto, el mismo estara escuchando en la URL: http://localhost:8080

## Ejecutando las pruebas ⚙️

_las pruebas se realizan mediante la herramientas Postman_

exporte el archivo (reba.postman_collection.json) ubicacion:

```
../src/resource/nisum.postman_collection.json
```

_Script shema DB_

```
../src/resource/init-shema-nisum.sql
```

_Diagrama de solucion_

```
../src/resource/diagrama-solucion.jpg
```


### documentacion de aplicacion 🔩

_la documentacion de la Api Rest_

```
http://localhost:8080/swagger-ui.html#/
```

### base de datos ⌨️

_el proyecto contiene una base en memoria H2_

acceso a la consola de administracion

```
http://localhost:8080/h2-console
```

## Despliegue 📦

_ingresar al directorio raiz en donde se ubica la carpeta del proyecto y ejecuta el siguiente comando maven_

```
mvn spring-boot:run
```

## Construido con 🛠️

_Spring Boot 2.4.6_

## Versionado 📌

codigo fuente es versionado en Github

## Autores ✒️

* **Aguiar juan carlos** - *developer* - [jucaguilar](https://gitlab.com/jucaguilar-01)

## Licencia 📄

Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo [LICENSE.md](LICENSE.md) para detalles

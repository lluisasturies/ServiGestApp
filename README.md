# ServiGest App
Proyecto de Desarrollo de Aplicaciones Web. 2020

## Qué es ServiGest?
> ServiGest es una aplicación web, desarrollada en Java con Spring Boot y Angular para empresas del sector de servicios de reparación e instalación de aparatos de gas, electrodomésticos o fontanería. Se trata de una plataforma en la que poder gestionar los clientes y los trabajos realizados.

## Despliegue
Primero compilar el backend
```
mvn package -DskipTests
```

Compilar el frontend
```
npm install
```
```
ng-build --prod
```

Para desplegar basta con escribir el comando
```
docker-compose up
```

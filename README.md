# DSW2_Proyecto_Huron_Azul_Servicio
Servicio Web SOAP basado en Java configurado para servidores Tomcat v7

## Requisitos 
1. Servidor Apache Tomcat 7
1. MySQL Server 8.0
1. Java 8 (jre, jdk 1.8)
1. Eclipse IDE for Enterprise Java and Web Developers - Latest Release

## Configuración espacio de trabajo
1. Para java 8   
Windows/Preferences/Java/Installed JREs -> Borrar Todo, añadir jre 1.8   
Windows/Preferences/Java/Compiler -> Compliance level 1.8   
1. Para servidor Tomcat   
Windows/Preferences/Server/Runtime Enviroments -> Add Apache Tomcat v7.0   

## Ejecutando el proyecto
1. Clonar el repositorio en el espacio de trabajo
1. Abrir y ejecutar **sql/SCRIPT_BD_HURON_AZUL_MySQL.sql** en el servidor Mysql local
1. Run as -> Run on Server -> Correr en Tomcat

Si se desea cambiar la configuracion de bd entrar a **/src/main/java/sql/ConectaDB.java**


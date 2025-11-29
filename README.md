# api-gestion-inventarios
Proyecto académico: API para gestión de inventarios (Universidad de El Salvador). Incluye registro de productos, proveedores, usuarios, categorías, control de stock y alertas de inventario.

# API para Gestión de Inventarios

## 📌 Descripción
Este proyecto corresponde a la asignatura **Programación Orientada a Objetos (POO)** de la Universidad de El Salvador.  
Se trata de una API diseñada para administrar un sistema de inventarios, con funcionalidades de registro y consulta de productos, proveedores, categorías y usuarios, así como control de stock mediante entradas y salidas.

## 🚀 Características principales
- Registrar productos, proveedores, categorías y usuarios.
- Actualizar y consultar stock de inventario.
- Registrar movimientos de entradas y salidas.
- Generar alertas automáticas cuando un producto llega a un nivel crítico.
- Consultar alertas activas y resueltas.

## 🛠️ Tecnologías
- Lenguaje: **Java**
- Framework de construcción: **Gradle/Maven**
- Paradigma: **Programación Orientada a Objetos**

## 👨‍💻 Integrantes
- Jacqueline Beatriz Renderos Martínez (RM24005)
- Oscar Manuel Peraza Velásquez (PV21001)
- Diego Roberto Vásquez Ríos (VR22001)
- José Luis Galán González (GG23009)
- Juan José Recinos Murgas (RM24009)

## 🎯 Tutor
- Ing. Erick Adiel Trigueros Jerez

# API de Gestión de Inventarios

API RESTful desarrollada con Spring Boot para la gestión de inventarios universitarios. Permite administrar productos, proveedores, categorías, usuarios y movimientos de stock (entradas y salidas).

## 🛠 Tecnologías Utilizadas
* Java 17 / 21
* Spring Boot 3.x
* Gradle
* MySQL (Base de datos)
* Lombok
* JUnit 5 & Mockito

## ⚙️ Configuración y Base de Datos

El proyecto está configurado para funcionar "out-of-the-box" sin necesidad de instalar servidores de base de datos externos (como MySQL o Postgres).

**Base de Datos H2 (Modo Archivo):**
La base de datos se creará automáticamente en la carpeta del proyecto:
`./data/inventario_db`

Esto asegura que los datos persistan incluso si se detiene la aplicación, cumpliendo con los requisitos de portabilidad y persistencia.

---

## 🚀 Instrucciones de Ejecución

### Prerrequisitos
* Tener instalado **JDK 21**.
* Tener configurada la variable de entorno `JAVA_HOME`.

### Ejecución desde IntelliJ IDEA Community Edition

1.  **Importar el Proyecto:**
    * Abre IntelliJ IDEA.
    * Selecciona `Open` o `Open Project`.
    * Navega hasta la carpeta `api-gestion-inventarios` y selecciona el archivo `build.gradle`.
    * Haz clic en `Open` (o "Open as Project").

2.  **Configuración Inicial:**
    * Espera a que IntelliJ termine de indexar y descargar las dependencias de Gradle (barra de progreso inferior).
    * Si aparece una alerta, selecciona **"Load Gradle Project"** o **"Trust Project"**.
    * Asegúrate de que el SDK del proyecto esté configurado en Java 21 (File -> Project Structure -> Project -> SDK).

3.  **Ejecutar la Aplicación:**
    * Navega en el árbol del proyecto a:
      `src/main/java/com/ApiGestionInventariosApplication.java`
    * Haz clic derecho sobre el archivo y selecciona **"Run 'ApiGestionInventarios...'"** (o usa el icono de "Play" verde al lado de la línea `public class`).
    * La consola mostrará los logs de Spring Boot y confirmará que inició en el puerto 8080.
# 📚 Trabajo Práctico – Patrones de Diseño en Java

Comisión 3K10

Integrantes:
* Copparoni, Macarena 
* Echavarria, Emiliano 
* Fernandez, Candela
* Fernandez, Julian 
* Marquez, Matias 
* Montenegro, Sol
* Zaupa, Bruno

Este repositorio contiene la implementación de un **sistema de biblioteca** desarrollado en **Java**, cuyo objetivo es poner en práctica distintos **patrones de diseño**.

El sistema simula la gestión de **usuarios**, **libros** y la interacción con una capa de **UI básica**, utilizando como base los siguientes patrones:

## 🎯 Patrones de diseño implementados

1. **Singleton**

    * Asegura que exista una única instancia de clases centrales, como el gestor de la biblioteca o el manejador de la configuración.

2. **Factory Method**

    * Permite la creación flexible de distintos tipos de objetos de usuario (por ejemplo, *Estudiante*, *Profesor*, *Invitado*) sin exponer la lógica de instanciación.

3. **Abstract Factory**

    * Extiende la idea del Factory Method, agrupando fábricas relacionadas, por ejemplo: fábricas de interfaces gráficas que generan distintos estilos de UI (consola, gráfico, etc.).

4. **Builder**

    * Se aplica para la construcción de objetos complejos como **Libros** (con múltiples atributos opcionales, como autor, género, año de publicación, editorial, etc.), de manera controlada y legible.

5. **Prototype**

    * Se utiliza para clonar objetos existentes (por ejemplo, duplicar un libro o un usuario con sus características).

---

## 📂 Estructura del proyecto

```
/bibliioteca_patrones
  ├── src/
  │   ├── singleton/
  │   ├── factory/
  │   ├── abstractfactory/
  │   ├── builder/
  │   ├── prototype/
  └── Main.java
```

* Cada carpeta contiene la implementación y ejemplos de uso del patrón correspondiente.
* `Main.java` incluye un flujo de prueba que integra los distintos patrones en el contexto de la biblioteca.

---

## 🚀 Ejecución

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/usuario/tp-patrones-diseno-java.git
   ```
2. Compilar el proyecto:

   ```bash
   javac src/Main.java
   ```
3. Ejecutar:

   ```bash
   java -cp src Main
   ```

---

## 📝 Ejemplos de uso

El archivo `Main.java` demuestra cada patrón de diseño en acción dentro del sistema de biblioteca.

---

### 1. **Singleton – Database**

Se asegura una única instancia de la base de datos en memoria:

```java
Database database = Database.getInstance();
database.listLibros(); // Lista inicial vacía

LibroDigital librod1 = new LibroDigital("libro 1", "Autor1", "ISBN1", "Editorial1");
LibroFisico librof1 = new LibroFisico("libro 2", "Autor2", "ISBN2", "Editorial2");

database.addLibro(librod1);
database.addLibro(librof1);
database.listLibros();

// Verificación de misma instancia
Database database2 = Database.getInstance();
System.out.println("Las instancias son iguales? " + database2.equals(database));
```

**Salida en consola:**

```
------------------PARTE 1
Lista de libros en la base de datos:
(no hay libros)

Lista de libros en la base de datos:
LibroDigital{titulo='libro 1', autor='Autor1', isbn='ISBN1', editorial='Editorial1'}
LibroFisico{titulo='libro 2', autor='Autor2', isbn='ISBN2', editorial='Editorial2'}

Las instancias son iguales? true
```

---

### 2. **Factory – Creación de libros**

Se crean objetos de tipo `Libro` sin exponer la lógica de instanciación:

```java
Libro libro1 = LogisticaLibro.fabrica("fisico", "TituloFabrica1", "Autor1", "ISBN1", "Editorial1");
Libro libro2 = LogisticaLibro.fabrica("digital", "TituloFabrica2", "Autor2", "ISBN2", "Editorial2");

System.out.println("LIBRO 1 (creado tipo fisico)");
System.out.println(libro1);
System.out.println(libro1.getClass());
System.out.println("LIBRO 2 (creado tipo digital)");
System.out.println(libro2);
System.out.println(libro2.getClass());
```

**Salida en consola:**

```
------------------PARTE 2
LIBRO 1 (creado tipo fisico)
LibroFisico{titulo='TituloFabrica1', autor='Autor1', isbn='ISBN1', editorial='Editorial1'}
class factory.LibroFisico
LIBRO 2 (creado tipo digital)
LibroDigital{titulo='TituloFabrica2', autor='Autor2', isbn='ISBN2', editorial='Editorial2'}
class factory.LibroDigital
```

---

### 3. **Abstract Factory – Interfaces gráficas**

Se generan diferentes tipos de interfaz de usuario según el rol:

```java
InterfazUI adminUIFactory = AbstractFactory.obtenerInterfaz("Admin");
Render ui = adminUIFactory.crearInterfaz();
ui.pintar(); // Muestra interfaz de Administrador

InterfazUI userUIFactory = AbstractFactory.obtenerInterfaz("Usuario");
Render ui2 = userUIFactory.crearInterfaz();
ui2.pintar(); // Muestra interfaz de Usuario
```

**Salida en consola:**

```
------------------PARTE 3
Implementación de Abstract factory. Debe crear UI Admin primero y luego UI Usuario
[Pintando interfaz de Administrador...]
[Pintando interfaz de Usuario...]
```

---

### 4. **Builder – Creación de usuarios**

Se construyen objetos `Usuario` con parámetros opcionales:

```java
Usuario user1 = new Usuario.Builder()
        .setNombre("Fulanito")
        .setEmail("fulanito@email.com")
        .build();

Usuario user2 = new Usuario.Builder()
        .setNombre("Menganito")
        .setTelefono("123456789")
        .setDireccion("Calle Falsa 123")
        .build();

System.out.println(user1);
System.out.println(user2);
```

**Salida en consola:**

```
---------------PARTE 4
Implementación de Builder.
Usuario{nombre='Fulanito', email='fulanito@email.com', telefono='null', direccion='null'}
Usuario{nombre='Menganito', email='null', telefono='123456789', direccion='Calle Falsa 123'}
```

---

### 5. **Prototype – Clonación de préstamos**

Se clonan objetos existentes modificando algunos atributos:

```java
Prestamo prestamo = new Prestamo("Moby Dick", "Pepe", "1/01/2025", "1/03/2025");

Prestamo copia = prestamo.clone();
copia.setLibro("El Principito");

Prestamo copia2 = prestamo.clone();
copia2.setLibro("El Eternauta");

System.out.println("Objeto original: " + prestamo);
System.out.println("Objeto copia: " + copia);
System.out.println("Objeto copia2: " + copia2);
```

**Salida en consola:**

```
---------------PARTE 5
Implementación de Prototype
Objeto original: Prestamo{libro='Moby Dick', usuario='Pepe', fechaInicio='1/01/2025', fechaFin='1/03/2025'}
Objeto copia: Prestamo{libro='El Principito', usuario='Pepe', fechaInicio='1/01/2025', fechaFin='1/03/2025'}
Objeto copia2: Prestamo{libro='El Eternauta', usuario='Pepe', fechaInicio='1/01/2025', fechaFin='1/03/2025'}
```

---

## 🎓 Objetivo académico

Este trabajo práctico tiene como finalidad:

* Comprender la **importancia de los patrones de diseño** en la resolución de problemas comunes de software.
* Aplicar los patrones en un **contexto concreto** (sistema de biblioteca).
* Analizar las **ventajas y desventajas** de cada patrón.

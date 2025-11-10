# Trabajo Práctico: Programación Funcional en Java 🚀

## 📋 Descripción

Este proyecto es un trabajo práctico completo sobre **Programación Funcional en Java**, donde se aplican operaciones de **Streams API** para procesar colecciones de forma declarativa y eficiente.

## 🎯 Objetivo General

Practicar operaciones intermedias y terminales de los Streams en Java para procesar colecciones de forma declarativa, utilizando las mejores prácticas de programación funcional.

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Lombok** - Para reducir código boilerplate
- **Streams API** - Para procesamiento funcional de colecciones
- **IntelliJ IDEA** - IDE de desarrollo

## 📚 Ejercicios Implementados

### 1️⃣ Ejercicio: Gestión de Alumnos

**Entidad:** `Alumno(nombre, apellido, nota, curso)`

**Operaciones implementadas:**
- ✅ Listar alumnos aprobados (nota ≥ 7) en mayúsculas y ordenados
- ✅ Calcular el promedio general de notas
- ✅ Agrupar alumnos por curso
- ✅ Obtener los 3 mejores promedios por curso

**Conceptos aplicados:**
- `filter()`, `map()`, `sorted()`, `collect()`
- `mapToInt()`, `average()`
- `Collectors.groupingBy()`, `Collectors.averagingDouble()`

---

### 2️⃣ Ejercicio: Gestión de Productos

**Entidad:** `Producto(nombre, categoria, precio, stock)`

**Operaciones implementadas:**
- ✅ Filtrar productos con precio > 100, ordenados descendentemente
- ✅ Agrupar por categoría y calcular stock total
- ✅ Generar String concatenado con formato "nombre;precio"
- ✅ Calcular promedio de precio general y por categoría

**Conceptos aplicados:**
- `Comparator.comparingDouble().reversed()`
- `Collectors.summingInt()` - Suma de valores enteros
- `Collectors.joining()` - Concatenación de strings
- `Collectors.averagingDouble()` - Promedio por grupos

---

### 3️⃣ Ejercicio: Gestión de Libros

**Entidad:** `Libro(titulo, autor, paginas, precio)`

**Operaciones implementadas:**
- ✅ Listar títulos de libros con más de 300 páginas, ordenados alfabéticamente
- ✅ Calcular el promedio de páginas de todos los libros
- ✅ Agrupar libros por autor y contar cuántos tiene cada uno
- ✅ Obtener el libro más caro de la lista

**Conceptos aplicados:**
- `filter()` + `map()` + `sorted()` - Pipeline de transformaciones
- `Collectors.counting()` - Conteo de elementos por grupo
- `max()` + `Comparator` - Búsqueda de máximo
- `Optional.ifPresent()` - Manejo seguro de valores opcionales

---

### 4️⃣ Ejercicio: Gestión de Empleados

**Entidad:** `Empleado(nombre, apellido, departamento, salario, edad)`

**Operaciones implementadas:**
- ✅ Obtener empleados con salario > 2000, ordenados por salario descendente
- ✅ Calcular el salario promedio general
- ✅ Agrupar empleados por departamento y calcular suma de salarios
- ✅ Obtener los nombres de los 2 empleados más jóvenes

**Conceptos aplicados:**
- `Collectors.summingDouble()` - Downstream collector para sumar valores
- `limit()` - Limitación de resultados
- Combinación de `sorted()`, `limit()` y `map()` para consultas complejas
- `Comparator.comparingInt()` - Comparación por valores enteros

---

## 🔑 Conceptos Clave de Streams API

### Operaciones Intermedias
- `filter()` - Filtrado de elementos
- `map()` - Transformación de elementos
- `sorted()` - Ordenamiento
- `limit()` - Limitación de resultados
- `mapToInt()`, `mapToDouble()` - Conversión a tipos primitivos

### Operaciones Terminales
- `collect()` - Recolección de resultados
- `forEach()` - Iteración sobre elementos
- `average()` - Cálculo de promedio
- `max()`, `min()` - Búsqueda de extremos
- `count()` - Conteo de elementos

### Collectors Avanzados
- `Collectors.toList()` - Conversión a lista
- `Collectors.groupingBy()` - Agrupación por criterio
- `Collectors.counting()` - Conteo de elementos
- `Collectors.summingInt()` / `summingDouble()` - Suma de valores
- `Collectors.averagingDouble()` - Promedio de valores
- `Collectors.joining()` - Concatenación de strings

---

## 📂 Estructura del Proyecto

import entidades.Alumno;
import entidades.Empleado;
import entidades.Libro;
import entidades.Producto;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //EJERCICIO 1 ALUMNOS
        System.out.println("========== EJERCICIO 1: ALUMNOS ==========\n");

        List<Alumno> alumnos = new ArrayList<>();

        Alumno a1 = Alumno.builder()
                .nombre("Ezequiel")
                .apellido("Abadie")
                .nota(10)
                .curso("3K10")
                .build();

        Alumno a2 = Alumno.builder()
                .nombre("Santino")
                .apellido("Andino")
                .nota(9)
                .curso("3K10")
                .build();

        Alumno a3 = Alumno.builder()
                .nombre("Maxi")
                .apellido("López")
                .nota(6)
                .curso("3K09")
                .build();

        Alumno a4 = Alumno.builder()
                .nombre("Ana")
                .apellido("Martínez")
                .nota(7)
                .curso("3K10")
                .build();

        Alumno a5 = Alumno.builder()
                .nombre("Luis")
                .apellido("Rodríguez")
                .nota(8)
                .curso("3K09")
                .build();

        alumnos.add(a1);
        alumnos.add(a2);
        alumnos.add(a3);
        alumnos.add(a4);
        alumnos.add(a5);

        System.out.println("===  Alumnos Aprobados ===");
        List<String> aprobados = alumnos.stream()
                .filter(alumno -> alumno.getNota() >= 7)
                .map(alumno -> alumno.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        aprobados.forEach(System.out::println);

        System.out.println("\n===  Promedio General ===");
        double promedio = alumnos.stream()
                .mapToInt(Alumno::getNota)
                .average()
                .orElse(0.0);
        System.out.println("Promedio: " + promedio);

        System.out.println("\n===  Alumnos agrupados por Curso ===");
        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
        alumnosPorCurso.forEach((curso, listaAlumnos) -> {
            System.out.println("Curso " + curso + ":");
            listaAlumnos.forEach(alumno -> System.out.println("  - " + alumno));
        });


        //devuelve las 3 mejores notas porque ahora solo tiene 1 nota cada alumno
        System.out.println("\n===   3 Mejores promedios ===");
        List<Alumno> top3 = alumnos.stream()
                .sorted(Comparator.comparingInt(Alumno::getNota).reversed())
                .limit(3)
                .collect(Collectors.toList());
        top3.forEach(alumno -> System.out.println(alumno.getNombre() + " - Nota: " + alumno.getNota()));

        //EJERCICIO 2 PRODUCTOS
        System.out.println("\n\n========== EJERCICIO 2: PRODUCTOS ==========\n");

        List<Producto> productos = new ArrayList<>();

        Producto p1 = Producto.builder()
                .nombre("Lenovo Legion")
                .categoria("Electrónica")
                .precio(1500.0)
                .stock(10)
                .build();

        Producto p2 = Producto.builder()
                .nombre("Mouse Logitech")
                .categoria("Electrónica")
                .precio(50.0)
                .stock(25)
                .build();

        Producto p3 = Producto.builder()
                .nombre("Silla Gamer")
                .categoria("Muebles")
                .precio(300.0)
                .stock(15)
                .build();

        Producto p4 = Producto.builder()
                .nombre("Teclado Razer")
                .categoria("Electrónica")
                .precio(99.0)
                .stock(20)
                .build();

        Producto p5 = Producto.builder()
                .nombre("Escritorio")
                .categoria("Muebles")
                .precio(200.0)
                .stock(8)
                .build();

        Producto p6 = Producto.builder()
                .nombre("Monitor 240Hz")
                .categoria("Electrónica")
                .precio(350.0)
                .stock(12)
                .build();

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);

        // 1. Productos con precio > 100, ordenados por precio descendente
        System.out.println("=== 1. Productos con precio > 100 (ordenados) ===");
        List<Producto> productoscaros = productos.stream()
                .filter(producto -> producto.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
        productoscaros.forEach(p -> System.out.println(p.getNombre() + " - $" + p.getPrecio()));

        // 2. Agrupar por categoría y calcular stock total
        System.out.println("\n=== 2. Stock Total por Categoría ===");
        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));
        stockPorCategoria.forEach((categoria, stockTotal) ->
                System.out.println(categoria + ": " + stockTotal + " unidades"));

        // 3. String con nombre y precio separados por ";"
        System.out.println("\n=== 3. Productos (nombre;precio) ===");
        String productosLista = productos.stream()
                .map(p -> p.getNombre() + ";" + p.getPrecio())
                .collect(Collectors.joining(" | "));
        System.out.println(productosLista);

        // 4. Precio promedio general y por categoría
        System.out.println("\n=== 4. Promedios de Precio ===");

        // Promedio general
        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        System.out.println("Promedio General: $" + String.format("%.2f", promedioGeneral));

        // Promedio por categoría
        System.out.println("\nPromedio por Categoría:");
        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        promedioPorCategoria.forEach((categoria, promedioCat) ->
                System.out.println(categoria + ": $" + String.format("%.2f", promedioCat)));

        //EJERCICIO 3 LIBROS
        System.out.println("\n\n========== EJERCICIO 3: LIBROS ==========\n");
        List<Libro> libros = new ArrayList<>();

        Libro l1 = Libro.builder()
                .titulo("El Quijote")
                .autor("Miguel de Cervantes")
                .paginas(863)
                .precio(7000)
                .build();

        Libro l2 = Libro.builder()
                .titulo("Cien Años de Soledad")
                .autor("Gabriel García Márquez")
                .paginas(417)
                .precio(18000)
                .build();

        Libro l3 = Libro.builder()
                .titulo("1984")
                .autor("George Orwell")
                .paginas(328)
                .precio(15099)
                .build();

        Libro l4 = Libro.builder()
                .titulo("El Principito")
                .autor("Antoine de Saint-Exupéry")
                .paginas(96)
                .precio(12550)
                .build();

        Libro l5 = Libro.builder()
                .titulo("Rebelión en la Granja")
                .autor("George Orwell")
                .paginas(144)
                .precio(14000)
                .build();

        Libro l6 = Libro.builder()
                .titulo("Fahrenheit 451")
                .autor("Ray Bradbury")
                .paginas(249)
                .precio(16775)
                .build();

        Libro l7 = Libro.builder()
                .titulo("Rayuela")
                .autor("Julio Cortázar")
                .paginas(736)
                .precio(22000)
                .build();

        Libro l8 = Libro.builder()
                .titulo("El Amor en los Tiempos del Cólera")
                .autor("Gabriel García Márquez")
                .paginas(368)
                .precio(19550)
                .build();

        libros.add(l1);
        libros.add(l2);
        libros.add(l3);
        libros.add(l4);
        libros.add(l5);
        libros.add(l6);
        libros.add(l7);
        libros.add(l8);

        // 1. Títulos de libros con más de 300 páginas, ordenados alfabéticamente
        System.out.println("=== 1. Libros con más de 300 páginas (ordenados) ===");
        List<String> titulosLargos = libros.stream()
                .filter(libro -> libro.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());
        titulosLargos.forEach(System.out::println);

        // 2. Promedio de páginas de todos los libros
        System.out.println("\n=== 2. Promedio de Páginas ===");
        double promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);
        System.out.println("Promedio: " + String.format("%.2f", promedioPaginas) + " páginas");

        // 3. Agrupar libros por autor y contar cuántos tiene cada uno
        System.out.println("\n=== 3. Libros por Autor ===");
        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));
        librosPorAutor.forEach((autor, cantidad) ->
                System.out.println(autor + ": " + cantidad + " libro(s)"));

        // 4. Libro más caro de la lista
        System.out.println("\n=== 4. Libro Más Caro ===");
        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));
        libroMasCaro.ifPresent(libro ->
                System.out.println(libro.getTitulo() + " - $" + libro.getPrecio() + " (" + libro.getPaginas() + " págs)"));

        //EJERCICIO 4 EMPLEADOS
        System.out.println("\n\n========== EJERCICIO 4: EMPLEADOS ==========\n");

        List<Empleado> empleados = new ArrayList<>();

        Empleado e1 = Empleado.builder()
            .nombre("Juan")
            .apellido("Pérez")
            .Departamento("Ventas")
            .salario(2500.0)
            .edad(35)
            .build();

        Empleado e2 = Empleado.builder()
            .nombre("María")
            .apellido("García")
            .Departamento("IT")
            .salario(3200.0)
            .edad(28)
            .build();

        Empleado e3 = Empleado.builder()
            .nombre("Carlos")
            .apellido("López")
            .Departamento("RRHH")
            .salario(1800.0)
            .edad(42)
            .build();

        Empleado e4 = Empleado.builder()
            .nombre("Ana")
            .apellido("Martínez")
            .Departamento("IT")
            .salario(3500.0)
            .edad(30)
            .build();

        Empleado e5 = Empleado.builder()
            .nombre("Luis")
            .apellido("Rodríguez")
            .Departamento("Ventas")
            .salario(2200.0)
            .edad(25)
            .build();

        Empleado e6 = Empleado.builder()
            .nombre("Laura")
            .apellido("Fernández")
            .Departamento("RRHH")
            .salario(1950.0)
            .edad(33)
            .build();

        Empleado e7 = Empleado.builder()
            .nombre("Pedro")
            .apellido("Sánchez")
            .Departamento("IT")
            .salario(2800.0)
            .edad(26)
            .build();

        Empleado e8 = Empleado.builder()
            .nombre("Sofía")
            .apellido("Gómez")
            .Departamento("Ventas")
            .salario(2100.0)
            .edad(29)
            .build();

        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);
        empleados.add(e4);
        empleados.add(e5);
        empleados.add(e6);
        empleados.add(e7);
        empleados.add(e8);

        // 1. Empleados con salario > 2000, ordenados por salario descendente
        System.out.println("=== 1. Empleados con salario > 2000 (ordenados) ===");
        List<Empleado> empleadosAltoSalario = empleados.stream()
            .filter(empleado -> empleado.getSalario() > 2000)
            .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
            .collect(Collectors.toList());
        empleadosAltoSalario.forEach(emp ->
            System.out.println(emp.getNombre() + " - $" + emp.getSalario()));

        // 2. Salario promedio general
        System.out.println("\n=== 2. Salario Promedio General ===");
        double promedioSalario = empleados.stream()
            .mapToDouble(Empleado::getSalario)
            .average()
            .orElse(0.0);
        System.out.println("Promedio: $" + String.format("%.2f", promedioSalario));

        // 3. Agrupar por departamento y calcular suma de salarios
        System.out.println("\n=== 3. Suma de Salarios por Departamento ===");
        Map<String, Double> salariosPorDepartamento = empleados.stream()
            .collect(Collectors.groupingBy(
                Empleado::getDepartamento,
                Collectors.summingDouble(Empleado::getSalario)
            ));
        salariosPorDepartamento.forEach((departamento, sumaSalarios) ->
            System.out.println(departamento + ": $" + String.format("%.2f", sumaSalarios)));

        // 4. Nombres de los 2 empleados más jóvenes
        System.out.println("\n=== 4. Los 2 Empleados Más Jóvenes ===");
        List<String> masJovenes = empleados.stream()
            .sorted(Comparator.comparingInt(Empleado::getEdad))
            .limit(2)
            .map(Empleado::getNombre)
            .collect(Collectors.toList());
        masJovenes.forEach(System.out::println);
    }
}

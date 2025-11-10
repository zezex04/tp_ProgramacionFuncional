import entidades.Alumno;
import entidades.Producto;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // ========== EJERCICIO 1: ALUMNOS ==========
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

        System.out.println("\n===   3 Mejores Notas ===");
        List<Alumno> top3 = alumnos.stream()
            .sorted(Comparator.comparingInt(Alumno::getNota).reversed())
            .limit(3)
            .collect(Collectors.toList());
        top3.forEach(alumno -> System.out.println(alumno.getNombre() + " - Nota: " + alumno.getNota()));

        // ========== EJERCICIO 2: PRODUCTOS ==========
        System.out.println("\n\n========== EJERCICIO 2: PRODUCTOS ==========\n");

        List<Producto> productos = new ArrayList<>();

        Producto p1 = Producto.builder()
            .nombre("Laptop Dell")
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
            .nombre("Teclado Mecánico")
            .categoria("Electrónica")
            .precio(120.0)
            .stock(20)
            .build();

        Producto p5 = Producto.builder()
            .nombre("Escritorio")
            .categoria("Muebles")
            .precio(200.0)
            .stock(8)
            .build();

        Producto p6 = Producto.builder()
            .nombre("Monitor Samsung")
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
        List<Producto> productosCostosos = productos.stream()
            .filter(producto -> producto.getPrecio() > 100)
            .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
            .collect(Collectors.toList());
        productosCostosos.forEach(p -> System.out.println(p.getNombre() + " - $" + p.getPrecio()));

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
        System.out.println("\n=== 3. Productos formateados (nombre;precio) ===");
        String productosFormateados = productos.stream()
            .map(p -> p.getNombre() + ";" + p.getPrecio())
            .collect(Collectors.joining(" | "));
        System.out.println(productosFormateados);

        // 4. Precio promedio general y por categoría
        System.out.println("\n=== 4. Promedios de Precio ===");

        // Promedio general
        double promedioGeneral = productos.stream()
            .mapToDouble(Producto::getPrecio)
            .average()
            .orElse(0.0);
        System.out.println("Promedio General: $" + String.format("%.2f", promedioGeneral));

        // Promedio por categoría
// Promedio por categoría
System.out.println("\nPromedio por Categoría:");
Map<String, Double> promedioPorCategoria = productos.stream()
    .collect(Collectors.groupingBy(
        Producto::getCategoria,
        Collectors.averagingDouble(Producto::getPrecio)
    ));
promedioPorCategoria.forEach((categoria, promedioCat) ->
    System.out.println(categoria + ": $" + String.format("%.2f", promedioCat)));
    }
}

package entidades;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
}
package entidades;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private double precio;
}
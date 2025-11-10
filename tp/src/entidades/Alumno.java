package entidades;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Alumno {
    private String nombre;
    private String apellido;
    private int nota;
    private String curso;
}
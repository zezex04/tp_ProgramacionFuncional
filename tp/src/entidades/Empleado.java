package entidades;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Empleado {
    private String nombre;
    private String apellido;
    private String Departamento;
    private double salario;
    private int edad;

}

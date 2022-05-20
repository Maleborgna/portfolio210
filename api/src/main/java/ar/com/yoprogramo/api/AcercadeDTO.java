package ar.com.yoprogramo.api;

import jakarta.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;

public class AcercadeDTO {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    public AcercadeDTO() {
    }
    public AcercadeDTO(@NotBlank String nombre, @NotBlank String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import jakarta.persistence.*;
import java.io.Serializable;
/**
 *num INT 
	nombreMascota VARCHAR(15),
	tipo VARCHAR(15),
	nombreDuenio VARCHAR(20),
	telDuenio INT(9),
	DNIDuenio VARCHAR
 * @author Diurno
 */
@Entity
@Table(name="ANIMAL")
public class Animal implements Serializable{
    @Id
    @Column (name="num")
    private int id;
    @Column (name="nombreMascota")
    private String nombreM;
    @Column (name="tipo")
    private String tipo;


    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="persona", column = @Column(name="perContacto")),
        @AttributeOverride(name="telf", column = @Column(name="telContacto")),
        @AttributeOverride(name="dni", column = @Column(name="DNIContacto"))
    })
    private Contacto c;
    
    public Animal() {
    }

    public Animal(String nombreM, String tipo, Contacto c) {
        this.nombreM = nombreM;
        this.tipo = tipo;
        this.c = c;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * *
id INT PRIMARY KEY AUTO_INCREMENT,
	nombreVeterinario VARCHAR(20),
	fechaEntrada DATE,
	perContacto VARCHAR(20),
	telContacto INT(9),
	DNIContacto VARCHAR
 * @author Diurno
 */
@Entity
@Table(name="VETERINARIO")
public class Veterinaria implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Porque el id es auto incrementable
    @Column (name="id")
    private int id;
    @Column (name="nombreVeterinario")
    private String nombre;
    
    @Temporal(TemporalType.DATE)
    @Column (name="fechaEntrada")
    private Date fecha;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="persona", column = @Column(name="perContacto")),
        @AttributeOverride(name="telf", column = @Column(name="telContacto")),
        @AttributeOverride(name="dni", column = @Column(name="DNIContacto"))
    })
    private Contacto c;
    
    public Veterinaria() {
    }

    public Veterinaria(int id) {
        this.id = id;
    }

    public Veterinaria(String nombre, Date fecha, Contacto c) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.c = c;
    }

    public Contacto getC() {
        return c;
    }

    public void setC(Contacto c) {
        this.c = c;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    
}

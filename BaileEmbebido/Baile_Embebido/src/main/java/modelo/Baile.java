/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author Diurno
 */
@Entity
@Table(name="Baile")
public class Baile implements Serializable{
    @Id
    @Column (name="idBaile")
    private int id;
    @Column (name="nombreBaile")
    private String nombre;
    @Column (name="plazasLibres")
    private int plazas;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="via", column=@Column(name="calle")),
        @AttributeOverride(name="numero", column=@Column(name="numero"))
    })
    private Direccion d;

    public Baile() {
    }

    public Baile(int id, String nombre, int plazas, Direccion d) {
        this.id = id;
        this.nombre = nombre;
        this.plazas = plazas;
        this.d=d;
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

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public Direccion getD() {
        return d;
    }

    public void setD(Direccion d) {
        this.d = d;
    }
    
            
}

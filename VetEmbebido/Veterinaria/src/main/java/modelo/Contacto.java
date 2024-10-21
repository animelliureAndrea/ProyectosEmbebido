/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Column;

/**
 *
 * @author Diurno
 */
public class Contacto {
    @Column (name="perContacto")
    private String persona;
    @Column (name="telContacto")
    private int telf;
    @Column (name="DNIContacto")
    private String dni;

    public Contacto() {
    }

    public Contacto(String persona, int telf, String dni) {
        this.persona = persona;
        this.telf = telf;
        this.dni = dni;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}

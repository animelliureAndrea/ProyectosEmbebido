/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author Diurno
 */
@Embeddable
public class Direccion {
     @Column (name="calle")
    private String via;
      @Column (name="numero")
    private int numero;
       @Column (name="codPostal")
    private int codP;

    public Direccion() {
    }

    public Direccion(String via, int numero, int codP) {
        this.via = via;
        this.numero = numero;
        this.codP = codP;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodP() {
        return codP;
    }

    public void setCodP(int codP) {
        this.codP = codP;
    }
    
}

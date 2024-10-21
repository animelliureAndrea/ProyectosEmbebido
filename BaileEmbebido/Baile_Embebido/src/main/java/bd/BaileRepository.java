/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import jakarta.persistence.EntityManager;
import modelo.Baile;

/**
 *
 * @author Diurno
 */
public class BaileRepository {

    public BaileRepository() {
    }
    public void salvar(EntityManager em, Baile b){
        //iniciamos la transaccion
        em.getTransaction().begin();
        
        //persistir el onjeto a insertar
        em.persist(b);
        
        //guardamos los cambios en la transaccion
        em.getTransaction().commit();
    }
}

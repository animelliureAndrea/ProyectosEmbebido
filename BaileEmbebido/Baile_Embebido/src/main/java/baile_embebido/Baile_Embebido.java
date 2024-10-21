/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package baile_embebido;

import bd.BaileRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Baile;
import modelo.Direccion;

/**
 *
 * @author Diurno
 */
public class Baile_Embebido {

    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("UnidadDePersistencia");
        EntityManager em = enf.createEntityManager();
        
        BaileRepository br= new BaileRepository();
        
        Direccion d=  new Direccion("paseo prior",2,26004);
        Baile b = new Baile(1, "Bachata", 4,d);
        Baile b2 = new Baile(2, "Folk", 1, d);
        
        br.salvar(em, b2);
        em.close();
        enf.close();
    }
}

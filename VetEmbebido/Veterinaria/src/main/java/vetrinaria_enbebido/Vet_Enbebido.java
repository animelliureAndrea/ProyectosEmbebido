/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vetrinaria_enbebido;

import bd.AnimalRepository;
import bd.VetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import modelo.Animal;
import modelo.Contacto;
import modelo.Veterinaria;

/**
 *
 * @author Diurno
 */
public class Vet_Enbebido {
    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("UnidadDePersistencia");
        EntityManager em = enf.createEntityManager();
        
        VetRepository vet = new VetRepository();
        AnimalRepository animal = new AnimalRepository(em);
        
        Date fecha = new Date();
        Contacto c= new Contacto("Andrea", 666666666, "1234A");
        Veterinaria v = new Veterinaria("VetVet",fecha,c);
        //vet.salvar(em, v);
        
        Animal a1 = new Animal("Kenzo","Gato Siberiano", c);
        animal.salvar( a1);
        
        enf.close();
        em.close();
    }
}

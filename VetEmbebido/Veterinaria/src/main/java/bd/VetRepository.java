/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import modelo.Veterinaria;

/**
 *
 * @author Diurno
 */
public class VetRepository {
    EntityManager em;

    public VetRepository(EntityManager em) {
        this.em = em;
    }
    
    public VetRepository() {
    }
    public void salvar(EntityManager em, Veterinaria v){
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
    }
    
    public Veterinaria findById(int id){
        Veterinaria v = em.find(Veterinaria.class, id);
        return v;
    }
    
    public void update(Veterinaria nueva){
        em.getTransaction().begin();
        Veterinaria vieja = findById(nueva.getId());
        vieja.setFecha(nueva.getFecha());
        vieja.setId(nueva.getId());
        em.getTransaction().commit();
    }
    
    public void updateUno(Veterinaria vieja, String nom){
        em.getTransaction().begin();
        vieja = findById(vieja.getId());
        vieja.setNombre(nom);
        em.getTransaction().commit();
    }
    
    public void delete(int id){
        em.getTransaction().begin();
        Veterinaria v=findById(id);
        em.remove(v);
        em.getTransaction().commit();
    }
    
    public List<Veterinaria> findByName(String name){
        List<Veterinaria> vets = em.createNamedQuery("Veterinaria.buscarNombre", Veterinaria.class).setParameter("nombre", name).getResultList();
        return vets;
    }
    
    public List<Veterinaria> findAll(){
        List<Veterinaria> vet = em.createQuery("from Veterinaria").getResultList();
        return vet;
    }
    
    public void nativa (){
        String query = "SELECT * FROM Veterinaria";
        List<Veterinaria> vet = em.createNativeQuery(query, Veterinaria.class).getResultList();
        
    }
    
    public void criteria(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Veterinaria> cq = cb.createQuery(Veterinaria.class);
        Root<Veterinaria> root = cq.from(Veterinaria.class);
        cq.select(root);
        cq.where(cb.between(root.get("id"), 5, 8));
        
        List<Veterinaria> vet = em.createQuery(cq).getResultList();
        
    }
}

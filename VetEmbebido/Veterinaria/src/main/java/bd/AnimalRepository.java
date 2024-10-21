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
import modelo.Animal;

/**
 *
 * @author Diurno
 */
public class AnimalRepository {
    EntityManager em;

    public AnimalRepository() {
    }
    
    //estudiar

    public AnimalRepository(EntityManager em) {
        this.em = em;
    }
    
    public void salvar (Animal a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }
    
    public List<Animal> findByName(String nombreM){
        List<Animal> animales = em.createNamedQuery("Animal.buscarNombre", Animal.class).setParameter("nombreM", nombreM).getResultList();
        return animales;
    }
    
    public Animal findById(int id){
        Animal a = em.find(Animal.class, id);
        return a;
    }
    public List<Animal> findAll(){
        List<Animal> animales = em.createQuery("from Animal").getResultList();
        return animales;
    }
    
    public void nativa(){
        String query ="SELECT nombreMascota, tipo FROM animal";
        List<Animal> animales = em.createNativeQuery(query, Animal.class).getResultList();
        
        for(Animal a: animales){
            System.out.println("El nombre es: "+a.getNombreM());
            System.out.println("Su tipo es: "+a.getTipo());
        }
    }
    
    public void condiciones(){
        String query = "SELECT * FROM animal WHERE tipo='Siberiano'";
        List<Animal> animales = em.createQuery(query).getResultList();
        
        for(Animal a: animales){
            System.out.println("El nombre de nuestro siberino: "+ a.getNombreM());
            System.out.println("Su tipo: "+a.getTipo());
        }
    }
    
    public void showCriteria(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Animal> cq = cb.createQuery(Animal.class);
        Root<Animal> root = cq.from(Animal.class);
        cq.select(root);
        cq.where(cb.between(root.get("id"), 1, 5));
        
        List<Animal> animales = em.createQuery(cq).getResultList();
        
        for(Animal a: animales){
            System.out.println("El nombre de nuestro siberino: "+ a.getNombreM());
            System.out.println("Su tipo: "+a.getTipo());
        }
    }
    
    public void update(Animal nuevo){
        em.getTransaction().begin();
        Animal viejo = findById(nuevo.getId());
        viejo.setId(nuevo.getId());
        em.getTransaction().commit();
    }
    
    public void updateTipo(Animal viejo, String tipoNuevo){
        em.getTransaction().begin();
        viejo = findById(viejo.getId());
        viejo.setTipo(tipoNuevo);
        em.getTransaction().commit();
    }
    
    public void remove(int id){
        em.getTransaction().begin();
        Animal a =findById(id);
        em.remove(a);
        em.getTransaction().commit();
    }
}

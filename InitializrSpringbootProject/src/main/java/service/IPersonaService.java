/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Persona;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Personal
 */

@Repository
public interface IPersonaService {
    public List<Persona> getAllPerson();
    public void savePerson(Persona persona);
    public Persona getPersonById(long id);
    public void delete(long id);
    
}

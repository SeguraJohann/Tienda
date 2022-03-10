/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import entity.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Personal
 */
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    
}

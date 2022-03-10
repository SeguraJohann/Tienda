/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PersonaRepository;
import service.IPersonaService;


@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getAllPerson() {
        return (List<Persona>)personaRepository.findAll();
    }

    @Override
    public void savePerson(Persona persona) {
        
        personaRepository.save(persona);
        
        
    }

    @Override
    public Persona getPersonById(long id) {
        return personaRepository.findById(id).orElse(null);
        
    }

    @Override
    public void delete(long id) {
        
        personaRepository.deleteById(id);
        
    }

}
    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.IPersonaService;

/**
 *
 * @author Personal
 */
@Controller
public class PersonasController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping({"/personas"})
    public String index(Model model) {

        List<Persona> listaPersonas = personaService.getAllPerson();
        System.out.println(listaPersonas);
        model.addAttribute("titulo", "Personas");
        model.addAttribute("personas", listaPersonas);
        return "personas";
    }

}

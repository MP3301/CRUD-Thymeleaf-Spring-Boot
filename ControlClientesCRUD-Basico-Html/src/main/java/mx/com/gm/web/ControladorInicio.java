package mx.com.gm.web;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import mx.com.gm.servicio.PersonaService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

   @Autowired
   private PersonaService personaService;

   @GetMapping("/")
   public String inicio(Model model) {
      Iterable<Persona> personasIterable = personaService.listarPersonas();

     // List<Persona> personas = new ArrayList<>();
    //  personasIterable.forEach(personas::add);

      log.info("ejecutando el controlador Spring MVC");
      model.addAttribute("personas", personasIterable);
      return "index";
   }
   
   
      @GetMapping("/agregar")
   public String Agregar(Persona persona) {
      
        
     // List<Persona> personas = new ArrayList<>();
    //  personasIterable.forEach(personas::add);

      log.info("ejecutando el controlador Spring MVC Metodo agregar");
      
      return "modificar";
   }
   
   
         @PostMapping("/guardar")
   public String guardar(Persona persona) {
      
        personaService.guardar(persona);
        
        
     // List<Persona> personas = new ArrayList<>();
    //  personasIterable.forEach(personas::add);

      log.info("ejecutando el controlador Spring MVC Metodo guardar");
      
      return "redirect:/";
   }
   
   
           @GetMapping("/editar/{idPersona}")
   public String Editar(Persona persona, Model model) {
      
       persona = personaService.encontrarPersona(persona);
       
       model.addAttribute("persona",persona);
        
        
     // List<Persona> personas = new ArrayList<>();
    //  personasIterable.forEach(personas::add);

      log.info("ejecutando el controlador Spring MVC Metodo Editar");
      
      return "modificar";
   }
   
   
   
           @GetMapping("/eliminar/{idPersona}")
   public String Eliminar(Persona persona, Model model) {
      
       persona = personaService.encontrarPersona(persona);
       
       personaService.eliminar(persona);
       

        
     // List<Persona> personas = new ArrayList<>();
    //  personasIterable.forEach(personas::add);

      log.info("ejecutando el controlador Spring MVC Metodo Eliminar");
      
      return "redirect:/";
   }
   
   
}

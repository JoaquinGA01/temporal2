package com.uv.helloworld.controllers;

import com.uv.helloworld.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import static spark.Spark.*;

import java.util.List;
import java.util.ArrayList;
@Controller
public class HelloworldController {
    List<Usuarios> usuarios = new ArrayList<Usuarios>();

    @GetMapping("/")
    public String inicio(){
        usuarios.add(new Usuarios(1L,"Pedro","AInEk1020"));
        usuarios.add(new Usuarios(1L,"Joaquin","Kenia25"));
        usuarios.add(new Usuarios(1L,"Carol","Carol52"));
        usuarios.add(new Usuarios(1L,"Jahir","AInEk14"));
        return "Entrada";
    }

    @GetMapping("/index")
    public String hello(String nombre, String pass, Model model){
        
        System.out.println(nombre + pass);
        for(Usuarios usu : usuarios){
            System.out.println(usu);
        }
        for(Usuarios usu : usuarios){
            if(usu.getNombre().equals(nombre)){
                if(usu.getPass().equals(pass)){
                    model.addAttribute("Nombre", nombre);
                    model.addAttribute("Lista", usuarios);
                    return "Tabla";
                }else{
                    model.addAttribute("Error","Contraseña Diferente" );
                    return "Errores";
                }
            }
        }
        model.addAttribute("Error","Usuario Inexistente" );
        return "Errores";    
    }
    
    @GetMapping("/registro")
    public String registrar(String user, String pass, String pass2, Model model){
        if(pass.equals("")||pass.equals("")){
            model.addAttribute("Error","Rellena Todos los Campos" );
            return "Errores";
        }
        if(pass.equals(pass2)){
            usuarios.add(new Usuarios(1L,user,pass));
            model.addAttribute("Nombre", user);
            model.addAttribute("Lista", usuarios);
            return "Tabla";
        }else{
            model.addAttribute("Error","Contraseña Diferente" );
            return "Errores";
        }
    }
}

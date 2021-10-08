package com.actividad.demo;
import static spark.Spark.*;

import org.eclipse.jetty.io.SelectChannelEndPoint;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));


        System.out.println( "Hello World!" );
        get("/hola", (rq , rs)->{
            System.out.println(
                "Request: " + rq.queryParams("usuario") + " " + rq.queryParams("pass")
            );
            String usuario=rq.queryParams("usuario");
            
            if(rq.queryParams("usuario").equals("root")){
                String mensaje = MostrarUsuarios(true,"nada");
                return mensaje;
            }else if(rq.queryParams("usuario").equals("joaquin")){
                String mensaje = MostrarUsuarios(true,"nada");
                return mensaje;
            }else{
                Thread.sleep(5);
                return "Usuario no registrado " + "<a href= '//127.0.0.1:5500/Actividad/actividad/index.html'> regresar </a> ";
                
            }
            
        });

        get("/holaa", (rq , rs)->{
            System.out.println(
                "Request: " + rq.queryParams("usuario") + " " + rq.queryParams("pass")
            );
            String usuario=rq.queryParams("usuario");
            
            if(!rq.queryParams("contraseña2").equals(null)){
                String mensaje = MostrarUsuarios(false, rq.queryParams("usuario"));
                return mensaje;
            }else{
                return "Usuario no registrado " + "<a href= '//127.0.0.1:5500/Actividad/actividad/index.html'> regresar </a> ";
            }  
        });

        

    }

    public static String MostrarUsuarios(Boolean metodo, String usuario){
        if(metodo==true){
        String msj = "Bienvenido" + "\n"+
        "Usuario Registrados" + "<br>" + 
        "<table>" + 
        "<tr>"+
            "<th>Usuarios</th>"+
            "<th>Contraseñas</th>"+
        "</tr>"+
        "<tr>"+
            "<th>root</th>"+
            "<th>root</th>"+
        "</tr>"+
        "<tr>"+
            "<th>joaquin</th>"+
            "<th>asd</th>"+
        "</tr>"+
        "</table><br>"+ 
        "<a href= '//127.0.0.1:5500/Actividad/actividad/index.html'> regresar </a> ";
        return msj;
        }else{
        String msj = "Bienvenido" + "\n"+
        "Usuario Registrados" + "<br>" + 
        "<table>" + 
        "<tr>"+
            "<th>Usuarios</th>"+
            "<th>Contraseñas</th>"+
        "</tr>"+
        "<tr>"+
            "<th>root</th>"+
            "<th>root</th>"+
        "</tr>"+
        "<tr>"+
            "<th>joaquin</th>"+
            "<th>asd</th>"+
        "</tr>"+
        "<tr>"+
            "<th>" + usuario + "</th>"+
            "<th> *****</th>"+
        "</table><br>"+ 
        "<a href= '//127.0.0.1:5500/Actividad/actividad/index.html'> regresar </a> ";
        return msj;
        }
        /*rs.redirect("http://127.0.0.1:5500/Actividad/actividad/Usuario.html");*/
    }
}

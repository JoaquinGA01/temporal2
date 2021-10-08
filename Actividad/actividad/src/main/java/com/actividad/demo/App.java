package com.actividad.demo;
import static spark.Spark.*;
import com.google.gson.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

        ArrayList <String> usuarios = new ArrayList<String>();
        usuarios.add("Root");
        usuarios.add("Joaquin");
        usuarios.add("Alberto");
        usuarios.add("Jesus");
        usuarios.add("Kevin");

        System.out.println( "Hello World!" );

        post("/HolaJson", (rq, rs)->{
            String request = rq.body();
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(request);
            JsonObject peticion = arbol.getAsJsonObject();
            Object nombre =  peticion.get("usuario") ;
            String msj = null;
            if (rq.queryParams("usuario").equals("root"))
                msj = "Bienvenido!";
            else
                msj = "Usuario equivocado";
            return "Hola post " + nombre + " " + "<a href='//127.0.0.1:5500/formulario.html'>regresar</a>";
        });


        get("/hola", (rq , rs)->{
            String usuario=rq.queryParams("usuario");
            System.out.println(
                "Requestssss: " + rq.queryParams("usuario") + " " + rq.queryParams("pass") + 
                usuario + 
                usuarios.size()
            );

            String mensaje = "Usuario no Registrado <a href='//127.0.0.1:5500/Actividad/actividad/index.html'> regresar </a>'";
            for(int i=0; i<usuarios.size();i++){
                System.out.println(usuarios.get(i));
                if(rq.queryParams("usuario").equals(usuarios.get(i))){
                    mensaje = MostrarUsuarios(usuarios);
                    break;
                }
            }
            return mensaje;
        });

        get("/holaa", (rq , rs)->{
            System.out.println(
                "Request: " + rq.queryParams("usuario") + " " + rq.queryParams("pass")
            );
            String usuario=rq.queryParams("usuario");
            usuarios.add(usuario);

            if(!rq.queryParams("contraseña2").equals(null)){
                String mensaje = MostrarUsuarios(usuarios);
                return mensaje;
            }else{
                return "Usuario no registrado " + "<a href= '//127.0.0.1:5500/Actividad/actividad/index.html'> regresar </a> ";
            }  
        });

        

    }

    public static String MostrarUsuarios(ArrayList<String> usuarios){
            String mensaje = "Bienvenidos <br> Usuarios Registrados <br> <table> <tr> <th>Usuarios</th><th>Contraseñas</th></tr>";
            
            for(int i=0; i<usuarios.size(); i++){
                mensaje += "<tr><th>" + usuarios.get(i) +"</th> <th>*****</th></tr>";
            }

            mensaje += "</table><br>"+ 
            "<a href= '//127.0.0.1:5500/Actividad/actividad/index.html'> regresar </a> ";
            return mensaje;
    }
}

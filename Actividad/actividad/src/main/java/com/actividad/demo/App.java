package com.actividad.demo;
import static spark.Spark.*;
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
            String msj;
            if(rq.queryParams("usuario").equals("root")){
                msj = "Bienvenido";
            }else{
                msj = "Usuario no registrado";
            }
            return "Hola get " + msj + " " + "<a href= '//127.0.0.1:5500/index.html'> regresar </a> ";
        });
    }
}

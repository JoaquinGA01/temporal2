package mx.uv.demo;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
//import spark.ModelAndView;
import mx.uv.demo.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Usuarios> usuarios = new ArrayList<Usuarios>();
        port(8080);

        get("/",(rq, rs)->{
            usuarios.add(new Usuarios(1L,"Pedro","AInEk1020"));
            usuarios.add(new Usuarios(1L,"Joaquin","Kenia25"));
            usuarios.add(new Usuarios(1L,"Carol","Carol52"));
            usuarios.add(new Usuarios(1L,"Jahir","AInEk14"));
            Map<String, Object> variables = new HashMap<>();
            variables.put("today", new Date());
            IContext context = new Context(rq.raw().getLocale(), variables);
            String out = ThymeleafUtil.getTemplateEngine().process("home", context);
            return out;
        });

        get("/hola", (req,rs)->{
            Map<String, Object> variables = new HashMap<>();
            variables.put("Lista", usuarios);
            IContext context = new Context(req.raw().getLocale(), variables);
            String out = ThymeleafUtil.getTemplateEngine().process("Tabla", context);
            return out;
        });

        get("/validacion", (rq,rs)->{
            String user = rq.queryParams("nombre");
            String pass = rq.queryParams("pass");
            System.out.println(user + pass);
            Map<String, Object> variables = new HashMap<>();
            for(Usuarios usu : usuarios){
                System.out.println(usu);
            }
            for(Usuarios usu : usuarios){
                if(usu.getNombre().equals(user)){
                    if(usu.getPass().equals(pass)){
                        variables.put("Nombre", user);
                        variables.put("User", user);
                        variables.put("Lista", usuarios);                        
                        IContext context = new Context(rq.raw().getLocale(), variables);
                        String out = ThymeleafUtil.getTemplateEngine().process("Tabla", context);
                        return out;
                    }else{
                        variables.put("Error", "Contraseña Diferente");
                        IContext context = new Context(rq.raw().getLocale(), variables);
                        String out = ThymeleafUtil.getTemplateEngine().process("Errores", context);
                        return out;
                    }
                }
            }
            variables.put("Error", "Usuario Inexistente");
            IContext context = new Context(rq.raw().getLocale(), variables);
            String out = ThymeleafUtil.getTemplateEngine().process("Errores", context);
            return out;    
        });

        get("/registro", (rq, rs)->{
            Map<String, Object> variables = new HashMap<>();
            String user = rq.queryParams("user");
            String pass = rq.queryParams("pass");
            String pass2 = rq.queryParams("pass2");
            if(user.equals("")){
                variables.put("Error", "Agrega un Nombre de Usuario");
                IContext context = new Context(rq.raw().getLocale(), variables);
                String out = ThymeleafUtil.getTemplateEngine().process("Errores", context);
                return out;
            }
            for(Usuarios usu : usuarios){
                if(user.equals(usu.getNombre())){
                    variables.put("Error", "Este Usuario ya Existe");
                    IContext context = new Context(rq.raw().getLocale(), variables);
                    String out = ThymeleafUtil.getTemplateEngine().process("Errores", context);
                    return out;
                }
            }
            if(pass.equals("")||pass.equals("")){
                
                variables.put("Error", "Rellena Todos los Campos");
                IContext context = new Context(rq.raw().getLocale(), variables);
                String out = ThymeleafUtil.getTemplateEngine().process("Errores", context);
                return out;
            }
            if(pass.equals(pass2)){
                usuarios.add(new Usuarios(1L,user,pass));
                variables.put("Nombre", user);
                variables.put("Lista", usuarios);                        
                IContext context = new Context(rq.raw().getLocale(), variables);
                String out = ThymeleafUtil.getTemplateEngine().process("Tabla", context);
                return out;
            }else{
                variables.put("Error", "Contraseña Diferente");
                IContext context = new Context(rq.raw().getLocale(), variables);
                String out = ThymeleafUtil.getTemplateEngine().process("Errores", context);
                return out;
            }
        });
    }
}

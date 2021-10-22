package mx.uv.demo;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafUtil {
    private static TemplateEngine templateEngine;

    public static void init(String ruta) {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        if(ruta==null){
            templateResolver.setPrefix("templates/");
        }else{
            templateResolver.setPrefix("resources/");
        }
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    public static TemplateEngine getTemplateEngine(String ruta) {
        if(ruta == null){       
            if(templateEngine == null) { init(ruta); }    
            return templateEngine;
        }else{
            if(templateEngine == null) { init(ruta); }    
            return templateEngine;
        }
    }
    
    public static String process(String template, IContext context, String ruta) {
        if(ruta == null){
        return getTemplateEngine(ruta).process(template, context);
        }else{
            return getTemplateEngine(ruta).process(template, context);
        }

    }
}

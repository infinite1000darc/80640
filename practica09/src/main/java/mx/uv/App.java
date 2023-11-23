package mx.uv;
import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        get("/", 
        (request,response)->"<h1>Hola Mundo</h1>"
        );

        //fuente:https://gist.github.com/saeidzebardast/e375b7d17be3e0f4dddf

options("/*",(request,response)->{

    String accessControlRequestHeaders=request.headers("Access-Control-Request-Headers");
    
    if(accessControlRequestHeaders!=null){
    
    response.header("Access-Control-Allow-Headers",accessControlRequestHeaders);
    
    }
    
    String accessControlRequestMethod=request.headers("Access-Control-Request-Method");
    
    if(accessControlRequestMethod!=null){
    
    response.header("Access-Control-Allow-Methods",accessControlRequestMethod);
    
    }
    
    return "OK";
    
    });
    
    before((request,response)->response.header("Access-Control-Allow-Origin","*"));
    
        get("/index.html", 
        (request,response)->"<h1>Adiós Mundo</h1>"
        );
        
        get("/1", 
        (request,response)->{
            String parametro = request.queryParams("apellido");
            System.out.println(parametro);
            System.out.println("tipo de contenido" + request.contentType());
            System.out.println("Este es el request" + request.contentType());
            return "<h1>Que tal Mundo</h1>" + parametro + "!";
        });

        post("/1", 
        (request,response)->{
            //String parametro = request.queryParams("apellido");
            String parametro = request.body();
            System.out.println(parametro);
            System.out.println("tipo de contenido" + request.contentType());
            System.out.println("Este es el request" + request.contentType());
            return "<h1>Que tal Mundo</h1>" + parametro + "!";
        });

        get("/2", 
        (request,response)->{
            String parametro = request.queryParams("nombre");
            System.out.println("tipo de contenido" + request.contentType());
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("msj", "hola");
            respuesta.addProperty("apellido", parametro);
            response.type("application/json");
            return respuesta;}
        );
        
        post("/2", 
        (request,response)->{
            String parametro = request.queryParams("nombre");
            System.out.println("tipo de contenido" + request.contentType());
            System.out.println("El body tiene"+parametro);
            
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(parametro);


            //Construye la respuesta JSon
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("msj", "hola");
            respuesta.addProperty("apellido", arbol.getAsJsonObject().get("nombre").getAsString());
            response.type("application/json");
            return respuesta;}
        );

        get("/3", 
        (request,response)-> {
            System.out.println("Este es el request" + request.contentType());
            response.type("application/json");
            return"{\"alumno\":\"John\",\"matrícula\":\"s0081\",\"carrera\":\"tc\"}";
        }
        );
        
    }
}

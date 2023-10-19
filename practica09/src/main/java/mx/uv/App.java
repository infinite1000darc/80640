package mx.uv;

import static spark.Spark.*;
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

        get("/1", 
        (request,response)->"<h1>Adiós Mundo</h1>"
        );
        
        get("/2", 
        (request,response)->"<h1>Que tal Mundo</h1>"
        );
        
        get("/3", 
        (request,response)->"<h1>Ok Mundo</h1>"
        );
        
    }
}

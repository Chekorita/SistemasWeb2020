package wx.uv.sw80688;

import static spark.Spark.*;

import com.google.gson.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        get("/", (reg,res)->"Hola desde spark");
        get("/hola", (reg,res)->"Hola hola");
        get("/adios", (reg,res)->"Adiós desde spark");
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

        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });
        post("/json",(request,response)->{
            // JsonParser parser = new JsonParser();
            // JsonElement arbol = parser.parse(request.body());
            // JsonObject peticion = arbol.getAsJsonObject();

            System.out.println("prm" + request.body());
            System.out.println("prm" + request.contentType());
            return "algo";
        });
        post("/fromdata",(request,response)->{
            //JsonParser parser = new JsonParser();
            //JsonElement arbol = parser.parse(request.body());
            //JsonObject peticion = arbol.getAsJsonObject();
            //tener cuidado de usar el body antes del queryparams porque ya no funcionaria, igual de lado contrario
            System.out.println("prm1 "+ request.queryParams("Prtemail"));
            System.out.println("prm2 "+ request.queryParams("Prtpassword"));
            System.out.println("prm" + request.body());
            System.out.println("prm" + request.contentType());
            return "algo";
        });
        get("/queryparams", (request, response) -> {
            return "Hello: " + request.queryParams("Prtemail");
        });
    }
}

package mx.uv.basededatos;
import static spark.Spark.*;
import java.util.*;
import com.google.gson.*;
/**
 * Hello world!
 *
 */
public class App {
    private static Gson gson = new Gson();
    private static Map<String,Usuarios> usuarios = new HashMap<>();
    
    public static void main( String[] args )
    {
        before((req,res)->res.type("application/json"));
        get("/usuarios",(req,res)->gson.toJson(usuarios.values() ));
        post("/usuarios",(req,res)->{
            String query = req.body();
            System.out.println("peticion: "+query);
            Usuarios usuario = gson.fromJson(query, Usuarios.class);
            String id = UUID.randomUUID().toString();
            usuario.setId(id);
            usuarios.put(id, usuario);
            return "se creo el usuario con id: " + id;
        });
        System.out.println( "Hello World!" );
    }
}

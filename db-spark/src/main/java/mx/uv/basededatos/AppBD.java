package mx.uv.basededatos;
import static spark.Spark.*;
import java.util.*;
import com.google.gson.*;
public class AppBD {
    private static Gson gson = new Gson();
    public static void main( String[] args ){
        before((req,res)->res.type("application/json"));
        get("/usuarios",(req,res)->gson.toJson(DAO.dameUsuarios() ));
        post("/usuarios",(req,res)->{
            String query = req.body();
            System.out.println("peticion: "+query);
            Usuarios usuario = gson.fromJson(query, Usuarios.class);
            String id = UUID.randomUUID().toString();
            usuario.setId(id);
            return DAO.crearUsuarios(usuario);
        });
    }
}

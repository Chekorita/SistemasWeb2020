package mx.uv.basededatos;

import java.sql.*;
import java.util.*;

public class DAO {
    private static Conexion conexion = new Conexion();
    public static List<Usuarios> dameUsuarios(){
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        List<Usuarios> resultados = new ArrayList<Usuarios>();
        con = conexion.getConnection();
        try{
            String sql = "select * from Usuarios";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Usuarios u = new Usuarios(rs.getString("id"),rs.getString("email"),rs.getString("password"));
                resultados.add(u);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs =null;
            }
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                st = null;
            }
            try {
                con.close();
                System.out.println("conexion cerrada");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultados;
    }
    public static String crearUsuarios(Usuarios u){
        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();
        try{
            String sql = "insert into Usuarios(id,email,password) values (?,?,?)";
            st = con.prepareStatement(sql);
            st.setString(1,u.getId());
            st.setString(2,u.getEmail());
            st.setString(3,u.getPassword());
            if(st.executeUpdate()>0){
                msj = "El usuario fue agregado";
            }else{
                msj = "No se pudo agregar el usuario";
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                st = null;
            }
            try {
                con.close();
                System.out.println("conexion cerrada");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return msj;
    }
    public static String modificarUsuarios(Usuarios u){
        PreparedStatement st = null;
        Connection con = null;
        String msj = "";
        con = conexion.getConnection();
        try{
            String sql = "update Usuarios set email=?, password=? where id=?)";
            st = con.prepareStatement(sql);
            st.setString(3,u.getId());
            st.setString(1,u.getEmail());
            st.setString(2,u.getPassword());
            if(st.executeUpdate()>0){
                msj = "El usuario fue actualizar";
            }else{
                msj = "No se pudo actualizar el usuario";
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                st = null;
            }
            try {
                con.close();
                System.out.println("conexion cerrada");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return msj;
    }
}

package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class DB {
    Connection conexion;
    String cadenaConexion = "jdbc:mysql://localhost/clinica?serverTimezone=UTC";
    String usuario = "root";
    String clave = "";
        public DB() {
        try {
            conexion = DriverManager.getConnection(cadenaConexion,usuario,clave);
            System.out.println("Conectado con exito");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
public void agregarPaciente(Paciente pac){
        try {
            PreparedStatement s = conexion.prepareStatement(" INSERT INTO PACIENTE (dni,nombre,peso,altura,IMC) values (?,?,?,?,?) ");
            s.setInt(1, pac.getDni());
            s.setString(2, pac.getNombre());
            s.setDouble(3, pac.getPeso());
            s.setDouble(4, pac.getAltura());
            s.setDouble(5, pac.getIMC());
            s.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void eliminarPaciente(int dni){
        Statement s;
         try {
            s = conexion.createStatement();
            s.executeUpdate(" DELETE FROM PACIENTE WHERE DNI = " + dni);
       } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public ArrayList<Paciente> obtenerPacientes(){
    
    ArrayList<Paciente> lista = new ArrayList<>();
    try {
        Statement s = conexion.createStatement();
        ResultSet res = s.executeQuery(" SELECT * FROM PACIENTE ORDER BY dni ");
        while(res.next()){
        Paciente p = new Paciente(
                res.getInt("codigo"),
                res.getInt("dni"),
                res.getString("nombre"),
                res.getDouble("peso"),
                res.getDouble("altura"),
                res.getDouble("IMC")
        );
        
        lista.add(p); 
        }
       
        } 
    catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return lista;
}
}

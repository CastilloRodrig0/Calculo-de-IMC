package controlador;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.DB;
import modelo.Paciente;
import vista.VistaPrincipal;
public class ControladorPrincipal {
    public static VistaPrincipal ventana = new VistaPrincipal();
    public static void mostrar(){ ventana.setVisible(true); 
        DB db = new DB();
    ArrayList<Paciente> pacientes = db.obtenerPacientes();
   DefaultTableModel model = (DefaultTableModel) ventana.getjTable1().getModel();
   model.setNumRows(0);
    for (Paciente paciente : pacientes) {
   Object[] fila = new Object[6];
   fila[0] = paciente.getCodigo();
   fila[1] = paciente.getDni();
   fila[2] = paciente.getNombre();
   fila[3] = paciente.getPeso();
   fila[4] = paciente.getAltura();
   fila[5] = paciente.getIMC();
    
    
    model.addRow(fila);
    } }
    public static void ocultar(){ ventana.setVisible(false); }
   
    public static void botonCalcular(){
       double peso = Double.parseDouble(ventana.getjTextField3().getText());
        double altura = Double.parseDouble(ventana.getjTextField4().getText());
        double imc = peso / ((altura/100)*(altura/100)); 

    }
        public static void botoneliminarPaciente(){
  int dni = Integer.parseInt(ventana.getjTextField1().getText());
DB db = new DB();
db.eliminarPaciente(dni);
mostrar();
      }
        public static void botonagregarPaciente(){
            
            int dni = Integer.parseInt(ventana.getjTextField1().getText());
            String nombre = ventana.getjTextField2().getText();
            double peso = Double.parseDouble(ventana.getjTextField3().getText());
            double altura = Double.parseDouble(ventana.getjTextField4().getText());
            double IMC = Double.parseDouble(ventana.getjTextField5().getText());
            
            Paciente p = new Paciente();
            p.setDni(dni);
            p.setNombre(nombre);
            p.setPeso(peso);
            p.setAltura(altura);
            p.setIMC(IMC);
            DB db = new DB();
            db.agregarPaciente(p);
            mostrar();
      }

       
}

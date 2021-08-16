package modelo;

public class Paciente {
    private int codigo;
    private int dni;
    private String nombre;
    private double peso;
    private double altura;
    private double IMC;

    @Override
    public String toString() {
        return "Paciente{" + "codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", peso=" + peso + ", altura=" + altura + ", IMC=" + IMC + '}';
    }

    public Paciente(int codigo, int dni, String nombre, double peso, double altura, double IMC) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.IMC = IMC;
    }

    public Paciente() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

   
}

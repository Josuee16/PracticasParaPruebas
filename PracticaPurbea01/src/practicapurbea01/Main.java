/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicapurbea01;

/**
 *
 * @author VEL-JOSUE
 */
class Empleado {
    protected String nombre;
    protected String apellidos;
    protected String cedula;
    protected String direccion;
    protected int añosAntiguedad;
    protected String telefono;
    protected double salario;

    public Empleado(String nombre, String apellidos, String cedula, String direccion, int añosAntiguedad, String telefono, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.añosAntiguedad = añosAntiguedad;
        this.telefono = telefono;
        this.salario = salario;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellidos);
        System.out.println("Cédula: " + cedula);
        System.out.println("Dirección: " + direccion);
        System.out.println("Años de antigüedad: " + añosAntiguedad);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Salario: " + salario);
    }
}

class Secretario extends Empleado {
    public String despacho;
    public double horasExtras;

    public Secretario(String nombre, String apellidos, String cedula, String direccion, int añosAntiguedad, String telefono, double salario, String despacho, double horasExtras) {
        super(nombre, apellidos, cedula, direccion, añosAntiguedad, telefono, salario);
        this.despacho = despacho;
        this.horasExtras = horasExtras;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Despacho: " + despacho);
        System.out.println("Horas extras: " + horasExtras);
    }
}

class Vendedor extends Empleado {
    public String matriculaCoche;
    public String marcaCoche;
    public String modeloCoche;
    public String telefonoMovil;
    public String areaVenta;
    public double porcentajeVentas;

    public Vendedor(String nombre, String apellidos, String cedula, String direccion, int añosAntiguedad, String telefono, double salario, String matriculaCoche, String marcaCoche, String modeloCoche, String telefonoMovil, String areaVenta, double porcentajeVentas) {
        super(nombre, apellidos, cedula, direccion, añosAntiguedad, telefono, salario);
        this.matriculaCoche = matriculaCoche;
        this.marcaCoche = marcaCoche;
        this.modeloCoche = modeloCoche;
        this.telefonoMovil = telefonoMovil;
        this.areaVenta = areaVenta;
        this.porcentajeVentas = porcentajeVentas;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Matrícula del coche: " + matriculaCoche);
        System.out.println("Marca del coche: " + marcaCoche);
        System.out.println("Modelo del coche: " + modeloCoche);
        System.out.println("Teléfono móvil: " + telefonoMovil);
        System.out.println("Área de venta: " + areaVenta);
        System.out.println("Porcentaje de ventas: " + porcentajeVentas);
    }
}

class JefeDeZona extends Empleado {
    public Secretario secretario;
    public Vendedor[] vendedores;
    public double porcentajeGlobalVentas;

    public JefeDeZona(String nombre, String apellidos, String cedula, String direccion, int añosAntiguedad, String telefono, double salario, Secretario secretario, Vendedor[] vendedores, double porcentajeGlobalVentas) {
        super(nombre, apellidos, cedula, direccion, añosAntiguedad, telefono, salario);
        this.secretario = secretario;
        this.vendedores = vendedores;
        this.porcentajeGlobalVentas = porcentajeGlobalVentas;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Secretario: ");
        secretario.mostrarInformacion();
        System.out.println("Vendedores: ");
        for (Vendedor vendedor : vendedores) {
            vendedor.mostrarInformacion();
        }
        System.out.println("Porcentaje global de ventas: " + porcentajeGlobalVentas);
    }
}

public class Main {
    public static void main(String[] args) {
        Secretario secretario = new Secretario("Ana", "Perez", "12345678", "Calle Falsa 123", 5, "123456789", 30000, "Despacho 1", 10);

        Vendedor[] vendedores = new Vendedor[2];
        vendedores[0] = new Vendedor("Luis", "Gomez", "87654321", "Avenida Siempre Viva 456", 3, "987654321", 25000, "ABC123", "Toyota", "Corolla", "1122334455", "Zona Norte", 0.05);
        vendedores[1] = new Vendedor("Marta", "Lopez", "56781234", "Calle Luna 789", 4, "5544332211", 26000, "DEF456", "Honda", "Civic", "6677889900", "Zona Sur", 0.06);

        JefeDeZona jefe = new JefeDeZona("Carlos", "Fernandez", "34567812", "Paseo del Prado 321", 10, "1122334455", 50000, secretario, vendedores, 0.10);

        Empleado[] empleados = {secretario, vendedores[0], vendedores[1], jefe};

        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            System.out.println("-----------------------------");
        }
    }
}

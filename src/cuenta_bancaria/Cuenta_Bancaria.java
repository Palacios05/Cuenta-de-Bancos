import java.util.Scanner;

public class Cuenta_Bancaria {

    private String nombre_titular;
    private String apellido_titular;
    private int numero_cuenta = 0;
    private String tipo_cuenta;
    private double saldo_cuenta;

    public enum tipoCuenta{
        AHORROS, CORRIENTE
    }

    public Cuenta_Bancaria(String nombre_titular, String apellido_titular, int numero_cuenta, String tipo_cuenta, double saldo_cuenta){
        this.nombre_titular = nombre_titular;
        this.apellido_titular = apellido_titular;
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo_cuenta = saldo_cuenta;
    }

    public String getNombreTitular() {
        return nombre_titular;
    }

    public void setNombreTitular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }

    public String getApellidoTitular() {
        return apellido_titular;
    }

    public void setApellidoTitular(String apellido_titular) {
        this.apellido_titular = apellido_titular;
    }

    public int getNumeroCuenta() {
        return numero_cuenta;
    }

    public void setNumeroCuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getTipoCuenta() {
        return tipo_cuenta;
    }

    public void setTipoCuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public double getSaldoCuenta() {
        return saldo_cuenta;
    }

    public void setSaldoCuenta(double saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    public void imprimir(){

        System.out.println("Nombre del titular: " + nombre_titular);
        System.out.println("Apellido del titular" + apellido_titular);
        System.out.println("Numero cuenta: " + numero_cuenta);
        System.out.println("Tipo de cuenta: " + tipo_cuenta);
        System.out.println("Saldo: " + saldo_cuenta);
    }

    public static void main(String[] args) {
        Scanner cuenta = new Scanner(System.in);

        Cuenta_Bancaria[] cuentas = new Cuenta_Bancaria[4];

        cuentas[0] = new Cuenta_Bancaria("Juan Jose", "Palacios Giraldo", 12345, "AHORROS", 1000000);
        cuentas[1] = new Cuenta_Bancaria("María", "González López", 123456, "CORRIENTE", 500000);
        cuentas[2] = new Cuenta_Bancaria("Carlos", "Pérez García", 1234567, "AHORROS", 750000);
        cuentas[3] = new Cuenta_Bancaria("Ana", "Martínez Rodríguez", 12345678, "CORRIENTE", 300000);
        

        int opcion;

        do{
            System.out.println("Seleccione la operacion que desea realizar \n 1. Consultar saldo \n 2. Consignar \n 3. Retirar \n 4. Salir");
            opcion = cuenta.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese su numero de cuenta");
                    int numero_consulta = cuenta.nextInt();
                    boolean cuenta_encontrada = false;

                    for(int i = 0; i < cuentas.length; i++){

                        if(cuentas[i].getNumeroCuenta() == numero_consulta){
                            System.out.println("El saldo de la cuenta de " + cuentas[i].getNombreTitular() + " es de: " + cuentas[i].getSaldoCuenta() + "\n");
                            cuenta_encontrada = true;
                            break;
                        }
                    }

                    if(!cuenta_encontrada){
                        System.out.println("El numero de cuenta ingresado no corresponde a ninguna cuenta registrada" + "\n");
                    }

                    break;
            
                case 2:

                    System.out.println("Ingrese el numero de cuenta a consignar");    
                    int numero_consignar = cuenta.nextInt();

                    System.out.println("Ingrese el monto a consginar");
                    double monto_consignar = cuenta.nextDouble();

                    boolean cuenta_encontrada_consignar = false;

                    for(int i = 0; i < cuentas.length; i++){
                        if(cuentas[i].getNumeroCuenta() == numero_consignar){

                            cuentas[i].setSaldoCuenta(cuentas[i].getSaldoCuenta() + monto_consignar);
                            System.out.println("¡CONSIGNACIÓN EXITOSA!" + "\n");

                            cuenta_encontrada_consignar = true;
                            break;
                        }
                    }

                    if(!cuenta_encontrada_consignar){
                        System.out.println("El numero de cuenta ingresado no corresponde a ninguna cuenta registrada" + "\n");
                    }


                    break;
    
                case 3:
                    
                    System.out.println("Ingrese el numero de cuenta para retirar");
                    int numero_retirar = cuenta.nextInt();

                    System.out.println("Ingrese el monto a retirar");
                    int monto_retirar = cuenta.nextInt();

                    boolean cuenta_encontrada_retirar = false;

                    for(int i = 0; i < cuentas.length; i++){

                        if(cuentas[i].getNumeroCuenta() == numero_retirar){
                            
                            if(cuentas[i].getSaldoCuenta() >= monto_retirar && monto_retirar > 0 && (cuentas[i].getSaldoCuenta()) - monto_retirar >= 0){
                                
                                cuentas[i].setSaldoCuenta(cuentas[i].getSaldoCuenta() - monto_retirar);

                                System.out.println("¡Retiro exitoso!" + "\n");

                            }else{
                                System.out.println("El monto a retirar no es valido. Asegúrate de ingresar un numero positivo y que no exceda tu saldo disponible" + "\n");
                            }

                            cuenta_encontrada_retirar = true;

                            break;
                        }
                    }
                    if(!cuenta_encontrada_retirar){
                        System.out.println("El numero de cuenta ingresado no corresponde a ninguna cuenta registada" + "\n");
                    }
                
                    break;
                
                case 4:
                System.out.println("¡Hasta la proxima!");
    
                default:
                    System.out.println("El numero ingresado es incorrecto" + "\n");
            }
        }while(opcion != 4);
        
    }
    
}

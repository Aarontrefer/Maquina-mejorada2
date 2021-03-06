public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // billetes vendidos
    private int billetesVendidos;
    // tipo de maquina
    private boolean tipoMaquina;
    // numero maximo de billetes
    private int maximoDeBilletes;
    // cuenta de billetes con premio
    private int billetesConPremio;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean tipo, int maximo) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0; 
        tipoMaquina = tipo;
        maximoDeBilletes = maximo;
        billetesConPremio = 0;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (maximoDeBilletes > billetesVendidos){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            } 
        }
        else {
           System.out.println("No es posible intoducir dinero en la maquina ya se ha llegado al limite"); 
        }
    }
        
    
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDelDineroQueFalta = precioBillete - balanceClienteActual;
        if (maximoDeBilletes > billetesVendidos) {
            if ( cantidadDelDineroQueFalta <= 0) { 
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();
                
                 if ( tipoMaquina ==true){
                     billetesConPremio += 1;
                     if ( billetesConPremio ==3) { 
                     System.out.println("Tienes un " + ( precioBillete *0.1 ) + " euros de descuento en alimerka en tu proxima compra");
                     billetesConPremio = 0;
                    }
                    
                }
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                billetesVendidos += 1;
            }
            else {
                System.out.println("Necesitas introducir " + (cantidadDelDineroQueFalta) + " euros mas!");
                
            }   
        }
        else {
            System.out.println("No se puede imprimir mas ha llegado al limite ");
        }
    }
    
    public int numeroBilletesVendidos(){
         return billetesVendidos;
    }
    
    public void imprimeNumeroBilletesVendidos () {
        System.out.println("Has imprimido " + (billetesVendidos) +  " billtes");
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 

    public int vaciarDineroDeLaMaquina () {
        int cantidadDeDineroAVaciar;
            cantidadDeDineroAVaciar = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual == 0) {
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else {
            cantidadDeDineroAVaciar = -1;
            System.out.println("la maquina tiene una operacion en curso ");
        }
        return cantidadDeDineroAVaciar;
    }
}

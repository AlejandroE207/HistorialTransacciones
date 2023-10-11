/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vista;
import javax.swing.JOptionPane;
import modelo.*;
public class ActividadPila {

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();
        int opc=0;
        double monto;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("\tMENU\t\n1. Depositar\n2. Retirar\n"+
                    "3. Deshacer ultima transacción\n4. Consultar saldo\n5. Historial.\n6. Salir"));
            switch(opc){
                case 1:
                    monto = Double.parseDouble(JOptionPane.showInputDialog("Digite el monto a depositar: "));
                    cuenta.depositar(monto);
                    break;
                    
                case 2:
                    monto = Double.parseDouble(JOptionPane.showInputDialog("Digite el monto a retirar: "));
                    cuenta.retirar(monto);
                    break;
                    
                case 3:
                    cuenta.deshacerTransaccion();
                    break;
                    
                case 4:
                    cuenta.consultarSaldo();
                    break;
                    
                case 5:
                    cuenta.historial();
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Digite una opción valida!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }while(opc!=6);
    }
}

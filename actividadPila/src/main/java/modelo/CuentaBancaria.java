/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Stack;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public class CuentaBancaria {
    private double saldo;
    private Stack<Double> transacciones;

    public CuentaBancaria() {
        this.saldo = 0;
        this.transacciones = new Stack<>();
    }
    public void depositar(double monto){
        this.saldo+= monto;
        transacciones.push(monto);
    }
    public void retirar (double monto){
        if(transacciones.isEmpty()==false){
            if(saldo>=monto){
                saldo-=monto;
                transacciones.push(-monto);
                JOptionPane.showMessageDialog(null, "Ha retirado un monto de: "+monto+"\n"+
                        "Su nuevo saldo es de: "+saldo, "ACTUALIZACIÓN", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Saldo insuficiente para el retiro!\nSu saldo es de: "+saldo, "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para el retiro!\nSu saldo es de: "+saldo, "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deshacerTransaccion(){
        if(!transacciones.isEmpty()){
            double ultima=transacciones.pop();
            saldo-=ultima;
            JOptionPane.showMessageDialog(null, "Su saldo actual es: "+saldo, "ANULACIÓN COMPLETA", JOptionPane.OK_CANCEL_OPTION);
        }
    }
    
    public void consultarSaldo(){
        JOptionPane.showMessageDialog(null, "Su saldo actual es: "+saldo, "SALDO", JOptionPane.OK_CANCEL_OPTION);
    }
    
    public void historial() {
    String cadena = "";
    Stack<Double> aux = new Stack<>();
    aux.addAll(transacciones); // Copia las transacciones a aux en orden inverso
    while (!aux.isEmpty()) {
        String movimiento = "" + aux.pop();
        cadena += "* " + movimiento + "\n";
    }
    JOptionPane.showMessageDialog(null, cadena, "HISTORIAL", JOptionPane.INFORMATION_MESSAGE);
}    
}

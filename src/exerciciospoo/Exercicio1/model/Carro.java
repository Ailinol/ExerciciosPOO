/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciospoo.Exercicio1.model;

/**
 *
 * @author liliano
 */
public class Carro extends Veiculo {

    public Carro(String tipo, String marca, String cor, String modelo, int ano) {
        super(tipo, marca, cor, modelo, ano);
    }
    
    
    public void mover() {
        System.out.println("O carro esta se movendo....");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciospoo.exercicio6.model;

/**
 *
 * @author liliano
 */
public class contaPoupanca implements Conta{
    private String Nome;
    private double saldo;
    private double taxa;

    public contaPoupanca(String Nome, double saldo, double taxa) {
        this.Nome = Nome;
        this.saldo = saldo;
        this.taxa = taxa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    @Override
    public double calcularTaxa() {
        return saldo * taxa;
    }
    
    
    
}

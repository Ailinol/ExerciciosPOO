/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciospoo.exercicio6.model;

/**
 *
 * @author liliano
 */
public class ContaCorrente implements Conta {
   private String nome;
   private double taxaFixa;
   private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ContaCorrente(String nome, double taxaFixa, double saldo) {
        this.nome = nome;
        this.taxaFixa = taxaFixa;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTaxaFixa() {
        return taxaFixa;
    }

    public void setTaxaFixa(double taxaFixa) {
        this.taxaFixa = taxaFixa;
    }

    @Override
    public double calcularTaxa() {
        return taxaFixa;
    }
   
   
}

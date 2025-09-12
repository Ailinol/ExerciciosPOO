/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciospoo.exercicio5.model;

/**
 *
 * @author liliano
 */
public class Funcionario implements Pagavel {
    private double salarioFixo;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public Funcionario(double salarioFixo, String nome) {
        this.salarioFixo = salarioFixo;
        this.nome = nome;
    }

    @Override
    public double calcularSalario() {
       return salarioFixo;
    }
}

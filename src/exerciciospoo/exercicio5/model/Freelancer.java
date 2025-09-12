/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciospoo.exercicio5.model;

/**
 *
 * @author liliano
 */
public class Freelancer implements Pagavel {
    private String nome;
    private double horasTrabalhadas;
    private double salarioHora;

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * salarioHora;
    }

    public Freelancer(double horasTrabalhadas, double salarioHora, String nome) {
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioHora = salarioHora;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ailinol
 */
public class Professor extends Pessoa{
    private String disciplina;
    private double salario;

    public Professor(int id, String nome, int idade, String genero, String telefone, String email) {
        super(id, nome, idade, genero, telefone, email);
    }

    public Professor(String disciplina, double salario, int id, String nome, int idade, String genero, String telefone, String email) {
        super(id, nome, idade, genero, telefone, email);
        this.disciplina = disciplina;
        this.salario = salario;
    }
    

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

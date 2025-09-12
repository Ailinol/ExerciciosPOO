/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciospoo.exercicio3.model;

/**
 *
 * @author liliano
 */
public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.setNome(nome);
        this.setIdade(idade);
        this.matricula = matricula;
    }
    
    
    @Override
    public String toString(){
        return "Nome: " + getNome() + " Idade: " + getIdade() + " Matricula: " + matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
    
    
}

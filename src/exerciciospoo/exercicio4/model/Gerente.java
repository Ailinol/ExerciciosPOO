/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciospoo.exercicio4.model;

import exerciciospoo.exercicio4.model.Funcionario;

/**
 *
 * @author liliano
 */
public class Gerente extends Funcionario{
    
    public Gerente(String nome, double salario) {
        super(nome, salario);
    }
    
    public void aumentarSalario(double percentual){
        this.salario = this.salario * percentual / 100;
    }
    
}

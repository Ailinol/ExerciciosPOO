/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ailinol
 */
public class Aluno extends Pessoa implements Serializable{
    private String matricula;
    private String curso;
    private String tipoAluno;
    private double mensalidadeBase;
    private double mensalidadeValor;
    

    public Aluno() {
        super(0, null, 0, null, null, null);
    }

    public double getMensalidadeBase() {
        return mensalidadeBase;
    }

    public void setMensalidadeBase(double mensalidadeBase) {
        this.mensalidadeBase = mensalidadeBase;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
    private ArrayList<Integer> mensalidades;
    private double nota1;
    private double nota2;
    private double media;

    public Aluno(int id, String nome, int idade, String genero, String telefone, String email) {
        super(id, nome, idade, genero, telefone, email);
    }

    public Aluno(int id, String matricula, String curso, String tipoAluno, String nome, int idade, String genero, String telefone, String email) {
        super(id, nome, idade, genero, telefone, email);
        this.matricula = matricula;
        this.curso = curso;
        this.tipoAluno = tipoAluno;
        this.mensalidadeValor = 0.0;
        this.mensalidades = null;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTipoAluno() {
        return tipoAluno;
    }

    public void setTipoAluno(String tipoAluno) {
        this.tipoAluno = tipoAluno;
    }

    public double getMensalidadeValor() {
        return mensalidadeValor;
    }

    public void setMensalidadeValor(double mensalidadeValor) {
        this.mensalidadeValor = mensalidadeValor;
    }

    public ArrayList<Integer> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(ArrayList<Integer> mensalidades) {
        this.mensalidades = mensalidades;
    }
    
    //Metoodos para saber a dispensa com base na nota
    
    public String VerificarDispensa(int id){
    
    if(tipoAluno.equalsIgnoreCase("Bolseiro")){
        if(media>=16){
            mensalidadeValor = 0;
            return "Estudante dispensado e nao pagara a matricula";
        }else{
            mensalidadeValor = mensalidadeBase / 2;
            return "Estudante nao Dispensado";
        }
    } 
    else if(tipoAluno.equalsIgnoreCase("Nao-Bolseiro")){
        if(media >= 14){
            mensalidadeValor = mensalidadeBase;
            return "Estudante dispensado, mas paga a matricula";
        }else{
            mensalidadeValor = mensalidadeBase; 
            return "Estudante Nao dispensado";
        }
    }else{
        mensalidadeValor = mensalidadeBase;
        return "Tipo de estudante nao encontrado";
    }
}
    
    
}

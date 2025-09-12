/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciospoo.Exercicio1.model;

import java.io.Serializable;

/**
 *
 * @author liliano
 */
public abstract class Veiculo implements Serializable{
    private String tipo;
    private String marca;
    private String cor;
    private String modelo;
    private int ano;

    public Veiculo(String tipo, String marca, String cor, String modelo, int ano) {
        this.tipo = tipo;
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
    
    public abstract void mover();
}

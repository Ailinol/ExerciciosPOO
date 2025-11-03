/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Dao.Ficheiro;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import view.CadastroAlunos;

/**
 *
 * @author liliano
 */
public class GestaoAlunos {
    ArrayList<Aluno> lista = new ArrayList<>();
    CadastroAlunos cadastro;
    Ficheiro file = new Ficheiro();
    
    public GestaoAlunos(CadastroAlunos cadastro){
        this.cadastro = cadastro;
        carregarDados();
        ActualizarTabela();
    }
    
    
    public void salvar(){
        String nome = cadastro.getCampoNome().getText();
        int idade = Integer.parseInt(cadastro.getCampoIdade().getText());
        String genero = (String) cadastro.getComboGenero().getSelectedItem();
        String telefone = cadastro.getCampoTelefone().getText();
        String email = cadastro.getCampoEmail().getText();
        String curso = cadastro.getCampoLista().getSelectedValue();
        String bolsa = (String) cadastro.getComboBolsa().getSelectedItem();
        
        Aluno alunos = new Aluno(0, null, curso, bolsa,nome, idade,genero, telefone, email);
        lista.add(alunos);
        
        try{
            file.gravar(lista, "Alunos.dat");
            ActualizarTabela();
            JOptionPane.showMessageDialog(cadastro, "Alunos salvo com sucesso!");
        }catch(Exception e){
            System.out.println("Erro " + e);
        }
        
        cadastro.getCampoNome().setText("");
        cadastro.getCampoIdade().setText("");
        cadastro.getCampoTelefone().setText("");
        cadastro.getCampoEmail().setText("");
    }
    
    public void carregar(){
        int linhaSelecionada = cadastro.getTabela().getSelectedRow();
        
        if(linhaSelecionada == -1){
            JOptionPane.showMessageDialog(cadastro, "Linha invalida");
            return;
        }
        
        Aluno aluno = lista.get(linhaSelecionada);
        
        cadastro.getCampoNome().setText(aluno.getNome());
        cadastro.getCampoIdade().setText(String.valueOf(aluno.getIdade()));
        cadastro.getComboGenero().setSelectedItem(aluno.getGenero());
        cadastro.getCampoTelefone().setText(aluno.getTelefone());
        cadastro.getCampoEmail().setText(aluno.getEmail());
        cadastro.getComboBolsa().setSelectedItem(aluno.getTipoAluno());
        
        file.gravar(lista, "Alunos.dat");
        ActualizarTabela();
        
        JOptionPane.showMessageDialog(cadastro, "Dados editados com sucesso!");
    }
    
    public void actualizarDados(){
        int linhaSelecionada = cadastro.getTabela().getSelectedRow();
        
        if(linhaSelecionada == -1){
            JOptionPane.showMessageDialog(cadastro, "Linha invalida");
            return;
        }
        
        String nome = cadastro.getCampoNome().getText();
        int idade = Integer.parseInt(cadastro.getCampoIdade().getText());
        String genero = (String) cadastro.getComboGenero().getSelectedItem();
        String telefone = cadastro.getCampoTelefone().getText();
        String email = cadastro.getCampoEmail().getText();
        String curso = cadastro.getCampoLista().getSelectedValue();
        String bolsa = (String) cadastro.getComboBolsa().getSelectedItem();
        
        Aluno aluno = lista.get(linhaSelecionada);
        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setGenero(genero);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
        aluno.setCurso(curso);
        aluno.setTipoAluno(bolsa);
    }
    
    public void ActualizarTabela(){
        DefaultTableModel modelo = (DefaultTableModel) cadastro.getTabela().getModel();
        modelo.setRowCount(0);
        
        for(Aluno aluno : lista){
            Object[] linha = {
              aluno.getNome(),
              aluno.getIdade(),
              aluno.getTipoAluno(),
              aluno.getCurso(),
              aluno.getMedia()
              
            };
            modelo.addRow(linha);
        }
    }
    
    public void carregarDados(){
        try{
            Object dados = file.carregar("Alunos.dat");
            if(dados instanceof ArrayList){
                lista = (ArrayList<Aluno>) dados;
                System.out.println("Carregados " + lista.size() + " Alunos");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
    
    public void salvarNota(){
        int linha = cadastro.getTabela().getSelectedRow();
        double nota = Double.parseDouble(cadastro.getCampoNotaFinal().getText());
                ;
        
        if(linha == -1) {
            JOptionPane.showMessageDialog(cadastro, "Linha invalida");
        }
        
        Aluno aluno = lista.get(linha);
        
        aluno.setMedia(nota);
        
        
        double mensalidade = 20000;
        System.out.println("mensaldade" + mensalidade);
        if(aluno.getTipoAluno().equalsIgnoreCase("Bolseiro")){
            if(nota >= 16){
                mensalidade = 0;
            }else{
                mensalidade = mensalidade/2;
            }
            aluno.setMensalidadeValor(mensalidade);
            
        }else if(aluno.getTipoAluno().equalsIgnoreCase("Nao bolseiro")){
           aluno.setMensalidadeValor(mensalidade);
        }else{
            System.out.println("Invalido");
        }
        
        try{
           file.gravar(lista, "Alunos.dat");
           ActualizarTabela();
           JOptionPane.showMessageDialog(cadastro, "Curso: " + aluno.getCurso() + "\n Nota: " + nota + "\nMensalidade: " + aluno.getMensalidadeValor());
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Dao.Ficheiro;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Professor;
import view.TelaGestaoProfessores;

/**
 *
 * @author liliano
 */
public class CadastroProfessor {
    TelaGestaoProfessores gestao;
    ArrayList<Professor> lista = new ArrayList<>();
    Ficheiro ficheiro = new Ficheiro();
    
    public CadastroProfessor(TelaGestaoProfessores gestao) {
        this.gestao = gestao;
        carregarDados();
        actualizarTabela();
    }
    
    public void salvarProfessores(){
        String nome = gestao.getCampoNome().getText();
        int idade = Integer.parseInt(gestao.getCampoIdade().getText());
        String genero = (String) gestao.getComboGenero().getSelectedItem();
        String telefone = gestao.getCompoTelefone().getText();
        String email = gestao.getCompoEmail().getText();
        String disciplina = gestao.getCampoDisciplina().getText();
        double salario = Double.parseDouble(gestao.getCampoSalario().getText());
        
        Professor professor = new Professor(disciplina, salario, 1, nome, idade, genero, telefone, email); 
        lista.add(professor);
        
        try{
            ficheiro.gravar(lista, "Professores.dat");
            actualizarTabela();
            JOptionPane.showMessageDialog(gestao, "Salvo com sucesso");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
        
        gestao.getCampoDisciplina().setText("");
        gestao.getCampoIdade().setText("");
        gestao.getCompoTelefone().setText("");
        gestao.getCompoEmail().setText("");
        gestao.getCampoDisciplina().setText("");
        gestao.getCampoSalario().setText("");
        
    }
    
   public void actualizarTabela(){
    DefaultTableModel modelo = (DefaultTableModel) gestao.getTabelaProfessores().getModel();
    modelo.setRowCount(0);
    
    for(Professor professor : lista){
        Object[] linha = {
            //professor.getId(),
            professor.getNome(),
            professor.getIdade(),
            professor.getGenero(),
            professor.getTelefone(),
            //professor.getEmail(),
            professor.getDisciplina(),
            professor.getSalario()
        };
        modelo.addRow(linha);
    }
}
    
    public void editar(){
        int linhaSelecionada = gestao.getTabelaProfessores().getSelectedRow();
        
        if(linhaSelecionada == -1){
            JOptionPane.showMessageDialog(gestao, "Linha invalida");
            return;
        }
        
        String nome = gestao.getCampoNome().getText();
        int idade = Integer.parseInt(gestao.getCampoIdade().getText());
        String genero = (String) gestao.getComboGenero().getSelectedItem();
        String telefone = gestao.getCompoTelefone().getText();
        String email = gestao.getCompoEmail().getText();
        String disciplina = gestao.getCampoDisciplina().getText();
        double salario = Double.parseDouble(gestao.getCampoSalario().getText());
        
        Professor professor = lista.get(linhaSelecionada);
        professor.setNome(nome);
        professor.setIdade(idade);
        professor.setGenero(genero);
        professor.setTelefone(telefone);
        professor.setEmail(email);
        professor.setDisciplina(disciplina);
        professor.setSalario(salario);
        
        ficheiro.gravar(lista, "Professores.dat");
        actualizarTabela();
        
        JOptionPane.showMessageDialog(gestao, "Editado com sucesso!");
        
    }
    
    public void carregarEdicao(){
        int linhaSelecionada = gestao.getTabelaProfessores().getSelectedRow();
        
        if(linhaSelecionada == -1){
            JOptionPane.showMessageDialog(gestao, "Linha invalida");
            return;
        }
        
        Professor professor = lista.get(linhaSelecionada);
        
        gestao.getCampoNome().setText(professor.getNome());
        gestao.getCampoIdade().setText(String.valueOf(professor.getIdade()));
        gestao.getComboGenero().setSelectedItem(professor.getGenero());
        gestao.getCompoTelefone().setText(professor.getTelefone());
        gestao.getCompoEmail().setText(professor.getEmail());
        gestao.getCampoDisciplina().setText(professor.getDisciplina());
        gestao.getCampoSalario().setText(String.valueOf(professor.getSalario()));
    }
    
    public void eliminar(){
        int linhaSelecionada = gestao.getTabelaProfessores().getSelectedRow();
        
        if(linhaSelecionada == -1){
            JOptionPane.showMessageDialog(gestao, "Linha invalida");
            return;
        }
        
        Professor professor = lista.get(linhaSelecionada);
        lista.remove(professor);
        
        ficheiro.gravar(lista, "Professores.dat");
        actualizarTabela();
    }
    
    public void carregarDados(){
        try{
            Object dados = ficheiro.carregar("Professores.dat");
            if(dados instanceof ArrayList){
                lista = (ArrayList<Professor>) dados;
                System.out.println("Carregados " + lista.size() + " professores");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
    
}

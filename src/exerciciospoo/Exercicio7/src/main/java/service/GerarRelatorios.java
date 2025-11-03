package service;

import Dao.Ficheiro;
import java.util.ArrayList;
import model.Aluno;
import model.Professor;
import view.Relatorios;

public class GerarRelatorios {
    private Ficheiro file = new Ficheiro();
    private ArrayList<Aluno> listaAlunos;
    private ArrayList<Professor> listaProfessores;
    private Relatorios relatorio;
    
    public GerarRelatorios(Relatorios relatorio) {
        this.relatorio = relatorio;
        this.listaAlunos = file.carregar("Alunos.dat");
        this.listaProfessores = file.carregar("Professores.dat");
    }
    
    public void relatorioAlunos() {
        if (listaAlunos == null || listaAlunos.isEmpty()) {
            relatorio.getAreaRelatorios().setText("Nenhum aluno encontrado.");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE ALUNOS ===\n\n");
        for (Aluno aluno : listaAlunos) {
            sb.append("Nome: ").append(aluno.getNome()).append("\n");
            sb.append("Curso: ").append(aluno.getCurso()).append("\n");
            sb.append("Nota: ").append(aluno.getMedia()).append("\n");
            sb.append("Mensalidade: ").append(aluno.getMensalidadeValor()).append("\n");
            sb.append("------------------------\n");
        }
        relatorio.getAreaRelatorios().setText(sb.toString());
    }
    
    public void relatorioProfessores() {
        if (listaProfessores == null || listaProfessores.isEmpty()) {
            relatorio.getAreaRelatorios().setText("Nenhum professor encontrado.");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE PROFESSORES ===\n\n");
        for (Professor professor : listaProfessores) {
            sb.append("Nome: ").append(professor.getNome()).append("\n");
            sb.append("ID: ").append(professor.getId()).append("\n");
            sb.append("Idade: ").append(professor.getIdade()).append("\n");
            sb.append("Gênero: ").append(professor.getGenero()).append("\n");
            sb.append("Disciplina: ").append(professor.getDisciplina()).append("\n");
            sb.append("Salário: ").append(String.format("%.2f", professor.getSalario())).append("\n");
            sb.append("Telefone: ").append(professor.getTelefone()).append("\n");
            sb.append("Email: ").append(professor.getEmail()).append("\n");
            sb.append("------------------------\n");
        }
        relatorio.getAreaRelatorios().setText(sb.toString());
    }
    
    public void relatorioCompleto() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("=== RELATÓRIO COMPLETO ===\n\n");
        
        sb.append("PROFESSORES:\n");
        if (listaProfessores == null || listaProfessores.isEmpty()) {
            sb.append("Nenhum professor encontrado.\n");
        } else {
            for (Professor professor : listaProfessores) {
                sb.append("• ").append(professor.getNome())
                  .append(" - ").append(professor.getDisciplina())
                  .append(" - Salario:  ").append(String.format("%.2f", professor.getSalario()))
                  .append("\n");
            }
        }
        
        sb.append("\nALUNOS:\n");
        if (listaAlunos == null || listaAlunos.isEmpty()) {
            sb.append("Nenhum aluno encontrado.\n");
        } else {
            for (Aluno aluno : listaAlunos) {
                sb.append("• ").append(aluno.getNome())
                  .append(" - ").append(aluno.getCurso())
                  .append(" - Media: ").append(aluno.getMedia())
                  .append("\n");
            }
        }
        
        sb.append("\n=== ESTATÍSTICAS ===\n");
        sb.append("Total de professores: ").append(listaProfessores != null ? listaProfessores.size() : 0).append("\n");
        sb.append("Total de alunos: ").append(listaAlunos != null ? listaAlunos.size() : 0).append("\n");
        
        relatorio.getAreaRelatorios().setText(sb.toString());
    }
}
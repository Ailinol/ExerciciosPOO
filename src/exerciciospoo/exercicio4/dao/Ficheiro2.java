package exerciciospoo.exercicio4.dao;

import exerciciospoo.exercicio4.model.Funcionario;
import java.io.*;
import java.util.ArrayList;

public class Ficheiro2 {

    // Salvar lista de veículos
    public static void gravar(String caminho, ArrayList<Funcionario> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao gravar no ficheiro: " + e.getMessage());
        }
    }

    // Ler lista de veículos
    public static ArrayList<Funcionario> ler(String caminho) {
        ArrayList<Funcionario> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            lista = (ArrayList<Funcionario>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando lista vazia.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
        return lista;
    }
}

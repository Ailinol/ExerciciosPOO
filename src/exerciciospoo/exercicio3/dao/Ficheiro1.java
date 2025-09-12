package exerciciospoo.exercicio3.dao;

import exerciciospoo.exercicio3.model.Pessoa;
import java.io.*;
import java.util.ArrayList;

public class Ficheiro1 {

    // Salvar lista de veículos
    public static void gravar(String caminho, ArrayList<Pessoa> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao gravar no ficheiro: " + e.getMessage());
        }
    }

    // Ler lista de veículos
    public static ArrayList<Pessoa> ler(String caminho) {
        ArrayList<Pessoa> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            lista = (ArrayList<Pessoa>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando lista vazia.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
        return lista;
    }
}

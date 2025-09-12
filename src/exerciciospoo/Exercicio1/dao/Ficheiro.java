package exerciciospoo.Exercicio1.dao;

import exerciciospoo.Exercicio1.model.Veiculo;
import java.io.*;
import java.util.ArrayList;

public class Ficheiro {

    // Salvar lista de veículos
    public static void gravar(String caminho, ArrayList<Veiculo> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao gravar no ficheiro: " + e.getMessage());
        }
    }

    // Ler lista de veículos
    public static ArrayList<Veiculo> ler(String caminho) {
        ArrayList<Veiculo> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            lista = (ArrayList<Veiculo>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando lista vazia.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
        return lista;
    }
}

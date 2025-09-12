/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciospoo.exercicio6.dao;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ficheiro6 {

    // Grava uma ArrayList em arquivo
    public static void gravar(ArrayList<?> lista, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(lista);
            System.out.println("ArrayList gravada em arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao gravar em arquivo: " + e);
        }

    }

    // Carrega uma ArrayList de um arquivo
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> carregar(String nomeArquivo) {
        // Verifica se o arquivo existe
        if (!new java.io.File(nomeArquivo).exists()) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
            return new ArrayList<T>();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            ArrayList<T> lista = (ArrayList<T>) inputStream.readObject();
            System.out.println("ArrayList carregada do arquivo: " + nomeArquivo);
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar do arquivo: " + e);
            return new ArrayList<T>();
        }
    }
}
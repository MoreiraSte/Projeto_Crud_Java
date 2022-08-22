
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void alterar(String[] nomeProd, double[][] codVal, int indiceVazio) throws IOException {

        // ALTERAR O CAMINHO DE ACORDE ONDE O ARQUIVO TXT ESTA
        Path path = Paths.get("G:/SENAI/1°semestre/FPOOprograms/Java/Java_Project_StephanyMoreira/produtosCadastrados.txt");
        List<String> linhas = Files.readAllLines(path);

        linhas.remove(2);

        String novoConteudo = JOptionPane.showInputDialog(null,"Escreva a nova quantidade do produto: ");

         String conteudo =
                linhas.get(2).substring(2)+ novoConteudo ;

        linhas.add(2, "Quantidade: " + novoConteudo);

        Files.write(path, linhas);
    }
    static void remover(){
        File file = new File( "produtosCadastrados.txt" );
        file.delete();
    }


    static int procCod(String nomeProd[], double codVal[][], int indiceVazio, double buscaCod) {
        int i=0;

        while ((i<indiceVazio)&&(buscaCod!=codVal[1][i])) {
            i++;
        }
        if (buscaCod!=codVal[1][i]) {
            return -1;
        }
        else {
            return i;
        }
    }
    static int procNome(String nomeProd[], double codVal[][], int indiceVazio, String buscaNome) {
        int i=0;

        while ((i<indiceVazio)&&(!(buscaNome.equalsIgnoreCase(nomeProd[i])))) {
            i++;
        }
        if (!(buscaNome.equalsIgnoreCase(nomeProd[i]))) {
            return -1;
        }
        else {
            return i;
        }
    }
    static void execCad(String nomeProd[], double codVal[][], int indice, double cod, String nome,
                        double prCusto, double valVenda) {
        double lucrUn;

        lucrUn = valVenda - prCusto;
        nomeProd[indice] = nome;
        codVal[1][indice] = cod;
        codVal[5][indice] = prCusto;
        codVal[6][indice] = valVenda;
        codVal[7][indice] = lucrUn;
    }

    //Mostra todos as informações cadastradas no sistema
    static void mostraTodos(String nomeProd[], double codVal[][], int indiceVazio) throws IOException {
        int i=0;

        // ALTERAR O CAMINHO DE ACORDE ONDE O ARQUIVO TXT ESTA
        File archivo = new File("G:/SENAI/1°semestre/FPOOprograms/Java/Java_Project_StephanyMoreira/produtosCadastrados.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        Vector<String> lines = new Vector<String>();

        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        JOptionPane.showMessageDialog(null, new JScrollPane(new JList(lines)));
        fr.close();


    }



}

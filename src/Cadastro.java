import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Cadastro {
    static int cadastro(String[] nomeProd, double[][] codVal, int indiceVazio) throws IOException {
        char resp='s', confirmaCad;
        int indiceCad, indiceNomeCad;
        double prCusto, valVenda, codCad, quant;
        String nomeCad;

        do {
            if (indiceVazio<nomeProd.length) {
                nomeCad = JOptionPane.showInputDialog("Digite o nome do produto: ");
                //Verifica se o nome do produto já foi cadastrado
                indiceCad= Main.procNome(nomeProd, codVal, indiceVazio, nomeCad);
                if (indiceCad != -1) {
                    //Mostra mensagem caso esteja cadastrado e informa onde
                    JOptionPane.showMessageDialog(null, "Produto já cadastrado com o código: "+codVal[1][indiceCad]);
                }
                else {
                    codCad = Double.parseDouble(JOptionPane.showInputDialog("Digite o código do produto"));
                    //Verifica se o código do produto já foi cadastrado
                    indiceNomeCad = Main.procCod(nomeProd, codVal, indiceVazio, codCad);
                    if (indiceNomeCad != -1) {
                        //Caso sim, mostra o nome do produto que está usando o código
                        JOptionPane.showMessageDialog(null, "Código já cadastrado para o produto: "+nomeProd[indiceNomeCad]);
                    }
                    else {
                        prCusto = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de custo: "));
                        valVenda = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de venda: "));
                        quant = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade: "));

                        confirmaCad = (JOptionPane.showInputDialog(
                                "           Confirmação de cadastro"+"\n\n"+
                                        "Código: "+codCad+"\n"+
                                        "Nome do produto: "+nomeCad+"\n"+
                                        "Quantidade: "+quant+"\n"+
                                        "Preço de custo: R$"+prCusto+"\n"+
                                        "Valor de venda: R$"+valVenda+"\n\n"+
                                        "Confirma entrada dos dados (S/N)?")).charAt(0);

                        if ((confirmaCad=='s')||(confirmaCad=='S')){

                            ImageIcon noted = new ImageIcon("anotado.jpg");
                            JOptionPane.showMessageDialog(null,null,"Estamos cadastrando....",JOptionPane.INFORMATION_MESSAGE,noted);

                            Main.execCad(nomeProd, codVal, indiceVazio, codCad, nomeCad, prCusto, valVenda);
                            indiceVazio=(indiceVazio+1);

                            String cod = Double.toString(codCad);
                            String preco = Double.toString(prCusto);
                            String venda = Double.toString(valVenda);
                            String quat = Double.toString(quant);

                            OutputStream os = new FileOutputStream("produtosCadastrados.txt"); // nome do arquivo que será escrito
                            Writer wr = new OutputStreamWriter(os); // criação de um escritor
                            BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

                            br.write("ID: " +cod);
                            br.newLine();
                            br.write("Nome: " +nomeCad);
                            br.newLine();
                            br.write("Quantidade: " +quat);
                            br.newLine();
                            br.write("Preço: " +preco);
                            br.newLine();
                            br.write("Custo de venda:" +venda);
                            br.close();


                        }
                    }
                }

                resp = (JOptionPane.showInputDialog("Deseja cadastrar outro produto (S/N)?")).charAt(0);
            }
            else {
                JOptionPane.showMessageDialog(null, "Limite de cadastros alcançado");
                resp = 'n';
            }
        } while ((resp=='s') || (resp=='S'));
        return indiceVazio;
    }
}

import javax.swing.*;
import java.io.IOException;


public class Menu {
    public static void menu() throws IOException {
        double codVal [][] = new double [8][200];
        String nomeProd [] = new String [200];
        int indiceVazio=0, op;


        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "                Sistema de controle de estoque\n\n\n"+
                            "                              Menu principal \n\n" +
                            "1  - Cadastrar produto \n"+ "" +
                            "2  - Mostrar todas as informações cadastradas \n"+
                            "3  - Alterar quantidade\n"+
                            "4  - Remover produtos \n"+
                            "5  - Sair do Sistema \n"+
                            "\n\n"+
                            "6 - Créditos\n"
                            ));
            switch (op) {

                case 1:
                    indiceVazio = Cadastro.cadastro(nomeProd, codVal, indiceVazio);
                    break;

                case 2:
                    Main.mostraTodos(nomeProd, codVal, indiceVazio);
                    break;

                case 3:
                    Main.alterar(nomeProd, codVal, indiceVazio);
                    break;

                case 4:
                    Main.remover();
                    break;

                case 5:
                    ImageIcon stop = new ImageIcon("parar.jpg");
                    JOptionPane.showMessageDialog(null,"Finalizando o sistema...","Flw",JOptionPane.INFORMATION_MESSAGE,stop);
                    System.exit(0);
                    break;

                case 6:
                    ImageIcon cry = new ImageIcon("cry.jpg");
                    JOptionPane.showMessageDialog(null,"Programa feito por:\nStephany Moreira \nData:\n 09/06/2022","Programa feito com muito esforço ;-;",JOptionPane.INFORMATION_MESSAGE,cry);
                    System.exit(0);
					break;

                default:
                    JOptionPane.showMessageDialog(null, "Código inválido");
                    break;
            }

        }while(op!=6);
    }
}

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.*;

public class Login {
   public static void main(String[]args) throws IOException {
        //log = o que acontece no nosso programa

        ArrayList<String> logs = new ArrayList<>();
        logs.add("Programa iniciado"+ LocalDateTime.now());

        while (true){
            ImageIcon ohayo = new ImageIcon("ohayo.jpg");
            JOptionPane.showMessageDialog(null,"","Bom dia caro usuário",JOptionPane.INFORMATION_MESSAGE,ohayo);
            
            String user = JOptionPane.showInputDialog(null,"Entre com o usuario certo para desbloquear o controle de estoque: ");
            if (user.toLowerCase(Locale.ROOT).equals("admin")) {
                logs.add(user + " Adicionado na lista de cadastros, as " + LocalDateTime.now());
                logs.add(" Login finalizado "+ LocalDateTime.now());
                EscreverLog escreve = new EscreverLog();
                escreve.escrever(logs);
                Menu iniciar = new Menu();
                Menu.menu();

            }

            else{
                    ImageIcon erro = new ImageIcon("erroUsuario.jpg");
                    JOptionPane.showMessageDialog(null,"Usuario errado! Controle de estoque bloqueado!","Presta atenção ;-;",JOptionPane.INFORMATION_MESSAGE,erro);
                    break;

                }
        }


    }



}

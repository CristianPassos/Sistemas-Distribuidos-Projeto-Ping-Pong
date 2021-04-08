package projeto03;

import java.net.*;
import java.io.*;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket conexao = new Socket("127.0.0.1", 2001);
        DataInputStream entrada = new DataInputStream(conexao.getInputStream());
        DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

        String linhaSaida;;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Digite mensagem ");
            linhaSaida = teclado.readLine();
            saida.writeUTF(linhaSaida);

            if (linhaSaida.equalsIgnoreCase("sair")) {
                System.out.println("Desconectado.");
                break;
            }
            System.out.println("Mensagem Enviada.");
            System.out.println("Esperando resposta.");
            String linhaEntrada = entrada.readUTF();
            System.out.println("Resposta recebida :"+linhaEntrada);
        }

    }
}

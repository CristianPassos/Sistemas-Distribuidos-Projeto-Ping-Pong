package projeto03;

import java.net.*;
import java.io.*;

public class Servidor {

    public static void main(String[] args) throws IOException, EOFException {

        ServerSocket s = new ServerSocket(2001);

        while (true) {
            System.out.println("Esperando conexão...");
            Socket conexao = s.accept();
            System.out.println("Esperando mensagem!");
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

            String linhaSaida;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String linhaEntrada = entrada.readUTF();
            System.out.println("Mensagem recebida "+linhaEntrada);

            while (linhaEntrada != null && !(linhaEntrada.trim().equalsIgnoreCase("sair"))) {
                System.out.print("Digite a resposta: ");
                linhaSaida = teclado.readLine();
                System.out.println("Resposta enviada. ");
                saida.writeUTF( linhaSaida);
                System.out.println("Esperando mensagem.");
                linhaEntrada = entrada.readUTF();
                System.out.println("Resposta recebida :"+linhaEntrada);
            }
            saida.writeUTF(linhaEntrada);
            System.out.println("Conexão encerrada");
            conexao.close();

        }
    }
}

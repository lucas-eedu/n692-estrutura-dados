import java.io.IOException;

// Classe principal do programa
public class Main {

   // Método main: ponto de entrada da aplicação
   public static void main(String[] args) {
      // Verifica se o usuário informou o caminho do arquivo
      if (args.length == 0) {
         System.out.println("Uso: java -cp src Main input/entrada.txt");
         return;
      }

      // Pega o caminho do arquivo passado por argumento
      String caminhoArquivo = args[0];

      try {
         // Cria o autenticador de documentos
         DocumentAuthenticator authenticator = new DocumentAuthenticator();

         // Gera os códigos de autenticação
         String resultado = authenticator.generateAuthenticationCodes(caminhoArquivo);

         // Exibe o resultado final
         System.out.println(resultado);
      } catch (IOException e) {
         // Trata erro de leitura do arquivo
         System.out.println("Erro ao ler o arquivo: " + e.getMessage());
      }
   }
}
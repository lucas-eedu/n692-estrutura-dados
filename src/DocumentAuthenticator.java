import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Classe responsável por ler o arquivo e gerar os hashes de autenticação
public class DocumentAuthenticator {

    // Método principal que processa o arquivo
    public String generateAuthenticationCodes(String filePath) throws IOException {
        // Pilha que vai armazenar as árvores AVL geradas para cada linha
        LinkedStack<AVLTree> treeStack = new LinkedStack<>();

        // Leitura do arquivo linha por linha
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Enquanto houver linhas no arquivo
            while ((line = reader.readLine()) != null) {

                // Ignora linhas vazias
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Divide a linha em palavras e armazena em uma lista dinâmica
                StringLinkedList words = splitLineIntoWords(line);

                // Cria uma árvore AVL para a linha atual
                AVLTree tree = new AVLTree();

                // Percorre a lista de trás para frente
                for (int i = words.size() - 1; i >= 0; i--) {
                    tree.insert(words.get(i));
                }

                // Empilha a árvore gerada
                treeStack.push(tree);
            }
        }

        // StringBuilder para montar a saída final
        StringBuilder output = new StringBuilder();

        // Desempilha as árvores e calcula o hash de cada uma
        while (!treeStack.isEmpty()) {
            AVLTree currentTree = treeStack.pop();
            String hash = currentTree.computeRootHash();
            output.append(hash);

            // Quebra de linha entre hashes, exceto no último
            if (!treeStack.isEmpty()) {
                output.append(System.lineSeparator());
            }
        }

        return output.toString();
    }

    // Método auxiliar que quebra uma linha em palavras
    private StringLinkedList splitLineIntoWords(String line) {
        StringLinkedList list = new StringLinkedList();

        // Remove espaços do início e do fim
        String trimmedLine = line.trim();

        // Se a linha estiver vazia, retorna lista vazia
        if (trimmedLine.isEmpty()) {
            return list;
        }

        // Divide a linha por um ou mais espaços
        String[] parts = trimmedLine.split("\\s+");

        // Adiciona cada palavra à lista
        for (String part : parts) {
            if (!part.isBlank()) {
                list.add(part);
            }
        }

        return list;
    }
}
// Classe que representa a árvore AVL
public class AVLTree {
    private AVLNode root;

    // Método público para inserir um valor na árvore
    public void insert(String value) {
        // Ignora valores nulos ou vazios
        if (value == null || value.isBlank()) {
            return;
        }

        root = insert(root, value);
    }

    // Método público para calcular o hash da raiz
    public String computeRootHash() {
        if (root == null) {
            return "";
        }

        return computeHash(root);
    }

    // Inserção recursiva na AVL
    private AVLNode insert(AVLNode node, String value) {
        // Se o nó for nulo, cria um novo
        if (node == null) {
            return new AVLNode(value);
        }

        // Comparação ignorando maiúsculas e minúsculas
        int comparison = value.compareToIgnoreCase(node.value);

        // Insere na esquerda
        if (comparison < 0) {
            node.left = insert(node.left, value);
        }

        // Insere na direita
        else if (comparison > 0) {
            node.right = insert(node.right, value);
        }

        // Se for igual, ignora valor duplicado
        else {
            return node;
        }

        // Atualiza altura do nó
        updateHeight(node);

        // Verifica fator de balanceamento
        int balance = getBalance(node);

        // Caso esquerda-esquerda
        if (balance > 1 && value.compareToIgnoreCase(node.left.value) < 0) {
            return rotateRight(node);
        }

        // Caso direita-direita
        if (balance < -1 && value.compareToIgnoreCase(node.right.value) > 0) {
            return rotateLeft(node);
        }

        // Caso esquerda-direita
        if (balance > 1 && value.compareToIgnoreCase(node.left.value) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Caso direita-esquerda
        if (balance < -1 && value.compareToIgnoreCase(node.right.value) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Calcula recursivamente o hash do nó
    private String computeHash(AVLNode node) {
        // Hash da própria palavra do nó
        String ownHash = HashUtils.sha1(node.value);

        // String usada para montar a concatenação final
        StringBuilder combined = new StringBuilder();

        // Primeiro entra hash do filho esquerdo, se existir
        if (node.left != null) {
            combined.append(computeHash(node.left));
        }

        // Depois entra hash do filho direito, se existir
        if (node.right != null) {
            combined.append(computeHash(node.right));
        }

        // Por último entra hash do próprio nó
        combined.append(ownHash);

        // Retorna SHA-1 da concatenação
        return HashUtils.sha1(combined.toString());
    }

    // Retorna a altura do nó
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Atualiza a altura do nó
    private void updateHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Calcula o fator de balanceamento
    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Rotação simples à direita
    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Rotação simples à esquerda
    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode t2 = y.left;

        y.left = x;
        x.right = t2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }
}
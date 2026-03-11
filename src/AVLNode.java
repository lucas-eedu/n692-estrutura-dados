// Classe que representa um nó da árvore AVL
public class AVLNode {
    String value;     // Palavra armazenada no nó
    int height;       // Altura do nó
    AVLNode left;     // Filho esquerdo
    AVLNode right;    // Filho direito

    // Construtor do nó
    public AVLNode(String value) {
        this.value = value;
        this.height = 1;
    }
}
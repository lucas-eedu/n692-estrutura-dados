// Nó genérico usado pela pilha
public class StackNode<T> {
    T value;               // Valor armazenado
    StackNode<T> next;     // Próximo nó

    // Construtor
    public StackNode(T value) {
        this.value = value;
    }
}
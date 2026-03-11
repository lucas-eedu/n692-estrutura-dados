// Implementação de pilha dinâmica usando nós encadeados
public class LinkedStack<T> {
    private StackNode<T> top;
    private int size;

    // Empilha um novo valor
    public void push(T value) {
        StackNode<T> newNode = new StackNode<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Desempilha e retorna o topo
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia.");
        }

        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return top == null;
    }

    // Retorna a quantidade de elementos
    public int size() {
        return size;
    }
}
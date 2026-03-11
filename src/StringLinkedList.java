// Lista encadeada dinâmica para armazenar palavras
public class StringLinkedList {
    private StringNode head;
    private int size;

    // Adiciona um valor ao final da lista
    public void add(String value) {
        StringNode newNode = new StringNode(value);

        // Se a lista estiver vazia, o novo nó vira o primeiro
        if (head == null) {
            head = newNode;
        } else {
            // Percorre até o último nó
            StringNode current = head;
            while (current.next != null) {
                current = current.next;
            }

            // Liga o último nó ao novo nó
            current.next = newNode;
        }

        size++;
    }

    // Retorna o valor da posição informada
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        StringNode current = head;
        int currentIndex = 0;

        // Percorre até a posição desejada
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        return current.value;
    }

    // Retorna o tamanho da lista
    public int size() {
        return size;
    }
}
# N692 - Estrutura de Dados

Projeto desenvolvido para a disciplina **Estrutura de Dados** utilizando **Java**.

O objetivo do trabalho é ler um arquivo `.txt`, processar cada linha utilizando **estruturas de dados implementadas manualmente** e gerar um **código de autenticação baseado em SHA-1** a partir da estrutura de uma **árvore AVL**.

---

# 📚 Objetivo do Projeto

O programa realiza os seguintes passos:

1. Lê um arquivo `.txt` linha por linha
2. Divide cada linha em palavras
3. Armazena as palavras em uma **lista dinâmica**
4. Insere as palavras em uma **árvore AVL**
5. Ignora palavras duplicadas usando `compareToIgnoreCase`
6. Armazena cada árvore em uma **pilha dinâmica**
7. Gera um **hash SHA-1** para cada árvore
8. Exibe o hash de cada linha do arquivo

Cada linha do arquivo gera um **código de autenticação único** baseado na estrutura da árvore AVL.

---

# 🧠 Estruturas de Dados Utilizadas

O projeto implementa manualmente as seguintes estruturas:

## Lista Dinâmica

Classes utilizadas:

- StringLinkedList
- StringNode

Responsável por armazenar as palavras de cada linha do arquivo.

---

## Árvore AVL

Classes utilizadas:

- AVLTree
- AVLNode

Responsável por armazenar as palavras de forma ordenada e balanceada.

Características:

- Balanceamento automático
- Rotação à esquerda
- Rotação à direita
- Ignora palavras duplicadas
- Comparação utilizando `compareToIgnoreCase`

---

## Pilha Dinâmica

Classes utilizadas:

- LinkedStack
- StackNode

Utilizada para armazenar as árvores AVL criadas a partir de cada linha do arquivo.

A pilha segue o princípio:

LIFO (Last In First Out)

Ou seja, a última árvore inserida é a primeira a ser processada.

---

# 🔐 Geração do Hash

O hash é gerado utilizando o algoritmo **SHA-1**.

Para cada nó da árvore é aplicado o seguinte cálculo:

h( h(A) + h(B) + h(P) )

Onde:

- A = subárvore esquerda  
- B = subárvore direita  
- P = palavra armazenada no nó  

Essa regra garante que a **estrutura da árvore AVL influencia diretamente o resultado final do hash**.

---

# 📂 Estrutura do Projeto

```shell
.
├── input
│   └── entrada.txt
│
├── src
│   ├── AVLNode.java
│   ├── AVLTree.java
│   ├── DocumentAuthenticator.java
│   ├── HashUtils.java
│   ├── LinkedStack.java
│   ├── Main.java
│   ├── StackNode.java
│   ├── StringLinkedList.java
│   └── StringNode.java
│
├── explicacao.md
└── README.md
```

---

# ▶️ Como Executar o Projeto

## 1️⃣ Compilar o projeto

Na raiz do projeto execute:

javac src/*.java

---

## 2️⃣ Executar o programa

java -cp src Main input/entrada.txt

---

# 📄 Arquivo de Entrada

O arquivo `entrada.txt` deve conter **no mínimo 30 linhas de texto em português**, conforme solicitado no trabalho.

Cada linha será processada da seguinte forma:

linha do arquivo
↓
separação das palavras
↓
lista dinâmica
↓
inserção na árvore AVL
↓
armazenamento na pilha
↓
geração do hash

Cada linha gera **um código de autenticação SHA-1**.

---

# 📌 Observações

- As estruturas de dados foram implementadas manualmente.
- Não foram utilizadas estruturas prontas como `ArrayList`, `Stack` ou `TreeSet`.
- O projeto demonstra a aplicação prática de **listas encadeadas, pilhas e árvores AVL**.
- O resultado do programa são **hashes SHA-1 representados em hexadecimal**.

---

# 👨‍💻 Autor

Projeto desenvolvido para a disciplina **N692 - Estrutura de Dados**.

Autor: **Lucas Eduardo**

# Divisão da Apresentação do Trabalho -- Estrutura de Dados

## Objetivo

Dividir a explicação do projeto igualmente entre os **6 integrantes do
grupo**, garantindo que cada membro tenha participação ativa no vídeo,
conforme solicitado no trabalho.

Tempo máximo do vídeo: **10 minutos**

------------------------------------------------------------------------

# Integrante 1 --- Introdução e Objetivo do Projeto => Vitor

Tempo aproximado: **1 minuto**

Responsável por apresentar o contexto do trabalho.

### Pontos para explicar

-   Apresentar **nome e matrícula**.
-   Explicar o **tema do projeto**.
-   O projeto consiste na implementação de um **autenticador de
    documentos textuais**.
-   O sistema gera **códigos de autenticação (hash)** para cada linha de
    um arquivo de texto.
-   O objetivo é garantir a **integridade e autenticidade de documentos
    digitais**.
-   O projeto utiliza **estruturas de dados estudadas na disciplina**,
    como:
    -   lista encadeada
    -   árvore AVL
    -   pilha
    -   função hash criptográfica (SHA-1).

------------------------------------------------------------------------

# Integrante 2 --- Leitura do Arquivo TXT => Ana Raquel

Tempo aproximado: **1 minuto**

Responsável por explicar a entrada de dados do sistema.

### Pontos para explicar

-   O programa recebe como entrada um **arquivo `.txt`**.
-   Esse arquivo deve possuir **mínimo de 30 linhas**.
-   Cada linha do arquivo é lida **individualmente**.
-   Cada linha será utilizada para gerar **um código de autenticação
    específico**.
-   A leitura do arquivo é realizada pela classe responsável pela
    autenticação do documento.

### Código relacionado

-   Classe `Main`
-   Classe `DocumentAuthenticator`

------------------------------------------------------------------------

# Integrante 3 --- Lista Dinâmica de Palavras => Alisson Moreira

Tempo aproximado: **1,5 minutos**

Responsável por explicar o uso da **lista encadeada**.

### Pontos para explicar

-   Cada linha do texto é **separada em palavras**.
-   A separação ocorre usando **os espaços em branco**.
-   As palavras são armazenadas em uma **lista dinâmica (lista
    encadeada)**.
-   Cada palavra é inserida em um **nó da lista**.

### Estruturas usadas

-   `StringLinkedList`
-   `StringNode`

### Conceito importante

Lista encadeada:

-   Estrutura dinâmica
-   Não possui tamanho fixo
-   Cada elemento aponta para o próximo

------------------------------------------------------------------------

# Integrante 4 --- Construção da Árvore AVL => Oderlan Freire

Tempo aproximado: **2 minutos**

Responsável por explicar a criação da árvore AVL.

### Pontos para explicar

-   As palavras da lista são inseridas na árvore **em ordem reversa**.
-   Ou seja, a inserção ocorre **do final da lista para o início**.
-   A comparação entre palavras é feita usando **ordem lexicográfica**.

### Método utilizado

compareToIgnoreCase()

### Regras importantes

-   A árvore utilizada é uma **Árvore AVL**.
-   A AVL é uma **árvore binária de busca balanceada**.
-   Palavras duplicadas **não são inseridas na árvore**.

### Estruturas usadas

-   `AVLTree`
-   `AVLNode`

------------------------------------------------------------------------

# Integrante 5 --- Uso da Pilha de Árvores => Petherson

Tempo aproximado: **1,5 minutos**

Responsável por explicar a estrutura de **pilha**.

### Pontos para explicar

-   Cada linha do texto gera **uma árvore AVL**.
-   Após construída, essa árvore é **armazenada em uma pilha**.
-   A pilha guarda todas as árvores geradas.

### Funcionamento da pilha

A pilha segue o princípio:

**LIFO --- Last In, First Out**

Ou seja:

-   o último elemento inserido
-   é o primeiro a ser removido.

### Estruturas usadas

-   `LinkedStack`
-   `StackNode`

### Fluxo da aplicação

```shell
Linha do texto 
↓ 
Lista de palavras 
↓ 
Árvore AVL 
↓ 
Pilha
```

------------------------------------------------------------------------

# Integrante 6 --- Geração do Hash e Resultado Final => Lucas Eduardo

Tempo aproximado: **2 minutos**

Responsável por explicar a geração do código de autenticação.

### Pontos para explicar

-   As árvores são **desempilhadas uma a uma**.
-   Para cada árvore é calculado um **hash criptográfico**.
-   O cálculo do hash é feito **percorrendo os nós da árvore**.

### Lógica de geração do hash

hash(P) = h( h(A) + h(B) + h(P) )

Onde:

-   P = nó pai
-   A = filho esquerdo
-   B = filho direito

Se um dos filhos não existir, ele **não entra no cálculo**.

### Algoritmo utilizado

SHA-1

### Resultado final

-   Cada linha gera **um hash**
-   Todos os hashes são **exibidos separados por quebra de linha**
-   Esse conjunto de hashes representa o **código de autenticação do
    documento**

------------------------------------------------------------------------

# Estrutura Final do Vídeo

  Integrante   Tema                               Tempo
  ------------ ---------------------------------- ---------
  1            Introdução e objetivo do projeto   1 min
  2            Leitura do arquivo                 1 min
  3            Lista encadeada                    1,5 min
  4            Árvore AVL                         1,5 min
  5            Pilha de árvores                   1,5 min
  6            Geração do hash                    1,5 min

Tempo total aproximado: **9 a 10 minutos**

------------------------------------------------------------------------

# Dica para a Apresentação

Durante a explicação, cada integrante pode mostrar rapidamente:

-   a **parte do código relacionada**
-   ou **um trecho da estrutura implementada**

Isso demonstra domínio do conteúdo e fortalece a apresentação do grupo.

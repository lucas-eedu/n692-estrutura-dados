## Ordem de desenvolvimento do projeto

### 1) Main.java

O arquivo `Main.java` é o ponto de entrada do programa. Nele começa a execução da aplicação.

Primeiro é verificado se o usuário informou o caminho do arquivo `.txt` ao executar o programa. Caso não tenha informado, o sistema mostra uma mensagem explicando como executar corretamente.

Depois disso, é criado um objeto da classe `DocumentAuthenticator`, que é responsável por fazer todo o processamento do arquivo.

Em seguida, o método `generateAuthenticationCodes` é chamado passando o caminho do arquivo. Esse método retorna os códigos de autenticação gerados a partir do conteúdo do arquivo.

Por fim, o resultado é exibido no console. Também existe um `try-catch` para tratar possíveis erros de leitura do arquivo.

---

### 2) DocumentAuthenticator.java

A classe `DocumentAuthenticator` é responsável por coordenar todo o processamento do arquivo.

Primeiro, o arquivo `.txt` é aberto utilizando `BufferedReader`. O conteúdo é lido linha por linha.

Cada linha é dividida em palavras através do método `splitLineIntoWords`. Essas palavras são armazenadas em uma lista dinâmica implementada pela classe `StringLinkedList`.

Depois disso, é criada uma árvore AVL para representar a linha. As palavras da lista são inseridas na árvore de trás para frente, conforme solicitado no trabalho.

Cada árvore criada é armazenada em uma pilha. No final do processo, as árvores são desempilhadas e o hash de cada uma é calculado e retornado.

---

### 3) AVLTree.java

A classe `AVLTree` representa a árvore AVL utilizada para armazenar as palavras de cada linha.

O método `insert` é responsável por inserir uma palavra na árvore. A inserção utiliza `compareToIgnoreCase`, garantindo que a comparação ignore letras maiúsculas e minúsculas.

Caso a palavra já exista na árvore, ela é ignorada, evitando duplicação.

Após cada inserção, a árvore é balanceada automaticamente através das rotações AVL, garantindo que a estrutura continue balanceada.

A classe também possui o método `computeRootHash`, que percorre a árvore recursivamente e gera o hash da estrutura seguindo a regra definida no enunciado.

---

### 4) AVLNode.java

A classe `AVLNode` representa cada nó da árvore AVL.

Cada nó armazena três informações principais: a palavra (`value`), a altura do nó (`height`) e referências para os filhos esquerdo e direito.

Essa classe é utilizada pela `AVLTree` para montar a estrutura da árvore.

---

### 5) StringLinkedList.java

A classe `StringLinkedList` implementa uma lista encadeada dinâmica para armazenar as palavras de cada linha do arquivo.

Ela possui métodos para adicionar novos elementos (`add`), acessar um elemento pelo índice (`get`) e obter o tamanho da lista (`size`).

Essa lista foi implementada manualmente para atender ao requisito do trabalho de utilizar estruturas de dados próprias.

---

### 6) StringNode.java

A classe `StringNode` representa cada nó da lista encadeada de palavras.

Cada nó contém a palavra armazenada e uma referência para o próximo elemento da lista.

Ela é utilizada internamente pela classe `StringLinkedList`.

---

### 7) LinkedStack.java

A classe `LinkedStack` implementa uma pilha dinâmica utilizando nós encadeados.

Ela possui os métodos principais de uma pilha: `push`, que adiciona um elemento no topo, e `pop`, que remove o elemento do topo.

Essa pilha é utilizada para armazenar as árvores AVL geradas para cada linha do arquivo.

---

### 8) StackNode.java

A classe `StackNode` representa cada nó da pilha.

Cada nó armazena um valor e uma referência para o próximo elemento da pilha.

Ela é utilizada internamente pela classe `LinkedStack`.

---

### 9) HashUtils.java

A classe `HashUtils` é responsável por gerar o hash SHA-1 das palavras e das combinações de hashes da árvore.

Ela utiliza a classe `MessageDigest` da biblioteca padrão do Java para calcular o SHA-1.

Também possui um método auxiliar que converte os bytes do hash em uma representação hexadecimal.

---

### 10) entrada.txt

O arquivo `entrada.txt` é o arquivo de entrada utilizado pelo programa.

Cada linha do arquivo representa um conjunto de palavras que será transformado em uma árvore AVL.

O programa lê esse arquivo linha por linha, separa as palavras e constrói a estrutura de dados necessária para gerar o código de autenticação.

Cada linha do arquivo resultará em um hash gerado a partir da árvore construída com suas palavras.
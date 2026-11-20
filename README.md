# Library System

Sistema de gerenciamento de biblioteca desenvolvido em Java. Permite cadastrar livros e usuários, realizar empréstimos e gerar relatórios — tudo via menu interativo no terminal.

---

## Estrutura do projeto

```
Library_system/
├── Livro.java          # Representa um livro (título, autor, disponibilidade)
├── Pessoa.java         # Classe abstrata base para pessoas
├── Usuario.java        # Usuário da biblioteca, estende Pessoa
├── Biblioteca.java     # Acervo de livros e operações sobre ele
├── BaseUsuarios.java   # Lista de usuários e geração de relatório
└── Test.java           # Ponto de entrada — menu interativo
```

---

## Classes

### `Livro`
Representa um livro do acervo.

| Campo | Tipo | Descrição |
|---|---|---|
| `titulo` | `String` | Título do livro |
| `autor` | `String` | Nome do autor |
| `disponivel` | `boolean` | Se o livro está disponível para empréstimo |

Métodos principais:
- `disponibilidade()` — retorna `"Disponível"` ou `"indisponível"`
- `trocarDisponilidade(int)` — passa `1` para disponível, `0` para indisponível

---

### `Pessoa` *(abstrata)*
Base para qualquer pessoa no sistema. Armazena nome e idade, e define o método abstrato `exibirInfo()`.

---

### `Usuario`
Estende `Pessoa`. Representa um usuário cadastrado na biblioteca.

| Campo | Tipo | Descrição |
|---|---|---|
| `matricula` | `int` | Identificador único do usuário |
| `emprestado` | `Livro` | Livro atualmente emprestado ao usuário |

---

### `Biblioteca`
Gerencia o acervo de livros.

| Método | Descrição |
|---|---|
| `setNewBook(nome, autor)` | Cadastra um novo livro disponível |
| `listarLivros()` | Exibe todos os livros com título, autor e disponibilidade |
| `emprestarLivro(index)` | Marca o livro como indisponível e o retorna para associar a um usuário |

---

### `BaseUsuarios`
Gerencia a lista de usuários cadastrados.

| Método | Descrição |
|---|---|
| `setUsers(...)` | Cadastra um novo usuário |
| `encontrarPessoa(matricula)` | Busca um usuário pela matrícula |
| `listarUsuarios()` | Exibe informações de todos os usuários |
| `criarRelatorio()` | Gera o arquivo `Relatorio.txt` com dados de todos os usuários |

---

### `Test` — Ponto de entrada
Inicia o sistema com dois livros e dois usuários pré-cadastrados, pergunta o nome do usuário atual e exibe o menu:

```
1 - Cadastrar Livro
2 - Listar Livros
3 - Emprestar Livro
4 - Cadastrar Usuário
5 - Listar Usuários
6 - Criar relatório
0 - Sair
```

---

## Como executar

**Pré-requisito:** JDK 11 ou superior instalado.

```bash
# Compilar (a partir da pasta pai de Library_system)
javac Library_system/*.java

# Executar
java Library_system.Test
```

O relatório gerado pela opção 6 é salvo como `Relatorio.txt` no diretório de onde o programa é executado.

---

## Tecnologias

- Java (sem dependências externas)
- `java.util` — `ArrayList`, `List`, `Scanner`
- `java.nio.file` — escrita do relatório em arquivo

# Calculadora Binário/Decimal com GALS

Este projeto implementa uma pequena linguagem de expressões matemáticas, utilizando o GALS para geração do analisador léxico, sintático e semântico. O objetivo é permitir o cálculo de expressões em binário ou decimal, com suporte a variáveis, operações matemáticas e testes automatizados.

## Funcionalidades
- **Entrada de expressões em decimal ou binário**
- **Operações suportadas:**
  - Adição: `+`
  - Subtração: `-`
  - Multiplicação: `*`
  - Divisão: `/`
  - Exponenciação: `**`
  - Logaritmo natural: `log()`
- **Atribuição e uso de variáveis**
- **Exibição do resultado em decimal e binário**
- **Módulo de testes automatizados**
- **Menu interativo**

## Como funciona
Ao executar o programa, o usuário verá um menu com as opções:

```
==== CALCULADORA BINÁRIO/DECIMAL ====
Escolha uma opção:
1. Rodar testes prontos (GalsUnitTests)
2. Digitar expressão manualmente
3. Ver operações suportadas
0. Sair
Opção:
```

- **Opção 1:** Executa testes automáticos para validar a linguagem e as operações.
- **Opção 2:** Permite digitar uma expressão, escolhendo se ela está em decimal ou binário. O resultado é exibido em ambos os formatos.
- **Opção 3:** Mostra todas as operações suportadas pela linguagem.
- **Opção 0:** Encerra o programa.

## Exemplos de uso
- Expressão em binário: `A=10+11; Show(A);` (2 + 3 = 5)
- Expressão em decimal: `A=2+3; Show(A);` (convertido para binário internamente)
- Exponenciação: `A=10**11; Show(A);` (2 ** 3 = 8)
- Logaritmo: `A=log(1); Show(A);`
- Uso de variáveis: `X=100; Y=X; Show(Y);`

## Estrutura do projeto
- `projeto_lfa.gals`: Definição da linguagem para o GALS (tokens, gramática, ações semânticas)
- `src/main/java/gals/`: Implementação das classes geradas e utilitários (léxico, sintático, semântico, erros, testes)
- `src/main/java/Menu.java`: Menu interativo para o usuário
- `src/main/java/Main.java`: Classe principal para execução do programa

## Como rodar
1. Compile o projeto com Maven ou seu IDE Java favorito.
2. Execute a classe `Main`.
3. Siga as instruções do menu.

## Testes
O módulo de testes automatizados pode ser executado pela opção 1 do menu, validando as principais operações e funcionalidades da linguagem.

---

Projeto desenvolvido para disciplina de Linguagens Formais e Autômatos (LFA).
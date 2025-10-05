package gals;

import java.util.HashMap;

import java.util.Stack;

public class Semantico implements Constants {
    HashMap<String, Integer> variaveis = new HashMap<>();
    Stack<Integer> pilha = new Stack<>();
    String variavelAtual;

    public void executeAction(int action, Token token) throws SemanticError {
        Integer a, b;
        switch (action) {
            // adição
            case 1:
                a = pilha.pop();
                b = pilha.pop();
                pilha.push(b + a);
                break;
            // subtração
            case 2:
                a = pilha.pop();
                b = pilha.pop();
                pilha.push(b - a);
                break;
            // multiplicação
            case 3:
                a = pilha.pop();
                b = pilha.pop();
                pilha.push(b * a);
                break;
            // divisão
            case 4:
                a = pilha.pop();
                b = pilha.pop();
                pilha.push(b / a);
                break;
            // exponenciação
            case 5:
                a = pilha.pop();
                b = pilha.pop();
                pilha.push((int) Math.pow(b, a));
                break; // log
            case 6:
                a = pilha.pop();
                pilha.push((int) Math.log(a));
                break;
            // capturar variável
            case 7:
                variavelAtual = token.getLexeme();
                break;
            // salvar variável
            case 8:
                variaveis.put(variavelAtual, pilha.pop());
                break;
            // imprimir resultado
            case 9:
                if (pilha.isEmpty()) {
                    System.out.println("Erro: pilha vazia ao imprimir.");
                } else {
                    System.out.println("Resultado: " + pilha.peek());
                }
                break;
            // empilha número binário
            case 10:
                pilha.push(Integer.parseInt(token.getLexeme(), 2));
                break;
            // empilha valor de variável
            case 11:
                if (variaveis.containsKey(token.getLexeme())) {
                    pilha.push(variaveis.get(token.getLexeme()));
                } else {
                    throw new SemanticError("Variável não declarada: " + token.getLexeme());
                }
                break;
        }
    }

    public int getResultado() {
        return pilha.peek();
    }
}

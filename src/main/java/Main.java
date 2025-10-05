import java.io.StringReader;

import gals.Lexico;
import gals.Semantico;
import gals.Sintatico;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                Menu.exibirMenu();
                int op = Menu.lerOpcao();
                if (op == 0) {
                    System.out.println("Saindo...");
                    break;
                }
                if (op == 1) {
                    Menu.rodarTestesGalsUnitTests();
                    continue;
                }
                String exprParaParser = null;
                if (op == 2) {
                    Menu.ManualInput input = Menu.lerExpressaoManualComTipo();
                    if (input.isBinario) {
                        exprParaParser = input.expr;
                    } else {
                        exprParaParser = Menu.decimalParaBinario(input.expr);
                    }
                } else if (op == 3) {
                    Menu.exibirOperacoesSuportadas();
                    continue;
                } else {
                    System.out.println("Opção inválida.");
                    continue;
                }

                Lexico lexico = new Lexico(new StringReader(exprParaParser));
                Sintatico sintatico = new Sintatico();
                Semantico semantico = new Semantico();
                sintatico.parse(lexico, semantico);
                int resultado = semantico.getResultado();
                Menu.mostrarResultado(resultado);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
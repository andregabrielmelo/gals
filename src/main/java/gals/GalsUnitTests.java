package gals;

import java.io.StringReader;

public class GalsUnitTests {
    private static void runTest(String input) {
        Lexico lexico = new Lexico(new StringReader(input));
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();
        try {
            System.out.println("Entrada: " + input);
            sintatico.parse(lexico, semantico);
        } catch (LexicalError | SyntaticError | SemanticError e) {
            System.out.println("Erro durante o processamento: " + e.getMessage());
        }
    }

    public static void runAll() {
        System.out.println("Testes GalsUnitTests:");
        System.out.println("----------------------");
        System.out.println("testAddition");
        // 2 + 3 = 5 → 10 + 11 = 101
        System.out.println(" 2 + 3 = 5 -> 10 + 11 = 101");
        runTest("A=10+11; Show(A);");
        System.out.println();
        System.out.println("testSubtraction");
        // 4 - 1 = 3 → 100 - 1 = 11
        System.out.println(" 4 - 1 = 3 -> 100 - 1 = 11");
        runTest("A=100-1; Show(A);");
        System.out.println();
        System.out.println("testMultiplication");
        // 2 * 3 = 6 → 10 * 11 = 110
        System.out.println(" 2 * 3 = 6 -> 10 * 11 = 110");
        runTest("A=10*11; Show(A);");
        System.out.println();
        System.out.println("testDivision");
        // 6 / 2 = 3 → 110 / 10 = 11
        System.out.println(" 6 / 2 = 3 -> 110 / 10 = 11");
        runTest("A=110/10; Show(A);");
        System.out.println();
        System.out.println("testExponentiation");
        // 2**3 = 8 → 10 ** 11 = 1000
        System.out.println(" 2**3 = 8 -> 10 ** 11 = 1000");
        runTest("A=10**11; Show(A);");
        System.out.println();
        System.out.println("testLog");
        // Log(1) = 0 → Log(1) = Log(1)
        System.out.println(" Log(1) = 0 -> Log(1) = Log(1)");
        runTest("A=Log(1); Show(A);");
        System.out.println();
        System.out.println("testVariableUsage");
        // X = 4, Y = X → 100
        System.out.println(" X = 4, Y = X -> 100");
        runTest("X=100; Y=X; Show(Y);");
        System.out.println();
        System.out.println("testComplexExpression");
        // (2 + 3 * 4 - 5**2 / 5) → binary
        // Let's simplify: 10 + 11 * 100 - 101**10 / 101
        System.out.println(" (2 + 3 * 4 - 5**2 / 5) -> binary");
        System.out.println(" Let's simplify: 10 + 11 * 100 - 101**10 / 101");
        runTest("A=10+11*100-101**10/101; Show(A);");
        System.out.println();
    }
}

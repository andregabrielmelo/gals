import gals.*;

import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

public class GalsUnitTests {

    void runTest(String input) {
        Lexico lexico = new Lexico(new StringReader(input));
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();

        try {
            System.out.println("Entrada: " + input);
            sintatico.parse(lexico, semantico);
        } catch (LexicalError | SyntaticError | SemanticError e) {
            fail("Erro durante o processamento: " + e.getMessage());
        }
    }

    @Test
    void testAddition() {
        // 2 + 3 = 5 → 10 + 11 = 101
        runTest("A=10+11; Show(A);");
    }

    @Test
    void testSubtraction() {
        // 4 - 1 = 3 → 100 - 1 = 11
        runTest("A=100-1; Show(A);");
    }

    @Test
    void testMultiplication() {
        // 2 * 3 = 6 → 10 * 11 = 110
        runTest("A=10*11; Show(A);");
    }

    @Test
    void testDivision() {
        // 6 / 2 = 3 → 110 / 10 = 11
        runTest("A=110/10; Show(A);");
    }

    @Test
    void testExponentiation() {
        // 2**3 = 8 → 10 ** 11 = 1000
        runTest("A=10**11; Show(A);");
    }

    @Test
    void testLog() {
        // Log(1) = 0 → Log(1) = Log(1)
        runTest("A=Log(1); Show(A);");
    }

    @Test
    void testVariableUsage() {
        // X = 4, Y = X → 100
        runTest("X=100; Y=X; Show(Y);");
    }

    @Test
    void testComplexExpression() {
        // (2 + 3 * 4 - 5**2 / 5) → binary
        // Let's simplify: 10 + 11 * 100 - 101**10 / 101
        runTest("A=10+11*100-101**10/101; Show(A);");
    }
}
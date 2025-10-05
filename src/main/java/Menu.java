import java.util.Scanner;

public class Menu {
    public static void exibirMenu() {
        System.out.println("==== CALCULADORA BINÁRIO/DECIMAL ====");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Rodar testes prontos (GalsUnitTests)");
        System.out.println("2. Digitar expressão manualmente");
        System.out.println("3. Ver operações suportadas");
        System.out.println("0. Sair");
        System.out.print("Opção: ");
    }

    public static int lerOpcao() {
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        scanner.nextLine();
        return op;
    }

    public static void rodarTestesGalsUnitTests() {
        try {
            gals.GalsUnitTests.runAll();
        } catch (Exception e) {
            System.out.println("Erro ao rodar testes: " + e.getMessage());
        }
    }

    public static ManualInput lerExpressaoManualComTipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você deseja digitar a expressão em:");
        System.out.println("1. Decimal");
        System.out.println("2. Binário");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a expressão (ex: 10+11): ");
        String expr = scanner.nextLine();
        String input = "A=" + expr + ";Show(A);";
        return new ManualInput(input, tipo == 2);
    }

    public static boolean isBinario(String expr) {
        return expr.matches("[-01+*/() ]+$");
    }

    public static String decimalParaBinario(String expr) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("(?<![0-9a-zA-Z])([0-9]+)(?![0-9a-zA-Z])");
        java.util.regex.Matcher m = p.matcher(expr);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String bin = Integer.toBinaryString(Integer.parseInt(m.group(1)));
            m.appendReplacement(sb, bin);
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static void mostrarResultado(int resultado) {
        System.out.println("Resultado decimal: " + resultado);
        System.out.println("Resultado binário: " + Integer.toBinaryString(resultado));
    }

    public static void exibirOperacoesSuportadas() {
        System.out.println("\nOperações suportadas:");
        System.out.println("+  (adição)");
        System.out.println("-  (subtração)");
        System.out.println("*  (multiplicação)");
        System.out.println("/  (divisão)");
        System.out.println("** (exponenciação)");
        System.out.println("log() (logaritmo natural)");
        System.out.println();
    }

    // Classe auxiliar para transportar expressão e tipo
    public static class ManualInput {
        public final String expr;
        public final boolean isBinario;
        public ManualInput(String expr, boolean isBinario) {
            this.expr = expr;
            this.isBinario = isBinario;
        }
    }
}

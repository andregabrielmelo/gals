import gals.Lexico;
import gals.Semantico;
import gals.Sintatico;

import java.io.StringReader;

public class Main {
    public static void main(String[] args) {
        try{
            String test_log =
                    "A=Log(100);" +
                    "Show(A);";
            String test_sum =
                    "A=10+11;" +
                    "Show(A);";
            String test=
                    "A=2**3;" + "Show(A);";

            Lexico lexico = new Lexico(
                new StringReader(
                    test
                )
            );

            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();
            sintatico.parse(lexico, semantico);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
package gals;

public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_PRINT = 2;
    int t_LOG = 3;
    int t_VARIABLE = 4;
    int t_NUMBER = 5;
    int t_EQUALS = 6;
    int t_ADDITION = 7;
    int t_SUBTRACTION = 8;
    int t_MULTIPLICATION = 9;
    int t_DIVISION = 10;
    int t_EXPONENTIATION = 11;
    int t_OPEN_PARENTHESES = 12;
    int t_CLOSE_PARENTHESES = 13;
    int t_EOL = 14;

}

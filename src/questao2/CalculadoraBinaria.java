package questao2;

public class CalculadoraBinaria {
    public String somar(String a, String b) {
        int decimalA = Integer.parseInt(a, 2);
        int decimalB = Integer.parseInt(b, 2);
        int resultado = decimalA + decimalB;
        return Integer.toBinaryString(resultado);
    }

    public String subtrair(String a, String b) {
        int decimalA = Integer.parseInt(a, 2);
        int decimalB = Integer.parseInt(b, 2);
        int resultado = decimalA - decimalB;
        return Integer.toBinaryString(resultado);
    }
}

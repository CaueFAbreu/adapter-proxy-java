package questao2;

public class CalculadoraAdapter implements CalculadoraDecimal {
    private CalculadoraBinaria calculadoraBinaria;

    public CalculadoraAdapter(CalculadoraBinaria calculadoraBinaria) {
        this.calculadoraBinaria = calculadoraBinaria;
    }

    @Override
    public int somar(int a, int b) {
        String binarioA = Integer.toBinaryString(a);
        String binarioB = Integer.toBinaryString(b);
        String resultadoBinario = calculadoraBinaria.somar(binarioA, binarioB);
        return Integer.parseInt(resultadoBinario, 2);
    }

    @Override
    public int subtrair(int a, int b) {
        String binarioA = Integer.toBinaryString(a);
        String binarioB = Integer.toBinaryString(b);
        String resultadoBinario = calculadoraBinaria.subtrair(binarioA, binarioB);
        return Integer.parseInt(resultadoBinario, 2);
    }

    @Override
    public int multiplicar(int a, int b) {
        int resultado = 0;

        for (int i = 0; i < b; i++) {
            resultado = somar(resultado, a);
        }

        return resultado;
    }
}

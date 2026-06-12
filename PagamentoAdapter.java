package questao3;

public class PagamentoAdapter implements LeitorPagamento {
    private SistemaPagamentoAntigo sistemaAntigo;

    public PagamentoAdapter(SistemaPagamentoAntigo sistemaAntigo) {
        this.sistemaAntigo = sistemaAntigo;
    }

    @Override
    public void pagar(double valor) {
        int valorEmCentavos = (int) Math.round(valor * 100);
        sistemaAntigo.realizarPagamentoEmCentavos(valorEmCentavos);
    }
}

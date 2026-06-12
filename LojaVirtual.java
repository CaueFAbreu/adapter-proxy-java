package questao3;

public class LojaVirtual {
    private LeitorPagamento pagamento;

    public LojaVirtual(LeitorPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void finalizarCompra(double valor) {
        System.out.println("Finalizando compra no valor de R$ " + valor);
        pagamento.pagar(valor);
    }
}

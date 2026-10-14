package questao4;

public class VideoPremium implements Video {
    private String titulo;

    public VideoPremium(String titulo) {
        this.titulo = titulo;
        carregarVideoPesado();
    }

    private void carregarVideoPesado() {
        System.out.println("Carregando arquivo pesado do video premium: " + titulo);
    }

    @Override
    public void reproduzir(String nomeUsuario) {
        System.out.println("Reproduzindo o video premium '" + titulo + "' para " + nomeUsuario + ".");
    }
}

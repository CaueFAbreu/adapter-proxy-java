package questao4;

public class VideoProxy implements Video {
    private VideoPremium videoBase;
    private String titulo;
    private Usuario usuario;

    public VideoProxy(String titulo, Usuario usuario) {
        this.titulo = titulo;
        this.usuario = usuario;
    }

    @Override
    public void reproduzir(String nomeUsuario) {
        // Proxy: VideoProxy.
        // Objeto base: VideoPremium.
        // Cliente: classe Main, que solicita a reproducao do video.
        // O cliente nao acessa VideoPremium diretamente; ele passa pelo proxy.
        // O proxy possui a mesma interface do objeto base, ou seja, implementa Video.

        if (!usuario.isAssinantePremium()) {
            System.out.println("Acesso negado para " + nomeUsuario + ". Apenas assinantes premium podem assistir a este video.");
            return;
        }

        if (videoBase == null) {
            videoBase = new VideoPremium(titulo);
        }

        videoBase.reproduzir(nomeUsuario);
    }
}

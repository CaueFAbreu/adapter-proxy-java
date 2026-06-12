package questao4;

public class Main {
    public static void main(String[] args) {
        Usuario usuarioComum = new Usuario("Fabiola", false);
        Usuario usuarioPremium = new Usuario("Cauê", true);

        Video videoParaUsuarioComum = new VideoProxy("Aula exclusiva de Padroes de Projeto", usuarioComum);
        Video videoParaUsuarioPremium = new VideoProxy("Aula exclusiva de Padroes de Projeto", usuarioPremium);

        System.out.println("=== Tentativa de usuario comum ===");
        videoParaUsuarioComum.reproduzir(usuarioComum.getNome());

        System.out.println("\n=== Tentativa de usuario premium ===");
        videoParaUsuarioPremium.reproduzir(usuarioPremium.getNome());
    }
}

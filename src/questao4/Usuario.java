package questao4;

public class Usuario {
    private String nome;
    private boolean assinantePremium;

    public Usuario(String nome, boolean assinantePremium) {
        this.nome = nome;
        this.assinantePremium = assinantePremium;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAssinantePremium() {
        return assinantePremium;
    }
}

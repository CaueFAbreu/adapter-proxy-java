package questao1;

public class PatoDomestico implements Pato {
    @Override
    public void voar() {
        System.out.println("Pato domestico voando.");
    }

    @Override
    public void grasnar() {
        System.out.println("Pato domestico grasnando.");
    }
}

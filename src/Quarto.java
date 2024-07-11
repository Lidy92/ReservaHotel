public class Quarto {

private String tipo;
private int capacidade;

public Quarto(String tipo, int capacidade){
    this.tipo = tipo;
    this.capacidade = capacidade;
}

    public String getTipo() {
        return tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "tipo='" + tipo + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}

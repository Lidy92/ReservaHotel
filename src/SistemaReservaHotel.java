import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SistemaReservaHotel {

    public static void main(String[] args) {
        List<Quarto> quartosDisponiveis = new ArrayList<>(Arrays.asList(
                new Quarto("Quarto Simples", 2),
                new Quarto("Quarto Duplo", 4),
                new Quarto("Quarto Familia", 5)
        ));

        SistemaReservas sistemaReservas = new SistemaReservas(quartosDisponiveis);
        Usuario usuario1 = new Usuario("Alice");
        Usuario usuario2 = new Usuario("Vasco");
        Usuario usuario3 = new Usuario("Maria");

        sistemaReservas.adicionarObservador(usuario1);
        sistemaReservas.adicionarObservador(usuario2);
        sistemaReservas.adicionarObservador(usuario3);

        Reserva reserva1 = new Reserva.ReservaBuilder(1, "Alice", "Quarto Duplo")
                .setQuantidadePessoas(2)
                .setDataCheckIn("2024-07-10")
                .setDataCheckOut("2024-07-15")
                .setCafeDaManhaIncluido(true)
                .build();

        sistemaReservas.fazerReserva(reserva1);

        Reserva reserva2 = new Reserva.ReservaBuilder(2, "Vasco", "Quarto Familia")
                .setQuantidadePessoas(4)
                .setDataCheckIn("2024-07-10")
                .setDataCheckOut("2024-07-15")
                .setCafeDaManhaIncluido(false)
                .build();

        sistemaReservas.fazerReserva(reserva2);

        Reserva reserva3 = new Reserva.ReservaBuilder(3, "Charlie", "Quarto Simples")
                .setQuantidadePessoas(3)
                .setDataCheckIn("2024-07-10")
                .setDataCheckOut("2024-07-15")
                .setCafeDaManhaIncluido(true)
                .build();

        sistemaReservas.fazerReserva(reserva3);

        sistemaReservas.cancelarReserva(reserva1);
    }
}

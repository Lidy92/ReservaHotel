import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SistemaReservas {
    private List<Observador> observadores = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Quarto> quartosDisponiveis = new ArrayList<>();

    public SistemaReservas(List<Quarto> quartosDisponiveis) {
        this.quartosDisponiveis = quartosDisponiveis;
    }

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String mensagem) {
        for (Observador observador : observadores) {
            observador.atualizar(mensagem);
        }
    }

    public void fazerReserva(Reserva reserva) {
        System.out.println("Tentando fazer reserva para " + reserva.getNomeHospede());

        // Procurar um quarto disponível que atenda aos critérios da reserva
        Optional<Quarto> quartoOpt = quartosDisponiveis.stream()
                .filter(quarto -> quarto.getTipo().equals(reserva.getTipoQuarto()) &&
                        quarto.getCapacidade() >= reserva.getQuantidadePessoas())
                .findFirst();

        if (quartoOpt.isPresent()) {
            // Adicionar a reserva à lista de reservas e remover o quarto disponível
            reservas.add(reserva);
            quartosDisponiveis.remove(quartoOpt.get());
            notificarObservadores("Reserva confirmada para " + reserva.getNomeHospede() +
                    " no quarto " + reserva.getTipoQuarto());
        } else {
            notificarObservadores("Reserva falhou para " + reserva.getNomeHospede() +
                    ": tipo de quarto " + reserva.getTipoQuarto() + " não disponível ou capacidade insuficiente.");
        }
    }

    public List<Reserva> buscarReservas(String criterio, String valor) {
        List<Reserva> reservasEncontradas = new ArrayList<>();

        for (Reserva reserva : reservas) {
            if ("nome".equalsIgnoreCase(criterio) && reserva.getNomeHospede().equalsIgnoreCase(valor)) {
                reservasEncontradas.add(reserva);
            } else if ("quarto".equalsIgnoreCase(criterio) && reserva.getTipoQuarto().equalsIgnoreCase(valor)) {
                reservasEncontradas.add(reserva);
            }
        }

        return reservasEncontradas;
    }

    public void cancelarReserva(Reserva reserva) {
        System.out.println("Tentando cancelar reserva para " + reserva.getNomeHospede());

        // Remover a reserva da lista de reservas e adicionar o quarto de volta à lista de quartos disponíveis
        if (reservas.remove(reserva)) {
            quartosDisponiveis.add(new Quarto(reserva.getTipoQuarto(), reserva.getQuantidadePessoas()));
            notificarObservadores("Reserva cancelada para " + reserva.getNomeHospede());
        } else {
            notificarObservadores("Não foi possível cancelar a reserva para " + reserva.getNomeHospede() + ". Reserva não encontrada.");
        }
    }
}

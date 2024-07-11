import java.util.Objects;

class Reserva {
    private int idReserva;
    private String nomeHospede;
    private int quantidadePessoas;
    private String tipoQuarto;
    private String dataCheckIn;
    private String dataCheckOut;
    private boolean cafeDaManhaIncluido;

    private Reserva(ReservaBuilder builder) {
        this.idReserva = builder.idReserva;
        this.nomeHospede = builder.nomeHospede;
        this.quantidadePessoas = builder.quantidadePessoas;
        this.tipoQuarto = builder.tipoQuarto;
        this.cafeDaManhaIncluido = builder.cafeDaManhaIncluido;
        this.dataCheckIn = builder.dataCheckIn;
        this.dataCheckOut = builder.dataCheckOut;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public boolean isCafeDaManhaIncluido() {
        return cafeDaManhaIncluido;
    }

    public static class ReservaBuilder {
        private int idReserva;
        private String nomeHospede;
        private int quantidadePessoas;
        private String tipoQuarto;
        private String dataCheckIn;
        private String dataCheckOut;
        private boolean cafeDaManhaIncluido;

        public ReservaBuilder(int idReserva, String nomeHospede, String tipoQuarto) {
            this.idReserva = idReserva;
            this.nomeHospede = nomeHospede;
            this.tipoQuarto = tipoQuarto;
        }

        public ReservaBuilder setQuantidadePessoas(int quantidadePessoas) {
            this.quantidadePessoas = quantidadePessoas;
            return this;
        }

        public ReservaBuilder setDataCheckIn(String dataCheckIn) {
            this.dataCheckIn = dataCheckIn;
            return this;
        }

        public ReservaBuilder setDataCheckOut(String dataCheckOut) {
            this.dataCheckOut = dataCheckOut;
            return this;
        }

        public ReservaBuilder setCafeDaManhaIncluido(boolean cafeDaManhaIncluido) {
            this.cafeDaManhaIncluido = cafeDaManhaIncluido;
            return this;
        }

        public Reserva build() {
            return new Reserva(this);
        }
    }


    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", nomeHospede='" + nomeHospede + '\'' +
                ", tipoQuarto='" + tipoQuarto + '\'' +
                ", dataCheckIn='" + dataCheckIn + '\'' +
                ", dataCheckOut='" + dataCheckOut + '\'' +
                ", cafeDaManhaIncluido=" + cafeDaManhaIncluido +
                ", quantidadePessoas=" + quantidadePessoas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return quantidadePessoas == reserva.quantidadePessoas &&
                Objects.equals(nomeHospede, reserva.nomeHospede) &&
                Objects.equals(tipoQuarto, reserva.tipoQuarto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeHospede, tipoQuarto, quantidadePessoas);
    }
}



public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    // Construtor completo
    public Reserva(String nomeHospede, String tipoQuarto,
                   int numeroDias, double valorDiaria) {

        this.setNomeHospede(nomeHospede);
        this.setTipoQuarto(tipoQuarto);
        this.setNumeroDias(numeroDias);
        this.setValorDiaria(valorDiaria);
    }

    // Getters e setters
    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        if (nomeHospede == null || nomeHospede.isBlank()) {
            throw new IllegalArgumentException(
                    "O nome do hospede nao pode ser vazio."
            );
        }

        this.nomeHospede = nomeHospede.trim();
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        if (tipoQuarto == null || tipoQuarto.isBlank()) {
            throw new IllegalArgumentException(
                    "O tipo de quarto nao pode ser vazio."
            );
        }

        this.tipoQuarto = tipoQuarto.trim();
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        if (numeroDias < 1) {
            throw new IllegalArgumentException(
                    "A estadia deve ter pelo menos 1 dia."
            );
        }

        this.numeroDias = numeroDias;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        if (!Double.isFinite(valorDiaria)
                || valorDiaria <= 0) {
            throw new IllegalArgumentException(
                    "O valor da diaria deve ser maior que zero."
            );
        }

        this.valorDiaria = valorDiaria;
    }

    // Regra de negocio
    public double calcularValorTotal() {
        return numeroDias * valorDiaria;
    }

    // Representacao textual da reserva
    @Override
    public String toString() {
        return "Hospede: " + nomeHospede
                + "\nTipo de quarto: " + tipoQuarto
                + "\nDias de estadia: " + numeroDias
                + "\nValor da diaria: R$ "
                + String.format("%.2f", valorDiaria)
                + "\nValor total: R$ "
                + String.format("%.2f", calcularValorTotal());
    }
}

package modelo;

public class Apartamento extends Financiamento {
    private double valorImovelApt;
    private int prazoFinanciamentoApt;
    private double taxaJurosAnualApt;

    private double NumeroVagasGaragem;
    private double NumeroDoAndar;

    //getter p/atributos privados

    public double getValorImovel() {
        return valorImovelApt;
    }

    public int getprazoFinanciamento() {
        return prazoFinanciamentoApt;
    }

    public double gettaxaJurosAnual() {
        return taxaJurosAnualApt;
    }


    public Apartamento(double valorImovelApt, int prazoFinanciamentoApt, double TaxaJurosAnualApt, double NumeroVagasGaragem, double NumeroDoAndar) {
        super(valorImovelApt, prazoFinanciamentoApt, TaxaJurosAnualApt);
        this.NumeroVagasGaragem = NumeroVagasGaragem;
        this.NumeroDoAndar = NumeroDoAndar;
    }

    public double calcularPagamentoMensal() {
        double valorImovel = super.getValorImovel();
        double valorPrazo = super.getprazoFinanciamento();
        double valorTaxa = super.gettaxaJurosAnual();
        double TaxaMensal = valorTaxa/12;
        double Meses = valorPrazo*12;

        return (valorImovel) * Math.pow((1 + TaxaMensal), Meses) / Math.pow((1 + TaxaMensal), (Meses - 1)) / Meses;
    }

    public double calcularPagamentoTotal(){
        return ((this.calcularPagamentoMensal()) * (super.getprazoFinanciamento() * 12));
    }


//    public void MostrarNaTela() {
//        System.out.println("VALOR FINANCIAMENTO APARTAMENTO: " + calcularPagamentoMensal());
//    }
}





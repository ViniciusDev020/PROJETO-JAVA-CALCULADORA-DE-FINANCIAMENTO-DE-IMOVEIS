package modelo;

public class Terreno extends Financiamento{

    private double valorImovelTer;
    private int prazoFinanciamentoTer;
    private double taxaJurosAnualTer;
    
    private String TipoDeZona;

    public double getValorImovel(){
        return valorImovelTer;
    }

    public double getPrazoFinanciamento(){
        return prazoFinanciamentoTer;
    }

    public double getTaxaJurosAnual(){
        return taxaJurosAnualTer;
    }


    public Terreno(double valorImovelTer, int prazoFinanciamentoTer, double TaxaJurosAnualTer, String TipoDeZona) {
        super(valorImovelTer, prazoFinanciamentoTer, TaxaJurosAnualTer);
        this.TipoDeZona = TipoDeZona;
    }

    public double calcularPagamentoMensalTer(){
        return (super.getValorImovel() / (super.getprazoFinanciamento()*12)) * (1 + (super.gettaxaJurosAnual() / 12));
    }

    public double calcularPagamentoMensal() {
        double Mensal = this.calcularPagamentoMensalTer();

        double Acrescimo = Mensal / (Mensal * 2);

        return (Mensal + Acrescimo) * 1.02;

    }

    public double calcularPagamentoTotal(){
        return ((this.calcularPagamentoMensalTer()) * (super.getprazoFinanciamento() * 12));
    }


    public void MostrarNaTela() {
        System.out.println("VALOR FINANCIAMENTO TERRENO: " + calcularPagamentoMensalTer());
    }
}

package modelo;

public abstract class Financiamento{

    //atributos
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    private double desconto;

    //getter p/atributos privados

    public double getValorImovel() {
        return valorImovel;
    }

    public int getprazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double gettaxaJurosAnual() {
        return taxaJurosAnual;
    }


    //construtor/método

    public Financiamento(double valorDoImovel, int prazoDoFinanciamento, double taxaDoJurosAnual){
        this.valorImovel = valorDoImovel;
        this.prazoFinanciamento = prazoDoFinanciamento;
        this.taxaJurosAnual = taxaDoJurosAnual;
    }



    //métodos
    public abstract double calcularPagamentoMensal();

    public abstract double calcularPagamentoTotal();

    //mostrar os dados do financiamento na tela
//    public abstract void MostrarNaTela();

}

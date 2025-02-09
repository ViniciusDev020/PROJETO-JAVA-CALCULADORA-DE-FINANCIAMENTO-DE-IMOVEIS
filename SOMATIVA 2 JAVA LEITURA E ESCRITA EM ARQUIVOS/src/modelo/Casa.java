package modelo;

import util.InterfaceUsuario;

import java.util.Scanner;

public class Casa extends Financiamento {

    private double valorImovelCasa;
    private int prazoFinanciamentoCasa;
    private double taxaJurosAnualCasa;
    private double Acrescimo;

    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    //getter p/atributos privados

    public double getValorImovel() {
        return valorImovelCasa;
    }

    public int getprazoFinanciamento() {
        return prazoFinanciamentoCasa;
    }

    public double gettaxaJurosAnual() {
        return taxaJurosAnualCasa;
    }

    public double getTamanhoAreaConstruida() {
        return tamanhoAreaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    public double getAcrescimo() {
        return Acrescimo;
    }


    public Casa(double valorImovelCasa, int prazoFinanciamentoCasa, double TaxaJurosAnualCasa, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovelCasa, prazoFinanciamentoCasa, TaxaJurosAnualCasa);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public void ValorAcrescimo(double ValorAcrescimo, double ValorJuros){
        try {
            if (ValorAcrescimo > ValorJuros) {
                throw new AcrescimoMaiorQueJurosException("O valor do acréscimo deve ser igual ou menor do que o valor dos juros!");
            }
        }
        catch(AcrescimoMaiorQueJurosException e){
            System.out.println(e.getMessage());
        }

    }

    public double calcularPagamentoMensal(){
        //valor juros
        double ImovelParcelaComJuros =  (super.getValorImovel() / (super.getprazoFinanciamento()*12)) * (1 + (super.gettaxaJurosAnual() / 12));
        double ImovelParcelaSemJuros = (super.getValorImovel() / (super.getprazoFinanciamento()*12));
        double Juros = ImovelParcelaComJuros - ImovelParcelaSemJuros;
        double ValorAcrescimo = 31; //Valor do acréscimo maior do que o valor dos juros, apresentará o erro AcrescimoMaiorQueJurosException.

        try {
            ValorAcrescimo(ValorAcrescimo, Juros);
            if (ValorAcrescimo > Juros) {
                throw new AcrescimoMaiorQueJurosException("O valor do acréscimo deve ser igual ou menor do que o valor dos juros!");
            }
        }
        catch(AcrescimoMaiorQueJurosException e){
           ValorAcrescimo = Juros;
        }

        return ImovelParcelaComJuros + ValorAcrescimo;

    }

    public double calcularPagamentoTotal(){
        return ((this.calcularPagamentoMensal()) * (super.getprazoFinanciamento() * 12));
    }



//    public void MostrarNaTela() {
//        System.out.println("VALOR FINANCIAMENTO CASA: " + calcularPagamentoMensal());
//    }


}

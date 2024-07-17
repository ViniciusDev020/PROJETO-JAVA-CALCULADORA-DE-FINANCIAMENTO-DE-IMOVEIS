package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;

import java.util.ArrayList;
import java.util.List;


public class Main{

    public static void main(String[] args){
        System.out.println("== Bem vindo ao Sistema de Simulação de financiamentos imobiliários de um grande banco ==");
        System.out.println("== Informe os valores solicitados para obter o cálculo do financiamento dos imóveis ==");

            try {
                ArrayList<Financiamento> listaDeFinanciamentos = new ArrayList<Financiamento>();

                //Solicita os valores do imóvel, prazo financiamento e taxa de juros quatro vezes, para 5 imóveis diferentes.
                //Por enquanto os valores são iguais para facilitar os testes.

                //Solicita os valores do imóvel, prazo financiamento e taxa de juros quatro vezes, para quatro imóveis diferentes.
                InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
                System.out.println("== PRIMEIRO IMÓVEL CASA ==");
                double valorImovel = interfaceUsuario.InformeValorImovel();
                int prazoFinanciamento = interfaceUsuario.InformePrazoFinanciamento();
                double taxaJuros = interfaceUsuario.InformeTaxaJuros();


                double valorImovelDois = 500000;
                int prazoFinanciamentoDois = 10;
                double taxaJurosDois = 0.1;


                double valorImovelTres = 500000;
                int prazoFinanciamentoTres = 10;
                double taxaJurosTres = 0.1;


                double valorImovelQuatro = 500000;
                int prazoFinanciamentoQuatro = 10;
                double taxaJurosQuatro = 0.1;


                double valorImovelCinco = 500000;
                int prazoFinanciamentoCinco = 10;
                double taxaJurosCinco = 0.1;


                // Atributos Casa
                double tamanhoAreaConstruida = 0;
                double tamanhoTerreno = 0;

                //Atributos Apartamento
                double NumeroVagasGaragem = 0;
                double NumeroDoAndar = 0;

                //Atributos Terreno
                String TipoDeZona = "Rural";

                //total financiamento

                //adiciona cada um dos quatro objetos instanciados na lista, na seguinte ordem: 0, 1, 2 e 3;
                //por enquanto os mesmos valores para deixar os testes mais rápidos, sem precisar digitar 5 vezes.


                listaDeFinanciamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJuros,tamanhoAreaConstruida, tamanhoTerreno));
                listaDeFinanciamentos.add(new Casa(valorImovelDois, prazoFinanciamentoDois, taxaJurosDois,tamanhoAreaConstruida, tamanhoTerreno));
                listaDeFinanciamentos.add(new Apartamento(valorImovelTres, prazoFinanciamentoTres, taxaJurosTres, NumeroVagasGaragem, NumeroDoAndar));
                listaDeFinanciamentos.add(new Apartamento(valorImovelQuatro, prazoFinanciamentoQuatro, taxaJurosQuatro, NumeroVagasGaragem, NumeroDoAndar));
                listaDeFinanciamentos.add(new Terreno(valorImovelCinco, prazoFinanciamentoCinco, taxaJurosCinco, TipoDeZona));

                //retorna os valores dos cinco financiamentos
                double f1 = listaDeFinanciamentos.get(0).calcularPagamentoMensal();
                double f2 = listaDeFinanciamentos.get(1).calcularPagamentoMensal();
                double f3 = listaDeFinanciamentos.get(2).calcularPagamentoMensal();
                double f4 = listaDeFinanciamentos.get(3).calcularPagamentoMensal();
                double f5 = listaDeFinanciamentos.get(4).calcularPagamentoMensal();

                double fa = listaDeFinanciamentos.get(0).calcularPagamentoTotal();
                double fb = listaDeFinanciamentos.get(1).calcularPagamentoTotal();
                double fc = listaDeFinanciamentos.get(2).calcularPagamentoTotal();
                double fd = listaDeFinanciamentos.get(3).calcularPagamentoTotal();
                double fe = listaDeFinanciamentos.get(4).calcularPagamentoTotal();

                //retorna os valores dos cinco imóveis
                double f6 = listaDeFinanciamentos.get(0).getValorImovel();
                double f7 = listaDeFinanciamentos.get(1).getValorImovel();
                double f8 = listaDeFinanciamentos.get(2).getValorImovel();
                double f9 = listaDeFinanciamentos.get(3).getValorImovel();
                double f10 = listaDeFinanciamentos.get(4).getValorImovel();

                double calculoImovel = valorImovel + valorImovelDois + valorImovelTres + valorImovelQuatro + valorImovelCinco;

                FileWriter escritor = null;

                try {
                    escritor = new FileWriter("DadosFinanciamentos.txt");
                    ArrayList<String> Dados = new ArrayList<String>();

                    String FinanciamentoUm = "Financiamento 1 Casa: " + "\n" + "VALOR MENSAL FINANCIAMENTO CASA: " + f1 + "\n" + "VALOR FINANCIAMENTO TOTAL CASA: "+ fa + "\n" + "Valor imóvel Casa: " + valorImovel;
                    String FinanciamentoDois = "Financiamento 2 Casa: " + "\n" + "VALOR MENSAL FINANCIAMENTO CASA: " + f2 + "\n" + "VALOR FINANCIAMENTO TOTAL CASA: "+ fb + "\n" + "Valor imóvel Casa: " + valorImovelDois;
                    String FinanciamentoTres = "Financiamento 3 Apartamento: " + "\n" + "VALOR MENSAL FINANCIAMENTO APARTAMENTO: " + f3 + "\n" + "VALOR FINANCIAMENTO TOTAL APARTAMENTO: " + fc + "\n" + "Valor imóvel Apartamento: " + valorImovelTres;
                    String FinanciamentoQuatro = "Financiamento 4 Apartamento: " + "\n" + "VALOR MENSAL FINANCIAMENTO APARTAMENTO: " + f4 + "\n" + "VALOR FINANCIAMENTO TOTAL APARTAMENTO: "+ fd + "\n"  + "Valor imóvel Apartamento: " + valorImovelQuatro;
                    String FinanciamentoCinco = "Financiamento 5 Terreno: " + "\n" + "VALOR MENSAL FINANCIAMENTO TERRENO: " + f5 + f4 + "\n" + "VALOR FINANCIAMENTO TOTAL TERRENO: "+ fe + "\n" +"Valor imóvel Terreno: " + valorImovelCinco;
                    String ValoresTotais = "== VALORES TOTAIS ========" + "\n" + "Valor total de todos os imóveis: R$" + calculoImovel + "\n" + "Valor total de todos os financiamentos: R$" + Math.round(fa + fb + fc + fd + fe);

                    Dados.add(FinanciamentoUm);
                    Dados.add(FinanciamentoDois);
                    Dados.add(FinanciamentoTres);
                    Dados.add(FinanciamentoQuatro);
                    Dados.add(FinanciamentoCinco);
                    Dados.add(ValoresTotais);

                    for(int i = 0; i < Dados.size(); i++){
                        escritor.write("========" + Dados.get(i) + "\n");
                        System.out.println("========" + Dados.get(i));
                    }

                    escritor.close();
                }
                catch(FileNotFoundException e){
                    System.out.println("O arquivo não foi encontrado");
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Valor inválido, informe apenas números!");
            }


    }


}

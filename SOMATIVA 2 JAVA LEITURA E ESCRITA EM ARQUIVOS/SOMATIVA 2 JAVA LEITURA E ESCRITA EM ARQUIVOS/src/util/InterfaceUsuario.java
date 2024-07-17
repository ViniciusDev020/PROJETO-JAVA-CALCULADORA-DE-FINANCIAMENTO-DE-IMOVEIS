package util;

import modelo.ValorInvalidoException;

import java.util.Scanner;

public class InterfaceUsuario{
//    //Métodos de input para pedir os valores ao usuário
    Scanner Input = new Scanner(System.in);

    public double InformeValorImovel (){

        System.out.println("Informe o valor do imóvel");
        double ValorIm = Input.nextDouble();
    try {
        if (ValorIm < 0) {
            throw new ValorInvalidoException("Valor inválido. Informe um valor válido!");
        }
    }
    catch (ValorInvalidoException e) {
        System.out.println(e.getMessage());
    }

    while(ValorIm < 0){
        System.out.println("Informe o valor do imóvel");
        ValorIm = Input.nextDouble();
    }
        return ValorIm;
    }


    public int InformePrazoFinanciamento(){
        System.out.println("Informe o prazo");
        int PrazoF = Input.nextInt();

        try {
            if (PrazoF < 0) {
                throw new ValorInvalidoException("Valor inválido. Informe um valor válido!");
            }
        }
        catch (ValorInvalidoException e) {
            System.out.println(e.getMessage());
        }

        while(PrazoF < 0){
            System.out.println("Informe o prazo");
            PrazoF = Input.nextInt();
        }
        return PrazoF;
    }


    public  double InformeTaxaJuros(){
        System.out.println("Informe o valor da taxa");
        double TaxaJ = Input.nextDouble();

        try {
            if (TaxaJ < 0 || TaxaJ > 100) {
                throw new ValorInvalidoException("Valor inválido. Informe um valor válido!");
            }
        }
        catch (ValorInvalidoException e) {
            System.out.println(e.getMessage());
        }


        while(TaxaJ < 0 || TaxaJ > 100){
            System.out.println("Informe o valor da taxa");
            TaxaJ = Input.nextDouble();
        }
        return TaxaJ;

    }

    public double InformeDesconto(){
        System.out.println("Informe o valor do desconto");
        double Desconto = Input.nextDouble();

        return Desconto;
    }




    }





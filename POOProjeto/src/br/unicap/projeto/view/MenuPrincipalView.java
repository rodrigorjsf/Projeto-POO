/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.projeto.view;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pedro Oliveira
 */
public class MenuPrincipalView {

    private Scanner scanf;

	public void menuPrincipal() throws IOException {
        scanf = new Scanner(System.in);
        int voto = 0;
        while(voto != 3){
            System.out.println("Minha Academia\n");
            System.out.println("1 - Fichas");
            System.out.println("2 - Exercicios");
            System.out.println("3 - sair");
            System.out.print("\ndigite aqui : ");
            voto = scanf.nextInt();
            while(voto < 1 || voto > 3){
                System.out.println("opcao invalida");
                System.out.print("digite numero dentro da faixa permitida [1-3] : ");
                voto = scanf.nextInt();
            }
            if(voto == 1){
                FichaView fView = new FichaView();
                fView.menuFicha();
            } else if (voto == 2){
                System.out.println("essa opcao ainda vai ser implementada ");
            } else {
                System.out.println("obrigado por usar esse programa");
            }
        }
    }
}

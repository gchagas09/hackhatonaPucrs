package App.Views;

import java.util.Scanner;

/*
Classe que faz a validação de entradas de dados numérico, para garantir que não sejam digitados caracteres não numericos.
*/

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int nextInt() {
        int number;
        try {
            number = Integer.valueOf(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("<INFORME UM NÚMERO INTEIRO>");
            number = nextInt();
        }
        return number;
    }

    public double nextDouble() {
        double number;
        try {
            number = Double.valueOf(this.scanner.nextLine());
        } catch (Exception e) {
            System.out.println("<INFORME UM NÚMERO COM VÍRGULA>");
            number = nextDouble();

        }
        return number;
    }
}

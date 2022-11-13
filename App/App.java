package App;

import App.Classes.Aluno;
import App.Views.Input;

public class App {
    public static void main(String[] args) {

        int numero;

        Input in = new Input();

        System.out.println("Insira um número inteiro: ");

        numero = in.nextInt();

        System.out.println(numero);

    }
}
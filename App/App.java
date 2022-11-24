package App;

import App.Classes.*;
import App.Views.Input;
import App.Views.ViewTime;

public class App {
    public static void main(String[] args) {
        Hackatona hackatona = new Hackatona();
        Input in = new Input();

        System.out.println("Olá, bem vindo ao Sistema de cadastro da Hackatona 2022/2 da PUCRS");
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Cadastro\n2 - Login");
    }
}
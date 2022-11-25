package App;

import App.Classes.*;
import App.Views.*;
public class App {
    public static void main(String[] args) {
        Hackatona hackatona = new Hackatona();
        ViewAluno viewAluno = new ViewAluno(hackatona);
        ViewProfessor viewProfessor = new ViewProfessor(hackatona);
        ViewTime viewTime = new ViewTime(hackatona);
        Input in = new Input();

       int opt;
        System.out.println("BEM VINDO AO SISTEMA DA HACKATONA 2022 DA PUCRS");
        do {
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Cadastro\n2 - Login\n0 - Encerrar");
            System.out.print("DIGITE SUA OPÇÃO: ");
            opt=in.nextInt();
            switch (opt) {
                case 1:
                    do {
                        System.out.println("Você é aluno ou professor?");
                        System.out.println("1 - ALUNO\n2 - PROFESSOR\n0 - Encerrar");
                        System.out.print("DIGITE SUA OPÇÃO: ");
                        opt = in.nextInt();
                        if(opt==1){
                            viewAluno.autocadastro();
                        }else if(opt==2){
                            viewProfessor.autocadastro();
                        }else if(opt ==0){
                           System.out.println("\nREDIRECIONANDO");
                        }else{
                            System.out.println("<OPÇÃO INVÁLIDA>");
                        }
                    } while (opt<0 || opt>2);
                    for(int i=0; i<100; i++){
                        System.out.println("\n\n");
                    }                    
                    break;
                case 2:
                    do {
                        System.out.println("Você é aluno ou professor?");
                        System.out.println("1 - ALUNO\n2 - PROFESSOR\n3 - Encerrar");
                        System.out.print("DIGITE SUA OPÇÃO: ");
                        opt = in.nextInt();
                        if(opt==1){
                            viewAluno.loginAluno();
                        }else if(opt==2){
                            viewProfessor.loginProfessor();
                        }else{
                            System.out.println("<OPÇÃO INVÁLIDA>");
                        }
                    } while (opt!=0);
                    for(int i=0; i<100; i++){
                        System.out.println("\n\n");
                    }                    
                    break;
                default:
                    opt=100;
                    break;
            }
        } while (opt!=0);
    }
}
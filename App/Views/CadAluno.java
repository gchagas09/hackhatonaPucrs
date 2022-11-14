package App.Views;
import App.Classes.*;
public class CadAluno {
    private Aluno aluno;
    private Input in;

    public Aluno autocadastro(){
        String nome, email;
        int matricula, opt;

        System.out.println("Olá, como vai? Estou aqui para ajuda-lo");
        System.out.println("Primeiro de tudo, vamos a um cadastro rápido");
        do{
            do {
                System.out.print("Qual seu nome? ");
                nome = in.nextLine();
            } while (nome.length() <= 0);
            do {
                System.out.print("Qual seu email? ");
                email = in.nextLine();
            } while (email.length() <= 0);
            do {
                System.out.print("Qual sua matricula? ");
                matricula = in.nextInt();
            } while (matricula <= 0);

            System.out.println("Nome: "+nome+"\nEmail: "+email+"\nMatricula: "+matricula);
            System.out.println("Você confirma as informações acima?\nDigite 0 para SIM\nDigite outro número para NÃO");
            System.out.println("Sua resposta: ");
            opt = in.nextInt();
        }while(opt!=0);

        return this.aluno = new Aluno(nome, email, matricula);
    }
    public Aluno cadastro(){
        String nome, email;
        int matricula, opt;

        System.out.println("Olá professor, como vai? Estou aqui para ajuda-lo");
        System.out.println("Primeiro de tudo, vamos a um cadastro rápido");
        do{
            do {
                System.out.print("Qual o nome do aluno? ");
                nome = in.nextLine();
            } while (nome.length() <= 0);
            do {
                System.out.print("Qual o email do aluno? ");
                email = in.nextLine();
            } while (email.length() <= 0);
            do {
                System.out.print("Qual a matricula do aluno? ");
                matricula = in.nextInt();
            } while (matricula <= 0);

            System.out.println("Nome: "+nome+"\nEmail: "+email+"\nMatricula: "+matricula);
            System.out.println("Você confirma as informações acima?\nDigite 0 para SIM\nDigite outro número para NÃO");
            System.out.println("Sua resposta: ");
            opt = in.nextInt();
        }while(opt!=0);

        return this.aluno = new Aluno(nome, email, matricula);
    }
}

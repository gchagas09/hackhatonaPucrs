package App.Views;
import App.Classes.*;

/**
 * View de ocadastro do professor;
 */
public class CadProfessor {
    private Professor professor;
    private Input in;
    
    public Professor autocadastro() {
        String nome, email;
        int idFuncional, opt;

        System.out.println("Olá professor(a), como vai? Estou aqui para ajuda-lo");
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
                System.out.print("Qual sua ID funcional? ");
                idFuncional = in.nextInt();
            } while (idFuncional <= 0);

            System.out.println("Nome: "+nome+"\nEmail: "+email+"\nID Funcional: "+idFuncional);
            System.out.println("Você confirma as informações acima?\nDigite 0 para SIM\nDigite outro número para NÃO");
            System.out.println("Sua resposta: ");
            opt = in.nextInt();
        }while(opt!=0);

        return this.professor = new Professor(nome, email, idFuncional);
    }
}

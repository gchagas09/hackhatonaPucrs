package App.Views;

/**
 * View de ocadastro do professor;
 */
public class CadProfessor {

    private String nome, email;
    private int idFuncional;
    Input in = new Input();

    public void autocadastro() {
        System.out.println("Olá professor(a), como vai? Estou aqui para ajuda-lo");
        System.out.println("Primeiro de tudo, vamos a um cadastro rápido");
        do {
            System.out.print("Qual seu nome? ");
            this.nome = in.nextLine();
        } while (this.nome.length() <= 0);
        do {
            System.out.print("Qual seu email? ");
            this.nome = in.nextLine();
        } while (this.email.length() <= 0);
        do {
            System.out.print("Qual sua ID funcional? ");
        } while (this.idFuncional <= 0);

    }
}

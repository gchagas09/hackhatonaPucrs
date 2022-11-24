package App.Views;

import App.Classes.*;

public class ViewAluno {
    private Hackatona hackatona;
    private Input in;

    public ViewAluno(Hackatona hackatona) {
        this.hackatona = hackatona;
    }

    public Aluno autocadastro() {
        Aluno aluno;
        String nome, email;
        int matricula, opt;

        System.out.println("Olá, como vai? Estou aqui para ajuda-lo");
        System.out.println("Primeiro de tudo, vamos a um cadastro rápido");
        do {
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

            System.out.println("Nome: " + nome + "\nEmail: " + email + "\nMatricula: " + matricula);
            System.out.println("Você confirma as informações acima?\nDigite 0 para SIM\nDigite outro número para NÃO");
            System.out.println("Sua resposta: ");
            opt = in.nextInt();
        } while (opt != 0);
        aluno = new Aluno(nome, email, matricula);
        return aluno;
    }

    public boolean alunoLogin(Aluno[] alunos, String email, int matricula) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {
                if (alunos[i].getEmail().endsWith(email) && alunos[i].getMatricula() == matricula) {
                    return true;
                }
            }
        }
        return false;
    }

    public void telaIncial(Aluno aluno) {
        System.out.println("Olá, " + aluno.getNome());
        if (!aluno.getTime().equalsIgnoreCase("<ALUNO SEM TIME>")) {

        }
    }
}

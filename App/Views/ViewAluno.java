package App.Views;

import App.Classes.*;

public class ViewAluno {
    private Hackatona hackatona;
    private Input in;

    public ViewAluno(Hackatona hackatona) {
        this.hackatona = hackatona;
    }

    public void autocadastro() {
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
        this.hackatona.createAluno(aluno);
    }

    public boolean alunoLogin(String email, int matricula) {
        for (int i = 0; i < this.hackatona.alunos.length; i++) {
            if (this.hackatona.alunos[i] != null) {
                if (this.hackatona.alunos[i].getEmail().endsWith(email) && this.hackatona.alunos[i].getMatricula() == matricula) {
                    return true;
                }
            }
        }
        return false;
    }

    public void telaIncial(Aluno aluno) {
        String time="";
        int opt;

        System.out.println("Olá, " + aluno.getNome());
        if (!aluno.getTime().equalsIgnoreCase("<ALUNO SEM TIME>")) {
            for(int i=0; i<this.hackatona.time.length; i++){
                if(this.hackatona.time[i].getNome().equalsIgnoreCase(aluno.getTime())){
                    time = this.hackatona.time[i].toString();
                }
            }
        }else{
            time = "<ALUNO SEM TIME>";
        }
        System.out.println(time);
        do {
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Criar time\n2 - Entrar em um time\n3 - Sair de um time\n0 - Fazer logoff");
            opt = this.in.nextInt();

            switch (opt) {
                case 1:
                    alunoCadastraTime(aluno);
                    break;
                case 2:
                    alunoEntraTime(aluno);
                    break;
                case 3:
                    alunoSaiTime(aluno);
                    break;
            }
        } while (opt!=0);
    }

    public void alunoCadastraTime(Aluno aluno){
        String nome;
        boolean timeCriado=false;
        boolean insereAluno=false;
        int opt;
    
        Time time;
        if(this.hackatona.getTimesCadastrados()<15){
        do {
            System.out.print("Qual o nome deste time? ");
            nome = this.in.nextLine();
            System.out.println("Seu time se chamará "+ nome);
            System.out.print("Você tem certeza? Digite 0 para confirmar e qualquer outro número para mudar o nome");
            opt = in.nextInt();
            if(hackatona.timeExiste(nome)){
                opt = 100;
                System.out.println("JÁ EXISTE UM TIME COM ESTE NOME!!");
            }
        } while (opt!=0);
        time = new Time(nome);
        timeCriado = this.hackatona.createTime(time);
        insereAluno = this.hackatona.insereAlunoTime(nome, aluno);
        if(timeCriado && insereAluno){
            System.out.println("TIME CRIADO COM SUCESSO!!");
        }
        }
            
    }
    public void alunoEntraTime(Aluno aluno){
        String nomeTime;
        int opt =0;
        do {
            System.out.println("Qual o time em que você deseja entrar? ");
            nomeTime = this.in.nextLine();
            while(!this.hackatona.timeExiste(nomeTime)){
                System.out.println("Esse time não exite. Insira o nome de um time válido ");
                nomeTime = this.in.nextLine();
            }
            System.out.println(this.hackatona.readIntegrantesTime(nomeTime));            
            System.out.println("Você deseja entrar no time acima? Digite 0 para confirmar ou qualquer outro número para sair");
            
            opt=this.in.nextInt();
            if(opt==0){
                if(this.hackatona.insereAlunoTime(nomeTime, aluno)){
                    System.out.println("VOCÊ ENTROU NO TIME!!");
                    opt=1;
                }else{
                    System.out.println("O TIME ESTÁ COM A CAPACIDADE MÁXIMA!!");
                }
            }
        } while (opt==0);
    }
    public void alunoSaiTime(Aluno aluno){
        if(this.hackatona.removeAlunoTime(aluno)){
            System.out.println("ALUNO REMOVIDO DO TIME!!");
        }else{
            System.out.println("NÃO FOI POSSÍVEL REMOVER VOCÊ DO TIME");
        }
    }
}

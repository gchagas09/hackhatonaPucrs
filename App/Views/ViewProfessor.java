package App.Views;

import App.Classes.*;

/**
 * View de cadastro do professor;
 */
public class ViewProfessor {
    private Hackatona hackatona;
    private Input in;

    public ViewProfessor(Hackatona hackatona) {
        this.hackatona = hackatona;
    }

    public Professor autocadastro() {
        Professor professor;
        String nome, email;
        int idFuncional, opt;

        System.out.println("Olá professor(a), como vai? Estou aqui para ajuda-lo");
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
                System.out.print("Qual sua ID funcional? ");
                idFuncional = in.nextInt();
            } while (idFuncional <= 0);

            System.out.println("Nome: " + nome + "\nEmail: " + email + "\nID Funcional: " + idFuncional);
            System.out.println("Você confirma as informações acima?\nDigite 0 para SIM\nDigite outro número para NÃO");
            System.out.println("Sua resposta: ");
            opt = in.nextInt();
        } while (opt != 0);
        professor = new Professor(nome, email, idFuncional);
        return professor;
    }

    public boolean profLogin(Professor[] professores, String email, int matricula) {
        for (int i = 0; i < professores.length; i++) {
            if (professores[i] != null) {
                if (professores[i].getEmail().endsWith(email) && professores[i].getIdFuncional() == matricula) {
                    return true;
                }
            }
        }
        return false;
    }

    public void consultarTime(){  
        String nomeTime;
        System.out.println("Digite o nome do time que você deseja Consultar? ");
        nomeTime = this.in.nextLine();
        System.out.println(this.hackatona.consultarTime(nomeTime));
    }

    public void consultarAluno(){
        int opt;
        Aluno aluno = null;
        
        do {
            System.out.println("Como você deseja consultar o aluno em questão?\n1 - Informar matrícula\n2 - Informar email");
            opt= in.nextInt();
        } while (opt<1 || opt>2);
        if(opt==1){
            int matricula;
            System.out.print("Informe a matrícula do aluno: ");
            matricula = in.nextInt();
            while(matricula<=0){
                System.out.println("DIGITE UM NÚMERO DE MATRÍCULA VÁLIDO!!");
                in.nextInt();
            }
            aluno = this.hackatona.readAlunoMatricula(matricula);
        }else if(opt==2){
            String email;
            System.out.print("Informe o email do aluno: ");
            email = this.in.nextLine();
            aluno = this.hackatona.readAlunoEmail(email);
        }
        if(aluno==null){
            System.out.println("ALUNO NÃO ENCONTRADO");
        }       
    }
    public void inserirNotas(){
        String nomeTime;
        System.out.println("Digite o nome do time que você deseja INSERIR NOTA: ");
        nomeTime = this.in.nextLine();
        if(this.hackatona.timeExiste(nomeTime)){
           System.out.println("Time localizado");
           System.out.println("Insira a nota do time: ");
           if(this.hackatona.insereNotaTime(nomeTime, in.nextDouble())){
            System.out.println("NOTA INSERIDA COM SUCESSO!!");
           }else{
            System.out.println("NÃO FOI POSSÍVEL INSERIR A NOTA!!");
           }
        }else{
            System.out.println("TIME NÃO EXISTE");
        }
    }
}

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
        this.in = new Input();
    }

    public void autocadastro() {
        Professor professor;
        String nome, email;
        int idFuncional, opt;
        boolean cadastrado;
        if (this.hackatona.getProfsCadastrados() < 10) {
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
                System.out.println(
                        "Você confirma as informações acima?\nDigite 0 para SIM\nDigite outro número para NÃO");
                System.out.print("Sua resposta: ");
                opt = in.nextInt();
            } while (opt != 0);
            professor = new Professor(nome, email, idFuncional);
            if (this.hackatona.createProfessor(professor)) {
                System.out.println("CADASTRADO COM SUCESSO!!");
            } else {
                System.out.println("JÁ EXISTE UM PROFESSOR COM ESSA ID FUNCIONAL!!!");
            }
        } else {
            System.out.println("QUANTIDADE MÁXIMA DE PROFESSORES ATINGIDA!!");
        }
    }

    public void loginProfessor() {
        String email;
        int idFuncional;
        boolean login;
        do {
            System.out.print("Professor(a), insira seu email: ");
            email = this.in.nextLine();
            System.out.print("Insira seu ID Funcional: ");
            idFuncional = this.in.nextInt();
            if (this.hackatona.profLogin(email, idFuncional)) {
                telaIncial(this.hackatona.readProfessorId(idFuncional));
                login = true;
            } else {
                System.out.println("DADOS NÃO LOCALIZADOS!!");
                login = false;
            }
        } while (!login);
    }

    public void telaIncial(Professor prof) {
        int opt;
        System.out.println("Olá, professor(a) " + prof.getNome());
        System.out.println("DADOS HACKATONA: ");
        System.out.println("TIMES CADASTRADOS: " + this.hackatona.getTimesCadastrados());
        System.out.println("ALUNOS CADASTRADOS: " + this.hackatona.getAlunosCadastrados());

        if (this.hackatona.retornaVencedor().equalsIgnoreCase("AS NOTAS AINDA NÃO FORAM ATRIBUIDAS A TODOS OS TIMES")) {
            System.out.println("AINDA NÃO HÁ UM VENCEDOR");
        } else {
            System.out.println(this.hackatona.retornaVencedor());
        }

        do {
            System.out.println("O que você deseja fazer? ");
            System.out.println("1 - Consultar aluno\n2 - Consultar time\n3 - Inserir notas");
            System.out.println(
                    "4 - Consultar times com nota maior que 8\n5 - Encerrar competição\n6 - Consultar vencedor");
            System.out.println("DIGITE SUA OPÇÃO: ");
            opt = this.in.nextInt();

            switch (opt) {
                case 1:
                    consultarAluno();
                    break;
                case 2:
                    consultarTime();
                    break;
                case 3:
                    inserirNotas();
                    break;
                case 4:
                    consultarTimesAcimaDeOito();
                    break;
                case 5:
                    encerrarCompeticao();
                    break;
                case 6:
                    consultaVencedor();
                    break;
            }

        } while (opt != 0);
    }

    public void consultarTime() {
        String nomeTime;
        System.out.println("\n\n**************************");
        System.out.println("Digite o nome do time que você deseja Consultar? ");
        nomeTime = this.in.nextLine();
        System.out.println(this.hackatona.consultarTime(nomeTime));
    }

    public void consultarAluno() {
        int opt;
        Aluno aluno = null;
        System.out.println("\n\n**************************");
        do {
            System.out.println(
                    "Como você deseja consultar o aluno em questão?\n1 - Informar matrícula\n2 - Informar email");
            opt = in.nextInt();
        } while (opt < 1 || opt > 2);
        if (opt == 1) {
            int matricula;
            System.out.print("Informe a matrícula do aluno: ");
            matricula = in.nextInt();
            while (matricula <= 0) {
                System.out.println("DIGITE UM NÚMERO DE MATRÍCULA VÁLIDO!!");
                in.nextInt();
            }
            aluno = this.hackatona.readAlunoMatricula(matricula);
            System.out.println(aluno);
        } else if (opt == 2) {
            String email;
            System.out.print("Informe o email do aluno: ");
            email = this.in.nextLine();
            aluno = this.hackatona.readAlunoEmail(email);
            System.out.println(aluno);
        }
        if (aluno == null) {
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
    }

    public void inserirNotas() {
        String nomeTime;
        System.out.println("\n\n**************************");
        System.out.println("Digite o nome do time que você deseja INSERIR NOTA: ");
        nomeTime = this.in.nextLine();
        if (this.hackatona.timeExiste(nomeTime)) {
            System.out.println("Time localizado");
            System.out.println("Insira a nota do time: ");
            if (this.hackatona.insereNotaTime(nomeTime, in.nextDouble())) {
                System.out.println("NOTA INSERIDA COM SUCESSO!!");
            } else {
                System.out.println("NÃO FOI POSSÍVEL INSERIR A NOTA!!");
            }
        } else {
            System.out.println("TIME NÃO EXISTE");
        }
    }

    public void consultarTimesAcimaDeOito() {
        System.out.println("\n\n**************************");
        System.out.println("Estes são os times que tiveram nota maior ou igual a oito: ");
        System.out.println(this.hackatona.notaMaiorQueOito());
    }

    public void encerrarCompeticao() {
        int opt;
        System.out.println("\n\n**************************");
        do {
            System.out.println(
                    "ATENÇÃO: ESSA OPÇÃO VAI ZERAR A NOTA DE TODOS OS TIMES QUE AINDA NÃO TIVERAM SUA NOTA ATRIBUIDA. VOCÊ TEM CERTEZA DISSO?");
            System.out.println("1 - SIM\n2 - NÃO");
            opt = in.nextInt();
        } while (opt < 1 || opt > 2);
        if (opt == 1) {
            this.hackatona.encerrarCompeticao();
            System.out.println("COMPETIÇÃO ENCERRADA COM SUCESSO");
            System.out.println("O TIME VENCEDOR É ");
            System.out.println(this.hackatona.retornaVencedor());
        }
    }

    public void consultaVencedor() {
        System.out.println("\n\n**************************");
        System.out.println("O time vencedor da hackatona é ");
        System.out.println(this.hackatona.retornaVencedor());
    }
}

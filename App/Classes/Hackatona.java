package App.Classes;

public class Hackatona {
    private Professor[] professores = new Professor[10];
    public Time[] time = new Time[15];
    public Aluno[] alunos = new Aluno[75];// 5 x 15 = 75 - a quantidade máxima de integrantes vezes a quantidade
                                          // máxima
                                          // de grupos;
    private int profsCadastrados, timesCadastrados, alunosCadastrados, alunosSemTime;
    private Time timeVencedor;

    public Time getTimeVencedor() {
        return timeVencedor;
    }

    /*
     * CRUD PROFESSOR
     */
    public boolean createProfessor(Professor prof) {
        for (int i = 0; i < this.professores.length; i++) {
            if (this.professores[i] == null) {
                this.professores[i] = prof;
                profsCadastrados++;
                return true;
            }
        }
        return false;
    }

    public Professor readProfessorId(int idFuncional) {
        for (int i = 0; i < this.professores.length; i++) {
            if (this.professores[i].getIdFuncional() == idFuncional) {
                return this.professores[i];
            }
        }
        return null;
    }

    public boolean deleteProfessor(Professor professor) {
        int posicao;
        for (int i = 0; i < this.professores.length; i++) {
            if (this.professores[i] == professor) {
                this.professores[i] = null;
                posicao = i;
                for (int j = posicao; j < this.professores.length - 1; j++) {
                    if (this.professores[j] != this.professores[j + 1]) {
                        this.professores[j] = this.professores[j + 1];
                    }
                }
                this.professores[this.professores.length - 1] = null;
                this.profsCadastrados--;
                return true;
            }
        }
        return false;
    }

    public boolean updateProfessor(Professor profConsultado, Professor profAtualizado) {
        if (profConsultado != null) {
            for (int i = 0; i < this.professores.length; i++) {
                if (this.professores[i] == profConsultado) {
                    this.professores[i] = profAtualizado;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /*
     * CRUD Times
     */
    public boolean createTime(Time time) {
        for (int i = 0; i < this.time.length; i++) {
            if (this.time[i] == null) {
                this.time[i] = time;
                timesCadastrados++;
                return true;
            }
        }
        return false;
    }

    public boolean deleteTime(Time time) {
        int posicao;
        for (int i = 0; i < this.time.length; i++) {
            if (this.time[i] == time) {
                this.time[i].deleteTime();
                this.time[i] = null;
                posicao = i;
                for (int j = posicao; j < this.time.length - 1; j++) {
                    if (this.time[j] != this.time[j + 1]) {
                        this.time[j] = this.time[j + 1];
                    }
                }
                this.time[this.time.length - 1] = null;
                this.timesCadastrados--;
                return true;
            }
        }
        return false;
    }

    /*
     * CRUD Alunos
     */

    public boolean createAluno(Aluno aluno) {
        for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i] == null) {
                this.alunos[i] = aluno;
                alunosCadastrados++;
                return true;
            }
        }
        return false;
    }

    public boolean deleteAluno(Aluno aluno) {
        int posicao;
        for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i] == aluno) {
                if (!alunos[i].getTime().equalsIgnoreCase("<ALUNO SEM TIME>")) {
                    for (int j = 0; i < this.time.length; i++) {
                        if (this.time[j].getNome().equalsIgnoreCase(alunos[i].getTime())) {
                            this.time[j].deleteIntegrante(aluno);
                        }
                    }
                }
                this.alunos[i] = null;

                posicao = i;

                for (int j = posicao; j < this.alunos.length - 1; j++) {
                    if (this.alunos[j] != this.alunos[j + 1]) {
                        this.alunos[j] = this.alunos[j + 1];
                    }
                }

                this.alunos[this.alunos.length - 1] = null;
                this.alunosCadastrados--;
                return true;
            }
        }
        return false;
    }

    public Aluno readAlunoMatricula(int matricula) {
        for (int i = 0; i < alunos.length; i++) {
            if (this.alunos[i].getMatricula() == matricula) {
                return this.alunos[i];
            }
        }
        return null;
    }

    public Aluno readAlunoEmail(String email) {
        for (int i = 0; i < alunos.length; i++) {
            if (this.alunos[i].getEmail().equalsIgnoreCase(email)) {
                return this.alunos[i];
            }
        }
        return null;
    }

    public void identificaVencedor(Time[] times) {
        Time timeVencedor = times[0];
        for (int i = 1; i < this.time.length; i++) {
            if (times[i] != null) {
                if (times[i].getNotaFinal() > timeVencedor.getNotaFinal()) {
                    timeVencedor = times[i];
                }
            }
        }
        this.timeVencedor = timeVencedor;
    }

}

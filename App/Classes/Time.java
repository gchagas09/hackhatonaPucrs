package App.Classes;

public class Time {
    private String nome;
    private double notaFinal;
    private int integrantesTime;
    private Aluno integrantes[];

    public Time(String nome) {
        this.nome = nome;
        this.integrantesTime = 0;
        this.integrantes = new Aluno[5];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getIntegrantesTime() {
        return integrantesTime;
    }

    public void setIntegrantesTime(int integrantesTime) {
        this.integrantesTime = integrantesTime;
    }

    public Aluno getIntegranteMatricula(int matricula) {
        for (int i = 0; i < integrantes.length; i++) {
            if (this.integrantes[i].getMatricula() == matricula) {
                return this.integrantes[i];
            }
        }
        return null;
    }

    public Aluno getIntegranteEmail(String email) {
        for (int i = 0; i < integrantes.length; i++) {
            if (this.integrantes[i].getEmail().equalsIgnoreCase(email)) {
                return this.integrantes[i];
            }
        }
        return null;
    }

    public boolean setIntegrante(Aluno aluno) {
        for (int i = 0; i < this.integrantes.length; i++) {
            if (this.integrantes[i] == null) {
                this.integrantes[i] = aluno;
                integrantesTime++;
                return true;
            }
        }
        return false;
    }

    public boolean deleteIntegrante(Aluno aluno) {
        for (int i = 0; i < this.integrantes.length; i++) {
            if (this.integrantes[i] == aluno) {
                this.integrantes[i].setTime("<ALUNO SEM TIME>");
                this.integrantes = null;
                return true;
            }
        }
        return false;
    }

    public void deleteTime() {
        for (int i = 0; i < this.integrantes.length; i++) {
            if (this.integrantes[i] != null) {
                this.integrantes[i].setTime("<ALUNO SEM TIME>");
            }
        }
    }

}

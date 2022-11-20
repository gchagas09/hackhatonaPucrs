package App.Classes;

public class Aluno {
    private String nome, email, time;
    private int matricula;

    public Aluno(String nome, String email, int matricula) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.time = "<ALUNO SEM TIME>";
    }

    @Override
    public String toString() {
        return "Nome do aluno:" + this.nome + "\nEmail: " + this.email + "\nViewTime: " + this.time + "\nMatricula: "
                + this.matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
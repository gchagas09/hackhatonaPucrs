package App.Classes;

public class Time {
    String nome;
    double notaFinal;
    int integrantesTime;
    Aluno integrantes[];

    public Time(String nome) {
        this.nome = nome;
        this.notaFinal = (Double) null;
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

    public Aluno[] getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(Aluno[] integrantes) {
        this.integrantes = integrantes;
    }

}

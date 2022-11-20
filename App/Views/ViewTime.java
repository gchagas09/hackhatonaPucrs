package App.Views;

import App.Classes.*;

public class ViewTime {
    private String nome;
    private double notaFinal;
    private int proximoIndice;
    private int tamanhoVetor;

    public Aluno[] vetorAlunos;
    public Time[] vetorTimes;

    public ViewTime(String nome, double notaFinal, int proximoIndice) {
        this.nome = nome;
        this.notaFinal = notaFinal;
        this.proximoIndice = 0;
    }

    public double identificaVencedor(String nome, double notaFinal) {
        double maiorNota = 0;
        for (int i = 0; i < proximoIndice; i++) {
            maiorNota = maiorNota + vetorTimes[i].getNotaFinal();
        }
        return maiorNota;
    }

    public Aluno[] mostraAlunos(Aluno[] alunos) {
        for (int i = 0; i < proximoIndice; i++) {
            System.out.println(alunos[i]);
        }
        return alunos;
    }

    public Time[] mostraNotas() {

        Time[] notaMaior = new Time[tamanhoVetor];
        int proximaPosicao = 0;

        for (int i = 0; i < proximaPosicao; i++) {
            if (vetorTimes[i].getNotaFinal() > 8.0) {
                notaMaior[proximaPosicao] = vetorTimes[i];
                proximaPosicao++;
            }
        }
        return notaMaior;
    }
}



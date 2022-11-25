package App.Views;

import App.Classes.*;

public class ViewTime {
    private String nome;
    private double notaFinal;
    private int proximoIndice;
    private Hackatona hackatona;
    private Input in;

    public ViewTime(Hackatona hackatona) {
        this.hackatona = hackatona;
        this.in = new Input();
    }

    public Aluno[] mostraAlunos(Aluno[] alunos) {
        for (int i = 0; i < proximoIndice; i++) {
            System.out.println(alunos[i]);
        }
        return alunos;
    }

    public void mostraTimeVencedor(Time time) {
        System.out.println("Time vencedor: \n" + time);
    }

    public String mostraNotas(Time[] notaMaior) {

        String relatorioDeNotas = "Notas maiores ou iguais a 8: ";
        int proximaPosicao = 0;

        for (int i = 0; i < proximaPosicao; i++) {
            if (notaMaior[i].getNotaFinal() >= 8.0) {
                relatorioDeNotas += "\n" + notaMaior[i];
                relatorioDeNotas += "\n-------------";
                proximaPosicao++;
            }
        }
        return relatorioDeNotas;
    }

    
}

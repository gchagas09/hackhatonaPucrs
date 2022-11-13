package App.Classes;

public class Professor {
    String nome, email;
    int idFuncional;

    public Professor(String nome, String email, int idFuncional) {
        this.nome = nome;
        this.email = email;
        this.idFuncional = idFuncional;
    }

    @Override
    public String toString() {
        return "Nome=" + nome + "\nEmail=" + email + "\nID Funcional:" + idFuncional;
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

    public int getIdFuncional() {
        return idFuncional;
    }

    public void setIdFuncional(int idFuncional) {
        this.idFuncional = idFuncional;
    }

}

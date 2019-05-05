package dmdulliustisolutions.meuapp.Modelos;

public class Evento {
    private String data, titulo, descricao;
    private int vagas, id;

    public Evento(String data, String titulo, String descricao, int vagas) {

        this.data = data;
        this.titulo = titulo;
        this.descricao = descricao;
        this.vagas = vagas;
        this.id = id;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return this.titulo + " - " + this.data + "   " + this.vagas + " vagas ";
    }
}

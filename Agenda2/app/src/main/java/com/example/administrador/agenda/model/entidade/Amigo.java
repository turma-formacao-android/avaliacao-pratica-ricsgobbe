package com.example.administrador.agenda.model.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrador on 01/10/2015.
 */
public class Amigo implements Parcelable {
    private Long _id;
    private String nome;
    private String cep;
    private String rua;
    private String bairro;
    private String estado;
    private String cidade;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Amigo() {
        super();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amigo amigo = (Amigo) o;

        if (_id != null ? !_id.equals(amigo._id) : amigo._id != null) return false;
        if (nome != null ? !nome.equals(amigo.nome) : amigo.nome != null) return false;
        if (cep != null ? !cep.equals(amigo.cep) : amigo.cep != null) return false;
        if (rua != null ? !rua.equals(amigo.rua) : amigo.rua != null) return false;
        if (bairro != null ? !bairro.equals(amigo.bairro) : amigo.bairro != null) return false;
        if (estado != null ? !estado.equals(amigo.estado) : amigo.estado != null) return false;
        return !(cidade != null ? !cidade.equals(amigo.cidade) : amigo.cidade != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "_id=" + _id +
                ", nome='" + nome + '\'' +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this._id);
        dest.writeString(this.nome);
        dest.writeString(this.cep);
        dest.writeString(this.rua);
        dest.writeString(this.bairro);
        dest.writeString(this.estado);
        dest.writeString(this.cidade);
    }

    protected Amigo(Parcel in) {
        this._id = (Long) in.readValue(Long.class.getClassLoader());
        this.nome = in.readString();
        this.cep = in.readString();
        this.rua = in.readString();
        this.bairro = in.readString();
        this.estado = in.readString();
        this.cidade = in.readString();
    }

    public static final Parcelable.Creator<Amigo> CREATOR = new Parcelable.Creator<Amigo>() {
        public Amigo createFromParcel(Parcel source) {
            return new Amigo(source);
        }

        public Amigo[] newArray(int size) {
            return new Amigo[size];
        }
    };
}

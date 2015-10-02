package com.example.administrador.agenda.model.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrador on 02/10/2015.
 */
public class Telefone implements Parcelable {

    private Long _id;
    private Long idAmigo;
    private String telefone;

    public Telefone() {
        super();
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Long getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Long idAmigo) {
        this.idAmigo = idAmigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Telefone telefone1 = (Telefone) o;

        if (_id != null ? !_id.equals(telefone1._id) : telefone1._id != null) return false;
        if (idAmigo != null ? !idAmigo.equals(telefone1.idAmigo) : telefone1.idAmigo != null)
            return false;
        return !(telefone != null ? !telefone.equals(telefone1.telefone) : telefone1.telefone != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (idAmigo != null ? idAmigo.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Telefone{" +
                "_id=" + _id +
                ", idAmigo=" + idAmigo +
                ", telefone='" + telefone + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this._id);
        dest.writeValue(this.idAmigo);
        dest.writeValue(this.telefone);

    }


    protected Telefone(Parcel in) {
        this._id = (Long) in.readValue(Long.class.getClassLoader());
        this.idAmigo = (Long) in.readValue(Long.class.getClassLoader());
        this.telefone = in.readString();
    }

    public static final Parcelable.Creator<Telefone> CREATOR = new Parcelable.Creator<Telefone>() {
        public Telefone createFromParcel(Parcel source) {
            return new Telefone(source);
        }

        public Telefone[] newArray(int size) {
            return new Telefone[size];
        }
    };
}

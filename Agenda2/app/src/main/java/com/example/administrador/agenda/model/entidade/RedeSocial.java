package com.example.administrador.agenda.model.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrador on 02/10/2015.
 */
public class RedeSocial
        implements Parcelable {

    private Long _id;
    private Long idAmigo;
    private String rede;


    public RedeSocial() {
        super();
    }


    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getRede() {
        return rede;
    }

    public void setRede(String rede) {
        this.rede = rede;
    }

    public Long getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Long idAmigo) {
        this.idAmigo = idAmigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RedeSocial that = (RedeSocial) o;

        if (_id != null ? !_id.equals(that._id) : that._id != null) return false;
        if (idAmigo != null ? !idAmigo.equals(that.idAmigo) : that.idAmigo != null) return false;
        return !(rede != null ? !rede.equals(that.rede) : that.rede != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (idAmigo != null ? idAmigo.hashCode() : 0);
        result = 31 * result + (rede != null ? rede.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "RedeSocial{" +
                "_id=" + _id +
                ", idAmigo=" + idAmigo +
                ", rede='" + rede + '\'' +
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
        dest.writeString(this.rede);
    }

    protected RedeSocial(Parcel in) {
        this._id = (Long) in.readValue(Long.class.getClassLoader());
        this.idAmigo = (Long) in.readValue(Long.class.getClassLoader());
        this.rede = in.readString();
    }

    public static final Creator<RedeSocial> CREATOR = new Creator<RedeSocial>() {
        public RedeSocial createFromParcel(Parcel source) {
            return new RedeSocial(source);
        }

        public RedeSocial[] newArray(int size) {
            return new RedeSocial[size];
        }
    };
}

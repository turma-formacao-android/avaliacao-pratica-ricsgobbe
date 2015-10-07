package com.example.administrador.agenda.model.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrador on 02/10/2015.
 */
public class Email implements Parcelable {

    private Long _id;
    private Long idAmigo;
    private String email;

    public Email() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email1 = (Email) o;

        if (_id != null ? !_id.equals(email1._id) : email1._id != null) return false;
        if (idAmigo != null ? !idAmigo.equals(email1.idAmigo) : email1.idAmigo != null)
            return false;
        return !(email != null ? !email.equals(email1.email) : email1.email != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (idAmigo != null ? idAmigo.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "_id=" + _id +
                ", idAmigo=" + idAmigo +
                ", email='" + email + '\'' +
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
        dest.writeString(this.email);
    }

    protected Email(Parcel in) {
        this._id = (Long) in.readValue(Long.class.getClassLoader());
        this.idAmigo = (Long) in.readValue(Long.class.getClassLoader());
        this.email = in.readString();
    }

    public static final Creator<Email> CREATOR = new Creator<Email>() {
        public Email createFromParcel(Parcel source) {
            return new Email(source);
        }

        public Email[] newArray(int size) {
            return new Email[size];
        }
    };
}

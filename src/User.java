import java.io.Serializable;


//Создание пользователя, необходим для сериализации и дисериализации
public class User implements Serializable {
    private static final long serialVersionUID = 1L; // для сравнения версий класса, обеспечивающих загрузку одного и того же класса во время сериализации во время десериализации
    private String name; //Имя пользователя
    private String eMail; //Адрес почтового ящика


    public User(String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }  // seteMail !?
}

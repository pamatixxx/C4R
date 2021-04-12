import java.io.*;
import java.util.ArrayList;

//Работа с локальным файлом, загрузка данных для наполнения таблицы и обратное, запись из таблицы в файл.
public class WorkFile {


    public String saveUser(User user) {
        try {
            File file = new File("C4R2.txt");
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Пользователь успешно сохранен."; // user was added successfully
    }


    public ArrayList<User> toReadUser() { // readUsers -> на этот раз с s
        File file = new File("C4R2.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C4R2.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<User> objectsList = new ArrayList<>();
//        boolean cont = true;
//        while (cont) {
        ObjectInputStream input;
        Object obj;
        while (true) {
            try {
                input = new ObjectInputStream(fis);
                obj = input.readObject();
                if (obj != null) {
                    objectsList.add((User) obj);
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }

        return objectsList;
    }

}



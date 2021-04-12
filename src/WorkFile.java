import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class WorkFile {

    public String toSaveUsers(Users users) {
        try {
            File file = new File("D:\\\\C4R2.txt");
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Пользователь успешно сохранен.";
    }


    public ArrayList<Users> toReadUsers() throws FileNotFoundException {
        File file = new File("D:\\\\C4R2.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fis = new FileInputStream("D:\\\\C4R2.txt");
        ArrayList<Users> objectsList = new ArrayList<>();
        boolean cont = true;
        while (cont) {
            try {
                ObjectInputStream input = new ObjectInputStream(fis);
                Object obj = input.readObject();
                if (obj != null) {
                    objectsList.add((Users) obj);
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                break;
            }
        }
        return objectsList;
    }

}



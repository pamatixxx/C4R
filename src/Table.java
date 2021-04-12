import java.io.FileNotFoundException;
import java.util.ArrayList;

//Создание таблицы для окна Window
public class Table {

    // Заголовки столбцов
    private Object[] columnsHeader;
    //массив пользователей для отображения
    private Object[][] array;

    public Table(String[] strings) {
        this.columnsHeader = strings;
    }


    public Object[] getColumnsHeader() {
        return columnsHeader;
    }

    public void setColumnsHeader(Object[] columnsHeader) {
        this.columnsHeader = columnsHeader;
    }


    public Object[][] getArray() {

        WorkFile file = new WorkFile();
        ArrayList<User> arrayList = null;
        arrayList = file.toReadUser();

        Object[][] array = new String[arrayList.size()][getColumnsHeader().length];

        //Иницилизация массива для работы таблицы, привидение к типу для работы таблицы.
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < getColumnsHeader().length; j++) {
                if (j == 0) { //если первый элемент записываем в 1-ю ячейку таблицы
                    array[i][j] = arrayList.get(i).getName();
                } else { //иначе записываем во вторую ячейку таблицы
                    array[i][j] = arrayList.get(i).geteMail();
                }
            }
        }
        this.array = array;

        return array;
    }

    public void setArray(Object[][] array) {
        this.array = array;
    }
}

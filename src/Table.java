import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Table {

    // Заголовки столбцов
    private Object[] columnsHeader = new String[]{"name", "e-mail"};
    //массив пользователей для отображения
    private Object[][] array ;


    public Object[] getColumnsHeader() {
        return columnsHeader;
    }

    public void setColumnsHeader(Object[] columnsHeader) {
        this.columnsHeader = columnsHeader;
    }

    public Object[][] getArray() throws FileNotFoundException {

            WorkFile file = new WorkFile();
            ArrayList<Users> arrayList = file.toReadUsers();

            Object[][] array = new String[arrayList.size()][getColumnsHeader().length];
            for (int i = 0; i< arrayList.size();i++){
                for (int j = 0 ; j <getColumnsHeader().length;j++){
                    if (j==0)array[i][j] = arrayList.get(i).getName();
                    else array[i][j] = arrayList.get(i).geteMail();
                }}
            setArray(array);

        return array;
    }

    public void setArray(Object[][] array) {
        this.array = array;
    }
}

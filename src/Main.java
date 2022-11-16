import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Створити словник – текстовий файл, кожний рядок якого містить слово та його переклад. Заповнити бінарне дерево словами із словника.
// Ввести рядок. За допомогою дерева знайти переклад кожного слова і вивести переклад рядка на екран.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        tree derevo =new tree(); //Cтворення бінарного дерева
        File file = new File("D:\\University\\2Course\\ADS\\Lab9_3\\src\\dictionary.txt"); // Створення об'єкта класу File, до якого ми записуємо шлях до нашого словника

        //Створюємо об'єкт класу Scanner, який зчитує дані з джерела, яке ми для нього вкажемо.
        // Наприклад, з рядка, із файлу, з консолі. Далі він розпізнає цю інформацію та обробляє належним чином.
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){ //Зчитуємо рядки з файлу, поки вони присутні
            String line=scanner.nextLine();//Зберігаємо рядок у змінний
            String[] words = line.split(" ");//Перетворюємо рядок на масив слів
            derevo.insert(words[0],words[1]);//Додаємо пару <ключ, значення> до нашого бінарного дерева
        }



        Scanner scannerUser;
        while (true){
            System.out.println("Введите слово перевод которого хотите найти:");
            scannerUser = new Scanner(System.in);
            String searchWord=scannerUser.nextLine();
            if(searchWord.compareTo("/q")==0){//умова виходу зі словника
                break;
            }
            System.out.println("Перевод: "+derevo.find(searchWord));//Знаходження перекладу в бінарному дереві
        }

    }
}
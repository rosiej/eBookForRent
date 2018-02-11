package pl.sdacademy.domain;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileEBookStorage implements EBookStorage {
    public Category getMainCategory() {
        return mainCategory;
    }

    private Category mainCategory;


    public FileEBookStorage() throws FileNotFoundException {
        Category biography = new Category("Biografie", 1);
        Category forKids = new Category("Dla dzieci", 2);
        Category fantasticHorror = new Category("Fantastyka i horror", 3);
        Category history = new Category("Historia", 4);
        Category criminalSensationThriller = new Category("Kryminał, sensacja, thriller", 5);
        Category moralLiterature = new Category("Literatura obyczajowa", 6);
        Category logs = new Category("Dzienniki", 7);
        Category autobiography = new Category("Autobiografie", 8);
        Category interviews = new Category("Wywiady", 9);
        Category forYoungest = new Category("Dla najmłodszych", 10);
        Category forTeenagers = new Category("Dla nastolatków", 11);
        Category fantasy = new Category("Fantastyka", 12);
        Category horror = new Category("Horror", 13);
        Category sf = new Category("Sf", 14);
        Category worldHistory = new Category("Historia świata", 15);
        Category polishHistory = new Category("Historia Polski", 16);
        Category criminal = new Category("Kryminał", 17);
        Category senastion = new Category("Sensacja", 18);
        Category thriller = new Category("Thriller", 19);
        Category erotics = new Category("Erotyka", 20);
        Category romance = new Category("Romans", 21);

        mainCategory = new Category("główna", 0);
        mainCategory.addChildCategory(biography);
        mainCategory.addChildCategory(forKids);
        mainCategory.addChildCategory(fantasticHorror);
        mainCategory.addChildCategory(history);
        mainCategory.addChildCategory(criminalSensationThriller);
        mainCategory.addChildCategory(moralLiterature);
        biography.addChildCategory(logs);
        biography.addChildCategory(autobiography);
        biography.addChildCategory(interviews);
        forKids.addChildCategory(forYoungest);
        forKids.addChildCategory(forTeenagers);
        fantasticHorror.addChildCategory(fantasy);
        fantasticHorror.addChildCategory(horror);
        fantasticHorror.addChildCategory(sf);
        history.addChildCategory(worldHistory);
        history.addChildCategory(polishHistory);
        criminalSensationThriller.addChildCategory(criminal);
        criminalSensationThriller.addChildCategory(senastion);
        criminalSensationThriller.addChildCategory(thriller);
        moralLiterature.addChildCategory(erotics);
        moralLiterature.addChildCategory(romance);


        uploadBookList();

        // testy
//        printTree(mainCategory);
//        Category c = choseSubcategory(mainCategory, 53);
//        System.out.println("Znaleziono: " + c.getName());
    }



    public void printTree(Category category){
        for (int i = 0; i < category.size(); i++) {
            System.out.println(category.getChild(i).getName()+"  wybierz: "+category.getChild(i).getId());
            printTree(category.getChild(i));

        }
        categoryTree();
    }

    public Category choseSubcategory(Category category, int id)  {
        for (int i = 0; i < category.size(); i++) {
            if(category.getChild(i).getId() == id) {
                return category.getChild(i);
            } else {
                Category result = choseSubcategory(category.getChild(i), id);
                if(result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    
    Scanner scanner = new Scanner(new File("BookList.txt"));

    Map<Integer, Book> eBooksMap = new HashMap<Integer, Book>();

    public void uploadBookList() {
        while (scanner.hasNext()) {
            String[] book = scanner.nextLine().split("; ");
            Book eBook = new Book(book[2], book[1], book[3], Integer.parseInt(book[0]));
            eBooksMap.put(Integer.parseInt(book[0]), eBook);
        }
    }
     public void categoryTree(){
        Scanner scanner = new Scanner(System.in);

         System.out.println("wybierz kategorie:");
         for (int i = 0; i < mainCategory.getChildren().size(); i++) {
             System.out.println(mainCategory.getChildren().get(i).getName());
         }
         int catNumber = scanner.nextInt();

         System.out.println(choseSubcategory(mainCategory,catNumber).getName());

     }

}
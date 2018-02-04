package pl.sdacademy.domain;

import java.util.ArrayList;
import java.util.TreeMap;

public class EBookStorage {
    ArrayList<Category> mainCategory = new ArrayList<Category>();

    Category biograf = new Category("Biografie");
    Category autobiograf = new Category("Autobiografie");
    Category jurnal = new Category("Pamietniki");
    Category Interview = new Category("Wywiady");
    Category Come dy = new Category("Komedie");
    Category BlackComedy = new Category("Czarny humor");
    Category Criminal = new Category("Kryminał");
    Category Romans = new Category("Komedie romantyczne");
    Category Horror = new Category("Horror");

    public void settingCategory(){
        biograf.addChildCategory(autobiograf);
        biograf.addChildCategory(jurnal);
        biograf.addChildCategory(Interview);
        Comedy.addChildCategory(BlackComedy);
        Comedy.addChildCategory(Criminal);
        Comedy.addChildCategory(Romans);
        Horror.addChildCategory(Criminal);

        mainCategory.add(biograf);
        mainCategory.add(Comedy);
        mainCategory.add(Horror);

        System.out.println(mainCategory.get(1).getName());
    }

}

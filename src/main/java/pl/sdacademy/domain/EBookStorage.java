package pl.sdacademy.domain;


public class EBookStorage {
    private Category mainCategory;

    public EBookStorage() {
        Category biography = new Category("Biografie", 1);
        Category forKids = new Category("Dla dzieci", 2);
        Category fantasticHorror = new Category("Fantastyka i horror", 3);
        Category history = new Category("Historia", 4);
        Category criminalSensationThriller = new Category("Kryminał, sensacja, thriller", 5);
        Category moralLiterature = new Category("Literatura obyczajowa", 6);
        Category logs = new Category("Dzienniki", 10);
        Category autobiography = new Category("Autobiografie", 11);
        Category interviews = new Category("Wywiady", 12);
        Category forYoungest = new Category("Dla najmłodszych", 21);
        Category forTeenagers = new Category("Dla nastolatków", 22);
        Category fantasy = new Category("Fantastyka", 31);
        Category horror = new Category("Horror", 32);
        Category sf = new Category("Sf", 33);
        Category worldHistory = new Category("Historia świata", 41);
        Category polishHistory = new Category("Historia Polski", 42);
        Category criminal = new Category("Kryminał", 51);
        Category senastion = new Category("Sensacja", 52);
        Category thriller = new Category("Thriller", 53);
        Category erotics = new Category("Erotyka", 61);
        Category romance = new Category("Romans", 62);

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

     }
}
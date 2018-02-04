package pl.sdacademy.domain;


public class EBookStorage {
    private Category mainCategory;

    public EBookStorage() {
       Category

        biograf.addChildCategory(autobiograf);
        biograf.addChildCategory(jurnal);
        biograf.addChildCategory(Interview);
        Comedy.addChildCategory(BlackComedy);
        Comedy.addChildCategory(Criminal);
        Comedy.addChildCategory(Romans);
        Horror.addChildCategory(Criminal);

        mainCategory.addChildCategory(biograf);
        mainCategory.addChildCategory(Comedy);
        mainCategory.addChildCategory(Horror);
    }


}

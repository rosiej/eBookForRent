package pl.sdacademy.domain;

public class Book {
    String title;
    String author;
    String content;
    Category category;
    int id;

    public Book(String title, String author, String content, int id) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.id = id;
        if(id<6){
           category = new Category("Dzienniki",10);
        }if(id>5&&id<12){
            category = new Category("Autobiografie",11);
        } if(id>11&&id<17){
            category = new Category("Wywiady",12);
        } if(id>16&&id<22){
            category = new Category("Dla najmłodszych",21);
        } if(id>21&&id<27){
            category = new Category("Dla nastolatków",22);
        } if(id>26&&id<32){
            category = new Category("Fantastyka",31);
        } if(id>31&&id<37){
            category = new Category("Horror",32);
        } if(id>36&&id<42){
            category = new Category("Sf",33);
        } if(id>41&&id<47){
            category = new Category("Historia świata",41);
        } if(id>46&&id<52){
            category = new Category("Historia Polski",42);
        } if(id>51&&id<57){
            category = new Category("Kryminał",51);
        } if(id>56&&id<62){
            category = new Category("Sensacja",52);
        } if(id>61&&id<67){
            category = new Category("Thriller",53);
        } if(id>61&&id<67){
            category = new Category("Thriller",53);
        } if(id>66&&id<89){
            category = new Category("Erotyka",61);
        } if(id>88&&id<=100) {
            category = new Category("Romans", 62);
        }

    }
}

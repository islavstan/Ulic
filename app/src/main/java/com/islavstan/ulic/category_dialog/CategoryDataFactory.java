package com.islavstan.ulic.category_dialog;

import java.util.Arrays;
import java.util.List;


public class CategoryDataFactory {

    public static List<Category> makeCategory() {
        return Arrays.asList(makeChildCategory(),
                makeElectronicsCategory(),
                makeClothesCategory()
               /* makeSalsaGenre(),
                makeBluegrassGenre()*/);
    }


    public static Category makeChildCategory() {
        return new Category("Детский мир", makeChildSub());
    }


    public static List<Subcategory> makeChildSub() {
        Subcategory child1 = new Subcategory("Детская одежда");
        Subcategory child2 = new Subcategory("Детская обувь");
        Subcategory child3 = new Subcategory("Детские коляски");
        Subcategory child4 = new Subcategory("Деская мебель");
        Subcategory child5 = new Subcategory("Игрушки");
        Subcategory child6 = new Subcategory("Товары для школьников");
        Subcategory child7 = new Subcategory("Прочие детские товары");

        return Arrays.asList(child1, child2, child3, child4, child5, child6, child7);
    }

    public static Category makeElectronicsCategory() {
        return new Category("Электроника", makeChildElectronics());
    }


    public static List<Subcategory> makeChildElectronics() {
        Subcategory child1 = new Subcategory("Телефоны и аксессуары");
        Subcategory child2 = new Subcategory("Компьютеры и комплектующие");
        Subcategory child3 = new Subcategory("Фото / Видео");
        Subcategory child4 = new Subcategory("ТВ / Видеотехника");
        Subcategory child5 = new Subcategory("Аудиотехника");
        Subcategory child6 = new Subcategory("Игровые приставки");
        Subcategory child7 = new Subcategory("Ноутбуки");
        Subcategory child8 = new Subcategory("Техника для дома");
        Subcategory child9 = new Subcategory("Прочая электроника");

        return Arrays.asList(child1, child2, child3, child4, child5, child6, child7 , child8, child9);
    }

    public static Category makeClothesCategory() {
        return new Category("Одежда и обувь", makeClothesChild());
    }


    public static List<Subcategory> makeClothesChild() {
        Subcategory child1 = new Subcategory("Женская одежда");
        Subcategory child2 = new Subcategory("Женская обувь");
        Subcategory child3 = new Subcategory("Мужская одежда");
        Subcategory child4 = new Subcategory("Мужская обувь");
        Subcategory child5 = new Subcategory("Головные уборы");

        return Arrays.asList(child1, child2, child3, child4, child5);
    }

 /*   public static Category makeSalsaGenre() {
        return new Category("Salsa", makeSalsaArtists());
    }


    public static List<Subcategory> makeSalsaArtists() {
        Subcategory hectorLavoe = new Subcategory("Hector Lavoe");
        Subcategory celiaCruz = new Subcategory("Celia Cruz");
        Subcategory willieColon = new Subcategory("Willie Colon");
        Subcategory marcAnthony = new Subcategory("Marc Anthony");

        return Arrays.asList(hectorLavoe, celiaCruz, willieColon, marcAnthony);
    }

    public static Category makeBluegrassGenre() {
        return new Category("Bluegrass", makeBluegrassArtists());
    }


    public static List<Subcategory> makeBluegrassArtists() {
        Subcategory billMonroe = new Subcategory("Bill Monroe");
        Subcategory earlScruggs = new Subcategory("Earl Scruggs");
        Subcategory osborneBrothers = new Subcategory("Osborne Brothers");
        Subcategory johnHartford = new Subcategory("John Hartford");

        return Arrays.asList(billMonroe, earlScruggs, osborneBrothers, johnHartford);
    }*/
}

package com.example.rakatak.liquidrakatak.datalogic.article;

import com.example.rakatak.liquidrakatak.R;

import java.lang.reflect.Array;

/**
 * Created by Robin on 20.06.2015.
 */
public final class ArticleEntries {

    public static final Article ps4_1 = new Article(R.drawable.destiny_ps4, "Destiny", "PS4", true, 19.99);
    public static final Article ps4_2 = new Article(R.drawable.witcher_ps4, "The Witcher", "PS4", false, 59.99);
    public static final Article ps4_3 = new Article(R.drawable.metalgear_ps4, "Metal Gear: Ground Zeroes", "PS4", true, 15.99);
    public static final Article ps4_4 = new Article(R.drawable.killzone_ps4, "Killzone", "PS4", true, 10.99);
    public static final Article ps4_5 = new Article(R.drawable.call_ps4, "Call of Duty", "PS4", false, 35.99);
    public static final Article ps4_6 = new Article(R.drawable.dragon_ps4, "Dragon Age", "PS4", true, 39.99);
    public static final Article ps4_7 = new Article(R.drawable.final_ps4, "Final Fantasy Type-0", "PS4", false, 59.99);
    public static final Article ps4_8 = new Article(R.drawable.need_ps4, "Need for Speed Rivals", "PS4", true, 15.99);
    public static final Article ps4_9 = new Article(R.drawable.fifa_ps4, "Fifa 15", "PS4", true, 29.99);
    public static final Article ps4_10 = new Article(R.drawable.dbz_ps4, "Dragon Ball Xenoverse", "PS4", true, 19.99);
    public static final Article ps4_11 = new Article(R.drawable.madden_ps4, "Madden NFL 15", "PS4", true, 19.99);
    public static final Article ps4_12 = new Article(R.drawable.nba_ps4, "NBA 2k15", "PS4", true, 59.99);
    public static final Article ps4_13 = new Article(R.drawable.hdr_ps4, "Herr der Ringe", "PS4", true, 15.99);
    public static final Article ps4_14 = new Article(R.drawable.elder_ps4, "Elder Scrolls Online", "PS4", false, 10.99);
    public static final Article ps4_15 = new Article(R.drawable.far_ps4, "Far Cry 4", "PS4", false, 35.99);

    public static final Article xbox_1 = new Article(R.drawable.destiny_xbox, "Destiny", "Xbox One", true, 19.99);
    public static final Article xbox_2 = new Article(R.drawable.fifa_xbox, "Fifa 15", "Xbox One", true, 29.99);
    public static final Article xbox_3 = new Article(R.drawable.metalgear_xbox, "Metal Gear: Ground Zeroes", "Xbox One", true, 15.99);
    public static final Article xbox_4 = new Article(R.drawable.witcher_xbox, "The Witcher", "Xbox One", false, 59.99);
    public static final Article xbox_5 = new Article(R.drawable.limbo_xbox, "Limbo", "Xbox One", true, 9.99);
    public static final Article xbox_6 = new Article(R.drawable.tomb_xbox, "Tomb Raider", "Xbox One", true, 69.99);
    public static final Article xbox_7 = new Article(R.drawable.dragon_xbox, "Dragon Age", "Xbox One", true, 39.99);
    public static final Article xbox_8 = new Article(R.drawable.need_xbox, "Need for Speed Rivals", "Xbox One", false, 15.99);
    public static final Article xbox_9 = new Article(R.drawable.forza_xbox, "Forza 5", "Xbox One", true, 25.99);
    public static final Article xbox_10 = new Article(R.drawable.titan_xbox, "Titanfall", "Xbox One", true, 13.99);
    public static final Article xbox_11 = new Article(R.drawable.sunset_xbox, "Sunset Overdrive", "Xbox One", true, 12.99);
    public static final Article xbox_12 = new Article(R.drawable.trials_xbox, "Trials Fusion", "Xbox One", false, 10.99);
    public static final Article xbox_13 = new Article(R.drawable.gta5_xbox, "Grand Theft Auto 5", "Xbox One", true, 49.99);
    public static final Article xbox_14 = new Article(R.drawable.assasin_xbox, "Assassin's Creed", "Xbox One", true, 30.99);
    public static final Article xbox_15 = new Article(R.drawable.cars_xbox, "Project Cars", "Xbox One", false, 49.99);

    public static final Article wii_1 = new Article(R.drawable.mario_wii, "Super Mario Bros.U", "Wii U", true, 39.99);
    public static final Article wii_2 = new Article(R.drawable.toad_wii, "Toad Tressure Tracker", "Wii U", true, 59.99);
    public static final Article wii_3 = new Article(R.drawable.splatoon_wii, "Splatoon", "Wii U", true, 15.99);
    public static final Article wii_4 = new Article(R.drawable.pac_wii, "Pacman 2", "Wii U", false, 19.99);
    public static final Article wii_5 = new Article(R.drawable.party_wii, "Mario Party 10", "Wii U", true, 29.99);
    public static final Article wii_6 = new Article(R.drawable.nin_wii, "Nintendo Land", "Wii U", true, 49.99);
    public static final Article wii_7 = new Article(R.drawable.yoshi_wii, "Yoshi Wooly World", "Wii U", true, 39.99);
    public static final Article wii_8 = new Article(R.drawable.lego_wii, "Lego Jurassic World", "Wii U", false, 15.99);
    public static final Article wii_9 = new Article(R.drawable.kirby_wii, "Kirby: Der Regenbogen Pinsel", "Wii U", true, 35.99);
    public static final Article wii_10 = new Article(R.drawable.mariod_wii, "Mario 3D World", "Wii U", true, 43.99);
    public static final Article wii_11 = new Article(R.drawable.rayman_wii, "Rayman Legends", "Wii U", true, 12.99);
    public static final Article wii_12 = new Article(R.drawable.need_wii, "Need For Speed Most Wanted", "Wii U", false, 10.99);
    public static final Article wii_13 = new Article(R.drawable.zombi_wii, "ZombiU", "Wii U", true, 49.99);
    public static final Article wii_14 = new Article(R.drawable.hobbit_wii, "Lego Der Hobbit", "Wii U", true, 30.99);
    public static final Article wii_15 = new Article(R.drawable.tekken_wii, "Tekken Tag Tournament", "Wii U", false, 49.99);

    public static final Article[] ALL_ARTICLES_PS4 = {ps4_1, ps4_2, ps4_3, ps4_4, ps4_5, ps4_6, ps4_7, ps4_8, ps4_9, ps4_10, ps4_11, ps4_12, ps4_13, ps4_14, ps4_15};
    public static final Article[] ALL_ARTICLES_XBOX = {xbox_1, xbox_2, xbox_3, xbox_4, xbox_5, xbox_6, xbox_7, xbox_8, xbox_9, xbox_10, xbox_11, xbox_12, xbox_13, xbox_14, xbox_15};
    public static final Article[] ALL_ARTICLES_WII = {wii_1, wii_2, wii_3, wii_4, wii_5, wii_6, wii_7, wii_8, wii_9, wii_10, wii_11, wii_12, wii_13, wii_14, wii_15};

}

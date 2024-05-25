package monopoly;

import java.awt.*;
import java.util.*;

public class Constants {
    // Defined colors
    public static class ColorConstants {
        public static final java.awt.Color BOARD = new java.awt.Color(210, 229, 210);
        public static final java.awt.Color INDIGO = new java.awt.Color(75, 0, 130);
        public static final java.awt.Color SKY = new java.awt.Color(135, 206, 235);
        public static final java.awt.Color ORCHID = new java.awt.Color(216, 55, 148);
        public static final Color TANGERINE = new java.awt.Color(255, 165, 0);
        public static final Color RED = new java.awt.Color(255, 0, 0);
        public static final Color LEMON = new java.awt.Color(255, 255, 0);
        public static final Color FOREST = new java.awt.Color(0, 128, 0);
        public static final Color BLUE = new java.awt.Color(0, 0, 255);

        public static final ArrayList<Color> colorOrder = new ArrayList<>(Arrays.asList(INDIGO, Color.BLACK, SKY, ORCHID, Color.WHITE, TANGERINE, RED, LEMON, FOREST, BLUE));
    }

    // Defined properties
    public static class PropertyConstants {
        public static final Street mediterranean = new Street(1, "Mediterranean Ave", IndigoConstants.regPrice, ColorConstants.INDIGO, IndigoConstants.regRent, IndigoConstants.housePrice);
        public static final Special comm1 = new Special("Community Chest", 2, Special.Type.COMMUNITY);
        public static final Street baltic = new Street(3, "Baltic Ave", IndigoConstants.bonusPrice, ColorConstants.INDIGO, IndigoConstants.bonusRent, IndigoConstants.housePrice);
        public static final Special income = new Special("Income Tax", 4, Special.Type.INCOME);
        public static final Railroad readingRR = new Railroad(5, "Reading Railroad", RailroadConstants.price, Color.BLACK, RailroadConstants.rent);
        public static final Street oriental = new Street(6, "Oriental Ave", SkyConstants.regPrice, ColorConstants.SKY, SkyConstants.regRent, SkyConstants.housePrice);
        public static final Special chance1 = new Special("Chance", 7, Special.Type.CHANCE);
        public static final Street vermont = new Street(8, "Vermont Ave", SkyConstants.regPrice, ColorConstants.SKY, SkyConstants.regRent, SkyConstants.housePrice);
        public static final Street connecticut = new Street(9, "Connecticut Ave", SkyConstants.bonusPrice, ColorConstants.SKY, SkyConstants.bonusRent, SkyConstants.housePrice);
        public static final Special jail = new Special("Jail", 10, Special.Type.JAIL);
        public static final Street charles = new Street(11, "St. Charles Place", OrchidConstants.regPrice, ColorConstants.ORCHID, OrchidConstants.regRent, OrchidConstants.housePrice);
        public static final Utility electric = new Utility(12, "Electric Company", UtilityConstants.price, java.awt.Color.WHITE);
        public static final Street states = new Street(13, "States Ave", OrchidConstants.regPrice, ColorConstants.ORCHID, OrchidConstants.regRent, OrchidConstants.housePrice);
        public static final Street virginia = new Street(14, "Virginia Ave", OrchidConstants.bonusPrice, ColorConstants.ORCHID, OrchidConstants.bonusRent, OrchidConstants.housePrice);
        public static final Railroad pennRR = new Railroad(15, "Pennsylvania Railroad", RailroadConstants.price, java.awt.Color.BLACK, RailroadConstants.rent);
        public static final Street james = new Street(16, "St. James Place", TangerineConstants.regPrice, ColorConstants.TANGERINE, TangerineConstants.regRent, TangerineConstants.housePrice);
        public static final Special comm2 = new Special("Community Chest", 17, Special.Type.COMMUNITY);
        public static final Street tennessee = new Street(18, "Tennessee Ave", TangerineConstants.regPrice, ColorConstants.TANGERINE, TangerineConstants.regRent, TangerineConstants.housePrice);
        public static final Street york = new Street(19, "New York Ave", TangerineConstants.bonusPrice, ColorConstants.TANGERINE, TangerineConstants.bonusRent, TangerineConstants.housePrice);
        public static final Street kentucky = new Street(21, "Kentucky Ave", RedConstants.regPrice, ColorConstants.RED, RedConstants.regRent, RedConstants.housePrice);
        public static final Special chance2 = new Special("Chance", 22, Special.Type.CHANCE);
        public static final Street indiana = new Street(23, "Indiana Ave", RedConstants.regPrice, ColorConstants.RED, RedConstants.regRent, RedConstants.housePrice);
        public static final Street illinois = new Street(24, "Illinois Ave", RedConstants.bonusPrice, ColorConstants.RED, RedConstants.bonusRent, RedConstants.housePrice);
        public static final Railroad boRR = new Railroad(25, "B&O Railroad", RailroadConstants.price, java.awt.Color.BLACK, RailroadConstants.rent);
        public static final Street atlantic = new Street(26, "Atlantic Ave", LemonConstants.regPrice, ColorConstants.LEMON, LemonConstants.regRent, LemonConstants.housePrice);
        public static final Street ventnor = new Street(27, "Ventnor Ave", LemonConstants.regPrice, ColorConstants.LEMON, LemonConstants.regRent, LemonConstants.housePrice);
        public static final Utility water = new Utility(28, "Water Works", UtilityConstants.price, java.awt.Color.WHITE);
        public static final Street marvin = new Street(29, "Marvin Gardens", LemonConstants.bonusPrice, ColorConstants.LEMON, LemonConstants.bonusRent, LemonConstants.housePrice);
        public static final Street pacific = new Street(31, "Pacific Ave", ForestConstants.regPrice, ColorConstants.FOREST, ForestConstants.regRent, LemonConstants.housePrice);
        public static final Street carolina = new Street(32, "North Carolina Ave", ForestConstants.regPrice, ColorConstants.FOREST, ForestConstants.regRent, LemonConstants.housePrice);
        public static final Special comm3 = new Special("Community Chest", 33, Special.Type.COMMUNITY);
        public static final Street pennsylvania = new Street(34, "Pennsylvania", ForestConstants.bonusPrice, ColorConstants.FOREST, ForestConstants.bonusRent, LemonConstants.housePrice);
        public static final Railroad shortLineRR = new Railroad(35, "Short Line Railroad", RailroadConstants.price, Color.BLACK, RailroadConstants.rent);
        public static final Special chance3 = new Special("Chance", 36, Special.Type.CHANCE);
        public static final Street parkPlace = new Street(37, "Park Place", BlueConstants.regPrice, ColorConstants.BLUE, BlueConstants.regRent, BlueConstants.housePrice);
        public static final Special luxury = new Special("Luxury Tax", 38, Special.Type.LUXURY);
        public static final Street boardwalk = new Street(39, "Boardwalk", BlueConstants.bonusPrice, ColorConstants.BLUE, BlueConstants.bonusRent, BlueConstants.housePrice);

        public static final ArrayList<ArrayList<Property>> propertySets = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(mediterranean, baltic)),
                new ArrayList<>(Arrays.asList(oriental, vermont, connecticut)),
                new ArrayList<>(Arrays.asList(charles, states, virginia)),
                new ArrayList<>(Arrays.asList(james, tennessee, york)),
                new ArrayList<>(Arrays.asList(kentucky, indiana, illinois)),
                new ArrayList<>(Arrays.asList(atlantic, ventnor, marvin)),
                new ArrayList<>(Arrays.asList(pacific, carolina, pennsylvania)),
                new ArrayList<>(Arrays.asList(parkPlace, boardwalk)),
                new ArrayList<>(Arrays.asList(readingRR, pennRR, boRR, shortLineRR)),
                new ArrayList<>(Arrays.asList(electric, water))
        ));

        public static final ArrayList<Property> propertyList = new ArrayList<>(Arrays.asList(
                mediterranean, baltic, oriental, vermont, connecticut, charles, states,
                virginia, james, tennessee, york, kentucky, indiana, illinois,
                atlantic, ventnor, marvin, pacific, carolina, pennsylvania, parkPlace,
                boardwalk, readingRR, pennRR, boRR, shortLineRR, electric, water
        ));
    }

    // Mediterranean and Baltic
    public static class IndigoConstants {
        public static final int regPrice = 60;
        public static final int bonusPrice = 60;

        public static final int housePrice = 50;

        public static final int reg0 = 2;
        public static final int reg1 = 10;
        public static final int reg2 = 30;
        public static final int reg3 = 90;
        public static final int reg4 = 160;
        public static final int regHotel = 250;

        public static final int bonus0 = 4;
        public static final int bonus1 = 20;
        public static final int bonus2 = 60;
        public static final int bonus3 = 180;
        public static final int bonus4 = 320;
        public static final int bonusHotel = 450;

        public static final int[] regRent = new int[]{reg0, reg1, reg2, reg3, reg4, regHotel};
        public static final int[] bonusRent = new int[]{bonus0, bonus1, bonus2, bonus3, bonus4, bonusHotel};
    }

    // Oriental, Vermont, and Connecticut
    public static class SkyConstants {
        public static final int regPrice = 100;
        public static final int bonusPrice = 120;

        public static final int housePrice = 50;

        public static final int reg0 = 6;
        public static final int reg1 = 30;
        public static final int reg2 = 90;
        public static final int reg3 = 270;
        public static final int reg4 = 400;
        public static final int regHotel = 550;

        public static final int bonus0 = 8;
        public static final int bonus1 = 40;
        public static final int bonus2 = 100;
        public static final int bonus3 = 300;
        public static final int bonus4 = 450;
        public static final int bonusHotel = 600;

        public static final int[] regRent = new int[]{reg0, reg1, reg2, reg3, reg4, regHotel};
        public static final int[] bonusRent = new int[]{bonus0, bonus1, bonus2, bonus3, bonus4, bonusHotel};
    }

    // St. Charles, States, and Virginia
    public static class OrchidConstants {
        public static final int regPrice = 140;
        public static final int bonusPrice = 160;

        public static final int housePrice = 100;

        public static final int reg0 = 10;
        public static final int reg1 = 50;
        public static final int reg2 = 150;
        public static final int reg3 = 450;
        public static final int reg4 = 625;
        public static final int regHotel = 750;

        public static final int bonus0 = 12;
        public static final int bonus1 = 60;
        public static final int bonus2 = 180;
        public static final int bonus3 = 500;
        public static final int bonus4 = 700;
        public static final int bonusHotel = 900;

        public static final int[] regRent = new int[]{reg0, reg1, reg2, reg3, reg4, regHotel};
        public static final int[] bonusRent = new int[]{bonus0, bonus1, bonus2, bonus3, bonus4, bonusHotel};
    }

    // St. James, Tennessee, and New York
    public static class TangerineConstants {
        public static final int regPrice = 180;
        public static final int bonusPrice = 200;

        public static final int housePrice = 100;

        public static final int reg0 = 14;
        public static final int reg1 = 70;
        public static final int reg2 = 200;
        public static final int reg3 = 550;
        public static final int reg4 = 750;
        public static final int regHotel = 950;

        public static final int bonus0 = 16;
        public static final int bonus1 = 80;
        public static final int bonus2 = 220;
        public static final int bonus3 = 600;
        public static final int bonus4 = 800;
        public static final int bonusHotel = 1000;

        public static final int[] regRent = new int[]{reg0, reg1, reg2, reg3, reg4, regHotel};
        public static final int[] bonusRent = new int[]{bonus0, bonus1, bonus2, bonus3, bonus4, bonusHotel};
    }

    // Kentucky, Indiana, Illinois
    public static class RedConstants {
        public static final int regPrice = 180;
        public static final int bonusPrice = 200;

        public static final int housePrice = 150;

        public static final int reg0 = 18;
        public static final int reg1 = 90;
        public static final int reg2 = 250;
        public static final int reg3 = 700;
        public static final int reg4 = 875;
        public static final int regHotel = 1050;

        public static final int bonus0 = 20;
        public static final int bonus1 = 100;
        public static final int bonus2 = 300;
        public static final int bonus3 = 750;
        public static final int bonus4 = 925;
        public static final int bonusHotel = 1100;

        public static final int[] regRent = new int[]{reg0, reg1, reg2, reg3, reg4, regHotel};
        public static final int[] bonusRent = new int[]{bonus0, bonus1, bonus2, bonus3, bonus4, bonusHotel};
    }

    // Atlantic, Ventnor, Marvin
    public static class LemonConstants {
        public static final int regPrice = 260;
        public static final int bonusPrice = 280;

        public static final int housePrice = 150;

        public static final int reg0 = 22;
        public static final int reg1 = 110;
        public static final int reg2 = 330;
        public static final int reg3 = 800;
        public static final int reg4 = 975;
        public static final int regHotel = 1150;

        public static final int bonus0 = 24;
        public static final int bonus1 = 120;
        public static final int bonus2 = 360;
        public static final int bonus3 = 850;
        public static final int bonus4 = 1025;
        public static final int bonusHotel = 1200;

        public static final int[] regRent = new int[]{reg0, reg1, reg2, reg3, reg4, regHotel};
        public static final int[] bonusRent = new int[]{bonus0, bonus1, bonus2, bonus3, bonus4, bonusHotel};
    }

    // Pacific, North Carolina, Pennsylvania
    public static class ForestConstants {
        public static final int regPrice = 300;
        public static final int bonusPrice = 320;

        public static final int housePrice = 200;

        public static final int reg0 = 26;
        public static final int reg1 = 130;
        public static final int reg2 = 390;
        public static final int reg3 = 900;
        public static final int reg4 = 1100;
        public static final int regHotel = 1275;

        public static final int bonus0 = 28;
        public static final int bonus1 = 150;
        public static final int bonus2 = 450;
        public static final int bonus3 = 1000;
        public static final int bonus4 = 1200;
        public static final int bonusHotel = 1400;

        public static final int[] regRent = new int[]{reg0, reg1, reg2, reg3, reg4, regHotel};
        public static final int[] bonusRent = new int[]{bonus0, bonus1, bonus2, bonus3, bonus4, bonusHotel};
    }

    // Park Place, Boardwalk
    public static class BlueConstants {
        public static final int regPrice = 350;
        public static final int bonusPrice = 400;

        public static final int housePrice = 200;

        public static final int reg0 = 35;
        public static final int reg1 = 175;
        public static final int reg2 = 500;
        public static final int reg3 = 1100;
        public static final int reg4 = 1300;
        public static final int regHotel = 1500;

        public static final int bonus0 = 50;
        public static final int bonus1 = 200;
        public static final int bonus2 = 600;
        public static final int bonus3 = 1400;
        public static final int bonus4 = 1700;
        public static final int bonusHotel = 2000;

        public static final int[] regRent = new int[]{reg0, reg1, reg2, reg3, reg4, regHotel};
        public static final int[] bonusRent = new int[]{bonus0, bonus1, bonus2, bonus3, bonus4, bonusHotel};
    }

    public static class RailroadConstants {
        public static final int price = 200;
        public static final int rent0 = 25;
        public static final int rent1 = 50;
        public static final int rent2 = 75;
        public static final int rent3 = 100;
        public static final int[] rent = new int[]{rent0, rent1, rent2, rent3};
    }

    public static class UtilityConstants {
        public static final int price = 150;
    }

    public static class BoardConstants {
        // All units in pixels (px)
        public static final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        public static final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height - 50;

        public static final int popupScreenWidth = (int) (screenWidth * 0.25);
        public static final int popupScreenHeight = (int) (screenHeight * 0.25);

        public static final int boardDimension = screenHeight - 100;
        public static final int boardStartX = (screenWidth - boardDimension) / 2;
        public static final int boardStartY = (screenHeight - boardDimension) / 2;
        public static final int boardEndX = boardStartX + boardDimension;
        public static final int boardEndY = boardStartY + boardDimension;

        public static final int shortSide = 64;
        public static final int longSide = 104;

        public static final int longDie = 128;
        public static final int shortDie = 64;

        public static final int tokenHeight = 32;
        public static final int tokenWidth = 64;

        public static final BoardComponent go = new BoardComponent(boardEndX - longSide, boardEndY - longSide, longSide, longSide, "src/monopoly/img/go.jpg");
        public static final BoardComponent mediterranean = new BoardComponent(go.getX() - shortSide, boardEndY - longSide, shortSide, longSide, "src/monopoly/img/mediterranean.jpg", PropertyConstants.mediterranean);
        public static final BoardComponent comm1 = new BoardComponent(mediterranean.getX() - shortSide, boardEndY - longSide, shortSide, longSide, "src/monopoly/img/comm1.jpg", PropertyConstants.comm1);
        public static final BoardComponent baltic = new BoardComponent(comm1.getX() - shortSide, boardEndY - longSide, shortSide, longSide, "src/monopoly/img/baltic.jpg", PropertyConstants.baltic);
        public static final BoardComponent income = new BoardComponent(baltic.getX() - shortSide, boardEndY - longSide, shortSide, longSide, "src/monopoly/img/income.jpg", PropertyConstants.income);
        public static final BoardComponent readingRR = new BoardComponent(income.getX() - shortSide, boardEndY - longSide, shortSide, longSide, "src/monopoly/img/readingRR.jpg", PropertyConstants.readingRR);
        public static final BoardComponent oriental = new BoardComponent(readingRR.getX() - shortSide, boardEndY - longSide, shortSide, longSide, "src/monopoly/img/oriental.jpg", PropertyConstants.oriental);
        public static final BoardComponent chance1 = new BoardComponent(oriental.getX() - shortSide, boardEndY - longSide, shortSide, longSide, "src/monopoly/img/chance1.jpg", PropertyConstants.chance1);
        public static final BoardComponent vermont = new BoardComponent(chance1.getX() - shortSide, boardEndY - longSide, shortSide, longSide, "src/monopoly/img/vermont.jpg", PropertyConstants.vermont);
        public static final BoardComponent connecticut = new BoardComponent(vermont.getX() - shortSide, boardEndY - longSide, shortSide, longSide, "src/monopoly/img/connecticut.jpg", PropertyConstants.connecticut);
        public static final BoardComponent jail = new BoardComponent(connecticut.getX() - longSide, boardEndY - longSide, longSide, longSide, "src/monopoly/img/jail.jpg", PropertyConstants.jail);
        public static final BoardComponent charles = new BoardComponent(jail.getX(), jail.getY() - shortSide, longSide, shortSide, "src/monopoly/img/charles.jpg", PropertyConstants.charles);
        public static final BoardComponent electric = new BoardComponent(jail.getX(), charles.getY() - shortSide, longSide, shortSide, "src/monopoly/img/electric.jpg", PropertyConstants.electric);
        public static final BoardComponent states = new BoardComponent(jail.getX(), electric.getY() - shortSide, longSide, shortSide, "src/monopoly/img/states.jpg", PropertyConstants.states);
        public static final BoardComponent virginia = new BoardComponent(jail.getX(), states.getY() - shortSide, longSide, shortSide, "src/monopoly/img/virginia.jpg", PropertyConstants.virginia);
        public static final BoardComponent pennRR = new BoardComponent(jail.getX(), virginia.getY() - shortSide, longSide, shortSide, "src/monopoly/img/pennRR.jpg", PropertyConstants.pennRR);
        public static final BoardComponent james = new BoardComponent(jail.getX(), pennRR.getY() - shortSide, longSide, shortSide, "src/monopoly/img/james.jpg", PropertyConstants.james);
        public static final BoardComponent comm2 = new BoardComponent(jail.getX(), james.getY() - shortSide, longSide, shortSide, "src/monopoly/img/comm2.jpg", PropertyConstants.comm2);
        public static final BoardComponent tennessee = new BoardComponent(jail.getX(), comm2.getY() - shortSide, longSide, shortSide, "src/monopoly/img/tennessee.jpg", PropertyConstants.tennessee);
        public static final BoardComponent york = new BoardComponent(jail.getX(), tennessee.getY() - shortSide, longSide, shortSide, "src/monopoly/img/york.jpg", PropertyConstants.york);
        public static final BoardComponent parking = new BoardComponent(jail.getX(), york.getY() - longSide, longSide, longSide, "src/monopoly/img/parking.jpg");
        public static final BoardComponent kentucky = new BoardComponent(parking.getX() + longSide, parking.getY(), shortSide, longSide, "src/monopoly/img/kentucky.jpg", PropertyConstants.kentucky);
        public static final BoardComponent chance2 = new BoardComponent(kentucky.getX() + shortSide, parking.getY(), shortSide, longSide, "src/monopoly/img/chance2.jpg", PropertyConstants.chance2);
        public static final BoardComponent indiana = new BoardComponent(chance2.getX() + shortSide, parking.getY(), shortSide, longSide, "src/monopoly/img/indiana.jpg", PropertyConstants.indiana);
        public static final BoardComponent illinois = new BoardComponent(indiana.getX() + shortSide, parking.getY(), shortSide, longSide, "src/monopoly/img/illinois.jpg", PropertyConstants.illinois);
        public static final BoardComponent boRR = new BoardComponent(illinois.getX() + shortSide, parking.getY(), shortSide, longSide, "src/monopoly/img/boRR.jpg", PropertyConstants.boRR);
        public static final BoardComponent atlantic = new BoardComponent(boRR.getX() + shortSide, parking.getY(), shortSide, longSide, "src/monopoly/img/atlantic.jpg", PropertyConstants.atlantic);
        public static final BoardComponent ventnor = new BoardComponent(atlantic.getX() + shortSide, parking.getY(), shortSide, longSide, "src/monopoly/img/ventnor.jpg", PropertyConstants.ventnor);
        public static final BoardComponent water = new BoardComponent(ventnor.getX() + shortSide, parking.getY(), shortSide, longSide, "src/monopoly/img/water.jpg", PropertyConstants.water);
        public static final BoardComponent marvin = new BoardComponent(water.getX() + shortSide, parking.getY(), shortSide, longSide, "src/monopoly/img/marvin.jpg", PropertyConstants.marvin);
        public static final BoardComponent goToJail = new BoardComponent(marvin.getX() + shortSide, parking.getY(), longSide, longSide, "src/monopoly/img/gotojail.jpg");
        public static final BoardComponent pacific = new BoardComponent(goToJail.getX(), goToJail.getY() + longSide, longSide, shortSide, "src/monopoly/img/pacific.jpg", PropertyConstants.pacific);
        public static final BoardComponent carolina = new BoardComponent(goToJail.getX(), pacific.getY() + shortSide, longSide, shortSide, "src/monopoly/img/carolina.jpg", PropertyConstants.carolina);
        public static final BoardComponent comm3 = new BoardComponent(goToJail.getX(), carolina.getY() + shortSide, longSide, shortSide, "src/monopoly/img/comm3.jpg", PropertyConstants.comm3);
        public static final BoardComponent pennsylvania = new BoardComponent(goToJail.getX(), comm3.getY() + shortSide, longSide, shortSide, "src/monopoly/img/pennsylvania.jpg", PropertyConstants.pennsylvania);
        public static final BoardComponent shortLineRR = new BoardComponent(goToJail.getX(), pennsylvania.getY() + shortSide, longSide, shortSide, "src/monopoly/img/shortLineRR.jpg", PropertyConstants.shortLineRR);
        public static final BoardComponent chance3 = new BoardComponent(goToJail.getX(), shortLineRR.getY() + shortSide, longSide, shortSide, "src/monopoly/img/chance3.jpg", PropertyConstants.chance3);
        public static final BoardComponent parkPlace = new BoardComponent(goToJail.getX(), chance3.getY() + shortSide, longSide, shortSide, "src/monopoly/img/parkPlace.jpg", PropertyConstants.parkPlace);
        public static final BoardComponent luxury = new BoardComponent(goToJail.getX(), parkPlace.getY() + shortSide, longSide, shortSide, "src/monopoly/img/luxury.jpg", PropertyConstants.luxury);
        public static final BoardComponent boardwalk = new BoardComponent(goToJail.getX(), luxury.getY() + shortSide, longSide, shortSide, "src/monopoly/img/boardwalk.jpg", PropertyConstants.boardwalk);

        public static final HashMap<Integer, BoardComponent> positionMap = new HashMap<>() {{
            put(0, go);
            put(1, mediterranean);
            put(2, comm1);
            put(3, baltic);
            put(4, income);
            put(5, readingRR);
            put(6, oriental);
            put(7, chance1);
            put(8, vermont);
            put(9, connecticut);
            put(10, jail);
            put(11, charles);
            put(12, electric);
            put(13, states);
            put(14, virginia);
            put(15, pennRR);
            put(16, james);
            put(17, comm2);
            put(18, tennessee);
            put(19, york);
            put(20, parking);
            put(21, kentucky);
            put(22, chance2);
            put(23, indiana);
            put(24, illinois);
            put(25, boRR);
            put(26, atlantic);
            put(27, ventnor);
            put(28, water);
            put(29, marvin);
            put(30, goToJail);
            put(31, pacific);
            put(32, carolina);
            put(33, comm3);
            put(34, pennsylvania);
            put(35, shortLineRR);
            put(36, chance3);
            put(37, parkPlace);
            put(38, luxury);
            put(39, boardwalk);
        }};

        public static final Player nullPlayer = new Player("null", null);
        public static Player chanceGOOJ = nullPlayer;
        public static Player commGOOJ = nullPlayer;

        public static boolean sameTurnOverride = false;

        public static final BoardComponent center = new BoardComponent(connecticut.getX(), york.getY(), pacific.getX() - connecticut.getX(), mediterranean.getY() - york.getY(), "src/monopoly/img/center.jpg", false);

        public static final DiceComponent dice = new DiceComponent(parking.getX() / 2, parking.getY(), longDie, shortDie, new String[]{"src/monopoly/img/die_1.png", "src/monopoly/img/die_2.png", "src/monopoly/img/die_3.png", "src/monopoly/img/die_4.png", "src/monopoly/img/die_5.png", "src/monopoly/img/die_6.png"});

        public static ArrayList<String> chance = new ArrayList<>(Arrays.asList(
                "src/monopoly/img/ch_back.jpg",
                "src/monopoly/img/ch_boardwalk.jpg",
                "src/monopoly/img/ch_buildingLoan.jpg",
                "src/monopoly/img/ch_chairman.jpg",
                "src/monopoly/img/ch_charles.jpg",
                "src/monopoly/img/ch_dividend.jpg",
                "src/monopoly/img/ch_dup.jpg",
                "src/monopoly/img/ch_go.jpg",
                "src/monopoly/img/ch_illinois.jpg",
                "src/monopoly/img/ch_jail.jpg",
                "src/monopoly/img/ch_jailbreak.jpg",
                "src/monopoly/img/ch_nearRR.jpg",
                "src/monopoly/img/ch_poor.jpg",
                "src/monopoly/img/ch_reading.jpg",
                "src/monopoly/img/ch_repairs.jpg",
                "src/monopoly/img/ch_utility.jpg"
        ));
        public static ArrayList<String> communityChest = new ArrayList<>(Arrays.asList(
                "src/monopoly/img/comm_bank.jpg",
                "src/monopoly/img/comm_beauty.jpg",
                "src/monopoly/img/comm_doctor.jpg",
                "src/monopoly/img/comm_go.jpg",
                "src/monopoly/img/comm_hospital.jpg",
                "src/monopoly/img/comm_inherit.jpg",
                "src/monopoly/img/comm_insurance.jpg",
                "src/monopoly/img/comm_jail.jpg",
                "src/monopoly/img/comm_jailbreak.jpg",
                "src/monopoly/img/comm_opera.jpg",
                "src/monopoly/img/comm_repair.jpg",
                "src/monopoly/img/comm_school.jpg",
                "src/monopoly/img/comm_services.jpg",
                "src/monopoly/img/comm_stock.jpg",
                "src/monopoly/img/comm_tax.jpg",
                "src/monopoly/img/comm_xmas.jpg"
        ));

        public static final int playerStatsX = parking.getX() / 2;
        public static final int playerStatsY = 250;
        public static final int playerStatsPadding = 45;
        public static final Font playerFont = new Font("SansSerif", Font.PLAIN, 24);

        public static final int propertyPadding = 12;
        public static final int propertySquareDimensions = 12;
        public static final Font propertyFont = new Font("SansSerif", Font.PLAIN, 12);

        public static final ArrayList<BoardComponent> components = new ArrayList<>(Arrays.asList(go,
                mediterranean, comm1, baltic, income, readingRR, oriental, chance1, vermont, connecticut, jail,
                charles, electric, states, virginia, pennRR, james, comm2, tennessee, york, parking,
                kentucky, chance2, indiana, illinois, boRR, atlantic, ventnor, water, marvin, goToJail,
                pacific, carolina, comm3, pennsylvania, shortLineRR, chance3, parkPlace, luxury, boardwalk, center));
    }
}

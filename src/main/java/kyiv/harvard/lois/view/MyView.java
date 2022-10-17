/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.view
 * Class: MyView
 **/

package kyiv.harvard.lois.view;


import kyiv.harvard.lois.controller.GameController;
import kyiv.harvard.lois.controller.PlatformController;
import kyiv.harvard.lois.controller.SteamController;
import kyiv.harvard.lois.controller.UserController;
import kyiv.harvard.lois.domain.Game;
import kyiv.harvard.lois.domain.Platform;
import kyiv.harvard.lois.domain.Steam;
import kyiv.harvard.lois.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {
    @Autowired
    private GameController gameController;

    @Autowired
    private UserController userController;

    @Autowired
    private SteamController steamController;

    @Autowired
    private PlatformController platformController;

    final Map<String, String> menu;
    final Map<String, Printable> methodsMenu;
    final Scanner input = new Scanner(System.in);
    final Game nullGame = new Game(null, null, null, null, null);
    final Steam nullSteam = new Steam(null, null, null, null);
    final User nullUser = new User(null, null, null, null, null);
    final Platform nullPlatform = new Platform(null, null);

    public MyView() {
        menu = new LinkedHashMap<>();

        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Game");
        menu.put("11", "  11 - Create Game");
        menu.put("12", "  12 - Update Game");
        menu.put("13", "  13 - Delete from Game");
        menu.put("14", "  14 - Find all Games");
        menu.put("15", "  15 - Find Game by ID");
        menu.put("16", "  16 - Find Game by genre");
        menu.put("17", "  17 - Find Game by rating");

        menu.put("2", "   2 - Table: User");
        menu.put("21", "  21 - Create User");
        menu.put("22", "  22 - Update User");
        menu.put("23", "  23 - Delete from User");
        menu.put("24", "  24 - Find all Users");
        menu.put("25", "  25 - Find User by ID");

        menu.put("3", "   3 - Table: Steam");
        menu.put("31", "  31 - Create Steam");
        menu.put("32", "  32 - Update Steam");
        menu.put("33", "  33 - Delete from Steam");
        menu.put("34", "  34 - Find all Steams");
        menu.put("35", "  35 - Find Steam by ID");
        menu.put("36", "  36 - Find all Games by Steam ID");

        menu.put("4", "   4 - Table: Platform");
        menu.put("41", "  41 - Create Platform");
        menu.put("42", "  42 - Update Platform");
        menu.put("43", "  43 - Delete from Platform");
        menu.put("44", "  44 - Find all Platforms");
        menu.put("45", "  45 - Find Platform by ID");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createGame);
        methodsMenu.put("12", this::updateGame);
        methodsMenu.put("13", this::deleteFromGame);
        methodsMenu.put("14", this::findAllGames);
        methodsMenu.put("15", this::findGameById);
        methodsMenu.put("16", this::findGameByGameGenre);
        methodsMenu.put("17", this::findGameByGameRating);

        methodsMenu.put("21", this::createUser);
        methodsMenu.put("22", this::updateUser);
        methodsMenu.put("23", this::deleteFromUser);
        methodsMenu.put("24", this::findAllUsers);
        methodsMenu.put("25", this::findUserById);

        methodsMenu.put("31", this::createSteam);
        methodsMenu.put("32", this::updateSteam);
        methodsMenu.put("33", this::deleteFromSteam);
        methodsMenu.put("34", this::findAllSteams);
        methodsMenu.put("35", this::findSteamById);
        methodsMenu.put("36", this::findAllGamesById);

        methodsMenu.put("41", this::createPlatform);
        methodsMenu.put("42", this::updatePlatform);
        methodsMenu.put("43", this::deleteFromPlatform);
        methodsMenu.put("44", this::findAllPlatforms);
        methodsMenu.put("45", this::findPlatformById);
    }

    private void selectAllTable() {
        findAllGames();
        findAllUsers();
        findAllSteams();
        findAllPlatforms();
    }

    // region Game ---------------------------------------------------
    private void createGame() {
        System.out.println("Input new 'genre': ");
        String genre = input.nextLine();
        System.out.println("Input new 'rating': ");
        Integer rating = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'engine': ");
        String engine = input.nextLine();
        System.out.println("Input new 'platformId': ");
        Integer platformId = Integer.valueOf((input.nextLine()));
        Game game = new Game(null, genre, rating, engine, platformId);

        int count = gameController.create(game);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateGame() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'genre': ");
        String genre = input.nextLine();
        System.out.println("Input new 'rating': ");
        Integer rating = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'engine': ");
        String engine = input.nextLine();
        System.out.println("Input new 'platformId': ");
        Integer platformId = Integer.valueOf((input.nextLine()));
        Game game = new Game(null, genre, rating,engine,platformId);

        int count = gameController.update(id, game);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromGame() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = gameController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllGames() {
        System.out.println("\nTable: GAME");
        List<Game> games = gameController.findAll();
        for (Game game : games) {
            System.out.println(game);
        }
    }

    private void findGameById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Game> game = gameController.findById(id);
        System.out.println(game.orElse(nullGame));
    }

    private void findGameByGameGenre() {
        System.out.println("Input 'game genre': ");
        String genre = input.nextLine();

        Optional<Game> game = gameController.findByGameGenre(genre);
        System.out.println(game.orElse(nullGame));
    }

    private void findGameByGameRating() {
        System.out.println("Input 'rating': ");
        String rating = input.nextLine();

        Optional<Game> game = gameController.findByGameRating(rating);
        System.out.println(game.orElse(nullGame));
    }
    //endregion game


    // region USER ------------------------------------------
    private void createUser() {
        System.out.println("Input 'user name': ");
        String name = input.nextLine();
        System.out.println("Input 'user surname': ");
        String surname = input.nextLine();
        System.out.println("Input 'user age': ");
        Integer age = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user platformId': ");
        Integer platformId = Integer.valueOf((input.nextLine()));

        User user = new User(null, name, surname, age ,platformId);

        int count = userController.create(user);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user name': ");
        String name = input.nextLine();
        System.out.println("Input 'user surname': ");
        String surname = input.nextLine();
        System.out.println("Input 'user age': ");
        Integer age = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user platformId': ");
        Integer platformId = Integer.valueOf((input.nextLine()));

        User user = new User(null, name, surname, age ,platformId);

        int count = userController.update(id, user);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = userController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllUsers() {
        System.out.println("\nTable: USER");
        List<User> users = userController.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    private void findUserById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<User> user = userController.findById(id);
        System.out.println(user.orElse(nullUser));
    }
    //endregion USER


    // region Steam -------------------------------------------------
    private void createSteam() {
        System.out.println("Input 'moneyOnSteam': ");
        Integer moneyOnSteam = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'numberOfFriends': ");
        Integer numberOfFriends = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'userId': ");
        Integer userId = Integer.valueOf((input.nextLine()));

        Steam steam = new Steam(null, moneyOnSteam, numberOfFriends,
                userId);

        int count = steamController.create(steam);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateSteam() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'moneyOnSteam': ");
        Integer moneyOnSteam = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'numberOfFriends': ");
        Integer numberOfFriends = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'userId': ");
        Integer userId = Integer.valueOf((input.nextLine()));

        Steam steam = new Steam(null, moneyOnSteam, numberOfFriends,
                userId);

        int count = steamController.update(id, steam);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromSteam() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = steamController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllSteams() {
        System.out.println("\nTable: STEAM");
        List<Steam> steams = steamController.findAll();
        for (Steam steam : steams) {
            System.out.println(steam);
        }
    }

    private void findSteamById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Steam> steam = steamController.findById(id);
        System.out.println(steam.orElse(nullSteam));
    }

    private void findAllGamesById() {
        System.out.println("Input 'steam id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        List<Game> games = steamController.findAllGamesBy(id);
        for (Game game : games) {
            System.out.println(game);
        }
    }
    //endregion STEAM


    // region Platform
    private void createPlatform() {
        System.out.println("Input 'platformName': ");
        String platformName = input.nextLine();


        Platform platform = new Platform(null, platformName);

        int count = platformController.create(platform);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updatePlatform() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'platformName': ");
        String platformName = input.nextLine();

        Platform platform = new Platform(null, platformName);

        int count = platformController.update(id, platform);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromPlatform() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = platformController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllPlatforms() {
        System.out.println("\nTable: PLATFORM");
        List<Platform> platforms = platformController.findAll();
        for (Platform platform : platforms) {
            System.out.println(platform);
        }
    }

    private void findPlatformById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Platform> platform = platformController.findById(id);
        System.out.println(platform.orElse(nullPlatform));
    }
    // endregion PLATFORM

    //-------------------------------------------------------------------------

    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {
        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }


            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }
    //endregion output

}

import java.util.*;

public class Main {

    private static final List<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    

    private static int userID = 1000;

    private static void addDemoData() {

        User user1 = new User("vimosh", "VIMOSH", 2000);
        user1.setHomeland(new Hillcrest());
        user1.createArmy(new Shooter(), new Squire(), new Enchanter(), new Medic(), new Basilisk());
        user1.subtractGoldCoins(480);
        users.add(user1);

        User user2 = new User("abishan", "ABISHAN", 2001);
        user2.setHomeland(new Marshland());
        user2.createArmy(new Ranger(), new Cavalier(), new Illusionist(), new Saint(), new Dragon());
        user2.subtractGoldCoins(490);
        users.add(user2);

        User user3 = new User("nived", "NIVED", 2002);
        user3.setHomeland(new Desert());
        user3.createArmy(new Sunfire(), new Swiftblade(), new Conjurer(), new Soother(), new Hydra());
        user3.subtractGoldCoins(470);
        users.add(user3);

        User user4 = new User("aadhi", "AADHI", 2003);
        user4.setHomeland(new Arcane());
        user4.createArmy(new Zing(), new Templar(), new Eldritch(), new Lightbringer(), new Pegasus());
        user4.subtractGoldCoins(450);
        users.add(user4);
    }
    

    public static void main(String[] args) {


        while (true) {
            addDemoData();
            System.out.println();
            System.out.println("Welcome to the Game\n");
            System.out.println("Main Menu:");
            System.out.println();
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        }
    }

    private static void signUp() {

        System.out.println();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if the username already exists
        if (userExists(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            System.out.println();
            return;
        }

        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine(
        );
        System.out.println();
        // new----------------------------------------------------
        System.out.println("Select your home ground for battles:");
        System.out.println("-------------------------------------");
        System.out.println("1. Hillcrest" );
        System.out.println("2. Marshland");
        System.out.println("3. Desert");
        System.out.println("4. Arcane\n");
        System.out.print("Enter your choice: ");
        int playgroundChoice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println();
    
        String playground;
        switch (playgroundChoice) {
            case 1:
                playground = "Hillcrest";
                break;
            case 2:
                playground = "Marshland";
                break;
            case 3:
                playground = "Desert";
                break;
            case 4:
                playground = "Arcane";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Hillcrest.\n");
                playground = "Hillcrest";
        }
    
        User newUser = new User(username, playerName, userID);
        newUser.setHomeland(new playground(playground));

        users.add(newUser);
        System.out.println();
        System.out.println("Account created successfully.");
        System.out.println("Your user ID is: " + userID );
        // Award 500 gold coins to the new user
        System.out.println("You have been awarded "+newUser.getGoldCoins()+" gold coins.");
        System.out.println();
        // newUser.addGoldCoins(0);
        System.out.println("Now, let's buy an army for your user.");
        System.out.println();
        openShop(newUser);
        //displayUsers(); // Display users after sign up
        userID++; // Increment userID for the next user
    }

    private static boolean userExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("-- Welcome, " + user.getPlayerName() + "!");
                System.out.println("-- available coins : " + user.getGoldCoins()+"\n");
                System.out.println(user.getArmyComposition());
                while (true) {
                    System.out.println();
                    System.out.println("1. Play Battle");
                    System.out.println("2. Change Player Name");
                    System.out.println("3. Shop");
                    System.out.println("4. View your Army");
                    System.out.println("5. View your Gold Coins");
                    System.out.println("6. Back to Menu");
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println();
                    switch (choice) {
                        case 1:
                            selectOpponent(user);
                            break;
                        case 2:
                            changePlayerName(user);
                            break;
                        case 3:
                            openShop(user);
                            break;
                        case 4:
                            System.out.println(user.getArmyComposition());
                            break;
                        case 5:
                            System.out.println("Gold coins: " + user.getGoldCoins());
                            break;
                        case 6:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }
        System.out.println("Username not found.");
        System.out.println();
    }

    private static void selectOpponent(User user) {
        List<User> availableOpponents = new ArrayList<>();
        for (User opponent : users) {
            if (!opponent.getUsername().equals(user.getUsername())) {
                availableOpponents.add(opponent);
            }
        }

        int index = 0;
        while (true) {
            if (index < availableOpponents.size()) {
                User opponent = availableOpponents.get(index);
                System.out.println(opponent.getPlayerName() + " - " + opponent.getXP() + "XP");
                System.out.println("1. Play");
                if (index < availableOpponents.size() - 1) {
                    System.out.println("2. Next");
                }
                System.out.println("3. Back to Menu");
                System.out.println();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println();
                switch (choice) {
                    case 1:
                        playBattle(user, opponent);
                        return;
                    case 2:
                        index++;
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } 

            else 
            {
                System.out.println("No more opponents available.");
                return;
            }
        }
    }

    private static void playBattle(User user, User opponent) 
    {
        System.out.println(user.getArmyComposition());
        System.out.println();
        System.out.println("Starting battle in...");
        countdown();
        System.out.println(user.getPlayerName() + " vs " + opponent.getPlayerName());
        System.out.println();
        // startBattle(user, opponent);
        if (!user.hasCharacterOfCategory(Archer.class) || !user.hasCharacterOfCategory(Knight.class) ||!user.hasCharacterOfCategory(Mage.class) || !user.hasCharacterOfCategory(Healer.class) || !user.hasCharacterOfCategory(MythicalCreature.class)) {
        System.out.println("You need to have one character from each category before proceeding to the shop.");
        buyArmy(user);} // Redirect to buy characters
        playBattle playBattle = new playBattle(user, opponent);

    }

    private static void buyEquipments(User user) {
        while (true) {
            System.out.println("Choose an equipment category");
            System.out.println("-----------------------------");
            System.out.println("1. Armour");
            System.out.println("2. Artefact");
            System.out.println("3. Back to Login Menu");
            System.out.println("-----------------------------");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println();
            switch (choice) {
                case 1:
                    buyArmour(user);
                    break;
                case 2:
                    buyArtefact(user);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void buyArtefact(User user) {
        System.out.println("Gold left: " + user.getGoldCoins());
        
        // Choose a character to buy artefact for
        System.out.println("Choose a character to buy artefact for\n");
        System.out.println("--------------------------------------");
        System.out.println("1. Archer");
        System.out.println("2. Knight");
        System.out.println("3. Mage");
        System.out.println("4. Healer");
        System.out.println("5. Mythical Creature");
        System.out.println("6. Cancel");
        System.out.println("--------------------------------------");
        int characterChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Character character = null;
        
        switch (characterChoice) {
            case 1:
                if (!user.hasCharacterOfCategory(Archer.class)) {
                    System.out.println("You don't have an archer.\n");
                    return;
                }
                character = user.getArcher();
                break;
            case 2:
                if (!user.hasCharacterOfCategory(Knight.class)) {
                    System.out.println("You don't have a knight.\n");
                    return;
                }
                character = user.getKnight();
                break;
            case 3:
                if (!user.hasCharacterOfCategory(Mage.class)) {
                    System.out.println("You don't have a mage.\n");
                    return;
                }
                character = user.getMage();
                break;
            case 4:
                if (!user.hasCharacterOfCategory(Healer.class)) {
                    System.out.println("You don't have a healer.\n");
                    return;
                }
                character = user.getHealer();
                break;
            case 5:
                if (!user.hasCharacterOfCategory(MythicalCreature.class)) {
                    System.out.println("You don't have a mythical creature.\n");
                    return;
                }
                character = user.getMythicalCreature();
                break;
            case 6:
                System.out.println("Cancelled buying artefact.\n");
                return;
            default:
                System.out.println("Invalid choice.\n");
                return;
        }
        
        // Choose artefact to buy: Excalibur, Amulet, Crystal
        System.out.println("Choose an artefact to buy");
        System.out.println("-------------------------");
        System.out.println("1. Excalibur - 150 gc");
        System.out.println("2. Amulet - 200 gc");
        System.out.println("3. Crystal - 210 gc");
        System.out.println("4. Skip buying artefact.");
        System.out.println("-------------------------\n");
        int artefactChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Artefact artefact = null;
        
        switch (artefactChoice) {
            case 1:
                System.out.println("You chose Excalibur.\n");
                artefact = new Excaliber();
                break;
            case 2:
                System.out.println("You chose Amulet.\n");
                artefact = new Amulet();
                break;
            case 3:
                System.out.println("You chose Crystal.\n");
                artefact = new Crystal();
                break;
            case 4:
                System.out.println("You chose to skip buying artefact.\n");
                return;
            default:
                System.out.println("Invalid choice.\n");
                return;
        }
        
        if (artefact != null) {
            if (user.getGoldCoins() >= artefact.getPrice()) {
                character.setArtefact(artefact);
                System.out.println("------------------------------------");
                user.setGoldcoins(user.getGoldCoins() - artefact.getPrice());
                System.out.println("Bought " + artefact.getName() + " for " + artefact.getPrice() + " gold.");
                System.out.println("------------------------------------\n");
            } else {
                System.out.println("------------------------------------");
                System.out.println("Not enough gold to buy " + artefact.getName() + ".");
                System.out.println("------------------------------------\n");
            }
        }
    }
    

    private static void buyArmour(User user) {
        System.out.println("Gold left: " + user.getGoldCoins());
        System.out.println("\nChoose a character to buy armor for:\n1. Archer\n2. Knight\n3. Mage\n4. Healer\n5. Mythical Creature \n6. Back to Shop\n");
        System.out.print("Enter your choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println();
        Character character = null;
        switch (choice) {
            case 1:
                System.out.println("You have chosen your Archer.\n");
                character = user.getArcher();
                break;
            case 2:
                System.out.println("You have chosen your Knight.\n");
                character = user.getKnight();
                break;
            case 3:
                System.out.println("You have chosen your Mage.\n");
                character = user.getMage();
                break;
            case 4:
                System.out.println("You have chosen your Healer.\n");
                character = user.getHealer();
                break;
            case 5:
                System.out.println("You have chosen your Mythical Creature.\n");
                character = user.getMythicalCreature();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice.\n");
        }
        
        // Choose armor to buy: Chainmail, Regalia, Fleece
        System.out.println("Choose an armor to buy:\n1. Chainmail - 70 gc\n2. Regalia - 105 gc\n3. Fleece - 150 gc\n4. Skip buying armor\n");
        int armourChoice = scanner.nextInt();
        System.out.print("Enter your choice : ");
        scanner.nextLine(); // Consume newline
        System.out.println();
        Armour armour = null;
        switch (armourChoice) {
            case 1:
                System.out.println("You have chosen the Chainmail.\n");
                armour = new Chainmail();
                break;
            case 2:
                System.out.println("You have chosen the Regalia.\n");
                armour = new Regalia();
                break;
            case 3:
                System.out.println("You have chosen the Fleece.\n");
                armour = new Fleece();
                break;
            case 4:
                System.out.println("You have chosen to skip buying an armor.\n");
                return;
            default:
                System.out.println("Invalid choice.\n");
        }
        
        if (armour != null) {
            if (user.getGoldCoins() >= armour.getPrice()) {
                character.setArmour(armour);
                user.setGoldcoins(user.getGoldCoins() - armour.getPrice());
                System.out.println("------------------------------------");
                System.out.println("Bought " + armour.getName() + " for " + armour.getPrice() + " gold coins.");
                System.out.println("Gold left: " + user.getGoldCoins());
                System.out.println("------------------------------------\n");
            } else {
                warning();
                System.out.println("------------------------------------");
                System.out.println("Not enough gold to buy " + armour.getName() + ".");
                System.out.println("Gold left: " + user.getGoldCoins());
                System.out.println("------------------------------------");
                System.out.println();
                return;
            }
        }
    }
    
    private static void countdown() {
        try {
            for (int i = 3; i > 0; i--) {
                System.out.print(i + "... ");
                Thread.sleep(1000); // Wait for 1 second
            }
            System.out.println("Go!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void loading() {
        try {
            System.out.print("- Loading ... ");
            Thread.sleep(1000); // Wait for 1 second
            System.out.println("\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void warning() {
        try {
            System.out.print("- Warning ... ");
            Thread.sleep(1000); // Wait for 1 second
            System.out.println("\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void changePlayerName(User user) {
        System.out.print("Enter new player name: ");
        String newPlayerName = scanner.nextLine();
        user.setPlayerName(newPlayerName);
        System.out.println("Player name changed successfully.\n");
        System.out.println("New player name: " + user.getPlayerName() + "\n");
        //displayUsers(); // Display users after name change
    }
    
    private static void openShop(User user) {

        System.out.println("Welcome to the Shop!");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("Your Army Composition:");
        System.out.println(user.getArmyComposition());
        System.out.println("1. Buy Army");
        System.out.println("2. Buy Equipments");
        System.out.println("3. Sell Items"); 
        System.out.println("4. Back to menu");// Added sell option
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println();
    
        switch (choice) {
            case 1:
                buyArmy(user);
                break;
            case 2:
                buyEquipments(user);
                break;
            case 3:
                sellItems(user); // Call the method for selling items
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void sellItems(User user) {
        System.out.println("Welcome to the Sell Items section!");
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("1. Sell Army");
        // System.out.println("2. Sell Equipments");
        System.out.println("2. Back");
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println();
    
        switch (choice) {
            case 1:
                sellArmy(user);
                break;
            // case 2:
            //     sellEquipments(user);
            //     break;
            case 2:
                return; // Back to shop
            default:
                System.out.println("Invalid choice. Please try again.");
                System.out.println();
        }
    }
    
    private static void sellArmy(User user) {
        System.out.println("Which character would you like to sell?");
        System.out.println();
        System.out.println("1. Archer");
        System.out.println("2. Knight");
        System.out.println("3. Mage");
        System.out.println("4. Healer");
        System.out.println("5. Mythical Creature");
        System.out.println("6. Back");
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println();
    
        switch (choice) {
            case 1:
                sellCharacter(user, user.getArcher());
                break;
            case 2:
                sellCharacter(user, user.getKnight());
                break;
            case 3:
                sellCharacter(user, user.getMage());
                break;
            case 4:
                sellCharacter(user, user.getHealer());
                break;
            case 5:
                sellCharacter(user, user.getMythicalCreature());
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void sellCharacter(User user, Character character) {
        if (character != null) {
            double sellPrice = character.getPrice() * 0.9; // Calculate sell price (90% of current value)
            user.addGoldCoins((int) sellPrice); // Add sell price to user's gold coins
            user.removeCharacter(character); // Remove the character from user's inventory
            System.out.println("Sold " + character.getName() + " for " + (int) sellPrice + " gold coins.");
            System.out.println("Gold left: " + user.getGoldCoins());
        } else {
            System.out.println("No character to sell.");
        }
    }

    private static void buyArmy(User user) {
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            if (user.hasCharacterOfCategory(Archer.class) && user.hasCharacterOfCategory(Knight.class) && user.hasCharacterOfCategory(Mage.class) && user.hasCharacterOfCategory(Healer.class) && user.hasCharacterOfCategory(MythicalCreature.class)) {
                // If the user already has characters in each category, prompt them to sell before buying more
                System.out.println("You need to sell your existing characters before buying new ones.");
                System.out.println();
                System.out.println("----------------------------");
                System.out.println();
                System.out.println(user.getArmyComposition());
                System.out.println("----------------------------");
                System.out.println("Redirecting to sell option...");
                loading();
                sellItems(user);
                return;
            }
            System.out.println();
            System.out.println("Welcome to the Army Shop!");
            System.out.println();
    
            Class<? extends Character> category = null;
    
            System.out.println("Choose a character category\n");
            System.out.println("1. Archer");
            System.out.println("2. Knight");
            System.out.println("3. Mage");
            System.out.println("4. Healer");
            System.out.println("5. Mythical Creature");
            System.out.println("6. Back to Shop");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println();
    
            if (choice == 6) {
                return; // User chose to go back to the shop
            }
    
            switch (choice) {
                case 1:
                    category = Archer.class;
                    break;
                case 2:
                    category = Knight.class;
                    break;
                case 3:
                    category = Mage.class;
                    break;
                case 4:
                    category = Healer.class;
                    break;
                case 5:
                    category = MythicalCreature.class;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue; // Restart the loop
            }
    
            // Check if the user already has a character of this category
            if (user.hasCharacterOfCategory(category)) {
                System.out.println("You already have a character of this category.\n");
                continue; // Restart the loop
            }
    
            Character character = createCharacter(category, scanner);
            if (character != null) {
                user.subtractGoldCoins(character.getPrice());
                user.addCharacter(character);
                System.out.println("Character purchased successfully!");
                System.out.println("Remaining gold coins: " + user.getGoldCoins());
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
    
    private static Character createCharacter(Class<? extends Character> category, Scanner scanner) {
        switch (category.getSimpleName()) {
            case "Archer":
                System.out.println("Choose an Archer\n");
                System.out.println("----------------");
                System.out.println("1. Shooter - 80 gc");
                System.out.println("2. Ranger - 115 gc");
                System.out.println("3. Sunfire - 160 gc");
                System.out.println("4. Zing - 200 gc");
                System.out.println("5. Sagittarius - 230 gc");
                System.out.println("6. Back to Shop");
                System.out.println("----------------\n");
                break;

            case "Knight":
                System.out.println("Choose a Knight\n");
                System.out.println("----------------");
                System.out.println("1. Squire - 85 gc");
                System.out.println("2. Cavalier - 110 gc");
                System.out.println("3. Templar - 155 gc");
                System.out.println("4. Zoro - 180 gc");
                System.out.println("5. Swiftblade - 250 gc");
                System.out.println("6. Back to Shop\n");
                break;

            case "Mage":
                System.out.println("Choose a Mage\n");
                System.out.println("--------------");
                System.out.println("1. Warlock - 100 gc");
                System.out.println("2. Illusionist - 120 gc");
                System.out.println("3. Enchanter - 160 gc");
                System.out.println("4. Conjurer - 195 gc");
                System.out.println("5. Eldritch - 270 gc");
                System.out.println("6. Back to Shop");
                System.out.println("----------------\n");
                break;

            case "Healer":
                System.out.println("Choose a Healer\n");
                System.out.println("----------------");
                System.out.println("1. Soother - 95 gc");
                System.out.println("2. Medic - 125 gc");
                System.out.println("3. Alchemist - 150 gc");
                System.out.println("4. Saint - 200 gc");
                System.out.println("5. Lightbringer - 260 gc");
                System.out.println("6. Back to Shop");
                System.out.println("----------------\n");
                break;

            case "MythicalCreature":
                System.out.println("Choose a Mythical Creature\n");
                System.out.println("----------------");
                System.out.println("1. Dragon - 120 gc");
                System.out.println("2. Basilisk - 165 gc");
                System.out.println("3. Hydra - 205 gc");
                System.out.println("4. Pegasus - 340 gc");
                System.out.println("5. Phoenix - 275 gc");
                System.out.println("6. Back to Shop");
                System.out.println("----------------\n");
                break;

            default:
                return null;
        }
    
        int characterChoice;
        while (true) {
            System.out.print("Enter your choice: ");
            characterChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println();
            if (characterChoice >= 1 && characterChoice <= 6) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    
        switch (category.getSimpleName()) {
            case "Archer":
                switch (characterChoice) {
                    case 1:
                        return new Shooter();
                    case 2:
                        return new Ranger();
                    case 3:
                        return new Sunfire();
                    case 4:
                        return new Zing();
                    case 5:
                        return new Saggitarius();
                    default:
                        return null;
                }
            case "Knight":
                switch (characterChoice) {
                    case 1:
                        return new Squire();
                    case 2:
                        return new Cavalier();
                    case 3:
                        return new Templar();
                    case 4:
                        return new Zoro();
                    case 5:
                        return new Swiftblade();
                    default:
                        return null;
                }
            case "Mage":
                switch (characterChoice) {
                    case 1:
                        return new Warlock();
                    case 2:
                        return new Illusionist();
                    case 3:
                        return new Enchanter();
                    case 4:
                        return new Conjurer();
                    case 5:
                        return new Eldritch();
                    default:
                        return null;
                }
            case "Healer":
                switch (characterChoice) {
                    case 1:
                        return new Soother();
                    case 2:
                        return new Medic();
                    case 3:
                        return new Alchemist();
                    case 4:
                        return new Saint();
                    case 5:
                        return new Lightbringer();
                    default:
                        return null;
                }
            case "MythicalCreature":
                switch (characterChoice) {
                    case 1:
                        return new Dragon();
                    case 2:
                        return new Basilisk();
                    case 3:
                        return new Hydra();
                    case 4:
                        return new Pegasus();
                    case 5:
                        return new Phoenix();
                    default:
                        return null;
                }
            default:
                return null;
        }
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Profile{
    private static int playerCount = 0;
    protected static ArrayList<Player> players = new ArrayList<>();
    private static Player currentPlayer;

    private static Scanner scanner = new Scanner(System.in);

    public void startGame() {
        System.out.println("Welcome to Mystic Mayhem Game!");
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create Player");
            System.out.println("2. Select Player");
            System.out.println("3. Search for Opponent");
            System.out.println("4. Buy Equipments");
            System.out.println("5. Current Player Info");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createPlayer();
                    break;
                case 2:
                    selectPlayer();
                    break;
                case 3:
                    searchOpponent();
                    break;
                case 4:
                    buyEquipments();
                    break;
                case 5:
                    currentPlayerInfo();
                    break;
                default:
                    // System.out.println("Invalid choice. Please try again.");
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    private static void createPlayer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        while (!isUsernameUnique(username)) {
            System.out.print("Username already exist. Enter new username: ");
            username = scanner.nextLine();
        }

        Player player = new Player(name, username, playerCount++);
        players.add(player);
        System.out.println("Player created successfully!");

        while (true) {
            // Choose an Archer, diplay archers with their price
            System.out.println("Choose an archer:\n1. Shooter\n2. Ranger\n3. Sunfire\n4. Zing\n5. Sagittarius");

            int archerChoice = getChoice(5);
            Archer archer = null;
            switch (archerChoice) {
                case 1:
                    System.out.println("You chose Shooter.");
                    archer = new Shooter();
                    break;
                case 2:
                    System.out.println("You chose Ranger.");
                    archer = new Ranger();
                    break;
                case 3:
                    System.out.println("You chose Sunfire.");
                    archer = new Sunfire();
                    break;
                case 4:
                    System.out.println("You chose Zing.");
                    archer = new Zing();
                    break;
                case 5:
                    System.out.println("You chose Sagittarius.");
                    archer = new Saggitarius();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            // Choose a Knight
            System.out.println("Choose a knight:\n1. Cavalier\n2. Squire\n3. Swiftblade\n4. Templar\n5. Zoro");
            int knightChoice = getChoice(5);
            Knight knight = null;
            switch (knightChoice) {
                case 1:
                    System.out.println("You chose Cavalier.");
                    knight = new Cavalier();
                    break;
                case 2:
                    System.out.println("You chose Squire.");
                    knight = new Squire();
                    break;
                case 3:
                    System.out.println("You chose Swiftblade.");
                    knight = new Swiftblade();
                    break;
                case 4:
                    System.out.println("You chose Templar.");
                    knight = new Templar();
                    break;
                case 5:
                    System.out.println("You chose Zoro.");
                    knight = new Zoro();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            // Choose a Mage
            System.out.println("Choose a mage:\n1. Conjurer\n2. Eldritch\n3. Enchanter\n4. Illusionist\n5. Warlock");
            int mageChoice = getChoice(5);
            Mage mage = null;
            switch (mageChoice) {
                case 1:
                    System.out.println("You chose Conjurer.");
                    mage = new Conjurer();
                    break;
                case 2:
                    System.out.println("You chose Eldritch.");
                    mage = new Eldritch();
                    break;
                case 3:
                    System.out.println("You chose Enchanter.");
                    mage = new Enchanter();
                    break;
                case 4:
                    System.out.println("You chose Illusionist.");
                    mage = new Illusionist();
                    break;
                case 5:
                    System.out.println("You chose Warlock.");
                    mage = new Warlock();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            // Choose a Healer
            System.out.println("Choose a healer:\n1. Alchemist\n2. Lightbringer\n3. Medic\n4. Saint\n5. Soother");
            int healerChoice = getChoice(5);
            Healer healer = null;
            switch (healerChoice) {
                case 1:
                    System.out.println("You chose Alchemist.");
                    healer = new Alchemist();
                    break;
                case 2:
                    System.out.println("You chose Lightbringer.");
                    healer = new Lightbringer();
                    break;
                case 3:
                    System.out.println("You chose Medic.");
                    healer = new Medic();
                    break;
                case 4:
                    System.out.println("You chose Saint.");
                    healer = new Saint();
                    break;
                case 5:
                    System.out.println("You chose Soother.");
                    healer = new Soother();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            // Choose a Mythical Creature
            System.out.println("Choose a mythical creature:\n1. Basilisk\n2. Dragon\n3. Hydra\n4. Pegasus\n5. Phoenix");
            int creatureChoice = getChoice(5);
            MythicalCreature creature = null;
            switch (creatureChoice) {
                case 1:
                    System.out.println("You chose Basilisk.");
                    creature = new Basilisk();
                    break;
                case 2:
                    System.out.println("You chose Dragon.");
                    creature = new Dragon();
                    break;
                case 3:
                    System.out.println("You chose Hydra.");
                    creature = new Hydra();
                    break;
                case 4:
                    System.out.println("You chose Pegasus.");
                    creature = new Pegasus();
                    break;
                case 5:
                    System.out.println("You chose Phoenix.");
                    creature = new Phoenix();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            if (archer.price + knight.price + mage.price + healer.price + creature.price <= 500) {
                player.createArmy(archer, knight, mage, healer, creature);
                break;
            } else {
                System.out.println("Total price exceeds 500 gold. Please choose again.");
            }
        }
    }

    private static void selectPlayer() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).getUsername());
        }
        System.out.print("Choose a player: ");
        int choice = scanner.nextInt();
        currentPlayer = players.get(choice - 1);
        System.out.println("Player selected: " + currentPlayer.getUsername());
    }

    private static void searchOpponent() {
        if (currentPlayer == null) {
            System.out.println("No player selected.");
            return;
        }
        System.out.println("Current Player: " + currentPlayer.getName());
        ArrayList<Player> opponents = players;
        opponents.remove(currentPlayer);
        Collections.shuffle(opponents);

        System.out.println("Searching for opponent...");

        if (opponents.size() <= 0) {
            System.out.println("No opponent found.");
            return;
        }

        for (Player opponent : opponents) {
            opponent.displayInfo();
            //choose to battle or skip
            System.out.println("Do you want to battle with " + opponent.getUsername() + "?\n1. Yes\n2. No");
            int choice = getChoice(2);
            if (choice == 1) {
                //battle
                Battle battle = new Battle(currentPlayer, opponent);
                battle.start();
                break;
            } else {
                System.out.println("Skipping " + opponent.getUsername() + "...");
            }
        }
        
    }

    private static void buyEquipments() {
        if (currentPlayer == null) {
            System.out.println("No player selected.");
            return;
        }
        System.out.println("Gold left: " + currentPlayer.getGold());
        System.out.println(
                "\nChoose a character to buy artifacts for:\n1. Archer\n2. Knight\n3. Mage\n4. Healer\n5. Mythical Creature");
        int choice = getChoice(5);
        Character character = null;
        switch (choice) {
            case 1:
                System.out.println("You chose Archer.");
                character = currentPlayer.getArcher();
                break;
            case 2:
                System.out.println("You chose Knight.");
                character = currentPlayer.getKnight();
                break;
            case 3:
                System.out.println("You chose Mage.");
                character = currentPlayer.getMage();
                break;
            case 4:
                System.out.println("You chose Healer.");
                character = currentPlayer.getHealer();
                break;
            case 5:
                System.out.println("You chose Mythical Creature.");
                character = currentPlayer.getMythicalCreature();
                break;
            default:
                System.out.println("Invalid choice.");
        }
        // choose armour to buy from chainmail regalia, fleece
        System.out.println("Choose an armour to buy:\n1. Chainmail\n2. Regalia\n3. Fleece\n4.Skip buying armour.");
        int armourChoice = getChoice(4);
        Armour armour = null;
        switch (armourChoice) {
            case 1:
                System.out.println("You chose Chainmail.");
                armour = new Chainmail();
                break;
            case 2:
                System.out.println("You chose Regalia.");
                armour = new Regalia();
                break;
            case 3:
                System.out.println("You chose Fleece.");
                armour = new Fleece();
                break;
            case 4:
                System.out.println("You chose to skip buying armour.");
                return;
            default:
                System.out.println("Invalid choice.");
        }
        if (armour != null) {
            if (currentPlayer.getGold() >= armour.price) {
                character.setArmour(armour);
                currentPlayer.setGold(currentPlayer.getGold() - armour.price);
                System.out.println("Bought " + armour.name + " for " + armour.price + " gold.");
            } else {
                System.out.println("Not enough gold to buy " + armour.name + ".");
                return;
            }
        }

        // choose artefact to buy from excaliber, amulet and crystal
        System.out.println("Choose an artefact to buy:\n1. Excaliber\n2. Amulet\n3. Crystal\n4. Skip buying artefact.");
        int artefactChoice = getChoice(4);
        Artefact artefact = null;
        switch (artefactChoice) {
            case 1:
                System.out.println("You chose Excaliber.");
                artefact = new Excaliber();
                break;
            case 2:
                System.out.println("You chose Amulet.");
                artefact = new Amulet();
                break;
            case 3:
                System.out.println("You chose Crystal.");
                artefact = new Crystal();
                break;
            case 4:
                System.out.println("You chose to skip buying artefact.");
                return;
            default:
                System.out.println("Invalid choice.");
        }
        
        if (artefact != null) {
            if (currentPlayer.getGold() >= artefact.price) {
                character.setArtefact(artefact);
                currentPlayer.setGold(currentPlayer.getGold() - artefact.price);
                System.out.println("Bought " + artefact.name + " for " + artefact.price + " gold.");
            } else {
                System.out.println("Not enough gold to buy " + artefact.name + ".");
                return;
            }
        }
    }

    private static void currentPlayerInfo() {
        if (currentPlayer == null) {
            System.out.println("No player selected.");
            return;
        }
        System.out.println("\nCurrent Player: " + currentPlayer.getName());
        System.out.println("Gold: " + currentPlayer.getGold());
        System.out.println("XP: " + currentPlayer.getXP());
        System.out.println("Archer: " + currentPlayer.getArcher().getCharacterInfo());
        System.out.println("Knight: " + currentPlayer.getKnight().getCharacterInfo());
        System.out.println("Mage: " + currentPlayer.getMage().getCharacterInfo());
        System.out.println("Healer: " + currentPlayer.getHealer().getCharacterInfo());
        System.out.println("Mythical Creature: " + currentPlayer.getMythicalCreature().getCharacterInfo());
    }


    private static boolean isUsernameUnique(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                System.out.println("Username already exists. Please try again.");
                return false;
            }
        }
        return true;
    }

    private static int getChoice(int choiceCount) {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= choiceCount) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }
}
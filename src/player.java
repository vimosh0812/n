import java.util.ArrayList;

class Player {

    private String name;
    private String username;
    private int userID;

    private int XP;
    private int gold;
    private Archer archer;
    private Knight knight;
    private Mage mage;
    private Healer healer;
    private MythicalCreature mythicalCreature;
    // private Homeground homeground;
    private ArrayList<Character> characters = new ArrayList<>();

    public Player(String name, String username, int userID) {
        this.name = name;
        this.username = username;
        this.userID = userID;
        this.gold = 500;
    }

    public String getName() {
        return this.name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public int getUserID() {
        return this.userID;
    }

    public int getXP() {
        return this.XP;
    }

    public void changeXP(int XP) {
        this.XP += XP;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Archer getArcher() {
        return this.archer;
    }

    public void setArcher(Archer archer) {
        this.archer = archer;
    }

    public Knight getKnight() {
        return this.knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public Mage getMage() {
        return this.mage;
    }

    public void setMage(Mage mage) {
        this.mage = mage;
    }

    public Healer getHealer() {
        return this.healer;
    }

    public void setHealer(Healer healer) {
        this.healer = healer;
    }

    public MythicalCreature getMythicalCreature() {
        return this.mythicalCreature;
    }

    public void setMythicalCreature(MythicalCreature mythicalCreature) {
        this.mythicalCreature = mythicalCreature;
    }

    // public Homeground getHomeground() {
    //     return this.homeground;
    // }

    // public void setHomeground(Homeground homeground) {
    //     this.homeground = homeground;
    // }

    public void buyCharacter(Character character) {
        if (this.gold >= character.getPrice()) {
            this.gold -= character.getPrice();
            addCharacter(character);
        } else {
            System.out.println("Not enough gold");
        }
    }

    public void createArmy(Archer archer, Knight knight, Mage mage, Healer healer, MythicalCreature mythicalCreature) {
        this.archer = archer;
        this.knight = knight;
        this.mage = mage;
        this.healer = healer;
        this.mythicalCreature = mythicalCreature;

        buyCharacter(archer);
        buyCharacter(knight);
        buyCharacter(mage);
        buyCharacter(healer);
        buyCharacter(mythicalCreature);
    }

    public void displayInfo() {
        System.out.println("\nName: " + this.name);
        System.out.println("XP: " + this.XP);
        System.out.println("Archer: " + this.archer.getName());
        System.out.println("Knight: " + this.knight.getName());
        System.out.println("Mage: " + this.mage.getName());
        System.out.println("Healer: " + this.healer.getName());
        System.out.println("Mythical Creature: " + this.mythicalCreature.getName());
    }

    public void afterCombat(String result) {

    }

    public void addCharacter(Character character) {
        this.characters.add(character);
    }
}
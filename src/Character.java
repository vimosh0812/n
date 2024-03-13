public abstract class Character {

    String name,category;
    double attack,defence,health,speed;
    boolean check;
    int price;

    // private Archer archer;
    // private Knight knight;
    // private Mage mage;
    // private MythicalCreature mythicalCreature;
    // private Healer healer;

    Armour armour;
    Artefact artefact;

    Character(String name, int price, double attack, double defence, double health, double speed,String category) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
        this.category = category;
    }
    public void check() {
        check = true;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public double getAttack() {
        return this.attack;
    }

    public double getDefence() {
        return this.defence;
    }

    public double getHealth() {
        if(isDead()){
            return 0.0;
        }
        else
        {
        return this.health;
        }
    }

    public double getSpeed() {
        return this.speed;
    }

    public String getCategory() {
        return this.category;
    }

    public Armour getArmour() {
        return this.armour;
    }

    public void setArmour(Armour armour) {
        if (this.armour != null) {
            this.defence -= this.armour.getDefence();
            this.health -= this.armour.getHealth();
            this.speed -= this.armour.getSpeed();

            this.price -= this.armour.getPrice() * 20/100;
            this.armour = null;
        }
        
        this.armour = armour;
        this.defence += armour.getDefence();
        this.health += armour.getHealth();
        this.speed += armour.getSpeed();

        this.price += armour.getPrice() * 20/100;
    }


    public Artefact getArtefact() {
        return this.artefact;
    }

    public void setArtefact(Artefact artefact) {
        if (this.artefact != null) {
            this.attack -= this.artefact.getAttack();
            this.defence -= this.artefact.getDefence();
            this.health -= this.artefact.getHealth();
            this.speed -= this.artefact.getSpeed();

            this.price -= this.artefact.getPrice() * 20/100;
            this.artefact = null;
        }

        this.artefact = artefact;
        this.attack += artefact.getAttack();
        this.defence += artefact.getDefence();
        this.health += artefact.getHealth();
        this.speed += artefact.getSpeed();

        this.price += artefact.getPrice() * 20/100;
    }



    public void getdamage(double damage){
        // if (this.health > 0.0){
        //     this.health -= damage;
        // }
        this.health -= damage;
        
        if (this.health <= 0.0) {
            this.health = 0.0;
            System.out.println(this.name + " died");
        }
        
    }

    public void increasehealth(double health){
        this.health += health;
        System.out.println(this.name + " got healed to health "+this.health);
    }
    public boolean isDead(){
        //System.out.println(this.name + " helath after died "+this.health);
        return this.health <= 0.0;
        
    }

    public double setHealth(double health) {
        return this.health = health;
    }
    public void increaseDefence(double defence){
        this.defence += defence;
        System.out.println(this.name + " got buffed to defence "+this.defence);
    }
    public void increaseAttack(double attack){
        this.attack += attack;
        System.out.println(this.name + " got buffed to attack "+this.attack);
    }
    public void increaseSpeed(double speed){
        this.speed += speed;
        System.out.println(this.name + " got buffed to speed "+this.speed);
    }
    public void decreaseDefence(double defence){
        this.defence -= defence;
        System.out.println(this.name + " got debuffed to defence "+this.defence);
    }
    public void decreaseAttack(double attack){
        this.attack -= attack;
        System.out.println(this.name + " got debuffed to attack "+this.attack);
    }
    public void decreaseSpeed(double speed){
        this.speed -= speed;
        System.out.println(this.name + " got debuffed to speed "+this.speed);
    }
    public void decreaseHealth(double health){
        this.health -= health;
        System.out.println(this.name + " got debuffed to health "+this.health);
    }
    // public Archer getArcher() {
    //     return archer;
    // }
    // public void setArcher(Archer archer) {
    //     this.archer = archer;
    // }
    // public Knight getKnight() {
    //     return knight;
    // }
    // public void setKnight(Knight knight) {
    //     this.knight = knight;
    // }
    // public Mage getMage() {
    //     return mage;
    // }
    // public void setMage(Mage mage) {
    //     this.mage = mage;
    // }
    // public MythicalCreature getMythicalCreature() {
    //     return mythicalCreature;
    // }
    // public void setMythicalCreature(MythicalCreature mythicalCreature) {
    //     this.mythicalCreature = mythicalCreature;
    // }
    // public Healer getHealer() {
    //     return healer;
    // }
    // public void setHealer(Healer healer) {
    //     this.healer = healer;
    // }

    
    
}
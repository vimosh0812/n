public class Armour extends Equipment {
    Armour(String name, int price, int attack, int defence, int health, int speed) {
        super(name, price, attack, defence, health, speed);
    }
}

class Chainmail extends Armour {
    Chainmail() {
        super("Chainmail", 100, 0, 5, 10, 0);
    }
}

class Regalia extends Armour {
    Regalia() {
        super("Regalia", 200, 0, 10, 20, 0);
    }
}

class Fleece extends Armour {
    Fleece() {
        super("Fleece", 300, 0, 15, 30, 0);
    }
}

public class Artefact extends Equipment {
    Artefact(String name, int price, int attack, int defence, int health, int speed) {
        super(name, price, attack, defence, health, speed);
    }
}

class Excaliber extends Artefact {
    Excaliber() {
        super("Excaliber", 500, 20, 0, 0, 0);
    }
}

class Amulet extends Artefact {
    Amulet() {
        super("Amulet", 300, 0, 0, 0, 10);
    }
}

class Crystal extends Artefact {
    Crystal() {
        super("Crystal", 400, 0, 0, 0, 20);
    }
}
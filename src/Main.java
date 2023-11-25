// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Equipment sword = new Equipment("Great Sword",50,"sword");
        Equipment shield = new Equipment("Great Shield",30,"shield");
        //a character might have a sword equipped, or not, and might have a shield equipped, or not
        Character a1 = new Character("Warrior",1,10,sword);
        Character a2 = new Character("Mage",1,5);
        Character b1 = new Character("Goblin",1,20,shield);
        //an RPG character has a level, which determines maximum HP and mana
        a1.statDisplay();
        //level can be upped
        a1.upLevel();
        //a character could be attacked by a sword, but can lessen damage with a shield
        //sword attack bare hand
        a1.attack(a2);
        //sword attack shield
        a1.attack(b1);
        //bare hand attack sword
        a2.attack(a1);
        //shield attack sword
        b1.attack(a1);
        //equipping any of these will reduce character's run speed
        //equipment has an effect on character's run speed
        a1.statDisplay();
        a1.removeEquip();
        a1.setMainHand(shield);
        a1.setMainHand(sword);
        //a sword has a level that increases damage dealt to a character and affects character's run speed
        a1.mainHandUpLevel(9);
        a1.mainHandUpLevel();
        a1.statDisplay();
        a1.attack(b1);
        //a shield has a level that decreases damage received by a character and affects character's run speed
        b1.heal();
        b1.statDisplay();
        a1.attack(b1);
        b1.heal();
        b1.mainHandUpLevel(200);
        b1.statDisplay();
        a1.attack(b1);
        //how and where to store data           object's private field that can't access from client's code
        //what operations are needed            a lots go see each classes
        //how and where to compute information  in private method ? maybe
    }
}
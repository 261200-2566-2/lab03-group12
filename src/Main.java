// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Equipment sword = new Equipment("Great Sword",50,"sword");
        Equipment shield = new Equipment("Great Shield",30,"shield");
        Character a1 = new Character("Warrior",1,10,sword);
        Character a2 = new Character("Mage",1,5);
        Character b1 = new Character("Goblin",1,20,shield);
//        a1.statDisplay();
//        a2.statDisplay();
//        b1.statDisplay();
        a1.statDisplay();
        a1.attack(a2);
        a1.attack(b1);
    }
}
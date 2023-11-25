import java.util.Objects;

public class Character {
    //fields
    private final String name;
    private  int level;
    private double maxHP,maxMP,maxSp;
    private double hp;
    private final double mp;
    private double sp;
    private final double baseSp;
    private Equipment mainHand;
    private boolean alive=true;
    //constructors
    public Character(String name,int level,int speed,Equipment weapon){
        this.name = name;
        this.level = level;
        this.baseSp = speed;
        mainHand = new Equipment(weapon.getName(), weapon.getLevel(), weapon.getType());
        updateStats();
        hp=maxHP;
        mp=maxMP;
    }
    public Character(String name,int level,int speed){
        this(name,level,speed,new Equipment("Bare Hand",0,"bareHand"));
    }
    //public methods
    public String getName() {
        return name;
    }           //getter
    public void setMainHand(Equipment mainHand) {
        this.mainHand = new Equipment(mainHand.getName(), mainHand.getLevel(), mainHand.getType());
        updateStats();
        statDisplay();
    }  //setter
    public void heal() {
        System.out.println(name+"was healed to full hp\n");
        hp = maxHP;
    }                           //heal
    public void removeEquip(){
        this.mainHand = new Equipment("Bare Hand",0,"bareHand");
        updateStats();
        statDisplay();
    }                     //remove equipment
    public void mainHandUpLevel(){
        mainHandUpLevel(1);
    }   //increase main hand weapon's level
    public void mainHandUpLevel(int lvl){
        mainHand.upLevel(lvl);
        updateStats();
    }          //method overloading
    public void upLevel(){
        upLevel(1);
    }          //increase character's level
    public void upLevel(int lvl){
        level+=lvl;
        updateStats();
        System.out.println(name+" LEVEL UP");
        statDisplay();
    }                  //method overloading
    public void attack(Character target){
        //no weapon you only deal 1 dmg
        double dmg=5;
        System.out.println(name+" Attack "+target.getName()+" with "+mainHand.getName()+" Lvl."+mainHand.getLevel());
        if(Objects.equals(mainHand.getName(), "bareHand")){
            dmg=1;
        }else if (Objects.equals(mainHand.getType(), "sword")){
            dmg=mainHand.getStats();
        }
        target.beingAttack(dmg);
    }          //attack
    public void statDisplay(){
        System.out.println(name+"'s Stats"+"\nStatus : "+(alive?"ALIVE":"DEAD"));
        System.out.println("MainHand\t: "+mainHand.getName());
        System.out.println("Level\t: "+level);
        System.out.println("Health\t: "+String.format("%.1f",hp)+"/"+String.format("%.1f",maxHP));
        System.out.println("Mana\t: "+String.format("%.1f",mp)+"/"+String.format("%.1f",maxMP));
        System.out.println("Speed\t: "+String.format("%.1f",sp)+"/"+String.format("%.1f",maxSp)+"\n");
    }                     //show character's stats
    //private methods
    private void updateStats(){
        maxHP = 100+10*level;
        maxMP = 50+2*level;
        maxSp = baseSp*(1+0.03*level);
        if(!Objects.equals(mainHand.getType(), "bareHand")) sp = maxSp - baseSp*(mainHand.getSpDec());
        else    sp = maxSp;
    }                    //update character's stats
    private void beingAttack(double dmg){
        if(Objects.equals(mainHand.getType(), "shield")){
            System.out.println(name+" block it with "+mainHand.getName()+" Lvl."+mainHand.getLevel());
            dmg-=mainHand.getStats();
            if(dmg<0)   dmg = 0;
        }
        System.out.println("Damage : "+String.format("%.1f",dmg));
        hp-=dmg;
        if(hp<=0)   alive=false;
        if(!alive) System.out.println(name+"has been slain.\n");
        else System.out.println(name+"'s health : "+String.format("%.1f",hp)+"/"+String.format("%.1f",maxHP)+"\n");
    }          //being attack
}

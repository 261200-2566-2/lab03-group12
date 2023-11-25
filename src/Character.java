import java.util.Objects;

public class Character {
    private String name;
    private int level,maxHP,maxMP,maxSp;
    private double hp,mp;
    private Equipment mainHand;
    private boolean alive=true;
    public Character(String name,int level,int speed){
        this.name = name;
        this.level = level;
        this.maxSp = speed;
        maxHP = 100+10*level;
        maxMP = 50+2*level;
        hp=maxHP;
        mp=maxMP;
        mainHand=null;
    }
    public Character(String name,int level,int speed,Equipment weapon){
        this.name = name;
        this.level = level;
        this.maxSp = speed;
        maxHP = 100+10*level;
        maxMP = 50+2*level;
        hp=maxHP;
        mp=maxMP;
        mainHand = new Equipment(weapon.getName(), weapon.getLevel(), weapon.getType());
    }
//    public  int getMaxHP(){return  maxHP;}
//    public int getMaxMP() {return maxMP;}
//    public int getLevel() {return level;}
//    public int getHp() {return hp;}
//    public int getMp() {return mp;}


    public String getName() {
        return name;
    }

    //public Equipment getMainHand() {return mainHand;}

    public void upLevel(){
        level++;
        maxHP = 100+10*level;
        maxMP = 50+2*level;
    }
    public void attack(Character target){
        //no weapon you only deal 1 dmg
        double dmg;
        System.out.println(name+" Attack "+target.getName()+(mainHand!=null?" with "+mainHand.getName():""));
        if(mainHand==null){
            dmg=1;
            target.beingAttack(dmg);
        }else if (Objects.equals(mainHand.getType(), "sword")){
            dmg=mainHand.getStats();
            target.beingAttack(dmg);
        }
    }
    private void beingAttack(double dmg){
        if(mainHand!=null&&Objects.equals(mainHand.getType(), "shield")){
            System.out.println(name+" block it with "+mainHand.getName());
            dmg-=mainHand.getStats();
            if(dmg<0)   dmg = 0;
        }
        System.out.println("Damage : "+dmg);
        hp-=dmg;
        if(hp<=0)   alive=false;
        if(!alive) System.out.println(name+"has been slain.");
        else System.out.println(name+"'s health : "+hp+"/"+maxHP+"\n");
    }
    public void statDisplay(){
        System.out.println(name+"\nStatus : "+(alive?"ALIVE":"DEAD"));
        if(mainHand!=null)    System.out.println("MainHand : "+mainHand.getName());
        System.out.println("Level\t: "+level);
        System.out.println("Health\t: "+hp+"/"+maxHP);
        System.out.println("Mana\t: "+mp+"/"+maxMP+"\n");
    }
}

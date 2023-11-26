import java.util.Objects;

public class Equipment {
    //fields
    private final String name;
    private int level;
    private final String type;    //"sword", "shield", "bareHand"
    private double stats,spDec;
    //constructor
    public Equipment(String name, int level, String type){
        this.name = name;
        this.level = level;
        this.type = type;
        updateStat();
    }
    //public methods
    //getter
    public double getStats() {
        return stats;
    }
    public int getLevel() {
        return level;
    }
    public String getName() {
        return name;
    }
    public double getSpDec(){return spDec;}
    public String getType() {
        return type;
    }
    public void upLevel(int lvl){
        level+=lvl;
        System.out.println(name+" LEVEL UP "+lvl+" levels");
        updateStat();
        status();
    }           //increase item's levels
    public void status(){
        System.out.println("Weapon : "+name+"\tLevel : "+level+"\tType : "+type);
        System.out.println((Objects.equals(type, "sword") ?"ATK : ":"DEF : ")+String.format("%.1f\n",stats));
    }                   //show item's stats
    //private methods
    private void updateStat(){
        //sword base damage
        int d = 10;
        //shield base defense
        int s = 10;
        switch (type){
            case "sword":
                stats = d *(1+0.1*level);
                spDec = 1-(level/100.0);
                if(spDec<0) spDec = 0;
                break;
            case "shield":
                stats = s *(1+0.05*level);
                spDec = 1-(level/120.0);    //worst case = 1,base case = 0
                if(spDec<0) spDec = 0;
                break;
        }
    }              //update item's stat
}

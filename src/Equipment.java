import java.util.Objects;

public class Equipment {
    private String name;
    private int level;
    private String type;    //"Sword", "Shield"
    private double stats;

    public double getStats() {
        return stats;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public Equipment(String name, int level, String type){
        this.name = name;
        this.level = level;
        this.type = type;
        updateStat();
    }

    private void updateStat(){
        //sword base damage
        int d = 10;
        //shield base defense
        int s = 10;
        switch (type){
            case "sword"    :stats = d *(1+0.1*level);
                break;
            case "shield"   :stats = s *(1+0.05*level);
                break;
        }
    }
    public void upLevel(){
        level++;
        updateStat();
    }
    public void status(){
        System.out.println("Weapon : "+name+"\tLevel : "+level+"\tType : "+type);
        System.out.println(Objects.equals(type, "sword") ?"ATK : ":"DEF : "+stats);
    }
    public String getType() {
        return type;
    }
}

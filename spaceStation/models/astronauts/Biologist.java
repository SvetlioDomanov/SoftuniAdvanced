package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{

    private static final double BIOLOGIST_OXYGEN = 70;

    public Biologist(String name) {
        super(name, BIOLOGIST_OXYGEN);
    }

    @Override
    public void breath(){
        if(getOxygen()-10<0){
            this.setOxygen(0);
        }
        else{
            this.setOxygen(getOxygen()-10);
        }
    }
}

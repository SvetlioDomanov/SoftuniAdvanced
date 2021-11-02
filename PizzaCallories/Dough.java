package PizzaCallories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight<1 || weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
    public double calculateCalories(){
        double flourTypeModifier;
        double bakingTechniqueModifier;
        if(this.flourType.equals("White")){
            flourTypeModifier =1.5;
        }
        else{
            flourTypeModifier = 1;
        }
        if(this.bakingTechnique.equals("Crispy")){
            bakingTechniqueModifier = 0.9;
        }
        else if(this.bakingTechnique.equals("Chewy")){
            bakingTechniqueModifier = 1.1;
        }
        else{
            bakingTechniqueModifier = 1;
        }

        return 2*this.weight*flourTypeModifier*bakingTechniqueModifier;
    }

}

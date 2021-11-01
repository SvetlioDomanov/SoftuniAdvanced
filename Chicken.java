package AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = name;
        }

    }

    private void setAge(int age) {
        if (age < 1 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        } else {
            this.age = age;
        }

    }
    private double calculatedProductPerDay(){
        if(this.age<6){
            return 2;
        }
        else if(this.age<12){
            return 1;
        }
        else{
            return 0.75;
        }
    }
    public double productPerDay(){
        return calculatedProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",getName(),getAge(),this.productPerDay());
    }
}

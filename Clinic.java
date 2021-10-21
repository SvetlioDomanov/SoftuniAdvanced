package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Pet pet){
        if(this.data.size()<this.capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        for (Pet pet:this.data) {
            if(pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner){
        for (Pet pet:this.data){
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
return null;
    }
    public Pet getOldestPet(){
        Pet oldestPet = data.get(0);
        for (Pet pet:this.data){
            if(pet.getAge()> oldestPet.getAge()){
                oldestPet=pet;
            }
        }
        return oldestPet;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:\n");
        for (Pet pet:this.data){
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append("\n");
        }
return sb.toString().trim();
    }


}

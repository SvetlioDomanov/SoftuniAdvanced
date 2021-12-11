package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHouse implements House{

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int softness =0;
        for(Toy toy:toys){
            softness+=toy.getSoftness();
        }
        return softness;
    }

    @Override
    public void addCat(Cat cat) {
        if(this.cats.size()==capacity){
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ")
                .append(this.getClass().getSimpleName()).append(":")
                .append(System.lineSeparator());

        sb.append("Cats:");
        if(cats.isEmpty()){
            sb.append(" none");
        }
        else{
            for(Cat cat: cats){
                sb.append(" ").append(cat.getName());
            }
        }
        sb.append(System.lineSeparator());
        sb.append("Toys: ").append(toys.size())
                .append(" Softness: ").append(this.sumSoftness());

        return sb.toString().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name=name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}

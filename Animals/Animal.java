package Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setAge(age);
        setName(name);
        setGender(gender);
    }

    public String produceSound() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isBlank()) {
            throw new IllegalArgumentException("Invalid Input!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid Input!");
        }

        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.trim().isBlank()) {
            throw new IllegalArgumentException("Invalid Input!");
        }

        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(this.name).append(" ").append(this.age).append(" ").append(this.gender).append(System.lineSeparator());
        return sb.toString();
    }
}

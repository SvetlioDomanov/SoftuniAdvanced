package catHouse.entities.toys;

public abstract class BaseToy implements Toy{

    private int softness;
    private double price;

    protected BaseToy(int softness, double price) {
        this.softness = softness;
        this.price = price;
    }

    public void setSoftness(int softness) {
        this.softness = softness;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getSoftness() {
        return softness;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

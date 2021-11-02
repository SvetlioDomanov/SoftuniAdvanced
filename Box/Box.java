package Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(double length) {
        if(length<=0){
            String message = exceptionMessage("Length");
            throw new IllegalArgumentException(message);
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if(width<=0){
            String message = exceptionMessage("Width");
            throw new IllegalArgumentException(message);
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if(height<=0){
            String message = exceptionMessage("Height");
            throw new IllegalArgumentException(message);
        }
        this.height = height;
    }

    private String exceptionMessage(String dimension) {
        return dimension + " cannot be zero or negative.";
    }

public double calculateSurfaceArea(){
        return 2*this.length*this.width + 2*this.length*this.height + 2*this.height*this.width;
}
public double calculateLateralSurfaceArea (){
        return 2*length*height + 2*width*height;
}
public double calculateVolume(){
        return length*width*height;
}
}

package factory;

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if ("circle".equals(shapeType)) {
            return new Circle();
        } else if ("rectangle".equals(shapeType)) {
            return new Rectangle();
        } else if ("square".equals(shapeType)) {
            return new Square();
        }
        return null;
    }
}

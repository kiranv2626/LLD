package factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();
        Shape Rectangle = shapeFactory.getShape("rectangle");
        Rectangle.draw();
        Shape Square = shapeFactory.getShape("square");
        Square.draw();
    }
}

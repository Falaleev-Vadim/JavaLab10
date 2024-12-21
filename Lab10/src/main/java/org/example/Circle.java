class Circle extends Shape implements Resizable {
    private double radius;

    public Circle(double radius) throws ShapeInputException {
        if (radius <= 0) {
            throw new ShapeInputException("Радиус должен быть положительным числом.");
        }
        this.radius = radius;
        this.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius + ", Area: " + area;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Circle)) return false;
        Circle other = (Circle) obj;
        return Double.compare(radius, other.radius) == 0;
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            System.out.println("Фактор изменения должен быть положительным.");
        } else {
            radius *= factor;
            area = calculateArea();
        }
    }
}
package org.example;

abstract class Shape implements Comparable<Shape>, Cloneable {
    protected double area;

    public abstract double calculateArea();
    public double getArea() {
        return area;
    }

    @Override
    public abstract String toString();
    @Override
    public abstract boolean equals(Object obj);

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.area, other.area);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
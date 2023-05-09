package quang.dev;

public class Circle extends Shape{
	private double r;
	
	public Circle(double r) {
		super();
		this.r = r;
	}

	@Override
	public double chuVi() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * r;
	}

	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return Math.PI * r * r;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Circle: cv:%.2f - dt:%.2f", chuVi(), dienTich());
	}
}

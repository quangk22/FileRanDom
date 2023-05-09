package quang.dev;

public class Rect extends Shape{
	private double a,b;

	public Rect(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public double chuVi() {
		// TODO Auto-generated method stub
		return 2 * (a + b);
	}

	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return a *b;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Rect: cv:%.2f - dt:%.2f", chuVi(), dienTich());
	}
}

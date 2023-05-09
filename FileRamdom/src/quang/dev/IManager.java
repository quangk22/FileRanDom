package quang.dev;

public interface IManager  {
	void add(Shape shape);
	void remove(Shape shape);
	Shape[] all();
	void sort();
	Shape findMaxChuVi();
	
}

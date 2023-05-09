package quang.dev;

import java.util.Scanner;

public class Manager implements IManager {
	Shape[] shapes = new Shape[10];
	int index = 0 ;

	@Override
	public void add(Shape shape) {
		// TODO Auto-generated method stub
		if (index < shapes.length) {
            shapes[index] = shape;
            index++;
        } else {
            System.out.println("mảng đầy");
        }
		
	}

	@Override
	public void remove(Shape shape) {
		// TODO Auto-generated method stub
		for (int i = 0; i < shapes.length; i++) {
			if(shape == shapes[i])
				shapes[i] = null;
		}
	}

	@Override
	public Shape[] all() {
		// TODO Auto-generated method stub
		return shapes;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		for (int i = 0; i < shapes.length -1; i++) {
			for (int j = i+1; j < shapes.length; j++) {
				if(shapes[i].chuVi() > shapes[j].chuVi()) {
					Shape shape = shapes[i];  
					shapes[i] = shapes[j];
					shapes[j] = shape;
				}
			}
		}
	}

	@Override
	public Shape findMaxChuVi() {
		// TODO Auto-generated method stub
		sort();
		return shapes[shapes.length -1];
	}

}

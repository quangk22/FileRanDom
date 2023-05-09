package quang.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
	static final String FILE = "input.txt";

	public static void main(String[] args) throws IOException {
		IManager manager = new Manager();

		randomFileData(FILE, 100);
		readFromFile(FILE, manager);
		print(manager);

//		System.out.println("Danh sách các đối tượng sau khi sắp xếp:");
//		manager.sort();
//		print(manager);
//
//		System.out.println("Hinh co chu vi lon nhat");
//		Shape max = manager.findMaxChuVi();
//		System.out.println(max);
	}

	private static void readFromFile(String file, IManager manager) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fstream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;

			while ((strLine = br.readLine()) != null) {
				String s[] = strLine.split(":");
				switch (s[0]) {

				case "Circle":
					manager.add(readCircle(s[1]));
					break;
				case "Triangle":
					manager.add(readRect(s[1]));
					break;
				case "Rect":
					manager.add(readTriangle(s[1]));
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sai");
		}
	}

	private static void randomFileData(String fileName, int i) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		FileWriter writer = new FileWriter(fileName);
		Random rand = new Random();
		for (int j = 0; j < 100; j++) {
			int randomNumber = rand.nextInt(3);
			if (randomNumber == 0) {
				writer.write("Circle:");
				randomNumber = rand.nextInt(100);
				writer.write(""+randomNumber);
			} else if (randomNumber == 1) {
				writer.write("Triangle:");
				int randomNumber1 = rand.nextInt(100);
				int randomNumber2 = rand.nextInt(100);
				int randomNumber3 = rand.nextInt(100);
				writer.write(""+randomNumber1 + "," + randomNumber2 + "," + randomNumber3);
			} else {
				writer.write("Rect:");
				int randomNumber1 = rand.nextInt(100);
				int randomNumber2 = rand.nextInt(100);
				writer.write(""+randomNumber1 + "," + randomNumber2);
			}
			writer.write("\n");
		}
		writer.close();

	}

	private static void print(IManager manager) {
		// TODO Auto-generated method stub
		for (Shape shape : manager.all()) {
			if (shape == null)
				continue;
			System.out.println(shape);
		}
	}

	private static Shape readTriangle(String s) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String arr[] = s.split(",");
		double a = Double.parseDouble(arr[0]);
		double b = Double.parseDouble(arr[1]);
		double c = Double.parseDouble(arr[2]);
		return new Triangle(a, b, c);
	}

	private static Shape readRect(String s) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String arr[] = s.split(",");
		double a = Double.parseDouble(arr[0]);
		double b = Double.parseDouble(arr[1]);
		return new Rect(a, b);
	}

	private static Shape readCircle(String s) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		double r = Double.parseDouble(s);
		return new Circle(r);
	}

}

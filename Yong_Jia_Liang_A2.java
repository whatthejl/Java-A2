//This project is done by Yong Jia Liang, UOW ID 7083609
//All codes in this file is my own.
//I did not pass my work to any friend.
//I am willing to accept whatever penalty given to me.

import java.util.*;

enum ShapeColor
{
	Blue,
	Yellow,
	Red,
	Green,
	White;
}//end enum

interface Recolorable
{
	public void recolor(ShapeColor sc);
}

interface Shape
{
	public double area();
}

interface Resizable
{
	public void resize(double percentage);
}

abstract class TwoD implements Recolorable, Shape
{
	protected ShapeColor sc;
	protected int a;
	protected int b;
	protected int c;
	protected int d;
	
	//default constructor
	public TwoD()
	{
		this.sc = ShapeColor.values()[4];
		this.a = 1;
	}
	
	//circle, 1 integer
	public TwoD(ShapeColor sc, int a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	//rectangle, 2 integer
	public TwoD(ShapeColor sc, int a, int b)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
	}
	
	//triangle, 3 integer
	public TwoD(ShapeColor sc, int a, int b, int c)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//trapezoid, 4 integer
	public TwoD(ShapeColor sc, int a, int b, int c, int d)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	//copy constructor
	public TwoD(TwoD td)
	{
		this (td.sc, td.a, td.b, td.c, td.d);
	}
	
	//accessor methods
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	public int getD()
	{
		return d;
	}
	
	public ShapeColor getShapeColor()
	{
		return sc;
	}
	
	//mutator method
	public void set(ShapeColor sc, int a, int b, int c, int d)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	//recolors the TwoD shape to a different color from the original
	@Override
	public void recolor(ShapeColor sc)
	{
		this.sc = sc;
	}
	
	public String toString()
	{
		//return String.format ("(2D (%s, %d, %d, %d, %d), %d)%n", sc, a, b, c, d, getHeight());
		return String.format ("(2D (%s, %d, %d, %d, %d))", sc, a, b, c, d);
	}
} //end TwoD class

class Circle extends TwoD
{
	//default constructor
	public Circle()
	{
		this.sc = ShapeColor.values()[4];
		this.a = 1;
	}
	
	public Circle(ShapeColor sc, int radius)
	{
		super (sc, radius);
	}
	
	//copy constructor
	public Circle(Circle c)
	{
		this (c.sc, c.a);
	}
	
	//calculates and returns area of circle
	@Override
	public double area()
	{
		return Math.PI * a * a;
	}
	
	//accessor methods
	public int getRadius()
	{
		return a;
	}
	
	//mutator method
	public void set(ShapeColor sc, int radius)
	{
		this.sc = sc;
		this.a = radius;
	}
	
	@Override
	public String toString()
	{
		return String.format ("Circle (2D (%s, %d))", sc, a);
	}
} //end circle class

class Rectangle extends TwoD
{
	//default constructor
	public Rectangle()
	{
		this.sc = ShapeColor.values()[4];
		this.a = 1;
		this.b = 1;
	}
	
	public Rectangle(ShapeColor sc, int length, int width)
	{
		super (sc, length, width);
	}
	
	//copy constructor
	public Rectangle(Rectangle r)
	{
		this (r.sc, r.a, r.b);
	}
	
	//calculates and returns area of rectangle
	@Override
	public double area()
	{
		return 1.0 * a * b;
	}
	
	//accessor methods
	public int getLength()
	{
		return a;
	}
	
	public int getWidth()
	{
		return b;
	}
	
	//mutator method
	public void set(ShapeColor sc, int length, int width)
	{
		this.sc = sc;
		this.a = length;
		this.b = width;
	}
	
	@Override
	public String toString()
	{
		if (a == b) //square
		{
			return String.format ("Square (2D (%s, %d, %d))", sc, a, a);
		}
		else
		{
			return String.format ("Rectangle (2D (%s, %d, %d))", sc, a, b);
		}
	}
} //end rectangle class

class Triangle extends TwoD
{
	//default constructor
	public Triangle()
	{
		this.sc = ShapeColor.values()[4];
		this.a = 1;
		this.b = 1;
		this.c = 1;
	}
	
	public Triangle(ShapeColor sc, int a, int b, int c)
	{
		super (sc, a, b, c);
	}
	
	//copy constructor
	public Triangle(Triangle t)
	{
		this (t.sc, t.a, t.b, t.c);
	}
	
	//calculates and returns area of triangle
	@Override
	public double area()
	{
		double s = (a + b + c) / 2.0;
		return Math.sqrt (s * (s - a) * (s - b) * (s - c));
	}
	
	//accessor methods
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	//mutator method
	public void set(ShapeColor sc, int a, int b, int c)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public String toString()
	{
		if (a == b && a == c) //equilateral
		{
			return String.format ("Equilateral Triangle (2D (%s, %d, %d, %d))", sc, a, a, a);
		} 
		else if (a == b || b == c || c == a) //isosceles
		{
			return String.format ("Isosceles Triangle (2D (%s, %d, %d, %d))", sc, a, b, c);
		} 
		else
		{
			return String.format ("Triangle (2D (%s, %d, %d, %d))", sc, a, b, c);
		}
	}
} //end triangle class

class Trapezoid extends TwoD //two sides are parallel
{
	private int h;
	//default constructor
	public Trapezoid()
	{
		this.sc = ShapeColor.values()[4];
		this.a = 1;
		this.b = 1;
		this.c = 1;
		this.d = 1;
	}
	
	public Trapezoid(ShapeColor sc, int a, int b, int c, int d, int h)
	{
		super (sc, a, b, c, d); //a and c are parallel
		this.h = h;
	}
	
	//accessor methods
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	public int getD()
	{
		return d;
	}
	
	public int getHeight()
	{
		return h;
	}
	
	//calculates and returns area of trapezoid
	@Override
	public double area()
	{
		return ((a + c) / 2.0) * h;
	}
	
	//mutator method
	public void set(ShapeColor sc, int a, int b, int c, int d)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	@Override
	public String toString()
	{
		return String.format ("Trapezoid (2D (%s, %d, %d, %d, %d), %d)", sc, a, b, c, d, h);
	}
} //end trapezoid class

abstract class ThreeD implements Shape, Resizable
{
	protected ShapeColor sc;
	protected double a;
	
	//default constructor
	public ThreeD()
	{
		this.sc = ShapeColor.values()[4];
		this.a = 1;
	}
	
	public ThreeD(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	//copy constructor
	public ThreeD(ThreeD td)
	{
		this (td.sc, td.a);
	}
	
	//accessor methods
	public double getA()
	{
		return a;
	}
	
	//mutator method
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	//resize a by certain %, will reduce area and volume also
	@Override
	public void resize(double percentage)
	{
		double reduce = percentage / 100.0;
		a = a * (1.0 - reduce);
	}
	
	public double volume()
	{
		return 1.0;
	}
	
	public String toString()
	{
		return String.format ("(3D (%s, %.3f))", sc, a);
	}
}

class Sphere extends ThreeD
{
	//default constructor
	public Sphere()
	{
		this.sc = ShapeColor.values()[4];
		this.a = 1;
	}
	
	public Sphere(ShapeColor sc, double a)
	{
		super(sc, a);
	}
	
	//copy constructor
	public Sphere(Sphere s)
	{
		this(s.sc, s.a);
	}
	
	//calculates and returns surface area of sphere
	@Override
	public double area()
	{
		return 4.0 * Math.PI * a * a;
	}
	
	//calculates and returns volume of sphere
	@Override
	public double volume()
	{
		return 4.0 * Math.PI * a * a * a / 3.0;
	}
	
	//accessor methods
	public double getA()
	{
		return a;
	}
	
	//mutator method
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	@Override
	public String toString()
	{
		return String.format ("Sphere %s", super.toString());
	}
} //end threeD class

class Cube extends ThreeD
{
	//default constructor
	public Cube()
	{
		this.sc = ShapeColor.values()[4];
		this.a = 1;
	}
	
	public Cube(ShapeColor sc, double a)
	{
		super(sc, a);
	}
	
	//copy constructor
	public Cube(Cube c)
	{
		this(c.sc, c.a);
	}
	
	//calculates and returns surface area of cube
	@Override
	public double area()
	{
		return 6.0 * a * a;
	}
	
	//calculates and returns volume of cube
	@Override
	public double volume()
	{
		return a * a * a;
	}
	
	//accessor methods
	public double getA()
	{
		return a;
	}
	
	//mutator method
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	@Override
	public String toString()
	{
		return String.format ("Cube %s", super.toString());
	}
} //end cube class

class Tetrahedron extends ThreeD
{
	//default constructor
	public Tetrahedron()
	{
		this.sc = ShapeColor.values()[4];
		this.a = 1;
	}
	
	public Tetrahedron(ShapeColor sc, double a)
	{
		super(sc, a);
	}
	
	//copy constructor
	public Tetrahedron(Tetrahedron t)
	{
		this(t.sc, t.a);
	}
	
	//calculates and returns surface area of tetrahedron
	@Override
	public double area()
	{
		return a * a * Math.sqrt(3.0);
	}
	
	//calculates and returns volume of tetrahedron
	@Override
	public double volume()
	{
		return a * a * a / (6.0 * Math.sqrt(2.0));
	}
	
	//accessor methods
	public double getA()
	{
		return a;
	}
	
	//mutator method
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	@Override
	public String toString()
	{
		return String.format ("Tetrahedron %s", super.toString());
	}
} //end tetrahedron class

class a2
{
	//generates and returns random integer 1-9
	private static int getInt()
	{
		Random r = new Random();
		int number = 1 + r.nextInt(10);
		return number;
	}
	
	//generates and returns random real number 0.0-9.9
	private static double getDouble()
	{
		Random r = new Random();
		return 9.9 * r.nextDouble();
	}
	
	//generates and returns a color
	private static ShapeColor getColor()
	{
		Random r = new Random();
		int number = r.nextInt(5); //generates random number 0-4 for indexing the color enum
		ShapeColor element = ShapeColor.values()[number];
		return element;
	}
	
	//checks if triangle can be formed (data validation)
	private static boolean isTriangle(int a, int b, int c)
	{
		boolean check = false;
		if (a + b > c && b + c > a && c + a > b)
		{
			check = true;
		}
		return check;
	}
	
	//generates and returns a TwoD shape
	private static TwoD getTwoD()
	{
		Random rand = new Random();
		int number =  rand.nextInt(4); //generates random number 0-3, determine type of TwoD
		if (number == 0) //0 = circle
		{
			TwoD randTwoD = new Circle(getColor(), getInt());
			return randTwoD;
		} 
		else if (number == 1) //1 = rectangle
		{
			TwoD randTwoD = new Rectangle(getColor(), getInt(), getInt());
			return randTwoD;
		}
		else if (number == 2) //2 = triangle
		{
			int a, b, c;
			do
			{
				a = getInt();
				b = getInt();
				c = getInt();
			} while (isTriangle(a, b, c) == false);
			TwoD randTwoD = new Triangle(getColor(), a, b, c);
			return randTwoD;
		}
		else //3 = trapezoid
		{
			TwoD randTwoD = new Trapezoid(getColor(), getInt(), getInt(), getInt(), getInt(), getInt());
			return randTwoD;
		}
	}
	
	//generates and returns a ThreeD shape
	private static ThreeD getThreeD()
	{
		Random rand = new Random();
		int number = rand.nextInt(3);//generates random number 0-2, determine type of ThreeD
		if (number == 0) //0 = sphere
		{
			ThreeD randThreeD = new Sphere(getColor(), getDouble());
			return randThreeD;
		} 
		else if (number == 1) //1 = cube
		{
			ThreeD randThreeD = new Cube(getColor(), getDouble());
			return randThreeD;
		} 
		else //2 = tetrahedron
		{
			ThreeD randThreeD = new Tetrahedron(getColor(), getDouble());
			return randThreeD;
		}
	}
	
	private static void displayList(ArrayList <Shape> alist)
	{
		int i = 1; //shape number
		for (Shape s : alist)
		{
			System.out.print("Shape " + i + ": ");
			System.out.println(s);
			if (s instanceof Circle)
			{
				Circle circ = (Circle) (s); //downcast
				ShapeColor tempColor;
				do
				{
					tempColor = getColor();
				}
				while (tempColor == circ.getShapeColor());
				circ.recolor(tempColor);
				System.out.printf ("Updated color : %s%nArea = %.3f%nI am a Circle with color changed to %s%n",
						circ.getShapeColor(), circ.area(), circ.getShapeColor());
			}
			else if (s instanceof Rectangle)
			{
				Rectangle rect = (Rectangle) (s); //downcast
				ShapeColor tempColor;
				do
				{
					tempColor = getColor();
				}
				while (tempColor == rect.getShapeColor());
				rect.recolor(tempColor);
				System.out.printf ("Updated color : %s%nArea = %.3f%nI am a Rectangle with color changed to %s%n",
						rect.getShapeColor(), rect.area(), rect.getShapeColor());
			}
			else if (s instanceof Triangle)
			{
				Triangle tri = (Triangle) (s); //downcast
				ShapeColor tempColor;
				do
				{
					tempColor = getColor();
				}
				while (tempColor == tri.getShapeColor());
				tri.recolor(tempColor);
				System.out.printf ("Updated color : %s%nArea = %.3f%nI am a Triangle with color changed to %s%n",
						tri.getShapeColor(), tri.area(), tri.getShapeColor());
			}
			else if (s instanceof Trapezoid)
			{
				Trapezoid trap = (Trapezoid) (s); //downcast
				ShapeColor tempColor;
				do
				{
					tempColor = getColor();
				}
				while (tempColor == trap.getShapeColor());
				trap.recolor(tempColor);
				System.out.printf ("Updated color : %s%nArea = %.3f%nI am a Trapezoid with color changed to %s%n",
						trap.getShapeColor(), trap.area(), trap.getShapeColor());
			}
			else if (s instanceof Sphere)
			{
				Sphere sph = (Sphere) (s); //downcast
				System.out.printf ("Surface Area = %.3f%nVolume = %.3f%n", sph.area(), sph.volume());
				double reduce = getDouble() * 10.0.;
				sph.resize(reduce);
				System.out.printf ("Size reduced by %.1f%% : %s%nUpdated Surface Area = %.3f%nUpdated Volume = %.3f%n"
						+ "I am a Sphere shape%n", reduce, s.toString(), sph.area(), sph.volume());
			}
			else if (s instanceof Cube)
			{
				Cube cub = (Cube) (s); //downcast
				System.out.printf ("Surface Area = %.3f%nVolume = %.3f%n", cub.area(), cub.volume());
				double reduce = getDouble() * 10.0;
				cub.resize(reduce);
				System.out.printf ("Size reduced by %.1f%% : %s%nUpdated Surface Area = %.3f%nUpdated Volume = %.3f%n"
						+ "I am a Cube shape%n", reduce, s.toString(), cub.area(), cub.volume());
			}
			else if (s instanceof Tetrahedron)
			{
				Tetrahedron tetr = (Tetrahedron) (s); //downcast
				System.out.printf ("Surface Area = %.3f%nVolume = %.3f%n", tetr.area(), tetr.volume());
				double reduce = getDouble() * 10.0;
				tetr.resize(reduce);
				System.out.printf ("Size reduced by %.1f%% : %s%nUpdated Surface Area = %.3f%nUpdated Volume = %.3f%n"
						+ "I am a Tetrahedron shape%n", reduce, s.toString(), tetr.area(), tetr.volume());
			}
			System.out.println("------------------------------------");
			i++;
		}
	}
	
	public static void main(String [] args)
	{
		ArrayList <Shape> alist = new ArrayList <Shape>();
		Random rand = new Random();
		int k;
		do
		{
			k = rand.nextInt(3);
			if (k == 1)
			{
				alist.add(getTwoD());
			}
			else if (k == 2)
			{
				alist.add(getThreeD());
			}
		} while (k != 0);
		
		displayList(alist);
	}
} //end a2 class
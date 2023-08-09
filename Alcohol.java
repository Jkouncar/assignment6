
public class Alcohol extends Beverage {
	boolean weekend;
	
	public Alcohol (String name, Type type, Size size, boolean weekend) {
		super(name, type, size);
		this.weekend = weekend;
	}
	
	public double calcPrice() {
		double price = 2;
		if (weekend == true)
			price += 0.6;
		if(size == Size.MEDIUM)
			price += 1;
		if(size == Size.LARGE)
			price += 2;
		return price;
	}
	public boolean equals (String name, Type type, Size size, boolean weekend) {
		boolean result = false;
		super.equals(name, type, size);
		if (this.weekend == weekend)
		 result = true;
		
		return result;
	}
	public String toString() {
		return super.toString() + "\nOffered in Weekend: " + weekend +  "\nPrice: $" + calcPrice();
	}
	
}

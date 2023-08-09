
public class Smoothie extends Beverage{
	boolean protein;
	int fruits;

	public Smoothie(String name, Type type, Size size, boolean protein, int fruits) {
		super(name, type, size);
		this.protein = protein;
		this.fruits = fruits;
	}
	
	public double calcPrice() {
		double price = 2;
		if (protein == true)
			price += 1.5;
		if (fruits > 0)
			price += 0.5*fruits;
		if(size == Size.MEDIUM)
			price += 1;
		if(size == Size.LARGE)
			price += 2;
		return price;
	}
	
	public boolean equals (String name, Type type, Size size, boolean protein, int fruits) {
		boolean result = false;
		super.equals(name, type, size);
		if (this.protein == protein && this.fruits == fruits)
		 result = true;
		
		return result;
	}
	
	public String toString() {
		return super.toString() + "\nProtein: " + protein + "\nNumber of fruits: " + fruits + "\nPrice: $" + calcPrice();
	}
}


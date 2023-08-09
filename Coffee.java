public class Coffee extends Beverage {
	boolean extraShot;
	boolean extraSyrup;

	public Coffee(String name, Type type, Size size, boolean extraShot, boolean extraSyrup) {
		super(name, type, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	public double calcPrice() {
		double price = 2;
		if (extraShot == true)
			price += 0.5;
		if (extraSyrup == true)
			price += 0.5;
		if(size == Size.MEDIUM)
			price += 1;
		if(size == Size.LARGE)
			price += 2;
		return price;
	}
	
	public boolean equals (String name, Type type, Size size, boolean extraShot, boolean extraSyrup) {
		boolean result = false;
		super.equals(name, type, size);
		if (this.extraShot == extraShot && this.extraSyrup == extraSyrup)
		 result = true;
		
		return result;
	}
	
	public String toString() {
		return super.toString() + "\nExtra Shot: " + extraShot + "\nExtra Syrup: " + extraSyrup + "\nPrice: $" + calcPrice();
	}
}
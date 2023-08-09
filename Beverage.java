
public abstract class Beverage {
	public String name;
	public Type type;
	public Size size;
	double BASE_PRICE = 2;
	double SIZE_PRICE = 1;
	
	public Beverage(String name, Type type, Size size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	public abstract double calcPrice();
	
	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	public Size getSize() {
		return size;
	}
	
	
	public boolean equals(String name, Type type, Size size) {
		boolean result = false;
		if (this.name == name && this.type == type && this.size == size)
			result = true;
		
		
		return result;
	}
	
	public String toString() {
		return "Name: " + name + "\nSize: " + size;
	}
	 
	
}

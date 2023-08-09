
public class Customer {
	public String name;
	public int age;
	
	public Customer(String name, int age) {
		this.name= name;
		this.age=age;
	}
	
	public Customer(Customer c1) {
		this.name=c1.getName();
		this.age=c1.getAge();
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "\nName: " + name + "\nAge: " + age;
	}
}


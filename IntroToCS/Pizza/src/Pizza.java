import java.util.ArrayList;
public class Pizza {
	public enum PIZZASIZES {SMALL,MEDIUM,LARGE,HUT};
	private PIZZASIZES size;
	private int num_slices;
	private ArrayList<String> toppings = new ArrayList<String>();
	private String name;
	
	public Pizza(PIZZASIZES size) {
		this.size = size;
		num_slices = 8;
	}
	
	public Pizza(PIZZASIZES size, int num_slices) {
		this.size = size;
		this.num_slices = num_slices;
	}
	
	public boolean Slice(int num_slices) {
		if(this.num_slices >= num_slices) {
			return true;
		} else {
			this.num_slices = num_slices;
			return false;
		}
		
	}
	
	public boolean AddTopping(String topping) {
		if(toppings.size() > 3) {
			return true;
		} else {
			toppings.add(topping);
			return false;
		}
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public String GetName() {
		return name;
	}
	
	public PIZZASIZES GetSize() {
		return size;
	}
	
	public int GetSlices() {
		return num_slices;
	}
	
	public String GetToppings() {
		String getToppings = toppings.toString();
		return getToppings;
	}
	
	public double GetPrice() {
		//String sizeinpt = size;
		double price;
		switch(size) {
			case SMALL: price = 8.50 + (1.25 * toppings.size());break;
			case MEDIUM: price = 10.25 + (1.25 * toppings.size());break;
			case LARGE: price = 12.75 + (1.25 * toppings.size());break;
			case HUT: price = 21.75 + (1.25 * toppings.size());break;
			default: price = 0;
		}
		return price;
		
		/*if(sizeinpt.equals("small")) {
			price = 8.50 + (1.25 * toppings.size());
			return price;
		} else if(sizeinpt.equals("medium")) {
			price = 10.25 + (1.25 * toppings.size());
			return price;
		} else if(sizeinpt.equals("large")) {
			price = 12.75 + (1.25 * toppings.size());
			return price;
		} else {
			price = 21.75 + (1.25 * toppings.size());
			return price;
		}*/
	}
}

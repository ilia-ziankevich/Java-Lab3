package application;

public class Food {
	private int FoodQuantity = 150;
	
	public int GiveFood()
	{
		FoodQuantity-=25;
		return FoodQuantity;
	}
}

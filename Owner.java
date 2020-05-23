package application;

import application.Poodle;
import application.Shepherd_dog;
import application.Terrier;
import javafx.scene.control.TextArea;

public class Owner {
	private Cat CatPet;
	private Poodle PoodlePet = null;
	private Terrier TerrierPet = null;
	private Shepherd_dog ShepherdDogPet = null;
	private TextArea OutputField;
	public Food DogFood = new Food();
	
	Owner(TextArea field)
	{
		OutputField = field;
	}
	
	public void Command()
	{
		if(PoodlePet != null)
		{
			PoodlePet.GetTheCommand(OutputField);
		}
		if(TerrierPet != null)
		{
			TerrierPet.GetTheCommand(OutputField);
		}
		if(ShepherdDogPet != null)
		{
			ShepherdDogPet.GetTheCommand(OutputField);
		}
	}

	public void Feed()
	{
		OutputField.setText(OutputField.getText() + "Вы покормили своего питомца!\n");
	}
	
	public void Walk()
	{
		
	}
	
	public void GetDog(String name, int age, int type)
	{
		switch(type)
		{
		case 1:PoodlePet = new Poodle(name, age);OutputField.setText(OutputField.getText() + "Вы завели пуделя по кличке "+name+ "!\n");break;
		case 2:TerrierPet = new Terrier(name, age);OutputField.setText(OutputField.getText() + "Вы завели терьера по кличке "+name+ "!\n");break;
		case 3:ShepherdDogPet = new Shepherd_dog(name, age);OutputField.setText(OutputField.getText() + "Вы завели овчарку по кличке "+name+ "!\n");break;
		}
	}
	
	public void GetCat(String name, int age)
	{
		CatPet = new Cat(name, age);
		OutputField.setText(OutputField.getText() + "Вы завели кота по кличке "+name+"!\n");
		CatPet.Sleep(OutputField);
	}
}

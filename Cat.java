package application;

import application.Pet;
import javafx.scene.control.TextArea;

public class Cat extends Pet{
	
	public Cat(String n, int a){
		Name = n;
		Age = a;
	}
	
	public void Sleep(TextArea field)
	{
		field.setText(field.getText()+ "Кот " + Name + " спит в кресле\n");
	}
}

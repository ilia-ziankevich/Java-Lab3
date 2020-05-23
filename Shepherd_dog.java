package application;

import javafx.scene.control.TextArea;

public class Shepherd_dog extends Pet_dog{
	
	public Shepherd_dog(String n, int a){
		Name = n;
		Age = a;
	}
	@Override
	protected void DoTheCommand(TextArea field) {
		field.setText(field.getText()+Name+" исполнил команду.\n");
		AskForFood(field);
	}

	@Override
	public void GetTheCommand(TextArea field) {
		field.setText(field.getText()+"Овчарка "+Name+" получает от вас команду.");
		DoTheCommand(field);
	}

	@Override
	public void AskForFood(TextArea field) {
		field.setText(field.getText()+"Овчарка "+Name+" хочет покушать.\n");
	}
}

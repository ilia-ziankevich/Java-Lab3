package application;

import javafx.scene.control.TextArea;

public class Poodle extends Pet_dog{
	
	public Poodle(String n, int a){
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
		field.setText(field.getText()+"Пудель "+Name+" получает от вас команду.");
		DoTheCommand(field);
	}

	@Override
	public void AskForFood(TextArea field) {
		field.setText(field.getText()+"Пудель "+Name+" хочет покушать.\n");
	}
}

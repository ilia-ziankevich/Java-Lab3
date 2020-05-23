package application;

import javafx.scene.control.TextArea;

public class Poodle extends Pet_dog{
	
	public Poodle(String n, int a){
		Name = n;
		Age = a;
	}
	@Override
	protected void DoTheCommand(TextArea field) {
		field.setText(field.getText()+Name+" �������� �������.\n");
		AskForFood(field);
	}

	@Override
	public void GetTheCommand(TextArea field) {
		field.setText(field.getText()+"������ "+Name+" �������� �� ��� �������.");
		DoTheCommand(field);
	}

	@Override
	public void AskForFood(TextArea field) {
		field.setText(field.getText()+"������ "+Name+" ����� ��������.\n");
	}
}

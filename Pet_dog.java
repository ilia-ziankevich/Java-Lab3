package application;

import javafx.scene.control.TextArea;

public abstract class Pet_dog extends Pet{
	
	protected abstract void DoTheCommand(TextArea field);
	public abstract void GetTheCommand(TextArea field);
	public abstract void  AskForFood(TextArea field);
}

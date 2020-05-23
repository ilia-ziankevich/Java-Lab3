package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,900,450);
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		HBox hbox3 = new HBox();
		VBox vbox1 = new VBox();
		TextField pet_name = new TextField("Имя питомца");
		TextField pet_age = new TextField("Возраст");
		TextField food = new TextField("150");
		TextArea info_label = new TextArea();
		RadioButton poodle = new RadioButton("Пудель");
		RadioButton terrier = new RadioButton("Терьер");
		RadioButton shepherd_dog = new RadioButton("Овчарка");
		Button get_cat = new Button("Завести котика");
		Button get_dog = new Button("Завети собачку");
		Button command =  new Button("Дать команду собачке");
		Button feed = new Button("Покормить");
		Owner owner1 = new Owner(info_label);
		Food pack1 = new Food();
		
		poodle.setSelected(true);
		feed.setDisable(true);
		command.setDisable(true);
		food.setEditable(false);
		hbox3.getChildren().addAll(feed, food);
		hbox2.getChildren().addAll(get_cat, get_dog);
		vbox1.getChildren().addAll(pet_name, pet_age, poodle, terrier, shepherd_dog, hbox2, command, hbox3);
		hbox1.getChildren().addAll(vbox1, info_label);
		vbox1.setMinSize(430d, 430d);
		vbox1.setTranslateX(20d);
		vbox1.setTranslateY(20d);
		info_label.setMinSize(470d, 450d);
		pet_name.setMaxWidth(200d);
		pet_age.setMaxWidth(75d);
		pet_age.setTranslateY(20d);
		poodle.setTranslateY(40d);
		terrier.setTranslateY(50d);
		shepherd_dog.setTranslateY(60d);
		hbox2.setTranslateY(140d);
		command.setTranslateY(170d);
		hbox3.setTranslateY(200d);
		get_dog.setTranslateX(40d);
		food.setMaxWidth(40d);
		food.setTranslateX(120d);
		
		EventHandler<ActionEvent> poodle_event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent poodle_event) 
	    	{ 
				poodle.setSelected(true);
				terrier.setSelected(false);
				shepherd_dog.setSelected(false);
	    	} 
	    };
		EventHandler<ActionEvent> terrier_event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent  terrier_event) 
	    	{ 
				poodle.setSelected(false);
				terrier.setSelected(true);
				shepherd_dog.setSelected(false);
	    	} 
	    };
		EventHandler<ActionEvent> shepherd_dog_event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent shepherd_dog_event) 
	    	{ 
				poodle.setSelected(false);
				terrier.setSelected(false);
				shepherd_dog.setSelected(true);
	    	} 
	    };
		EventHandler<ActionEvent> get_cat_event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent get_cat_event) 
	    	{ 
				owner1.GetCat(pet_name.getText(), Integer.parseInt(pet_age.getText()));
				get_cat.setDisable(true);
	    	} 
	    };
		EventHandler<ActionEvent> get_dog_event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent get_dog_event) 
	    	{ 
				if(poodle.isSelected())
					owner1.GetDog(pet_name.getText(), Integer.parseInt(pet_age.getText()), 1);
				if(terrier.isSelected())
					owner1.GetDog(pet_name.getText(), Integer.parseInt(pet_age.getText()), 2);
				if(shepherd_dog.isSelected())
					owner1.GetDog(pet_name.getText(), Integer.parseInt(pet_age.getText()), 3);
				get_dog.setDisable(true);
				command.setDisable(false);
				feed.setDisable(false);
	    	} 
	    };
		EventHandler<ActionEvent> command_event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent command_event) 
	    	{ 
				owner1.Command();
				command.setDisable(true);
	    	} 
	    };
		EventHandler<ActionEvent> feed_event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent feed_event) 
	    	{ 
				if(Integer.parseInt(food.getText())==0)
				{
					info_label.setText(info_label.getText() + "Невозможно покормить: Корм закончился!\n");
					return;
				}
				food.setText(String.valueOf(pack1.GiveFood()));
				owner1.Feed();
				command.setDisable(false);
	    	} 
	    };
		
	    poodle.setOnAction(poodle_event);
	    terrier.setOnAction(terrier_event);
	    shepherd_dog.setOnAction(shepherd_dog_event);
	    command.setOnAction(command_event);
	    feed.setOnAction(feed_event);
	    get_cat.setOnAction(get_cat_event);
	    get_dog.setOnAction(get_dog_event);
		root.getChildren().addAll(hbox1);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

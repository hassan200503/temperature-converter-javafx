package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;  // Added import statement for Insets


public class TemperatureConverterApp extends Application{


    //VBox layout for all the scenes

VBox root = new VBox(10);


//status message for the entire app
Label notification = new Label();

//input labels and fields for both conversions
Label tempinput = new Label();
TextField tempinputfield = new TextField();


@Override

public void start(Stage stage){
    


root.setPadding(new Insets(20));


notification.setStyle("-fx-text-fill:red;");  //status message

tempinput.setStyle("-fx-text-fill:blue;");





root.getChildren().add(notification);


Menu(stage);



Scene  scene = new Scene(root,1000,500);

stage.setScene(scene);
stage.setTitle("TEMPERATURE CONVERTER APP");

stage.show();



}



//Menu 

private void Menu(Stage stage){

root.getChildren().clear();

Label choosescale = new Label("Choose your suitable scale below;");
choosescale.setStyle("-fx-font-size:15px;");


//Buttons to choose the conversion type

Button celciusbutton = new Button("Celcius to Fahrenheit");

celciusbutton.setStyle("-fx-text-fill:blue;");

celciusbutton.setOnAction(e -> Celciusinput(stage));



Button fahtbutton = new Button("Fahrenheit to Celcius");
fahtbutton.setStyle("-fx-text-fill:blue");

fahtbutton.setOnAction(e -> Fahtinput(stage));



//Button to go back to the menu 

Button backbutton = new Button("Back");
backbutton.setStyle("-fx-text-fill: purple");


root.getChildren().addAll(choosescale,celciusbutton,fahtbutton);





}





//Input layout for celcius

private void Celciusinput(Stage stage){

root.getChildren().clear();

//Heading for the conversion type

Label area = new Label("Celcius to Fahrenheit");
area.setStyle("-fx-font-size: 24px; -fx-font-color:blue");




tempinput.setText("Temperature in degrees:  ");
tempinputfield = new TextField();

Button backbutton = new Button("Menu");
backbutton.setOnAction(e ->  Menu(stage)    );


//Button to convert the temperature after inputting the value
Button convertbutton = new Button("Convert temperature");

convertbutton.setOnAction(e -> Convertcelcius(stage)    );


//Layout for the input field and its label
HBox inputlayout = new HBox();

inputlayout.getChildren().addAll(tempinput,tempinputfield);

root.getChildren().addAll(area,inputlayout,convertbutton,backbutton);



}





//Calculations
private void Convertcelcius(Stage stage){

    root.getChildren().clear();


    try{

float degrees = Float.parseFloat(tempinputfield.getText());

float result = (degrees * 9/5) + 32;


//Displaying the output


Label tempoutput = new Label("Temperature in Fahreint: " + result);
tempoutput.setStyle("-fx-text-fill:blue;");


//Button to go back to the menu after conversion

Button backbutto = new Button("Back");

backbutto.setStyle("-fx-text-fill: blue");

backbutto.setOnAction(event -> Menu(stage));

notification.setText("Temperature converted successfully!");

root.getChildren().addAll(tempoutput,backbutto,notification);


    }


    //If user enters an invalid input
catch(Exception e){

notification.setText("Error, please enter a valid value to convert!");
Button backbutton = new Button("Back");
backbutton.setOnAction(event -> Celciusinput(stage)  );

root.getChildren().addAll(notification,backbutton);
}




}





//Fahrenheit to Celcius conversion

private void Fahtinput(Stage stage){
root.getChildren().clear();

//Heading for the conversion type

Label area = new Label("Fahrenheit to Celsius");

area.setStyle("-fx-font-size: 24px; ");


//Label and textfield for the input

tempinput.setText("Temperature in Fahrenheit: ");
tempinput.setStyle("-fx-text-weight: italic; -fx-text-weght:bold;");

tempinputfield = new TextField();


//Layout for the input field and its label
HBox inputlayout = new HBox();

inputlayout.getChildren().addAll(tempinput,tempinputfield);


//Button to convert the temperature after entering a value
Button convertbutton = new Button("Convert temperature");
convertbutton.setOnAction(e -> ConvertFah(stage)   );


//Button to go back to the menu
Button backbutton = new Button("Back");
backbutton.setOnAction(e -> Menu(stage)   );

root.getChildren().addAll(area,inputlayout,convertbutton,backbutton); 



}








// Method to convert Fahrenheit to Celcius


private void ConvertFah(Stage stage){

root.getChildren().clear();


try{

//Calculation

float fah = Float.parseFloat(tempinputfield.getText());

float celcius = (fah - 32) * 5/9 ;

//output

Label tempoutput = new Label("Tempereture in degrees: " + celcius );
tempoutput.setStyle("-fx-text-fill:blue;");

//Button to go back to the menu 


Button backbutton = new Button("Back");
backbutton.setStyle("-fx-text-fill:brown;");
backbutton.setOnAction(event-> Menu(stage)  );

//after successful conversion notification
notification.setText("Temperature converted successfully");

root.getChildren().addAll(tempoutput,backbutton,notification);


}

//if the user enters wrong input

catch(Exception e ){
notification.setText("Error, please enter a valid value to convert!");

//Button to go back to the input page for Fahrenheit to Celcius conversion
Button backbutton = new Button("Back");
backbutton.setOnAction(event -> Fahtinput(stage)  );

root.getChildren().addAll(notification,backbutton);
}

}







public static void main(String[]args){



launch(args);




}
}






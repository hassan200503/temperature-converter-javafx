package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;  // Added import statement for Insets
import javafx.stage.Stage;








public class TemperatureConverterApp extends Application{


    //VBox layout for all the scenes

VBox root = new VBox(100);


//status message for the entire app
Label notification = new Label();

//input labels and fields for both conversions
Label tempinput = new Label();
TextField tempinputfield = new TextField();


@Override

public void start(Stage stage){
    


root.setPadding(new Insets(20));
root.setAlignment(Pos.CENTER);

notification.setStyle("-fx-text-fill: red; -fx-font-size: 21px;  -fx-font-weight: bold; -fx-font-style: italic;");  //status message


//set style for temiput label and tempinputfield

tempinput.setStyle("-fx-text-fill: darkblue; -fx-font-size: 21px; -fx-font-weight: bold; ");




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

Label choosescale = new Label("choose your suitable scale below");
choosescale.setStyle("-fx-font-size:24px; -fx-font-weight: bold; -fx-text-fill: black;");



//Buttons to choose the conversion type

Button celciusbutton = new Button("Celcius to Fahrenheit");
celciusbutton.setPrefWidth(400);
celciusbutton.setPrefHeight(40);

celciusbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold;");


//mouse action


celciusbutton.setOnMouseEntered(e ->{


celciusbutton.setStyle("-fx-text-fill: white; -fx-font-size: 21px; -fx-background-color: blue; -fx-font-weight: bold;");


});



celciusbutton.setOnMouseExited(e ->{

celciusbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold;");



});









celciusbutton.setOnAction(e -> Celciusinput(stage));



Button fahtbutton = new Button("Fahrenheit to Celcius");

fahtbutton.setPrefWidth(300);
fahtbutton.setPrefHeight(40);



fahtbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold;");


//mouse action

fahtbutton.setOnMouseEntered(e ->{

fahtbutton.setStyle("-fx-text-fill: white; -fx-font-size: 21px; -fx-background-color: blue; -fx-font-weight: bold;");



});



fahtbutton.setOnMouseExited(e ->{

fahtbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold;");


});







fahtbutton.setOnAction(e -> Fahtinput(stage));






root.getChildren().addAll(choosescale,celciusbutton,fahtbutton);





}





//Input layout for celcius

private void Celciusinput(Stage stage){

root.getChildren().clear();

//Heading for the conversion type

Label area = new Label("Celcius to Fahrenheit");
area.setStyle("-fx-font-size:24px; -fx-font-weight: bold; -fx-text-fill: black;");




tempinput.setText("Temperature in degrees");


tempinputfield.setStyle("-fx-text-fill: black; -fx-font-size: 17px; -fx-font-weight: bold;");
tempinputfield.setPrefWidth(300);
tempinputfield.setPrefHeight(50);
tempinputfield.setMaxWidth(300);
tempinputfield.setMaxHeight(50);




Button backbutton = new Button("Menu");
backbutton.setPrefWidth(100);
backbutton.setPrefHeight(40);
backbutton.setStyle("-fx-text-fill: white; -fx-background-color: blue; -fx-font-size: 17px; -fx-font-weight: bold;");

//mouse action


backbutton.setOnMouseEntered(e ->{

backbutton.setStyle("-fx-text-fill: white; -fx-background-color: blue; -fx-font-size: 19px; -fx-font-weight: bold;");



});




backbutton.setOnMouseExited(e ->{

backbutton.setStyle("-fx-text-fill: white; -fx-background-color: blue; -fx-font-size: 17px; -fx-font-weight: bold;");



});





backbutton.setOnAction(e ->  Menu(stage)    );


//Button to convert the temperature after inputting the value
Button convertbutton = new Button("Convert temperature");

convertbutton.setPrefWidth(400);
convertbutton.setPrefHeight(40);
convertbutton.setStyle("-fx-text-fill: white; -fx-background-color: blue; -fx-font-size: 17px; -fx-font-weight: bold;");

//mouse action

convertbutton.setOnMouseEntered(e ->{


convertbutton.setStyle("-fx-text-fill: white; -fx-background-color: blue; -fx-font-size: 21px; -fx-font-weight: bold;");


});



convertbutton.setOnMouseExited(e ->{

convertbutton.setStyle("-fx-text-fill: white; -fx-background-color: blue; -fx-font-size: 17px; -fx-font-weight: bold;");

});





convertbutton.setOnAction(e -> Convertcelcius(stage)    );


//Layout for the input field and its label
HBox inputlayout = new HBox(5);
inputlayout.setPadding(new Insets(20));
inputlayout.setAlignment(Pos.CENTER);

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


Label tempoutput = new Label("Temperature in Fahreint  " + result);
tempoutput.setStyle("-fx-text-fill: darkblue; -fx-font-size: 20px; -fx-font-weight: bold; ");


//Button to go back to the menu after conversion

Button backbutton = new Button("Main menu");
backbutton.setPrefWidth(200);
backbutton.setPrefHeight(40);

backbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold");


//mouse action

backbutton.setOnMouseEntered(e ->{

backbutton.setStyle("-fx-text-fill: white; -fx-font-size: 19px; -fx-background-color: blue; -fx-font-weight: bold;");

});



backbutton.setOnMouseExited(e ->{

backbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold;");


});




backbutton.setOnAction(event -> Menu(stage));

notification.setText("Temperature converted successfully!");

root.getChildren().addAll(tempoutput,backbutton,notification);


    }


    //If user enters an invalid input
catch(Exception e){

notification.setText("Error, please enter a valid value to convert!");
Button backbutton = new Button("Back");
backbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue;");
backbutton.setPrefWidth(100);
backbutton.setPrefHeight(40);

//mouse action

backbutton.setOnMouseEntered(ev ->{

backbutton.setStyle("-fx-text-fill: white; -fx-font-size: 19px; -fx-background-color: blue;");

});


backbutton.setOnMouseExited(ev ->{

backbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue;");


});




backbutton.setOnAction(event -> Celciusinput(stage)  );

root.getChildren().addAll(notification,backbutton);
}




}










//Fahrenheit to Celcius conversion

private void Fahtinput(Stage stage){
root.getChildren().clear();

//Heading for the conversion type

Label area = new Label("Fahrenheit to Celsius");
area.setStyle("-fx-font-size:24px; -fx-font-weight: bold; -fx-text-fill: black;");



//Label and textfield for the input

tempinput.setText("Temperature in Fahrenheit");
tempinputfield = new TextField();

tempinputfield.setStyle("-fx-text-fill: black; -fx-font-size: 17px; -fx-font-weight: bold;");
tempinputfield.setPrefWidth(300);
tempinputfield.setPrefHeight(50);
tempinputfield.setMaxWidth(300);
tempinputfield.setMaxHeight(50);



//Layout for the input field and its label
HBox inputlayout = new HBox(10);
inputlayout.setPadding(new Insets(20));
inputlayout.setAlignment(Pos.CENTER);



inputlayout.getChildren().addAll(tempinput,tempinputfield);


//Button to convert the temperature after entering a value
Button convertbutton = new Button("Convert temperature");
convertbutton.setPrefWidth(400);
convertbutton.setPrefHeight(40);
convertbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold;");


//mouse action

convertbutton.setOnMouseEntered(ev ->{

convertbutton.setStyle("-fx-text-fill: white; -fx-font-size: 21px; -fx-background-color: blue; -fx-font-weight: bold;");

});


convertbutton.setOnMouseExited(event ->{

convertbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold;");


});






convertbutton.setOnAction(e -> ConvertFah(stage)   );


//Button to go back to the menu
Button backbutton = new Button("Menu");
backbutton.setPrefWidth(100);
backbutton.setPrefHeight(40);
backbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold;");

//mouse action

backbutton.setOnMouseEntered(ev ->{

convertbutton.setStyle("-fx-text-fill: white; -fx-font-size: 19px; -fx-background-color: blue; -fx-font-weight: bold;");


});



backbutton.setOnMouseExited(ev ->{

backbutton.setStyle("-fx-text-fill: white; -fx-font-size: 17px; -fx-background-color: blue; -fx-font-weight: bold;");


});







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

Label tempoutput = new Label("Tempereture in degrees  " + celcius );
tempoutput.setStyle("-fx-text-fill: darkblue; -fx-font-size: 20px; -fx-font-weight: bold; ");

//Button to go back to the menu 


Button backbutton = new Button("Menu");
backbutton.setPrefWidth(100);
backbutton.setPrefHeight(40);
backbutton.setStyle("-fx-font-size: 17px; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-color: blue;");

//mouse action

backbutton.setOnMouseEntered(ev ->{

backbutton.setStyle("-fx-font-size: 19px; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-color: blue;");


});


backbutton.setOnMouseExited(ev ->{

backbutton.setStyle("-fx-font-size: 17px; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-color: blue;");


});





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
backbutton.setStyle("-fx-font-size: 15px; -fx-text-fill: white; -fx-background-color: blue; -fx-font-weight: bold;");
backbutton.setPrefWidth(100);
backbutton.setPrefHeight(40);

//mouse action

backbutton.setOnMouseEntered(ev ->{
backbutton.setStyle("-fx-font-size: 17px; -fx-text-fill: white; -fx-background-color: blue; -fx-font-weight: bold;");


});



backbutton.setOnMouseExited(event ->{
backbutton.setStyle("-fx-font-size: 15px; -fx-text-fill: white; -fx-background-color: blue; -fx-font-weight: bold;");


});






backbutton.setOnAction(event -> Fahtinput(stage)  );

root.getChildren().addAll(notification,backbutton);
}

}







public static void main(String[]args){



launch(args);




}
}






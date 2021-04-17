/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapplication;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.event.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class DrawingApplication extends Application {
	
    static Color color;
    static String mode="";
    static double length;
    Line line = new Line();
    Rectangle rect = new Rectangle();
    Circle circle = new Circle();
   
    Scene scene;
   

	@Override
    public void start(Stage primaryStage) {
    	//second scene
		//create Button
		Pane pane2 = new Pane();
		Label ll = new Label("Paint Application\n Created BY\n EL Maaroufi Abdessamad");
		ll.setLayoutX(8);
		ll.setLayoutY(90);
		ll.setStyle("-fx-background-color: \r\n"
    			+ "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
    			+ "        linear-gradient(#020b02, #3a3a3a),\r\n"
    			+ "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\r\n"
    			+ "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\r\n"
    			+ "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\r\n"
    			+ "    -fx-background-insets: 0,1,4,5,6;\r\n"
    			+ "    -fx-background-radius: 9,8,5,4,3;\r\n"
    			+ "    -fx-padding: 15 30 15 30;\r\n"
    			+ "    -fx-font-family: \"Helvetica\";\r\n"
    			+ "    -fx-font-size: 18px;\r\n"
    			+ "    -fx-font-weight: bold;\r\n"
    			+ "    -fx-text-fill: white;\r\n"
    			+ "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
    	
    	
    	Button bg=new Button();
    	bg.setText("BACK");
    	bg.setLayoutX(10);
    	bg.setLayoutY(30);
    	bg.setStyle(" -fx-background-color: \r\n"
    			+ "        #ecebe9,\r\n"
    			+ "        rgba(0,0,0,0.05),\r\n"
    			+ "        linear-gradient(#dcca8a, #c7a740),\r\n"
    			+ "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\r\n"
    			+ "        linear-gradient(#f6ebbe, #e6c34d);\r\n"
    			+ "    -fx-background-insets: 0,9 9 8 9,9,10,11;\r\n"
    			+ "    -fx-background-radius: 50;\r\n"
    			+ "    -fx-padding: 15 30 15 30;\r\n"
    			+ "    -fx-font-family: \"Helvetica\";\r\n"
    			+ "    -fx-font-size: 18px;\r\n"
    			+ "    -fx-text-fill: #311c09;\r\n"
    			+ "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");
    	
    	pane2.getChildren().addAll(ll,bg);
    	Scene scene3 = new Scene(pane2,300,300);
    	pane2.setStyle("-fx-background-color: #F0F8FF");
    	Button b1=new Button("About");
    	b1.setLayoutX(550);
    	b1.setLayoutY(150);
    	b1.setStyle("-fx-background-color: \r\n"
    			+ "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
    			+ "        linear-gradient(#020b02, #3a3a3a),\r\n"
    			+ "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\r\n"
    			+ "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\r\n"
    			+ "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\r\n"
    			+ "    -fx-background-insets: 0,1,4,5,6;\r\n"
    			+ "    -fx-background-radius: 9,8,5,4,3;\r\n"
    			+ "    -fx-padding: 15 30 15 30;\r\n"
    			+ "    -fx-font-family: \"Helvetica\";\r\n"
    			+ "    -fx-font-size: 18px;\r\n"
    			+ "    -fx-font-weight: bold;\r\n"
    			+ "    -fx-text-fill: white;\r\n"
    			+ "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
    	b1.setOnAction(e ->primaryStage.setScene(scene3));
    	
    	
    	Button b2=new Button("Start ");
    	b2.setLayoutX(550);
    	b2.setLayoutY(250);
    	b2.setStyle("-fx-background-color: \r\n"
    			+ "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
    			+ "        linear-gradient(#020b02, #3a3a3a),\r\n"
    			+ "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\r\n"
    			+ "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\r\n"
    			+ "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\r\n"
    			+ "    -fx-background-insets: 0,1,4,5,6;\r\n"
    			+ "    -fx-background-radius: 9,8,5,4,3;\r\n"
    			+ "    -fx-padding: 15 30 15 30;\r\n"
    			+ "    -fx-font-family: \"Helvetica\";\r\n"
    			+ "    -fx-font-size: 18px;\r\n"
    			+ "    -fx-font-weight: bold;\r\n"
    			+ "    -fx-text-fill: white;\r\n"
    			+ "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
    	b2.setOnAction(e ->primaryStage.setScene(scene));
    	
       
    	Button b3=new Button("Close");
    	b3.setLayoutX(550);
    	b3.setLayoutY(350);
    	b3.setStyle("-fx-background-color: \r\n"
    			+ "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
    			+ "        linear-gradient(#020b02, #3a3a3a),\r\n"
    			+ "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\r\n"
    			+ "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\r\n"
    			+ "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\r\n"
    			+ "    -fx-background-insets: 0,1,4,5,6;\r\n"
    			+ "    -fx-background-radius: 9,8,5,4,3;\r\n"
    			+ "    -fx-padding: 15 30 15 30;\r\n"
    			+ "    -fx-font-family: \"Helvetica\";\r\n"
    			+ "    -fx-font-size: 18px;\r\n"
    			+ "    -fx-font-weight: bold;\r\n"
    			+ "    -fx-text-fill: white;\r\n"
    			+ "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
    	
    	        b3.setOnAction(e ->((Stage)(((Button)e.getSource()).getScene().getWindow())).close());
    	        
    	       
    	
    	
   //create LOGO or Label
    	
    	
    	
    
    // setting up layout 
    Pane pane = new Pane();
    
    pane.getChildren().addAll(b1,b2,b3);
   
    Scene scene2 = new Scene(pane,950,600);
   
   //hona
	//b2.setOnAction(e ->primaryStage.setScene(scene2));
    
    scene2.getStylesheets().add("drawingapplication/style2.css");
    
     // show stage

     
    

		
    	
    	//la fin de seconde scene
       
    // create HBox widgets 
    ColorPicker colorPicker = new ColorPicker();
    colorPicker.setStyle("-fx-background-color: #ffbd59");
    
    Label label = new Label("", new ImageView("drawingapplication/ps.png"));
    
     //create a scroll bar
    ScrollBar scrollBar = new ScrollBar();
    scrollBar.setMin(5);
    scrollBar.setMax(75);
    scrollBar.setValue(20);
    
    // change color
    colorPicker.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
               color = colorPicker.getValue();
            }
    });
     
    Button paintBtn = new Button("", new ImageView("drawingapplication/paintt.png"));
  paintBtn.setStyle("-fx-background-color: #f6f9fb");
    
    Button strokeBtn = new Button("", new ImageView("drawingapplication/stroke.png"));
    strokeBtn.setStyle("-fx-background-color: #f6f9fb");
    Button fillStrokeBtn = new Button("", new ImageView("drawingapplication/strokep.png"));
    fillStrokeBtn.setStyle("-fx-background-color: #f6f9fb");
    
    Button rectangleBtn = new Button("", new ImageView("drawingapplication/rec.png"));
    rectangleBtn.setStyle("-fx-background-color: #f6f9fb");
    Button fillRectBtn = new Button("", new ImageView("drawingapplication/recp.png"));
    fillRectBtn.setStyle("-fx-background-color: #f6f9fb");
    
    Button circleBtn = new Button("", new ImageView("drawingapplication/noplein.png"));
    circleBtn.setStyle("-fx-background-color:#f6f9fb");

    
    Button fillCircleBtn = new Button("", new ImageView("drawingapplication/plein.png"));
    fillCircleBtn.setStyle("-fx-background-color: #f6f9fb");

    
    
    Button saveBtn = new Button("", new ImageView("drawingapplication/SV.png"));
    
    Button eraserBtn = new Button("", new ImageView("drawingapplication/eraser.png"));
    eraserBtn.setStyle("-fx-background-color: #f6f9fb");
    Button openBtn = new Button("", new ImageView("drawingapplication/SN.png"));
 
    Button home = new Button("", new ImageView("drawingapplication/HN.png"));
   
    home.setOnAction(e ->primaryStage.setScene(scene2));
    bg.setOnAction(e ->primaryStage.setScene(scene2));
   	Label ls1=new Label("");
   	Label ls2=new Label("");
   	Label ls3=new Label("");
   	Label ls4=new Label("");
   	Label ls5=new Label("");
   	Label ls6=new Label("");
   	Label ls7=new Label("");
   	Label ls8=new Label("");
   	
    
    // add event listeners to each button 
    paintBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                mode="Paint";
            }
        });
    
    strokeBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                mode="Stroke";
            }
        });
    
    fillStrokeBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                mode="Fill Stroke";
            }
        });
    

    eraserBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                mode="eraser";
            }
        });
    rectangleBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                mode="Rectangle";
            }
        });
    
    fillRectBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                mode="Fill Rect";
            }
        });
    
    circleBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                mode="Circle";
            }
        });
    
    fillCircleBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                mode="Fill Circle";
            }
        });
    
    
    //Creating a VBox 
    VBox btns = new VBox(2);
        btns.getChildren().addAll(colorPicker,label,scrollBar,paintBtn,strokeBtn,fillStrokeBtn,rectangleBtn,fillRectBtn,circleBtn,fillCircleBtn,eraserBtn);
        btns.setStyle("-fx-background-image: url(\"file:///C:/Users/admin/Downloads/bac1.png\");\r\n"
        		+ "    -fx-background-size: 100% 100%;\r\n"
        		+ "    -fx-background-attachement:fixed;");
        btns.setPrefWidth(200);
        btns.setAlignment(Pos.TOP_CENTER);
         
        //creating a VBOX2
        VBox btns2 = new VBox(10);
        btns2.setStyle("-fx-background-color: #cfd8dc;");
        btns2.getChildren().addAll(ls1,ls7,ls8,ls6,home,ls2,ls3,openBtn,ls4,ls5,saveBtn);
        btns2.setPrefWidth(80);
        
       
        
        
        
        
        
        
     Canvas canvas = new Canvas(700,600);
     GraphicsContext context = canvas.getGraphicsContext2D();
     context.setLineWidth(1);

     
     canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
           
            if(mode == "Paint"){
                context.setFill(colorPicker.getValue());
                length = scrollBar.getValue();
            }
            
            
           
                
                if(mode == "eraser"){
                	canvas.getGraphicsContext2D().setFill(color.WHITE);
                	
                	
                   
                    
                }
            
            else if(mode == "Stroke"){
                context.setStroke(colorPicker.getValue());
                context.beginPath();
       
            }
            
            else if (mode == "Fill Stroke"){
                
                context.setStroke(colorPicker.getValue());
                context.setFill(colorPicker.getValue());
                context.beginPath();
                line.setStartX(e.getX());
                line.setStartY(e.getY());
            }
            
            else if(mode == "Rectangle"){
               
                context.setStroke(colorPicker.getValue());
                
                rect.setX(e.getX());
                rect.setY(e.getY());
                
            }
            
            else if (mode == "Fill Rect"){
                context.setFill(colorPicker.getValue());
                
                rect.setX(e.getX());
                rect.setY(e.getY());
            }
            
            else if(mode=="Circle"){
                context.setStroke(colorPicker.getValue());
          
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
            }
            
            else if(mode=="Fill Circle"){
                context.setFill(colorPicker.getValue());
                
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
            }
        }
    });
    
     canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
           
            if(mode == "Paint"){
                context.fillRect(e.getX(),e.getY(),length,length);
            }
            else  if(mode == "eraser"){
                context.fillRect(e.getX(),e.getY(),length,length);
            }
            else if(mode == "Stroke" || mode =="Fill Stroke"){
                context.lineTo(e.getX(), e.getY());
                context.stroke();
            }
            
            
        }
    });
    
     canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
           
          
            
            if(mode == "Stroke"){
              
                context.closePath();
            }
            else if(mode == "Fill Stroke"){
                line.setEndX(e.getX());
                line.setEndY(e.getY());
                context.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
                context.fill();
            }
            
            else if(mode=="Rectangle"){
                
                rect.setWidth(Math.abs(e.getX()-rect.getX()));
                rect.setHeight(Math.abs(e.getY()-rect.getY()));
                
                if(rect.getX()>e.getX()){
                    rect.setX(e.getX());
                }
                
                if(rect.getY()>e.getY()){
                    rect.setY(e.getY());
                }
                
                context.strokeRect(rect.getX(),rect.getY(),rect.getWidth(),rect.getHeight());
            }
            
            else if(mode=="Fill Rect"){
                
                rect.setWidth(Math.abs(e.getX()-rect.getX()));
                rect.setHeight(Math.abs(e.getY()-rect.getY()));
                
                if(rect.getX()>e.getX()){
                    rect.setX(e.getX());
                }
                
                if(rect.getY()>e.getY()){
                    rect.setY(e.getY());
                }
                
                context.fillRect(rect.getX(),rect.getY(),rect.getWidth(),rect.getHeight());
            }
            
            else if(mode=="Circle"){
                
                circle.setRadius(Math.sqrt(Math.pow(circle.getCenterX()-e.getX(),2) + Math.pow(circle.getCenterY()-e.getY(),2)));
                

                context.strokeOval(circle.getCenterX(),circle.getCenterY(),circle.getRadius(),circle.getRadius());
    
            }
            
            else if(mode=="Fill Circle"){
                
                circle.setRadius(Math.sqrt(Math.pow(circle.getCenterX()-e.getX(),2) + Math.pow(circle.getCenterY()-e.getY(),2)));
                
                context.fillOval(circle.getCenterX(),circle.getCenterY(),circle.getRadius(),circle.getRadius());
    
            }
          
        }
    });
    
     // Open
        openBtn.setOnAction((e)->{
            FileChooser openFile = new FileChooser();
            openFile.setTitle("Open File");
            File file = openFile.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    InputStream io = new FileInputStream(file);
                    Image img = new Image(io);
                    context.drawImage(img, 0, 0);
                } catch (IOException ex) {
                    System.out.println("Error!");
                }
            }
        });
        
        // Save
        saveBtn.setOnAction((e)->{
            FileChooser savefile = new FileChooser();
            savefile.setTitle("Save File");
            
            File file = savefile.showSaveDialog(primaryStage);
            if (file != null) {
                try {
                    WritableImage writableImage = new WritableImage(1200, 800);
                    canvas.snapshot(null, writableImage);
                    RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                    ImageIO.write(renderedImage, "png", file);
                } catch (IOException ex) {
                    System.out.println("Error!");
                }
            }
            
        });
    // setting up layout 
    BorderPane borderPane = new BorderPane();
    borderPane.setLeft(btns);
    borderPane.setRight(btns2);
    borderPane.setCenter(canvas);
   
     scene = new Scene(borderPane);
   //hona
	//b2.setOnAction(e ->primaryStage.setScene(scene2));
    
    scene.getStylesheets().add("drawingapplication/style.css");
   
     // show stage
     primaryStage.setScene(scene);
     primaryStage.setTitle("Drawing Application");
     primaryStage.show();
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

	
    
}

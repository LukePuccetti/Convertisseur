package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable {

    @FXML
    private TabPane monPane;
    
    @FXML
    public Button btnQuitter;
    
    @FXML
    public Button btnHomeV;
	
    @FXML
    public Button btnHomeM;
	
    @FXML
    public Button btnHomeL;
	
    @FXML
    public Button btnQuitterV;
	
    @FXML
    public Button btnQuitterM;
	
    @FXML
    public Button btnQuitterL;
    //==============================================================================================================================================
   
    @FXML
    public Button btnVolume;
   
    	@FXML
    	private ComboBox<String> vcbo1;
    	
    	private ObservableList<String> ListVolume=FXCollections.observableArrayList("Litre","Mililitre","Metre Cubic","Pouse Cubic","Pied Cubic","Gallon Liquide US","Pinte Liquide US");
        private double []volume= {1.0, 1000, 0.001, 61.0237, 0.0353147, 0.264172, 2.11338};
    	
    	private double setTaux(ComboBox a, double tbl [])
    	{
    		return tbl[a.getSelectionModel().getSelectedIndex()];
    	}
    	@FXML
    	private void convert1()
    	{
    		convertir(vcbo1,vcbo2,vtxt1,vtxt2,volume);
    	}
    	
    	@FXML
    	private void convert2()
    	{
    		convertir(vcbo2,vcbo1,vtxt2,vtxt1,volume);
    	}
    	private void convertir(ComboBox a,ComboBox b, TextField c,TextField d, double tbl[])  
    	{
    		double from=setTaux(a,tbl);
    		double to=setTaux(b,tbl);
    		double depart=0.0;
    		/*if(c.getText().equals(""))
    			depart=0.0;
    		else
    			depaart=Double.parseDouble(c.getText()); */
    		depart=c.getText().equals("")?0.0:Double.parseDouble(c.getText());
    		double dest=(to/from)*depart;
    		d.setText(String.valueOf(dest));
    	}
    	
    	@FXML
    	private ComboBox<String> vcbo2;
    	
    	@FXML
    	private TextField vtxt1;
    	
    	@FXML
        private TextField vtxt2;
   //========================================================================================================================================
   
    	@FXML
    public Button btnMasse;
    
	@FXML
	private ComboBox<String> mcbo1;
	
	private ObservableList<String> ListMasse=FXCollections.observableArrayList("Kilogramme","Gramme","Tonne","Milligram","livres","Once","Microgramme");
    private double []masse= {1.0, 1000, 0.001, 1000000, 2.20462, 35.274, 1000000000};

	private double msetTaux(ComboBox am, double tblm [])
	{
		return tblm[am.getSelectionModel().getSelectedIndex()];
	}
	@FXML
	private void mconvert1()
	{
		convertir(mcbo1,mcbo2,mtxt1,mtxt2,masse);
	}
	
	@FXML
	private void mconvert2()
	{
		convertir(mcbo2,mcbo1,mtxt2,mtxt1,masse);
	}
	private void mconvertir(ComboBox am,ComboBox bm, TextField cm,TextField dm, double tblm[])  
	{
		double from=setTaux(am,tblm);
		double to=setTaux(bm,tblm);
		double depart=0.0;
		/*if(c.getText().equals(""))
			depart=0.0;
		else
			depaart=Double.parseDouble(c.getText()); */
		depart=cm.getText().equals("")?0.0:Double.parseDouble(cm.getText());
		double dest=(to/from)*depart;
		dm.setText(String.valueOf(dest));
	}
	
	@FXML
	private ComboBox<String> mcbo2;
	
	@FXML
	private TextField mtxt1;
	
	@FXML
    private TextField mtxt2;
   //==========================================================================================================================================
    
    @FXML
    public Button btnLongeur;
    
    @FXML
	private ComboBox<String> lcbo1;
	
	private ObservableList<String> ListLongeur=FXCollections.observableArrayList("Metre","Centimetre","Milimetre","Kilometre","Pied","Milles","Nanometre");
    private double []longeur= {1.0, 100, 1000, 0.001, 3.28084, 0.000621371, 1000000000};

	private double lsetTaux(ComboBox al, double tbll [])
	{
		return tbll[al.getSelectionModel().getSelectedIndex()];
	}
	@FXML
	private void lconvert1()
	{
		convertir(lcbo1,lcbo2,ltxt1,ltxt2,masse);
	}
	
	@FXML
	private void lconvert2()
	{
		convertir(lcbo2,lcbo1,ltxt2,ltxt1,masse);
	}
	private void lconvertir(ComboBox al,ComboBox bl, TextField cl,TextField dl, double tbll[])  
	{
		double from=setTaux(al,tbll);
		double to=setTaux(bl,tbll);
		double depart=0.0;
		/*if(c.getText().equals(""))
			depart=0.0;
		else
			depaart=Double.parseDouble(c.getText()); */
		depart=cl.getText().equals("")?0.0:Double.parseDouble(cl.getText());
		double dest=(to/from)*depart;
		dl.setText(String.valueOf(dest));
	}
	
	@FXML
	private ComboBox<String> lcbo2;
	
	@FXML
	private TextField ltxt1;
	
	@FXML
    private TextField ltxt2;
    
    //==============================================================================================================================================
    @FXML
    void changer(ActionEvent e)
    {
    	Button b=(Button)e.getSource();
    	String a=b.getText();
    	
    	switch (a)
    	{
    	case "Volume":
    		monPane.getSelectionModel().select(1);
    		break;
    	case "Masse":
    		monPane.getSelectionModel().select(2);
    		break;
    	case "Longeur":
    		monPane.getSelectionModel().select(3);
    		break;
    	}
    }
    
    @FXML
    void home(ActionEvent e)
    {
    	Button c=(Button)e.getSource();
    	String d=c.getText();
    	
    	switch (d)
    	{
    	case "Acceuil":
    		monPane.getSelectionModel().select(0);
    	break;
    }
    }
    
    @FXML
    void quitter()
    {
    	Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("SORIE");
    	alert.setContentText("Voulez vousfremer l'application ?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK)
    		System.exit(0);
    }
    
    @FXML
    public void verifNum(KeyEvent e)
    {
    TextField txt=(TextField)e.getSource();

    txt.textProperty().addListener((observable,oldValue,newValue)->

    {
    if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
    {
    txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
    }

    });
    }
   
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) 
		{
		vcbo1.setItems(ListVolume);
		vcbo2.setItems(ListVolume);
		vcbo1.getSelectionModel().selectFirst();
		vcbo2.getSelectionModel().selectFirst();
		
		vcbo1.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		vcbo2.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		
		mcbo1.setItems(ListMasse);
		mcbo2.setItems(ListMasse);
		mcbo1.getSelectionModel().selectFirst();
		mcbo2.getSelectionModel().selectFirst();
		
		mcbo1.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		mcbo2.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		
		lcbo1.setItems(ListMasse);
		lcbo2.setItems(ListMasse);
		lcbo1.getSelectionModel().selectFirst();
		lcbo2.getSelectionModel().selectFirst();
		
		lcbo1.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		lcbo2.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		
		btnVolume.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		btnMasse.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		btnLongeur.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		btnQuitter.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		
		btnHomeV.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		btnHomeM.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		btnHomeL.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		
		btnQuitterV.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		btnQuitterM.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		btnQuitterL.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #FFFFFF;");
		}

}

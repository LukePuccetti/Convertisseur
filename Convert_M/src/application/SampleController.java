package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable {

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt1;

    @FXML
    private Button btn1;

    @FXML
    private ComboBox<String> cbo2;

    @FXML
    private ComboBox<String> cbo1;
    
    private ObservableList<String> ListMonnaie=FXCollections.observableArrayList("CAN","EU","USD","GBP","AUD");
    private double []monnaie= {1.0, 0.70, 0.78, 0.58, 1.09};
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
	cbo1.setItems(ListMonnaie);
	cbo2.setItems(ListMonnaie);
	cbo1.getSelectionModel().selectFirst();
	cbo2.getSelectionModel().selectFirst();
	
	}

	private double setTaux(ComboBox a, double tbl [])
	{
		return tbl[a.getSelectionModel().getSelectedIndex()];
	}
	
	@FXML
	private void convert1()
	{
		convertir(cbo1,cbo2,txt1,txt2,monnaie);
	}
	
	@FXML
	private void convert2()
	{
		convertir(cbo2,cbo1,txt2,txt1,monnaie);
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
    
   
    
    
    
}

package snakegame.viewers;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class TextJPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7687886054921145470L;

	//Create txtField
	public JTextField txtField = new JTextField(5);
	
	//Create Lbl
	public JLabel fieldLbl = new JLabel();
	
	public TextJPanel() {
		
		this.setLayout(new FlowLayout());
		this.add(fieldLbl);
		this.add(txtField);
		
	}
	
	public void setLblName(String lblName){
		fieldLbl.setText(lblName);
	}
	
	public int getTxt(){
		return Integer.parseInt(txtField.getText());
	}
	
	public void setTxt(int n){
		String txt = Integer.toString(n);
		txtField.setText(txt);
	}
}

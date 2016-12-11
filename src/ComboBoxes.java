
/*
 * Program created by Marcus Lynn. May only be used for learning purposes only. 
 * Any use of this program for academic purposes is cheating and not permitted. Programmed on 12/10/16
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class ComboBoxes{
	
	String[] cars = {"Ford", "Chevy", "Honda"};
	String tempOut = "";
	Integer inputPrice;
	JFrame frame = new JFrame();
	boolean isFound = false;
	Map <String, Integer> fordCars = new HashMap();
	Map <String, Integer> chevyCars = new HashMap();
	Map <String, Integer> hondaCars = new HashMap();
	Map <String, String> carPath = new HashMap();
	ArrayList carDisplay = new ArrayList();
	
	JComboBox cBox = new JComboBox(cars);
	JComboBox cDisplay = new JComboBox(carDisplay.toArray());
	JButton runButton = new JButton("Find");
	JLabel label = new JLabel("<html>" + "Please select a make and input a price please, then select a car to view below" + "</html>");
	JLabel picture = new JLabel();
	JTextField inputNum = new JTextField(15);
	
	
	public ComboBoxes(){
		createFrame();
		setFrame();
		fillMap();
	}
	
	public void fillMap(){
		fordCars.put("F150", 26540);
		fordCars.put("Focus", 16775);
		fordCars.put("Fusion", 22120);
		fordCars.put("Mustang", 24915);
		fordCars.put("Taurus", 27345);
		fordCars.put("Fiesta", 13660);
		
		chevyCars.put("Spark", 13000);
		chevyCars.put("Sonic", 15145);
		chevyCars.put("Cruze", 16975);
		chevyCars.put("Malibu", 21680);
		chevyCars.put("Impala", 27300);
		
		hondaCars.put("Civic", 18740);
		hondaCars.put("Accord", 22355);
		hondaCars.put("CR-Z", 20295);
		hondaCars.put("Pilot", 30595);
		hondaCars.put("Odyssey", 29550);
		
		carPath.put("F150", "F150.png");
		carPath.put("Focus", "focus.png");
		carPath.put("Fusion", "fusion.png");
		carPath.put("Mustang", "mustang.png");
		carPath.put("Taurus", "taurus.png");
		carPath.put("Fiesta", "fiesta.png");
		
		carPath.put("Spark", "spark.png");
		carPath.put("Sonic", "sonic.png");
		carPath.put("Cruze", "cruze.png");
		carPath.put("Malibu", "malibu.png");
		carPath.put("Impala", "impala.png");
		
		carPath.put("Civic", "civic.png");
		carPath.put("Accord", "accord.png");
		carPath.put("CR-Z", "cr-z.png");
		carPath.put("Pilot", "pilot.png");
		carPath.put("Odyssey", "odyssey.png");
	}
	
	public void createFrame(){
		frame.setVisible(true);
		frame.setSize(1920,1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setFrame(){
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		cBox.setLocation(50,50);
		cBox.setSize(100,50);
		panel.add(cBox);
		
		runButton.setLocation(50, 300);
		runButton.setSize(100,50);
		panel.add(runButton);
		
		label.setLocation(175, 25);
		label.setSize(300,100);
		panel.add(label);
		
		picture.setLocation(300,50);
		picture.setSize(700,700);
		panel.add(picture);
		
		inputNum.setLocation(50,125);
		inputNum.setSize(100,25);
		panel.add(inputNum);
		
		frame.add(panel);
		frame.validate();
		
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(isFound == false){
					String selected = cBox.getSelectedItem().toString();
					inputPrice = Integer.parseInt(inputNum.getText());
					if(selected=="Ford"){
						for(String key:fordCars.keySet()){
							if(fordCars.get(key)<=inputPrice){
								carDisplay.add(key);
								tempOut += (key + " $" +fordCars.get(key) + "<br>");
								label.setText("<html>" + tempOut + "<html>");
							}
						}
						tempOut = "";
					}
					else if(selected=="Chevy"){
						for(String key:chevyCars.keySet()){
							if(chevyCars.get(key)<=inputPrice){
								carDisplay.add(key);
								tempOut += (key + " $" +chevyCars.get(key) + "<br>");
								label.setText("<html>" + tempOut + "<html>");
							}
						}
						tempOut = "";
					}
					else if(selected=="Honda"){
						for(String key:hondaCars.keySet()){
							if(hondaCars.get(key)<=inputPrice){
								carDisplay.add(key);
								tempOut += (key + " $" +hondaCars.get(key) + "<br>");
								label.setText("<html>" + tempOut + "<html>");
							}
						}
						tempOut = "";
					}
					
					DefaultComboBoxModel model = (DefaultComboBoxModel) cBox.getModel();
			        model.removeAllElements();
			        for (Object item : carDisplay) {
			            model.addElement(item);
			        }
			        
			        cBox.setModel(model);
					isFound = true;
					
				}
				
				else if(isFound == true){
					String selected = cBox.getSelectedItem().toString();
					picture.setIcon(new ImageIcon(carPath.get(selected)));
				}
			 }
			});
	}
	
	public static void main(String[]args){
		
		ComboBoxes test = new ComboBoxes();
		
	}
	/*
	 * Program created by Marcus Lynn. May only be used for learning purposes only. 
	 * Any use of this program for academic purposes is cheating and not permitted. Programmed on 12/10/16
	 */
}
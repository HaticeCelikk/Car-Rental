

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Contract extends JFrame {

	private JPanel contentPane;
	public Contract() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setBounds(10, 23, 96, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblOccupiedCar = new JLabel("Rent Duration");
		lblOccupiedCar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblOccupiedCar.setForeground(new Color(178, 34, 34));
		lblOccupiedCar.setBounds(1046, 23, 84, 13);
		contentPane.add(lblOccupiedCar);
		
		JLabel lblRentOrSale = new JLabel("Rent or Sale");
		lblRentOrSale.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRentOrSale.setForeground(new Color(178, 34, 34));
		lblRentOrSale.setBounds(387, 23, 84, 13);
		contentPane.add(lblRentOrSale);
		
		JLabel lblOwnedCar = new JLabel("Owned Car Info");
		lblOwnedCar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblOwnedCar.setForeground(new Color(178, 34, 34));
		lblOwnedCar.setBounds(766, 23, 96, 13);
		contentPane.add(lblOwnedCar);
		int i = 0;
		try { //creating panels and adding infos in it while txt's line isnt null
			File myObj = new File("contrat.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] mainsplit = line.split("#");
				i++;
				JPanel panel = new JPanel();
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBounds(10, 5 + 44*i, 1120, 31);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblCustomerInfo = new JLabel(mainsplit[0]); //customer info
				lblCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 9));
				lblCustomerInfo.setBounds(10, 10, 362, 13);
				panel.add(lblCustomerInfo);
				
				JLabel lblRentOrSale_2 = new JLabel(mainsplit[3]); //it shows rent or sale
				lblRentOrSale_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
				lblRentOrSale_2.setBounds(382, 10, 84, 13);
				panel.add(lblRentOrSale_2);
				
				JLabel lblOwnedCarInfo = new JLabel(mainsplit[1]); //car info
				lblOwnedCarInfo.setFont(new Font("Tahoma", Font.PLAIN, 9));
				lblOwnedCarInfo.setBounds(591, 10, 397, 13);
				panel.add(lblOwnedCarInfo);
				
				JLabel lblRentDuration = new JLabel(mainsplit[2]); //how many days
				lblRentDuration.setFont(new Font("Tahoma", Font.PLAIN, 9));
				lblRentDuration.setBounds(1036, 10, 84, 13);
				panel.add(lblRentDuration);
				

			}
			myReader.close();
		} catch (FileNotFoundException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		

	}
}

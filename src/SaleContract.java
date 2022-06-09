
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SaleContract extends JFrame {

	private JPanel contentPane;

	public SaleContract(final CarForSale temp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(100, 100, 1043, 704);
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		// Set the new frame location

		setLocation(x, y);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(temp.getBrand());
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 38));
		lblNewLabel.setBounds(407, 10, 301, 72);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Model: " + temp.getModel());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(726, 143, 198, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Engine Type: " + temp.getEngineType());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(726, 187, 245, 40);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Km: " + temp.getKm());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(726, 231, 231, 44);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Year: " + temp.getYear());
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(726, 275, 231, 37);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Color: " + temp.getColor());
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(726, 319, 231, 33);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_10 = new JLabel("Second Hand: " + String.valueOf(temp.isUsed()));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(726, 363, 198, 40);
		contentPane.add(lblNewLabel_10);

		int sale = (temp.getPrice() + 5000);
		JLabel lblNewLabel_6 = new JLabel(String.valueOf(sale));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setBounds(726, 407, 231, 37);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("\u2014\u2014\u2014\u2014");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setBounds(726, 407, 231, 37);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel(String.valueOf(temp.getPrice()));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(726, 451, 165, 44);
		contentPane.add(lblNewLabel_9);

		ImageIcon image_2 = new ImageIcon(temp.getImage());
		ImageIcon imageIcon_2 = new ImageIcon(image_2.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH));

		JLabel lblNewLabel_7 = new JLabel(imageIcon_2);
		lblNewLabel_7.setBounds(67, 102, 641, 444);

		contentPane.add(lblNewLabel_7);

		JButton btnNewButton = new JButton("BUY NOW");// checks customer's budget if it not enough gives an error
														// message and if it is enough sale operation is happened
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (int i = 0; i < Login.company.getCarsForSale().size(); i++) {
						if (temp.getId() == Login.company.getCarsForSale().get(i).getId()) {
							if (Login.customer.getBudget() - temp.getPrice() >= 0) {
								Login.company.getCarsForSale().remove(i);
								Login.customer.setBudget(Login.customer.getBudget() - temp.getPrice());
								JOptionPane.showMessageDialog(contentPane, "Successfully saled");

								FileWriter fileWritter = new FileWriter("contrat.txt", true);
								BufferedWriter bw = new BufferedWriter(fileWritter);

								bw.append("\n" + Login.customer + "#" + Login.company.getCarsForSale().get(i) + "#"
										+ "-" + "#" + "SALE");

								bw.close();
							} else {
								JOptionPane.showMessageDialog(contentPane, "Insufficient balance");
								break;
							}

						}
					}

					FileWriter fileWritter = new FileWriter("carsforsale.txt"); // re-writing operations after buy phase

					for (int j = 0; j < Login.company.getCarsForSale().size(); j++) {
						String temp = Login.company.getCarsForSale().get(j).toString();
						fileWritter.write(temp + "\n");
					}
					fileWritter.close();
				} catch (IOException x) {
					x.printStackTrace();
				}

				try {

					FileWriter fWriter = new FileWriter("customers.txt");// re-writing operations for customer's budget
																			// after buy phase
					for (int j = 0; j < Login.company.getCustomerCount(); j++) {
						String temp = Login.company.getCustomer(j).toString();
						fWriter.write(temp + "\n");
					}

					fWriter.close();

				}

				catch (IOException a) {

					System.out.print(a.getMessage());
				}

			}
		});
		btnNewButton.setBounds(726, 525, 239, 55);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// one page back if the customer wants
				SaleScreen screen = new SaleScreen(0);
				screen.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(23, 10, 66, 26);
		btnNewButton_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("back.png")).getImage()
				.getScaledInstance(70, 21, Image.SCALE_SMOOTH)));

		contentPane.add(btnNewButton_1);

	}
}
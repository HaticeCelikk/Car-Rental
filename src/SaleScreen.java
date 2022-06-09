
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;

import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaleScreen extends JFrame {

	public SaleScreen(int start) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(100, 100, 969, 730);
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		// Set the new frame location

		setLocation(x, y);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// one page back if the customer wants it(sale screen to choice
													// screen)
				ChoiceScreen c = new ChoiceScreen();
				c.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 19, 40, 21);
		btnNewButton_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("back.png")).getImage()
				.getScaledInstance(70, 21, Image.SCALE_SMOOTH)));

		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_6 = new JLabel("Welcome " + Login.customer.getName() + " " + Login.customer.getSurname());
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(72, 12, 282, 28);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Current Budget: " + Login.customer.getBudget());
		lblNewLabel_7.setForeground(new Color(220, 20, 60));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(342, 5, 182, 21);
		getContentPane().add(lblNewLabel_7);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Click to change budget");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int newBudget = Login.customer.getBudget();
				String str = JOptionPane.showInputDialog(getContentPane(), "Please enter your new budget: ");
				if (str != null) {
					newBudget = Integer.valueOf(str);

				}

				Login.customer.setBudget(newBudget);
				SaleScreen r = new SaleScreen(0);
				r.setVisible(true);
				setVisible(false);

			}
		});
		rdbtnNewRadioButton.setBounds(338, 29, 158, 21);
		getContentPane().add(rdbtnNewRadioButton);

		int pages = (Login.company.getCarsForSale().size() / 6);
		if ((Login.company.getCarsForSale().size() / 6) % 6 != 0) {
			pages++;
		}

		String str[] = new String[pages];
		for (int i = 0; i < str.length; i++) {
			str[i] = String.valueOf(i + 1);
		}

		JComboBox comboBox = new JComboBox(str);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int page = 6 * (Integer.valueOf((String) comboBox.getSelectedItem()) - 1);
				SaleScreen r = new SaleScreen(page);
				r.setVisible(true);
				setVisible(false);
			}

		});

		comboBox.setBounds(878, 11, 40, 21);
		getContentPane().add(comboBox);

		JLabel lblNewLabel_8 = new JLabel("Page");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(842, 11, 40, 21);
		getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("SALE");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_9.setBounds(635, -6, 140, 61);
		getContentPane().add(lblNewLabel_9);

		writingSale(start);

	}

	public void writingSale(int startCar) {// function that allows to show at most 6 cars at one page

		int x = 0;
		int y = 35;
		int size = 6;
		if (startCar + 6 > Login.company.getCarsForSale().size()) {
			size = Login.company.getCarsForSale().size() - startCar;
		}
		for (int i = startCar; i < startCar + size; i++) {
			if (i != startCar && i % 3 == 0) {
				y += 310;
				x = 0;
			}
			final JPanel panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(10 + 310 * x, 20 + y, 300, 307);
			getContentPane().add(panel);
			panel.setLayout(null);
			panel.setName(String.valueOf(Login.company.getCarsForSale().get(i).getId()));

			JLabel lblNewLabel = new JLabel("- - - - " + Login.company.getCarsForSale().get(i).getBrand() + " "
					+ Login.company.getCarsForSale().get(i).getModel() + " - - - -");
			lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 17));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.ORANGE);
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setBounds(10, 10, 280, 23);
			panel.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel(
					"Color            :            " + Login.company.getCarsForSale().get(i).getColor());
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(43, 170, 247, 13);
			panel.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel(
					"Engine         :            " + Login.company.getCarsForSale().get(i).getEngineSize() + "    /   "
							+ Login.company.getCarsForSale().get(i).getEngineType());
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(43, 193, 247, 13);
			panel.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel(
					"Km                :            " + Login.company.getCarsForSale().get(i).getKm());
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(43, 216, 247, 13);
			panel.add(lblNewLabel_3);
			ImageIcon image_2 = new ImageIcon(Login.company.getCarsForSale().get(i).getImage());
			ImageIcon imageIcon_2 = new ImageIcon(image_2.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH));
			JLabel lblNewLabel_4 = new JLabel(imageIcon_2);
			lblNewLabel_4.setBounds(61, 20, 190, 150);
			panel.add(lblNewLabel_4);

			JLabel lblNewLabel_1_1 = new JLabel(Login.company.getCarsForSale().get(i).getPrice() + " TRY");
			lblNewLabel_1_1.setDoubleBuffered(true);
			lblNewLabel_1_1.setFont(new Font("Impact", Font.PLAIN, 17));
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(Color.ORANGE);
			lblNewLabel_1_1.setBounds(43, 249, 200, 23);
			panel.add(lblNewLabel_1_1);

			JButton btnNewButton = new JButton("B U Y");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int i = 0; i < Login.company.getCarsForSale().size(); i++) {
						String tempCar = Integer.toString(Login.company.getCarsForSale().get(i).getId());
						if (panel.getName().equalsIgnoreCase(tempCar)) {
							SaleContract page = new SaleContract(Login.company.getCarsForSale().get(i));

							page.setVisible(true);
							setVisible(false);
						}
					}

				}
			});
			btnNewButton.setForeground(new Color(255, 248, 220));
			btnNewButton.setBackground(Color.ORANGE);
			btnNewButton.setFont(new Font("Impact", Font.PLAIN, 17));
			btnNewButton.setBounds(61, 272, 166, 28);
			panel.add(btnNewButton);

			JLabel lblNewLabel_5 = new JLabel("--------------- Properties ---------------");
			lblNewLabel_5.setForeground(Color.ORANGE);
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(43, 147, 208, 13);
			panel.add(lblNewLabel_5);
			x++;

		}

	}
}
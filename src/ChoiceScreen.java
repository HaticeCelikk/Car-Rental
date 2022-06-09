
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChoiceScreen extends JFrame { // customer chooses whether he/she wants to rent a car or buy a car

	private JPanel contentPane;

	public ChoiceScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setBounds(100, 100, 352, 174);
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		// Set the new frame location

		setLocation(x, y);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Car To Rent");
		btnNewButton.addMouseListener(new MouseAdapter() { // if this button clicked program opens rent screen
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectDay page = new SelectDay();
				page.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(80, 48, 168, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Car To Buy");// if this button clicked program opens sale screen

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SaleScreen page = new SaleScreen(0);
				page.setVisible(true);
				setVisible(false);

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(80, 85, 168, 27);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("What Are You Looking For?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(93, 17, 168, 21);
		contentPane.add(lblNewLabel);
	}
}
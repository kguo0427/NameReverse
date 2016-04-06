import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class mainWindow {

	private JFrame frmNameReverse;
	private JTextField inputRoute;
	private JTextField outputName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frmNameReverse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNameReverse = new JFrame();
		frmNameReverse.setTitle("Name Reverse");
		frmNameReverse.setBounds(100, 100, 450, 300);
		frmNameReverse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNameReverse.getContentPane().setLayout(null);
		
		inputRoute = new JTextField();
		inputRoute.setBounds(115, 76, 309, 20);
		frmNameReverse.getContentPane().add(inputRoute);
		inputRoute.setColumns(10);
		
		JLabel lblInputRoute = new JLabel("input route");
		lblInputRoute.setBounds(10, 79, 67, 14);
		frmNameReverse.getContentPane().add(lblInputRoute);
		
		outputName = new JTextField();
		outputName.setBounds(115, 110, 155, 20);
		frmNameReverse.getContentPane().add(outputName);
		outputName.setColumns(10);
		
		JLabel lblOutputFileName = new JLabel("output file name");
		lblOutputFileName.setBounds(10, 113, 100, 14);
		frmNameReverse.getContentPane().add(lblOutputFileName);
		
		frmNameReverse.getContentPane().add(convertButton());
	}
	
	//convert the names.
	public JButton convertButton() {
		JButton convertButton = new JButton("Convert!");
		convertButton.setBounds(115, 155, 155, 59);
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					@SuppressWarnings("resource")
					BufferedReader br = new BufferedReader(new FileReader(inputRoute.getText()));
					String line = "";
					String outputFilename = outputName.getText() + ".txt";
					PrintWriter writer = new PrintWriter(outputFilename, "UTF-8");
					while((line = br.readLine()) != null) {
						String[] name = line.split(",");
						writer.println(name[1].trim() + " " + name[0]);
					}
					JOptionPane.showMessageDialog(null, "Success.");
					writer.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Failed.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Failed.");
				}
			}
		});
		return convertButton;
	}
}

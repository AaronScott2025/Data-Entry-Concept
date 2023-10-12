package pkgjobs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Jobgui {

	private JFrame frame;
	private JTextField namebox;
	private JTextField deptbox;
	private JTextField positionbox;
	private JTextField salarybox;
	private JTextField genderbox;
	private JLabel dept;
	private JLabel position;
	private JLabel salary;
	private JLabel gender;
	private JLabel name_error;
	private JLabel dept_error;
	private JLabel position_error;
	private JLabel salary_error;
	private JLabel gender_error;
	JTextArea dataentries = new JTextArea();
	private JTextArea returned;
	private JTextField key;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jobgui window = new Jobgui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Jobgui() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Data Entry");
		
		frame.getContentPane().setBackground(new Color(255, 222, 173));
		frame.setBounds(100, 100, 1200, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 984, 1);
		frame.getContentPane().add(desktopPane);
		
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("Logo.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setBounds(900, 22, 274, 259);
            frame.getContentPane().add(picLabel);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
		
		namebox = new JTextField();
		namebox.setBounds(320, 113, 339, 46);
		frame.getContentPane().add(namebox);
		namebox.setColumns(10);
		namebox.setText(null);
		
		deptbox = new JTextField();
		deptbox.setColumns(10);
		deptbox.setBounds(320, 213, 339, 46);
		frame.getContentPane().add(deptbox);
		deptbox.setText(null);
		
		positionbox = new JTextField();
		positionbox.setColumns(10);
		positionbox.setBounds(320, 314, 339, 46);
		frame.getContentPane().add(positionbox);
		positionbox.setText(null);
		
		salarybox = new JTextField();
		salarybox.setColumns(10);
		salarybox.setBounds(320, 412, 339, 46);
		frame.getContentPane().add(salarybox);
		salarybox.setText(null);
		
		genderbox = new JTextField();
		genderbox.setColumns(10);
		genderbox.setBounds(320, 510, 339, 46);
		frame.getContentPane().add(genderbox);
		genderbox.setText(null);
		
		JLabel name = new JLabel("Name");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(320, 83, 339, 30);
		frame.getContentPane().add(name);
		
		JLabel dept = new JLabel("Department");
		dept.setHorizontalAlignment(SwingConstants.CENTER);
		dept.setBounds(320, 183, 339, 30);
		frame.getContentPane().add(dept);
		
		JLabel position = new JLabel("Position");
		position.setHorizontalAlignment(SwingConstants.CENTER);
		position.setBounds(320, 284, 339, 30);
		frame.getContentPane().add(position);
		
		JLabel salary = new JLabel("Salary");
		salary.setHorizontalAlignment(SwingConstants.CENTER);
		salary.setBounds(320, 385, 339, 30);
		frame.getContentPane().add(salary);
		
		JLabel gender = new JLabel("Gender");
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		gender.setBounds(320, 480, 339, 30);
		frame.getContentPane().add(gender);
		
		returned = new JTextArea();
		returned.setWrapStyleWord(true);
		returned.setLineWrap(true);
		returned.setEditable(false);
		returned.setBounds(900, 315, 274, 184);
		frame.getContentPane().add(returned);
		
		key = new JTextField();
		key.setColumns(10);
		key.setBounds(900, 521, 274, 46);
		frame.getContentPane().add(key);
		
		
		/**
		 * ERROR MESSAGES (to be toggled)
		 */
		
		name_error = new JLabel("**Must complete field");
		
		dept_error = new JLabel("**Must complete field");

		position_error = new JLabel("**Must complete field");

		salary_error = new JLabel("**Must complete field");
		
		gender_error = new JLabel("**Must complete field");
		
		JButton btnNewButton = new JButton("Submit New Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					submitbutton();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(379, 578, 170, 46);
		frame.getContentPane().add(btnNewButton);
		dataentries.setEditable(false);
		

		dataentries.setWrapStyleWord(true);
		dataentries.setLineWrap(true);
		dataentries.setBounds(10, 12, 274, 639);
		frame.getContentPane().add(dataentries);
		
		JButton Scan = new JButton("Scan Database");
		Scan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					scanlist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Scan.setBounds(962, 578, 160, 46);
		frame.getContentPane().add(Scan);
		

	}
	public void submitbutton() throws IOException {
		name_error.setVisible(false);
		dept_error.setVisible(false);
		position_error.setVisible(false);
		salary_error.setVisible(false);
		gender_error.setVisible(false);
		String a = namebox.getText();
		String b = deptbox.getText();
		String c = positionbox.getText();
		String d = salarybox.getText();
		String e = genderbox.getText();
		frame.revalidate();
		frame.repaint();
		if(a.length() == 0 || b.length() == 0 || c.length() == 0 || d.length() == 0 || e.length() == 0) {
			dataentries.append("\nPlease fill out all lines before continuing");
			if(a.length() == 0) {
				name_error.setForeground(new Color(255, 0, 0));
				name_error.setBounds(650, 130, 147, 14);
				frame.getContentPane().add(name_error);
				name_error.setVisible(true);
				
			}
			if(b.length() == 0) {
				dept_error.setForeground(Color.RED);
				dept_error.setBounds(650, 227, 147, 14);
				frame.getContentPane().add(dept_error);
				dept_error.setVisible(true);
				
			}
			if(c.length() == 0) {
				position_error.setForeground(Color.RED);
				position_error.setBounds(650, 327, 147, 14);
				frame.getContentPane().add(position_error);
				position_error.setVisible(true);
				
			}
			if(d.length() == 0) {
				salary_error.setForeground(Color.RED);
				salary_error.setBounds(650, 429, 147, 14);
				frame.getContentPane().add(salary_error);
				salary_error.setVisible(true);
			}
			if(e.length() == 0) {
				gender_error.setForeground(Color.RED);
				gender_error.setBounds(650, 527, 147, 14);
				frame.getContentPane().add(gender_error);
				gender_error.setVisible(true);
			}
			
		} else {
			Data data = new Data(a, b, c, d, e);
			Ids generate = new Ids();
			String x = generate.id(data);
			dataentries.append("\n" + a + " Successfully entered into the database!" + "\nId: " + x);
				
			
			namebox.setText("");
			deptbox.setText("");
			positionbox.setText("");
			salarybox.setText("");
			genderbox.setText("");
			
		}
		frame.revalidate();
		frame.repaint();
		
			
	}
	public void scanlist() throws IOException {
		String id;
		id = key.getText();
		Datfile dat = new Datfile();
		id = dat.finder(id);
		returned.append(id + "\n");
	}
}


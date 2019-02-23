import javax.swing.*;	// Needed for Swing classes
import java.awt.*;
import java.awt.event.*; // Needed for ActionListener Interface
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.EtchedBorder;


public class AccountGui extends JFrame {

	private static final long serialVersionUID = 1L;

	//declare Panels
	private JPanel panel;
	private JPanel Create;
	private JPanel Reset;
	private JPanel choose;
	private JPanel Exit;
	private JPanel CreateBoth;
	private JPanel CreateLeft;
	private JPanel CreateRight;
	private JPanel ResetBoth;
	private JPanel ResetLeft;
	private JPanel ResetRight;
	private JPanel panel_1;
	private JPanel panel_2;

	//declare buttons
	private JButton createUser;
	private JButton ResetUser;
	private JButton exitButton;

	//declare window size
	private static final int WINDOW_WIDTH = 750;
	private static final int WINDOW_HEIGHT = 500;

	//declare JLabel
	private JLabel firstName;
	private JLabel lastName;
	private JLabel studentID;
	private JLabel graduateYear;
	private JLabel Staff;
	private JLabel userName;
	private JLabel password;

	private JLabel RuserName;
	private JLabel RfirstName;
	private JLabel RLastName;
	private JLabel RnewPassword;
	private JLabel RconfirmNewPassword;
	private JLabel blank1;

	//declare JTextField
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField studentIDTF;
	private JTextField userNameTF;
	private JTextField passwordTF;

	private JTextField RuserNameTF;
	private JTextField RfirstNameTF;
	private JTextField RLastNameTF;
	private JTextField RNewPasswordTF;
	private JTextField RConfirmPasswordTF;

	//declare JComboBox
	private JComboBox graduateYearCB;	
	private JComboBox StaffCB;
	
	//declare radio buttons
	private JRadioButton Staff_1;
	private JRadioButton Student;

	//declare button group
	private final ButtonGroup buttonGroup = new ButtonGroup();

	String createdUserName;

	String[] graduateYears = { "", "2019", "2020", "2021",
			"2022", "2023", "2024" };

	String[] staffArea = { "", "Elementary Teacher",
			"Middle Teacher", "High Teacher", "Elementary Office", 
			"Middle Office", "High Office", "Maitence/Custodian",
			"Bus Garage", "Cafeteria", "Board Office" };


	/**
		Constructor
	*/

	public AccountGui() {

		// Set the Custom image
		setIconImage(new ImageIcon("logo.png").getImage());

		// Set the window title.
		setTitle("Account GUI");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel and add it to the frame.
		buildPanel();

		// Add the panel to the frame's content pane.
		getContentPane().add(panel);

		// Display the window.
		setVisible(true);
	
	}


	/**
		The buildPanel method adds a label, text field, and
		and a button to a panel.
	*/

	@SuppressWarnings("unchecked")
	private void buildPanel() {
		createdUserName = "";
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new exitButtonListener());
		exitButton.setMnemonic(KeyEvent.VK_E);
		exitButton.setToolTipText("Click here to Exit the Program");


		//Set Labels and textfields
		firstName = new JLabel("First Name");
		lastName = new JLabel("Last Name");
		studentID = new JLabel("Student ID");
		graduateYear = new JLabel("Graduate Year");
		Staff = new JLabel("Staff Location");
		userName = new JLabel("User Name");
		password = new JLabel("Password");

		RuserName = new JLabel("User Name");
		RfirstName = new JLabel("First Name");
		RLastName = new JLabel("Last Name");
		RnewPassword = new JLabel("New Password");
		RconfirmNewPassword = new JLabel("Confirm New Password");

		//declare JTextField
		firstNameTF = new JTextField();
		lastNameTF = new JTextField();
		studentIDTF = new JTextField();	
		userNameTF = new JTextField();
		passwordTF = new JTextField();

		RuserNameTF = new JTextField();
		RfirstNameTF = new JTextField();
		RLastNameTF = new JTextField();
		RNewPasswordTF = new JTextField();
		RConfirmPasswordTF = new JTextField();

		firstNameTF.addActionListener(new firstNameListener());
		lastNameTF.addActionListener(new lastNameListener());

		//declare JComboBoxes
		graduateYearCB = new JComboBox<String>(graduateYears);
		graduateYearCB.setEditable(true);
		StaffCB = new JComboBox<String>(staffArea);

		graduateYearCB.addActionListener(new graduateYearListener());
		StaffCB.addActionListener(new StaffListener());

		
		// Create JPanel objects and let the panel
		// fields reference it.
		panel = new JPanel();
		Create = new JPanel();
		Reset = new JPanel();
		Exit = new JPanel();
		CreateBoth = new JPanel();
		CreateLeft = new JPanel();
		CreateRight = new JPanel();
		ResetBoth = new JPanel();
		ResetLeft = new JPanel();
		ResetRight = new JPanel();

		//Set Layouts of the panels

		panel.setLayout(new GridLayout(2,1));
		Create.setLayout(new BorderLayout());
		CreateBoth.setLayout(new GridLayout(1,2));
		CreateLeft.setLayout(new GridLayout(7,1));
		CreateRight.setLayout(new GridLayout(7,1));
		Reset.setLayout(new BorderLayout());
		ResetBoth.setLayout(new GridLayout(1,2));
		ResetLeft.setLayout(new GridLayout(7,1));
		ResetRight.setLayout(new GridLayout(7,1));
		Exit.setLayout(new BorderLayout());

		//borders
		CreateBoth.setBorder(BorderFactory.createTitledBorder("Create "
				+ "Account"));
		ResetBoth.setBorder(BorderFactory.createTitledBorder("Reset "
				+ "Account"));

		//add components
		panel.add(Create);
		panel.add(Reset);
		Create.add(CreateBoth);
		CreateBoth.add(CreateLeft);
		CreateBoth.add(CreateRight);
		Reset.add(ResetBoth);
		ResetBoth.add(ResetLeft);
		ResetBoth.add(ResetRight);

		CreateLeft.add(firstName);
		CreateLeft.add(lastName);
		CreateLeft.add(studentID);
		CreateLeft.add(graduateYear);
		CreateLeft.add(Staff);
		CreateLeft.add(userName);
		CreateLeft.add(password);

		CreateRight.add(firstNameTF);
		CreateRight.add(lastNameTF);
		CreateRight.add(studentIDTF);
		CreateRight.add(graduateYearCB);
		CreateRight.add(StaffCB);
		CreateRight.add(userNameTF);
		CreateRight.add(passwordTF);

		ResetLeft.add(RuserName);
		ResetLeft.add(RfirstName);
		ResetLeft.add(RLastName);
		ResetLeft.add(RnewPassword);
		ResetLeft.add(RconfirmNewPassword);

		ResetRight.add(RuserNameTF);
		ResetRight.add(RfirstNameTF);
		ResetRight.add(RLastNameTF);
		ResetRight.add(RNewPasswordTF);
		ResetRight.add(RConfirmPasswordTF);
		
		choose = new JPanel();
		panel.add(choose);
				choose.setLayout(new BorderLayout(0, 0));
								
								panel_1 = new JPanel();
								choose.add(panel_1, BorderLayout.NORTH);
								panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
								
								Staff_1 = new JRadioButton("Staff");
								panel_1.add(Staff_1);
								
										buttonGroup.add(Staff_1);
										Staff_1.setSelected(true);
										
										Student = new JRadioButton("Student");
										panel_1.add(Student);
										buttonGroup.add(Student);
								
								panel_2 = new JPanel();
								choose.add(panel_2, BorderLayout.CENTER);
										panel_2.setLayout(new BorderLayout(0, 0));
								
										// Create my buttons.
										createUser = new JButton("Create User");
										panel_2.add(createUser, BorderLayout.NORTH);
										
												// Add an action listener to the button.
												createUser.addActionListener(new createUserListener());
												
														//set mnemonic and tooltip
														createUser.setMnemonic(KeyEvent.VK_C);
														createUser.setToolTipText("Click here to create the User");
		Exit.add(exitButton, BorderLayout.SOUTH);
		panel.add(Exit);
		ResetUser = new JButton("Reset Password");
		Exit.add(ResetUser, BorderLayout.NORTH);
		ResetUser.addActionListener(new ResetUserButtonListener());
		ResetUser.setMnemonic(KeyEvent.VK_R);
		ResetUser.setToolTipText("Click here to Reset the User Password");		

	}	


	/**
		CreateUserListener is an action listener class for
		the roll button.
	*/

	private class createUserListener implements ActionListener {

		/**
		The actionPerformed method executes when the user
		clicks on the create button.
		@param e The event object.
		*/

		public void actionPerformed(ActionEvent e) {
	
			Pattern p = Pattern.compile("[\\W]");
		    Matcher m = p.matcher(userNameTF.getText());
		    boolean b = m.find();
		    if (b == true) {
		        JOptionPane.showMessageDialog(null, "Error:  An invalid "
		        		+ "character was entered.  Please fix and try "
		        		+ "again.");
			} else {
				createdUserName = userName.getText();

				String org = ADOrg();
				boolean createGA = createGoogleAccount(userName.getText(),
					firstName.getText(), lastName.getText(), 
					password.getText(), org, false);

				if (!createGA) {
					JOptionPane.showMessageDialog(null, "Error:  Error creating Google Account ");
				} else {
				
					boolean createAD = createADAccount(userName.getText(), 
							firstName.getText(), lastName.getText(), 
							password.getText(), org, false);
					
					if (!createAD) {
						JOptionPane.showMessageDialog(null, "Error:  Error creating AD Account ");
					}
				
					
			}
		}

//			String s = null;
//			
//			String lname = lastNameTF.getText();
//			String fname = firstNameTF.getText();
//
//			panel.setBackground(Color.YELLOW);
//			
//			if (fname.length() == 0 || lname.length() == 0) {
//				System.out.println("error");
//				fname.replaceAll("g", "d");
//				
//				char fInitial = fname.charAt(0);
//				System.out.println(fInitial);
//				
//				String userName = fInitial + lname;
//
//			} else {
//				
//			}



//			try {
//					
//				// run the Unix "ps -ef" command
//				// using the Runtime exec method:
//				Process p1 = Runtime.getRuntime().exec("PowerShell -Command \"Add-Type -AssemblyName " 
//				+ "PresentationFramework;[System.Windows.MessageBox]::Show('Hello World')");
//				Process p = Runtime.getRuntime().exec("sndvol.exe -f\r\n");
//
//				
//				BufferedReader stdInput = new BufferedReader(new 
//						InputStreamReader(p.getInputStream()));
//
//				BufferedReader stdError = new BufferedReader(new 
//						InputStreamReader(p.getErrorStream()));
//
//				// read the output from the command
//				while ((s = stdInput.readLine()) != null) {
//					System.out.println(s);
//				}
//					
//				// read any errors from the attempted command
//				while ((s = stdError.readLine()) != null) {
//					System.out.println(s);
//				}
//				
//			} catch (IOException e1) {
//				System.out.println("exception happened - here's what I know: ");
//				e1.printStackTrace();
//			}



		}

		private boolean createGoogleAccount(String userName, 
				String firstName, String lastName, String password, 
				String org, boolean ChangePassword) {
			try {
				Runtime.getRuntime().exec("PowerShell -Command GoogleAccount.ps1 " + userName + " " + firstName + " " + lastName + " " + password + " " + org);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		private boolean createADAccount(String userName, String firstName, 
				String lastName, String password, String org,
				boolean ChangePassword) {

			try {
				Runtime.getRuntime().exec("PowerShell -Command ADAccount.ps1 " + userName + " " + firstName + " " + lastName + " " + password + " " + org + " " + ChangePassword);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	private class exitButtonListener implements ActionListener {

		/**
		The actionPerformed method executes when the user
		clicks on the exit button.
		@param e The event object.
		*/

		public void actionPerformed(ActionEvent e) {
			//Exit the program
			System.exit(0);
		}

	}


	private class ResetUserButtonListener implements ActionListener {

		/**
		The actionPerformed method executes when the user
		clicks on the exit button.
		@param e The event object.
		*/

		public void actionPerformed(ActionEvent e) {

		}

	}


	private class firstNameListener implements ActionListener {

		/**
		The actionPerformed method executes when the user
		clicks on the exit button.
		@param e The event object.
		*/

		public void actionPerformed(ActionEvent e) {

			try {
				createdUserName = (Character.toString(
						firstNameTF.getText().charAt(0)) + 
						lastNameTF.getText());
			} catch (Exception e1) {
				createdUserName = "";
			}

			userNameTF.setText(createdUserName);
		}

	}


	private class lastNameListener implements ActionListener {

		/**
		The actionPerformed method executes when the user
		clicks on the exit button.
		@param e The event object.
		*/

		public void actionPerformed(ActionEvent e) {

			try {
				createdUserName = (Character.toString(
						firstNameTF.getText().charAt(0)) + 
						lastNameTF.getText());
			} catch (Exception e1) {
				createdUserName = "";
			}

			userNameTF.setText(createdUserName);
		}

	}


	private class studentIDListener implements ActionListener {

		/**
		The actionPerformed method executes when the user
		clicks on the exit button.
		@param e The event object.
		*/

		public void actionPerformed(ActionEvent e) {

			try {
				createdUserName = (Character.toString(
						firstNameTF.getText().charAt(0)) + 
						lastNameTF.getText());
			} catch (Exception e1) {
				createdUserName = "";
			}

			userNameTF.setText(createdUserName);
		}

	}
	
	private class graduateYearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
        	if(graduateYearCB.getSelectedItem()!="0")
        		StaffCB.setSelectedIndex(0);
		}
	}
	
	private class StaffListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
        	if(StaffCB.getSelectedItem()!="0")
        		graduateYearCB.setSelectedIndex(0);
		}
	}

	public String ADOrg() {
		if (graduateYearCB.getSelectedItem()=="0") {
			String index = StaffCB.getSelectedItem().toString();
			if (index.equals( "Elementary Teacher")) {
				return "";
			} else if (index.equals( "Middle Teacher")) {
				return "";
			} else if (index.equals( "High Teacher")) {
				return "";
			} else if (index.equals( "Elementary Office")) {
				return "";
			} else if (index.equals( "Middle Office")) {
				return "";
			} else if (index.equals( "High Office")) {
				return "";
			} else if (index.equals( "Maitence/Custodian")) {
				return "";
			} else if (index.equals( "Bus Garage")) {
				return "";
			} else if (index.equals( "Cafeteria")) {
				return "";
			} else if (index.equals( "Board Office")) {
				return "";
			} else {
				JOptionPane.showMessageDialog(null, "If you see this "
						+ "something is screwed up");
				try {
					wait(100);
				} catch (InterruptedException e) {
				}
				System.exit(1);
			}

		} else if (StaffCB.getSelectedItem()!="0") {
			String index = graduateYearCB.getSelectedItem().toString();
			if (index.equals( "2019")) {
				return "";
			} else if (index.equals( "2020")) {
				return "";
			} else if (index.equals( "2021")) {
				return "";
			} else if (index.equals( "2022")) {
				return "";
			} else if (index.equals( "2023")) {
				return "";
			} else if (index.equals( "2024")) {
				return "";
			} else if (index.equals( "2025")) {
				return "";
			} else if (index.equals( "2026")) {
				return "";
			} else if (index.equals( "2027")) {
				return "";
			} else if (index.equals( "2028")) {
				return "";
			} else if (index.equals( "2029")) {
				return "";
			} else if (index.equals( "2030")) {
				return "";
			} else if (index.equals( "2031")) {
				return "";
			} else if (index.equals( "2032")) {
				return "";
			} else if (index.equals( "2033")) {
				return "";
			} else if (index.equals( "2034")) {
				return "";
			} else if (index.equals( "2035")) {
				return "";
			} else if (index.equals( "2036")) {
				return "";
			} else if (index.equals( "2037")) {
				return "";
			} else if (index.equals( "2038")) {
				return "";
			} else if (index.equals( "2039")) {
				return "";
			} else if (index.equals( "2040")) {
				return "";
			} else {
				JOptionPane.showMessageDialog(null, "If you see this "
						+ "something is screwed up");
				try {
					wait(100);
				} catch (InterruptedException e) {
				}
				System.exit(1);
			}

		}
		return "Error";
	}
	
	public String GoogleOrg() {
		if (graduateYearCB.getSelectedItem()=="0") {
			String index = StaffCB.getSelectedItem().toString();
			if (index.equals( "Elementary Teacher")) {
				return "";
			} else if (index.equals( "Middle Teacher")) {
				return "";
			} else if (index.equals( "High Teacher")) {
				return "";
			} else if (index.equals( "Elementary Office")) {
				return "";
			} else if (index.equals( "Middle Office")) {
				return "";
			} else if (index.equals( "High Office")) {
				return "";
			} else if (index.equals( "Maitence/Custodian")) {
				return "";
			} else if (index.equals( "Bus Garage")) {
				return "";
			} else if (index.equals( "Cafeteria")) {
				return "";
			} else if (index.equals( "Board Office")) {
				return "";
			} else {
				JOptionPane.showMessageDialog(null, "If you see this "
						+ "something is screwed up");
				try {
					wait(100);
				} catch (InterruptedException e) {
				}
				System.exit(1);
			}

		} else if (StaffCB.getSelectedItem()!="0") {
			String index = graduateYearCB.getSelectedItem().toString();
			if (index.equals( "2019")) {
				return "";
			} else if (index.equals( "2020")) {
				return "";
			} else if (index.equals( "2021")) {
				return "";
			} else if (index.equals( "2022")) {
				return "";
			} else if (index.equals( "2023")) {
				return "";
			} else if (index.equals( "2024")) {
				return "";
			} else if (index.equals( "2025")) {
				return "";
			} else if (index.equals( "2026")) {
				return "";
			} else if (index.equals( "2027")) {
				return "";
			} else if (index.equals( "2028")) {
				return "";
			} else if (index.equals( "2029")) {
				return "";
			} else if (index.equals( "2030")) {
				return "";
			} else if (index.equals( "2031")) {
				return "";
			} else if (index.equals( "2032")) {
				return "";
			} else if (index.equals( "2033")) {
				return "";
			} else if (index.equals( "2034")) {
				return "";
			} else if (index.equals( "2035")) {
				return "";
			} else if (index.equals( "2036")) {
				return "";
			} else if (index.equals( "2037")) {
				return "";
			} else if (index.equals( "2038")) {
				return "";
			} else if (index.equals( "2039")) {
				return "";
			} else if (index.equals( "2040")) {
				return "";
			} else {
				JOptionPane.showMessageDialog(null, "If you see this "
						+ "something is screwed up");
				try {
					wait(100);
				} catch (InterruptedException e) {
				}
				System.exit(1);
			}

		}
		return "Error";
	}
	
	/**
		main method
	*/

	public static void main(String[] args) {
		new AccountGui();
	}


}

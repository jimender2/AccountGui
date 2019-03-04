import javax.swing.*;	// Needed for Swing classes
import java.awt.*;
import java.awt.event.*; // Needed for ActionListener Interface
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.EtchedBorder;

public class AccountGUI extends JFrame {

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
	
	private JLabel holding;

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

	String[] graduateYears = { "", "2019", "2020", "2021", "2022", "2023",
			"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031",
			"2032"};

	String[] staffArea = { "", "Elementary Teacher",
			"Middle Teacher", "High Teacher", "Elementary Office", 
			"Middle Office", "High Office", "Maintenance/Custodian",
			"Bus Garage", "Cafeteria", "Board Office", "Coach", 
			"Board Member" };

	String domain = ",OU=Accounts,DC=blackriver,DC=k12,DC=oh,DC=us";

	/**
		Constructor
	*/

	public AccountGUI() {

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

		holding = new JLabel();
		firstNameTF.addActionListener(new firstNameListener());
		lastNameTF.addActionListener(new lastNameListener());

		//declare JComboBoxes
		graduateYearCB = new JComboBox<String>(graduateYears);
		graduateYearCB.setEditable(true);
		StaffCB = new JComboBox<String>(staffArea);
		StaffCB.setEditable(true);

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

		Staff_1.addActionListener(new Staff_1Listener());
		Student.addActionListener(new StudentListener());

		Exit.add(exitButton, BorderLayout.SOUTH);
		panel.add(Exit);
		ResetUser = new JButton("Reset Password");
		Exit.add(ResetUser, BorderLayout.NORTH);
		ResetUser.addActionListener(new ResetUserButtonListener());
		ResetUser.setMnemonic(KeyEvent.VK_R);
		ResetUser.setToolTipText("Click here to Reset the User Password");		

		graduateYear.setVisible(false);
		Staff.setVisible(true);
		graduateYearCB.setVisible(false);
		StaffCB.setVisible(true);
		studentID.setVisible(false);
		studentIDTF.setVisible(false);
	}


	/**
		CreateUserListener is an action listener class for
		the create button.
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
			if (userNameTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Error:  Username is "
						+ "empty.");
				return;
			}
			if (passwordTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Error:  Password is "
						+ "empty.");
				return;
			}
			if (firstNameTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Error:  First Name is"
						+ " empty.");
				return;
			}
			if (lastNameTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Error:  Last Name is "
						+ "empty.");
				return;
			}
			
			if (b == true) {
				JOptionPane.showMessageDialog(null, "Error:  An invalid "
						+ "character was entered.  Please fix and try "
						+ "again.");
				return;
			}

			createdUserName = userName.getText();

			String org = GoogleOrg();
			boolean createGA = createGoogleAccount(userNameTF.getText(),
				firstNameTF.getText(), lastNameTF.getText(), 
				passwordTF.getText(), org, false);

			if (!createGA) {
				JOptionPane.showMessageDialog(null, "Error:  Error creating Google Account ");
				return;
			}
			
			org = ADOrg();
			boolean createAD = createADAccount(userName.getText(), 
					firstName.getText(), lastName.getText(), 
					password.getText(), org, false);

			if (!createAD) {
				JOptionPane.showMessageDialog(null, "Error:  Error creating AD Account ");
				return;
			}
		}

		private boolean createGoogleAccount(String userName, 
				String firstName, String lastName, String password, 
				String org, boolean ChangePassword) {
			try {
//				Runtime.getRuntime().exec("PowerShell -Command GoogleAccount.ps1 " + userName + " " + firstName + " " + 
//						lastName + " " + password + " " + org);
				System.out.println("PowerShell -Command GoogleAccount.ps1 " + userName + " " + firstName + " " + 
				lastName + " " + password + " " + org);
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
//				Runtime.getRuntime().exec("PowerShell -Command ADAccount.ps1 " + userName + " " + firstName + " " +
//						lastName + " " + password + " " + org + " " + ChangePassword);
				System.out.println("PowerShell -Command ADAccount.ps1 " + userName + " " + firstName + " " +
						lastName + " " + password + " " + org + " " + ChangePassword);
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
			//if(graduateYearCB.getSelectedItem()!="0")
				//StaffCB.setSelectedIndex(0);
		}
	}
	
	private class StaffListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//if(StaffCB.getSelectedItem()!="0")
				//graduateYearCB.setSelectedIndex(0);
		}
	}

	private class Staff_1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (Staff_1.isSelected()) {
				graduateYear.setVisible(false);
				Staff.setVisible(true);
				graduateYearCB.setVisible(false);
				StaffCB.setVisible(true);
				studentID.setVisible(false);
				studentIDTF.setVisible(false);
				graduateYearCB.setSelectedIndex(0);
				studentIDTF.setText("");
			}
		}
	}

	private class StudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (Student.isSelected()) {
				graduateYear.setVisible(true);
				Staff.setVisible(false);
				graduateYearCB.setVisible(true);
				StaffCB.setVisible(false);
				studentID.setVisible(true);
				studentIDTF.setVisible(true);
				StaffCB.setSelectedIndex(0);
			}
		}
	}

	public String ADOrg() {
		if (graduateYearCB.getSelectedItem().toString().equals("")) {

			String index = StaffCB.getSelectedItem().toString();
			if (index.equals( "Elementary Teacher")) {
				return "OU=EL Teachers,OU=Teachers" + domain;
			} else if (index.equals( "Middle Teacher")) {
				return "OU=MS Teachers,OU=Teachers" + domain;
			} else if (index.equals( "High Teacher")) {
				return "OU=HS Teachers,OU=Teachers" + domain;
			} else if (index.equals( "Elementary Office")) {
				return "OU=HS,OU=Staff" + domain;
			} else if (index.equals( "Middle Office")) {
				return "OU=HS,OU=Staff" + domain;
			} else if (index.equals( "High Office")) {
				return "OU=HS,OU=Staff" + domain;
			} else if (index.equals( "Maintenance/Custodian")) {
				return "OU=HS,OU=Staff" + domain;
			} else if (index.equals( "Bus Garage")) {
				return "OU=HS,OU=Staff" + domain;
			} else if (index.equals( "Cafeteria")) {
				return "OU=HS,OU=Staff" + domain;
			} else if (index.equals( "Board Office")) {
				return "OU=HS,OU=Staff" + domain;
			} else if (index.equals( "Board Member")) {
				return "OU=HS,OU=Staff" + domain;
			} else {
				JOptionPane.showMessageDialog(null, "If you see this "
						+ "something is screwed up3");
				System.exit(1);
			}

		} else if (!StaffCB.getSelectedItem().toString().equals("")) {
			String index = graduateYearCB.getSelectedItem().toString();
			if (index.equals( "2019")) {
				return "OU=2019,OU=HS,OU=Students" + domain;
			} else if (index.equals( "2020")) {
				return "OU=2020,OU=HS,OU=Students" + domain;
			} else if (index.equals( "2021")) {
				return "OU=2021,OU=HS,OU=Students" + domain;
			} else if (index.equals( "2022")) {
				return "OU=2022,OU=HS,OU=Students" + domain;
			} else if (index.equals( "2023")) {
				return "OU=2023,OU=MS,OU=Students" + domain;
			} else if (index.equals( "2024")) {
				return "OU=2024,OU=MS,OU=Students" + domain;
			} else if (index.equals( "2025")) {
				return "OU=2025,OU=MS,OU=Students" + domain;
			} else if (index.equals( "2026")) {
				return "OU=2026,OU=ES,OU=Students" + domain;
			} else if (index.equals( "2027")) {
				return "OU=2027,OU=ES,OU=Students" + domain;
			} else if (index.equals( "2028")) {
				return "OU=2028,OU=ES,OU=Students" + domain;
			} else if (index.equals( "2029")) {
				return "OU=2029,OU=ES,OU=Students" + domain;
			} else if (index.equals( "2030")) {
				return "OU=2030,OU=ES,OU=Students" + domain;
			} else if (index.equals( "2031")) {
				return "OU=2019,OU=HS,OU=Students" + domain;
//			} else if (index.equals( "2032")) {
//				return "OU=2019,OU=HS,OU=Students" + domain;
//			} else if (index.equals( "2033")) {
//				return "OU=2019,OU=HS,OU=Students" + domain;
//			} else if (index.equals( "2034")) {
//				return "OU=2019,OU=HS,OU=Students" + domain;
//			} else if (index.equals( "2035")) {
//				return "OU=2019,OU=HS,OU=Students" + domain;
//			} else if (index.equals( "2036")) {
//				return "OU=2019,OU=HS,OU=Students" + domain;
//			} else if (index.equals( "2037")) {
//				return "OU=2019,OU=HS,OU=Students" + domain;
//			} else if (index.equals( "2038")) {
//				return "OU=2019,OU=HS,OU=Students" + domain;
//			} else if (index.equals( "2039")) {
//				return "OU=2019,OU=HS,OU=Students" + domain;
//			} else if (index.equals( "2040")) {
//				return "OU=2019,OU=HS,OU=Students" + domain;
			} else {
				JOptionPane.showMessageDialog(null, "If you see this "
						+ "something is screwed up4");
				System.exit(1);
			}

		}
		return "Error";
	}
	
	public String GoogleOrg() {
		if (graduateYearCB.getSelectedItem()=="0") {
			String index = StaffCB.getSelectedItem().toString();
			System.out.println(index);

			if (index.equals( "Elementary Teacher")) {
				return "Staff/Teachers";
			} else if (index.equals( "Middle Teacher")) {
				return "Staff/Teachers";
			} else if (index.equals( "High Teacher")) {
				return "Staff/Teachers";
			} else if (index.equals( "Elementary Office")) {
				return "Staff/Support";
			} else if (index.equals( "Middle Office")) {
				return "Staff/Support";
			} else if (index.equals( "High Office")) {
				return "Staff/Support";
			} else if (index.equals( "Maintenance/Custodian")) {
				return "Staff/Maintenance";
			} else if (index.equals( "Bus Garage")) {
				return "Staff/Bus Drivers";
			} else if (index.equals( "Cafeteria")) {
				return "Staff/Kitchen";
			} else if (index.equals( "Board Office")) {
				return "Staff/Support";
			} else if (index.equals( "Board Member")) {
				return "Staff/Board Members";
			} else {
				JOptionPane.showMessageDialog(null, "If you see this "
						+ "something is screwed up1");
				System.exit(1);
			}

		} else if (StaffCB.getSelectedItem()=="0") {
			String index = (String)graduateYearCB.getSelectedItem();//.toString();

			if (index.equals( "2019")) {
				return "Students/2019";
			} else if (index.equals( "2020")) {
				return "Students/2020";
			} else if (index.equals( "2021")) {
				return "Students/2021";
			} else if (index.equals( "2022")) {
				return "Students/2022";
			} else if (index.equals( "2023")) {
				return "Students/2023";
			} else if (index.equals( "2024")) {
				return "Students/2024";
			} else if (index.equals( "2025")) {
				return "Students/2025";
			} else if (index.equals( "2026")) {
				return "Students/2026";
			} else if (index.equals( "2027")) {
				return "Students/2027";
			} else if (index.equals( "2028")) {
				return "Students/2028";
			} else if (index.equals( "2029")) {
				return "Students/2029";
			} else if (index.equals( "2030")) {
				return "Students/2030";
			} else if (index.equals( "2031")) {
				return "Students/2031";
//			} else if (index.equals( "2032")) {
//				return "Students/2032";
//			} else if (index.equals( "2033")) {
//				return "Students/2033";
//			} else if (index.equals( "2034")) {
//				return "Students/2034";
//			} else if (index.equals( "2035")) {
//				return "Students/2035";
//			} else if (index.equals( "2036")) {
//				return "Students/2036";
//			} else if (index.equals( "2037")) {
//				return "Students/2037";
//			} else if (index.equals( "2038")) {
//				return "Students/2038";
//			} else if (index.equals( "2039")) {
//				return "Students/2039";
//			} else if (index.equals( "2040")) {
//				return "Students/2040";
			} else {
				JOptionPane.showMessageDialog(null, "If you see this "
						+ "something is screwed up2");
				System.exit(1);
			}

		}
		return "Error";
	}
	
	/**
		main method
	*/

	public static void main(String[] args) {
		new AccountGUI();
	}


}

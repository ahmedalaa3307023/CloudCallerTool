package com.mentor.app;
	
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

import org.apache.http.HttpResponse;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import com.mentor.app.database.helpers.MyUserInfo;
import com.mentor.app.database.helpers.Tool;
import javax.swing.JList;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JPopupMenu;
import javax.swing.JComboBox;
	
	public class MainWindow {
	
		
		// layout components
		private JFrame frmMentorApplication;
		private static Timer t;
		private Dimension mainWindowSize;
		private JLabel timeViewer;
		private JMenuBar menuBar;
		private JMenu loginMenu;
		private JMenu supportMenu;
		private JMenu buyMenu;
		private JMenuItem studentLoginSub;
		private JMenuItem companyLoginSub;
		private JMenuItem employeeLoginSub;
		private JMenu technicalHelpSub;
		private JMenuItem mailUsSub;
		private JMenuItem documenttaionSub;
		private JMenuItem reportSub;
		private JMenuItem mntmHowToUse;
		private JMenuItem mntmPricing;
		private JMenuItem mntmHowToPay;
		private JLabel logoLabel;
		private JLabel aboutCompanyLable;
		private JLabel aboutProductLabel;
		private JTextPane aboutProductField;
		private JPanel loginPanel;
		private JLabel userNameLabel;
		private JLabel passwordLabel;
		private JLabel emailLabel;
		private JLabel logoPanel;
		private JPasswordField passwordText;
		private JTextField userNameText;
		private JTextField emailText;
		private JButton loginSubmit;
		private JPanel mainPanel;
		private JLabel emailHint;
		private JLabel userNameHint;
		private JPanel toolsList;
		private JPanel registerationPanel;
		
		//////////////////////////////////////////////////
		public static void main(String[] args) {
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						MainWindow window = new MainWindow();
						window.frmMentorApplication.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		/**
		 * Create the application.
		 */
		public MainWindow() {
	
			
			Toolkit tk = Toolkit.getDefaultToolkit();  
			/*
			 * toolkit is used to get current information form the targent plateform and devices
			 * the use of toolkit is to get the current size of the screen to adjust the frame to it
			 * the concept used in order to use this toolkit is to avoid modifying component places when the use resize the window
			 */
			mainWindowSize = tk.getScreenSize(); // getting the screen size and save it to a private variable to use it  the size is saved as a Dimension type
			
			//mainPanelIntial();
			
			frmMentorApplication = new JFrame();
			frmMentorApplication.setTitle("Mentor Application");
			/*
			 * the link below is the current link for the logo image can be modefied any time
			 */
			frmMentorApplication.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\amohamed\\Desktop\\cloud-models-100255369-orig.jpg"));
			frmMentorApplication.getContentPane().setBackground(new Color(153, 153, 153));
			frmMentorApplication.getContentPane().setLayout(null); // null layout = abslute layout
			
			// the main panel cantains all other panels and options
			mainPanel = new JPanel(); 
			mainPanel.setForeground(UIManager.getColor("CheckBox.focus"));
			mainPanel.setBackground(new Color(255, 255, 255));
			mainPanel.setBounds(0, 0, 1594, 1172);
			frmMentorApplication.getContentPane().add(mainPanel);
			mainPanel.setLayout(null);
			
			////////////////////////////////////////////////////////////////////////////////////
			// used data to get the client current time
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd   HH:mm:ss");
			Date date = new Date();
			///////////////////////////////////////////////////////////////////////////////////
			
			//////////////////////////////////////////////////////////////////////////////////
			// start editing the timer viewer label
			// the lable used to view the time
			timeViewer = new JLabel((dateFormat.format(date).toString()));
			timeViewer.setHorizontalAlignment(SwingConstants.CENTER);
			timeViewer.setFont(new Font("Serif", Font.BOLD, 16));
			timeViewer.setForeground(new Color(0, 0, 128));
			timeViewer.setBackground(new Color(192, 192, 192));
			timeViewer.setBounds(1396, 0, 198, 20);
			mainPanel.add(timeViewer);
			// finish editing the timer viewer label
			////////////////////////////////////////////////////////////////////////////////
			
			///////////////////////////////////////////////////////////////////////////////
			// view of the upper menu 
			menuBar = new JMenuBar();
			menuBar.setForeground(Color.WHITE);
			menuBar.setBorderPainted(false);
			menuBar.setBackground(new Color(255, 255, 255));
			menuBar.setBounds(0, 0, 1400, 21);
			mainPanel.add(menuBar);
			
			loginMenu = new JMenu("Login");
			loginMenu.setForeground(new Color(0, 0, 255));
			menuBar.add(loginMenu);
			
			studentLoginSub = new JMenuItem("Student");
			
			studentLoginSub.setForeground(new Color(0, 0, 128));
			loginMenu.add(studentLoginSub);
			
			companyLoginSub = new JMenuItem("Company");
			companyLoginSub.setForeground(new Color(0, 0, 128));
			loginMenu.add(companyLoginSub);
			
			employeeLoginSub = new JMenuItem("Employee");
			employeeLoginSub.setForeground(new Color(0, 0, 128));
			loginMenu.add(employeeLoginSub);
			
			supportMenu = new JMenu("Support");
			supportMenu.setForeground(new Color(0, 0, 205));
			menuBar.add(supportMenu);
			
			technicalHelpSub = new JMenu("Technical help");
			supportMenu.add(technicalHelpSub);
			
			mailUsSub = new JMenuItem("MailList");
			technicalHelpSub.add(mailUsSub);
			
			documenttaionSub = new JMenuItem("Decumentation");
			technicalHelpSub.add(documenttaionSub);
			
			reportSub = new JMenuItem("Report");
			technicalHelpSub.add(reportSub);
			
			mntmHowToUse = new JMenuItem("How To use");
			supportMenu.add(mntmHowToUse);
			
			buyMenu = new JMenu("Buy");
			buyMenu.setForeground(new Color(0, 0, 255));
			menuBar.add(buyMenu);
			
			mntmPricing = new JMenuItem("Pricing");
			buyMenu.add(mntmPricing);
			
			mntmHowToPay = new JMenuItem("How to pay");
			buyMenu.add(mntmHowToPay);
			// finish edting the upper menu
			/////////////////////////////////////////////////////////////////////
			
			/////////////////////////////////////////////////////////////////////
			// the main registerration button on the left of the screen
			JButton registerButton = new JButton("Register");
			
			registerButton.setEnabled(false);
			registerButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loginPanel.setVisible(false);
					try {
						
						//register();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			registerButton.setBackground(new Color(255, 255, 255));
			registerButton.setFont(new Font("Rockwell Extra Bold", registerButton.getFont().getStyle() | Font.BOLD, registerButton.getFont().getSize() + 15));
			registerButton.setBounds(59, 234, 230, 76);
			mainPanel.add(registerButton);
			
			JButton loginButton = new JButton("Login");
			loginButton.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					loginPanel.show();
				}
			});
			
			loginButton.setFont(new Font("Rockwell Extra Bold", loginButton.getFont().getStyle(), loginButton.getFont().getSize() + 15));
			loginButton.setBackground(Color.WHITE);
			loginButton.setBounds(59, 308, 230, 76);
			mainPanel.add(loginButton);
			
			JTextPane aboutCompany = new JTextPane();
			aboutCompany.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			aboutCompany.setForeground(new Color(0, 0, 128));
			aboutCompany.setBackground(new Color(255, 255, 255));
			aboutCompany.setText("We enable companies to develop better electronic products faster and more cost-effectively. Our innovative products and solutions help engineers conquer design challenges in the increasingly complex worlds of board and chip design.");
			aboutCompany.setBounds(10, 452, 527, 102);
			mainPanel.add(aboutCompany);
			
			aboutCompanyLable = new JLabel("About Company");
			aboutCompanyLable.setForeground(new Color(204, 204, 204));
			aboutCompanyLable.setBounds(10, 427, 124, 20);
			mainPanel.add(aboutCompanyLable);
			
			aboutProductLabel = new JLabel("About Product");
			aboutProductLabel.setForeground(new Color(204, 204, 204));
			aboutProductLabel.setBounds(10, 579, 124, 20);
			mainPanel.add(aboutProductLabel);
			
			aboutProductField = new JTextPane();
			aboutProductField.setText("This is Area for small overview about the product and the developers");
			aboutProductField.setForeground(new Color(0, 0, 128));
			aboutProductField.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			aboutProductField.setBackground(Color.WHITE);
			aboutProductField.setBounds(10, 618, 527, 102);
			mainPanel.add(aboutProductField);
			
			logoLabel = new JLabel("");
			logoLabel.setBounds(49, 32, 240, 160);
			mainPanel.add(logoLabel);
			logoLabel.setVerticalAlignment(SwingConstants.TOP);
			logoLabel.setLabelFor(mainPanel);
			logoLabel.setIcon(new ImageIcon("C:\\Users\\amohamed\\Desktop\\mentor-graphics-logo.jpg"));
			
			//
			//loginPanelIntial();
			loginPanel = new JPanel();
			loginPanel.setBounds(768, 96, 709, 739);
			mainPanel.add(loginPanel);
			loginPanel.setVisible(false);
			loginPanel.setForeground(new Color(0, 0, 128));
			loginPanel.setBorder(new CompoundBorder());
			loginPanel.setBackground(new Color(255, 255, 255));
			loginPanel.setLayout(null);
			
			userNameLabel = new JLabel("User Name");
			userNameLabel.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("deprecation")
				@Override
				public void mouseEntered(MouseEvent e) {
					userNameHint.show();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					userNameHint.setVisible(false);
				}
			});
			userNameLabel.setBackground(new Color(245, 245, 245));
			userNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			userNameLabel.setForeground(new Color(0, 0, 255));
			userNameLabel.setBounds(64, 280, 87, 35);
			loginPanel.add(userNameLabel);
			
			passwordLabel = new JLabel("Password");
			passwordLabel.setForeground(Color.BLUE);
			passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			passwordLabel.setBackground(new Color(245, 245, 245));
			passwordLabel.setBounds(64, 360, 87, 35);
			loginPanel.add(passwordLabel);
			
			emailLabel = new JLabel("Email");
			emailLabel.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("deprecation")
				@Override
				public void mouseEntered(MouseEvent e) {
					emailHint.show();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					emailHint.setVisible(false);
				}
			});
			emailLabel.setForeground(Color.BLUE);
			emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			emailLabel.setBackground(new Color(245, 245, 245));
			emailLabel.setBounds(64, 198, 87, 35);
			loginPanel.add(emailLabel);
			
			logoPanel = new JLabel("");
			logoPanel.setIcon(new ImageIcon("C:\\Users\\amohamed\\Desktop\\mentor-graphics-logo.jpg"));
			logoPanel.setVerticalAlignment(SwingConstants.TOP);
			logoPanel.setBounds(180, 0, 240, 145);
			loginPanel.add(logoPanel);
			
			passwordText = new JPasswordField();
			passwordText.setBounds(232, 368, 206, 20);
			loginPanel.add(passwordText);
			
			userNameText = new JTextField();
			userNameText.setBounds(232, 288, 206, 20);
			loginPanel.add(userNameText);
			userNameText.setColumns(10);
			
			emailText = new JTextField();
			emailText.setBounds(232, 206, 206, 20);
			loginPanel.add(emailText);
			emailText.setColumns(10);
			
			JButton forgetPasswordButton = new JButton("forget password");
			forgetPasswordButton.setHorizontalAlignment(SwingConstants.LEFT);
			forgetPasswordButton.setBorder(null);
			forgetPasswordButton.setBackground(new Color(255, 255, 255));
			forgetPasswordButton.setForeground(new Color(211, 211, 211));
			forgetPasswordButton.setBounds(64, 511, 145, 23);
			loginPanel.add(forgetPasswordButton);
			
			loginSubmit = new JButton("Login");
			loginSubmit.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					try {
						ArrayList<String> userData = new ArrayList<>();
						userData.add(emailText.getText());
						userData.add(userNameText.getText());
						userData.add(String.copyValueOf(passwordText.getPassword()));
						ArrayList<Tool> toolList = getToolsList(userData);
						toolsList.setLayout(new GridLayout(toolList.size(), 1, 5, 25));
						
						JButton[] tools = new JButton [toolList.size()];
						for(int i = 0 ; i < toolList.size() ; i++){
							tools[i] = new JButton();
							tools[i].setText(toolList.get(i).getTool_calling_name());
							tools[i].setBackground(Color.white);
							tools[i].setBorder(null);
							tools[i].setAlignmentX(JButton.LEFT_ALIGNMENT);
							tools[i].addActionListener(ac);
							
							
							toolsList.add(tools[i]);
						}
						loginPanel.setVisible(false);
						toolsList.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					/*
					ArrayList<String> config  = new ArrayList<String>();
					config.add(new String("com.mysql.jdbc.Driver"));
					config.add(new String("jdbc:mysql://localhost:3306/aws_connection"));
					
					// the next try to make admin class with all what can he do from uploading apps and adding tables in the database
					ArrayList<String> admin = new ArrayList<String>();
					admin.add(new String("root"));
					admin.add(new String(""));
					
					String[] tablesData = new String[1];
					tablesData[0] = "users";
					//
					
					String databaseName = "aws_connection";
			
					ArrayList<String> userData = new ArrayList<>();
					userData.add(emailText.getText());
					userData.add(userNameText.getText());
					userData.add(passwordText.getPassword().toString());
				
					DatabaseConnector databaseClon = new DatabaseConnector(config, admin, tablesData, databaseName, userData);
					try {
						String[] tables = new String[4];
						tables[1] = "credintials";
						tables[0] = "users";
						UserData ar = new UserData(); 
						ar = databaseClon.getUserData(tables, userNameText.getText(), emailText.getText(), String.copyValueOf(passwordText.getPassword()));
						
						
						toolsList.setLayout(new GridLayout(ar.getTools().size(), 1, 5, 25));
						
						JButton[] tools = new JButton [ar.getTools().size()];
						for(int i = 0 ; i < ar.getTools().size() ; i++){
							tools[i] = new JButton();
							tools[i].setText(ar.getTools().get(i).getTool_calling_name());
							tools[i].setBackground(Color.white);
							tools[i].setBorder(null);
							tools[i].setAlignmentX(JButton.LEFT_ALIGNMENT);
							tools[i].addActionListener(ac);
							
							
							toolsList.add(tools[i]);
						}
						loginPanel.setVisible(false);
						toolsList.show();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} */
				}
			});
			loginSubmit.setFont(new Font("Times New Roman", Font.BOLD, 19));
			loginSubmit.setBackground(new Color(255, 255, 255));
			loginSubmit.setForeground(new Color(0, 0, 255));
			loginSubmit.setBounds(297, 491, 109, 56);
			loginPanel.add(loginSubmit);
			
			emailHint = new JLabel("Type down your Email address please it is required");
			emailHint.setVisible(false);
			emailHint.setForeground(new Color(135, 206, 250));
			emailHint.setBorder(null);
			emailHint.setBackground(new Color(255, 255, 255));
			emailHint.setBounds(64, 229, 305, 14);
			loginPanel.add(emailHint);
			
			userNameHint = new JLabel("Type down your user name please it is required");
			userNameHint.setVisible(false);
			userNameHint.setForeground(new Color(135, 206, 250));
			userNameHint.setBackground(new Color(255, 255, 255));
			userNameHint.setBounds(64, 312, 291, 14);
			loginPanel.add(userNameHint);
			loginPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{userNameLabel, passwordLabel, emailLabel, logoPanel, passwordText, userNameText, emailText, forgetPasswordButton, loginSubmit, emailHint, userNameHint}));
			
			toolsList = new JPanel();
			toolsList.setBounds(801, 133, 658, 739);
			mainPanel.add(toolsList);
			toolsList.setBackground(UIManager.getColor("Button.disabledShadow"));
			toolsList.setLayout(null);
			
			///////////////////////////////////////////////////////////////////////////////////
			// start editing registeration panel
			registerationPanel = new JPanel();
			registerationPanel.setBackground(Color.WHITE);
			registerationPanel.setBounds(721, 103, 763, 816);
			mainPanel.add(registerationPanel);
			registerationPanel.setLayout(null);
			
			JLabel userName = new JLabel("Name");
			userName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			userName.setBounds(84, 188, 123, 33);
			registerationPanel.add(userName);
			
			JLabel userEmail = new JLabel("Email");
			userEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			userEmail.setBounds(84, 263, 84, 41);
			registerationPanel.add(userEmail);
			
			JLabel conEmail = new JLabel("Confirm Email");
			conEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			conEmail.setBounds(84, 343, 120, 41);
			registerationPanel.add(conEmail);
			
			JLabel password = new JLabel("Password");
			password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			password.setBounds(84, 430, 84, 41);
			registerationPanel.add(password);
			
			JLabel conPassword = new JLabel("Confirm Password");
			conPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			conPassword.setBounds(84, 517, 144, 41);
			registerationPanel.add(conPassword);
			
			JLabel registerationType = new JLabel("Registeration Type");
			registerationType.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			registerationType.setBounds(84, 603, 144, 41);
			registerationPanel.add(registerationType);
			
			textField = new JTextField();
			textField.setBounds(335, 188, 242, 28);
			registerationPanel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(335, 263, 242, 28);
			registerationPanel.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(335, 343, 242, 28);
			registerationPanel.add(textField_2);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(335, 442, 242, 29);
			registerationPanel.add(passwordField);
			
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(335, 529, 242, 29);
			registerationPanel.add(passwordField_1);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(335, 615, 242, 20);
			comboBox.addItem(new JCheckBox());
			registerationPanel.add(comboBox);
			registerationPanel.setVisible(false);
			// finish editing of registeration panel
			//////////////////////////////////////////////////////////////////////
		    //timingforTimerCall();
		    t = new Timer(1000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd   HH:mm:ss");
					Date date = new Date();
					timeViewer.setText((dateFormat.format(date).toString())); 
				}
			});
			
			t.setRepeats(true);
			t.start();
		    //
			
			frmMentorApplication.setBackground(new Color(102, 102, 102));
			frmMentorApplication.setResizable(false);
			frmMentorApplication.setSize(mainWindowSize);
			frmMentorApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		ActionListener ac = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton current = (JButton)e.getSource();
				try {
					JSch ssh = new JSch();
					Session session = ssh.getSession("ec2-user", "54.186.141.167", 22);
					session.setX11Host("localhost");
					session.setX11Port(0+6000);
					UserInfo ui=new MyUserInfo();
					session.setUserInfo(ui);
					session.connect();
					Channel channel = session.openChannel("shell");
					channel.setXForwarding(true);
					String callingProgram = current.getText() + " \n";
					InputStream into = new ByteArrayInputStream(callingProgram.getBytes());
					channel.setInputStream(into);
					channel.setOutputStream(System.out);
					channel.connect();
				} catch (JSchException e1) {
					e1.printStackTrace();
				}
			}
<<<<<<< HEAD
		});

		t.setRepeats(true);
		t.start();
		// End editing time view managemenrt
		// //////////////////////////////////////////////////////////////////

		// /////////////////////////////////////////////////////////////////
		// Setting frame veiw
		frmMentorApplication.setBackground(new Color(102, 102, 102));
		frmMentorApplication.setSize(mainWindowSize);
		frmMentorApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// End setting the frame view
		// /////////////////////////////////////////////////////////////////
	}

	/**
	 * the Action listener takes the ability to connect using the Jsch jar classes to the AWS EC2 instance
	 * connecting to the instance 
	 * sending the calling name of the selected tool
	 */
	ActionListener ac = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton current = (JButton) e.getSource();
			try {
				JSch ssh = new JSch();
				Session session = ssh.getSession("ec2-user", "54.186.141.167",22);
				session.setX11Host("localhost");
				session.setX11Port(0 + 6000);
				UserInfo ui = new MyUserInfo();
				session.setUserInfo(ui);
				session.connect();
				Channel channel = session.openChannel("shell");
				channel.setXForwarding(true);
				String callingProgram = current.getText() + " \n";
				InputStream into = new ByteArrayInputStream(
						callingProgram.getBytes());
				channel.setInputStream(into);
				channel.setOutputStream(System.out);
				channel.connect();
			} catch (JSchException e1) {
				e1.printStackTrace();
=======
		};
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JPasswordField passwordField;
		private JPasswordField passwordField_1;
	
		private void register() throws Exception {
			 
			String url = "http://localhost/registeration/Registeration/welcome_controller/insert_into_table";
	 
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
			
			post.setHeader("User-Agent", "Mozilla/5.0");
	 
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("name", "aahmed"));
			urlParameters.add(new BasicNameValuePair("email", "alla.ahmed45@yahoo.com"));
			urlParameters.add(new BasicNameValuePair("password", "5050505050"));
			urlParameters.add(new BasicNameValuePair("type", "A"));
	 
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
	 
			HttpResponse response = client.execute(post);
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : " + 
	                                    response.getStatusLine().getStatusCode());
	 
			BufferedReader rd = new BufferedReader(
	                        new InputStreamReader(response.getEntity().getContent()));
	 
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
>>>>>>> parent of 9cc3e46... Final delivery
			}
	 
			System.out.println(result.toString());
	 
		}
		
		private ArrayList<Tool> getToolsList(ArrayList<String> userData) throws Exception {
			 
			String url = "http://localhost/registeration/Registeration/login/log_in";
	 
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
	 
			// add header
			post.setHeader("User-Agent", "Mozilla/5.0");
	 
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("user_name", userData.get(1)));
			urlParameters.add(new BasicNameValuePair("email", userData.get(0)));
			urlParameters.add(new BasicNameValuePair("password", userData.get(2)));
			System.out.println(userData.get(0));
			System.out.println(userData.get(1));
			System.out.println(userData.get(2));
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			
			HttpResponse response = client.execute(post);
							
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String serverResponse = rd.readLine();
			String json = (serverResponse.substring(serverResponse.indexOf('{'), serverResponse.length()-1));
			System.out.println(json);
			JSONObject obj = new JSONObject(json);
			String state = obj.getString("success");
			
			ArrayList<Tool> tools = null;
			
			if(state.equals("true")){
				tools = new ArrayList<Tool>();
				JSONArray arr = obj.getJSONArray("data");
				for (int i = 0; i < arr.length(); i++)
				{
					Tool tool = new Tool();
					tool.setTool_id(arr.getJSONObject(i).getString("tool_id"));
				    tool.setTool_calling_name(arr.getJSONObject(i).getString("calling_name"));
				    tool.setTool_name(arr.getJSONObject(i).getString("tool_name"));
				    tools.add(tool);
				}
			}
			return tools;
		}
		private static void addPopup(Component component, final JPopupMenu popup) {
			component.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}
				public void mouseReleased(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}
				private void showMenu(MouseEvent e) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			});
		}
	}

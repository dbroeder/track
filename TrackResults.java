package track;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class TrackResults {

	private JFrame frame;
	private JTextField textFieldCSV;
	private JTextField txtAthletename;
	private File file;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnEvent;
	private JLabel lblEventsTitle;
	private JLabel lblGrades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackResults window = new TrackResults();
					window.frame.setTitle("Track Results");
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
	public TrackResults() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 204));
		frame.setBackground(Color.LIGHT_GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int) screenSize.getWidth() / 2 - (594 / 2), (int) screenSize.getHeight() / 2 - (360 / 2), 594,
				360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JCheckBox[] events = new JCheckBox[15];
		JCheckBox[] grades = new JCheckBox[4];

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(new Color(255, 204, 204));
		horizontalBox.setBounds(10, 0, 525, 23);

		lblNewLabel = new JLabel("     CSV File     ");
		lblNewLabel.setBackground(new Color(255, 204, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		horizontalBox.add(lblNewLabel);

		textFieldCSV = new JTextField();
		horizontalBox.add(textFieldCSV);
		textFieldCSV.setColumns(10);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		horizontalBox.add(btnBrowse);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(horizontalBox);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(10, 34, 279, 66);
		frame.getContentPane().add(verticalBox_1);

		JLabel lblResultsBy = new JLabel("Results by");
		lblResultsBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		verticalBox_1.add(lblResultsBy);

		Box horizontalBox_4 = Box.createHorizontalBox();
		horizontalBox_4.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox_1.add(horizontalBox_4);

		rdbtnEvent = new JRadioButton("Event");
		rdbtnEvent.setBackground(new Color(255, 204, 204));
		horizontalBox_4.add(rdbtnEvent);
		rdbtnEvent.setSelected(true);

		JRadioButton rdbtnAthlete = new JRadioButton("Athlete");
		rdbtnAthlete.setBackground(new Color(255, 204, 204));
		horizontalBox_4.add(rdbtnAthlete);
		rdbtnAthlete.setSelected(false);

		Box horizontalBox_11 = Box.createHorizontalBox();
		horizontalBox_11.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox_1.add(horizontalBox_11);

		JRadioButton rdbtnAuroraOnly = new JRadioButton("Aurora Only");
		rdbtnAuroraOnly.setBackground(new Color(255, 204, 204));
		horizontalBox_11.add(rdbtnAuroraOnly);
		rdbtnAuroraOnly.setSelected(true);

		JRadioButton rdbtnAllSchools = new JRadioButton("All Schools");
		rdbtnAllSchools.setBackground(new Color(255, 204, 204));
		horizontalBox_11.add(rdbtnAllSchools);
		rdbtnAllSchools.setSelected(false);

		Box athlete_box = Box.createVerticalBox();
		athlete_box.setBounds(10, 111, 427, 50);
		frame.getContentPane().add(athlete_box);
		athlete_box.setVisible(false);

		Box horizontalBox_9 = Box.createHorizontalBox();
		horizontalBox_9.setAlignmentX(Component.LEFT_ALIGNMENT);
		athlete_box.add(horizontalBox_9);

		JLabel lblAthlete = new JLabel("Athlete");
		lblAthlete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		horizontalBox_9.add(lblAthlete);

		Box horizontalBox_10 = Box.createHorizontalBox();
		horizontalBox_10.setAlignmentX(Component.LEFT_ALIGNMENT);
		athlete_box.add(horizontalBox_10);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		horizontalBox_10.add(lblName);

		txtAthletename = new JTextField();
		txtAthletename.setHorizontalAlignment(SwingConstants.LEFT);
		horizontalBox_10.add(txtAthletename);
		txtAthletename.setColumns(10);

		JRadioButton rdbtnExactSpelling = new JRadioButton("Exact Spelling");
		rdbtnExactSpelling.setBackground(new Color(255, 204, 204));
		horizontalBox_10.add(rdbtnExactSpelling);
		rdbtnExactSpelling.setSelected(true);

		JRadioButton rdbtnContains = new JRadioButton("Contains");
		rdbtnContains.setBackground(new Color(255, 204, 204));
		horizontalBox_10.add(rdbtnContains);
		rdbtnContains.setSelected(false);

		JButton btnViewResults = new JButton("View Results");
		btnViewResults.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewResults.setBounds(10, 273, 139, 23);
		frame.getContentPane().add(btnViewResults);

		Box events_box = Box.createHorizontalBox();
		events_box.setBounds(10, 111, 525, 151);
		frame.getContentPane().add(events_box);

		Box verticalBox = Box.createVerticalBox();
		events_box.add(verticalBox);

		Box horizontalBox_5 = Box.createHorizontalBox();
		horizontalBox_5.setAlignmentX(Component.LEFT_ALIGNMENT);
		horizontalBox_5.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox_5);

		lblEventsTitle = new JLabel("Events");
		lblEventsTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		horizontalBox_5.add(lblEventsTitle);

		Component horizontalStrut = Box.createHorizontalStrut(30);
		horizontalBox_5.add(horizontalStrut);

		JCheckBox chckbxAll_events = new JCheckBox("All");
		chckbxAll_events.setBackground(new Color(255, 204, 204));
		horizontalBox_5.add(chckbxAll_events);

		Box horizontalBox_6 = Box.createHorizontalBox();
		horizontalBox_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_6);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalBox_6.add(horizontalStrut_2);

		JLabel lblFieldEvents = new JLabel("Field Events");
		horizontalBox_6.add(lblFieldEvents);
		lblFieldEvents.setFont(new Font("Tahoma", Font.PLAIN, 16));

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_1);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_1);

		JCheckBox chckbxHj = new JCheckBox("HJ");
		chckbxHj.setBackground(new Color(255, 204, 204));
		horizontalBox_1.add(chckbxHj);
		events[0] = chckbxHj;

		JCheckBox chckbxLj = new JCheckBox("LJ");
		chckbxLj.setBackground(new Color(255, 204, 204));
		horizontalBox_1.add(chckbxLj);
		events[1] = chckbxLj;

		JCheckBox chckbxTj = new JCheckBox("TJ");
		chckbxTj.setBackground(new Color(255, 204, 204));
		horizontalBox_1.add(chckbxTj);
		events[2] = chckbxTj;

		JCheckBox chckbxPv = new JCheckBox("PV");
		chckbxPv.setBackground(new Color(255, 204, 204));
		horizontalBox_1.add(chckbxPv);
		events[3] = chckbxPv;

		JCheckBox chckbxSp = new JCheckBox("SP");
		chckbxSp.setBackground(new Color(255, 204, 204));
		horizontalBox_1.add(chckbxSp);
		events[4] = chckbxSp;

		JCheckBox chckbxDt = new JCheckBox("DT");
		chckbxDt.setBackground(new Color(255, 204, 204));
		horizontalBox_1.add(chckbxDt);
		events[5] = chckbxDt;

		Box horizontalBox_7 = Box.createHorizontalBox();
		horizontalBox_7.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_7);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalBox_7.add(horizontalStrut_3);

		JLabel lblRunningEvents = new JLabel("Running Events");
		horizontalBox_7.add(lblRunningEvents);
		lblRunningEvents.setFont(new Font("Tahoma", Font.PLAIN, 16));

		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_2);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalBox_2.add(horizontalStrut_4);

		JCheckBox checkBox = new JCheckBox("100");
		checkBox.setBackground(new Color(255, 204, 204));
		horizontalBox_2.add(checkBox);
		events[6] = checkBox;

		JCheckBox checkBox_1 = new JCheckBox("200");
		checkBox_1.setBackground(new Color(255, 204, 204));
		horizontalBox_2.add(checkBox_1);
		events[7] = checkBox_1;

		JCheckBox checkBox_2 = new JCheckBox("400");
		checkBox_2.setBackground(new Color(255, 204, 204));
		horizontalBox_2.add(checkBox_2);
		events[8] = checkBox_2;

		JCheckBox checkBox_3 = new JCheckBox("800");
		checkBox_3.setBackground(new Color(255, 204, 204));
		horizontalBox_2.add(checkBox_3);
		events[9] = checkBox_3;

		JCheckBox checkBox_4 = new JCheckBox("1600");
		checkBox_4.setBackground(new Color(255, 204, 204));
		horizontalBox_2.add(checkBox_4);
		events[10] = checkBox_4;

		JCheckBox chckbxh = new JCheckBox("100H");
		chckbxh.setBackground(new Color(255, 204, 204));
		horizontalBox_2.add(chckbxh);
		events[11] = chckbxh;

		JCheckBox chckbxh_1 = new JCheckBox("195H");
		chckbxh_1.setBackground(new Color(255, 204, 204));
		horizontalBox_2.add(chckbxh_1);
		events[12] = chckbxh_1;

		Box horizontalBox_8 = Box.createHorizontalBox();
		horizontalBox_8.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_8);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalBox_8.add(horizontalStrut_5);

		JLabel lblRelays = new JLabel("Relays");
		horizontalBox_8.add(lblRelays);
		lblRelays.setFont(new Font("Tahoma", Font.PLAIN, 16));

		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_3);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_6);

		JCheckBox chckbxx = new JCheckBox("400");
		chckbxx.setBackground(new Color(255, 204, 204));
		horizontalBox_3.add(chckbxx);
		events[13] = chckbxx;

		JCheckBox chckbxx_1 = new JCheckBox("1600");
		chckbxx_1.setBackground(new Color(255, 204, 204));
		horizontalBox_3.add(chckbxx_1);
		events[14] = chckbxx_1;

		Box verticalBox_3 = Box.createVerticalBox();
		verticalBox_3.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		events_box.add(verticalBox_3);

		Box horizontalBox_13 = Box.createHorizontalBox();
		horizontalBox_13.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox_3.add(horizontalBox_13);

		lblGrades = new JLabel("Grades");
		lblGrades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		horizontalBox_13.add(lblGrades);

		JCheckBox chckbxAll_grades = new JCheckBox("All");
		chckbxAll_grades.setBackground(new Color(255, 204, 204));
		horizontalBox_13.add(chckbxAll_grades);

		Box horizontalBox_14 = Box.createHorizontalBox();
		horizontalBox_14.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox_3.add(horizontalBox_14);

		JCheckBox chckbxthBoys = new JCheckBox("8th Boys");
		chckbxthBoys.setBackground(new Color(255, 204, 204));
		horizontalBox_14.add(chckbxthBoys);
		grades[0] = chckbxthBoys;

		JCheckBox chckbxthGirls = new JCheckBox("8th Girls");
		chckbxthGirls.setBackground(new Color(255, 204, 204));
		horizontalBox_14.add(chckbxthGirls);
		grades[1] = chckbxthGirls;

		Box horizontalBox_15 = Box.createHorizontalBox();
		horizontalBox_15.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox_3.add(horizontalBox_15);

		JCheckBox chckbxthBoys_1 = new JCheckBox("7th Boys");
		chckbxthBoys_1.setBackground(new Color(255, 204, 204));
		horizontalBox_15.add(chckbxthBoys_1);
		grades[2] = chckbxthBoys_1;

		JCheckBox chckbxthGirls_1 = new JCheckBox("7th Girls");
		chckbxthGirls_1.setBackground(new Color(255, 204, 204));
		horizontalBox_15.add(chckbxthGirls_1);
		grades[3] = chckbxthGirls_1;

		JTextArea txtrDisplayarea = new JTextArea();
		txtrDisplayarea.setBounds(10, 273, 525, 189);

		JScrollPane scroll = new JScrollPane(txtrDisplayarea);
		scroll.setBounds(10, 273, 525, 189);

		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setBounds(354, 34, 186, 66);
		frame.getContentPane().add(verticalBox_2);

		JLabel lblOrderByPersonal = new JLabel("Season Highs");
		lblOrderByPersonal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		verticalBox_2.add(lblOrderByPersonal);

		JRadioButton rdbtnSeasonHighs = new JRadioButton("Show Season Highs");
		rdbtnSeasonHighs.setBackground(new Color(255, 204, 204));
		verticalBox_2.add(rdbtnSeasonHighs);

		JFrame displayFrame = new JFrame();
		displayFrame.getContentPane().add(scroll);
		displayFrame.setBounds((int) screenSize.getWidth() / 2 - (594 / 2),
				(int) screenSize.getHeight() / 2 - (360 / 2), 594, 360);

		for (int i = 0; i < events.length; i++) {
			final int in = i;
			events[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (!events[in].isSelected()) {
						chckbxAll_events.setSelected(false);
					}
				}
			});
		}

		for (int i = 0; i < grades.length; i++) {
			final int in = i;
			grades[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (!grades[in].isSelected()) {
						chckbxAll_grades.setSelected(false);
					}
				}
			});
		}

		chckbxAll_grades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxAll_grades.isSelected()) {
					for (int i = 0; i < grades.length; i++) {
						grades[i].setSelected(true);
					}
				} else {
					for (int i = 0; i < grades.length; i++) {
						grades[i].setSelected(false);
					}
				}

			}
		});

		chckbxAll_events.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxAll_events.isSelected()) {
					for (int i = 0; i < events.length; i++) {
						events[i].setSelected(true);
					}
				} else {
					for (int i = 0; i < events.length; i++) {
						events[i].setSelected(false);
					}
				}

			}
		});

		rdbtnEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnAthlete.isSelected()) {
					rdbtnAthlete.setSelected(false);
					events_box.setVisible(true);
					athlete_box.setVisible(false);
					rdbtnAuroraOnly.setEnabled(true);
					rdbtnAllSchools.setEnabled(true);
				} else if (!rdbtnAthlete.isSelected() && !rdbtnEvent.isSelected()&&rdbtnSeasonHighs.isSelected()) {
					rdbtnEvent.setSelected(true);
				}else if (!rdbtnAthlete.isSelected() && !rdbtnEvent.isSelected()) {
					rdbtnEvent.setSelected(true);
				}

			}
		});

		rdbtnAthlete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnAuroraOnly.setEnabled(false);
				rdbtnAllSchools.setEnabled(false);
				if (rdbtnEvent.isSelected()) {
					rdbtnEvent.setSelected(false);
					events_box.setVisible(false);
					athlete_box.setVisible(true);
				} else if (!rdbtnAthlete.isSelected() && !rdbtnEvent.isSelected()) {
					rdbtnAthlete.setSelected(true);
				}

			}
		});

		rdbtnAuroraOnly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAuroraOnly.isSelected()) {
					rdbtnAllSchools.setSelected(false);
				} else if (!rdbtnAuroraOnly.isSelected() && !rdbtnAllSchools.isSelected()) {
					rdbtnAuroraOnly.setSelected(true);
				}

			}
		});

		rdbtnAllSchools.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAllSchools.isSelected()) {
					rdbtnAuroraOnly.setSelected(false);
				} else if (!rdbtnAuroraOnly.isSelected() && !rdbtnAllSchools.isSelected()) {
					rdbtnAllSchools.setSelected(true);
				}

			}
		});

		rdbtnContains.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnContains.isSelected()) {
					rdbtnExactSpelling.setSelected(false);
				} else if (!rdbtnContains.isSelected() && !rdbtnExactSpelling.isSelected()) {
					rdbtnContains.setSelected(true);
				}

			}
		});

		rdbtnExactSpelling.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnExactSpelling.isSelected()) {
					rdbtnContains.setSelected(false);
				} else if (!rdbtnContains.isSelected() && !rdbtnExactSpelling.isSelected()) {
					rdbtnExactSpelling.setSelected(true);
				}

			}
		});

		btnViewResults.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean fileRunnable = false;
				boolean eventRunnable = false;
				boolean gradeRunnable = false;
				boolean eventCheck = false;
				boolean gradeCheck = false;
				ArrayList<String> selectedEvents = new ArrayList<String>();
				ArrayList<String> selectedGrades = new ArrayList<String>();
				File file = new File(textFieldCSV.getText());
				
				if (rdbtnSeasonHighs.isSelected()) {
					
					lblNewLabel.setForeground(Color.black);
					
					for (int i = 0; i < events.length; i++) {
						if (events[i].isSelected()) {
							eventCheck = true;
							if (i == 13 || i == 14)
								selectedEvents.add(events[i].getText() + "R");
							else
								selectedEvents.add(events[i].getText());

						}
					}
					for (int i = 0; i < grades.length; i++) {
						if (grades[i].isSelected()) {
							gradeCheck = true;
							selectedGrades.add(grades[i].getText());
						}

					}

					if (eventCheck == false) {
						lblEventsTitle.setForeground(Color.RED);
						eventRunnable = false;

					} else {
						lblEventsTitle.setForeground(Color.black);
						eventRunnable = true;
					}
					if (gradeCheck == false) {
						lblGrades.setForeground(Color.red);
						gradeRunnable = false;
					} else {
						lblGrades.setForeground(Color.black);
						gradeRunnable = true;
					}
					
					if (eventRunnable && gradeRunnable) {
						StudentEvents se = new StudentEvents();
						try {
							se.loadStudents();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<StudentAthlete> students = se.getStudents();
						ArrayList<Student> grade8M = new ArrayList<Student>();
						ArrayList<Student> grade8G = new ArrayList<Student>();
						ArrayList<Student> grade7M = new ArrayList<Student>();
						ArrayList<Student> grade7G = new ArrayList<Student>();
						for (StudentAthlete sa : students) {
							for (String r : selectedEvents) {
								for (Event v : sa.getEvents()) {
									if (v.getEventName().equals(r.replace("R", ""))) {
										if (sa.getGrade().contains("8th") && sa.getGender().equals("M")) {
											grade8M.add(new Student(sa.getName(), sa.getGrade(), sa.getGender(),
													v.getEventName(), v.getBestDistance(),v.getEventType()));
										} else if (sa.getGrade().contains("8th") && sa.getGender().equals("F")) {
											grade8G.add(new Student(sa.getName(), sa.getGrade(), sa.getGender(),
													v.getEventName(), v.getBestDistance(),v.getEventType()));
										} else if (sa.getGrade().contains("7th") && sa.getGender().equals("F")) {
											grade7G.add(new Student(sa.getName(), sa.getGrade(), sa.getGender(),
													v.getEventName(), v.getBestDistance(),v.getEventType()));
										} else if (sa.getGrade().contains("7th") && sa.getGender().equals("M")) {
											grade7M.add(new Student(sa.getName(), sa.getGrade(), sa.getGender(),
													v.getEventName(), v.getBestDistance(),v.getEventType()));
										}

									}
								}
							}
						}
						if(grade8M.get(0).getEventType().equals("F")){
							grade8M.sort(Comparator.comparing(Student::compareDistance).reversed());
							grade7M.sort(Comparator.comparing(Student::compareDistance).reversed());
							grade8G.sort(Comparator.comparing(Student::compareDistance).reversed());
							grade7G.sort(Comparator.comparing(Student::compareDistance).reversed());
						}else{
							grade8M.sort(Comparator.comparing(Student::compareDistance));
							grade7M.sort(Comparator.comparing(Student::compareDistance));
							grade8G.sort(Comparator.comparing(Student::compareDistance));
							grade7G.sort(Comparator.comparing(Student::compareDistance));
						}
						
						String printout = "";
						for (String s : selectedGrades) {
							if (s.equals("8th Boys")) {
								for (Student z : grade8M)
									printout += z.display()+"\n";
								printout += "\n\n";
							} else if (s.equals("8th Girls")) {
								for (Student z : grade8G)
									printout += z.display()+"\n";
								printout += "\n\n";
							} else if (s.equals("7th Boys")) {
								for (Student z : grade7M)
									printout += z.display()+"\n";
								printout += "\n\n";
							} else {
								for (Student z : grade7G)
									printout += z.display()+"\n";
								printout += "\n\n";
							}
						}
						txtrDisplayarea.setText(printout);

						displayFrame.setVisible(true);
					}

				}
				 else if (rdbtnAthlete.isSelected()) {
					 if (!file.exists() || !file.getAbsolutePath().endsWith(".csv")) {
							lblNewLabel.setForeground(Color.RED);
							textFieldCSV.setText("File does not exist or is not a csv file. Please try again.");
							fileRunnable = false;
						} else {
							lblNewLabel.setForeground(Color.black);
							fileRunnable = true;
						}
					if (fileRunnable) {
						boolean exact = true;
						if (rdbtnContains.isSelected())
							exact = false;
						StudentEvents sa = new StudentEvents();
						txtrDisplayarea.setText(sa.getStudents(txtAthletename.getText(), file, exact));
						displayFrame.setVisible(true);
					}

				} else if (rdbtnEvent.isSelected()) {
					if (!file.exists() || !file.getAbsolutePath().endsWith(".csv")) {
						lblNewLabel.setForeground(Color.RED);
						textFieldCSV.setText("File does not exist or is not a csv file. Please try again.");
						fileRunnable = false;
					} else {
						lblNewLabel.setForeground(Color.black);
						fileRunnable = true;
					}


					for (int i = 0; i < events.length; i++) {
						if (events[i].isSelected()) {
							eventCheck = true;
							if (i == 13 || i == 14)
								selectedEvents.add(events[i].getText() + "R");
							else
								selectedEvents.add(events[i].getText());

						}
					}
					for (int i = 0; i < grades.length; i++) {
						if (grades[i].isSelected()) {
							gradeCheck = true;
							selectedGrades.add(grades[i].getText());
						}

					}

					if (eventCheck == false) {
						lblEventsTitle.setForeground(Color.RED);
						eventRunnable = false;

					} else {
						lblEventsTitle.setForeground(Color.black);
						eventRunnable = true;
					}
					if (gradeCheck == false) {
						lblGrades.setForeground(Color.red);
						gradeRunnable = false;
					} else {
						lblGrades.setForeground(Color.black);
						gradeRunnable = true;
					}

					String printout = "";
					if (fileRunnable && gradeRunnable && eventRunnable) {
						System.err.println("here");
						TrackResultsBrain trb = new TrackResultsBrain(file);
						StudentEvents se = new StudentEvents();

						try {
							se.getStudents("", file, false);
							se.saveStudents();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						String school = "All";
						if (rdbtnAuroraOnly.isSelected())
							school = "Aurora";
						for (int i = 0; i < selectedEvents.size(); i++) {
							for (int d = 0; d < selectedGrades.size(); d++) {
								try{
									printout += trb.getStudents(selectedEvents.get(i), selectedGrades.get(d), school);

								}catch(Exception er){
									er.printStackTrace();
								}
							}
						}

						txtrDisplayarea.setText(printout);

						displayFrame.setVisible(true);

					}
				}

			}

		});

		btnBrowse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File directory = new File("C:\\Users\\dbroeder\\Downloads");
				JFileChooser chooser = new JFileChooser(directory);
				FileNameExtensionFilter ff = new FileNameExtensionFilter("CSV Filter", "csv");
				chooser.setFileFilter(ff);
				chooser.setDialogTitle("Select CSV File");
				int choice = chooser.showOpenDialog(frame);
				if (choice == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					textFieldCSV.setText(file.getAbsolutePath());
				}
			}
		});
		rdbtnSeasonHighs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSeasonHighs.isSelected()) {
					if(rdbtnAthlete.isSelected()){
						events_box.setVisible(true);
						athlete_box.setVisible(false);
						rdbtnEvent.setSelected(true);
						rdbtnAthlete.setSelected(false);
					}
					rdbtnAuroraOnly.setEnabled(false);
					rdbtnAthlete.setEnabled(false);
					rdbtnAllSchools.setEnabled(false);
					rdbtnEvent.setSelected(true);
					rdbtnAthlete.setSelected(false);
					chckbxx.setEnabled(false);
					chckbxx_1.setEnabled(false);
				} else {
					rdbtnAuroraOnly.setEnabled(true);
					rdbtnAthlete.setEnabled(true);
					rdbtnAllSchools.setEnabled(true);
					chckbxx.setEnabled(true);
					chckbxx_1.setEnabled(true);
					
				}
			}
		});
	}
}

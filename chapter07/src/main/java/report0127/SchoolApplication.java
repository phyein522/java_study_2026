package report0127;

import lombok.Getter;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Getter
public class SchoolApplication extends JFrame {
	ArrayList<StudentForApp> students = new ArrayList<StudentForApp>(0);
	StudentForApp student;

	public SchoolApplication() {
		setTitle("SchoolApplication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(null);
		createMenu(0);

		setSize(800, 450);
		setVisible(true);
	}

	void createMenu(int state) {
		getContentPane().removeAll();
		JMenuBar mb = new JMenuBar();
		switch(state) {
			case 0:
				JMenu signupMenu = new JMenu("회원가입");
				JMenu loginMenu = new JMenu("로그인");
				signupMenu.addMenuListener(new MenuListener() {
					@Override
					public void menuSelected(MenuEvent e) {
						setContentPane(new SignupPane());
						revalidate();
						repaint();
					}
					@Override
					public void menuDeselected(MenuEvent e) {}
					@Override
					public void menuCanceled(MenuEvent e) {}
				});
				loginMenu.addMenuListener(new MenuListener() {
					@Override
					public void menuSelected(MenuEvent e) {
						setContentPane(new LoginPane());
						revalidate();
						repaint();
					}
					@Override
					public void menuDeselected(MenuEvent e) {}
					@Override
					public void menuCanceled(MenuEvent e) {}
				});
				mb.add(signupMenu);
				mb.add(loginMenu);
				break;
			case 1:
				JMenu lectureMenu = new JMenu("강의 관리");
				JMenuItem lectureListMenuItem = new JMenuItem("강의 목록");
				JMenuItem lectureAddMenuItem = new JMenuItem("강의 추가");
				JMenuItem lectureRemoveMenuItem = new JMenuItem("강의 삭제");
				lectureListMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setContentPane(new LectureListPane());
					}
				});
				lectureAddMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
				lectureRemoveMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
				lectureMenu.add(lectureListMenuItem);
				lectureMenu.add(lectureAddMenuItem);
				lectureMenu.add(lectureRemoveMenuItem);

				JMenu myPageMenu = new JMenu("마이페이지");
				JMenuItem logoutMenuItem = new JMenuItem("로그아웃");
				JMenuItem signOutMenuItem = new JMenuItem("회원탈퇴");
				JMenuItem informationMenuItem = new JMenuItem("회원 정보");	//회원 정보 수정 버튼 포함
				informationMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
				signOutMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
				logoutMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
				myPageMenu.add(informationMenuItem);
				myPageMenu.add(signOutMenuItem);
				myPageMenu.add(logoutMenuItem);

				mb.add(lectureMenu);
				mb.add(myPageMenu);

				break;
		}
		setJMenuBar(mb);
		revalidate();
		repaint();
	}

	class SignupPane extends JPanel {
		JTextField nameTf;
		JTextField majorTf;
		JTextField numberTf;
		JTextField birthTf;
		JTextField phoneTf;
		JTextField emailTf;

		SignupPane() {
			setLayout(new GridLayout(7, 2));

			add(new JLabel("이름 (1~100자)"));
			nameTf = new JTextField(100);
			add(nameTf);

			add(new JLabel("학과/전공 (1~100자)"));
			majorTf = new JTextField(100);
			add(majorTf);

			add(new JLabel("학번 (10자리 숫자)"));
			numberTf = new JTextField(10);
			add(numberTf);

			add(new JLabel("생년월일 (yyyy-MM-dd) (선택)"));
			birthTf = new JTextField(10);
			add(birthTf);

			add(new JLabel("전화번호 (010-0000-0000) (선택)"));
			phoneTf = new JTextField(13);
			add(phoneTf);

			add(new JLabel("이메일 (선택)"));
			emailTf = new JTextField();
			add(emailTf);

			JButton clearBtn = new JButton("초기화");
			JButton signupBtn = new JButton("회원가입");
			add(clearBtn);
			add(signupBtn);

			clearBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					clearTf();
				}
			});

			signupBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = nameTf.getText();
					if(!StudentForApp.isValid(name, "name")) {
						JOptionPane.showMessageDialog(null, "이름을 1~100글자 범위로 입력하세요.", "name", JOptionPane.WARNING_MESSAGE);
						return;
					}
					String major = majorTf.getText();
					if(!StudentForApp.isValid(major, "major")) {
						JOptionPane.showMessageDialog(null, "학과/전공을 1~100글자 범위로 입력하세요.", "major", JOptionPane.WARNING_MESSAGE);
						return;
					}
					String numberString = numberTf.getText();
					if(!StudentForApp.isValid(numberString, "number")) {
						JOptionPane.showMessageDialog(null, "학번을 10자리 숫자로 입력하세요.", "number", JOptionPane.WARNING_MESSAGE);
						return;
					}
					int number = Integer.parseInt(numberString);
					if(containsStudentNumber(number)) {
						JOptionPane.showMessageDialog(null, "이미 회원가입된 학번입니다.", "containsStudentNumber", JOptionPane.WARNING_MESSAGE);
						return;
					}
					String birthString = birthTf.getText();
					if(!birthString.isBlank() && !StudentForApp.isValid(birthString, "birth")) {
						JOptionPane.showMessageDialog(null, "날짜를 yyyy-MM-dd 형식으로 입력해주세요.", "birth", JOptionPane.WARNING_MESSAGE);
						return;
					}
					LocalDate birth = birthString.isBlank() ? null : LocalDate.parse(birthString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					String phone = phoneTf.getText();
					if(!phone.isBlank() && !StudentForApp.isValid(phone, "phone")) {
						JOptionPane.showMessageDialog(null, "전화번호를 010-0000-0000 형식으로 입력해주세요.", "phone", JOptionPane.WARNING_MESSAGE);
						return;
					}
					phone = phone.isBlank() ? null : phone;
					String email = emailTf.getText();
					if(!email.isBlank() && !StudentForApp.isValid(email, "email")) {
						JOptionPane.showMessageDialog(null, "이메일을 이메일 형식으로 입력해주세요.", "email", JOptionPane.WARNING_MESSAGE);
						return;
					}
					email = email.isBlank() ? null : email;
					getStudents().add(new StudentForApp(name, major, number, birth, phone, email));
					clearTf();
				}
			});
		}

		void clearTf() {
			nameTf.setText("");
			majorTf.setText("");
			numberTf.setText("");
			birthTf.setText("");
			phoneTf.setText("");
			emailTf.setText("");
		}
	}

	class LoginPane extends JPanel {
		JTextField numberTf;
		LoginPane() {
			setLayout(new GridLayout(1, 3));
			add(new JLabel("학번"));
			numberTf = new JTextField(10);
			add(numberTf);
			JButton loginBtn = new JButton("Login");
			add(loginBtn);

			loginBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String numberString = numberTf.getText();
					if(!StudentForApp.isValid(numberString, "number")) {
						JOptionPane.showMessageDialog(null, "학번을 10자리 숫자로 입력하세요.", "number", JOptionPane.WARNING_MESSAGE);
						return;
					}
					int number = Integer.parseInt(numberString);
					if(!containsStudentNumber(number)) {
						JOptionPane.showMessageDialog(null, "존재하지 않거나 회원가입 되지 않은 학번입니다.", "containsStudentNumber", JOptionPane.WARNING_MESSAGE);
						return;
					}
					setStudent(getStudents().get(getStudentIndex(number)));
					numberTf.setText("");
					createMenu(1);
				}
			});
		}
	}

	class LectureListPane extends JPanel {
		LectureListPane() {
			//임시, 수정 필요
			setLayout(new FlowLayout());
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(getStudents().size() + 1, 5));
			panel.add(new JLabel("강의명"));
			panel.add(new JLabel("학점"));
			panel.add(new JLabel("성적"));
			panel.add(new JLabel("수강일"));
			panel.add(new JLabel("구분"));
			addLectureList(panel);

			JScrollPane scrollPane = new JScrollPane(panel);
			add(scrollPane);
		}

		void addLectureList(JPanel panel) {
			for(LectureForApp lecture : getStudent().getLectures()) {
				panel.add(new JLabel(lecture.getSubject()));
				panel.add(new JLabel(String.valueOf(lecture.getCredit())));
				panel.add(new JLabel(switch(String.valueOf(lecture.getGrade())) {
					case "4.5" -> "A+";
					case "4.0" -> "A";
					case "3.5" -> "B+";
					case "3.0" -> "B";
					case "2.5" -> "C+";
					case "2.0" -> "C";
					case "1.5" -> "D+";
					case "1.0" -> "D";
					default -> "F";
				}));
				panel.add(new JLabel(lecture.getTakeDate()));
				panel.add(new JLabel(lecture.getDivide()));
			}
		}
	}

	class LectureAddPane extends JPanel {
		JTextField subjectTf;
		JTextField creditTf;
		JRadioButton[] gradeRadioButtons;
		JRadioButton A_plus;
		JRadioButton A;
		JRadioButton B_plus;
		JRadioButton B;
		JRadioButton C_plus;
		JRadioButton C;
		JRadioButton D_plus;
		JRadioButton D;
		JRadioButton F;
		GradeListener gradeListener;
		JTextField takeDateTf;
		JRadioButton divideMajor;
		JRadioButton divideRefinement;
		DivideListener divideListener;
		JButton clearBtn;
		JButton addBtn;

		LectureAddPane() {
			setLayout(new GridLayout(6, 2));

			add(new JLabel("과목/강의명"));
			subjectTf = new JTextField(100);
			add(subjectTf);

			add(new JLabel("학점"));
			creditTf = new JTextField(3);
			add(creditTf);

			add(new JLabel("성적"));
			JPanel gradePanel = new JPanel();
			gradePanel.setLayout(new GridLayout(9, 1));
			A_plus = new JRadioButton("A+");
			A = new JRadioButton("A");
			B_plus = new JRadioButton("B+");
			B = new JRadioButton("B");
			C_plus = new JRadioButton("C+");
			C = new JRadioButton("C");
			D_plus = new JRadioButton("D+");
			D = new JRadioButton("D");
			F = new JRadioButton("F");
			gradeRadioButtons[0] = A_plus;
			gradeRadioButtons[1] = A;
			gradeRadioButtons[2] = B_plus;
			gradeRadioButtons[3] = B;
			gradeRadioButtons[4] = C_plus;
			gradeRadioButtons[5] = C;
			gradeRadioButtons[6] = D_plus;
			gradeRadioButtons[7] = D;
			gradeRadioButtons[8] = F;
			gradeListener = new GradeListener();
			for(JRadioButton gradeRadioButton : gradeRadioButtons) {
				gradeRadioButton.addItemListener(gradeListener);
				gradePanel.add(gradeRadioButton);
			}

			add(new JLabel("수강일"));
			takeDateTf = new JTextField(7);
			add(takeDateTf);

			add(new JLabel("구분"));
			JPanel dividePanel = new JPanel();
			dividePanel.setLayout(new GridLayout(1, 2));
			divideMajor = new JRadioButton("전공");
			divideRefinement = new JRadioButton("교양");
			divideListener = new DivideListener();
			divideMajor.addItemListener(divideListener);
			divideRefinement.addItemListener(divideListener);
			dividePanel.add(divideMajor);
			dividePanel.add(divideRefinement);

			clearBtn = new JButton("초기화");
			addBtn = new JButton("추가");
			clearBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					clear();
				}
			});
			addBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String subject = subjectTf.getText();
					if(!LectureForApp.isValid(subject, "subject")) {
						JOptionPane.showMessageDialog(null, "과목/강의명을 1~100글자 범위로 입력하세요.", "subject", JOptionPane.WARNING_MESSAGE);
						return;
					}
					String creditString = creditTf.getText();
					if(!LectureForApp.isValid(creditString, "credit")) {
						JOptionPane.showMessageDialog(null, "", "credit", JOptionPane.WARNING_MESSAGE);
						return;
					}
					int credit = Integer.parseInt(creditString);
					double grade = gradeListener.getGrade();
					if(!LectureForApp.isValid(String.valueOf(grade), "grade")) {
						JOptionPane.showMessageDialog(null, "성적을 F~A+ 범위로 입력하세요.", "grade", JOptionPane.WARNING_MESSAGE);
						return;
					}
					String takeDate = takeDateTf.getText();
					if(!LectureForApp.isValid(takeDate, "takeDate")) {
						JOptionPane.showMessageDialog(null, "수강일을 년도-학기 형식(예: 2000-3)으로 입력하세요.", "takeDate", JOptionPane.WARNING_MESSAGE);
						return;
					}
					String divide = divideListener.getDivide();
					if(!LectureForApp.isValid(divide, "divide")) {
						JOptionPane.showMessageDialog(null, "구분을 전공/교양 중에서 입력하세요.", "divide", JOptionPane.WARNING_MESSAGE);
						return;
					}
					getStudent().addLecture(subject, credit, grade, takeDate, divide);
					clear();
				}
			});
			add(clearBtn);
			add(addBtn);

			clear();
		}

		void clear() {
			subjectTf.setText("");
			creditTf.setText("");
			for(JRadioButton gradeRadioButton : gradeRadioButtons) {
				gradeRadioButton.setSelected(false);
			}
			takeDateTf.setText("");
			divideMajor.setSelected(false);
			divideRefinement.setSelected(false);
		}

		class GradeListener implements ItemListener {
			double grade;

			double getGrade() {
				return this.grade;
			}

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(e.getItem() == A_plus) {
						grade = LectureForApp.A_PLUS;
					} else if(e.getItem() == A) {
						grade = LectureForApp.A;
					} else if(e.getItem() == B_plus) {
						grade = LectureForApp.B_PLUS;
					} else if(e.getItem() == B) {
						grade = LectureForApp.B;
					} else if(e.getItem() == C_plus) {
						grade = LectureForApp.C_PLUS;
					} else if(e.getItem() == C) {
						grade = LectureForApp.C;
					} else {
						grade = LectureForApp.F;
					}
				}
			}
		}

		class DivideListener implements ItemListener {
			String divide;

			String getDivide() {
				return this.divide;
			}

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(e.getItem() == divideRefinement) {
						divide = "REFINEMENT";
					} else {
						divide = "MAJOR";
					}
				}
			}
		}
	}

	public boolean containsStudentNumber(int number) {
		for(StudentForApp student : this.getStudents()) {
			if(number == student.getNumber()) {
				return true;
			}
		}
		return false;
	}

	private int getStudentIndex(int number) {
		for(int i = 0; i < this.getStudents().size(); i++) {
			if(this.getStudents().get(i).getNumber() == number) {
				return i;
			}
		}
		return -1;
	}

	private void setStudent(StudentForApp student) {
		this.student = student;
	}

	public static void main(String[] args) {
		new SchoolApplication();
	}
}

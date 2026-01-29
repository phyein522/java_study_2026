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

				JMenu myPageMenu = new JMenu("마이페이지");
				JMenuItem logoutMenuItem = new JMenuItem("로그아웃");
				JMenuItem signOutMenuItem = new JMenuItem("회원탈퇴");
				JMenuItem informationMenuItem = new JMenuItem("회원 정보");	//회원 정보 수정 버튼 포함

				break;
		}
		setJMenuBar(mb);
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
					createMenu(1);
				}
			});
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

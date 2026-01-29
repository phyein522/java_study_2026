package report0127;

import lombok.Getter;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@Getter
public class SchoolApplication extends JFrame {
	ArrayList<StudentForApp> students = new ArrayList<StudentForApp>(0);
	int state = 0;

	public SchoolApplication() {
		setTitle("SchoolApplication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(null);

		createMenu();

		setSize(800, 450);
		setVisible(true);
	}

	public void createMenu() {
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
					if(!StudentForApp.isValid(nameTf.getText(), "name")) {
						JOptionPane.showMessageDialog(null, "이름을 1~100글자 범위로 입력하세요.", "name", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(!StudentForApp.isValid(majorTf.getText(), "major")) {
						JOptionPane.showMessageDialog(null, "학과/전공을 1~100글자 범위로 입력하세요.", "major", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(!StudentForApp.isValid(numberTf.getText(), "number")) {
						JOptionPane.showMessageDialog(null, "학번을 10자리 숫자로 입력하세요.", "number", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(containsStudentNumber(Integer.parseInt(numberTf.getText()))) {
						JOptionPane.showMessageDialog(null, "이미 회원가입된 학번입니다.", "containsStudentNumber", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(!birthTf.getText().isBlank() && !StudentForApp.isValid(birthTf.getText(), "birth")) {
						JOptionPane.showMessageDialog(null, "날짜를 yyyy-MM-dd 형식으로 입력해주세요.", "birth", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(!phoneTf.getText().isBlank() && !StudentForApp.isValid(phoneTf.getText(), "phone")) {
						JOptionPane.showMessageDialog(null, "전화번호를 010-0000-0000 형식으로 입력해주세요.", "phone", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(!emailTf.getText().isBlank() && !StudentForApp.isValid(emailTf.getText(), "email")) {
						JOptionPane.showMessageDialog(null, "이메일을 이메일 형식으로 입력해주세요.", "email", JOptionPane.WARNING_MESSAGE);
						return;
					}
					clearTf();
				}
			});
		}

		public void clearTf() {
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
					String number = numberTf.getText();
					if(!StudentForApp.isValid(number, "number")) {
						JOptionPane.showMessageDialog(null, "학번을 10자리 숫자로 입력하세요.", "number", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(!containsStudentNumber(Integer.parseInt(number))) {
						JOptionPane.showMessageDialog(null, "존재하지 않거나 회원가입 되지 않은 학번입니다.", "containsStudentNumber", JOptionPane.WARNING_MESSAGE);
						return;
					}
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

	public static void main(String[] args) {
		new SchoolApplication();
	}
}

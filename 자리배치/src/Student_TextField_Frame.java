import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.HashSet;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Student_TextField_Frame extends JFrame implements Serializable {
	static JLabel[] label;
	static JTextField[] textField;
	static Student_TextField_Frame textFrame;
	static int total_student;

	public static final long serialVersionUID = 1111111111111111111L;

	final static JMenu completeNameMenu = new JMenu("이름 입력 완료");
	final static JMenuBar Menubar = new JMenuBar();

	static int cnt_method; // 메서드 호출 횟수

	public void SetTextValue() {
		if (cnt_method++ > 0) {
			getContentPane().removeAll();
			revalidate();
			repaint();
		}
		label = new JLabel[total_student];

		for (int i = 0; i < total_student; i++) {
			label[i] = new JLabel(String.valueOf(i + 1) + "번", JLabel.LEFT);
			textField[i] = new JTextField(3);
		}
		for (int i = 0; i < total_student; i++) {
			add(label[i]);
			add(textField[i]);
		}

		revalidate();
		repaint();
	}

	public Student_TextField_Frame() {
		textFrame = this;
		setTitle("Made by rppt");

		setLayout(new GridLayout(0, 6));

		completeNameMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				HashSet<String> set = new HashSet<>();
				for (int i = 0; i < textField.length; i++) {
					set.add(textField[i].getText().trim());
				}
				if (set.size() != total_student) {
					JOptionPane.showMessageDialog(null, "이름이 중복 됨.");
				} else {
					for (int i = 0; i < textField.length; i++) {
						 Main.data.put(i + 1, textField[i].getText().trim());
					}
					FileChooser.filechooser.FileChoose();
				}
				dispose();
			}
		});

		Menubar.add(completeNameMenu);
		setJMenuBar(Menubar);

		pack();
		setResizable(false);
		setSize(new Dimension(500, 500));
		setVisible(false);
	}
}

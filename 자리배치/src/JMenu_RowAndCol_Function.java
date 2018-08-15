
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class JMenu_RowAndCol_Function extends JFrame {

	public static final long serialVersionUID = 1111111111111111111L;// 클래스 버전 아이디
	final static JButton UnderButton = new JButton("Click!");
	private String[] seat_m = new String[3];

	public static JList<String> list = new JList<>();
	private Border border = BorderFactory.createTitledBorder("선택사항");
	private JScrollPane scroll = new JScrollPane();

	static JMenu_RowAndCol_Function this_var;

	public JMenu_RowAndCol_Function() {
		this_var = this;

		seat_m[0] = "5*6";
		seat_m[1] = "5*8";
		seat_m[2] = "6*6";

		UnderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int idx = JMenu_RowAndCol_Function.list.getSelectedIndex();

				if (idx == 0) {
					Main.row = 5;
					Main.column = 6;
				} else if (idx == 1) {
					Main.row = 5;
					Main.column = 8;
				} else if (idx == 2) {
					Main.row = 6;
					Main.column = 6;
				}
				Main.button = new JButton[Main.row * Main.column];

				Main.buttonPanel.setLayout(new GridLayout(Main.row, Main.column, 20, 15));
				Main.buttonPanel.revalidate();
				Main.buttonPanel.repaint();

			    Jlist_Event.ArrangeSeat();
			}
		});
		add(UnderButton, BorderLayout.SOUTH);

		scroll.setViewportView(list);
		scroll.setBorder(border);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setListData(seat_m);
		list.setFont(new Font("ver-3", Font.BOLD, 40));
		list.addMouseListener(new Jlist_Event());

		add(new JLabel("행 * 열(최소한의 경우만 생각함)"), BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);

		setTitle("Select (Row & Column)");
		setLocation(500, 300);
		setPreferredSize(new Dimension(350, 350));
		pack();
		setResizable(false);
		setVisible(false);
	}
}

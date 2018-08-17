
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class JMenu_RowAndCol_Function extends JFrame {
	
	public static final long serialVersionUID = 1111111111111111111L;
	final static JButton UnderButton = new JButton("Click!");
	private String[] seat_m = new String[3];

	public static JList<String> list = new JList<>();
	private Border border = BorderFactory.createTitledBorder("선택사항");
	private JScrollPane scroll = new JScrollPane();

	static JMenu_RowAndCol_Function this_var;

	static int previous_idx;
	static int count;
	
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
					Main.panel = new JPanel[3];
				} else if (idx == 1) {
					Main.row = 5;
					Main.column = 8;
					Main.panel = new JPanel[4];
				} else if (idx == 2) {
					Main.row = 6;
					Main.column = 6;
					Main.panel = new JPanel[3]; 
				}
				previous_idx = idx;
				
				GoToFowardAndBackWard.isModified = true;
				for(int i = 0 ; i<Main.panel.length; i++) {
					Main.panel[i] = new JPanel();
					Main.panel[i].setLayout(new GridLayout(Main.row, 2, 0, 10 ));
				}
			
				Main.button = new JButton[Main.row * Main.column];
				
				
				Main.buttonPanel.setLayout(new GridLayout(1,Main.panel.length,30,0));
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

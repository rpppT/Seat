import java.awt.BorderLayout;
import java.awt.Dimension;
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


public class Jmenu_Students_Input_Num  extends JFrame{
	
	public static final long serialVersionUID = 1111111111111111111L;
	
	final static JButton completeInput = new JButton("Click!");
	final static JLabel label = new JLabel("총 인원");
	final static JList<Integer> list = new JList<>();
	final static JScrollPane scroll = new JScrollPane(list);
	final static Border border = BorderFactory.createTitledBorder("인원선택");
	
	static int cnt_constrcter;//생성자 호출 카운트
	static Jmenu_Students_Input_Num s_input;
	static int total;
	
	int total_people;
	
	
    final static Integer[] population = new Integer[16]; /* max == 40 */
    
	public void  settingPs() {
		for(int i=0; i<population.length; i++)
			population[i] = 2*10+(5+i);
			
	}

	public Jmenu_Students_Input_Num() {
		setTitle("Made by rppt");
		settingPs(); 
			
		   s_input = this;
		   
		   completeInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jmenu_Students_Input_Num.total = (int)list.getSelectedValue();
				Jmenu_StudentsFrame.button[1].setEnabled(true);
				Jmenu_StudentsFrame.dataFrame.revalidate();
				Jmenu_StudentsFrame.dataFrame.repaint();
				Jmenu_Students_Input_Num.s_input.dispose();
			}
		});
		   add(completeInput,BorderLayout.SOUTH);
		   scroll.setViewportView(list);
           scroll.setBorder(border); //경계 설정
           scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //가로바정책

           list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           list.setListData(population);
           list.addMouseListener(new Jmenu_StudentsFrame_MouseListner());
           

           
           add(new JLabel("총 인원 수 <MAX = 40>"), BorderLayout.NORTH);
           add(scroll, BorderLayout.CENTER);
		
         
        
        setLocation(300, 300);
		setPreferredSize(new Dimension(300,300));
		pack();
		setResizable(false);
		
		if(cnt_constrcter++ == 0)
			setVisible(false);	
	}
}

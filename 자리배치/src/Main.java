
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main extends JFrame implements Serializable{
	public static final long serialVersionUID = 1111111111111111111L;//클래스 버전 아이디

	
	public static Main main_frame; //Main클래스 객체 참조변수
	
	public static int row , column; // 행, 열
	
	public static  Map<Integer, String> data = new HashMap<>();//학생 데이터 자료구조 Map
	
	public final static ArrayList<Integer> MouseDraggedDisabledButton = new ArrayList<>();
	
	
	public final static JMenu Screenshot_Menu = new JMenu("스크린샷");
	final static JMenu Recv_Data_Menu = new JMenu("리소스 파일 다운로드");
	final static JMenu Assigned_Seat_Menu = new JMenu("자리 배치");
	final static JMenu Bring_Student_Info_Menu = new JMenu("데이터 가져오기");
	final static JMenu Button_Func_Menu = new JMenu("버튼 다루기");
	final static JMenu Input_Data_Menu = new JMenu("자료 입력");
	final static JMenu goFowarRd_Menu = new JMenu(">");
	final static JMenu goBackward_Menu = new JMenu("<");
	final static JMenu fontConfig_Menu = new JMenu("폰트 수정");
	final static JMenu Auxiliary_Menu = new JMenu("보조 기능");
	
	final static JMenuBar Menubar = new JMenuBar();//메뉴 객체를 담을 메뉴바 객체
	
    static JButton [] button; //학생 이름을 다음 버튼 배열
    static JMenuItem [] input_item = new JMenuItem[2];
    
	static  int font_size = 12;//폰트 크기
	
	
	public static int Stu_SetFrame_Count; //StudentSettingFrame 생성자 호출 카운트

	public  static JPanel imagePanel = new JPanel();//교탁 image를 담을 패널
	public  static JPanel buttonPanel = new JPanel();//학생 버튼을 담을 패널
	
	public static JMenuItem [] chButton_func = new JMenuItem[4];


	public static JLabel image_label;
	
	final static JButton desk = new JButton("교탁");

	static {
		new ChangeFont();
		new View_Task();
		
		Screenshot_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Assigned_Seat_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Bring_Student_Info_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Button_Func_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Recv_Data_Menu.addMouseListener(new JMenu_Mouse_Listner());
		
		Assigned_Seat_Menu.setEnabled(false);
		Bring_Student_Info_Menu.setEnabled(false);
		Button_Func_Menu.setEnabled(false);
		goFowarRd_Menu.setEnabled(false);
		goBackward_Menu.setEnabled(false);
		goFowarRd_Menu.addMouseListener(new JMenu_Mouse_Listner());
		goBackward_Menu.addMouseListener(new JMenu_Mouse_Listner());
		fontConfig_Menu.addMouseListener(new JMenu_Mouse_Listner());
		
		Menubar.add(goBackward_Menu);
		Menubar.add(goFowarRd_Menu);
		Menubar.add(Input_Data_Menu);
		Menubar.add(Bring_Student_Info_Menu);
		Menubar.add(Assigned_Seat_Menu);
		Menubar.add(Button_Func_Menu);
		Menubar.add(fontConfig_Menu);
		Menubar.add(Screenshot_Menu);
		Menubar.add(Auxiliary_Menu);
		
		
//		new Thread(new ScreenShot()).start();
		new ScreenShot();
		new Student_TextField_Frame();
		new JMenu_RowAndCol_Function();
		new FileChooser();
		new Jmenu_Students_Input_Num();
		new Jmenu_StudentsFrame();
	}
		
	public Main() {
		this(new JMenuItem("모든 버튼 활성화"), new JMenuItem("모든 버튼 비활성화")
			, new JMenuItem("행 * 열 입력"), new JMenuItem("학생 데이터 입력")
			,new JMenuItem("시스템 정보"), new JMenuItem("CMD"), new JMenuItem("Shutdown"), new JMenuItem("시스템 정보")
			 ,new JMenuItem("현재 Heap"));
		
		
		setTitle("메인 프레임 (Made by rppt)");
		setLayout(new BorderLayout());
		setJMenuBar(Menubar);
		
		Main.main_frame = this;
	
		buttonPanel.setPreferredSize(new Dimension(500,600));
	    imagePanel.setPreferredSize(new Dimension(250,200-50-10+50));

	    desk.setPreferredSize(new Dimension(170, 150));
	    desk.setFont(new Font("test", Font.BOLD, 30));
	    desk.setBackground(Color.GREEN);
	    imagePanel.add(desk);
//	    desk.addActionListener(new Desk_Colorchange());
	    desk.revalidate();
	    desk.repaint();
	    
	    add(imagePanel, BorderLayout.SOUTH);
	    add(buttonPanel, BorderLayout.NORTH);

	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocation(150, 150);
	    setPreferredSize(new Dimension(850-50, 950+50-10-50-10-50));
	    pack();
		setResizable(false);
		setVisible(true);
	}
	public Main(JMenuItem item1, JMenuItem item2, JMenuItem item3, JMenuItem item4, JMenuItem item5
			   ,JMenuItem item6, JMenuItem item7, JMenuItem item8, JMenuItem item9) {
		item1.addActionListener(new JButton_All_SetEnabled_ActoinLisnter());
		item2.addActionListener(new JButton_All_SetEnabled_ActoinLisnter());
		
		item3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JMenu_RowAndCol_Function.this_var.setVisible(true);
			}
		});
		item4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jmenu_StudentsFrame.dataFrame.setVisible(true);
			}
		});
		
		
		item5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sysinfo().print_info();
			}
		});
		
		item6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("explorer.exe C:\\windows\\system32\\cmd.exe");
				} catch (IOException e2) {
				}				
			}
		});
		
		item7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("shutdown -s -t 1");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
			}
		});
		
		item8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sysinfo().print_info();
			}
		});
		
		Heap_Info heap = new Heap_Info();
		item9.addActionListener(heap);
		new Thread(heap).start();
		
		Auxiliary_Menu.add(item6);
		Auxiliary_Menu.add(item7);
		Auxiliary_Menu.add(item8);
		Auxiliary_Menu.add(item9);
		
		
		chButton_func[0] = item1;
		chButton_func[1] = item2;
		
		
		Button_Func_Menu.add(chButton_func[0]);
		Button_Func_Menu.add(chButton_func[1]);

		
		Input_Data_Menu.add(item3);
		Input_Data_Menu.add(item4);
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
 	public static void main(String[] args) throws Exception {
 		new Main();
	}

}

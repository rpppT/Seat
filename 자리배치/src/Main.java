

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Main extends JFrame implements Serializable{
	public static final long serialVersionUID = 1111111111111111111L;//Ŭ���� ���� ���̵�

	
	public static Main main_frame; //MainŬ���� ��ü ��������
	
	public static int row , column; // ��, ��
	
	public static  Map<Integer, String> data = new HashMap<>();//�л� ������ �ڷᱸ�� Map
	
	public final static ArrayList<Integer> MouseDraggedDisabledButton = new ArrayList<>();
	
	
	public final static JMenu Screenshot_Menu = new JMenu("��ũ����");
	final static JMenu Recv_Data_Menu = new JMenu("���ҽ� ���� �ٿ�ε�");
	final static JMenu Assigned_Seat_Menu = new JMenu("�ڸ� ��ġ");
	final static JMenu Bring_Student_Info_Menu = new JMenu("������ Bring");
	final static JMenu Button_Func_Menu = new JMenu("��ư �ٷ��");
	final static JMenu Manual_Menu= new JMenu("����");
	final static JMenu Input_Data_Menu = new JMenu("�ڷ� �Է�");
	final static JMenu CMD_MENU = new JMenu("CMD(Shell)");
	final static JMenu Shutdown_Menu = new JMenu("Shutdown");
	final static JMenu Sysinfo_Menu = new JMenu("�ý��� ����");
	
	final static JMenuBar Menubar = new JMenuBar();//�޴� ��ü�� ���� �޴��� ��ü
	
    static JButton [] button; //�л� �̸��� ���� ��ư �迭
    static JMenuItem [] input_item = new JMenuItem[2];
    
	static  int font_size = 12;//��Ʈ ũ��
	
	
	public static int Stu_SetFrame_Count; //StudentSettingFrame ������ ȣ�� ī��Ʈ

	public  static JPanel imagePanel = new JPanel();//��Ź image�� ���� �г�
	public  static JPanel buttonPanel = new JPanel();//�л� ��ư�� ���� �г�
	
	public static JMenuItem [] chButton_func = new JMenuItem[4];
    
	private static JPasswordField pwd = new JPasswordField();

	public static JLabel image_label;
	
	static {
		if(!new File(System.getProperty("user.home")+"\\JavaAppData").exists()) {
			JOptionPane.showMessageDialog(null, "�� ���α׷��� �ʿ��� ���ҽ� ���� �� ������ �������� ����!!");
			JOptionPane.showMessageDialog(null, "JavaAppData���ҽ� ���ͳݿ��� �ٿ�޴� ��...");
			
			new GetFileOneTheUrl().downloadFile();
		}
		
		new View_Task();
		
		Screenshot_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Assigned_Seat_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Bring_Student_Info_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Button_Func_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Manual_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Recv_Data_Menu.addMouseListener(new JMenu_Mouse_Listner());
		
		Screenshot_Menu.setEnabled(false);
		Assigned_Seat_Menu.setEnabled(false);
		Bring_Student_Info_Menu.setEnabled(false);
		Button_Func_Menu.setEnabled(false);
		CMD_MENU.addMouseListener(new JMenu_Mouse_Listner());
		Shutdown_Menu.addMouseListener(new JMenu_Mouse_Listner());
		Sysinfo_Menu.addMouseListener(new JMenu_Mouse_Listner());
		
		Menubar.add(Input_Data_Menu);
		Menubar.add(Bring_Student_Info_Menu);
		Menubar.add(Assigned_Seat_Menu);
		Menubar.add(Button_Func_Menu);
		Menubar.add(Manual_Menu);
		Menubar.add(Recv_Data_Menu);
		Menubar.add(Screenshot_Menu);
		Menubar.add(CMD_MENU);
		Menubar.add(Shutdown_Menu);
		Menubar.add(Sysinfo_Menu);
		
		new ScreenShot();
		new Student_TextField_Frame();
		new JMenu_RowAndCol_Function();
		new FileChooser();
		new Jmenu_Students_Input_Num();
		new Jmenu_StudentsFrame();
		
		try {
//			imagePanel.setLayout(new GridLayout(1, 2, 30, 10));
			imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
			BufferedImage deskImage = ImageIO.read(new File(System.getProperty("user.home")+"//JavaAppData//��Ź.png"));
			image_label = new JLabel(new ImageIcon(deskImage));
			imagePanel.add(image_label);
			JButton button = new JButton("��Ʈ ũ��");
			button.addActionListener(new Change_Font_Malloc_ActionListener());
//			button.setLayout(new FlowLayout(FlowLayout.RIGHT, 1000, 30));
//						button.setSize(50,50);    
			button.setPreferredSize(new Dimension(100, 100));
			imagePanel.add(button);
			imagePanel.revalidate();
			imagePanel.repaint();
		} catch (IOException ee) {
		 }
	}
		
	public Main() {
		this(new JMenuItem("��� ��ư Ȱ��ȭ"), new JMenuItem("��� ��ư ��Ȱ��ȭ"),
			 new JMenuItem("��� ��ư ����"), new JMenuItem("��� ��ư ���� ����")
			, new JMenuItem("�� * �� �Է�"), new JMenuItem("�л� ������ �Է�")
			, new JMenuItem("��ư ��Ʈ ����"), new JMenuItem("�ý��� ����"));
		
//		new SystemInformation().print_info();
		
		setTitle("���� ������ (Made by rppt)");
		setLayout(new BorderLayout());
		setJMenuBar(Menubar);
		
		Main.main_frame = this;
		
//		imagePanel.setBackground(Color.BLUE);
//		buttonPanel.setBackground(Color.BLUE);
		
		buttonPanel.setPreferredSize(new Dimension(500,600));
	    imagePanel.setPreferredSize(new Dimension(250,200-50-10+50));
	    
	    
	    add(imagePanel, BorderLayout.SOUTH);
	    add(buttonPanel, BorderLayout.NORTH);
    
//	    new Thread(new ImagePanel_BackGround_Change()).start();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocation(150, 150);
	    setPreferredSize(new Dimension(850-50, 950+50-10-50-10-50));
	    pack();
		setResizable(false);
		setVisible(true);
	}
	public Main(JMenuItem item1, JMenuItem item2, JMenuItem item3, JMenuItem item4, JMenuItem item5
			,JMenuItem item6, JMenuItem item7, JMenuItem item8) {
		item1.addActionListener(new JButton_All_SetEnabled_ActoinLisnter());
		item2.addActionListener(new JButton_All_SetEnabled_ActoinLisnter());
		
//		item3.addActionListener(new JButton_All_Fixed_ActionListner());
//		item4.addActionListener(new JButton_All_Fixed_ActionListner());
		
		item5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JMenu_RowAndCol_Function.this_var.setVisible(true);
//				Main.Bring_Student_Info_Menu.setEnabled(true);
			}
		});
		item6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jmenu_StudentsFrame.dataFrame.setVisible(true);
			}
		});
		
//		item7.addActionListener(new Change_Font_Malloc_ActionListener());
		
		item8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SystemInformation().print_info();
			}
		});
		chButton_func[0] = item1;
		chButton_func[1] = item2;
		
//		chButton_func[2] = item3;
//		chButton_func[3] = item4;
		
		Button_Func_Menu.add(chButton_func[0]);
		Button_Func_Menu.add(chButton_func[1]);
//		
//		Button_Func_Menu.add(chButton_func[2]);
//		Button_Func_Menu.add(chButton_func[3]);
//		
//		Button_Func_Menu.add(item7);
		
		Input_Data_Menu.add(item5);
		Input_Data_Menu.add(item6);
		
//		button
	}
	

 	public static void main(String[] args) throws Exception {
 		new Main();
	}
}

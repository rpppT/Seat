import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Jmenu_Assigned_Seat_Function {
	static int font_size; // 공유하는 폰트 크기 정적 변수
	static boolean isCanFixed ;

	public void Assigend_Seat() {
		
		int i;
		int cnt = 0;
		int len = Main.button.length;
		int size = Main.data.size();
		int randNum = 0;
		int lastIndex = 0;
		int k = 0;
		
		ArrayList<Integer> c = new ArrayList<>();
		ArrayList<Integer> set_index = new ArrayList<>();
		ArrayList<String> set_name = new ArrayList<>();//중복된 이름
		
		HashSet<String> set = new HashSet<>();
		
		
		for(i=0; i<len; i++)
			if(Main.button[i].getText().equals(""))
				cnt++;

		if(cnt != len) {
			cnt = 0;
			for(i=0; i<len; i++) {
				if(Main.button[i].getBackground() == Color.PINK && !Main.button[i].equals("")) {
					cnt++;
				}
			}
			if(cnt == size)
				return;
		}
		cnt = 0;
		
		for (i = 0; i < len; i++)
			if (!Main.button[i].isEnabled())
				cnt++;

		if (size > len - cnt) {
			JOptionPane.showMessageDialog(null, "비활성화 버튼 때문에 학생 데이터를 모두 넣을수 없음!!");
			JOptionPane.showMessageDialog(null, "비활성화 버튼을 해제하거나 더 작은 학생 데이터를 읽어오삼!!");
			return;
		}      

		
		cnt = 0;
		
		for(i=0; i<len; i++)
			if(Main.button[i].getBackground() == Color.PINK)
				cnt++;

		
		cnt = 0;

		for (i = 0; i < len; i++)
			if (Main.button[i].isEnabled() && !Main.button[i].getText().equals("")) {
				cnt++;
				lastIndex = i;
			}

		if (cnt > size)
			for (i = 0; i < cnt - size; i++)
				Main.button[lastIndex - i].setText("");

	  cnt = 0;
	
		for (i = 0; i < len; i++) {

			if (Main.button[i].isEnabled() ) {
				if(Main.button[i].getBackground() == Color.PINK) {
					if(!Main.button[i].getText().equals(""))
						for(int j =1; j<=size; j++)
							if(Main.data.get(j).equals(Main.button[i].getText()))
								c.add(j);
					cnt++;
					continue;
				}
				randNum = (int) (Math.random() * size + 1);
				if (c.isEmpty()) {
					c.add(randNum);
					Main.button[i].setText(Main.data.get(randNum));
					Main.button[i].setFont(new Font("test", Font.BOLD, font_size));
					cnt++;
				} else {
					if (c.contains(randNum)) {
						i -= 1;
						continue;
					}
					Main.button[i].setText(Main.data.get(randNum));
					Main.button[i].setFont(new Font("test", Font.BOLD, font_size));
					c.add(randNum);
					cnt++;
				} // else
				if (cnt == Main.data.size())
					break;
			}
		} // for
		
		
		
		for(i=0; i<len; i++) {
			if(Main.button[i].isEnabled() && !set.add(Main.button[i].getText())) {
				if(Main.button[i].getBackground() == Color.PINK) {
					for(int j=0; j<len; j++) {
						if(Main.button[j].getText().equals(Main.button[i].getText())) {
							if(j == i) {
								continue;
							}else {
								set_index.add(j);
							}
						}
					}
				}
			}
		if(Main.button[i].isEnabled())
			set_name.add(Main.button[i].getText());
		}
			

		
		Collections.sort(set_index);
		
		for(i=1; i<=size; i++) {
			if(!set_name.contains(Main.data.get(i))) {
				Main.button[set_index.get(k++)].setText(Main.data.get(i));
			}
		}	
		cnt = 0;

		for(i=0; i<len; i++)
			if(!Main.button[i].getText().equals("") && Main.button[i].isEnabled())
				cnt++;
		
		
		if(cnt == Main.data.size())
			isCanFixed = true;
		else 
			isCanFixed = false;
		
//		new Joke().joking();
	}
}

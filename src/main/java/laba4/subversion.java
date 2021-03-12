package laba4; //����� Java �������

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //���������� ��� ������� ���������
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*; // ���������� ��� GUI (��������� �� ������ awt)


	public class subversion {
		private String poick = "";

		static JComboBox combo; //��������� JComboBox
		public subversion() {




			JFrame main_GUI = new JFrame("subversion"); // �������� ������������ ����
			main_GUI.setTitle ("Using subversion for developers");
			main_GUI.setBounds(500,400,400,350);
			main_GUI.setResizable(false); // ������������� ������ ����

			JPanel main_panel = new JPanel(); // ������ - ������������ ��� ����������� ����������� � ����
			main_panel.setLayout(null);
			main_GUI.add(main_panel);





			JLabel laba_info = new JLabel("������������ ������ �4"); // ����������� ������ ��� �����������
			laba_info.setBounds(120,0,150,30);
			main_panel.add(laba_info);

			JButton button_exit = new JButton("�����"); // ��������� ������
			button_exit.setBounds(270,240,100,40);
			ActionListener actionListener = new ListenerButton(); //������� ���������
			button_exit.addActionListener(actionListener); // ��������� ��������� � ������
			main_panel.add(button_exit);

			JButton button_info = new JButton("���������� "); // ��������� ������ ����������
			button_info.setBounds(20,240,120,40);
			ActionListener actionListener1 = new ListenerButton(); //������� ���������
			button_exit.addActionListener(actionListener1); // ��������� ��������� � ������
			main_panel.add(button_info);
			button_info.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(main_GUI, poick + "1. ��������(12.03.2021). ����� �� -19130625\n2. ������������ (12/03/2021). ����� �� - 19170028\n3. �������(12.03.2021). ����� �� - 19130168\n4. ��������.(12.03.2021) ����� �� - 19130616","������ � ����������", -1); }
			});

			// ��������� ���������� ����, ������� ������� ��� � ������ �������� ������ ����������
			JLabel dannie = new JLabel("������� ������ �����"); // ����������� ������ ��� �����������
			dannie.setBounds(0,145,150,30);
			main_panel.add(dannie);
			JTextField vvod = new JTextField();
			vvod.setBounds(10,170,100,30);
			main_panel.add(vvod);
			JButton vivod = new JButton("��������� "); // ��������� ������ ����������
			vivod.setBounds(130,170,140,30);
			ActionListener actionListener13 = new ListenerButton(); //������� ���������
			vivod.addActionListener(actionListener13); // ��������� ��������� � ������
			main_panel.add(vivod);
			vivod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			double r = Double.parseDouble(vvod.getText());
			double per = 2*r*Math.PI;
			String result = String.format("%.1f",per);
			
			JOptionPane.showMessageDialog(vivod, "�������� ����� ����������:  "+ result,"���������� ���������", -1);
			}
				   });
			JLabel button_logotype = new JLabel("");//��������� JLabel
			JMenuBar bar = new JMenuBar(); // ������� JMenuBar
			main_GUI.setJMenuBar(bar); // ��������� JMenuBar � ����������� ����
			JMenu Menu = new JMenu("����"); // ������� ������ "����"
			JMenuItem logotype = new JMenuItem("���������� ������� �����"); // ������� ������ "���������� ������� �����" � ����
			JMenuItem exit = new JMenuItem("�����"); // ������� ������ "�����" � ����
			JMenuItem zagruzka = new JMenuItem("��������� ���� � ������4");// ������� ����� ������
			zagruzka.addActionListener(new ListenerButton() {

				@Override
				public void actionPerformed(ActionEvent e) {
					poick = "";
					JFileChooser fileopen = new JFileChooser();
					int ret = fileopen.showDialog(null, "������� ����");
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = fileopen.getSelectedFile();
						FileReader fr = null;
						BufferedReader br = null;
						try {
							fr = new FileReader(file);
							br = new BufferedReader(fr);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						String line;
						try {
							while((line = br.readLine()) != null){
								poick = poick + line + "\n";
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							br.close();
							fr.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});




			class ListenerLogo implements ActionListener {

				@Override // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

					main_panel.add(button_logotype); // ��������� Label �� ������
					File currentDirFile = new File("src/main/java/laba4/logo.jpg");
					String pict = currentDirFile.getAbsolutePath();//��������� �������
					button_logotype.setBounds(220,30,150,120); // ������ ������������ ���� � ������ ��������
					button_logotype.setIcon(new ImageIcon(pict));

				}


			}
 
			exit.addActionListener(actionListener); // ��������� ��������� � ������ �����

			ActionListener logo = new ListenerLogo(); //������� ��������� ��� ������ ���������� ������� �����
			logotype.addActionListener(logo); // ��������� ��������� � ������ ���������� ������� �����

			bar.add(Menu); //��������� ������ "����" JMenuBar
			Menu.add(logotype); //��������� ������ "���������� ������� �����" � ����
			Menu.add(zagruzka); //��������� ������
			Menu.add(exit); //��������� ������ "�����" � ����

			String[] items = { //��������� ������ ������
					"����������� ������� ����� � ������� ������ ����",
					"����������� ������� ����� � ��������",
					"����������� ������� ����� � ����� ������� ����",
					"������������� ������ � �������4"
			};

			class combo implements ActionListener {

				@Override // �������� �����, ������� ��������� � �������� ������ ������ ������� ���������� ������ ������������� ������
				public void actionPerformed(ActionEvent e)
				{
					if (e.getSource() == combo) { //��������� ��������� JComboBox
						main_panel.remove(button_logotype);
						if (combo.getSelectedItem()=="����������� ������� ����� � ������� ������ ����") {

							main_panel.add(button_logotype); // ��������� Label � ������
							// ������ ������������ ���� � ������ ��������
							File currentDirFile = new File("src/main/java/laba4/logo.jpg");
							String pict = currentDirFile.getAbsolutePath();//��������� �������
							button_logotype.setBounds(220,30,150,120); // ������ ������������ ���� � ������ ��������
							button_logotype.setIcon(new ImageIcon(pict));
						}
						if (combo.getSelectedItem()=="����������� ������� ����� � ��������") {

							main_panel.add(button_logotype); // ��������� Label � ������
							// ������ ������������ ���� � ������ ��������
							File currentDirFile = new File("src/main/java/laba4/logo.jpg");
							String pict = currentDirFile.getAbsolutePath();//��������� ������� //; //��������� ������� //
							button_logotype.setBounds(110,30,150,120); // ������ ������������ ���� � ������ ��������
							button_logotype.setIcon(new ImageIcon(pict));
						}
						if (combo.getSelectedItem()=="����������� ������� ����� � ����� ������� ����") {

							main_panel.add(button_logotype); // ��������� Label �� ������
							// ��������� ���� � ������ ��������
							File currentDirFile = new File("src/main/java/laba4/logo.jpg");
							String pict = currentDirFile.getAbsolutePath();//��������� ������� //; //��������� ������� //
							button_logotype.setBounds(22,30,150,120); // ������ ������������ ���� � ������ ��������
							button_logotype.setIcon(new ImageIcon(pict));
						}
					}
				}
			}
			combo = new JComboBox(items); // ����������� �������� JComboBox
			combo.setBounds(50,210,310,20); // ������ ������� JComboBox
			ActionListener c = new combo(); // �������� ���������
			combo.addActionListener(c); // ��������� ��������� � JComboBox
			main_panel.add(combo); // ��������� JComboBox �� ������� ������
			main_GUI.setVisible(true);

			main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� JFrame � �������� Java
		}




		public static void main(String[] args) { // ���������� �������: http://www.mstu.edu.ru/study/materials/java/
			subversion student= new subversion();

		}

	}

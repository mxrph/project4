package laba4; //пакет Java классов

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //библиотека для события слушателя
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*; // Библиотека для GUI (построена на основе awt)


	public class subversion {
		private String poick = "";

		static JComboBox combo; //добавляем JComboBox
		public subversion() {




			JFrame main_GUI = new JFrame("subversion"); // создание графического окна
			main_GUI.setTitle ("Using subversion for developers");
			main_GUI.setBounds(500,400,400,350);
			main_GUI.setResizable(false); // фиксированный размер окна

			JPanel main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
			main_panel.setLayout(null);
			main_GUI.add(main_panel);





			JLabel laba_info = new JLabel("Лабораторная работа №4"); // Отображение текста или изображения
			laba_info.setBounds(120,0,150,30);
			main_panel.add(laba_info);

			JButton button_exit = new JButton("Выход"); // добавляем кнопку
			button_exit.setBounds(270,240,100,40);
			ActionListener actionListener = new ListenerButton(); //создаем слушатель
			button_exit.addActionListener(actionListener); // добавляем слушатель к кнопке
			main_panel.add(button_exit);

			JButton button_info = new JButton("Информация "); // добавляем кнопку Информация
			button_info.setBounds(20,240,120,40);
			ActionListener actionListener1 = new ListenerButton(); //создаем слушатель
			button_exit.addActionListener(actionListener1); // добавляем слушатель к кнопке
			main_panel.add(button_info);
			button_info.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(main_GUI, poick + "1. Самсонов(12.03.2021). Номер ЗЧ -19130625\n2. Фахретдинова (12/03/2021). Номер ЗЧ - 19170028\n3. Шейфель(12.03.2021). Номер ЗЧ - 19130168\n4. Степанян.(12.03.2021) Номер ЗЧ - 19130616","Данные о участниках", -1); }
			});

			// добавляем диалоговое окно, которое выводит ФИО и номера зачетных книжек участников
			JLabel dannie = new JLabel("Введите радиус круга"); // Отображение текста или изображения
			dannie.setBounds(0,145,150,30);
			main_panel.add(dannie);
			JTextField vvod = new JTextField();
			vvod.setBounds(10,170,100,30);
			main_panel.add(vvod);
			JButton vivod = new JButton("Вычислить "); // добавляем кнопку Информация
			vivod.setBounds(130,170,140,30);
			ActionListener actionListener13 = new ListenerButton(); //создаем слушатель
			vivod.addActionListener(actionListener13); // добавляем слушатель к кнопке
			main_panel.add(vivod);
			vivod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			double r = Double.parseDouble(vvod.getText());
			double per = 2*r*Math.PI;
			String result = String.format("%.1f",per);
			
			JOptionPane.showMessageDialog(vivod, "Периметр круга составляет:  "+ result,"Результаты подсчётов", -1);
			}
				   });
			JLabel button_logotype = new JLabel("");//добавляем JLabel
			JMenuBar bar = new JMenuBar(); // создаем JMenuBar
			main_GUI.setJMenuBar(bar); // добавляем JMenuBar в графическое окно
			JMenu Menu = new JMenu("Меню"); // создаем кнопку "Меню"
			JMenuItem logotype = new JMenuItem("Отобразить логотип УГАТУ"); // создаем кнопку "Отобразить логотип УГАТУ" в меню
			JMenuItem exit = new JMenuItem("Выход"); // создаем кнопку "Выход" в меню
			JMenuItem zagruzka = new JMenuItem("Загрузить файл в проект4");// создаем новую кнопку
			zagruzka.addActionListener(new ListenerButton() {

				@Override
				public void actionPerformed(ActionEvent e) {
					poick = "";
					JFileChooser fileopen = new JFileChooser();
					int ret = fileopen.showDialog(null, "Открыть файл");
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

				@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

					main_panel.add(button_logotype); // вставляем Label на панель
					File currentDirFile = new File("src/main/java/laba4/logo.jpg");
					String pict = currentDirFile.getAbsolutePath();//вставляем логотип
					button_logotype.setBounds(220,30,150,120); // задаем расположение окна и размер логотипа
					button_logotype.setIcon(new ImageIcon(pict));

				}


			}
 
			exit.addActionListener(actionListener); // добавляем слушатель к кнопке Выход

			ActionListener logo = new ListenerLogo(); //создаем слушатель для кнопки Отобразить логотип УГАТУ
			logotype.addActionListener(logo); // добавляем слушатель к кнопке Отобразить логотип УГАТУ

			bar.add(Menu); //добавляем кнопку "Меню" JMenuBar
			Menu.add(logotype); //Добавляем кнопку "Отобразить логотип УГАТУ" в меню
			Menu.add(zagruzka); //Добавляем кнопку
			Menu.add(exit); //добавляем кнопку "Выход" в меню

			String[] items = { //добавляем массив данных
					"Переместить логотип УГАТУ в верхний правый угол",
					"Переместить логотип УГАТУ в середину",
					"Переместить логотип УГАТУ в левый верхний угол",
					"Отсортировать данные в проекте4"
			};

			class combo implements ActionListener {

				@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
				public void actionPerformed(ActionEvent e)
				{
					if (e.getSource() == combo) { //проверяем изменение JComboBox
						main_panel.remove(button_logotype);
						if (combo.getSelectedItem()=="Переместить логотип УГАТУ в верхний правый угол") {

							main_panel.add(button_logotype); // вставляем Label в панель
							// задаем расположение окна и размер логотипа
							File currentDirFile = new File("src/main/java/laba4/logo.jpg");
							String pict = currentDirFile.getAbsolutePath();//вставляем логотип
							button_logotype.setBounds(220,30,150,120); // задаем расположение окна и размер логотипа
							button_logotype.setIcon(new ImageIcon(pict));
						}
						if (combo.getSelectedItem()=="Переместить логотип УГАТУ в середину") {

							main_panel.add(button_logotype); // вставляем Label в панель
							// задаем расположение окна и размер логотипа
							File currentDirFile = new File("src/main/java/laba4/logo.jpg");
							String pict = currentDirFile.getAbsolutePath();//вставляем логотип //; //вставляем логотип //
							button_logotype.setBounds(110,30,150,120); // задаем расположение окна и размер логотипа
							button_logotype.setIcon(new ImageIcon(pict));
						}
						if (combo.getSelectedItem()=="Переместить логотип УГАТУ в левый верхний угол") {

							main_panel.add(button_logotype); // вставляем Label на панель
							// Положение окна и размер логотипа
							File currentDirFile = new File("src/main/java/laba4/logo.jpg");
							String pict = currentDirFile.getAbsolutePath();//вставляем логотип //; //вставляем логотип //
							button_logotype.setBounds(22,30,150,120); // задаем расположение окна и размер логотипа
							button_logotype.setIcon(new ImageIcon(pict));
						}
					}
				}
			}
			combo = new JComboBox(items); // присваиваем значения JComboBox
			combo.setBounds(50,210,310,20); // задаем размеры JComboBox
			ActionListener c = new combo(); // создание слушателя
			combo.addActionListener(c); // добавляем слушатель к JComboBox
			main_panel.add(combo); // добавляем JComboBox на главную панель
			main_GUI.setVisible(true);

			main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java
		}




		public static void main(String[] args) { // интересные заметки: http://www.mstu.edu.ru/study/materials/java/
			subversion student= new subversion();

		}

	}

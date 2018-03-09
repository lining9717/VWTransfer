import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainView extends JFrame {
	private javax.swing.JPanel VoiceToWords;
	private javax.swing.JPanel WordsToVoice;
	private javax.swing.JTabbedPane jTabbedPanel;

	public MainView() {
		initComponents();
		setTitle("�ƴ�Ѷ���������ֻ�ת");
		setBounds(300, 100, 667, 431);
		setResizable(false);
		setVisible(true);
	}

	private void initComponents() {
		jTabbedPanel = new javax.swing.JTabbedPane();
		WordsToVoice = new WordsToVoice();
		VoiceToWords = new VoiceToWords();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jTabbedPanel.addTab("����ģ��", WordsToVoice);
		jTabbedPanel.addTab("����ʶ��", VoiceToWords);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPanel));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPanel));
		pack();
	}
	
	
}

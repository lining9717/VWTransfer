import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainView extends JFrame {
	private javax.swing.JPanel VoiceToWords;
	private javax.swing.JPanel WordsToVoice;
	private javax.swing.JTabbedPane jTabbedPanel;

	public MainView() {
		initComponents();
		setTitle("科大讯飞语音文字互转");
		setBounds(300, 100, 667, 431);
		setResizable(false);
		setVisible(true);
	}

	private void initComponents() {
		jTabbedPanel = new javax.swing.JTabbedPane();
		WordsToVoice = new WordsToVoice();
		VoiceToWords = new VoiceToWords();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jTabbedPanel.addTab("语音模拟", WordsToVoice);
		jTabbedPanel.addTab("语音识别", VoiceToWords);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPanel));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPanel));
		pack();
	}
	
	
}

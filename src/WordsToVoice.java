import javax.swing.*;

@SuppressWarnings("serial")
public class WordsToVoice extends JPanel {
	private javax.swing.JButton jButton_startplay;
	private javax.swing.JButton jButton_pauseplay;
	private javax.swing.JButton jButton_stopplay;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea_WrodsToVoice;
	private boolean flag = true;

	public WordsToVoice() {
		// TODO Auto-generated constructor stub
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea_WrodsToVoice = new javax.swing.JTextArea();
		jButton_startplay = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jButton_pauseplay = new javax.swing.JButton();
		jButton_stopplay = new javax.swing.JButton();

		jTextArea_WrodsToVoice.setColumns(20);
		jTextArea_WrodsToVoice.setRows(5);
		jTextArea_WrodsToVoice.setLineWrap(true);
		jTextArea_WrodsToVoice.setWrapStyleWord(true);
		jScrollPane1.setViewportView(jTextArea_WrodsToVoice);

		jButton_startplay.setText("播放");
		jButton_startplay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_startplayActionPerformed(evt);
			}
		});

		jButton_pauseplay.setText("暂停");
		jButton_pauseplay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_pauseplayActionPerformed(evt);
			}
		});

		jButton_stopplay.setText("停止");
		jButton_stopplay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_stopplayActionPerformed(evt);
			}
		});

		jButton_pauseplay.setEnabled(false);
		jButton_stopplay.setEnabled(false);

		jLabel1.setText("文字转语音");
		javax.swing.GroupLayout WordsToVoiceLayout = new javax.swing.GroupLayout(this);
		this.setLayout(WordsToVoiceLayout);
		WordsToVoiceLayout.setHorizontalGroup(WordsToVoiceLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(WordsToVoiceLayout.createSequentialGroup().addGap(90, 90, 90)
						.addGroup(WordsToVoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1)
								.addGroup(WordsToVoiceLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(WordsToVoiceLayout.createSequentialGroup()
												.addComponent(jButton_startplay, javax.swing.GroupLayout.PREFERRED_SIZE,
														80, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(122, 122, 122)
												.addComponent(jButton_pauseplay, javax.swing.GroupLayout.PREFERRED_SIZE,
														80, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jButton_stopplay, javax.swing.GroupLayout.PREFERRED_SIZE,
														80, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(88, Short.MAX_VALUE)));
		WordsToVoiceLayout.setVerticalGroup(WordsToVoiceLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(WordsToVoiceLayout.createSequentialGroup().addGap(35, 35, 35).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(WordsToVoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton_startplay).addComponent(jButton_pauseplay)
								.addComponent(jButton_stopplay))
						.addContainerGap(63, Short.MAX_VALUE)));
		// 初始化文字转语音的SpeechSynthesizer对象
		WtoV.init();
	}

	// 文字转语音播放
	private void jButton_startplayActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (flag) {
			String str = jTextArea_WrodsToVoice.getText().toString();
			// 开始播放
			WtoV.startplay(str);
			jButton_pauseplay.setEnabled(true);
			jButton_stopplay.setEnabled(true);
			jButton_startplay.setEnabled(false);
			flag = false;
		} else {
			WtoV.continueplay();
			jButton_startplay.setEnabled(false);
			jButton_pauseplay.setEnabled(true);
			jButton_stopplay.setEnabled(true);
			flag = true;
		}

	}

	private void jButton_pauseplayActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		WtoV.pauseplay();
		jButton_startplay.setEnabled(true);
		jButton_pauseplay.setEnabled(false);
	}

	private void jButton_stopplayActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		WtoV.stopplay();
		jButton_startplay.setEnabled(true);
		jButton_pauseplay.setEnabled(false);
		jButton_stopplay.setEnabled(false);
		flag = true;
	}

}

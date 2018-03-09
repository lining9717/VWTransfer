import javax.swing.*;

@SuppressWarnings("serial")
public class VoiceToWords extends JPanel {
	private javax.swing.JButton jButton_begin;
	private javax.swing.JButton jButton_stop;
	private javax.swing.JButton jButton_clear;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane2;
	private static javax.swing.JTextArea jTextArea_VoiceToWords;

	public VoiceToWords() {
		// TODO Auto-generated constructor stub
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea_VoiceToWords = new javax.swing.JTextArea();
		jLabel2 = new javax.swing.JLabel();
		jButton_begin = new javax.swing.JButton();
		jButton_stop = new javax.swing.JButton();
		jButton_clear = new javax.swing.JButton();

		jTextArea_VoiceToWords.setColumns(20);
		jTextArea_VoiceToWords.setRows(5);
		jTextArea_VoiceToWords.setLineWrap(true);
		jTextArea_VoiceToWords.setWrapStyleWord(true);
		jScrollPane2.setViewportView(jTextArea_VoiceToWords);

		jLabel2.setText("语音转文字");

		jButton_begin.setText("开始录制");
		jButton_begin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_beginActionPerformed(evt);
			}
		});

		jButton_stop.setText("结束录制");
		jButton_stop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_stopActionPerformed(evt);
			}
		});

		jButton_clear.setText("清空");
		jButton_clear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_clearActionPerformed(evt);
			}
		});

		jButton_stop.setEnabled(false);
		jTextArea_VoiceToWords.setEditable(false);

		javax.swing.GroupLayout VoiceToWordsLayout = new javax.swing.GroupLayout(this);
		this.setLayout(VoiceToWordsLayout);
		VoiceToWordsLayout.setHorizontalGroup(VoiceToWordsLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(VoiceToWordsLayout.createSequentialGroup().addGap(90, 90, 90)
						.addGroup(VoiceToWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2)
								.addGroup(VoiceToWordsLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(VoiceToWordsLayout.createSequentialGroup().addComponent(jButton_begin)
												.addGap(119, 119, 119).addComponent(jButton_stop)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jButton_clear))
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 482,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(90, Short.MAX_VALUE)));
		VoiceToWordsLayout.setVerticalGroup(VoiceToWordsLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(VoiceToWordsLayout.createSequentialGroup().addGap(35, 35, 35).addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(VoiceToWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton_begin).addComponent(jButton_stop).addComponent(jButton_clear))
						.addContainerGap(63, Short.MAX_VALUE)));
		VtoW.init();
	}

	private void jButton_beginActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		VtoW.startListening();
		jButton_stop.setEnabled(true);
		jButton_begin.setEnabled(false);
	}

	private void jButton_stopActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		VtoW.stopListening();
		jButton_stop.setEnabled(false);
		jButton_begin.setEnabled(true);
	}

	private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		jTextArea_VoiceToWords.setText("");
	}

	public static void addText(String text) {
		jTextArea_VoiceToWords.append(text);
	}

}

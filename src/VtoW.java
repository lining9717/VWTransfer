import com.iflytek.cloud.speech.*;

public class VtoW {
	private static SpeechRecognizer mIat;
	private static String text;
	private static RecognizerListener mRecoListener = new RecognizerListener() {
		// ��д����ص��ӿ�(����Json��ʽ������û��ɲμ���¼)��
		// һ������»�ͨ��onResults�ӿڶ�η��ؽ����������ʶ�������Ƕ�ν�����ۼӣ�
		// ���ڽ���Json�Ĵ���ɲμ�MscDemo��JsonParser�ࣻ
		// isLast����trueʱ�Ự������
		public void onResult(RecognizerResult results, boolean isLast) {
			text = results.getResultString();
			VoiceToWords.addText(JsonParser.parseGrammarResult(text));
		}

		// �Ự��������ص��ӿ�
		public void onError(SpeechError error) {
			System.out.println("����" + error.getErrorCode() + "  " + error.getErrorDesc()); // ��ȡ����������
		}

		// ��ʼ¼��
		public void onBeginOfSpeech() {
		}

		// ����ֵ0~30
		public void onVolumeChanged(int volume) {
		}

		// ����¼��
		public void onEndOfSpeech() {
		}

		// ��չ�ýӿ�
		public void onEvent(int eventType, int arg1, int arg2, String msg) {
		}
	};

	public static void init() {
		mIat = SpeechRecognizer.createRecognizer();
		SpeechUtility.createUtility(SpeechConstant.APPID + "=5a3ba1f8");
		// 2.������д�����������MSC Reference Manual��SpeechConstant��
		mIat.setParameter(SpeechConstant.DOMAIN, "iat");
		mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
		mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");
	}

	public static void startListening() {
		mIat.startListening(mRecoListener);
	}

	public static void stopListening() {
		mIat.stopListening();
	}
}

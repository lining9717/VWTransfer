import com.iflytek.cloud.speech.*;
public class WtoV {
	private static SpeechSynthesizer mTts;
	// �ϳɼ�����
	private static SynthesizerListener mSynListener = new SynthesizerListener() {
		// �Ự�����ص��ӿڣ�û�д���ʱ��errorΪnull
		public void onCompleted(SpeechError error) {
		}
		// ������Ȼص�
		// percentΪ�������0~100��beginPosΪ������Ƶ���ı��п�ʼλ�ã�endPos��ʾ������Ƶ���ı��н���λ�ã�infoΪ������Ϣ��
		public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
		}

		// ��ʼ����
		public void onSpeakBegin() {
		}

		// ��ͣ����
		public void onSpeakPaused() {
		}

		// ���Ž��Ȼص�
		// percentΪ���Ž���0~100,beginPosΪ������Ƶ���ı��п�ʼλ�ã�endPos��ʾ������Ƶ���ı��н���λ��.
		public void onSpeakProgress(int percent, int beginPos, int endPos) {
		}

		// �ָ����Żص��ӿ�
		public void onSpeakResumed() {
		}

		@Override
		public void onEvent(int arg0, int arg1, int arg2, int arg3, Object arg4, Object arg5) {
		}
	};

	public static void init() {
		// 1.����SpeechSynthesizer����
		mTts = SpeechSynthesizer.createSynthesizer();
		SpeechUtility.createUtility(SpeechConstant.APPID + "=5a3ba1f8");
		// 2.�ϳɲ������ã������MSC Reference Manual��SpeechSynthesizer ��
		mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");// ���÷�����
		mTts.setParameter(SpeechConstant.SPEED, "10");// ��������0~100
		mTts.setParameter(SpeechConstant.VOLUME, "80");// ������������Χ0~100
	}
	// ��ʼ����
	public static void startplay(String str) {
		mTts.startSpeaking(str, mSynListener);
	}

	// ��ͣ����
	public static void pauseplay() {
		mTts.pauseSpeaking();
	}
	// �ָ�����
	public static void continueplay() {
		mTts.resumeSpeaking();
	}
	// ֹͣ����
	public static void stopplay() {
		mTts.stopSpeaking();
	}
}

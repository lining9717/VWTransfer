import com.iflytek.cloud.speech.*;
public class WtoV {
	private static SpeechSynthesizer mTts;
	// 合成监听器
	private static SynthesizerListener mSynListener = new SynthesizerListener() {
		// 会话结束回调接口，没有错误时，error为null
		public void onCompleted(SpeechError error) {
		}
		// 缓冲进度回调
		// percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
		public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
		}

		// 开始播放
		public void onSpeakBegin() {
		}

		// 暂停播放
		public void onSpeakPaused() {
		}

		// 播放进度回调
		// percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
		public void onSpeakProgress(int percent, int beginPos, int endPos) {
		}

		// 恢复播放回调接口
		public void onSpeakResumed() {
		}

		@Override
		public void onEvent(int arg0, int arg1, int arg2, int arg3, Object arg4, Object arg5) {
		}
	};

	public static void init() {
		// 1.创建SpeechSynthesizer对象
		mTts = SpeechSynthesizer.createSynthesizer();
		SpeechUtility.createUtility(SpeechConstant.APPID + "=5a3ba1f8");
		// 2.合成参数设置，详见《MSC Reference Manual》SpeechSynthesizer 类
		mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");// 设置发音人
		mTts.setParameter(SpeechConstant.SPEED, "10");// 设置语速0~100
		mTts.setParameter(SpeechConstant.VOLUME, "80");// 设置音量，范围0~100
	}
	// 开始播放
	public static void startplay(String str) {
		mTts.startSpeaking(str, mSynListener);
	}

	// 暂停播放
	public static void pauseplay() {
		mTts.pauseSpeaking();
	}
	// 恢复播放
	public static void continueplay() {
		mTts.resumeSpeaking();
	}
	// 停止播放
	public static void stopplay() {
		mTts.stopSpeaking();
	}
}

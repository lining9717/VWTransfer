import com.iflytek.cloud.speech.*;

public class VtoW {
	private static SpeechRecognizer mIat;
	private static String text;
	private static RecognizerListener mRecoListener = new RecognizerListener() {
		// 听写结果回调接口(返回Json格式结果，用户可参见附录)；
		// 一般情况下会通过onResults接口多次返回结果，完整的识别内容是多次结果的累加；
		// 关于解析Json的代码可参见MscDemo中JsonParser类；
		// isLast等于true时会话结束。
		public void onResult(RecognizerResult results, boolean isLast) {
			text = results.getResultString();
			VoiceToWords.addText(JsonParser.parseGrammarResult(text));
		}

		// 会话发生错误回调接口
		public void onError(SpeechError error) {
			System.out.println("错误" + error.getErrorCode() + "  " + error.getErrorDesc()); // 获取错误码描述
		}

		// 开始录音
		public void onBeginOfSpeech() {
		}

		// 音量值0~30
		public void onVolumeChanged(int volume) {
		}

		// 结束录音
		public void onEndOfSpeech() {
		}

		// 扩展用接口
		public void onEvent(int eventType, int arg1, int arg2, String msg) {
		}
	};

	public static void init() {
		mIat = SpeechRecognizer.createRecognizer();
		SpeechUtility.createUtility(SpeechConstant.APPID + "=5a3ba1f8");
		// 2.设置听写参数，详见《MSC Reference Manual》SpeechConstant类
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

package android.support.v4.speech.tts;

import android.speech.tts.UtteranceProgressListener;

static final class TextToSpeechICSMR1$1 extends UtteranceProgressListener {
    final /* synthetic */ UtteranceProgressListenerICSMR1 val$listener;
    
    TextToSpeechICSMR1$1(final UtteranceProgressListenerICSMR1 val$listener) {
        this.val$listener = val$listener;
        super();
    }
    
    public void onDone(final String s) {
        val$listener.onDone(s);
    }
    
    public void onError(final String s) {
        val$listener.onError(s);
    }
    
    public void onStart(final String s) {
        val$listener.onStart(s);
    }
}
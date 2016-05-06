package android.support.v4.speech.tts;

import android.speech.tts.TextToSpeech$OnUtteranceCompletedListener;

static final class TextToSpeechICSMR1$2 implements TextToSpeech$OnUtteranceCompletedListener {
    final /* synthetic */ UtteranceProgressListenerICSMR1 val$listener;
    
    TextToSpeechICSMR1$2(final UtteranceProgressListenerICSMR1 val$listener) {
        this.val$listener = val$listener;
        super();
    }
    
    public void onUtteranceCompleted(final String s) {
        val$listener.onStart(s);
        val$listener.onDone(s);
    }
}
package com.example.dell.firstcry.Activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.example.dell.firstcry.R;
import net.gotev.speech.GoogleVoiceTypingDisabledException;
import net.gotev.speech.Speech;
import net.gotev.speech.SpeechDelegate;
import net.gotev.speech.SpeechRecognitionNotAvailable;
import java.util.List;

public class VoiceToText extends Activity {
    private final int MY_PERMISSIONS_RECORD_AUDIO = 1;
    EditText et_voice_to_text;
    ImageButton ib_mic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_to_text);
        et_voice_to_text = findViewById(R.id.et_voice_to_text);
        ib_mic = findViewById(R.id.iv_mic);
        et_voice_to_text.setFocusable(false);
        checkPermission();
        Speech.init(this, getPackageName());
        ib_mic.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // button pressed
                    et_voice_to_text.setText("");
                    et_voice_to_text.setHint("Listening...");
                    startSpeech();
                }
                if (event.getAction() == MotionEvent.ACTION_UP){
                   /* et_voice_to_text.setText("");
                    et_voice_to_text.setHint("try");*/
                }
                return false;
            }

        });

    }

    void checkPermission(){
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.RECORD_AUDIO)
                    != PackageManager.PERMISSION_GRANTED) {

                //When permission is not granted by user, show them message why this permission is needed.
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.RECORD_AUDIO)) {
                    Toast.makeText(this, "Please grant permissions to record audio", Toast.LENGTH_LONG).show();

                    //Give user option to still opt-in the permissions
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.RECORD_AUDIO},
                            MY_PERMISSIONS_RECORD_AUDIO);

                } else {
                    // Show user dialog to grant permission to record audio
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.RECORD_AUDIO},
                            MY_PERMISSIONS_RECORD_AUDIO);
                }
            }
            //If permission is granted, then go ahead recording audio
            else if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.RECORD_AUDIO)
                    == PackageManager.PERMISSION_GRANTED) {
                //Go ahead with recording audio now
            }
    }
    //Handling callback
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_RECORD_AUDIO: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "Permissions Denied to record audio", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
    @Override
    protected void onDestroy() {
        // prevent memory leaks when activity is destroyed
        super.onDestroy();
        Speech.getInstance().shutdown();
    }

    void startSpeech(){
        try {
            // you must have android.permission.RECORD_AUDIO granted at this point
            Speech.getInstance().startListening(new SpeechDelegate() {
                @Override
                public void onStartOfSpeech() {
                    Log.i("speech", "speech recognition is now active");
                }

                @Override
                public void onSpeechRmsChanged(float value) {
                    Log.d("speech", "rms is now: " + value);
                }

                @Override
                public void onSpeechPartialResults(List<String> results) {
                    StringBuilder str = new StringBuilder();
                    for (String res : results) {
                        str.append(res).append(" ");
                    }
                    et_voice_to_text.setText(str.toString().trim());
                    Log.i("speech", "partial result: " + str.toString().trim());
                }

                @Override
                public void onSpeechResult(String result)
                {
                   //et_voice_to_text.setText(result);
                }
            });
        } catch (SpeechRecognitionNotAvailable exc) {
            Log.e("speech", "Speech recognition is not available on this device!");
            // You can prompt the user if he wants to install Google App to have
            // speech recognition, and then you can simply call:
            //
            // SpeechUtil.redirectUserToGoogleAppOnPlayStore(this);
            //
            // to redirect the user to the Google App page on Play Store
        } catch (GoogleVoiceTypingDisabledException exc) {
            Log.e("speech", "Google voice typing must be enabled!");
        }
    }
}

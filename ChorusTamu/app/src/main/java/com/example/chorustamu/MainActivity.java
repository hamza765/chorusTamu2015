package com.example.chorustamu;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chorustamu.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;

import android.os.Bundle;
import android.os.Environment;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    Button p1, p2, p3, p4, stop,stop2,stop3,stop4, play, play2, play3, play4, full, aca;
    private MediaRecorder myAudioRecorder;
    private MediaRecorder myAudioRecorder2;
    private MediaRecorder myAudioRecorder3;
    private MediaRecorder myAudioRecorder4;
    private String outputFile = null;
    private String outputFile2 = null;
    private String outputFile3 = null;
    private String outputFile4 = null;
    private MediaPlayer a;
    private MediaPlayer a2;
    private MediaPlayer a3;
    private MediaPlayer a4;
    private MediaPlayer FullSong;
    String[] songs;
    public int currentSong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.button3);
        play2 = (Button) findViewById(R.id.button10);
        play3 = (Button) findViewById(R.id.button11);
        play4 = (Button) findViewById(R.id.button12);
        stop = (Button) findViewById(R.id.button2);
        stop2 = (Button) findViewById(R.id.button7);
        stop3 = (Button) findViewById(R.id.button8);
        stop4 = (Button) findViewById(R.id.button9);
        p1 = (Button) findViewById(R.id.button);
        p2 = (Button) findViewById(R.id.button4);
        p3 = (Button) findViewById(R.id.button5);
        p4 = (Button) findViewById(R.id.button6);
        aca = (Button) findViewById(R.id.button13);
        full = (Button) findViewById(R.id.button14);


        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.wav";
        outputFile2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording2.wav";
        outputFile3 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording3.wav";
        outputFile4 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording4.wav";
        songs = new String[4];
        songs[0] = outputFile;
        songs[1] = outputFile2;
        songs[2] = outputFile3;
        songs[3] = outputFile4;


        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder2 = new MediaRecorder();
        myAudioRecorder2.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder2.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder2.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder3 = new MediaRecorder();
        myAudioRecorder3.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder3.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder3.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder4 = new MediaRecorder();
        myAudioRecorder4.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder4.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder4.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);


        p1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                try {
                    myAudioRecorder.setOutputFile(outputFile);
                    myAudioRecorder.prepare();
                    myAudioRecorder.start();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //makePostRequest();



                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    myAudioRecorder2.setOutputFile(outputFile2);
                    myAudioRecorder2.prepare();
                    myAudioRecorder2.start();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //makePostRequest();



                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    myAudioRecorder3.setOutputFile(outputFile3);
                    myAudioRecorder3.prepare();
                    myAudioRecorder3.start();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //makePostRequest();



                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();


            }


        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                myAudioRecorder4.setOutputFile(outputFile4);
                myAudioRecorder4.prepare();
                myAudioRecorder4.start();
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //makePostRequest();


            Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();


        }



        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioRecorder.stop();
                myAudioRecorder.release();
                myAudioRecorder = null;



                Toast.makeText(getApplicationContext(), "Audio recorded successfully", Toast.LENGTH_LONG).show();
            }
        });
        stop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioRecorder2.stop();
                myAudioRecorder2.release();
                myAudioRecorder2 = null;


                Toast.makeText(getApplicationContext(), "Audio recorded successfully", Toast.LENGTH_LONG).show();
            }
        });
        stop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioRecorder3.stop();
                myAudioRecorder3.release();
                myAudioRecorder3 = null;


                Toast.makeText(getApplicationContext(), "Audio recorded successfully", Toast.LENGTH_LONG).show();
            }
        });
        stop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            myAudioRecorder4.stop();
            myAudioRecorder4.release();
            myAudioRecorder4 = null;

            

            Toast.makeText(getApplicationContext(), "Audio recorded successfully", Toast.LENGTH_LONG).show();
        }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException, SecurityException, IllegalStateException {
            MediaPlayer m = new MediaPlayer();

            try {
                m.setDataSource(outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                m.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            m.start();

            Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
        }
        });

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException, SecurityException, IllegalStateException {
            MediaPlayer m = new MediaPlayer();

            try {
                m.setDataSource(outputFile2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                m.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            m.start();

            Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
        }
        });

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException, SecurityException, IllegalStateException {
            MediaPlayer m = new MediaPlayer();

            try {
                m.setDataSource(outputFile3);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                m.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            m.start();

            Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
        }
        });

        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException, SecurityException, IllegalStateException {
            MediaPlayer m = new MediaPlayer();

            try {
                m.setDataSource(outputFile4);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                m.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            m.start();

            Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
        }
        });

        aca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException, SecurityException, IllegalStateException {
                a = new MediaPlayer();
                a2 = new MediaPlayer();
                a3 = new MediaPlayer();
                a4 = new MediaPlayer();
                try {
                    a.setDataSource(outputFile);
                    a2.setDataSource(outputFile2);
                    a3.setDataSource(outputFile3);
                    a4.setDataSource(outputFile4);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    a.prepare();
                    a2.prepare();
                    a3.prepare();
                    a4.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                a.start();

                a2.start();

                a3.start();

                a4.start();


                Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
            }
        });

        full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException, SecurityException, IllegalStateException {

               FullSong = new MediaPlayer();
                try {
                    FullSong.setDataSource(songs[currentSong]);


                } catch (IOException e) {
                    e.printStackTrace();
                }
                FullSong.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        currentSong++;
                        if (currentSong < songs.length) {
                            FullSong.reset();
                            try{
                            FullSong.setDataSource(songs[currentSong]);

                            FullSong.prepare();
                            }
                            catch (IOException e){
                                e.printStackTrace();
                            }
                            FullSong.start();
                        } else {

                            FullSong.release();
                        }
                    }
                });
                try {
                    FullSong.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                FullSong.start();


                Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
                currentSong = 0;
            }
        });



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
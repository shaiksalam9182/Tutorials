package com.salam.Tuts;


import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Hello extends Fragment {

    VideoView videoplayer;
    String video_url;
    ProgressDialog pdLoading;


    @Override
    public void onStart() {
        super.onStart();
        pdLoading = new ProgressDialog(getContext());
        videoplayer = (VideoView)getActivity().findViewById(R.id.video_load);
        video_url = "https://firebasestorage.googleapis.com/v0/b/tutorials-8e37f.appspot.com/o/18289369_695450913995142_5860382755409362944_n.mp4?alt=media&token=36a8775f-1fa0-4881-8842-492ca9074dc2";
        Uri url = Uri.parse(video_url);

        videoplayer.setVideoURI(url);
        videoplayer.requestFocus();
        videoplayer.start();
        videoplayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
                if(i == MediaPlayer.MEDIA_INFO_BUFFERING_END){
                    pdLoading.dismiss();
                    return  true;
                }else if (i == MediaPlayer.MEDIA_INFO_BUFFERING_START){
                    pdLoading.setMessage("Buffering...");
                    pdLoading.show();
                    return true;
                }
                return false;
            }
        });
    }

    public Hello() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello, container, false);
    }

}

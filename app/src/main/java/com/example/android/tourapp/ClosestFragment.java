package com.example.android.tourapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ClosestFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    /*
    public ClosestFragment() {
        // Required empty public constructor
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cpromos_travel_list, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Travel> sec_one_cat_one_items = new ArrayList<Travel>();
        sec_one_cat_one_items.add(new Travel(getContext().getString(R.string.txt_sec_1_cat_1_3_1_1), getContext().getString(R.string.txt_sec_1_cat_1_3_1_2), getContext().getString(R.string.txt_sec_1_cat_1_3_1_3), getContext().getString(R.string.txt_sec_1_cat_1_3_1_4), getContext().getString(R.string.txt_sec_1_cat_1_3_1_5), getContext().getString(R.string.txt_sec_1_cat_1_3_1_6), R.drawable.ic_closest_one, R.raw.best_one));
        sec_one_cat_one_items.add(new Travel(getContext().getString(R.string.txt_sec_1_cat_1_3_2_1), getContext().getString(R.string.txt_sec_1_cat_1_3_2_2), getContext().getString(R.string.txt_sec_1_cat_1_3_2_3), getContext().getString(R.string.txt_sec_1_cat_1_3_2_4), getContext().getString(R.string.txt_sec_1_cat_1_3_2_5), getContext().getString(R.string.txt_sec_1_cat_1_3_2_6), R.drawable.ic_closest_two, R.raw.best_two));
        sec_one_cat_one_items.add(new Travel(getContext().getString(R.string.txt_sec_1_cat_1_3_3_1), getContext().getString(R.string.txt_sec_1_cat_1_3_3_2), getContext().getString(R.string.txt_sec_1_cat_1_3_3_3), getContext().getString(R.string.txt_sec_1_cat_1_3_3_4), getContext().getString(R.string.txt_sec_1_cat_1_3_3_5), getContext().getString(R.string.txt_sec_1_cat_1_3_3_6), R.drawable.ic_closest_three, R.raw.best_three));
        sec_one_cat_one_items.add(new Travel(getContext().getString(R.string.txt_sec_1_cat_1_3_4_1), getContext().getString(R.string.txt_sec_1_cat_1_3_4_2), getContext().getString(R.string.txt_sec_1_cat_1_3_4_3), getContext().getString(R.string.txt_sec_1_cat_1_3_4_4), getContext().getString(R.string.txt_sec_1_cat_1_3_4_5), getContext().getString(R.string.txt_sec_1_cat_1_3_4_6), R.drawable.ic_closest_four, R.raw.best_four));
        sec_one_cat_one_items.add(new Travel(getContext().getString(R.string.txt_sec_1_cat_1_3_5_1), getContext().getString(R.string.txt_sec_1_cat_1_3_5_2), getContext().getString(R.string.txt_sec_1_cat_1_3_5_3), getContext().getString(R.string.txt_sec_1_cat_1_3_5_4), getContext().getString(R.string.txt_sec_1_cat_1_3_5_5), getContext().getString(R.string.txt_sec_1_cat_1_3_5_6), R.drawable.ic_closest_five, R.raw.best_five));
        TravelAdapter adapter = new TravelAdapter(getActivity(), sec_one_cat_one_items, R.color.category_closest);
        ListView listView = (ListView) rootView.findViewById(R.id.sec_cpromos_travel_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Travel sec_one_cat_one_obj = sec_one_cat_one_items.get(position);
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), sec_one_cat_one_obj.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
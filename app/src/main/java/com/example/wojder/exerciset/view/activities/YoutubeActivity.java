package com.example.wojder.exerciset.view.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;

import com.example.wojder.exerciset.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private String GOOGLE_API_KEY = "AIzaSyC73V5t4sV215oxBqr_UU9Gce_gOcPl54Q";
    private String YOUTUBE_VIDEO_ID = "NyPtlOoCmV4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Snackbar.make(findViewById(R.id.youtube_layout), "YT player initialized succesfully", Snackbar.LENGTH_LONG).show();

        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if (!wasRestored) {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
//            Snackbar.make(findViewById(R.id.youtube_player), "Video is playing ok", Snackbar.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
//            Snackbar.make(findViewById(R.id.youtube_player), "Video is paused", Snackbar.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Snackbar.make(findViewById(R.id.youtube_player), "Click ad now, make the video creator rich!", Snackbar.LENGTH_LONG).show();
        }

        @Override
        public void onVideoStarted() {
            Snackbar.make(findViewById(R.id.youtube_player), "Video is started", Snackbar.LENGTH_LONG).show();
        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Snackbar.make(findViewById(R.id.youtube_layout), "Failed to initialize YT player", Snackbar.LENGTH_LONG).show();
    }
}

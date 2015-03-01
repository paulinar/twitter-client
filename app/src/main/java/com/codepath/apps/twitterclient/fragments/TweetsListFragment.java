package com.codepath.apps.twitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.twitterclient.R;
import com.codepath.apps.twitterclient.adapters.TweetsArrayAdapter;
import com.codepath.apps.twitterclient.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulina on 2/26/15.
 */
public class TweetsListFragment extends Fragment {

    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    private ListView lvTweets;

    // inflation logic
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list, parent, false);  // doesn't add itself to view immediately; do that later

        // goes into onCreateView because it REQUIRES the view
        // now looking up the listview within the FRAGMENT rather than the ACTIVITY
        lvTweets = (ListView) v.findViewById(R.id.lvTweets); // Find the listview

        lvTweets.setAdapter(aTweets); // Connect adapter to listview

        return v;
    }

    // creation lifecycle event
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // these don't require the view
        tweets = new ArrayList<>();  // Create the arraylist (data source)
        aTweets = new TweetsArrayAdapter(getActivity(), tweets); // Construct adapter from data source

    }

    public void addAll(List<Tweet> tweets) {
        aTweets.addAll(tweets);
    }

    public void clear() {
        aTweets.clear();
    }
}
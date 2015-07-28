package com.example.ahmed.stpblog;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class SummaryFragment extends Fragment implements View.OnClickListener {

    public static final String TAG_SUMARRAY_TITLE = "SUMARRAY_TITLE";
    public static final String TAG_SUMARRAY_CONTENT = "SUMARRAY_CONTENT";
    public static final String TAG_SUMARRAY_IMAGE = "SUMARRAY_IMAGE";
    public static final String TAG_SUMARRAY_POSITION = "SUMARRAY_POSITION";

    private int position;
    private String imageUrl;
    private String title;
    private String content;
    private ImageView imageView;
    private TextView textView_title;
    private TextView textView_summary;
    private Button more_detais;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_summary, container, false);
        imageView = (ImageView) v.findViewById(R.id.summary_image_1);
        textView_title = (TextView) v.findViewById(R.id.title_summary);
        textView_summary = (TextView) v.findViewById(R.id.summary_content);
        more_detais = (Button) v.findViewById(R.id.go_2_article);

        if (getArguments() != null) {
            position = getArguments().getInt(TAG_SUMARRAY_POSITION);
            imageUrl = getArguments().getString(TAG_SUMARRAY_IMAGE);
            title = getArguments().getString(TAG_SUMARRAY_TITLE);
            content = getArguments().getString(TAG_SUMARRAY_CONTENT);
            textView_title.setText(title);
            textView_summary.setText(content);
            Picasso.with(getActivity())
                    .load(imageUrl)
                    .fit()
                    .into(imageView);
        } else
            Toast.makeText(getActivity(), "no argument passed ", Toast.LENGTH_LONG).show();
        more_detais.setOnClickListener(this);

        return v;
    }


    public static Fragment newInstance(String title, String summary, String imageUrl, int position) {
        Bundle args = new Bundle();
        args.putString(TAG_SUMARRAY_TITLE, title);
        args.putString(TAG_SUMARRAY_CONTENT, summary);
        args.putString(TAG_SUMARRAY_IMAGE, imageUrl);
        args.putInt(TAG_SUMARRAY_POSITION, position);
        SummaryFragment fragment = new SummaryFragment();
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.go_2_article) {
            Intent intent = new Intent(getActivity(), ArticleActivity.class);
            intent.putExtra(TAG_SUMARRAY_POSITION, position);
            intent.putExtra(TAG_SUMARRAY_IMAGE, imageUrl);
            intent.putExtra(TAG_SUMARRAY_TITLE, title);
            startActivity(intent);
        }
    }
}

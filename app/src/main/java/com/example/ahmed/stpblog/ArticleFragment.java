package com.example.ahmed.stpblog;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {


    public static final String TAG_DETAILS_TITLE = "SUMARRAY_TITLE";
    public static final String TAG_DETAILS_CONTENT = "SUMARRAY_CONTENT";
    public static final String TAG_DETAILS_IMAGE = "SUMARRAY_IMAGE";
    private ImageView article_imageView;
    private TextView article_textView;
    private TextView title_textView;
    private String imageUrl;
    private String title;
    private String content;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_article, container, false);
        article_imageView= (ImageView) v.findViewById(R.id.article_img);
        article_textView= (TextView) v.findViewById(R.id.article_content);
        title_textView= (TextView) v.findViewById(R.id.article_title);
        if (getArguments() != null) {
            imageUrl = getArguments().getString(TAG_DETAILS_IMAGE);
            content = getArguments().getString(TAG_DETAILS_CONTENT);
            title=getArguments().getString(TAG_DETAILS_TITLE);
            title_textView.setText(title);
            article_textView.setText(content);
            Picasso.with(getActivity())
                    .load(imageUrl)
                    .fit()
                    .into(article_imageView);


        }

        return v;
    }

    public static android.support.v4.app.Fragment newInstance(String title, String content, String imageUrl) {
        Bundle args = new Bundle();
        args.putString(TAG_DETAILS_TITLE, title);
        args.putString(TAG_DETAILS_CONTENT, content);
        args.putString(TAG_DETAILS_IMAGE, imageUrl);
        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);

        return fragment;

    }


}

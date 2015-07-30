package com.example.ahmed.stpblog;

import android.content.Intent;
import android.support.v4.app.Fragment;


public class ArticleActivity extends SingleFragmentActivity {

String[] article_Details;

    @Override
    public Fragment getFragment() {
        article_Details = getResources().getStringArray(R.array.details_array);

        Intent intent =getIntent();
        int position=intent.getIntExtra(SummaryFragment.TAG_SUMARRAY_POSITION, 0);
        String title =intent.getStringExtra(SummaryFragment.TAG_SUMARRAY_TITLE);
        String imageUrl=intent.getStringExtra(SummaryFragment.TAG_SUMARRAY_IMAGE);
        return ArticleFragment.newInstance(title,article_Details[position],imageUrl);
    }
}

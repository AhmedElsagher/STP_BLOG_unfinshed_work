package com.example.ahmed.stpblog;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.squareup.picasso.Picasso;


public class SummaryArticle extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_article);
        ViewPager viewPager = new ViewPager(getApplicationContext());
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));


    }


    public class MyAdapter extends FragmentPagerAdapter {
        public static final int NUM_ITEMS = 10;
        Resources resources = getResources();
        String[] titles = resources.getStringArray(R.array.titles_array);
        String[] summaries = resources.getStringArray(R.array.summary_array);
        String[] imageUrls={
                "http://stp-egypt.com/Blog/wp-content/uploads/2015/03/love-between1.jpg"
                ,"http://stp-egypt.com/Blog/wp-content/uploads/2015/03/%D8%A7%D9%84%D8%AD%D8%B1%D9%88%D9%81-%D8%A7%D9%84%D8%B9%D8%B1%D8%A8%D9%8A%D8%A9.jpg"
                ,"http://stp-egypt.com/Blog/wp-content/uploads/2015/03/morals.jpg"
                ,"http://stp-egypt.com/Blog/wp-content/uploads/2015/03/love-between1.jpg"
                ,"http://stp-egypt.com/Blog/wp-content/uploads/2015/03/11037-outdoor-advertising-1.jpg"
                ,"http://stp-egypt.com/Blog/wp-content/uploads/2015/03/url.jpeg"
                ,"http://stp-egypt.com/Blog/wp-content/uploads/2015/03/let-go.jpg"
                ,"http://stp-egypt.com/Blog/wp-content/uploads/2015/03/7.jpg"
                ,"http://stp-egypt.com/Blog/wp-content/uploads/2014/12/11089057_920173758032858_1494404664_o.png"
                ,"http://stp-egypt.com/Blog/wp-content/uploads/2014/12/horoob-ila-wahm.jpg"
        };

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                case 1:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                case 2:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                case 3:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                case 4:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                case 5:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                case 6:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                case 7:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                case 8:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                case 9:
                    return SummaryFragment.newInstance(titles[position], summaries[position], imageUrls[position], position);
                default:
                    return null;
            }
        }
    }
}

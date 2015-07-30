package com.example.ahmed.stpblog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


public class GridFragment extends Fragment {
    public static final String TAG_POSITION = "grid";
    private ArrayList<Article> articles;
    private ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);
        articles = ArticleFactory.getArticleFactory(getActivity()).getArticles();
        listView = (ListView) v.findViewById(R.id.listView);
        ArticleAdapter adapter = new ArticleAdapter(articles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), SummaryArticle.class);
                intent.putExtra(TAG_POSITION, position);
                startActivity(intent);
            }
        });
        return v;
    }


    private class ArticleAdapter extends ArrayAdapter<Article> {
        public ArticleAdapter(ArrayList<Article> articles) {
            super(getActivity(), 0, articles);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.blog_list_item, null);
            }
            Article article = getItem(position);
            TextView titleTextView =
                    (TextView) convertView.findViewById(R.id.blog_list_item_title);
            titleTextView.setText(article.getArticle_title());
            ImageView imageView =
                    (ImageView) convertView.findViewById(R.id.blog_list_item_limage);
//            String imageUrl = article.getArticle_image_url();
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(getActivity(), SummaryArticle.class);
//                    intent.putExtra(TAG_POSITION, getCount());
//                    startActivity(intent);
//
//                }
//            });
            Picasso.with(getActivity())
                    .load(article.getArticle_image_url())
                    .fit()
                    .into(imageView);

            return convertView;
        }
    }
}


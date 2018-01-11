package com.appssquare.navigationdrawer.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appssquare.navigationdrawer.Models.NavigationModel;
import com.appssquare.navigationdrawer.R;

import java.util.List;

/**
 * Created by LAP_SHOP on 11/01/2018.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationHolder> {
    private List<NavigationModel> navigationModels;
    private FragmentActivity activity;

    public NavigationAdapter(List<NavigationModel> navigationModels,FragmentActivity activity) {
        this.navigationModels = navigationModels;
        this.activity=activity;
    }


    @Override
    public NavigationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NavigationHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_navigation, parent, false));
    }

    @Override
    public void onBindViewHolder(NavigationHolder holder, final int position) {
        final NavigationModel navigationModel=navigationModels.get(position);
        holder.nav_text.setText(navigationModel.getNav_text());
        holder.nav_img.setImageResource(navigationModel.getNav_img());
        holder.nav_main_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(navigationModel.getNav_fragment(),activity);
                for(int i=0 ; i<navigationModels.size();i++){
                    if(i==position){
                        navigationModel.setNav_active(true);
                    }else {
                        navigationModel.setNav_active(false);
                    }
                }


            }
        });

    }


    @Override
    public int getItemCount() {
        return navigationModels.size();
    }

    class NavigationHolder extends RecyclerView.ViewHolder {
        private View nav_main_view;
        private ImageView nav_img;
        private TextView nav_text;

        public NavigationHolder(View itemView) {
            super(itemView);
            nav_main_view=itemView.findViewById(R.id.nav_main_view);
            nav_img=itemView.findViewById(R.id.nav_img);
            nav_text=itemView.findViewById(R.id.nav_text);
        }
    }


    public static Class currentFragmentClass;

    public static void openFragment(Fragment fragment, FragmentActivity activity) {
        if (currentFragmentClass != fragment.getClass()) {
            currentFragmentClass = fragment.getClass();
            Log.e("openFragment", fragment.getClass().getName() + "");

            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.main_container_layout, fragment)
                    .addToBackStack(fragment.getClass().getName())
                    .commit();
        }
    }
}

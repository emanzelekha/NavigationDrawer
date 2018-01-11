package com.appssquare.navigationdrawer.Models;


import android.support.v4.app.Fragment;

/**
 * Created by LAP_SHOP on 11/01/2018.
 */

public class NavigationModel {
    private String nav_text;
    private int nav_img;
    private Fragment nav_fragment;
    private boolean nav_active;

    public String getNav_text() {
        return nav_text;
    }

    public void setNav_text(String nav_text) {
        this.nav_text = nav_text;
    }

    public int getNav_img() {
        return nav_img;
    }

    public void setNav_img(int nav_img) {
        this.nav_img = nav_img;
    }

    public Fragment getNav_fragment() {
        return nav_fragment;
    }

    public void setNav_fragment(Fragment nav_fragment) {
        this.nav_fragment = nav_fragment;
    }

    public boolean isNav_active() {
        return nav_active;
    }

    public void setNav_active(boolean nav_active) {
        this.nav_active = nav_active;
    }
}

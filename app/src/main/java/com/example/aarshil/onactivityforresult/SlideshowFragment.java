package com.example.aarshil.onactivityforresult;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SlideshowFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sildeshow, container, false);
        return rootView;
    }

    public void onViewCreated(View view, Bundle savedInstancedState){

        super.onViewCreated(view, savedInstancedState);

        getActivity().setTitle("SlideShow");
    }

}

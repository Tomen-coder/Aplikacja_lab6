package com.example.aplikacja_lab6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThirdFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Kolorki kolor = new ViewModelProvider(requireActivity()).get(Kolorki.class);
        final View layout = view.findViewById(R.id.constraint_layout3);
        layout.setBackgroundColor(kolor.kolorki_layout3.getValue());
        Observer<Integer> numberObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer newInteger) {
                layout.setBackgroundColor(kolor.kolorki_layout3.getValue());
            }
        };
        kolor.kolorki_layout3.observe(getViewLifecycleOwner(), numberObserver);

        view.findViewById(R.id.button_n3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.button_p3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_SecondFragment);
            }
        });
    }
}
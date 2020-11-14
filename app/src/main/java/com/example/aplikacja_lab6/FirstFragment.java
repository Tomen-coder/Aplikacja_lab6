package com.example.aplikacja_lab6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Kolorki kolor = new ViewModelProvider(requireActivity()).get(Kolorki.class);
        final View layout = view.findViewById(R.id.constraint_layout1);
        layout.setBackgroundColor(kolor.kolorki_layout1.getValue());
        Observer<Integer> numberObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer newInteger) {
                layout.setBackgroundColor(kolor.kolorki_layout1.getValue());
            }
        };
        kolor.kolorki_layout1.observe(getViewLifecycleOwner(), numberObserver);

        view.findViewById(R.id.button_n1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        view.findViewById(R.id.button_p1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_thirdFragment);
            }
        });
    }
}
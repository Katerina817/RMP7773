package com.example.rmp7773.UI.Layer.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.rmp7773.R;
import com.example.rmp7773.Data.Layer.Repository.RabbitRepository;
import com.example.rmp7773.UI.Layer.viewmodel.ShowRViewModel;

import java.util.Random;

public class ThirdFragment extends Fragment {
    public ThirdFragment() {
        super(R.layout.thirdfragment);
    }

    private ShowRViewModel viewModel2;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        Button back = view.findViewById(R.id.goback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_secondFragment);
            }
        });
        Button go = view.findViewById(R.id.gotolist);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_fourthFragment);
            }
        });
        viewModel2 = new ViewModelProvider(requireActivity()).get(ShowRViewModel.class);
        // Наблюдаем за LiveData с кроликами и обновляем список
        AbsoluteLayout Layout = requireView().findViewById(R.id.thirdfrag);
        viewModel2.getRabbitListLiveData().observe(getViewLifecycleOwner(), new Observer<RabbitRepository>() {
            @Override
            public void onChanged(RabbitRepository rabbits) {
                for (int i = 0; i < Layout.getChildCount(); i++) {
                    View childView = Layout.getChildAt(i);
                    if (childView instanceof ImageView) {
                        Layout.removeView(childView);
                    }
                }
                for (int i=0;i<rabbits.getRabbits().size();i++) {
                    ImageView im = new ImageView(requireContext());
                    im.setImageResource(R.drawable.rabbit);
                    Random random = new Random();
                    int x = random.nextInt(1200);
                    int y = random.nextInt(2200);
                    AbsoluteLayout.LayoutParams params = new AbsoluteLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            x,
                            y
                    );
                    im.setLayoutParams(params);
                    Layout.addView(im);
                }
            }
        });
        Button del = view.findViewById(R.id.deleteR);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_trirdThirdFragment2);
            }
        });
    }
}

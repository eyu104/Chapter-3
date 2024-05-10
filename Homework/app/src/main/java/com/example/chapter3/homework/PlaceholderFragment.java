package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.airbnb.lottie.LottieAnimationView;
import com.example.chapter3.homework.domain.Friend;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private RecyclerView recyclerView;
    private FriendsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        animationView = getView().findViewById(R.id.animation_view2);
        recyclerView = getView().findViewById(R.id.recycler_view);


        animationView.playAnimation();
        Log.d("alligator", "onActivityCreated: qqqqqqqq");
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,View.ALPHA,1.0f,0.0f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(recyclerView,View.ALPHA,0.0f,1.0f);
                animator1.setDuration(1000);
                animator2.setDuration(1000);
                animator1.setInterpolator(new AccelerateDecelerateInterpolator());
                animator2.setInterpolator(new AccelerateDecelerateInterpolator());
                animator1.start();
                animator2.start();

                List<Friend> friendList = generateFriendList();
                adapter = new FriendsAdapter(friendList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        }, 5000);
    }
    private List<Friend> generateFriendList() {
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Alice", true));
        friends.add(new Friend("Bob", false));
        friends.add(new Friend("Charlie", true));
        friends.add(new Friend("David", true));
        friends.add(new Friend("Eva", false));
        return friends;
    }

}

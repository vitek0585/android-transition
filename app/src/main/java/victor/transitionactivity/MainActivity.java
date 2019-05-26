package victor.transitionactivity;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.ChangeBounds;
import androidx.transition.Scene;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior<View> _bottomSheetBehavior;
    View bottomSheet;

    //SCENE
    private ViewGroup rootContainer;
    private Scene scene1, scene2;
    private boolean sceneOne;
    private TransitionManager _transitionManager;
    private ChangeBounds autoTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        final View con =
                findViewById(R.id.v);
        View t =
                findViewById(R.id.title);
        t.setOnClickListener(new View.OnClickListener() {
            boolean exp = true;

            @Override
            public void onClick(View v) {
                exp = !exp;

                if (exp) {
//                    ScaleAnimation sc = new ScaleAnimation(1, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
//                    sc.setDuration(500);
//                    sc.setFillAfter(true);
//                    con.startAnimation(sc);

//                    androidx.transition.TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.card));
//                    con.setVisibility(exp ? View.VISIBLE : View.GONE);

                    new AnimUtils().expand(con);
                } else {
//                    ScaleAnimation sc = new ScaleAnimation(1, 1, 1, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
//                    sc.setDuration(500);
//                    sc.setFillAfter(true);
//                    con.startAnimation(sc);

                    new AnimUtils().collapse(con);
                }
//                    androidx.transition.TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.accord));

                findViewById(R.id.arrow_icon).animate().scaleY(exp ? 1 : -1).setDuration(200).start();

            }
        });
//        setupScene();
//        Button button = findViewById(R.id.button);
//        final Button button1 = findViewById(R.id.button1);
//        Button button2 = findViewById(R.id.button2);
//       // _transitionManager = new TransitionManager();
//
//        button.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//
//                        Transition exitTrans = new Explode();
//                        getWindow().setExitTransition(exitTrans);
//
//                        Transition reenterTrans = new Slide();
//                        getWindow().setReenterTransition(reenterTrans);
//
//                        // startActivity(new Intent(MainActivity.this, SubMainActivity.class));
//                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
//                        Intent intent = new Intent(MainActivity.this, SubMainActivity.class);
//                        startActivity(intent, options.toBundle());
//                    }
//                });
//        button1.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        androidx.transition.TransitionManager.go(scene2, autoTransition);
//
//                    }
//                });
//
//        button2.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
//                                MainActivity.this, new Pair(button1, "button1"));
//                        Intent intent = new Intent(MainActivity.this, SubMainActivity.class);
//                        startActivity(intent, options.toBundle());
//
//                    }
//                });
//
//        //button.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
//        bottomSheet = findViewById(R.id.standardBottomSheet);
//        setupButtons();
//        setupStandardBottomSheet();


    }

    private void setupScene() {
        //SCENE

        rootContainer =
                findViewById(R.id.container);

        scene1 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene1, this);

        scene2 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene2, this);

        autoTransition = new ChangeBounds();
        autoTransition.addListener(new androidx.transition.Transition.TransitionListener() {
            @Override
            public void onTransitionStart(@NonNull androidx.transition.Transition transition) {

            }

            @Override
            public void onTransitionEnd(@NonNull androidx.transition.Transition transition) {
                findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        androidx.transition.TransitionManager.go(scene1, autoTransition);
                    }
                });
            }

            @Override
            public void onTransitionCancel(@NonNull androidx.transition.Transition transition) {

            }

            @Override
            public void onTransitionPause(@NonNull androidx.transition.Transition transition) {

            }

            @Override
            public void onTransitionResume(@NonNull androidx.transition.Transition transition) {

            }
        });


        scene1.enter();
    }

    private void setupButtons() {
        Button standardBottomSheetButton = findViewById(R.id.standardBottomSheetButton);
        standardBottomSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
//        Button modalBottomSheetButton = findViewById(R.id.modal_btn);
//        modalBottomSheetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    private void setupStandardBottomSheet() {
        _bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {

            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                textView.text = when(newState) {
//                    BottomSheetBehavior.STATE_EXPANDED ->"STATE_EXPANDED"
//                    BottomSheetBehavior.STATE_COLLAPSED ->"STATE_COLLAPSED"
//                    BottomSheetBehavior.STATE_DRAGGING ->"STATE_DRAGGING"
//                    BottomSheetBehavior.STATE_HALF_EXPANDED ->"STATE_HALF_EXPANDED"
//                    BottomSheetBehavior.STATE_HIDDEN ->"STATE_HIDDEN"
//                    BottomSheetBehavior.STATE_SETTLING ->"STATE_SETTLING"
//                    else ->null
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                val fraction = (slideOffset + 1f) / 2f
//                val color = ArgbEvaluatorCompat.getInstance().evaluate(fraction, startColor, endColor)
//                slideView.setBackgroundColor(color)
            }
        };

        _bottomSheetBehavior.setBottomSheetCallback(bottomSheetCallback);
        _bottomSheetBehavior.setSaveFlags(BottomSheetBehavior.SAVE_ALL);
    }
}

package victor.transitionactivity;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;

import androidx.appcompat.app.AppCompatActivity;

public class SubMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
        //findViewById(R.id.button).setAnimation(AnimationUtils.loadAnimation(this,R.anim.elem));

        Transition enterTrans = new Explode();
        getWindow().setEnterTransition(enterTrans);

        Slide slide = new Slide(Gravity.LEFT);
        slide.addTarget(R.id.text);
        getWindow().setEnterTransition(slide);

        Transition returnTrans = new Slide();
        getWindow().setReturnTransition(returnTrans);
    }
}

package protekto.corpo.com.mx.corpoprotekto;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;

/**
 * Created by herna on 7/31/2017.
 */

public class MyMediaController extends MediaController {

    public MyMediaController(Context context) {
        super(context);
    }

    private static final int    sDefaultTimeout = 3000;
    // Do nothing on the overridden hide method so the playback controls will never go away.
    @Override
    public void show() {
        super.show();
        this.setVisibility(View.VISIBLE);
    }

    @Override
    public void hide() {
        super.hide();
        this.setVisibility(View.GONE);
    }

    // Override the dispatchKeyEvent function to capture the back KeyEvent and tell the activity to finish.
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            ((Activity) getContext()).finish();
        }

        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        show(sDefaultTimeout);
        return true;
    }
}

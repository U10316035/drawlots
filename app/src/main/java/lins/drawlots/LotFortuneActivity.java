package lins.drawlots;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by no_name on 2018/10/23.
 */

public class LotFortuneActivity extends AppCompatActivity {
    private ImageView lotImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot_fortune);

        setImageSize();
    }

    private void setImageSize(){
        lotImage = (ImageView)findViewById(R.id.imageViewLotFortune);

        int width = getResources().getConfiguration().screenWidthDp;

        lotImage.getLayoutParams().width = width;
        lotImage.getLayoutParams().height = width*15/4;

    }
}

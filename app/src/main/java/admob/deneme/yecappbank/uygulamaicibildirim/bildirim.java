package admob.deneme.yecappbank.uygulamaicibildirim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class bildirim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildirim);


        TextView txt = new TextView(this);
        txt.setText("Bildirime tıklandıktan sonra yazacak !");
        setContentView(txt);


    }
}

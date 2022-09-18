package ifsc.espindula.appslideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Integer[] imagens;
    int indexArrayImagens;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imagens = new Integer[]
                {
                        R.drawable.cachorro,
                        R.drawable.gardem,
                        R.drawable.happy,
                        R.drawable.patinho,
                        R.drawable.porquinho
                };
        setPrimeiraImagem();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnVoltar : setImagemAnterior (); break;
            case R.id.btnHome   : setPrimeiraImagem (); break;
            case R.id.btnProximo: setImagemPosterior(); break;
        }
    }

    private void setImagemAnterior() {
        if (indexArrayImagens == 0)
            indexArrayImagens = imagens.length -1;
        else
            indexArrayImagens--;
        setImagem();
    }

    private void setImagemPosterior() {
        if (indexArrayImagens == imagens.length - 1) {
            setPrimeiraImagem();
            return;
        }

        indexArrayImagens++;
        setImagem();
    }

    private void setPrimeiraImagem() {
        indexArrayImagens = 0;
        setImagem();
    }

    private void setImagem() {
        imageView.setImageResource(imagens[indexArrayImagens]);
    }
}
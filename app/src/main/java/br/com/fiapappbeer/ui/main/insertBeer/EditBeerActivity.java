package br.com.fiapappbeer.ui.main.insertBeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.fiapappbeer.R;
import br.com.fiapappbeer.api.controller.DeleteBeerController;
import br.com.fiapappbeer.api.controller.UpdateBeerController;
import br.com.fiapappbeer.api.models.Beer;
import de.hdodenhof.circleimageview.CircleImageView;

public class EditBeerActivity extends AppCompatActivity {
    EditText  edtUnidadeMedida, edtValorMedida, edtValorPreco;
    TextView txtMarca, txtTipoEmbalagem;
    CircleImageView ivFoto;
    Beer beer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_beer);

        if((Beer) getIntent().getSerializableExtra("beer") != null ) {
            beer = (Beer) getIntent().getSerializableExtra("beer");
        }
        ivFoto = findViewById(R.id.ivEditFoto);
        txtMarca = findViewById(R.id.lblEditMarca);
        txtTipoEmbalagem = findViewById(R.id.lblEditTipoEmbalagem);
        edtUnidadeMedida = findViewById(R.id.edtEditUnidadeMedida);
        edtValorMedida = findViewById(R.id.edtEditValorMedida);
        edtValorPreco = findViewById(R.id.edtEditPreco);

        loadData();
    }

    public void loadData(){
        Picasso.get().load(R.drawable.beerimage).into(ivFoto);
        txtMarca.setText(beer.getMarca());
        txtTipoEmbalagem.setText(beer.getTipoEmbalagem());
        edtUnidadeMedida.setText(beer.getUnidadeMedida());
        edtValorPreco.setText(String.valueOf(beer.getPreco()));
        edtValorMedida.setText(String.valueOf(beer.getValorMedida()));
    }

    public Beer retrieveData(){
        Beer beer = new Beer();
        beer.setMarca(txtMarca.getText().toString());
        beer.setTipoEmbalagem(txtTipoEmbalagem.getText().toString());
        beer.setPreco(Double.parseDouble(edtValorPreco.getText().toString()));
        beer.setUnidadeMedida(edtUnidadeMedida.getText().toString());
        beer.setValorMedida(Double.parseDouble(edtValorMedida.getText().toString()));
        return beer;
    }

    public void updateBeer(View v){
        UpdateBeerController updateBeerController = new UpdateBeerController();
        updateBeerController.execute(retrieveData());
    }

    public void deleteBeer(View v){
        DeleteBeerController deleteBeerController = new DeleteBeerController();
        deleteBeerController.execute(retrieveData());
    }
}

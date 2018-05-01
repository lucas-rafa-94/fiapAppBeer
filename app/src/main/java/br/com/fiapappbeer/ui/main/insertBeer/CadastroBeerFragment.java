package br.com.fiapappbeer.ui.main.insertBeer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.com.fiapappbeer.R;
import br.com.fiapappbeer.api.controller.InsertBeerController;
import br.com.fiapappbeer.api.models.Beer;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroBeerFragment extends Fragment {
    EditText edtMarca, edtTipoEmbalagem, edtUnidadeMedida, edtValorMedida, edtPreco;

    Button btnCadastroBeer;

    public CadastroBeerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_beer, container, false);

        edtMarca = view.findViewById(R.id.edtMarca);
        edtTipoEmbalagem = view.findViewById(R.id.edtTipoEmbalagem);
        edtUnidadeMedida = view.findViewById(R.id.edtUnidadeMedida);
        edtValorMedida = view.findViewById(R.id.edtValorMedida);
        edtPreco = view.findViewById(R.id.edtPreco);

        btnCadastroBeer = view.findViewById(R.id.btnCadastroBeer);

        btnCadastroBeer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cadastroBeer();
            }
        });

        return view;
    }

    public  Beer retrieveData(){
        Beer beer = new Beer();
        beer.setMarca(edtMarca.getText().toString());
        beer.setTipoEmbalagem(edtTipoEmbalagem.getText().toString());
        beer.setUnidadeMedida(edtUnidadeMedida.getText().toString());
        beer.setValorMedida(Double.parseDouble(edtValorMedida.getText().toString()));
        beer.setPreco(Double.parseDouble(edtPreco.getText().toString()));
        return beer;
    }

    public void cadastroBeer(){
        InsertBeerController insertBeerController = new InsertBeerController();
        insertBeerController.execute(retrieveData());
    }

}

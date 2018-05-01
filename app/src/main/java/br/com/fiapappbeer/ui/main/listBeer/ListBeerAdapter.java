package br.com.fiapappbeer.ui.main.listBeer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.fiapappbeer.R;
import br.com.fiapappbeer.api.models.Beer;

/**
 * Created by lucasdossantos on 5/1/18.
 */

public class ListBeerAdapter extends RecyclerView.Adapter<ListBeerAdapter.ViewHolder> {

    private List<Beer> beerList;
    private RecyclerViewClickListener mListener;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        private Context context;
        public TextView marca, embalagem, medida, preco;
        public ImageView ivFoto;
        private RecyclerViewClickListener mListener;


        public ViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            ivFoto = v.findViewById(R.id.ivFoto);
            marca = v.findViewById(R.id.txtMarca);
            embalagem = v.findViewById(R.id.txtEmbalagem);
            medida = v.findViewById(R.id.txtMedida);
            preco = v.findViewById(R.id.txtPreco);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }


    public ListBeerAdapter(List<Beer> beerList, RecyclerViewClickListener listener, Context context) {
        this.beerList= beerList;
        mListener = listener;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_beer, parent, false);

        return new ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Beer beer = beerList.get(position);
        Picasso.get().load(R.drawable.beerimage).into(holder.ivFoto);
        holder.medida.setText(Html.fromHtml(context.getString(R.string.menu_unidadeMedida)) + beer.getUnidadeMedida() + " " + String.valueOf(beer.getValorMedida()));
        holder.embalagem.setText(Html.fromHtml(context.getString(R.string.menu_tpEmbalagem)) + beer.getTipoEmbalagem());
        holder.marca.setText(Html.fromHtml(context.getString(R.string.menu_marca)) + beer.getMarca());
        holder.preco.setText(Html.fromHtml(context.getString(R.string.menu_preco)) + String.valueOf(beer.getPreco()));

    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }


}
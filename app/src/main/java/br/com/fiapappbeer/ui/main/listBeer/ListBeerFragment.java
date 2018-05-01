package br.com.fiapappbeer.ui.main.listBeer;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


import java.util.List;

import br.com.fiapappbeer.R;
import br.com.fiapappbeer.api.controller.GetBeersController;
import br.com.fiapappbeer.api.models.Beer;
import br.com.fiapappbeer.ui.main.insertBeer.EditBeerActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListBeerFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ProgressBar mProgressBar;

    public ListBeerFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_beer, container, false);
        recyclerView = view.findViewById(R.id.rvBeer);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        return view ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetBeersController getBeersController = new GetBeersController(this);

        try {
            loadData(getBeersController.execute().get());
        }catch (Exception e){
            e.printStackTrace();
        }
        mProgressBar.setVisibility(View.GONE);

    }

    public void toEdit(Beer beer){
        Intent toEditBeer = new Intent(getContext(), EditBeerActivity.class);
        toEditBeer.putExtra("beer", beer);
        startActivity(toEditBeer);
    }


    public void loadData(List<Beer> beers){

        RecyclerViewClickListener listener = (view, position) -> {
            toEdit(beers.get(position));
        };

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ListBeerAdapter(beers, listener, getContext());
        recyclerView.setAdapter(mAdapter);
    }
}

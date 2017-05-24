package br.unifor.mybeer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.unifor.mybeer.R;
import br.unifor.mybeer.adapter.BeerAdapter;
import br.unifor.mybeer.database.BeerDAO;

/**
 * Created by bruno on 23/05/17.
 */

public class FragmentBeerList extends Fragment {

    private RecyclerView mBeerList;
    private BeerDAO mBeerDAO;
    private BeerAdapter mBeerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beer_list, container, false);
        mBeerList = (RecyclerView) view.findViewById(R.id.fragment_beer_list);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mBeerDAO = new BeerDAO(getContext());
        mBeerAdapter = new BeerAdapter(getContext(), mBeerDAO.findAll());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        mBeerList.setAdapter(mBeerAdapter);
        mBeerList.setLayoutManager(llm);


    }
}

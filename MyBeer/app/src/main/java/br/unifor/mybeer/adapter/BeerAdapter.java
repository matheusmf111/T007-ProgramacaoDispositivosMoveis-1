package br.unifor.mybeer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.unifor.mybeer.R;
import br.unifor.mybeer.model.Beer;

/**
 * Created by bruno on 23/05/17.
 */

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.BeerHolder>{

    private LayoutInflater mLayoutInflater;
    private List<Beer> mBeers;

    public BeerAdapter(Context context, List<Beer> beers) {
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mBeers = beers;
    }

    @Override
    public BeerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_beer, parent, false);
        BeerHolder holder = new BeerHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BeerHolder holder, int position) {

        Beer beer = mBeers.get(position);

        holder.mBeerImage.setImageResource(R.drawable.skol);
        holder.mBeerTitle.setText(beer.getName() + " - " + beer.getBrand());

        StringBuilder sb = new StringBuilder();
        sb.append("Rating: ");
        sb.append(beer.getScore() + "\n");
        sb.append("Volume: ");
        sb.append(beer.getVolume() + "\n");

        holder.mBeerDescription.setText(sb.toString());

    }

    @Override
    public int getItemCount() {
        return mBeers.size();
    }

    public class BeerHolder extends RecyclerView.ViewHolder{

        public ImageView mBeerImage;
        public TextView mBeerTitle;
        public TextView mBeerDescription;

        public BeerHolder(View itemView) {

            super(itemView);
            mBeerImage = (ImageView) itemView.findViewById(R.id.item_beer_image);
            mBeerTitle = (TextView) itemView.findViewById(R.id.item_beer_title);
            mBeerDescription = (TextView) itemView.findViewById(R.id.item_beer_description);

        }
    }

}

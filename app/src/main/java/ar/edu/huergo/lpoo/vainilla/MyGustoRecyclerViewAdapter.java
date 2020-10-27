package ar.edu.huergo.lpoo.vainilla;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ar.edu.huergo.lpoo.vainilla.dummy.DummyContent.DummyItem;

import java.util.List;
import java.util.Random;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyGustoRecyclerViewAdapter extends RecyclerView.Adapter<MyGustoRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;

    public MyGustoRecyclerViewAdapter(List<DummyItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("QUEONDA", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_gusto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.d("QUEONDA",
                "bindeando (reciclando) el elemento " + holder +
                        " en la posicion " + position + "!");
        // onRecycle

        holder.mItem = mValues.get(position);

        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        Random r = new Random();
        holder.mColorcito.setColorFilter(Color.argb(255, r.nextInt(250), r.nextInt(250), r.nextInt(250)));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;

        public final ImageView mColorcito;

        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);

            mColorcito = (ImageView) view.findViewById(R.id.colorcito);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
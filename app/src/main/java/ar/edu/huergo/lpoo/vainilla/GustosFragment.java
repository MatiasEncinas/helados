package ar.edu.huergo.lpoo.vainilla;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import ar.edu.huergo.lpoo.vainilla.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class GustosFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_GUSTOS_DATA = "gustos-data";
    // TODO: Customize parameters
    private JSONObject mGustosData = new JSONObject();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GustosFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static GustosFragment newInstance(String gustosData) {
        GustosFragment fragment = new GustosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_GUSTOS_DATA, gustosData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            try {
                mGustosData = new JSONObject(getArguments().getString(ARG_GUSTOS_DATA));
            } catch (JSONException e) {
                // esto no deberia pasar porque venimos de volley y eso ya chequeo
                // que tuvieramos un json valido
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gusto_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            DummyContent.llenarGustos(mGustosData);
            recyclerView.setAdapter(new MyGustoRecyclerViewAdapter(DummyContent.ITEMS));
        }
        return view;
    }
}

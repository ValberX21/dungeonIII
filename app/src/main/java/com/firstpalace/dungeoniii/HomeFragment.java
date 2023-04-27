package com.firstpalace.dungeoniii;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private TextInputEditText txtInputCharacter;

    private Collection<String> comeBack = new ArrayList<>();

    private ListView listItens;

    public HomeFragment() {}

    public static HomeFragment newInstance(String param1, String param2) {

        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,
                container, false);

        txtInputCharacter = (TextInputEditText) view.findViewById(R.id.txtInputCharacter);
        listItens = (ListView) view.findViewById(R.id.listItens);
        Button addCharacter = (Button) view.findViewById(R.id.btnAdd);

        addCharacter.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                newItem();
                break;
        }
    }


    private void newItem(){

        comeBack.add(txtInputCharacter.getText().toString());

        ArrayAdapter adapter = new ArrayAdapter<String>(getContext(),R.layout.listviewone, (List<String>) comeBack);
        listItens.setAdapter(adapter);

        txtInputCharacter.setText("");

    }

}
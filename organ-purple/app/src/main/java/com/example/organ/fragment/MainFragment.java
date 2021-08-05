package com.example.organ.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.organ.R;
import com.example.organ.activity.DetalhesProdutoActivity;
import com.example.organ.adapter.ListagemAdapter;
import com.example.organ.helper.RecyclerItemClickListener;
import com.example.organ.model.Produtos;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    private RecyclerView recyclerListagem;
    private List<Produtos> produtos = new ArrayList<>();
    private ImageButton btnFavoritar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        //RecyclerView - Listagem dos Produtos
        recyclerListagem = view.findViewById(R.id.rcListagem);

        //Define Layout
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //recyclerListagem.setLayoutManager(layoutManager);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerListagem.setLayoutManager(layoutManager);

        //Define Adapter
        this.prepararProdutos();
        ListagemAdapter adapter = new ListagemAdapter(produtos);
        recyclerListagem.setAdapter(adapter);

        recyclerListagem.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getActivity(),
                        recyclerListagem,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent i = new Intent(getActivity(), DetalhesProdutoActivity.class);
                                startActivity(i);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );


        return view;
    }

    public void prepararProdutos(){

        Produtos p = new Produtos("Red De...", "R$148,90", R.drawable.img_product_15);
        this.produtos.add(p);

        p = new Produtos("Counte...", "R$137,00", R.drawable.img_product_20);
        this.produtos.add(p);

        p = new Produtos("XCOM 2", "R$232,99", R.drawable.img_product_19);
        this.produtos.add(p);

        p = new Produtos("Rainbo...", "R$149,00", R.drawable.img_product_14);
        this.produtos.add(p);

        p = new Produtos("Unchar...", "R$62,99", R.drawable.img_product_16);
        this.produtos.add(p);

        p = new Produtos("Horizo...", "R$55,99", R.drawable.img_product_18);
        this.produtos.add(p);

        p = new Produtos("Controle", "R$499,99", R.drawable.img_product_1);
        this.produtos.add(p);

        p = new Produtos("Controle", "R$469,99", R.drawable.img_product_4);
        this.produtos.add(p);

        p = new Produtos("Controle", "R$179,99", R.drawable.img_product_5);
        this.produtos.add(p);

        p = new Produtos("Headset", "R$1.099,0", R.drawable.img_product_2);
        this.produtos.add(p);

        p = new Produtos("Headset", "R$499,90", R.drawable.img_product_7);
        this.produtos.add(p);

        p = new Produtos("Headset", "R$539,90", R.drawable.img_product_6);
        this.produtos.add(p);

        p = new Produtos("Playsta...", "R$4.699,00", R.drawable.img_product_10);
        this.produtos.add(p);

        p = new Produtos("Playsta...", "R$3.199,00", R.drawable.img_product_9);
        this.produtos.add(p);

        p = new Produtos("Playsta...", "R$4.530,99", R.drawable.img_product_8);
        this.produtos.add(p);

        p = new Produtos("Xbox S...", "R$2.947,99", R.drawable.img_product_11);
        this.produtos.add(p);

        p = new Produtos("Xbox S...", "R$4.999,90", R.drawable.img_product_12);
        this.produtos.add(p);

        p = new Produtos("Cabo", "R$60,99", R.drawable.img_product_3);
        this.produtos.add(p);

        p = new Produtos("Adapta...", "R$37,00", R.drawable.img_product_13);
        this.produtos.add(p);

    }

}

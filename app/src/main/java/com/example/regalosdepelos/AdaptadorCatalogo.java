package com.example.regalosdepelos;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdaptadorCatalogo extends RecyclerView.Adapter<AdaptadorCatalogo.ViewHolderCatalogos>{
     ArrayList<Catalogo> listaCatalogos;

     public AdaptadorCatalogo(ArrayList<Catalogo> listaCatalogos){
         this.listaCatalogos = listaCatalogos;


     }

}

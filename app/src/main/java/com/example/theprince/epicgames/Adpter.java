package com.example.theprince.epicgames;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Adpter extends RecyclerView.Adapter<Adpter.Holder> {

    List<Set_Get_Data> gameList ;
    Context context;

    ///////this adapter constructor//////
    public Adpter(ArrayList<Set_Get_Data> gameList , Context c ) {      //adapter constructor //////////
        this.gameList = gameList;
        this.context = c ;   // initialization context
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        Holder holder = new Holder(row ,context ,gameList );           ////////////
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Set_Get_Data data = gameList.get(position);
        holder.txtName.setText(data.getName());
        holder.txtDes.setText(data.getText());
        holder.txtPrice.setText(data.getPrice());
        holder.poster.setImageResource(data.getImage());
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    /// THIS VIEW HOLDER CLASS
    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {  //implements//

        TextView txtName,txtDes,txtPrice ;
        ImageView poster;
        Context context;
        List<Set_Get_Data>getDataArrayList ;

        // this view holder constructor ///////
        public Holder(View itemView , Context context  , List<Set_Get_Data>set_get_dataArrayList ) {       // view holder constructor
            super(itemView);
            this.getDataArrayList =set_get_dataArrayList;
            itemView.setOnClickListener(this);    //////////////
            this.context=context;
            //////////////
            this.getDataArrayList = set_get_dataArrayList;
            txtName = itemView.findViewById(R.id.txtName);
            txtDes = itemView.findViewById(R.id.txtDes);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            poster = itemView.findViewById(R.id.img);
        }

        // over ride method
        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            Set_Get_Data set_get_data = this.getDataArrayList.get(position);
            Intent intent = new Intent(context , Game.class);
            intent.putExtra("imgPoster" , set_get_data.getImage());
            intent.putExtra("gamename" , set_get_data.getName());
            intent.putExtra("gameprice" , set_get_data.getPrice());
            this.context.startActivity(intent);



        }

    }


}
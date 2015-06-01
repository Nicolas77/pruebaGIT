package com.jn.UMG.campanas.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jn.UMG.campanas.Cliente;
import com.jn.UMG.campanas.R;
import com.jn.UMG.campanas.utils.ClienteItemInterface;

import java.util.List;


public class ExampleContactAdapter extends ContactListAdapter{

    private Context context;

    public ExampleContactAdapter(Context _context, int _resource,
                                 List<ClienteItemInterface> _items) {
        super(_context, _resource, _items);
        this.context=_context;

    }


    // override this for custom drawing
    public void populateDataForRow(View parentView, ClienteItemInterface item , int position){
        // default just draw the item only
        View infoView = parentView.findViewById(R.id.infoRowContainer);
        TextView fullNameView = (TextView)infoView.findViewById(R.id.fullNameView);
        TextView nicknameView = (TextView)infoView.findViewById(R.id.nickNameView);
        ImageView userImg=(ImageView)infoView.findViewById(R.id.userImg);

        nicknameView.setText(item.getItemForIndex());


        if(item instanceof ClienteItemInterface){
            Cliente contactItem = (Cliente)item;
            fullNameView.setText("" + contactItem.getNombreDelCliente());
            fullNameView.setTextColor(Color.argb(255, 153, 153, 153));
            //nicknameView.setText(contactItem.getNombre());
            userImg.setImageDrawable(context.getDrawable(R.drawable.logo_umg));
        }

    }

}

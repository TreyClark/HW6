/* package edu.ualr.recyclerviewassignment.data;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import edu.ualr.recyclerviewassignment.R;
import edu.ualr.recyclerviewassignment.model.Device;

 public class DeviceViewHolder extends RecyclerView.ViewHolder {

    public ImageView deviceIcon;
    public ImageView connectionType;
    public ImageView statusIcon;
    public TextView name;
    public TextView deviceStatus;

    public View lyt_parent;

    public DeviceViewHolder(View v) {
        super(v);
        deviceIcon = v.findViewById(R.id.deviceIcon);
        statusIcon = v.findViewById(R.id.statusIcon);
        name = v.findViewById(R.id.deviceName);
        deviceStatus = v.findViewById(R.id.deviceStatus);
        connectionType = v.findViewById(R.id.connectionButton);
        lyt_parent = v.findViewById(R.id.lyt_parent);

        lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mOnItemClickListener.onItemClick(view, mItems.get(getLayoutPosition()), getLayoutPosition());
            }
        });
    }


    private OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(View view, Device obj, int position);
    }
     public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
         this.mOnItemClickListener = mItemClickListener;
     }

}*/

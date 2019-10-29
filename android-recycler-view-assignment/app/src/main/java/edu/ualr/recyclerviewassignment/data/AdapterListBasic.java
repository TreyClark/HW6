package edu.ualr.recyclerviewassignment.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.ualr.recyclerviewassignment.R;
import edu.ualr.recyclerviewassignment.model.Device;
import edu.ualr.recyclerviewassignment.model.Header;
import edu.ualr.recyclerviewassignment.model.Item;

import static java.sql.Types.NULL;


public class AdapterListBasic extends RecyclerView.Adapter {

    private List<Item> mItems;
    private Context mContext;

    private static final int PERSON_VIEW = 0;
    private static final int HEADER_VIEW = 1;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Device obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterListBasic(Context context, List<Item> items){
        this.mItems = items;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        return this.mItems.get(position).getHeader()? HEADER_VIEW : PERSON_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        RecyclerView.ViewHolder vh = null;
        View itemView = null;
        switch (viewType) {
            case (HEADER_VIEW) :
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
                vh = new SectionHeaderViewHolder(itemView);
                break;
            case (PERSON_VIEW):
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
                vh = new DeviceViewHolder(itemView);
                break;
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        if (mItems.get(position).getHeader() == false) {
            DeviceViewHolder viewHolder = (DeviceViewHolder)holder;
            Device device = (Device) mItems.get(position);

            setDeviceIcon(viewHolder, device.getDeviceType());
            viewHolder.name.setText(device.getName());


            setDeviceConnectivity(viewHolder, device.getDeviceStatus(), device);

        }
        else{
            SectionHeaderViewHolder sectionHeaderViewHolder = (SectionHeaderViewHolder) holder;
            Header header = (Header) mItems.get(position);

            sectionHeaderViewHolder.label.setText(header.getTitle());

        }


        /*
        viewHolder.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        */

    }

    @Override
    public int getItemCount(){
        return this.mItems.size();

    }

    public void setDeviceConnectivity (DeviceViewHolder viewHolder, Device.DeviceStatus status, Device device){

        if(status == Device.DeviceStatus.Linked) {
            viewHolder.deviceStatus.setText("Never connected");
            viewHolder.connectionType.setImageResource(R.drawable.ic_btn_connect);
            //viewHolder.statusIcon.setImageResource(R.drawable.status_mark_ready);
        }

        if(status == Device.DeviceStatus.Ready) {
            if (device.getLastConnection() == null)
                viewHolder.deviceStatus.setText("Never connected");
            else
                viewHolder.deviceStatus.setText("Recently connected");
            viewHolder.connectionType.setImageResource(R.drawable.ic_btn_connect);
            viewHolder.statusIcon.setImageResource(R.drawable.status_mark_ready);
        }

        if(status == Device.DeviceStatus.Connected) {
            viewHolder.deviceStatus.setText("Currently connected");
            viewHolder.connectionType.setImageResource(R.drawable.ic_btn_disconnect);
            viewHolder.statusIcon.setImageResource(R.drawable.status_mark_connected);
        }


    }

    public void setDeviceIcon (DeviceViewHolder viewHolder, Device.DeviceType type){

        switch (type) {
            case GameConsole:
                viewHolder.deviceIcon.setImageResource(R.drawable.ic_gameconsole);
                break;
            case SmartTV:
                viewHolder.deviceIcon.setImageResource(R.drawable.ic_tv);
                break;
            case Smartphone:
                viewHolder.deviceIcon.setImageResource(R.drawable.ic_phone_android);
                break;
            case Tablet:
                viewHolder.deviceIcon.setImageResource(R.drawable.ic_tablet_android);
                break;
            case Laptop:
                viewHolder.deviceIcon.setImageResource(R.drawable.ic_laptop);
                break;
            case Desktop:
                viewHolder.deviceIcon.setImageResource(R.drawable.ic_pc);
                break;
            case Unknown:
                viewHolder.deviceIcon.setImageResource(R.drawable.ic_unknown_device);
                break;

        }
    }


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
            lyt_parent = v.findViewById(R.id.item_parent);

            lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view, (Device) mItems.get(getLayoutPosition()), getLayoutPosition());
                }
            });
        }
    }

    public class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView label;
        public SectionHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            this.label = itemView.findViewById(R.id.title_section);
        }
    }

}











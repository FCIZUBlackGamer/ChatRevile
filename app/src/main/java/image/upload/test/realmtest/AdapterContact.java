package image.upload.test.realmtest;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.VHolder> {
    private final Context mContext;
    private final List<ContactModel> contacts;
    FragmentManager fragmentManager;
    private final OnItemClickListener listener;
    int type = -1;

    public interface OnItemClickListener {
        void onItemClick(ContactModel item);
    }

    public AdapterContact(Context c, List<ContactModel> row_items, OnItemClickListener listener) {
        this.contacts = row_items;
        this.mContext = c;
        this.listener = listener;
    }
    public AdapterContact(int typem, Context c, List<ContactModel> row_items, OnItemClickListener listener) {
        this.contacts = row_items;
        this.mContext = c;
        this.listener = listener;
        type = typem;
    }

    @Override
    public AdapterContact.VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.adapter_contact,parent,false);
        fragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();
        return new VHolder(v);
    }

    @Override
    public void onBindViewHolder(VHolder holder, final int position) {

        holder.bind(contacts.get(position), listener);

        holder.name.setText(contacts.get(position).getName());
        holder.date_time.setText(contacts.get(position).getDate_time());
        holder.last_message.setText(contacts.get(position).getMessage());

        if (!contacts.get(position).getImage().isEmpty()) {
            Picasso.get().load(contacts.get(position).getImage()).into(holder.image);
        }

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class VHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name;
        TextView date_time;
        TextView last_message;

        public VHolder(View itemView) {
            super(itemView);
            image = (CircleImageView) itemView.findViewById(R.id.contact_image);
            name = (TextView) itemView.findViewById(R.id.contact_name);
            last_message = (TextView) itemView.findViewById(R.id.last_message);
            date_time = (TextView) itemView.findViewById(R.id.date_time);

        }

        public void bind(final ContactModel item, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
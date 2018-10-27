package image.upload.test.realmtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentContacts extends Fragment {
    RecyclerView recyclerView_contact;
    RecyclerView.Adapter contactAdapter;
    List<ContactModel> contactModels;
    static int type = 0;

    public static FragmentContacts setTitle(int s){
        type = s;
        return new FragmentContacts();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_home, container, false);
        recyclerView_contact = (RecyclerView) view.findViewById(R.id.contact_rec);
        recyclerView_contact.setHasFixedSize(true);
        recyclerView_contact.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        contactModels = new ArrayList<>();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (type == 0){
            ((MainChatHome) getActivity())
                    .setActionBarTitle("Group chat");
        }else if (type == 1){
            ((MainChatHome) getActivity())
                    .setActionBarTitle("Contacts");
        }else if (type == 2){
            ((MainChatHome) getActivity())
                    .setActionBarTitle("History");
        }
        for (int x=0; x<10; x++){
            ContactModel model = new ContactModel(x,"Mo'men Shaheen","What's app?!",
                    "12:23 pm","","seen");
            contactModels.add(model);
        }

        contactAdapter = new AdapterContact(1, getActivity(), contactModels, new AdapterContact.OnItemClickListener() {

            @Override
            public void onItemClick(ContactModel item) {
                //Todo: Make Some Action

            }
        });
        recyclerView_contact.setAdapter(contactAdapter);
    }
}

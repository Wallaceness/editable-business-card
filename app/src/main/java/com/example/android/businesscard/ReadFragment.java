package com.example.android.businesscard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReadFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReadFragment extends Fragment {
    private TextView nameText;
    private TextView professionText;
    private TextView emailText;
    private TextView phoneText;
    private Button EditButton;
    private FrameLayout fragmentView;

    private static final String ARG_PARAM1 = "Name";
    private static final String ARG_PARAM2 = "Profession";
    private static final String ARG_PARAM3 = "Email";
    private static final String ARG_PARAM4 = "Phone";


    private String nameParam;
    private String profParam;
    private String emailParam;
    private String phoneParam;



    private OnFragmentInteractionListener mListener;

    public ReadFragment() { }

    // TODO: Rename and change types and number of parameters
    public static ReadFragment newInstance(String name, String profession, String email, String phone) {
        ReadFragment fragment = new ReadFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        args.putString(ARG_PARAM2, profession);
        args.putString(ARG_PARAM3, email);
        args.putString(ARG_PARAM4, phone);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nameParam = getArguments().getString(ARG_PARAM1);
            profParam = getArguments().getString(ARG_PARAM2);
            emailParam = getArguments().getString(ARG_PARAM3);
            phoneParam = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView= inflater.inflate(R.layout.fragment_read, container, false);
        nameText = rootView.findViewById(R.id.name_text);
        professionText = rootView.findViewById(R.id.profession_text);
        emailText = rootView.findViewById(R.id.email_text);
        phoneText = rootView.findViewById(R.id.phone_text);
        EditButton = rootView.findViewById(R.id.edit_button);

        nameText.setText(nameParam);
        professionText.setText(profParam);
        emailText.setText(emailParam);
        phoneText.setText(phoneParam);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

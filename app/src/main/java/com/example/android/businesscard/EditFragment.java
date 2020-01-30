package com.example.android.businesscard;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EditFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditFragment extends Fragment {
    private EditText nameField;
    private EditText professionField;
    private EditText emailField;
    private EditText phoneField;
    private Button saveButton;

    private static final String ARG_PARAM1 = "Name";
    private static final String ARG_PARAM2 = "Profession";
    private static final String ARG_PARAM3 = "Email";
    private static final String ARG_PARAM4 = "Phone";

    private String nameParam;
    private String profParam;
    private String emailParam;
    private String phoneParam;

    private OnFragmentInteractionListener mListener;

    public EditFragment() {
        // Required empty public constructor
    }

    public static EditFragment newInstance(String name, String profession, String email, String phone) {
        EditFragment fragment = new EditFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.fragment_edit, container, false);

        nameField=rootView.findViewById(R.id.name_field);
        emailField=rootView.findViewById(R.id.email_field);
        professionField=rootView.findViewById(R.id.profession_field);
        phoneField=rootView.findViewById(R.id.phone_field);
        saveButton=rootView.findViewById(R.id.save_button);

        nameField.setText(nameParam);
        professionField.setText(profParam);
        emailField.setText(emailParam);
        phoneField.setText(phoneParam);

        saveButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                // Get text values of edit fields
                String name= nameField.getText().toString();
                String profession = professionField.getText().toString();
                String email = emailField.getText().toString();
                String phone = phoneField.getText().toString();

                MainActivity mainActivity = (MainActivity) getActivity();

                mainActivity.saveData(name, profession, email, phone);
            }
        });

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

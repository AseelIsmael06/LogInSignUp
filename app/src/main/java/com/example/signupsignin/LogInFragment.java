package com.example.signupsignin;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogInFragment extends Fragment {
    private EditText etEmailLogIn,etPassLogIn,logInToRPTxt,txtSignUpLogIn;
    private Button btnLogIn;
    private FirebaseServices fbs;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LogInFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        etEmailLogIn = getView().findViewById(R.id.etEmailLogIn);
        fbs=FirebaseServices.getInstance();
        etPassLogIn = getView().findViewById(R.id.etPassLogIn);
        btnLogIn = getView().findViewById(R.id.btnLogIn);
        txtSignUpLogIn = getView().findViewById(R.id.signUpToLogInTxt);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eMail = etEmailLogIn.getText().toString();
                String password = etPassLogIn.getText().toString();
                if (eMail.trim().isEmpty() && password.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "some fields are empty!!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                fbs.getAuth().signInWithEmailAndPassword(eMail,password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                    }
                });
                txtSignUpLogIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SignUpFragment SignUpFragment =new SignUpFragment();
                        FragmentManager manager=getFragmentManager();
                        manager.beginTransaction()
                                .replace(R.id.frameLayoutMain,SignUpFragment,SignUpFragment.getTag())
                                .commit();
                    }
                });
                logInToRPTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ForgotPasswordFragment ForgotPasswordFragment =new ForgotPasswordFragment();
                        FragmentManager manager=getFragmentManager();
                        manager.beginTransaction()
                                .replace(R.id.frameLayoutMain,ForgotPasswordFragment,ForgotPasswordFragment.getTag())
                                .commit();
                    }
                });

            }
        });
    }
}

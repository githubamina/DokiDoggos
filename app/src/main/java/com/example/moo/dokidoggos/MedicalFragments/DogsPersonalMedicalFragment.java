package com.example.moo.dokidoggos.MedicalFragments;


import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.moo.dokidoggos.Activities.EditDietInfoActivity;
import com.example.moo.dokidoggos.Activities.EditMedicalInfoActivity;
import com.example.moo.dokidoggos.Classes.Trick;
import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DogsPersonalMedicalFragment extends Fragment {

    public DogsPersonalMedicalFragment() {
        // Required empty public constructor
    }

    TextView nameTV;
    TextView vetNameTV;
    TextView vetClinicTV;
    TextView vetPhoneTV;
    TextView previousVetsTV;
    TextView nextApptTV;
    TextView regMedsTV;
    TextView shortMedsTV;
    TextView supplementsTV;
    TextView dentalTV;
    TextView healthCondsTV;
    TextView allergiesTV;
    TextView insuranceTV;
    TextView policyTV;
    TextView hWormTV;
    TextView fTicksTV;
    TextView cdvTV;
    TextView parvoTV;
    TextView adenoTV;
    TextView paraTV;
    TextView bbTV;
    TextView lintTV;
    TextView desexedTV;
    Button editButton;
    Button reminderButton;


    String id;
    String name = "";
    String vetName = "";
    String vetClinic = "";
    String vetPhone = "";
    String previousVets = "";
    String nextAppt = "";
    String regularMeds = "";
    String shortTermMeds = "";
    String supplements = "";
    String dentalRoutine = "";
    String healthConditions = "";
    String allergies = "";
    String insuranceProvider = "";
    String policyNumber = "";
    String heartWorm = "";
    String fleaTick = "";
    String cdvVac = "";
    String parvoVac = "";
    String adenoVac = "";
    String paraVac = "";
    String bronchVac = "";
    String lintVac = "";
    String desexed = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_dogs_personal_medical, container, false);

        nameTV = rootView.findViewById(R.id.name_medical);
        vetNameTV = rootView.findViewById(R.id.vet_name);
        vetClinicTV = rootView.findViewById(R.id.vet_clinic);
        vetPhoneTV = rootView.findViewById(R.id.vet_phone);
        previousVetsTV = rootView.findViewById(R.id.previous_vets);
        nextApptTV = rootView.findViewById(R.id.vet_appt);
        regMedsTV = rootView.findViewById(R.id.reg_meds);
        shortMedsTV = rootView.findViewById(R.id.short_term_meds);
        supplementsTV = rootView.findViewById(R.id.supplements);
        dentalTV = rootView.findViewById(R.id.dental);
        healthCondsTV = rootView.findViewById(R.id.health_conditions);
        allergiesTV = rootView.findViewById(R.id.allergies);
        insuranceTV = rootView.findViewById(R.id.insurance);
        policyTV = rootView.findViewById(R.id.policy);
        hWormTV = rootView.findViewById(R.id.hworm);
        fTicksTV = rootView.findViewById(R.id.ftick);
        cdvTV = rootView.findViewById(R.id.distemper_vac);
        parvoTV = rootView.findViewById(R.id.parvo_vac);
        adenoTV = rootView.findViewById(R.id.adeno_vac);
        paraTV = rootView.findViewById(R.id.pinfluenza_vac);
        bbTV = rootView.findViewById(R.id.bb_vac);
        lintTV = rootView.findViewById(R.id.linterrogans_vac);
        desexedTV = rootView.findViewById(R.id.desexed);



        Bundle bundle = this.getArguments();
        if (bundle != null) {
            id = bundle.getString("id", null);
            name = bundle.getString("name", null);
            vetName = bundle.getString("vetName", null);
            vetClinic = bundle.getString("vetClinic", null);
            vetPhone = bundle.getString("vetPhone", null);
            previousVets = bundle.getString("previousVets", null);
            nextAppt = bundle.getString("nextAppt", null);
            regularMeds = bundle.getString("regularMeds", null);
            shortTermMeds = bundle.getString("shortTermMeds", null);
            supplements = bundle.getString("supplements", null);
            dentalRoutine = bundle.getString("dentalRoutine", null);
            healthConditions = bundle.getString("healthConditions", null);
            allergies = bundle.getString("allergies", null);
            insuranceProvider = bundle.getString("insuranceProvider", null);
            policyNumber = bundle.getString("policyNumber", null);
            heartWorm = bundle.getString("heartWorm", null);
            fleaTick = bundle.getString("fleaTick", null);
            cdvVac= bundle.getString("cdvVac", null);
            parvoVac = bundle.getString("parvoVac", null);
            adenoVac = bundle.getString("adenoVac", null);
            paraVac = bundle.getString("paraVac", null);
            bronchVac = bundle.getString("bronchVac", null);
            lintVac = bundle.getString("lintVac", null);
            desexed = bundle.getString("desexed", null);
        }

        nameTV.setText(name);
        vetNameTV.setText(vetName);
        vetClinicTV.setText(vetClinic);
        vetPhoneTV.setText(vetPhone);
        previousVetsTV.setText(previousVets);
        nextApptTV.setText(nextAppt);
        regMedsTV.setText(regularMeds);
        shortMedsTV.setText(shortTermMeds);
        supplementsTV.setText(supplements);
        dentalTV.setText(dentalRoutine);
        healthCondsTV.setText(healthConditions);
        allergiesTV.setText(allergies);
        insuranceTV.setText(insuranceProvider);
        policyTV.setText(policyNumber);
        hWormTV.setText(heartWorm);
        fTicksTV.setText(fleaTick);
        cdvTV.setText(cdvVac);
        parvoTV.setText(parvoVac);
        adenoTV.setText(adenoVac);
        paraTV.setText(paraVac);
        bbTV.setText(bronchVac);
        lintTV.setText(lintVac);
        desexedTV.setText(desexed);


        editButton = rootView.findViewById(R.id.edit_button);
        reminderButton = rootView.findViewById(R.id.reminder_button);



        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditMedicalInfoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString ("id", String.valueOf(id));
                bundle.putString("name", name);
                bundle.putString("vetName", vetName);
                bundle.putString("vetClinic", vetClinic);
                bundle.putString("vetPhone", vetPhone);
                bundle.putString("previousVets", previousVets);
                bundle.putString("nextAppt", nextAppt);
                bundle.putString("regularMeds", regularMeds);
                bundle.putString("shortTermMeds", shortTermMeds);
                bundle.putString("supplements", supplements);
                bundle.putString("dentalRoutine", dentalRoutine);
                bundle.putString("healthConditions", healthConditions);
                bundle.putString("allergies", allergies);
                bundle.putString("insurance", insuranceProvider);
                bundle.putString("policyNumber", policyNumber);
                bundle.putString("heartWorm", heartWorm);
                bundle.putString("fleaTick", fleaTick);
                bundle.putString("cdvVac", cdvVac);
                bundle.putString("parvoVac", parvoVac);
                bundle.putString("adenoVac", adenoVac);
                bundle.putString("paraVac", paraVac);
                bundle.putString("bronchVac", bronchVac);
                bundle.putString("lintVac", lintVac);
                bundle.putString("desexed", desexed);




                intent.putExtras(bundle);


                startActivity(intent);
            }
        });


        reminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

}

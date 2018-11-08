package com.ermile.a01_learn_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class activity_twoo extends AppCompatActivity {
    Button btn_fname,btn_lname,btn_number,btn_email;
//    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_twoo );

        btn_fname=findViewById ( R.id.btn_fname);
        btn_lname=findViewById ( R.id.btn_lname);
        btn_number=findViewById ( R.id.btn_number);
        btn_email=findViewById ( R.id.btn_email);
//        btn_ok=findViewById ( R.id.btn_ok);

        Bundle getinfo_form = getIntent ().getExtras ();
        if (getinfo_form !=null)
            {
                String get_fname=" ";
                String get_lname=" ";
                String get_number=" ";
                String get_email=" ";

                if (getinfo_form.containsKey ( "post_fname" )){
                    get_fname = getinfo_form.getString ( "post_fname" );
                }
                if (getinfo_form.containsKey ( "post_lname" )){
                    get_lname = getinfo_form.getString ( "post_lname" );
                }
                if (getinfo_form.containsKey ( "post_number" )){
                    get_number = getinfo_form.getString ( "post_number" );
                }
                if (getinfo_form.containsKey ( "post_email" )){
                    get_email = getinfo_form.getString ( "post_email" );
                }

                btn_fname.setText ( get_fname );
                btn_lname.setText ( get_lname );
                btn_number.setText ( get_number );
                btn_email.setText ( get_email );
            }
    }
}

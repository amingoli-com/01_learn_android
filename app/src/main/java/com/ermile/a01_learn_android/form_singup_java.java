package com.ermile.a01_learn_android;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class form_singup_java implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Activity activity;
    private LinearLayout linearlayout_1;
    private EditText et_firstname,et_lastname,et_number,et_email;
    private CheckBox chbox;
    private Button btn_send;


    public form_singup_java(Activity activity,int layout)
        {
            this.activity= activity;
            linearlayout_1=activity.findViewById ( layout );
            init();
        }

    private void init() {
        if (linearlayout_1 == null){
            return;
        }
        et_firstname=linearlayout_1.findViewById (R.id.et_firstname);
        et_lastname=linearlayout_1.findViewById (R.id.et_lastname);
        et_number=linearlayout_1.findViewById (R.id.et_number);
        et_email=linearlayout_1.findViewById (R.id.et_email);
        chbox=linearlayout_1.findViewById (R.id.chbox);
        btn_send=linearlayout_1.findViewById (R.id.btn_send);


        btn_send.setOnClickListener ( this );
        chbox.setOnCheckedChangeListener ( this );
    }


    @Override
    public void onClick(View v) {
        if (v.getId ()==btn_send.getId ())
            {

                String fname=et_firstname.getText ().toString ().trim ();
                String lname=et_lastname.getText ().toString ().trim ();
                String numberr=et_number.getText ().toString ().trim ();
                String emaill=et_email.getText ().toString ().trim ();

                if (treejon(fname ,lname ,numberr ,emaill ))
                    {
                        Toast.makeText ( activity , "اطلاعات ارسال شد!" , Toast.LENGTH_SHORT ).show ( );
                        Intent post_info_form= new Intent ( activity, activity_twoo.class );
                        post_info_form.putExtra ( "post_fname",  fname );
                        post_info_form.putExtra ( "post_lname",  lname);
                        post_info_form.putExtra ( "post_number", numberr );
                        if (chbox.isChecked ())
                            {
                                post_info_form.putExtra ( "post_email",emaill );
                            }
                        activity.startActivity ( post_info_form );

                    }
            }

    }

    private boolean treejon(String fname , String lname , String numberr , String emaill) {
        if (fname.length () < 3)
            {
                Toast.makeText ( activity , "نام صحیح نیست" , Toast.LENGTH_SHORT ).show ( );
                et_firstname.requestFocus ();
                return false;
            }

        if (lname.length () < 3)
            {
                Toast.makeText ( activity , "نام خانوادگی صحیح نیست" , Toast.LENGTH_SHORT ).show ( );
                et_lastname.requestFocus ();
                return false;
            }

        if ( numberr.length () !=11 || ! numberr.startsWith ( "09" ))
            {
                Toast.makeText ( activity , "شماره تلفن اشتباه است" , Toast.LENGTH_SHORT ).show ( );
                et_number.requestFocus ();
                return false;
            }


        if (    emaill.isEmpty () ||
                emaill.lastIndexOf ( '@' )<=0 ||
                !emaill.contains ( "." ) ||
                emaill.lastIndexOf ( "." ) < emaill.lastIndexOf ( '@' ) ||
                emaill.split ( "@" ).length > 2 )
            {
                Toast.makeText ( activity , "ایمیل اشتباه است" , Toast.LENGTH_SHORT ).show ( );
                et_email.requestFocus ();
                return false;
                }

            

     return true; }

    @Override
    public void onCheckedChanged(CompoundButton cheki_forchbox , boolean isChecked) {
        if (cheki_forchbox.getId ()== R.id.chbox)
            {
                et_email.setEnabled ( isChecked );
            }

    }
}

package com.julenbujanda.noplanetb;


import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.test.espresso.action.ViewActions;


/**
 * @author ernesto
 */

public class ExampleInstrumentedTest extends ActivityInstrumentationTestCase2<BLogin> {

    private Button mloginbutton;
    private EditText etext1;
    private EditText etext2;

    public ExampleInstrumentedTest() {
        super(BLogin.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        BLogin actividad = getActivity();
        etext1 = actividad.findViewById(R.id.txt_username);
        etext2 = actividad.findViewById(R.id.txt_password);
        mloginbutton = actividad.findViewById(R.id.btn_login);

    }

    private static final String USERNAME = "julenbujanda@me.com";
    private static final String PASSWORD = "contrasena";

    public void testLoginSignup() {
        TouchUtils.tapView(this, etext1);
        getInstrumentation().sendStringSync(USERNAME);
        ViewActions.closeSoftKeyboard();
//        // now on value2 entry
        TouchUtils.tapView(this, etext2);
        getInstrumentation().sendStringSync(PASSWORD);
        // now on Add button
        TouchUtils.tapView(this, mloginbutton);
    }


}

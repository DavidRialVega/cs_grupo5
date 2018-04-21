package com.example.miguel.pong.tests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import gameObjs.Bullet;
import gameObjs.PalaJugador;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Prueba {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.miguel.pong", appContext.getPackageName());
        //Prueba
    }


    public void pala(){



        PalaJugador palajugador = new PalaJugador(null, 10, 10);

        assertTrue(palajugador.shoot(1,2));







    }
}

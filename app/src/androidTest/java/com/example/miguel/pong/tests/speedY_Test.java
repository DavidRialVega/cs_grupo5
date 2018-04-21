package com.example.miguel.pong.tests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import gameObjs.Bullet;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class speedY_Test {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.miguel.pong", appContext.getPackageName());
        //Prueba
    }


    public void test_speedX(){
        int x = 100;
        int y = 100;
        int dispW = 150;
        int dispH=150;
        int yFin = 150;
        int xFin = 200;
        int expectedYSpeed = 3000;

        Bullet bullet = new Bullet(null, dispW,dispH,x,y, xFin, yFin);

        assertEquals(expectedYSpeed, bullet.calculateSpeedY(y));



    }
}
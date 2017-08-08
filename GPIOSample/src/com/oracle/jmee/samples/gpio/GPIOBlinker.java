/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
 * 
 * This software is dual-licensed to you under the MIT License (MIT) and
 * the Universal Permissive License (UPL). See the LICENSE file in the
 * root directory for license terms.  You may choose either license, or both.
 */
package com.oracle.jmee.samples.gpio;

import java.io.IOException;

import javax.microedition.midlet.MIDlet;

import jdk.dio.DeviceManager;
import jdk.dio.gpio.GPIOPin;

/**
 * This class contains the code to open the pin (<b>GIO24</b> is hard coded) for output.
 * This will cause the LED to blink every 10 seconds
 * @author ramku
 *
 */
public class GPIOBlinker extends MIDlet {

    // GPIO pin which corresponds to a LED
    private GPIOPin led = null;




    @Override
	public void startApp() {
		System.out.println("******************************************");
		System.out.println("*         GPIO Sample started!           *");
		System.out.println("******************************************");

		// pin name
		String ledId = "GPIO24";

		// open pin for the LED
		try {
			try {
				int ledPinId = Integer.parseInt(ledId);
				System.out.println("Opening the GPIO pin with id " + ledPinId
						+ " for the LED");
				led = DeviceManager.open(ledPinId);
			} catch (NumberFormatException ex) {
				// this exception means that buttonId is not a number and may
				// contain a name
				System.out.println("Opening the GPIO pin with name \"" + ledId
						+ "\" for the LED");
				led = (GPIOPin) DeviceManager.open(ledId, GPIOPin.class);
			}
			led.setValue(true);
			for (int i = 0; i < 100; i++) {
				led.setValue(!led.getValue());
				System.out.println(led.getValue());
				Thread.sleep(10000);
			}
		} catch (IOException | IllegalArgumentException
				| InterruptedException ex) {
			System.out.println(
					"Cannot open the GPIO pin for the LED: " + ex.getMessage());
			destroyApp(true);
			return;
		}

	}

  
    @Override
    public void destroyApp(boolean unconditional) {
        System.out.println("******************************************");
        System.out.println("*         GPIO Sample destroyed          *");
        System.out.println("******************************************");

        // close all opened GPIO pins and port
        if (led != null) {
            try {
                led.close();
            } catch (IOException ex) {
                System.out.println("Cannot close pin of LED: " + ex.getMessage());
            }
        }
        
        notifyDestroyed();
    }
}

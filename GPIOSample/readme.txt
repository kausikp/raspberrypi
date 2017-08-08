#
# Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
# 
# This software is dual-licensed to you under the MIT License (MIT) and
# the Universal Permissive License (UPL). See the LICENSE file in the
# root directory for license terms.  You may choose either license, or both.
# 
# This is a sample of creating Oracle IoT CS edge application.
#

GPIOSample v1.0
---------------

Overview:
---------
This sample demonstrates usage of GPIO (General Purpose Input Output) package of Device I/O API 1.1. 

It is intended to work with a button and one or several LEDs. The sample switches LED(s) on/off with every button press.

This sample is a successor of GPIODemo application.

Target Platforms:
-----------------
Any platform which supports Device I/O API 1.1 with GPIO package and has the following DIO devices:
- GPIO pin to which a button is connected.
- either GPIO port that corresponds to a set of LEDs or a single LED connected via GPIO pin.

The sample is primary intended to run on the following predefined target platforms:
- EmbeddedDevice1 and EmbeddedDevice2 on SDK emulator. They use the following DIO devices:
    * GPIO pin with name "BUTTON 1" as a button.
    * GPIO port with name "LEDS".
- Qualcomm_IoE_Device on SDK emulator. It uses the following DIO devices:
    * GPIO pin with name "GPIO0" as a button.
    * GPIO port with name "LEDS".
- Freescale K64. It uses the following DIO devices:
    * GPIO pin with name "SW2" as a button.
    * GPIO port with name "LEDS".
    
For information about DIO devices on the predefined target platforms - see Getting Started Guide for Freescale FRDM-K64F and Developer Guide for Windows SDK emulator.

This sample can be run on any other platform under the condition that "GPIOSample-ButtonId" as well as either "GPIOSample-LEDPortId" or "GPIOSample-LEDId" JAD properties are specified.

Sample Configuration:
---------------------
- JAD property "GPIOSample-ButtonId" - GPIO pin id or name of a button. If property value is an integer number then it is used as id, otherwise - as a name.
  If there is no such property, a pin corresponding to the current one of the predefined target platforms is used:
    * EmbeddedDevice1 and EmbeddedDevice2 on SDK emulator - pin with "BUTTON 1" name.
    * Qualcomm_IoE_Device on SDK emulator - pin with "GPIO0" name.
    * Freescale K64 - pin with "SW2" name.
  If the current platform is not among the predefined target ones and JAD property is not specified, the sample terminates.

- JAD property "GPIOSample-LEDPortId" - GPIO port id or name of LED port. If property value is an integer number then it is used as id, otherwise - as a name.
  If there is no such property and the sample is running on one of the predefined target platforms, a port with "LEDS" name is used. 
  Otherwise the sample uses a single LED (see the next configuration property) instead of LED port.

- JAD property "GPIOSample-LEDId" - GPIO pin id or name of LED. If property value is an integer number then it is used as id, otherwise - as a name.
  It is required if LED port is not specified and the current platform is not among the predefined target platforms. If in this situation there is no such property, the sample terminates.

How To Run:
-----------
There are two ways to try this sample:
- Compile the sample using the provided project files and run it from IDE;
- Install and run already compiled JAD/JAR files without IDE.

This sample requires various permissions. 

For information about application compilation, installation, starting, etc., with and/or without IDE - see Oracle Java ME Embedded documentation.

Behaviour Description:
----------------------
- GPIOSample is started.

- GPIOSample obtains GPIO pin name or id for a button from JAD property. If it is absent, the sample uses the default pin on the predefined target platforms and terminates on another platforms.

- GPIOSample opens the GPIO pin for the button.

- GPIOSample obtains GPIO port name or id for a LED port from JAD property. If it is absent, the sample uses the default port on the predefined target platforms. 
  If underlying platform is not of predefined target ones and a LED port is not specified, the sample obtains GPIO pin name or id for LED from JAD property. 
  If neither pin nor port is specified or cannot be opened, the sample terminates.

- GPIOSample opens the GPIO port with LEDs or the pin for the LED. 

- GPIOSample sets a button press listener.

- GPIOSample switches LED(s) on/off with every button press.

- GPIOSample should be stopped manually.

Example Output:
---------------
******************************************
*         GPIO Sample started!           *
******************************************
Opening the GPIO pin with name "BUTTON 1" for the button
GPIO pin for the button is opened
Opening the GPIO port with name "LEDS"
GPIO port is opened
Listener for the button is set
Button is pressed
Button is pressed
******************************************
*         GPIO Sample destroyed          *
******************************************
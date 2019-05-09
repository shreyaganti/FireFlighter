README
Fire Flighter
Ashwini Suriyaprakash, Rujuta Swadi, Shreya Ganti
Period 4, AP CS, Mr. Shelby
5/3/19


Description:  
Intro: 
Forest fires plague the scorched Earth. Fire trucks have been deployed, but they are too slow and can’t keep up with the spreading flames. Being a passenger all your life, you’ve been called upon to take a seat as the pilot of a fire fighter plane!  
In this flight simulation, a side view of the plane, along with a simpler but accurate view of an airplane cockpit, will be provided. In the cockpit, a speed dial, altitude measurement, approximate time remaining, and a geographic map of the route will be displayed. You can change the plane’s elevation and set the plane’s speed by adjusting the throttle. Most importantly, your plane is equipped with a hose, that can spray water at the fires on the ground. But, due to the drought, your plane only has a certain amount of water. Take out as many fires as you can without running out of water! Remember successfully taking off and landing in the runways are equally as important! And who knows? Lightning may hit and throw your plane off balance. Are you ready to save the world from the flames? Humanity is counting on you!


Motivation/Target audience: 
We decided to build this game because we were interested in flight simulation and exploring how to make the experience as realistic and fun as possible, with an additional feature relating to our world’s climate change. We hope that those interested in being a pilot, playing a fun graphical game, saving the world, or getting that extra adrenaline, will use our program.


Instructions: 
* (DONE) In the instructions screen, select two airports (source and destination) and click the “Start” button with the mouse
* (DONE) In the game screen, use Up and Down arrow keys to adjust altitude of the plane, use Right arrow key to increase speed and Left arrow key to decrease speed of the plane, and use the Spacebar to deploy a spray of water from the plane to extinguish a fire
* (NOT DONE) At the end of the game, click the “Quit” or “Restart” button with the mouse


Features List: 
Must-Haves:
* (DONE) Menu which includes instructions and allows user to select source and destination airports and start the flight simulation
* (DONE) There should be two views (one of the cockpit and one of the side view of the plane). These views can be on separate windows or on the same window.
* (DONE) The plane should contain some kind of background/scenery that it is flying in
* (DONE) Player can adjust the plane’s speed and altitude
* (ALMOST DONE) Cockpit contains a dial showing speed and displays the numeric altitude in feet and approximate time remaining for the flight
* (NOT DONE) Players can have a successful/unsuccessful flight, depending on correct take-off and landing (correct take-off means that the plane did not go past the end of the runway before taking off and correct landing means that the plane landed in the runway at a slow speed)
* (DONE) Fires are randomly placed on the plane’s route, which the plane has to extinguish by spraying water
        
Want-To-Haves (NOT DONE):
* A real-time location tracker to see where the plane currently is on a geographic map (source, destination airports, route, and current position should be clearly marked on the map)
* Cockpit contains a compass, whose direction depends on the route the plane travels
* Weather catastrophes, which disturb plane and cause damage (wind, lightning, rain)
* Obstacles which the plane should avoid, such as birds and other planes
* Introduce a concept called “damage” which increases when the plane is struck by weather catastrophes or crashes into obstacles (too high damage causes player to lose control of plane and results in an unsuccessful flight)
* Sound effects (airplane engine noises when plane takes off and lands)
* Player can open and close the wheels of the plane when appropriate
* Guide person pops up before take-off to give a short background story on the fires
* Feature that warns player of incoming airport so player can prepare for landing


Stretch Features (NOT DONE):
* The background in which the plane is in corresponds to the actual location (for example, if the route from source to destination passes over an ocean, the background should change to an ocean instead of being entirely over land)
* Include flights, which have stop-over airports (player has to take-off and land multiple times during a single game)
* If the plane’s damage is too high, and it is flying over water, player can perform a water landing
* Make graphics 3-dimensional (player can see the plane from the top view and maneuver it left and right, as well as up and down)
* A store where players can buy upgrades for improving the functionality of the plane
 
Class List:
* (DONE) WaterSpray: represents a single spray of water, which the plane can shoot at the fires
* (DONE) Airplane: represents an airplane, which has an x,y coordinate, a velocity in the horizontal direction, a downward gravitational acceleration, and many WaterSpray objects
* (DONE) Fire: represents an animated forest fire, that the plane has to extinguish with its WaterSprays
* (NOT DONE) Weather (abstract class): represents a weather phenomenon and stores the strength and duration of the phenomenon
* (NOT DONE) Wind, Lightning, Rain: extends Weather and represents different kinds of weather phenomena with differing impacts (lightning causes damage while wind causes turbulence)
* (DONE) Background: represents the scenery behind the plane as Images (depending on the complexity could also be a moving background)
* (DONE) Image: represents an Image with an x,y coordinate
* (DONE) FlightSimulation: represents the simulation of the flight (2d view), containing the Airplane, Fire, Weather, and Background objects
* (NOT DONE) LocationTracker: represents a real-time tracker, which contains a geographic map of the plane’s route from source to destination and keeps track of where the plane is at
* (DONE) Dial: represents a circular dial, which has incrementally spaced values and a hand pointing to the current measurement (for speed, altitude, etc..)
* (DONE) Cockpit: represents a pilot’s cockpit, which has Dial objects and a LocationTracker object
* (DONE) InstructionsPanel: extends JPanel and represents the drawing surface where the initial instructions are provided, where user can select source and destination airports, and where user can start the game
* (DONE) PilotPanel: extends PApplet, represents the pilot’s view of the flight and cockpit, contains a FlightSimulation and a Cockpit object
* (DONE) Main: contains the main method and creates a JFrame with InstructionsPanel and PilotPanel


Credit List:
* Shreya: Dial, Cockpit, Background, PilotPanel
* Ashwini: WaterSpray, Plane, Fire, Weather classes, LocationTracker, FlightSimulation
* Rujuta: PilotPanel, InstructionsPanel, Main, creating images/gifs for the plane and fires
* Airplane image: http://clipart-library.com/airplane-cliparts.html
* Background scenery image: Clear Day Clipart (clipartimage.com)
* Fire/smoke gifs: animatedimages.org
Vidya-Vahini 🚍
Smart Student Bus Tracking System

Vidya-Vahini is an Android-based student transport tracking application developed to help students in rural and semi-urban areas monitor bus movement and receive real-time transport updates. The application uses a crowdsourced “Bus Ping” system where students can update the current location of the bus by selecting the latest stop crossed.

The project is designed to reduce uncertainty in daily travel, improve student safety, minimize waiting time at isolated bus stops, and help students manage their commute efficiently.
Problem Statement

Students in rural and semi-urban areas often depend on a single college bus or public transport route to reach their educational institutions. Delays, unexpected breakdowns, and lack of real-time transport information force students to wait for long hours at isolated bus stops, causing them to miss classes and exams.

Vidya-Vahini provides a lightweight and affordable solution that enables students to receive real-time bus updates, ETA information, breakdown alerts, and safety notifications.

Tech Stack
Category	        Technology Used
Platform	      - Android
Language	      - Kotlin
IDE	            - Android Studio
Database	      - Firebase Realtime Database
Authentication  - Firebase Authentication
UI Design	      - XML Layouts
Version Control	- Git & GitHub

Modules Implemented
1. Splash Screen
Displays the application logo and initializes the app.

2. Login & Signup
Implemented using Firebase Authentication with password recovery support.

3. Route Selection
Users can select source and destination stops to identify available routes.

4. Live Bus Status
Displays current stop, updated time, ETA, and bus breakdown alerts.

6. Bus Ping System
Students can update the latest bus location using a single tap.

6. Route Details
Displays route flow, driver details, and bus number.

7. Safe Reach Feature
Allows students to notify parents through email after safely reaching the destination.

8. Profile Section
Stores student details such as name, USN, phone number, parent phone number, and parent email.

Features
1. Real-Time Bus Status Tracking
The application provides live bus status updates using Firebase Realtime Database. Students can instantly view the current stop, last updated time, and overall route status without refreshing the application manually.

2. Crowdsourced Bus Ping System
Instead of relying completely on GPS tracking, students traveling on the route can update the latest bus location by selecting the current stop crossed by the bus. This collaborative system ensures that all users receive real-time updates from fellow students.

3. Dynamic ETA Calculation
The system calculates the Estimated Time of Arrival (ETA) dynamically based on the selected source stop, destination stop, and latest bus location update. Different routes and stops display different ETA values for better travel planning.

4. Route Selection and Route Details
Users can select their travel route using source and destination stops. The application displays route information including route flow, list of stops, bus number, and driver details.

5. Route Line Visualization
A vertical route line is displayed on the status page to visually represent the complete route and highlight the bus’s latest known position. This helps students understand how far the bus has traveled.

6. Bus Breakdown Reporting
Students can report bus breakdowns directly through the application. Once a breakdown is reported, all users on the same route receive an alert message along with the last known bus stop and update time.

7. Safe Reach Notification
The application includes a Safe Reach feature that allows students to notify parents through email once they safely reach their destination. Parent email details are stored in the user profile section.

8. User Authentication System
Firebase Authentication is used to implement secure login, signup, and password recovery functionalities. This ensures that only registered users can access the application.

9. User Profile Management
Students can store and manage personal details such as name, USN, phone number, parent phone number, and parent email through the profile section.

10. Lightweight and User-Friendly Interface
The application is designed with a clean and minimal interface suitable for low-end Android devices and areas with limited internet connectivity. The UI focuses on simplicity and ease of use for students.

Conclusion
Vidya-Vahini is a practical and user-friendly transport tracking application developed to solve real-world commuting problems faced by students in rural and semi-urban areas. The project successfully demonstrates Android application development, Firebase integration, real-time synchronization, ETA calculation, and collaborative transport tracking.
The project provided valuable hands-on experience in mobile application development, UI design, database integration, debugging, and real-time data handling while also focusing on creating a socially impactful solution for student safety and transportation management.

APK Download
https://drive.google.com/file/d/1Zklb_TkhAOJ_x5OJcrR763229rrnlj-s/view?usp=drive_link


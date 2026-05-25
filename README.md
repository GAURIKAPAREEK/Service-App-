# Service Pro India 🔧

A mobile service booking app for hiring trusted home professionals in India — built for Android.



## 📱 App Overview

**Service Pro India** lets users book home repair services like Plumber, Electrician, and more with options for normal or express delivery, add-on insurance, spare parts, and direct helpline contact — all from a clean, simple interface.



## 📸 App Screens

### 1. Login Screen
- App name: **Service Pro India** with a wrench icon
- Fields: **Username** and **Password** (min 8 characters, must include A, 1, @)
- **LOGIN** button to enter the app

### 2. Booking Details Screen
- **Service Dropdown** — Select service with base price shown (e.g. Plumber ₹1000)
- **Click Photo** button — Upload a photo of the problem
- **Pin Location** button (orange) — Set your location for the professional
- Location status shown below: *"Location: Not Set"*
- **Urgency Selection (Radio Buttons):**
  - `Normal` — Standard booking, no extra charge
  - `Express (+₹500)` — Fast service with ₹500 surcharge
- **GO TO BILLING** button — Proceed to payment summary

### 3. Final Amount Screen (Pay Now)
- **Add-on Checkboxes:**
  - `Insurance (+₹100)` — Optional coverage
  - `Spare Parts (~₹450)` — Pre-checked by default
- **Total amount displayed** prominently (e.g. ₹1000)
- **PAY NOW** button (pink/red) — Confirm and pay

### 4. Final Amount Screen (Helpline)
- Same add-on checkboxes as above
- **Total amount** updates based on selected add-ons (e.g. ₹1400 with spare parts)
- **CONTACT HELPLINE** button (green) — Call support directly

### 5. Helpline Call Screen
- Tapping "Contact Helpline" opens the **native Android dialer**
- Pre-filled helpline number: **+91 99999 99999**
- Options shown: Create new contact, Add to a contact, Send a message
- **Call** button to connect immediately

## 🚀 Installation (APK)

1. Download `ServiceProIndia.apk` from this repository
2. On your Android phone, go to **Settings → Security → Install Unknown Apps**
3. Allow installation from your file manager or browser
4. Open the APK file and tap **Install**
5. Launch **Service Pro India** from your app drawer

### Requirements

- Android 6.0 (Marshmallow) or higher
- Minimum 50 MB free storage
- Internet connection for booking and location features
- Camera permission for photo upload
- Location permission for Pin Location feature
- Phone permission for Contact Helpline feature

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| UI | Android XML Layouts |
| Minimum SDK | Android 6.0 (API 23) |
| Target SDK | Android 14 (API 34) |
| Build Tool | Gradle |



## 🔒 Permissions Required

| Permission | Purpose |
|---|---|
| `INTERNET` | Booking & data sync |
| `CAMERA` | Click photo of problem |
| `ACCESS_FINE_LOCATION` | Pin location for professional |
| `CALL_PHONE` | Contact helpline directly |



## 🤝 Contributing

1. Fork this repository
2. Create a branch: `git checkout -b feature/your-feature`
3. Commit changes: `git commit -m "Add your message"`
4. Push: `git push origin feature/your-feature`
5. Open a Pull Request


# 🥪 Divine Deli: Mood-Based Sandwich Generator

Welcome to **The Divine Deli**, where your feelings determine your flavor. This Java-based CLI app recommends or builds a sandwich based on your current mood.
 🥬✨ **Mood-Fueled. Ingredient Approved.**  
 We don’t do mystery meat or processed nonsense over here.  
 Every bite is **organic**, **grass-fed**, and **unapologetically clean**.  
 No fake flavors. No shady stuff. Just real food for real moods—  
 because healing tastes better when it's fresh.

---

## 🚀 Getting Started


### Prerequisites
- Java 17+
- IDE like IntelliJ or VS Code

### Running the App
```bash
javac Main.java
java Main
```

---


## 🥪 Divine Deli Features

✨ **Vibe-to-Bite Technology**  
Type your mood, get a sandwich. It’s basically emotional telepathy with extra cheese.

🧠 **Build-A-Bite Mode**  
Feelin’ like a sandwich scientist? Craft your own from scratch—vibes included.

🛒 **Combo Magic**  
Each meal comes with a mood-matching chip + drink. Curated by the sandwich gods.

💸 **Price That Makes Sense**  
No surprises. Just angelic numbers, like $8.88. Always feels aligned.

🧾 **Receipts That Slap**  
Your receipt has jokes, love, and all your flavor stats. Frame it if you want.

📜 **Menu That Reads You**  
Scroll through sandwiches made for heartbreak, joy, rage, or just being extra.

🌱 **Clean AF Ingredients**
(AF means AND FRESH!)
Everything is grass-fed, organic, and blessed by your ancestors. No processed energy allowed.


---

## 🧠 Interesting Code: slowPrint()
![ScreenRecording2025-05-30021232-ezgif com-optimize](https://github.com/user-attachments/assets/0d12ea67-8511-43d6-9a9e-2c6f0f305812)

---
```java
// Main.java — Used throughout the app for a slow, immersive text experience
public static void slowPrint(String message, int delay) {
    for (char c : message.toCharArray()) {
        System.out.print(c);
        try {
            Thread.sleep(delay); // Delay in milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    System.out.println(); // move to next line after printing
}

---

## 📈 Agile Scrum User Stories

- [ ] As a user, I want to get a sandwich based on my current mood.
- [ ] As a user, I want to customize my own sandwich from scratch.
- [ ] As a user, I want to see a full menu of mood-matching sandwiches.
- [ ] As a user, I want to get a printed receipt after I order.

---

## 🔨 In Progress

| Task                        | Status     |
|-----------------------------|------------|
| CLI sandwich selector       | ✅ Done     |
| Custom sandwich builder     | ✅ Done     |
| UML diagram                 | ✅ Done  |
| Screenshots & demo gif      | ✅ Done   |
| README polish with links    | ⏳ Ongoing  |


---




## 🎨 Screenshots & Diagrams


![ScreenRecording2025-05-30023643-ezgif com-optimize](https://github.com/user-attachments/assets/82706f62-9e39-4e84-9314-f5301c502675)

---


## 🧠 Divine Deli SDLC Flow  
*“From Mood to Mouthful: How the Deli Gets It Done”*  
This diagram shows how we turned pure feelings into sandwich magic using the Software Development Life Cycle.

  ![ChatGPT Image May 30, 2025, 03_24_53 AM](https://github.com/user-attachments/assets/3b91bd1d-8d70-41ee-b555-b535bd54abee)


---

## About the Developer
Faith Spikes – Aspiring software developer, mood-based experience creator, and certified sandwich philosopher.
🎓 Java + OOP student | 🌐 Future web/VR developer | 🎯 Building tech that heals.
[LinkedIn](https://linkedin.com/in/yourprofile) | [GitHub](https://github.com/Fspike1)

---

## 📜 License

This project is licensed under Chef Faith Spikes - see the [LICENSE](LICENSE) file for details.

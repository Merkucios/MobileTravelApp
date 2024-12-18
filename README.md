
# Mobile Travel App 📱✈️


![Logo](https://img.freepik.com/free-photo/3d-cartoon-airplane-sky_23-2151671574.jpg?semt=ais_hybrid)

![Android](https://img.shields.io/badge/android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Retrofit](https://img.shields.io/badge/Retrofit-2E7D32?style=for-the-badge&logo=retrofit&logoColor=white)
![OkHttp](https://img.shields.io/badge/OkHttp-FF3D00?style=for-the-badge&logo=okhttp&logoColor=white)

[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-green.svg)](https://opensource.org/licenses/)
![Downloads](https://img.shields.io/github/downloads/Merkucios/MobileTravelApp/total.svg)
![Rating](https://img.shields.io/badge/rating-4.5%2F5-brightgreen.svg)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5bf1457af8f94e6f960c810cbac2ff06)](https://app.codacy.com/gh/Merkucios/MobileTravelApp/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)

## Color Reference 🎨

| Color             | Hex                                                                |
| ----------------- | ------------------------------------------------------------------ |
| Blue | ![#3F95EC](https://via.placeholder.com/10/3F95EC?text=+) #3F95EC |
| Dark Blue | ![#253f66](https://via.placeholder.com/10/253f66?text=+) #253F66 |
| Light Grey | ![#efefef](https://via.placeholder.com/10/efefef?text=+) #efefef |


## Tech Stack ⚙️

### Client
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white) ![Gradle](https://img.shields.io/badge/Gradle-0a3640?style=for-the-badge&logo=gradle&logoColor=white)

**Client:** Java ☕, Gradle ⚙️

### Server
![Supabase](https://img.shields.io/badge/Supabase-3ECF8E?style=for-the-badge&logo=supabase&logoColor=white)

**Server:** Supabase 📂
## Environment Variables

To run this project, you will need to add the following variables to SupabaseClient class
`API_KEY`
`ANOTHER_API_KEY` 🧑🏻‍💻


## Create Database in Supabase 📁

```SQL
CREATE TABLE Banner (
    id SERIAL PRIMARY KEY,
    url TEXT NOT NULL
);

CREATE TABLE Category (
    id INT PRIMARY KEY,
    ImagePath TEXT NOT NULL,
    Name TEXT NOT NULL
);

CREATE TABLE Item (
    id SERIAL PRIMARY KEY,
    address TEXT NOT NULL,
    bed INT,
    dateTour DATE,
    description TEXT,
    distance TEXT,
    duration TEXT,
    pic TEXT,
    price FLOAT,
    score FLOAT,
    timeTour TIME,
    title TEXT,
    tourGuideName TEXT,
    tourGuidePhone TEXT,
    tourGuidePic TEXT
);

CREATE TABLE Location (
    id INT PRIMARY KEY,
    loc TEXT NOT NULL
);

CREATE TABLE Popular (
    id SERIAL PRIMARY KEY,
    address TEXT NOT NULL,
    bed INT,
    dateTour DATE,
    description TEXT,
    distance TEXT,
    duration TEXT,
    pic TEXT,
    price FLOAT,
    score FLOAT,
    timeTour TIME,
    title TEXT,
    tourGuideName TEXT,
    tourGuidePhone TEXT,
    tourGuidePic TEXT
);


```

## API Supabase 🅰️
API Supabase 🅰️
If you're looking to explore the endpoints, you can check out the swagger.json file for detailed API documentation. [Link](https://github.com/Merkucios/MobileTravelApp/blob/main/swagger.json)

## Let's create! ⭐

If you enjoy using this project and find it helpful, please consider giving it a star on GitHub! Your support means the world to me and helps continue improving and adding new features. Thank you for being a part of our programming community! 🌟

## MaterialCompat

Sample Android Application using MaterialCompat library to produce the Material effects on
per-lollipop devices

## Setup
MaterialCompat uses the following libraries to achieve the Material Theme
```bash
    compile 'com.android.support:appcompat-v7:22.2.0'
    compile 'com.android.support:design:22.2.0'
    compile 'com.android.support:cardview-v7:22.2.0'
    compile 'com.android.support:recyclerview-v7:22.2.0'
```

## Usage (local only)
1. Clone this repository into Dev system
```bash
  git clone https://github.com/hareeshbabu82ns/MaterialCompat.git
```

2. Link the **MaterialCompatTheme** Library project into other Android Studio Projects by including
 the following lines in **build.gradle** file (linking any Module using gradle to avoid copying)
```bash
  include ':app', ':materialcompattheme'
  project(':materialcompattheme').projectDir=new File('../MaterialCompat/materialcompattheme')
```

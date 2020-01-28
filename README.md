# Android Web App Launcher

This is only a test project but can use for simple applications. The idea is, build a web page like a web application. But instead display the page in the browser, convert it into a app.
Remember that the user has no back- or forward-button within that application and can´t mark certain pages as favorit like in the normal browser. The web application should develop 
with this in mind. Each page have to test if the user can reach all other pages. If you have links to other pages outside of your domain, the user has no chance to go back to our own web app.

## How it works

The app contain only a webView which use the complete screen and open a URL within. Each click on the page will 
redirect to the webView and it won´t switch to the normal browser on the mobile device. Also the title bar will hide during 
startup so the complete page can use to display your web app.

For example you can use jQuery mobile to develop a web app. ( [https://demos.jquerymobile.com]() ) But there many other frameworks you can use to create your application.

## Environment

**Project build with "androidStudio"**

![](image1.jpg)


## Preview

![](image2.png)

![](image3.png)

## Changes you have to do

    1. Change colors of your application (app\src\main\res\values.xml)
    
    2. Change name / url of your application (app\src\main\res\string.xml)
    
    3. Change logo of your applicaation (app\src\main\res\drawable-v24\ic_launcher_foreground.xml)
    
    4. Change package path (app/src/main/AndroidManifest.xml)
        HowTo: https://stackoverflow.com/questions/16804093/rename-package-in-android-studio
        
    
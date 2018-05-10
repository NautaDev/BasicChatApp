# Basic Chat App
Basic Chat App created using Android Studio 3.0.1 and Parser (back4app)

This is a basic chat app I created for two reasons:
1. Just practice and learn more about Android and Parser
2. To create a tutorial about it in my website and YouTube channels

It uses Parser for the online features (basically, the chat). Since parse.com is not available anymore, I have found another site that allows you to use Parser systems for free, it is called back4app. So, this is what I will use in this app.

# Changelog
This will be a really simple changelog, just to see what I have done and what I am going to do:

* 2018/05/10 - Added a function to load the last 50 messages sent. Also it sorts them from older to newer without doing a linear sort.
* 2018/05/10 - Added a custom adapter for the chat recycler view and also updated the ChatActivity to support the RecyclerView.
* 2018/05/10 - Added glide dependency and updated logging-interceptor dependency to the last available version (3.10.0).
* 2018/05/10 - Added a Message subclass to make our life easier and use it on the Recycler View. Also implemented some changes in the send message button to use this new class. And of course, created a new layout, the item_chat layout, later it will be used to display the messages.
* 2018/05/10 - Added dependency to use RecyclerView.
* 2018/05/10 - Coded basic UI (send button now works) and it saves the message on the server.
* 2018/05/10 - Changed again the activity, finally added a basic UI to send messages.
* 2018/05/10 - Changed the structure a bit, mostly adding an Application class to initialize Parse.
* 2018/05/10 - Replaced old MainActivity with a new one. For now this will be a simple design, after app is fully functional, I will implement a better UI.
* 2018/05/10 - Added Parse SDK (from back4apps site) and configured it.
* 2018/05/10 - Initial commit, it is just a fresh new Android Studio project, without nothing special.

# Sources
To learn how to do this app using Parser I have used several websites and documents so... to give credit to their authors and also to help anyone interested to learn about it, I will talk about them here:

* Building Simple Chat Client with Parse: This guide done by Roger Hu was my starting point, mostly all my original code is from that guide, I just tried to comment it a little bit more and maybe change few things. You can read the guide here: https://github.com/codepath/android_guides/wiki/Building-Simple-Chat-Client-with-Parse

* Gravatar: In the Roger Hu is used so I came here to learn a bit more about how we can use it in our projects: https://en.gravatar.com/site/implement/images/

* Back4app: Since Parse.com is not available and I didn't want to host a Parse server in my computer, I found this awesome site who offers a free Parse server, really easy to use and with good documentation: https://www.back4app.com/ Also, I had to use its documentation a little to be able to edit the Roger Hu guide to support the Back4app Parse SDK.

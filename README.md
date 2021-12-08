# Screen Pinner

Screen Pinner allows you to utilise the Screen Pinning API for Android in Cordova projects.

## Getting Started

Run the following command inside your Cordova Ionic project
```sh
ionic cordova plugin add cordova-plugin-screen-pinner
```
or if you're not using Ionic, then please run;
```sh
cordova plugin add cordova-plugin-screen-pinner
```

## Integrating into Ionic Cordova Project;

To add into your Ionic cordova application, first install the plugin as advised above.

Once done, you will want to define the cordova variable within your respective page;

```javascript
declare var cordova: any;
```

An example of this can be seen below;

```javascript
import { Component } from '@angular/core';
import { AlertController } from '../../../node_modules/@ionic/angular';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { InAppBrowser, InAppBrowserObject } from '@ionic-native/in-app-browser/ngx';

declare var cordova:any;

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage {

  public CustomerCode: string = "";
  public ButtonText: string = "Validate";
  public browser: InAppBrowserObject;
```

## Methods

The following methods are available to call;

### Start Screen Pinning

To start screen pinning, simply call the following;

```javascript
cordova.plugins.screenPinner.start(() => { 
    alert('Screen pinning started'); 
}, (error) => { 
    alert('There was an error'); 
    console.log(error);
});
```

You will want to set the first function parameter to be the success call, which will be called in the event of the screen pinning being activated.

The second function parameter has an error message returned to it and allows you to see if there are any errors with calling the screen pinning API.

### Stop Screen Pinning

To stop screen pinning, simply call the following;

```javascript
cordova.plugins.screenPinner.stop(() => { 
    alert('Screen pinning stopped'); 
}, (error) => { 
    alert('There was an error'); 
    console.log(error);
});
```

You will want to set the first function parameter to be the success call, which will be called in the event of the screen pinning being stopped.

The second function parameter has an error message returned to it and allows you to see if there are any errors with calling the screen pinning API.

### Is Screen Pinning Active

To see if screen pinning is currently active, you can call the following;

```javascript
cordova.plugins.screenPinner.isPinned(() => { 
    alert('Screen pinning active'); 
}, () => { 
    alert('Screen pinning not active'); 
}, (error) => { 
    alert('There was an error'); 
    console.log(error);
});
```

You will want to set the first function parameter to be the success call, which will tell you that the screen pinning is currently active.

The second function paramter is if the screen pinning is not currently active.

The third function parameter has an error message returned to it and allows you to see if there are any errors with calling the screen pinning API.
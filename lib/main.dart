// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HelloServices extends StatefulWidget {
  @override
  _HelloServicesState createState() => new _HelloServicesState();
}

class _HelloServicesState extends State<HelloServices> {
  String _result = "";

  @override
  Widget build(BuildContext context) {
    return new Material(
        child: new Center(
            child: new Column(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  new Text('Hello from Flutter!'),
                  new RaisedButton(
                      child: new Text('Create Notification'),
                      onPressed: _createNotification
                  ),
                  new Text(_result)
                ]
            )
        )
    );
  }

  Future<Null> _createNotification() async {
    String reply = "";
    reply = await PlatformMessages.sendString(
        'createNotification', "You have a new notification.");
    // If the widget was removed from the tree while the message was in flight,
    // we want to discard the reply rather than calling setState to update our
    // non-existent appearance.
    if (!mounted)
      return;
    setState(() {
      _result = reply;
    });
  }
}

void main() {
  runApp(new HelloServices());
}

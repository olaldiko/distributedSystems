// **********************************************************************
//
// Copyright (c) 2003-2015 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.1
//
// <auto-generated>
//
// Generated from file `chatServer.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package chat;

public interface _Callback_ChatServer_getMessage extends Ice.TwowayCallback
{
    public void response(boolean __ret, String message);
}

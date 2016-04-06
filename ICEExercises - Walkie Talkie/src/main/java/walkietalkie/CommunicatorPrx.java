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
// Generated from file `walkietalkie.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package walkietalkie;

public interface CommunicatorPrx extends Ice.ObjectPrx
{
    public void sendMessage(String inMsg);

    public void sendMessage(String inMsg, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendMessage(String inMsg);

    public Ice.AsyncResult begin_sendMessage(String inMsg, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sendMessage(String inMsg, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendMessage(String inMsg, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_sendMessage(String inMsg, Callback_Communicator_sendMessage __cb);

    public Ice.AsyncResult begin_sendMessage(String inMsg, java.util.Map<String, String> __ctx, Callback_Communicator_sendMessage __cb);

    public Ice.AsyncResult begin_sendMessage(String inMsg, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_sendMessage(String inMsg, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_sendMessage(String inMsg, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_sendMessage(String inMsg, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public void end_sendMessage(Ice.AsyncResult __result);
}

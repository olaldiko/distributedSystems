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

public final class ListenerPrxHelper extends Ice.ObjectPrxHelperBase implements ListenerPrx
{
    private static final String __messageNotification_name = "messageNotification";

    public boolean messageNotification(int msgNumber)
    {
        return messageNotification(msgNumber, null, false);
    }

    public boolean messageNotification(int msgNumber, java.util.Map<String, String> __ctx)
    {
        return messageNotification(msgNumber, __ctx, true);
    }

    private boolean messageNotification(int msgNumber, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__messageNotification_name);
        return end_messageNotification(begin_messageNotification(msgNumber, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber)
    {
        return begin_messageNotification(msgNumber, null, false, false, null);
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber, java.util.Map<String, String> __ctx)
    {
        return begin_messageNotification(msgNumber, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber, Ice.Callback __cb)
    {
        return begin_messageNotification(msgNumber, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_messageNotification(msgNumber, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber, Callback_Listener_messageNotification __cb)
    {
        return begin_messageNotification(msgNumber, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber, java.util.Map<String, String> __ctx, Callback_Listener_messageNotification __cb)
    {
        return begin_messageNotification(msgNumber, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber, 
                                                     IceInternal.Functional_BoolCallback __responseCb, 
                                                     IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_messageNotification(msgNumber, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber, 
                                                     IceInternal.Functional_BoolCallback __responseCb, 
                                                     IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                     IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_messageNotification(msgNumber, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber, 
                                                     java.util.Map<String, String> __ctx, 
                                                     IceInternal.Functional_BoolCallback __responseCb, 
                                                     IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_messageNotification(msgNumber, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_messageNotification(int msgNumber, 
                                                     java.util.Map<String, String> __ctx, 
                                                     IceInternal.Functional_BoolCallback __responseCb, 
                                                     IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                     IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_messageNotification(msgNumber, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_messageNotification(int msgNumber, 
                                                      java.util.Map<String, String> __ctx, 
                                                      boolean __explicitCtx, 
                                                      boolean __synchronous, 
                                                      IceInternal.Functional_BoolCallback __responseCb, 
                                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                      IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_messageNotification(msgNumber, __ctx, __explicitCtx, __synchronous, 
                                         new IceInternal.Functional_TwowayCallbackBool(__responseCb, __exceptionCb, __sentCb)
                                             {
                                                 public final void __completed(Ice.AsyncResult __result)
                                                 {
                                                     ListenerPrxHelper.__messageNotification_completed(this, __result);
                                                 }
                                             });
    }

    private Ice.AsyncResult begin_messageNotification(int msgNumber, 
                                                      java.util.Map<String, String> __ctx, 
                                                      boolean __explicitCtx, 
                                                      boolean __synchronous, 
                                                      IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__messageNotification_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__messageNotification_name, __cb);
        try
        {
            __result.prepare(__messageNotification_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeInt(msgNumber);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public boolean end_messageNotification(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __messageNotification_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            boolean __ret;
            __ret = __is.readBool();
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __messageNotification_completed(Ice.TwowayCallbackBool __cb, Ice.AsyncResult __result)
    {
        chat.ListenerPrx __proxy = (chat.ListenerPrx)__result.getProxy();
        boolean __ret = false;
        try
        {
            __ret = __proxy.end_messageNotification(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    public static ListenerPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), ListenerPrx.class, ListenerPrxHelper.class);
    }

    public static ListenerPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), ListenerPrx.class, ListenerPrxHelper.class);
    }

    public static ListenerPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), ListenerPrx.class, ListenerPrxHelper.class);
    }

    public static ListenerPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), ListenerPrx.class, ListenerPrxHelper.class);
    }

    public static ListenerPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, ListenerPrx.class, ListenerPrxHelper.class);
    }

    public static ListenerPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, ListenerPrx.class, ListenerPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::chat::Listener"
    };

    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, ListenerPrx v)
    {
        __os.writeProxy(v);
    }

    public static ListenerPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ListenerPrxHelper result = new ListenerPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
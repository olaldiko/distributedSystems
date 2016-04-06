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

public abstract class _ChatServerDisp extends Ice.ObjectImpl implements ChatServer
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::chat::ChatServer"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[1];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String ice_staticId()
    {
        return __ids[1];
    }

    public final boolean deleteListener(ListenerPrx listenerInstance)
    {
        return deleteListener(listenerInstance, null);
    }

    public final boolean getMessage(int msgNumber, Ice.StringHolder message)
    {
        return getMessage(msgNumber, message, null);
    }

    public final void pushMessage(String message, ListenerPrx associatedListener)
    {
        pushMessage(message, associatedListener, null);
    }

    public final boolean registerListener(ListenerPrx listenerInstance)
    {
        return registerListener(listenerInstance, null);
    }

    public static Ice.DispatchStatus ___registerListener(ChatServer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        ListenerPrx listenerInstance;
        listenerInstance = ListenerPrxHelper.__read(__is);
        __inS.endReadParams();
        boolean __ret = __obj.registerListener(listenerInstance, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeBool(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___deleteListener(ChatServer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        ListenerPrx listenerInstance;
        listenerInstance = ListenerPrxHelper.__read(__is);
        __inS.endReadParams();
        boolean __ret = __obj.deleteListener(listenerInstance, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeBool(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___pushMessage(ChatServer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String message;
        ListenerPrx associatedListener;
        message = __is.readString();
        associatedListener = ListenerPrxHelper.__read(__is);
        __inS.endReadParams();
        __obj.pushMessage(message, associatedListener, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___getMessage(ChatServer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        int msgNumber;
        msgNumber = __is.readInt();
        __inS.endReadParams();
        Ice.StringHolder message = new Ice.StringHolder();
        boolean __ret = __obj.getMessage(msgNumber, message, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeString(message.value);
        __os.writeBool(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "deleteListener",
        "getMessage",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "pushMessage",
        "registerListener"
    };

    public Ice.DispatchStatus __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___deleteListener(this, in, __current);
            }
            case 1:
            {
                return ___getMessage(this, in, __current);
            }
            case 2:
            {
                return ___ice_id(this, in, __current);
            }
            case 3:
            {
                return ___ice_ids(this, in, __current);
            }
            case 4:
            {
                return ___ice_isA(this, in, __current);
            }
            case 5:
            {
                return ___ice_ping(this, in, __current);
            }
            case 6:
            {
                return ___pushMessage(this, in, __current);
            }
            case 7:
            {
                return ___registerListener(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = 0L;
}

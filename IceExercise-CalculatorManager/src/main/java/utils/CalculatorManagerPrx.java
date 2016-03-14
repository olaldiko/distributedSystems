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
// Generated from file `calculatorICE.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package utils;

public interface CalculatorManagerPrx extends Ice.ObjectPrx
{
    public CalculatorPrx getCalculatorInstance();

    public CalculatorPrx getCalculatorInstance(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getCalculatorInstance();

    public Ice.AsyncResult begin_getCalculatorInstance(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getCalculatorInstance(Ice.Callback __cb);

    public Ice.AsyncResult begin_getCalculatorInstance(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getCalculatorInstance(Callback_CalculatorManager_getCalculatorInstance __cb);

    public Ice.AsyncResult begin_getCalculatorInstance(java.util.Map<String, String> __ctx, Callback_CalculatorManager_getCalculatorInstance __cb);

    public Ice.AsyncResult begin_getCalculatorInstance(IceInternal.Functional_GenericCallback1<CalculatorPrx> __responseCb, 
                                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getCalculatorInstance(IceInternal.Functional_GenericCallback1<CalculatorPrx> __responseCb, 
                                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                       IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_getCalculatorInstance(java.util.Map<String, String> __ctx, 
                                                       IceInternal.Functional_GenericCallback1<CalculatorPrx> __responseCb, 
                                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getCalculatorInstance(java.util.Map<String, String> __ctx, 
                                                       IceInternal.Functional_GenericCallback1<CalculatorPrx> __responseCb, 
                                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                       IceInternal.Functional_BoolCallback __sentCb);

    public CalculatorPrx end_getCalculatorInstance(Ice.AsyncResult __result);
}

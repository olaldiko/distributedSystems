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
// Generated from file `calculus.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package utils;

public abstract class Callback_Calculator_factorial
    extends IceInternal.TwowayCallback implements Ice.TwowayCallbackInt
{
    public final void __completed(Ice.AsyncResult __result)
    {
        CalculatorPrxHelper.__factorial_completed(this, __result);
    }
}
